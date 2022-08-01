/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author Sebkula
 */
public class Flight {
    private Airplane airplane;
    private Place departureAirport;
    private Place destinationAirport;
    
    public Flight(Airplane airplane, Place departureAirport, Place destinationAirport){
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }
    
    public Airplane getAirplane(){
        return this.airplane;
    }
    
    public Place getDepartureAirport(){
        return this.departureAirport;
    }
    
    public Place getDestinationAirport(){
        return this.destinationAirport;
    }
    
    @Override
    public String toString(){
        return this.airplane + " (" + this.departureAirport + "-" + this.destinationAirport +")";
    }
}
