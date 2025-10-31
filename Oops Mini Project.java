//Durgasri S
//2117240070081
//Online Voting System
Program:
DbManager.java -SQL code
package server;
import java.sql.*;

public class DBManager {
    static {
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/voting_system_db"
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        return DriverManager.getConnection(url, "root", "Ds@23");
    }

    // quick test main:
    public static void main(String[] args) {
        try (Connection c = getConnection()) {
            System.out.println("✅ DB connection OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
ServerMain.java:
package server;

import java.io.*;
import java.net.*;
import java.sql.*;

public class ServerMain {

    public static void main(String[] args) {
        int port = 5000;
        System.out.println("Server starting...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("✅ Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("👤 Client connected: " + clientSocket.getInetAddress());

                // Handle each client in a new thread
                new Thread(() -> handleClient(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("📩 Received: " + request);

                String response;

                if (request.startsWith("REGISTER")) {
                    response = handleRegister(request);
                } else if (request.startsWith("LOGIN")) {
                    response = handleLogin(request);
                } else {
                    response = "Invalid command!";
                }

                out.println(response);
            }

        } catch (IOException e) {
            System.out.println("❌ Client disconnected.");
        }
    }

    // ✅ Registration handler
    private static String handleRegister(String request) {
        try {
            // Split by colon :
            String[] parts = request.split(":");
            if (parts.length != 4) {
                return "Invalid command format!";
            }

            String name = parts[1];
            String username = parts[2];
            String password = parts[3];

            // ✅ Change password here to your real MySQL password
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/voting_system_db",
                    "root",
                    "Ds@23"
            );

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO voters (name, username, password) VALUES (?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);

            ps.executeUpdate();
            ps.close();
            conn.close();

            return "success: Registration successful!";

        } catch (SQLIntegrityConstraintViolationException e) {
            return "Username already exists!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }

    // ✅ Login handler
    private static String handleLogin(String request) {
        try {
            String[] parts = request.split(":");
            if (parts.length != 3) {
                return "Invalid command format!";
            }

            String username = parts[1];
            String password = parts[2];

            // ✅ Change password here to your real MySQL password
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/voting_system_db",
                    "root",
                    "Ds@23"
            );

            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM voters WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            boolean valid = rs.next();

            rs.close();
            ps.close();
            conn.close();

            if (valid) {
                return "success: Login successful!";
            } else {
                return "Invalid username or password!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }
}
ClientMain.java:
package client;

import java.io.*;
import java.net.*;

public class ClientMain {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    // Connect to server
    public boolean connectToServer(String host, int port) {
        try {
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("🟢 Connected to server at " + host + ":" + port);
            return true;
        } catch (IOException e) {
            System.out.println("❌ Could not connect to server: " + e.getMessage());
            return false;
        }
    }

    // Send a request to the server
    public String sendRequest(String request) {
        try {
            out.println(request); // send message to server
            return in.readLine(); // read reply from server
        } catch (IOException e) {
            e.printStackTrace();
            return "Error communicating with server!";
        }
    }

    // Close connection
    public void closeConnection() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
            System.out.println("🔴 Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
