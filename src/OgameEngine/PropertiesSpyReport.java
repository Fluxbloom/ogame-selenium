/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameElements.Buildings;
import OgameElements.Defence;
import OgameElements.Ships;
import OgameElements.ShipyardShips;
import OgameElements.ShipyardShips;
import OgameElements.Technology;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa dostarcza xpathów z konfiguracji dla potrzeb rozczytywania raportów szpiegowskich
 * @author Piotr Kowalski
 */
public class PropertiesSpyReport extends PropertiesOgame {

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
        moonMarkerXpath = properties.getProperty("moonMarkerXpath");
        moonMarker = properties.getProperty("moonMarker");
        metal = properties.getProperty("metal");
        cristal = properties.getProperty("cristal");
        deuterium = properties.getProperty("deuterium");
        energy = properties.getProperty("energy");
        player_status_bandit = properties.getProperty("");
        player_status_starlord = properties.getProperty("");
        player_status_honour = properties.getProperty("");
        player_status_vacation = properties.getProperty("");
        player_status_i = properties.getProperty("");
        player_status_I = properties.getProperty("");
        player_status_noob = properties.getProperty("");
        player_status_strong = properties.getProperty("");
        player_status_outlaw = properties.getProperty("");
        player_status_banned = properties.getProperty("");
        activity_no = properties.getProperty("");
        activity_yes = properties.getProperty("");
        activity_minutes = properties.getProperty("");
        activity_minutes_text = properties.getProperty("");
        fleet_block = properties.getProperty("");
        fleet_row_count = properties.getProperty("");
        fleet_column_count = properties.getProperty("");
        fleet_row = properties.getProperty("");
        fleet_key = properties.getProperty("");

        defence_block = properties.getProperty("");
        defence_row_count = properties.getProperty("");
        defence_column_count = properties.getProperty("");
        defence_row = properties.getProperty("");
        defence_key = properties.getProperty("");

        buildings_block = properties.getProperty("");
        buildings_row_count = properties.getProperty("");
        buildings_column_count = properties.getProperty("");
        buildings_row = properties.getProperty("");
        buildings_key = properties.getProperty("");

        tech_block = properties.getProperty("");
        tech_row_count = properties.getProperty("");
        tech_column_count = properties.getProperty("");
        tech_row = properties.getProperty("");
        tech_key = properties.getProperty("");
        {
            String mappingString = properties.getProperty("");
            fleet_mapping = new HashMap<String, ShipyardShips>();
            //String[] temp = mappingString.split(";;");

        }
        {
            String mappingString = properties.getProperty("");
            defence_mapping = new HashMap<String, Defence>();
            //String temp[] = mappingString.split(":;");
        }
        {
            String mappingString = properties.getProperty("");
            buildings_mapping = new HashMap<String, Buildings>();
            //String temp[] = mappingString.split(":;");
        }
        {
            String mappingString = properties.getProperty("");
            tech_mapping = new HashMap<String, Technology>();
            //String temp[] = mappingString.split(":;");
        }
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
    private String moonMarkerXpath;
    private String moonMarker;
    private String metal;
    private String cristal;
    private String deuterium;
    private String energy;
    private String player_status_bandit;
    private String player_status_starlord;
    private String player_status_honour;
    private String player_status_vacation;
    private String player_status_i;
    private String player_status_I;
    private String player_status_noob;
    private String player_status_strong;
    private String player_status_outlaw;
    private String player_status_banned;
    private String activity_no;
    private String activity_yes;
    private String activity_minutes;
    private String activity_minutes_text;
    private String fleet_block;
    private String fleet_row_count;
    private String fleet_column_count;
    private String fleet_row;
    private String fleet_key;
    private Map<String, ShipyardShips> fleet_mapping;
    private String defence_block;
    private String defence_row_count;
    private String defence_column_count;
    private String defence_row;
    private String defence_key;
    private Map<String, Defence> defence_mapping;
    private String buildings_block;
    private String buildings_row_count;
    private String buildings_column_count;
    private String buildings_row;
    private String buildings_key;
    private Map<String, Buildings> buildings_mapping;
    private String tech_block;
    private String tech_row_count;
    private String tech_column_count;
    private String tech_row;
    private String tech_key;
    private Map<String, Technology> tech_mapping;
    private static final Map<String, ShipyardShips> code2Ship = new HashMap<String, ShipyardShips>();

    static {
        code2Ship.put("LM", ShipyardShips.LM);
        code2Ship.put("CM", ShipyardShips.CM);
        code2Ship.put("KRK", ShipyardShips.KR);
        code2Ship.put("OW", ShipyardShips.OW);
        code2Ship.put("PANC", ShipyardShips.PAN);
        code2Ship.put("BOMB", ShipyardShips.BOMB);
        code2Ship.put("NISZ", ShipyardShips.NISZ);
        code2Ship.put("GS", ShipyardShips.GS);
        code2Ship.put("MT", ShipyardShips.MT);
        code2Ship.put("DT", ShipyardShips.DT);
        code2Ship.put("KOL", ShipyardShips.KOL);
        code2Ship.put("REC", ShipyardShips.REC);
        code2Ship.put("SOND", ShipyardShips.SOND);
        code2Ship.put("SAT", ShipyardShips.SAT);
    }
    private static final Map<String, Defence> code2Defence = new HashMap<String, Defence>();
    private static final Map<String, Buildings> code2Building = new HashMap<String, Buildings>();
    private static final Map<String, Technology> code2Technology = new HashMap<String, Technology>();
}
