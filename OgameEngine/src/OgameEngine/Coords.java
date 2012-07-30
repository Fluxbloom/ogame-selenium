/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author dyschemist
 */
public class Coords {
    private String universe;
    private String system;
    private String position;
    private CoordsProperties properties;
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
    
    public Coords(String uni,String sys, String pos){
        this.universe=uni;
        this.system=sys;
        this.position=pos;
        this.dest=Coords.PLANET;
    }
    
    public Coords(String uni,String sys, String pos,Destination dest){
        this.universe=uni;
        this.system=sys;
        this.position=pos;
        this.dest=dest;
    }
    
    public Coords(int uni,int sys, int pos){
        this.universe=Integer.toString(uni);
        this.system=Integer.toString(sys);
        this.position=Integer.toString(pos);
        this.dest=Coords.PLANET;
    }
    
    public Coords(int uni,int sys, int pos,Destination dest){
        this.universe=Integer.toString(uni);
        this.system=Integer.toString(sys);
        this.position=Integer.toString(pos);
        this.dest=dest;
    }

    
    static final public Destination PLANET = Destination.PLANET;
    static final public Destination MOON = Destination.MOON;
    static final public Destination PZ = Destination.PZ;

    @Override
    public String toString() {
        return "Coords{" + "universe=" + universe + ", system=" + system + ", position=" + position + ", dest=" + dest + '}';
    }

    public static class Destination {
        private String name;
    protected Destination(String name){this.name=name;}
        
    static final public StartDestination PLANET = new StartDestination("PLANET");
    static final public StartDestination MOON =  new StartDestination("MOON");
    static final public Destination PZ = new Destination("DEBRIS");

        @Override
        public String toString() {
            return "Destination{" + "name=" + name + '}';
        }
    
    
}
    
    public static class StartDestination extends Destination {
    private StartDestination(String name){super(name);}
    
}
    public static class Planet {
    
    private int uni;
    private int sys;
    private int pos;

    public Planet(int uni, int sys, int pos) {
        this.uni = uni;
        this.sys = sys;
        this.pos = pos;
    }
    public Planet(String uni, String sys, String pos) {
        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos));
    }

    @Override
    public String toString() {
        return "Planet{" + "uni=" + uni + ", sys=" + sys + ", pos=" + pos + '}';
    }  
}
    
 static class CoordsProperties {
    
    protected String path;
    protected Properties properties;
    
    private int universes;
    private int systems;
    private int positions;

    public int getPositions() {
        return positions;
    }

    public int getSystems() {
        return systems;
    }

    public int getUniverses() {
        return universes;
    }
    
    public CoordsProperties() throws IOException {
                Properties defaultPath = new Properties();
        defaultPath.load(new FileInputStream(
                System.getProperty("user.dir") + "/conf/defaultConfFile.properties")
                );
        this.path = System.getProperty("user.dir") + "/conf/"+defaultPath.getProperty("folder") +"/cords.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        universes=Integer.parseInt(properties.getProperty("universes"));
        systems=Integer.parseInt(properties.getProperty("systems"));
        positions=Integer.parseInt(properties.getProperty("positions"));
    }
}  
    
}
