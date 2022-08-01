package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {     
        BorderPane firstLayout = new BorderPane();
        Button firstButton = new Button("To the second view!");
        Label topText = new Label("First view!");
        firstLayout.setTop(topText);
        firstLayout.setCenter(firstButton);
        
        VBox secondLayout = new VBox();
        Button secondButton = new Button("To the third view!");
        Label onRightText = new Label("Second view!");
        secondLayout.getChildren().addAll(secondButton, onRightText);
        
        
        GridPane thirdLayout = new GridPane();
        Button thirdButton = new Button();
        Label text = new Label("Third view!");
        thirdLayout.add(text, 0, 0);
        thirdLayout.add(thirdButton, 1, 1);
        
        Scene firstView = new Scene(firstLayout);
        Scene secondView = new Scene(secondLayout);
        Scene thirdView = new Scene(thirdLayout);
        
        firstButton.setOnAction((event) -> {
            window.setScene(secondView);
        });
        secondButton.setOnAction((event) -> {
            window.setScene(thirdView);
        });
        thirdButton.setOnAction((event) -> {
            window.setScene(firstView);
        });
        
      
        window.setScene(firstView);
        window.show();
    }

}
