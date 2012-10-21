/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.PropertiesBuildings;
import OgameEngine.PropertiesMessages;
import OgameEngine.PropertiesSpyReport;
import java.io.File;
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
public class PropertiesOgame {
      
    protected PropertiesOgame() { 
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

    public PropertiesMessages getMessages() {
        return messages;
    }

    public PropertiesSpyReport getSpyreport() {
        return spyreport;
    }

    public PropertiesGalaxy getGalaxy() {
        return galaxy;
    }
    
    
    
    
    /**
     * Metoda służąca do zaczytywania propertiesów z pliów
     * @param fileName nazwa pliku, bez ścieżki. Folder jest zaczytywany z pliku defaultConfFile.properties
     * @throws OgameFileNotFoundException Błąd braku pliku
     * @throws OgameIOException  Błąd odczytu z pliku
     */
    protected void load(String name) throws OgameFileNotFoundException, OgameIOException{
        properties = new Properties();
        Properties defaultPath = new Properties();
        String defaultConfFilePath = System.getProperty("user.dir") + "/conf/defaultConfFile.properties";
        File main = new File(defaultConfFilePath);
        if (main.exists()) {
            try {
                defaultPath.load(new FileInputStream(main));
            } catch (FileNotFoundException ex) {
                logger.log(Level.SEVERE, "Missing file {0}", new String[]{defaultConfFilePath});
                throw new OgameFileNotFoundException(defaultConfFilePath);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Could read the source {0}", new String[]{defaultConfFilePath});
                int tries = 0;
                while (tries < 3) {
                    try {
                        defaultPath.load(new FileInputStream(main));
                        break;
                    } catch (IOException ex1) {
                        tries++;
                        logger.log(Level.SEVERE, "Could read the source {0} retry {1}",
                                new String[]{defaultConfFilePath, Integer.toString(tries)});
                        if (tries == 3) {
                            throw new OgameIOException(ex1);
                        }
                    }
                }

            }
        } else {
            throw new OgameFileNotFoundException(defaultConfFilePath);
        }
        path = System.getProperty("user.dir") + "/conf/" + defaultPath.getProperty("folder") + "/"+name;
        File conf = new File(path);
        if (conf.exists()) {
            try {
                properties.load(new FileInputStream(conf));
            } catch (FileNotFoundException ex) {
                logger.log(Level.SEVERE, "Missing file {0}", new String[]{path});
                throw new OgameFileNotFoundException(path);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Could read the source {0}", new String[]{path});
                int tries = 0;
                while (tries < 3) {
                    try {
                        properties.load(new FileInputStream(conf));
                        break;
                    } catch (IOException ex1) {
                        tries++;
                        logger.log(Level.SEVERE, "Could read the source {0} retry {1}",
                                new String[]{path, Integer.toString(tries)});
                        if (tries == 3) {
                            throw new OgameIOException(ex1);
                        }
                    }
                }
            }
        } else {
            throw new OgameFileNotFoundException(path);
        }
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
    private PropertiesGalaxy galaxy;
    private PropertiesEvents events;
    private PropertiesResources resources;
    private PropertiesSlots slots;
    private PropertiesMessages messages;
    private PropertiesSpyReport spyreport;
    
    private static final Logger logger = Logger.getLogger(PropertiesOgame.class.getName());
    
    public static PropertiesOgame mappingPropertiesFabric(){
        PropertiesOgame result = new PropertiesOgame();
        try {
                result.selenium = new PropertiesSelenium();
                result.login = new PropertiesLogin();
                result.overview = new PropertiesOverview();
                result.fleet = new PropertiesFleet();
                result.galaxy = new PropertiesGalaxy();
                result.buldings = new PropertiesBuildings();
                result.defence = new PropertiesDefence();
                result.events = new PropertiesEvents();
                result.lab = new PropertiesLab();
                result.resources = new PropertiesResources();
                result.shipyard = new PropertiesShipyard();
                result.slots = new PropertiesSlots();
                result.messages = new PropertiesMessages();
                result.spyreport = new PropertiesSpyReport();
        } catch (OgameFileNotFoundException ex) {
            Logger.getLogger(PropertiesOgame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OgameIOException ex) {
            Logger.getLogger(PropertiesOgame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
