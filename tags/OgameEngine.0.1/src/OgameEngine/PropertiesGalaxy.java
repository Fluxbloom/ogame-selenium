/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;

/**
 * Klasa odczytuje statyczne dane zawarte w pliku galaxySwitch.properties. 
 * Dane te dotyczą przycisków inactive pól zawartych w oknie podglądu galaktyki
 * @author dyschemist
 */
public class PropertiesGalaxy extends PropertiesOgame {

    public PropertiesGalaxy() throws OgameFileNotFoundException, OgameIOException {
        load("galaxy.properties");
        init();
    }

    private void init() {

        galaxySwitch = properties.getProperty("galaxy");
        systemSwitch = properties.getProperty("system");
        show_button = properties.getProperty("show_button");
        row_count = properties.getProperty("row_count");
        row = properties.getProperty("row");
        position_empty = properties.getProperty("position_empty");
        position_occupied = properties.getProperty("position_occupied");
        planet_activity = properties.getProperty("planet_activity");
        planet_minutes = properties.getProperty("planet_minutes");
        planet_minutes_text = properties.getProperty("planet_minutes_text");
        planet_name = properties.getProperty("planet_name");
        no_moon = properties.getProperty("no_moon");
        moon = properties.getProperty("moon");

        moon_activity = properties.getProperty("moon_activity");
        moon_minutes = properties.getProperty("moon_minutes");
        moon_minutes_text = properties.getProperty("moon_minutes_text");

        no_debris = properties.getProperty("no_debris");
        debris = properties.getProperty("debris");
        debris_a = properties.getProperty("debris_a");

        no_player = properties.getProperty("no_player");
        player = properties.getProperty("player");

        vacation = properties.getProperty("vacation");
        inactive = properties.getProperty("i");
        longInactive = properties.getProperty("I");
        noob = properties.getProperty("noob");
        strong = properties.getProperty("strong");
        banned = properties.getProperty("banned");
        outlaw = properties.getProperty("outlaw");
        honour = properties.getProperty("honour");
        bandit = properties.getProperty("bandit");
        starlord = properties.getProperty("starlord");

        no_ally = properties.getProperty("no_ally");
        ally = properties.getProperty("ally");
        isGalaxyOn=properties.getProperty("isGalaxyOn");
    }

    /**
     * Pobiera xpath do pola wstawiania numeru galaktyki
     * @return 
     */
    public String getGalaxySwitch() {
        return galaxySwitch;
    }

    public String getPosition_empty() {
        return position_empty;
    }

    public String getPosition_occupied() {
        return position_occupied;
    }

    public String getRow() {
        return row;
    }

    public String getRow(int i) {
        return row.replace("%i", Integer.toString(i));
    }

    public String getRow_count() {
        return row_count;
    }

    public String getShow_button() {
        return show_button;
    }

    /**
     * Pobiera xpath do pola wstawiania numeru systemu
     * @return 
     */
    public String getSystemSwitch() {
        return systemSwitch;
    }

    public String getPlanet_activity() {
        return planet_activity;
    }

    public String getPlanet_minutes() {
        return planet_minutes;
    }

    public String getPlanet_minutes_text() {
        return planet_minutes_text;
    }

    public String getDebris() {
        return debris;
    }

    public String getDebris_a() {
        return debris_a;
    }

    public String getMoon() {
        return moon;
    }

    public String getMoon_activity() {
        return moon_activity;
    }

    public String getMoon_minutes() {
        return moon_minutes;
    }

    public String getMoon_minutes_text() {
        return moon_minutes_text;
    }

    public String getNo_debris() {
        return no_debris;
    }

    public String getNo_moon() {
        return no_moon;
    }

    public String getPlanet_name() {
        return planet_name;
    }

    public String getInactive() {
        return inactive;
    }

    public String getAlly() {
        return ally;
    }

    public String getBandit() {
        return bandit;
    }

    public String getBanned() {
        return banned;
    }

    public String getHonour() {
        return honour;
    }

    public String getLongInactive() {
        return longInactive;
    }

    public String getNo_ally() {
        return no_ally;
    }

    public String getNo_player() {
        return no_player;
    }

    public String getNoob() {
        return noob;
    }

    public String getStrong() {
        return strong;
    }
    
    public String getOutlaw() {
        return outlaw;
    }

    public String getPlayer() {
        return player;
    }

    public String getStarlord() {
        return starlord;
    }

    public String getVacation() {
        return vacation;
    }

    public String getIsGalaxyOn() {
        return isGalaxyOn;
    }
    
    private String galaxySwitch;
    private String systemSwitch;
    private String show_button;
    private String row_count;
    private String row;
    private String position_empty;
    private String position_occupied;
    private String planet_activity;
    private String planet_minutes;
    private String planet_minutes_text;
    private String planet_name;
    private String no_moon;
    private String moon;
    private String moon_activity;
    private String moon_minutes;
    private String moon_minutes_text;
    private String no_debris;
    private String debris;
    private String debris_a;
    private String no_player;
    private String player;
    private String vacation;
    private String inactive;
    private String longInactive;
    private String noob;
    private String strong;
    private String banned;
    private String outlaw;
    private String honour;
    private String bandit;
    private String starlord;
    private String no_ally;
    private String ally;
    private String isGalaxyOn;
}
