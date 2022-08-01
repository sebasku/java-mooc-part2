package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        
        TextArea textArea = new TextArea();
        HBox bottomBox = new HBox();
        bottomBox.setSpacing(20);
        Label leftLabel = new Label("Letters:");
        Label middleLabel = new Label("Words:");
        Label rightLabel = new Label("The longest word is:");
        bottomBox.getChildren().addAll(leftLabel, middleLabel, rightLabel);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((string1, string2) -> string2.length() - string1.length())
                    .findFirst()
                    .get();
            
            leftLabel.setText("Letters: " + characters);
            middleLabel.setText("Words: " + words);
            rightLabel.setText("The longest word is: " + longest);
        });
        
        layout.setCenter(textArea);
        layout.setBottom(bottomBox);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

}
