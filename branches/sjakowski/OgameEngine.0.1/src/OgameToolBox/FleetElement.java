/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Coords;
import OgameElements.Fleet;
import OgameElements.Ships;
import OgameElements.Speed;

/**
 * Klasa odpowiada elementom nasyłanym na atak farmiący
 * @author Piotr Kowalski
 */
public class FleetElement {

    /**
     * Konstruktor z możliwością definiowana floty
     * @param destination cel
     * @param speed prędkość 
     * @param fleet flota
     * @param lastSend czy ostatnio atakowana
     */
    
    public FleetElement(Coords destination, Speed speed, Fleet fleet, boolean lastSend) {
        this.destination = destination;
        this.speed = speed;
        this.fleet = fleet;
        this.lastSend = lastSend;
    }
    
    
    /**
     * Konstruktor z możliwością definiowana floty
     * @param destination cel
     * @param speed prędkość 
     * @param fleet flota
     */
    public FleetElement(Coords destination, Speed speed, Fleet fleet) {
        this.destination = destination;
        this.speed = speed;
        this.fleet = fleet;
        this.lastSend=false;
    }
    /**
     * Wysyłanie floty na farming na cel z pełną prędkością
     * @param destination cel
     * @param fleet flota farmiąca
     */
    public FleetElement(Coords destination, Fleet fleet){
        this.destination=destination;
        this.fleet=fleet;
        this.speed=Speed.S100;
        this.lastSend=false;
    }
    
    /**
     * Ogólny konstruktor umożliwiający opóźnianie ataków na niektóre planety
     * Funkcja wysyłą po 5 mt na atak
     * @param destination cel ataku
     * @param speed prędkość ataku
     */
    public FleetElement(Coords destination, Speed speed) {
        this.destination = destination;
        this.speed = speed;
        this.fleet = farming;
        this.lastSend=false;
    }
    /**
     * Najpowszechniejszy konstrukror wysyłający atak na pełnej prędkości
     * @param destination cel ataku
     */
    public FleetElement(Coords destination) {
        this.destination = destination;
        this.speed=Speed.S100;
        this.fleet = farming;
        this.lastSend = false;
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

    /**
     * Czy ostatnio był atakowany
     * @return true jesli atakowany w ostatniej serii
     */
    public boolean isLastSend() {
        return lastSend;
    }

    /**
     * Ustawia czy ostatnio ten kord był atakowany
     * @param lastSend true jesli jest atakowany lub false jeśli nie jest
     */
    public void setLastSend(boolean lastSend) {
        this.lastSend = lastSend;
    }
    
    private static final Fleet farming = new Fleet();
    static {
        farming.add(Ships.MT, 5);
    }
    /**
     * Wypisuje stan obiektu
     * @return stan obiektu jako string
     */
    @Override
    public String toString() {
        return "FarmingElement{" + "destination=" + destination + ", speed=" + speed + ", fleet=" + fleet + '}';
    }
    
    
    private Coords destination;
    private Speed speed;
    private Fleet fleet;
    private boolean lastSend;
}
