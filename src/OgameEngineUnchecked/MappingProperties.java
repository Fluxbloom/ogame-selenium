/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa nadrzędna do zarządzania odwzorowaniami do danych statycznych w plikach properties
 * @author dyschemist
 */
class MappingProperties {
      
    protected MappingProperties() { 
    }

    /**
     * Zwraca propertiesy selenium
     * @return propertiesy selenium
     */
    public PropertiesSelenium getSelenium() {
        return selenium;
    }
    
    /**
     * Zwraca propertiesy logowania
     * @return propertiesy logowania
     */
    public PropertiesLogin getLogin() {
        return login;
    }


    /**
     * Zwraca propertiesy do podgladu
     *
     * @return propertiesy do podgladu
     */
    public PropertiesOverview getOverview() {
        return overview;
    }

    /**
     * Zwraca propertiesy do menu wysyłania flot
     * @return propertiesy do menu wysyłania flot
     */
    public PropertiesFleet getFleet() {
        return fleet;
    }

    public PropertiesBuildings getBuldings() {
        return buldings;
    }

    public PropertiesDefence getDefence() {
        return defence;
    }

    public PropertiesEvents getEvents() {
        return events;
    }

    public PropertiesLab getLab() {
        return lab;
    }

    public PropertiesResources getResources() {
        return resources;
    }

    public PropertiesShipyard getShipyard() {
        return shipyard;
    }

    public PropertiesSlots getSlots() {
        return slots;
    }
    
    
    
    /**
     * Metoda służąca do zaczytywania propertiesów z pliów
     * @param fileName nazwa pliku, bez ścieżki. Folder jest zaczytywany z pliku defaultConfFile.properties
     * @throws FileNotFoundException Błąd braku pliku
     * @throws IOException  Błąd odczytu z pliku
     */
    protected void load(String fileName) throws FileNotFoundException, IOException{
        Properties defaultPath = new Properties();
        defaultPath.load(new FileInputStream(System.getProperty("user.dir") + "/conf/defaultConfFile.properties"));
        path = System.getProperty("user.dir") + 
                "/conf/" + defaultPath.getProperty("folder") +'/'+ fileName;
        // reading property file
        properties = new Properties();
        properties.load(new FileInputStream(path));
    }
    
    
    

    

   

    

    

   

   
    
   

   

    

    

    



    
    
    /**
     * Ścieżka do plików properties
     */
    protected String path;
    /**
     * Tablica propertiesów
     */
    protected Properties properties;

    /**
     * Mappingi selenium
     */
    private PropertiesSelenium selenium;
    private PropertiesLogin login;
    private PropertiesOverview overview;
    private PropertiesBuildings buldings;
    private PropertiesLab lab;
    private PropertiesShipyard shipyard;
    private PropertiesDefence defence;
    private PropertiesFleet fleet;
    private PropertiesEvents events;
    private PropertiesResources resources;
    private PropertiesSlots slots;
    
        static MappingProperties mappingPropertiesFabric(){
        MappingProperties result = new MappingProperties();
        try {
                result.selenium = new PropertiesSelenium();
                result.login = new PropertiesLogin();
                result.overview = new PropertiesOverview();
                result.fleet = new PropertiesFleet();
                result.buldings = new PropertiesBuildings();
                result.defence = new PropertiesDefence();
                result.events = new PropertiesEvents();
                result.lab = new PropertiesLab();
                result.resources = new PropertiesResources();
                result.shipyard = new PropertiesShipyard();
                result.slots = new PropertiesSlots();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MappingProperties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MappingProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
