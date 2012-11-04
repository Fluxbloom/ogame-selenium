/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Coords;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;
import OgameElements.MilitaryTech;
import OgameElements.PropulsionTech;

/**
 *
 * @author andrzej
 */
public interface ISim {
    abstract public void stop();
    abstract public void start();
    public abstract BattleResult sim(Fleet f1,FleetAndDefence f2);
    public abstract BattleResult sim(Fleet f1,FleetAndDefence f2,MilitaryTech t1, MilitaryTech t2);
public abstract BattleResult sim(Fleet f1,FleetAndDefence f2,MilitaryTech t1, MilitaryTech t2,PropulsionTech pt,Coords origin, Coords target);
    
}
