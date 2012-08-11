/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.StartDestination;
import OgameEngine.Fleet.ShipyardShips;
import OgameEngine.Performance.Production;
import OgameEngine.Performance.ResourceField;
import com.thoughtworks.selenium.Selenium;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dyschemist
 */
public abstract class Ogame implements IOgame{
    
    protected Selenium selenium;
    public static Ogame ogameFabric(String uni,String lang){
        return new Ogame116pl();
    }

    
}
