//Durgasri S
//2117240070081
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
            System.out.println(" Connected to server at " + host + ":" + port);
            return true;
        } catch (IOException e) {
            System.out.println("Could not connect to server: " + e.getMessage());
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
            System.out.println(" Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
