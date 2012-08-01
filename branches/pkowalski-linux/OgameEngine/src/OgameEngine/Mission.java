/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;


/**
 *
 * @author dyschemist
 */
public class Mission {
    private String name;
    private Mission(String name){  this.name=name;}
    public static final Mission MISSION_EXPLORE =new Mission("EXPLORE");
    public static final Mission MISSION_KOLONIZE=new Mission("COLONIZE");
    public static final Mission MISSION_RECYCLE =new Mission("RECYCLE");
    public static final Mission MISSION_TRANSPORT=new Mission("TRANSPORT");
    public static final Mission MISSION_STATION=new Mission("STATION");
    public static final Mission MISSION_SPY=new Mission("SPY");
    public static final Mission MISSION_STAY=new Mission("STAY");
    public static final Mission MISSION_ATTACK=new Mission("ATTACK");
    public static final Mission MISSION_ACS=new Mission("ACS");
    public static final Mission MISSION_MOON=new Mission("MOON ATTACK");

    @Override
    public String toString() {
        return "Mission{" + "name=" + name + '}';
    }
    
}
