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
 * Klasa łącząca produkty stoczni
 * @author Andrzej Prokopczyk
 */
public class FleetAndDefence {

    public FleetAndDefence() {
        this.fleetAndDefence = new HashMap<ShipyardProduct, Integer>();
    }

    public void add(ShipyardProduct s, int count) {
        if (fleetAndDefence.containsKey(s)) {
            fleetAndDefence.put(s, new Integer(count + ((Integer) fleetAndDefence.get(s)).intValue()));
        } else {
            fleetAndDefence.put(s, new Integer(count));
        }
    }

    public void add(ShipyardProduct s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(ShipyardProduct s) {
        if (fleetAndDefence.containsKey(s)) {
            return ((Integer) fleetAndDefence.get(s)).intValue();
        } else {
            return 0;
        }
    }

    public HashMap<ShipyardProduct, Integer> getFleet() {
        return fleetAndDefence;
    }
    
    @Override
    public String toString() {
        String fleetString = "Fleet{";

        Set<Map.Entry<ShipyardProduct, Integer>> set = this.fleetAndDefence.entrySet();
        Iterator<Map.Entry<ShipyardProduct, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<ShipyardProduct, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
            }
            temp = it.next();
            fleetString += temp.getKey().name + "-" + (temp.getValue().intValue() == Ships.ALL ? "All " : temp.getValue().intValue());
        }
        return fleetString + '}';
    }
    HashMap<ShipyardProduct, Integer> fleetAndDefence;
}
