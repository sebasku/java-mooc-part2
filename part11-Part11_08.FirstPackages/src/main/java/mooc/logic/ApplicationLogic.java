/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import mooc.ui.UserInterface;

/**
 *
 * @author Sebkula
 */
public class ApplicationLogic {
    final private UserInterface ui;
    
    public ApplicationLogic(UserInterface ui){
        this.ui = ui;
    }
    
    public void execute(int times){
        String string = "Application logic is working";
        for(int i=0; i<times; i++){
            System.out.println(string);
            ui.update();
        }
    }
}
