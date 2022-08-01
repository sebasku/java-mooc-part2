package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        
        TextArea textAreaCenter = new TextArea();
        
        HBox textComponentsBottom = new HBox();
        textComponentsBottom.setSpacing(10);
        textComponentsBottom.getChildren().add(new Label("Letters: 0"));
        textComponentsBottom.getChildren().add(new Label("Words: 0"));
        textComponentsBottom.getChildren().add(new Label("The longest word is:"));
        
        layout.setCenter(textAreaCenter);
        layout.setBottom(textComponentsBottom);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

}
