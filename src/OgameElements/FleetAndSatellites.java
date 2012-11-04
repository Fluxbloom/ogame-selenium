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
public class FleetAndSatellites {
    public FleetAndSatellites() {
        this.fleetAndDefence = new HashMap<ShipyardShips, Integer>();
    }

    public void add(ShipyardShips s, int count) {
        if (fleetAndDefence.containsKey(s)) {
            fleetAndDefence.put(s, new Integer(count + ((Integer) fleetAndDefence.get(s)).intValue()));
        } else {
            fleetAndDefence.put(s, new Integer(count));
        }
    }

    public void add(ShipyardShips s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(ShipyardShips s) {
        if (fleetAndDefence.containsKey(s)) {
            return ((Integer) fleetAndDefence.get(s)).intValue();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String fleetString = "Fleet{";

        Set<Map.Entry<ShipyardShips, Integer>> set = this.fleetAndDefence.entrySet();
        Iterator<Map.Entry<ShipyardShips, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<ShipyardShips, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
            }
            temp = it.next();
            fleetString += temp.getKey().name + "-" + (temp.getValue().intValue() == Ships.ALL ? "All " : temp.getValue().intValue());
        }
        return fleetString + '}';
    }
    HashMap<ShipyardShips, Integer> fleetAndDefence;
}
