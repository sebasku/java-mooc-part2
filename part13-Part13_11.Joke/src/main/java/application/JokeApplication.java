package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        
        Button questionJoke = new Button("Joke");
        Button answerJoke = new Button("Answer");
        Button explanationJoke = new Button("Explanation");
        
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.getChildren().addAll(questionJoke, answerJoke, explanationJoke);
        
        layout.setTop(menu);
        
        StackPane firstLayout = createLayout("What do you call a bear with no teeth?");
        StackPane secondLayout = createLayout("A gummy bear.");
        StackPane thirdLayout = createLayout("Third View");
        
        questionJoke.setOnAction((event) -> layout.setCenter(firstLayout));
        answerJoke.setOnAction((event) -> layout.setCenter(secondLayout));
        explanationJoke.setOnAction((event) -> layout.setCenter(thirdLayout));
        
        layout.setCenter(firstLayout);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }
    
    private StackPane createLayout(String name){
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(name));
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    }
}
