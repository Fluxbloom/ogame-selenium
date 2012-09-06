/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author dyschemist
 */
public class PropertiesEvents extends MappingProperties {

    public PropertiesEvents() throws FileNotFoundException, IOException {
        load("event.properties");
        init();
    }
    private void init(){
        event_list_root = properties.getProperty("event_list_root");//table[@id="eventContent"]/tbody/tr
        event_list_flight = properties.getProperty("event_list_flight");//table[@id="eventContent"]/tbody/tr[%i]
        event_list_id_atribute=properties.getProperty("event_list_id_atribute");
event_list_id_atribute_prefix=properties.getProperty("event_list_id_atribute_prefix");
        event_list_class_atribute = properties.getProperty("event_list_class_atribute");//table[@id="eventContent"]/tbody/tr[%i]@class
        event_list_class_atribute_enemy_alliance = properties.getProperty("event_list_class_atribute_enemy_alliance");//allianceAttack
        event_list_class_atribute_friendly = properties.getProperty("event_list_class_atribute_friendly");//eventFleet
        event_list_class_atribute_friendly_return = properties.getProperty("event_list_class_atribute_friendly_return");//eventFleet odd
        event_list_atribute_count_down_time = properties.getProperty("event_list_atribute_count_down_time");///td[contains(@class,"countDown")]
        event_list_atribute_is_friendly = properties.getProperty("event_list_atribute_is_friendly");///td[contains(@class,"friendly")]
        event_list_atribute_is_neutral = properties.getProperty("event_list_atribute_is_neutral");///td[contains(@class,"neutral")]
        event_list_atribute_is_enemy = properties.getProperty("event_list_atribute_is_enemy");///td[contains(@class,"hostile")]
        event_list_atribute_is_spy = properties.getProperty("event_list_atribute_is_spy");///td[@class="missionFleet"]/img[contains(@title,"Szpieguj")]
        event_list_atribute_is_attack = properties.getProperty("event_list_atribute_is_attack");///td[@class="missionFleet"]/img[contains(@title,"Atakuj")]
        event_list_atribute_arrival_time = properties.getProperty("event_list_atribute_arrival_time");///td[@class="arrivalTime"]
        event_list_atribute_originFleet = properties.getProperty("event_list_atribute_originFleet");///td[@class="originFleet"]
        event_list_atribute_originCoords = properties.getProperty("event_list_atribute_originCoords");///td[@class="coordsOrigin"]/a
        event_list_atribute_detailsFleet = properties.getProperty("event_list_atribute_detailsFleet");///td[@class="detailsFleet"]/span
        event_list_atribute_destFleet = properties.getProperty("event_list_atribute_destFleet");///td[@class="destFleet"]
        event_list_atribute_destCoords = properties.getProperty("event_list_atribute_destCoords");///td[@class="destCoords"]/a
        event_list_atribute_icon_movement = properties.getProperty("event_list_atribute_icon_movement");
        
        
        event_list_time_parser_day = properties.getProperty("event_list_time_parser_day");
        event_list_time_parser_hour = properties.getProperty("event_list_time_parser_hour");
        event_list_time_parser_minute = properties.getProperty("event_list_time_parser_minute");
        event_list_time_parser_second = properties.getProperty("event_list_time_parser_second");
        event_list_time_parser_ingore = properties.getProperty("event_list_time_parser_ingore"); 
    }
    
     public String getEvent_list_atribute_icon_movement() {
        return event_list_atribute_icon_movement;
    }

    public String getEvent_list_time_parser_ingore() {
        return event_list_time_parser_ingore;
    }

    public String getEvent_list_time_parser_day() {
        return event_list_time_parser_day;
    }

    public String getEvent_list_time_parser_hour() {
        return event_list_time_parser_hour;
    }

    public String getEvent_list_time_parser_minute() {
        return event_list_time_parser_minute;
    }

    public String getEvent_list_time_parser_second() {
        return event_list_time_parser_second;
    }

    public String getEvent_list_atribute_is_attack() {
        return event_list_atribute_is_attack;
    }

    public String getEvent_list_atribute_is_enemy() {
        return event_list_atribute_is_enemy;
    }

    public String getEvent_list_atribute_is_spy() {
        return event_list_atribute_is_spy;
    }

    public String getEvent_list_atribute_arrival_time() {
        return event_list_atribute_arrival_time;
    }

    public String getEvent_list_atribute_count_down_time() {
        return event_list_atribute_count_down_time;
    }

    public String getEvent_list_atribute_destCoords() {
        return event_list_atribute_destCoords;
    }

    public String getEvent_list_atribute_destFleet() {
        return event_list_atribute_destFleet;
    }

    public String getEvent_list_atribute_detailsFleet() {
        return event_list_atribute_detailsFleet;
    }

    public String getEvent_list_atribute_is_friendly() {
        return event_list_atribute_is_friendly;
    }

    public String getEvent_list_atribute_is_neutral() {
        return event_list_atribute_is_neutral;
    }

    public String getEvent_list_atribute_originCoords() {
        return event_list_atribute_originCoords;
    }

    public String getEvent_list_atribute_originFleet() {
        return event_list_atribute_originFleet;
    }

    public String getEvent_list_class_atribute() {
        return event_list_class_atribute;
    }

    public String getEvent_list_class_atribute_enemy_alliance() {
        return event_list_class_atribute_enemy_alliance;
    }

    public String getEvent_list_class_atribute_friendly() {
        return event_list_class_atribute_friendly;
    }

    public String getEvent_list_class_atribute_friendly_return() {
        return event_list_class_atribute_friendly_return;
    }

    public String getEvent_list_id_atribute() {
        return event_list_id_atribute;
    }

    public String getEvent_list_id_atribute_prefix() {
        return event_list_id_atribute_prefix;
    }

    public String getEvent_list_flight(int i) {
        return event_list_flight.replace("%i", Integer.toString(i));
    }

    public String getEvent_list_root() {
        return event_list_root;
    }
    
    
    
    private String event_list_root;//=//table[@id="eventContent"]/tbody/tr
    private String event_list_flight;//=//table[@id="eventContent"]/tbody/tr[%i]
    private String event_list_id_atribute;//=@id
    private String event_list_id_atribute_prefix;//=eventRow-
    private String event_list_class_atribute;//=//table[@id="eventContent"]/tbody/tr[%i]@class
    private String event_list_class_atribute_enemy_alliance;//=allianceAttack
    private String event_list_class_atribute_friendly;//=eventFleet
    private String event_list_class_atribute_friendly_return;//=eventFleet odd
    private String event_list_atribute_count_down_time;//=/td[contains(@class,"countDown")]
    private String event_list_atribute_is_friendly;//=/td[contains(@class,"friendly")]
    private String event_list_atribute_is_neutral;//=/td[contains(@class,"neutral")]
    private String event_list_atribute_is_enemy;//=/td[contains(@class,"hostile")]
    private String event_list_atribute_is_spy;//=/td[@class="missionFleet"]/img[contains(@title,"Szpieguj")]
    private String event_list_atribute_is_attack;//=/td[@class="missionFleet"]/img[contains(@title,"Atakuj")]
    private String event_list_atribute_arrival_time;//=/td[@class="arrivalTime"]
    private String event_list_atribute_originFleet;//=/td[@class="originFleet"]
    private String event_list_atribute_originCoords;//=/td[@class="coordsOrigin"]/a
    private String event_list_atribute_detailsFleet;//=/td[@class="detailsFleet"]/span
    private String event_list_atribute_destFleet;//=/td[@class="destFleet"]
    private String event_list_atribute_destCoords;//=/td[@class="destCoords"]/a
    private String event_list_atribute_icon_movement;
    private String event_list_time_parser_day;//=c
    private String event_list_time_parser_hour;//=g
    private String event_list_time_parser_minute;//=min.
    private String event_list_time_parser_second;//=sek.
    private String event_list_time_parser_ingore;

}
