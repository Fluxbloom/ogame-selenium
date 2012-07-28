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

    @Override
    public String toString() {
        return "Fleet{ LM="+this.get(Ships.LM)+" CM="+this.get(Ships.CM)+
                " KRAZ="+this.get(Ships.KR)+" OW="+this.get(Ships.OW)+
                " PANC="+this.get(Ships.PAN)+" BOMB="+this.get(Ships.BOMB)+
                " NISC="+this.get(Ships.NISZ)+" GS="+this.get(Ships.GS)+
                " MT="+this.get(Ships.MT)+" DT="+this.get(Ships.DT)+
                " SKOL="+this.get(Ships.KOL)+" REC="+this.get(Ships.REC)+
                " SS="+this.get(Ships.SOND) +'}';
    }


}
