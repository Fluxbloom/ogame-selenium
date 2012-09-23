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
 * Opakowana klasa definiująca parametry skanowania
 * @author Piotr Kowalski
 */
public class ScanElement {
    /**
     * Konstruktor pełny
     * @param destination cel danego elementu
     * @param speed prędkość dla danego elementu
     * @param scanFleet flota skanująca dany element
     */
    public ScanElement(Coords destination, Speed speed, Fleet scanFleet) {
        this.destination = destination;
        this.speed = speed;
        this.scanFleet = scanFleet;
    }
    /**
     * Konstruktor z zdefiniowaną flotą skanującą
     * @param destination cel
     * @param scanFleet flota skanująca
     */
    public ScanElement(Coords destination, Fleet scanFleet) {
        this.destination = destination;
        this.scanFleet = scanFleet;
        this.speed = Speed.S100;
    }
    /**
     * Konstruktor ustawiający domyślną flotę skanującą na cel
     * @param destination cel
     */
    public ScanElement(Coords destination) {
        this.destination = destination;
        this.speed=Speed.S100;
        this.scanFleet=scanningFleet; 
    }
    /**
     * Zwraca cel elementu
     * @return cel elementu
     */
    public Coords getDestination() {
        return destination;
    }
    /**
     * Zwraca flotę skanującą
     * @return flota skanująca
     */
    public Fleet getScanFleet() {
        return scanFleet;
    }
    /**
     * Zwraca prędkość skanującą
     * @return prędkość
     */
    public Speed getSpeed() {
        return speed;
    }
    
    private static Fleet scanningFleet = new Fleet();
    static {
        ScanElement.scanningFleet.add(Ships.SOND, 3);
    }
 
    private Coords destination;
    private Speed speed;
    private Fleet scanFleet;
}
