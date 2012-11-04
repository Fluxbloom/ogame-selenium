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
        this.militaryTech=new HashMap<ResearchingArea, Integer>();
        
    }
    public void add(ResearchingArea tech, int level)
    {
        if (militaryTech.containsKey(tech)) {
           militaryTech.put(tech, new Integer(level + ((Integer) militaryTech.get(tech)).intValue()));
        } else {
            militaryTech.put(tech, new Integer(level));
        }
    }
    public void add(ResearchingArea tech, String level)
    {
        add(tech, Integer.parseInt(level));
    }
    public int get(ResearchingArea tech)
    {
        if(militaryTech.containsKey(tech)) {
            return ((Integer)militaryTech.get(tech).intValue());
        }
        else {
            return 0;
        }
    }
    public HashMap<ResearchingArea, Integer> getTech()
    {
        return militaryTech;
    }
    
    private HashMap<ResearchingArea, Integer> militaryTech;
    
}
