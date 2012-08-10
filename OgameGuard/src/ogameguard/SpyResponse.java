/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Events;
import OgameEngine.Ogame;
import OgameEngine.Slots;
import java.util.List;

/**
 *
 * @author dyschemist
 */
public interface SpyResponse {
    abstract void response(Ogame o,List<Events> list, List<Slots> sloty);
}
