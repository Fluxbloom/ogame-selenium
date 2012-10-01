/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameElements.Mission;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author dyschemist
 */
public class PropertiesSlots extends PropertiesOgame {


    
    public PropertiesSlots() throws OgameFileNotFoundException, OgameIOException {
        load("slot.properties");
        init();
    }

    private void init() {
        slots_usedFleets = properties.getProperty("slots_usedFleets");////div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="current"]
        slots_maxFleets = properties.getProperty("slots_maxFleets");////div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="all"]
        slots_useExp = properties.getProperty("slots_useExp");////div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="current"]
        slots_maxExp = properties.getProperty("slots_maxExp");////div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="all"]
        slots_fleet_by_number = properties.getProperty("slots_fleet_by_number");////div[contains(@id,"fleet")]
        slots_fleet_by_id = properties.getProperty("slots_fleet_by_id");////div[contains(@id,"%i")]
        slots_fleetId_remove = properties.getProperty("slots_fleetId_remove");
        slots_fleetId_suffix = properties.getProperty("slots_fleetId_suffix");//@id
        slots_fleetArrival_suffix = properties.getProperty("slots_fleetArrival_suffix");///span[contains(@id,"timer_")]
        slots_fleetMission_suffix = properties.getProperty("slots_fleetMission_suffix");///span[contains(@class,"mission")]
        slots_fleetAllianceName_suffix = properties.getProperty("slots_fleetAllianceName_suffix");///span[contains(@class,"allianceName")]
        slots_fleetOriginPlanet_suffix = properties.getProperty("slots_fleetOriginPlanet_suffix");///span[@class="originData"]//a
        slots_fleetReversal_suffix = properties.getProperty("slots_fleetReversal_suffix");///span[contains(@class,"reversal")]
        slots_fleetReversal_titleAtribute_suffix = properties.getProperty("slots_fleetReversal_titleAtribute_suffix");///span[contains(@class,"reversal")]@title
        slots_fleetReversal_button_suffix = properties.getProperty("slots_fleetReversal_button_suffix");
        slots_fleetTargetPlanet_suffix = properties.getProperty("slots_fleetTargetPlanet_suffix");///span[@class="destinationData"]//a
        slots_fleetComeBack_suffix = properties.getProperty("slots_fleetComeBack_suffix");///span[contains(@id,"timerNext_")]
        slots_fleetComeBack_titleAtribute_suffix = properties.getProperty("slots_fleetComeBack_titleAtribute_suffix");///span[contains(@id,"timerNext_")]@title
        {//odczytanie mapowania misji
            slots_missionMap = new HashMap<String,String>();
            String[] temp = properties.getProperty("slots_missionMap").split("!");
            String[] t;
            for (int i = 0; i < temp.length; i++) {
                t = temp[i].split(";");
                slots_missionMap.put(t[0], t.length < 2 ? "" : t[1].replace(" ", ""));
            }
        }
        slots_parseArrival = properties.getProperty("slots_parseArrival");// '|'dd.MM.yyyy HH:mm:ss
        slots_parseReversal = properties.getProperty("slots_parseReversal");//'Zawróć:|' dd.MM.yyyy'<br>'HH:mm:ss
        slots_parseReturn = properties.getProperty("slots_parseReturn");//'|'dd.MM.yyyy HH:mm:ss

    }
    
     public String getSlots_parseArrival() {
        return slots_parseArrival;
    }

    public String getSlots_parseReturn() {
        return slots_parseReturn;
    }

    public String getSlots_parseReversal() {
        return slots_parseReversal;
    }

    public String getSlots_fleetReversal_button_suffix() {
        return slots_fleetReversal_button_suffix;
    }

    public String getSlotMissionID(String missionType) {
        String result = "";
        Set set = slots_missionMap.entrySet();
        Entry<String, String> temp;
        Iterator<Entry<String, String>> it = set.iterator();
        while (it.hasNext()) {
            temp = it.next();
            if (temp.getKey().compareTo(missionType) == 0) {
                result = temp.getValue();
                break;
            }
        }
        return result;
    }

    public String getSlotMissionID(Mission m) {
        return getSlotMissionID(m.getName());
    }

    public String getSlots_fleetId_remove() {
        return slots_fleetId_remove;
    }

    public String getSlots_fleet_by_id(int i) {
        return slots_fleet_by_id.replace("%i", Integer.toString(i));
    }

    public String getSlots_fleet_by_number(int i) {
        return slots_fleet_by_number.replace("%i", Integer.toString(i));
    }

    public String getSlots_fleetAllianceName_suffix() {
        return slots_fleetAllianceName_suffix;
    }

    public String getSlots_fleetArrival_suffix() {
        return slots_fleetArrival_suffix;
    }

    public String getSlots_fleetComeBack_suffix() {
        return slots_fleetComeBack_suffix;
    }

    public String getSlots_fleetComeBack_titleAtribute_suffix() {
        return slots_fleetComeBack_titleAtribute_suffix;
    }

    public String getSlots_fleetId_suffix() {
        return slots_fleetId_suffix;
    }

    public String getSlots_fleetMission_suffix() {
        return slots_fleetMission_suffix;
    }

    public String getSlots_fleetOriginPlanet_suffix() {
        return slots_fleetOriginPlanet_suffix;
    }

    public String getSlots_fleetReversal_suffix() {
        return slots_fleetReversal_suffix;
    }

    public String getSlots_fleetReversal_titleAtribute_suffix() {
        return slots_fleetReversal_titleAtribute_suffix;
    }

    public String getSlots_fleetTargetPlanet_suffix() {
        return slots_fleetTargetPlanet_suffix;
    }

    public String getSlots_maxExp() {
        return slots_maxExp;
    }

    public String getSlots_maxFleets() {
        return slots_maxFleets;
    }

    public String getSlots_useExp() {
        return slots_useExp;
    }

    public String getSlots_usedFleets() {
        return slots_usedFleets;
    }
    
    
    private String slots_usedFleets;//=//div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="current"]
    private String slots_maxFleets;//=//div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="all"]
    private String slots_useExp;//=//div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="current"]
    private String slots_maxExp;//=//div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="all"]
    private String slots_fleet_by_number;//=//div[contains(@id,"fleet")]
    private String slots_fleet_by_id;//=//div[contains(@id,"%i")]
    private String slots_fleetId_remove;
    private String slots_fleetId_suffix;//=@id
    private String slots_fleetArrival_suffix;//=/span[contains(@id,"timer_")]
    private String slots_fleetMission_suffix;//=/span[contains(@class,"mission")]
    private String slots_fleetAllianceName_suffix;//=/span[contains(@class,"allianceName")]
    private String slots_fleetOriginPlanet_suffix;//=/span[@class="originData"]//a
    private String slots_fleetReversal_suffix;//=/span[contains(@class,"reversal")]
    private String slots_fleetReversal_titleAtribute_suffix;//=/span[contains(@class,"reversal")]@title
    private String slots_fleetReversal_button_suffix;
    private String slots_fleetTargetPlanet_suffix;//=/span[@class="destinationData"]//a
    private String slots_fleetComeBack_suffix;//=/span[contains(@id,"timerNext_")]
    private String slots_fleetComeBack_titleAtribute_suffix;//=/span[contains(@id,"timerNext_")]@title
    private HashMap<String, String> slots_missionMap;
    private String slots_parseArrival;//='|'dd.MM.yyyy HH:mm:ss
    private String slots_parseReversal;//='Zawróć:|' dd.MM.yyyy'<br>'HH:mm:ss
    private String slots_parseReturn;//='|'dd.MM.yyyy HH:mm:ss
}
