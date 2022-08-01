package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class PartiesApplication extends Application{

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        NumberAxis xAxis = new NumberAxis(1965,2010,4);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        Map<String, Map<Integer, Double>> values = readValues();
        
        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);
            
            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });
        Scene view = new Scene(lineChart, 1024, 768);
        window.setScene(view);
        window.show();
    }
    
    public Map<String, Map<Integer, Double>> readValues() {
        Map<String, Map<Integer, Double>> values = new HashMap<>();
        List<String> lines = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader("partiesdata.tsv"))){
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }
        String[] years = lines.get(0).split("\t");
        lines.remove(0);
        
        for(String line : lines){
            Map<Integer, Double> data = new HashMap<>();
            String[] parts = line.split("\t");
            for(int i = 1; i < parts.length; i++){
                if(!parts[i].equals("-")){
                    data.put(Integer.valueOf(years[i]), Double.valueOf(parts[i]));
                }
            }
            values.put(parts[0], data);
        }
        
        return values;
    }
}
