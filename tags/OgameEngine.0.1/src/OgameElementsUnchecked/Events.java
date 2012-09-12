/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElementsUnchecked;

import OgameElements.Coords;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author dyschemist
 */
public class Events {
    
    private int id;
    private FriendOrFoe type;
    private Multiplicity attackType;
    private Calendar arrivalTime;
    /**
     * Uwaga, floty ACS w ataku nie posiadają pola origin
     */
    private Coords origin; //TODO zmienic planety na coords
    private int fleetSize;
    private Coords dest;
    // TODO dodać obsluge floty i zapasy

    public Events(FriendOrFoe type, Multiplicity attackType, Calendar arrivalTime,
            Coords origin, int fleetSize, Coords dest) {
        this.type = type;
        this.attackType = attackType;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.fleetSize = fleetSize;
        this.dest = dest;
    }
    
    public Events(int id,FriendOrFoe type, Multiplicity attackType, Calendar arrivalTime,
            Coords origin, int fleetSize, Coords dest) {
        this.id = id;
        this.type = type;
        this.attackType = attackType;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.fleetSize = fleetSize;
        this.dest = dest;
    }
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    @Override
    public String toString() {
        
        return "Flights{" + "id="+id+
                ", type=" + type.toString() + 
                ", attackType=" + attackType.toString() +
                ", arrivalTime=" + sdf.format(arrivalTime.getTime()) + 
                ", origin=" + (origin==null?"ACS COORDS":origin.toString()) + 
                ", fleetSize=" + Integer.toString(fleetSize) + 
                ", dest=" + dest.toString() + '}';
    }
   

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public Coords getDest() {
        return dest;
    }

    public Coords getOrigin() {
        return origin;
    }

    public FriendOrFoe getType() {
        return type;
    }

    public int getId() {
        return id;
    }
    
    
    
    
    
    public static FriendOrFoe FRIEND = new FriendOrFoe("Friend");
    public static FriendOrFoe NEUTRAL = new FriendOrFoe("Neutral");
    public static FriendOrFoe SPY = new FriendOrFoe("Spy");
    public static FriendOrFoe ATTACK = new FriendOrFoe("Attack");
    public static Multiplicity SINGLE_FLEET = new Multiplicity("Single");
    public static Multiplicity ACS_FLEET = new Multiplicity("ACS");
    
    public static class FriendOrFoe {
        String name;
        private FriendOrFoe(String name) {this.name=name;}

        @Override
        public String toString() {
            return "FriendOrFoe{" + "name=" + name + '}';
        }

        public String getName() {
            return name;
        }
        
    }
    
    public static class Multiplicity {
        String name;
        private Multiplicity(String name){this.name=name;}

        @Override
        public String toString() {
            return "Multiplicity{" + "name=" + name + '}';
        }
        
    }
}
