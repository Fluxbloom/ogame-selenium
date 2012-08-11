/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.util.HashMap;

/**
 *
 * @author dyschemist
 */
public class Fleet {

    private HashMap<Ships,Integer> fleet;// = new int[13];

    public Fleet() {
        fleet= new HashMap();
    }
    
    public void add(Ships s,int count){
            if (fleet.containsKey(s)){
               fleet.put(s,new Integer(count+( (Integer) fleet.get(s)).intValue()));
            }
            else {
               fleet.put(s, new Integer(count));
            }
    }
    public void add(Ships s,String str){
        add(s,Integer.parseInt(str));
    }
    
    public int get(Ships s){
       if (fleet.containsKey(s))
                return ((Integer) fleet.get(s)).intValue();
       else return 0;      
    }

    public HashMap<Ships, Integer> getFleet() {
        return fleet;
    }
    
    public static final Fleet WHOLE_FLEET = new Fleet();

    public boolean isEmpty(){
        return fleet.isEmpty();
    }
    
    public final static class Ships extends ShipyardShips {
    
    private Ships(String name){
        super(name);
    }
    public static final Ships LM = new Ships("LM");//1
    public static final Ships CM = new Ships("CM");//2
    public static final Ships KR = new Ships("KR");//3
    public static final Ships OW = new Ships("OW");//4
    public static final Ships PAN= new Ships("PAN");//5
    public static final Ships BOMB = new Ships("BOMB");//6
    public static final Ships NISZ = new Ships("NISZ");//7
    public static final Ships GS = new Ships("GS");//8
    public static final Ships MT = new Ships("MT");//9
    public static final Ships DT= new Ships("DT");//10
    public static final Ships KOL = new Ships("KOL");//11
    public static final Ships REC = new Ships("REC");//12
    public static final Ships SOND = new Ships("SS");//13
}
    
    public static class  ShipyardShips {
    private String name;
    protected ShipyardShips(String name){this.name=name;}
    

    public static final ShipyardShips SAT = new ShipyardShips("SAT");
    
}
}
