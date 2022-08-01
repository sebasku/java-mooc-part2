package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        //First layout
        Label instructLabel = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button button = new Button("Start");
        
        //Creating layout, adding elements
        GridPane nameInputLayout = createLayout();
        nameInputLayout.add(instructLabel, 0, 0);
        nameInputLayout.add(textField, 0, 1);
        nameInputLayout.add(button, 0, 2);
        
        //2.1 Creating layout, adding elements
        Label nameViewLabel = new Label();
        GridPane nameViewLayout = createLayout();
        nameViewLayout.add(nameViewLabel, 0, 1);
        
        //Creating scenes and setting first view with name input
        Scene nameInput = new Scene(nameInputLayout);
        Scene nameView = new Scene(nameViewLayout);
        
        button.setOnAction((event) -> {
            nameViewLabel.setText("Welcome " + textField.getText() +"!");
            window.setScene(nameView);
        });
        
        window.setScene(nameInput);
        window.show();
    }
    
        //Styling the layout
    private GridPane createLayout(){
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPrefSize(300, 180);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setVgap(10);
        layout.setHgap(10);
        return layout;
    }
}
