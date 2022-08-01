package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        VBox layout = new VBox();
        
        TextField topText = new TextField();
        Button button = new Button("Update");
        Label botLabel = new Label("");
        
        button.setOnAction((event) -> {
            botLabel.setText(topText.getText());
        });
        
        layout.getChildren().addAll(topText, button, botLabel);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }

}
