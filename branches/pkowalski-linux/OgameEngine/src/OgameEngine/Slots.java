/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Represents the objects presented at second fleet view. Each object correspond
 * to one fleet send by its owner
 * @author dyschemist
 */
public class Slots {
    private int id;
    private Calendar targetTime;
    private Coords cel;
    private Calendar returnTime;
    private Calendar reversalTime;
    private Coords baza;
    private String allianceName;
    private Mission mission;

    public Slots(int id, Calendar targetTime, Coords cel, Calendar returnTime, Calendar reversalTime, Coords baza, String allianceName, Mission mission) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.returnTime = returnTime;
        this.reversalTime = reversalTime;
        this.baza = baza;
        this.allianceName = allianceName;
        this.mission = mission;
    }

    public Slots(int id, Calendar targetTime, Coords cel, Coords baza, String allianceName, Mission mission) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.baza = baza;
        this.allianceName = allianceName;
        this.mission = mission;
    }

    public Slots(int id, Calendar targetTime, Coords cel, Calendar returnTime, Calendar reversalTime, Coords baza, Mission mission) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.returnTime = returnTime;
        this.reversalTime = reversalTime;
        this.baza = baza;
        this.mission = mission;
    }

    public Slots(int id, Calendar targetTime, Coords cel, Coords baza, Mission mission) {
        this.id = id;
        this.targetTime = targetTime;
        this.cel = cel;
        this.baza = baza;
        this.mission = mission;
    }

    
    
    
    public Mission getMission() {
        return mission;
    }

    public Calendar getReversalTime() {
        return reversalTime;
    }

    
    

    public String getAllianceName() {
        return allianceName;
    }

    public Coords getCel() {
        return cel;
    }

    public int getId() {
        return id;
    }

    public Coords getBaza() {
        return baza;
    }

    public Calendar getReturnTime() {
        return returnTime;
    }

    public Calendar getTargetTime() {
        return targetTime;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    public String toString() {
        return "Slots{" + "id=" + id + 
                ", targetTime=" + sdf.format(targetTime.getTime()) + 
                ", cel=" + cel + 
                ", returnTime=" + (returnTime==null?"X":sdf.format(returnTime.getTime())) + 
                ", reversalTime=" + (reversalTime==null?"X":sdf.format(reversalTime.getTime())) + 
                ", baza=" + baza + 
                ", allianceName=" + (allianceName==null?"X":allianceName) + 
                ", mission=" + mission + '}';
    }
    
    
    
    
}
