/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.lang.model.element.Element;

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

    @Override
    public String toString() {
        String fleetString ="Fleet{";
        if (this==Fleet.WHOLE_FLEET) return "Fleet{Whole}";
        Set<Entry<Ships,Integer>> set = this.fleet.entrySet();
        Iterator<Entry<Ships,Integer>> it = set.iterator();
        boolean first = true;
        for (Entry<Ships,Integer> temp;it.hasNext();){
            if (!first){ 
                fleetString+=";";
                first=false;
            }
            temp = it.next();
            fleetString+=temp.getKey().name+"-"+(temp.getValue().intValue()==Ships.ALL?"All ":temp.getValue().intValue());
        }
        return fleetString + '}';
    }
    
    
    
    
    public static final Fleet WHOLE_FLEET = new Fleet();

    public boolean isEmpty(){
        return fleet.isEmpty();
    }
    
   
    
}
