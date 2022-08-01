/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Sebkula
 */
public class PracticeView {
    private String word;
    private Dictionary dictionary;
    
    public PracticeView(Dictionary dictionary){
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }
    
    public Parent getView(){
        GridPane layout = new GridPane();
        
        Label wordLabel = new Label("Translate the word '" + word + "'");
        TextField translationField = new TextField();
        
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));
        
        Button checkButton = new Button("Check");
        Label feedback = new Label("");
        
        layout.add(wordLabel, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedback, 0, 3);
       
        checkButton.setOnMouseClicked((event) -> {
            String translation = translationField.getText();
            if(dictionary.get(word).equals(translation)){
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The translation for the word '" + word + "' is '" + dictionary.get(word) + "'");
            }
            
            word = dictionary.getRandomWord();
            wordLabel.setText("Translate the word '" + word +"'");
            translationField.clear();
        });
        
        return layout;
    }
}
