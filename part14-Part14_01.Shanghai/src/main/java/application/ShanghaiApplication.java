package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxis = new NumberAxis(2005,2020,4);
        NumberAxis yAxis = new NumberAxis();
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        XYChart.Series srcData = new XYChart.Series();
        srcData.setName("SRC");
        
        srcData.getData().add(new XYChart.Data(2007, 73));
        srcData.getData().add(new XYChart.Data(2008, 68));
        srcData.getData().add(new XYChart.Data(2009, 72));
        srcData.getData().add(new XYChart.Data(2010, 72));
        srcData.getData().add(new XYChart.Data(2011, 74));
        srcData.getData().add(new XYChart.Data(2012, 73));
        srcData.getData().add(new XYChart.Data(2013, 76));
        srcData.getData().add(new XYChart.Data(2014, 73));
        srcData.getData().add(new XYChart.Data(2015, 67));
        srcData.getData().add(new XYChart.Data(2016, 56));
        srcData.getData().add(new XYChart.Data(2017, 56));
        
        lineChart.getData().add(srcData);
        
        Scene view = new Scene(lineChart, 1024, 768);
        window.setScene(view);
        window.show();
    }

}
