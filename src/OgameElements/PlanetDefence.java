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
 * @author dyschemist
 */
public class PlanetDefence {
      public PlanetDefence() {
        this.fleetAndDefence = new HashMap<Defence, Integer>();
    }

    public void add(Defence s, int count) {
        if (fleetAndDefence.containsKey(s)) {
            fleetAndDefence.put(s, new Integer(count + ((Integer) fleetAndDefence.get(s)).intValue()));
        } else {
            fleetAndDefence.put(s, new Integer(count));
        }
    }
    

    public void add(Defence s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(Defence s) {
        if (fleetAndDefence.containsKey(s)) {
            return ((Integer) fleetAndDefence.get(s)).intValue();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String fleetString = "Fleet{";

        Set<Map.Entry<Defence, Integer>> set = this.fleetAndDefence.entrySet();
        Iterator<Map.Entry<Defence, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<Defence, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
            }
            temp = it.next();
            fleetString += temp.getKey().name + "-" + (temp.getValue().intValue() == Ships.ALL ? "All " : temp.getValue().intValue());
        }
        return fleetString + '}';
    }
    HashMap<Defence, Integer> fleetAndDefence;
}
