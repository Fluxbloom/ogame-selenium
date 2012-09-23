/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Coords;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Ships;
import OgameElementsUnchecked.Speed;

/**
 * Klasa odpowiada elementom nasyłanym na atak farmiący
 * @author Piotr Kowalski
 */
public class FarmingElement {
    /**
     * Konstruktor z możliwością definiowana floty
     * @param destination cel
     * @param speed prędkość 
     * @param fleet flota
     */
    public FarmingElement(Coords destination, Speed speed, Fleet fleet) {
        this.destination = destination;
        this.speed = speed;
        this.fleet = fleet;
    }
    /**
     * Wysyłanie floty na farming na cel z pełną prędkością
     * @param destination cel
     * @param fleet flota farmiąca
     */
    public FarmingElement(Coords destination, Fleet fleet){
        this.destination=destination;
        this.fleet=fleet;
        this.speed=Speed.S100;
    }
    
    /**
     * Ogólny konstruktor umożliwiający opóźnianie ataków na niektóre planety
     * Funkcja wysyłą po 5 mt na atak
     * @param destination cel ataku
     * @param speed prędkość ataku
     */
    public FarmingElement(Coords destination, Speed speed) {
        this.destination = destination;
        this.speed = speed;
        this.fleet = farming;
    }
    /**
     * Najpowszechniejszy konstrukror wysyłający atak na pełnej prędkości
     * @param destination cel ataku
     */
    public FarmingElement(Coords destination) {
        this.destination = destination;
        this.speed=Speed.S100;
        this.fleet = farming;
    }
    /**
     * Pobiera kordyntat celu
     * @return cel
     */
    public Coords getDestination() {
        return destination;
    }
    /**
     * Pobiera prędkość
     * @return prędkość
     */
    public Speed getSpeed() {
        return speed;
    }
    /**
     * Pobiera flotę do farmingu
     * @return flota
     */
    public Fleet getFleet() {
        return fleet;
    }
    
    private static final Fleet farming = new Fleet();
    static {
        farming.add(Ships.MT, 5);
    }

    @Override
    public String toString() {
        return "FarmingElement{" + "destination=" + destination + ", speed=" + speed + ", fleet=" + fleet + '}';
    }
    
    
    private Coords destination;
    private Speed speed;
    private Fleet fleet;
}
