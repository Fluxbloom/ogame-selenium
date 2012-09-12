/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameElementsUnchecked.PlanetResources;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Ogame;
import OgameEngine.OgameTest;
import OgameEngine.TestProperties;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testy dla budynków
 * @author Piotr Kowalski
 */
public class BuildingsTest extends OgameTest{

    public BuildingsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void isMoonBuildingTest() {
        Buildings b = Buildings.MOON_FALANG;
        System.out.println(b.isMoonBuilding());
        b = Buildings.LABORATORY;
        System.out.println(b.isMoonBuilding());
    }

    @Test
    public void getBuildingPrice() throws OgameException {
        o.start();
        o.login(prop.getUniverse(), prop.getNick(), prop.getPass());
        PlanetResources cost = o.getCost(Buildings.METAL_MINE);
        System.out.println(cost);
        o.logout();
        o.stop();
    }

    @Test
    public void getBuildingTime() throws OgameException {
        o.start();
        o.login(prop.getUniverse(), prop.getNick(), prop.getPass());
        TimePeriod c = o.getProductionTime(Buildings.METAL_MINE);
        
        o.logout();
        o.stop();
    }

    
    

    

    
}
