/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.Planet;
import java.util.Calendar;

/**
 * Represents the objects presented at second fleet view. Each object correspond
 * to one fleet send by its owner
 * @author dyschemist
 */
public class Slots {
    private String id;
    private Calendar targetTime;
    private Planet cel;
    private Calendar returnTime;
    private Planet powrot;
    private String allianceName;

    public Slots(String id, Calendar targetTime, Planet cel, Calendar returnTime, Planet powrot, String allianceName) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.returnTime = returnTime;
        this.powrot = powrot;
        this.allianceName = allianceName;
    }

    public Slots(String id, Calendar targetTime, Planet cel, Calendar returnTime, Planet powrot) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.returnTime = returnTime;
        this.powrot = powrot;
        this.allianceName = "";
    }

    public Slots(String id, Calendar targetTime, Planet cel, String allianceName) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.allianceName = allianceName;
        this.returnTime = null;
        this.powrot = null;
    }

    public Slots(String id, Calendar targetTime, Planet cel) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.returnTime = null;
        this.powrot = null;
        this.allianceName = "";
    }

    public String getAllianceName() {
        return allianceName;
    }

    public Planet getCel() {
        return cel;
    }

    public String getId() {
        return id;
    }

    public Planet getPowrot() {
        return powrot;
    }

    public Calendar getReturnTime() {
        return returnTime;
    }

    public Calendar getTargetTime() {
        return targetTime;
    }
    
    
    
    
}
