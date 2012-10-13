/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;

/**
 *
 * @author andrzej
 */
public interface ISim {
    abstract public void stop();
    abstract public void start();
    public abstract BattleResult sim(Fleet f1,FleetAndDefence f2);
    
}
