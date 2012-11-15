/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author seba
 */
public class MilitaryTech {
     public MilitaryTech() {
        this.research = new HashMap<ResearchingArea, Integer>();
    }

    public void add(ResearchingArea s, int count) {
        if (research.containsKey(s)) {
            research.put(s, new Integer(count + ((Integer) research.get(s)).intValue()));
        } else {
            research.put(s, new Integer(count));
        }
    }


    public void add(ResearchingArea s, String str) {
        add(s, Integer.parseInt(str));
    }


    public int get(ResearchingArea s) {
        if (research.containsKey(s)) {
            return ((Integer) research.get(s)).intValue();
        } else {
            return 0;
        }
    }


    public HashMap<ResearchingArea, Integer> getTech() {
        return research;
    }

    @Override
    public String toString() {
        String researchString = "Research{";

        Set<Map.Entry<ResearchingArea, Integer>> set = this.research.entrySet();
        Iterator<Map.Entry<ResearchingArea, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<ResearchingArea, Integer> temp; it.hasNext();) {
            if (!first) {
                researchString += ";";
            }
            temp = it.next();
            researchString += temp.getKey().name + "-" + (temp.getValue().intValue() == Ships.ALL ? "All " : temp.getValue().intValue());
        }
        return researchString + '}';
    }
    private HashMap<ResearchingArea, Integer> research;
}
