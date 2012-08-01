/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.Planet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author dyschemist
 */
public class Flights {
    
    private FriendOrFoe type;
    private Multiplicity attackType;
    private Calendar arrivalTime;
    /**
     * Uwaga, floty ACS w ataku nie posiadają pola origin
     */
    private Planet origin;
    private int fleetSize;
    private Planet dest;

    public Flights(FriendOrFoe type, Multiplicity attackType, Calendar arrivalTime,
            Planet origin, int fleetSize, Planet dest) {
        this.type = type;
        this.attackType = attackType;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
        this.fleetSize = fleetSize;
        this.dest = dest;
    }
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
    @Override
    public String toString() {
        
        return "Flights{" + "type=" + type.toString() + ", attackType=" + attackType.toString() +
                ", arrivalTime=" + sdf.format(arrivalTime.getTime()) + ", origin=" +
                (origin==null?"ACS COORDS":origin.toString()) + 
                ", fleetSize=" + Integer.toString(fleetSize) + ", dest=" + dest.toString() + '}';
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
