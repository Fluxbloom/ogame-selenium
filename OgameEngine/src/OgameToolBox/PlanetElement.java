/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Planet;

/**
 * Klasa oddaje ilość flot na planecie, oraz kwestie nadawania z niej fs-a
 * @author Piotr Kowalski
 */
public class PlanetElement {
    
    /**
     * Pełny konstruktor o komplecie parametrów
     * @param planet planeta
     * @param fsFleet flota wysyłana na fs-a
     * @param fleetCount ilość flot nadawana z planety
     * @param fs czy planeta nadaje flotę fs-ową
     */
    public PlanetElement(Planet planet, Fleet fsFleet, int fleetCount, boolean fs) {
        this.planet = planet;
        this.fsFleet = fsFleet;
        this.fleetCount = fleetCount;
        this.fs = fs;
    }
    /**
     * Konstruktor dla domyślnie prawdziwego fs-a
     * @param planet planeta
     * @param fsFleet flota do fsa
     * @param fleetCount ilość flot do wysłania z planety
     */
    public PlanetElement(Planet planet, Fleet fsFleet, int fleetCount) {
        this.planet = planet;
        this.fsFleet = fsFleet;
        this.fleetCount = fleetCount;
        this.fs=true;
    }
    /**
     * Konstruktor domyślnie wysyłając cała flotę na fs-a
     * @param planet planeta 
     * @param fleetCount ilość flot do wysłania
     */
    public PlanetElement(Planet planet, int fleetCount) {
        this.planet = planet;
        this.fleetCount = fleetCount;
        this.fsFleet = Fleet.WHOLE_FLEET;
        this.fs=true;
    }
    /**
     * Konstruktor domyślnie wysyłający jedyną całą flotę na fsa
     * @param planet planeta
     */
    public PlanetElement(Planet planet) {
        this.planet = planet;
        this.fsFleet = Fleet.WHOLE_FLEET;
        this.fs = true;
        this.fleetCount=1;
    }

    /**
     * Pobiera ilość flot do nadania
     * @return ilość flot do nadania
     */
    public int getFleetCount() {
        return fleetCount;
    }
    /**
     * Ustawia ilość flot do nadania
     * @param fleetCount ilość flot
     */
    public void setFleetCount(int fleetCount) {
        this.fleetCount = fleetCount<0?0:fleetCount;
    }
    
    
    /**
     * Sprawdza czy flota nadaje fs-a 
     * @return true na tak, false na nie
     */
    public boolean isFs() {
        return fs;
    }
    /**
     * Zwraca flotę latająca na fs-a
     * @return fs flota
     */
    public Fleet getFsFleet() {
        return fsFleet;
    }
    /**
     * Zwraca planetę której dotyczą dane
     * @return 
     */
    public Planet getPlanet() {
        return planet;
    }
    
    private Planet planet;
    private Fleet fsFleet;
    private int fleetCount;
    private boolean fs;
    
}
