/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Flights;
import OgameEngine.Ogame;
import OgameEngine.Slots;
import java.util.List;

/**
 *
 * @author dyschemist
 */
public interface AttackResponse {
    abstract public void response(Ogame o,List<Flights> attackList, List<Slots> autoFleet);
}
