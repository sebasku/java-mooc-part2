
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebkula
 */
public class Hand implements Comparable<Hand>{
    private List<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card){
        this.hand.add(card);
    }
    
    public void print(){
        hand.stream().forEach(card -> System.out.println(card));
    }
    
    public void sort(){
        Collections.sort(hand);
    }
    
    public void sortBySuit(){
        Collections.sort(hand, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand comparedHand) {
        int thisValue = this.hand.stream().mapToInt(hand -> hand.getValue()).sum();
        int comparedValue = comparedHand.hand.stream().mapToInt(hand -> hand.getValue()).sum();
        return thisValue - comparedValue;
    }
}
