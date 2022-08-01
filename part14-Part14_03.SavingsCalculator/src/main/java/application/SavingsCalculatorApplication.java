package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // Main layout
        BorderPane mainLayout = new BorderPane();

        // line chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false);

        mainLayout.setCenter(lineChart);

        // top
        VBox sliders = new VBox();
        sliders.setSpacing(10);
        sliders.setPadding(new Insets(10, 10, 10, 10));
        //vbox - first border pane
        BorderPane first = new BorderPane();
        first.setPadding(new Insets(10, 10, 10, 10));

        //first border pane parts
        Label textFirst = new Label("Monthly savings");
        first.setLeft(textFirst);

        Slider sliderFirst = new Slider(25, 250, 25);
        sliderFirst.setShowTickMarks(true);
        sliderFirst.setShowTickLabels(true);

        first.setCenter(sliderFirst);

        Label descriptionFirst = new Label();

        first.setRight(descriptionFirst);
        sliderFirst.valueProperty().addListener(
                (obs, old, newval) -> {

                    int i = newval.intValue();
                    descriptionFirst.setText(Integer.toString(i));

                    lineChart.getData().clear();

                    Map<Integer, Integer> data = new HashMap<>();
                    XYChart.Series xyData = new XYChart.Series();

                    firstSlideData(i, data);

                    data.entrySet().stream().forEach(pair -> {
                        xyData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                    });

                    xyData.setName("");

                    lineChart.getData().add(xyData);
                });

        // vbox - second border pane
        BorderPane second = new BorderPane();
        second.setPadding(new Insets(10, 10, 10, 10));

        // second border pane parts
        Label textSecond = new Label("Yearly interest rate");
        second.setLeft(textSecond);

        Slider sliderSecond = new Slider(0, 10, 0.1);
        sliderSecond.setShowTickLabels(true);
        second.setCenter(sliderSecond);

        Label descriptionSecond = new Label();
        second.setRight(descriptionSecond);

        sliderSecond.valueProperty().addListener(
                (obs, old, newval) -> {
                    double i = Math.floor(newval.doubleValue() * 100) / 100;
                    descriptionSecond.setText(Double.toString(i));

                    int amount = (int) sliderFirst.valueProperty().get();

                    Map<Integer, Double> dataSecond = new HashMap<>();
                    Map<Integer, Integer> data = new HashMap<>();

                    XYChart.Series xyData = new XYChart.Series();
                    XYChart.Series xyDataSecond = new XYChart.Series();

                    lineChart.getData().clear();

                    firstSlideData(amount, data);
                    secondSlideData(i, amount, dataSecond);

                    data.entrySet().stream().forEach(pair -> {
                        xyData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                    });

                    dataSecond.entrySet().stream().forEach(pair -> {
                        xyDataSecond.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                    });

                    xyData.setName("");
                    xyDataSecond.setName("");

                    lineChart.getData().add(xyData);
                    lineChart.getData().add(xyDataSecond);

                });
        // set vbox and borderpane
        sliders.getChildren().add(first);
        sliders.getChildren().add(second);

        // set top vbox
        mainLayout.setTop(sliders);

        //set display
        Scene view = new Scene(mainLayout, 640, 400);
        window.setScene(view);
        window.show();

    }

    public void firstSlideData(int amount, Map<Integer, Integer> data) {
        for (int i = 0; i < 31; i++) {
            int actualX = i;
            int actualY = (i * 12) * amount;
            if (data.containsKey(i)) {
                data.remove(i);
            }
            data.put(actualX, actualY);
        }
    }

    public void secondSlideData(double interest, int amount, Map<Integer, Double> data) {
        double total = 0;
        int sumToAdd = 12 * amount;

        for (int i = 0; i < 31; i++) {
            int actualX = i;

            if (i != 0) {
                total = total + sumToAdd;
                double Int = calcInt(total, interest);
                total += Int;
            }

            data.put(actualX,total);
        }
    }

    public double calcInt(double sum, double interest) {
        double valInt = (sum * interest) / 100;

        return valInt;
    }

}
