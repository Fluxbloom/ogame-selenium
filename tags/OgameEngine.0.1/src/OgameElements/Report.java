/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameElementsUnchecked.PlanetResources;

/**
 * Klasa odpowiada raportowi w Ogame i zawiera wszystkie jego wewnętrzne operacje
 * @author Piotr Kowalski
 */
public class Report extends Message{
    /**
     * Konstruktor podstawowego raportuS
     * @param cords kordynaty
     * @param resources zasoby na planecie
     */
    public Report(Coords cords, PlanetResources resources) {
        this.cords = cords;
        this.resources = resources;
    }
    
    
    
    private Coords cords;
    private PlanetResources resources;
}
