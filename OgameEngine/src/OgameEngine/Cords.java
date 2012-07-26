/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class Cords {
    private String universe;
    private String system;
    private String position;
    private CordsProperties properties;
    private Destination dest;

    public Destination getDest() {
        return dest;
    }

    public void setDest(Destination dest) {
        this.dest = dest;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        int i;
        i=Integer.parseInt(position);
        this.position = Integer.toString(Math.max(1, Math.min(properties.getPositions(), i)));     
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        int i;
        i=Integer.parseInt(system);
        this.position = Integer.toString(Math.max(1, Math.min(properties.getSystems(), i)));
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        int i;
        i=Integer.parseInt(system);
        this.position = Integer.toString(Math.max(1, Math.min(properties.getUniverses(), i)));
    }
    
    public Cords(String uni,String sys, String pos){
        this.universe=uni;
        this.system=sys;
        this.position=pos;
        this.dest=Cords.PLANET;
    }
    
    public Cords(String uni,String sys, String pos,Destination dest){
        this.universe=uni;
        this.system=sys;
        this.position=pos;
        this.dest=dest;
    }

    
    static final public Destination PLANET = Destination.PLANET;
    static final public Destination MOON = Destination.MOON;
    static final public Destination PZ = Destination.PZ;
}
