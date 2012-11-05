/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.HashMap;

/**
 *
 * @author andrzej
 */
public class MilitaryTech {
    public MilitaryTech()
    {
        this.militaryTech=new HashMap<Technology, Integer>();
        
    }
    public void add(Technology tech, int level)
    {
        if (militaryTech.containsKey(tech)) {
           militaryTech.put(tech, new Integer(level + ((Integer) militaryTech.get(tech)).intValue()));
        } else {
            militaryTech.put(tech, new Integer(level));
        }
    }
    public void add(Technology tech, String level)
    {
        add(tech, Integer.parseInt(level));
    }
    public int get(Technology tech)
    {
        if(militaryTech.containsKey(tech)) {
            return ((Integer)militaryTech.get(tech).intValue());
        }
        else {
            return 0;
        }
    }
    public HashMap<Technology, Integer> getTech()
    {
        return militaryTech;
    }
    
    private HashMap<Technology, Integer> militaryTech;
    
}
