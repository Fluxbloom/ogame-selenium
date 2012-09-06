/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElementsUnchecked;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author dyschemist
 */
public class Coords {
    private int universe;
    private int system;
    private int position;
    private CoordsProperties properties;
    private Destination dest;

    public Destination getDest() {
        return dest;
    }

    public void setDest(Destination dest) {
        this.dest = dest;
    }

    public int getPosition() {
        return position;
    }
    public String getSPosition() {
        return Integer.toString(position);
    }

    public void setPosition(String position) {
        int i;
        i=Integer.parseInt(position);
        this.position = Math.max(1, Math.min(properties.getPositions(), i));     
    }
    public void setPosition(int position){
        this.position = Math.max(1, Math.min(properties.getPositions(), position));
    }

    public int getSystem() {
        return system;
    }
    
    public String getSSystem() {
        return Integer.toString(system);
    }

    public void setSystem(String system) {
        int i;
        i=Integer.parseInt(system);
        this.position = Math.max(1, Math.min(properties.getSystems(), i));
    }
    
        public void setSystem(int system) {
        this.position = Math.max(1, Math.min(properties.getSystems(), system));
    }

    public int getUniverse() {
        return universe;
    }

    public String getSUniverse() {
        return Integer.toString(universe);
    }
    
    public void setUniverse(String universe) {
        int i;
        i=Integer.parseInt(universe);
        this.position =Math.max(1, Math.min(properties.getUniverses(), i));
    }
    
    public void setUniverse(int universe) {
        this.position =Math.max(1, Math.min(properties.getUniverses(), universe));
    }
    public Coords(int uni,int sys, int pos,Destination dest){
        this.universe=uni;
        this.system=sys;
        this.position=pos;
        this.dest=dest;
    }
    
    public Coords(String uni,String sys, String pos){
        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos),Coords.PLANET);
    }
    
    public Coords(String uni,String sys, String pos,Destination dest){
        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos),dest);
    }
    
    public Coords(int uni,int sys, int pos){
        this(uni,sys,pos,Coords.PLANET);
    }
    

    
//    public Coords(Planet p){
//        this(p,Destination.PLANET);
//    }
    
//    public Coords(Planet p , Destination dest){
//        this.universe = Integer.toString(p.getUni());
//        this.system = Integer.toString(p.getSys());
//        this.position = Integer.toString(p.getPos());
//        this.dest=dest;
//    }

    public boolean isExploreable(){
        boolean result = false;
        for (int i=0; i<properties.getExplorePos().length;i++){
            if(this.position==properties.getExplorePos()[i]){
                result= true;
                break;
            }
        }
        return result;
    } 
    
    public static Coords parse(String s){
                String[] str =s.replace("[", "").replace("]", "").split(":");
        return new Coords(str[0],str[1],str[2]);
    }
    
    public static Coords[] parseArray(String[] s){
    List<Coords> list = new ArrayList<Coords>();
    for (int i=0; i< s.length; i++){
        try {
            list.add(Coords.parse(s[i]));
        } catch (Exception ex){
            
        }
    }
    Coords[] coords = new Coords[list.size()];
    for (int i=0; i< coords.length; i++){
        coords[i]= list.get(i);
    }
    return coords;
}
        
    static final public Destination PLANET = Destination.PLANET;
    static final public Destination MOON = Destination.MOON;
    static final public Destination PZ = Destination.PZ;

    @Override
    public String toString() {
        return "Coords{" + "universe=" + universe + ", system=" + system + ", position=" + position + ", dest=" + dest + '}';
    }
    
    public String shortPrint(){
        return "["+this.universe+":"+this.system+":"+this.position+"]";
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

    
    static class CoordsProperties {
    

    
    private int universes;
    private int systems;
    private int positions;
    private int[] explorePos;

    public int getPositions() {
        return positions;
    }

    public int getSystems() {
        return systems;
    }

    public int getUniverses() {
        return universes;
    }

    public int[] getExplorePos() {
            return explorePos;
        }
    
    public CoordsProperties() throws IOException {
        String path;
        Properties properties;
                Properties defaultPath = new Properties();
        defaultPath.load(new FileInputStream(
                System.getProperty("user.dir") + "/conf/defaultConfFile.properties")
                );
        path = System.getProperty("user.dir") + "/conf/"+defaultPath.getProperty("folder") +"/cords.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        universes=Integer.parseInt(properties.getProperty("universes"));
        systems=Integer.parseInt(properties.getProperty("systems"));
        positions=Integer.parseInt(properties.getProperty("positions"));
        String[] exploreString = properties.getProperty("explore_posiions").split(";");
        explorePos = new int[exploreString.length];
        for (int i=0; i<explorePos.length;i++){
            explorePos[i]=Integer.parseInt(exploreString[i]);
        }
    }
    }  
    
}
