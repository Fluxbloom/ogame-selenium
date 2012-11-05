/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa budynków wznoszonych na księżycu
 * @author Piotr Kowalski
 */
public class BuildingsMoon extends Buildings{
    /**
     * Konstruktor budynków na księżycu
     * @param name nazwa budynku
     */
    private BuildingsMoon(String name) {
        super(name);
    }
    
    /**
     * Budynek stacji księżycowej
     */
    static final BuildingsMoon MOON_STATION = new BuildingsMoon("MOON_STATION");
    /**
     * Budynek falangi ksieżycowej
     */
    static final BuildingsMoon MOON_FALANG= new BuildingsMoon("MOON_FALANG");
    /**
     * Budynek teleportera
     */
    static final BuildingsMoon MOON_TELEPORTER = new BuildingsMoon("MOON_TELEPORTER");
    /**
     * Budynek fabryki robotów
     */
    static final BuildingsMoon MOON_ROBOTS = new BuildingsMoon("MOON_ROBOTS");
    /**
     * Budynek stoczni
     */
    static final BuildingsMoon MOON_SHIPYARD = new BuildingsMoon("MOON_SHIPYARD");
}
