
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class MisplacingBox extends Box {
    private final ArrayList<Item> misplBoxes;
    
    public MisplacingBox(){
        this.misplBoxes = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        misplBoxes.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
