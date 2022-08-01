package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndLabelApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Label label = new Label("Label");
        Button button = new Button("Button");
        
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(label);
        componentGroup.getChildren().add(button);
        
        Scene view = new Scene(componentGroup);
        
        window.setScene(view);
        window.show();
    }

}
