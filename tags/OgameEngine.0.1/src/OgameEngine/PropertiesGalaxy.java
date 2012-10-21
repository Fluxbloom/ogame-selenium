/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;

/**
 * Klasa odczytuje statyczne dane zawarte w pliku galaxy.properties. 
 * Dane te dotyczą przycisków i pól zawartych w oknie podglądu galaktyki
 * @author dyschemist
 */
public class PropertiesGalaxy extends PropertiesOgame{
  
    public PropertiesGalaxy() throws OgameFileNotFoundException, OgameIOException {
        load("galaxy.properties");
        init();
    }

    private void init() {
        
    }
    
}
