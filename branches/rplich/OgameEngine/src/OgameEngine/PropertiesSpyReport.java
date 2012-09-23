/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngineUnchecked.MappingProperties;

/**
 * Klasa dostarcza xpathów z konfiguracji dla potrzeb rozczytywania raportów szpiegowskich
 * @author Piotr Kowalski
 */
public class PropertiesSpyReport extends MappingProperties {
    /**
     * Konstruktor wczytujący propertiesy
     * @throws OgameFileNotFoundException Błąd braku pliku
     * @throws OgameIOException  Błąd odczytu z 
     */
    public PropertiesSpyReport() throws OgameFileNotFoundException, OgameIOException {
        load("spyreport.properties");
        init();
    }

    private void init() {
        coords = properties.getProperty("coords");
        metal = properties.getProperty("metal");
        cristal = properties.getProperty("cristal");
        deuterium = properties.getProperty("deuterium");
        energy = properties.getProperty("energy");
    }
/**
     * Zwraca xpath do wczytania kordynatów
     * @return xpath do kordynatór
     */
    public String getCoords() {
        return coords;
    }
/**
     * Zwraca xpath do kryształów
     * @return path d kryształów
     */
    public String getCristal() {
        return cristal;
    }
    /**
     * Zwraca xpath do deuteru
     * @return xpath do euteru
     */
    public String getDeuterium() {
        return deuterium;
    }
    /**
     * Zwraca xpath do energii
     * @return xpath do energii
     */
    public String getEnergy() {
        return energy;
    }
    /**
     * Zwraca xpath do metalu
     * @return xpath do metalu
     */
    public String getMetal() {
        return metal;
    }
    
    
    
    private String coords;
    private String metal;
    private String cristal;
    private String deuterium;
    private String energy;
}
