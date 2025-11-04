//Durgasri S
//2117240070081
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DashboardCharts extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Dashboard - Line, Bar, and Pie Charts");

        // -------- LINE CHART --------
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Sales Trend (Line Chart)");

        XYChart.Series<String, Number> lineSeries = new XYChart.Series<>();
        lineSeries.setName("2025");
        lineSeries.getData().add(new XYChart.Data<>("Jan", 100));
        lineSeries.getData().add(new XYChart.Data<>("Feb", 150));
        lineSeries.getData().add(new XYChart.Data<>("Mar", 130));
        lineSeries.getData().add(new XYChart.Data<>("Apr", 180));

        lineChart.getData().add(lineSeries);

        // -------- BAR CHART --------
        CategoryAxis barX = new CategoryAxis();
        NumberAxis barY = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(barX, barY);
        barChart.setTitle("Product Comparison (Bar Chart)");

        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        barSeries.setName("Units Sold");
        barSeries.getData().add(new XYChart.Data<>("Laptop", 120));
        barSeries.getData().add(new XYChart.Data<>("Tablet", 90));
        barSeries.getData().add(new XYChart.Data<>("Phone", 160));

        barChart.getData().add(barSeries);

        // -------- PIE CHART --------
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.Data("Laptop", 40),
            new PieChart.Data("Tablet", 30),
            new PieChart.Data("Phone", 30)
        );

        PieChart pieChart = new PieChart(pieData);
        pieChart.setTitle("Market Share (Pie Chart)");

        // -------- DASHBOARD LAYOUT --------
        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.add(lineChart, 0, 0);
        root.add(barChart, 1, 0);
        root.add(pieChart, 0, 1, 2, 1);

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
