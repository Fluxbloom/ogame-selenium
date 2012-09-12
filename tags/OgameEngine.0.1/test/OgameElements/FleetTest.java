/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.Ships;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Piotr Kowalski
 */
public class FleetTest extends OgameTest{
    
    public FleetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Test
    public void arrivelTimeTest() throws OgameException{
        o.start();
        o.login(uni, nick, pass);
        Fleet f = new Fleet();
        f.add(Ships.LM, 1);
        Planet aisha = new Planet(new Coords(2,106,6),"Aisha");
        Planet videl = new Planet(new Coords(2,158,7),"Videl");
        ArrivalTime at = o.sendFleet(f, videl.getCoords(), Mission.STATION);
        System.out.println("Time   "+at.getArrivalTime().getFormattedTimeString());
        System.out.println("Period "+at.getFlyingTime().getFormattedTimeString());
        at = o.sendFleet(f, videl.getCoords(), Mission.TRANSPORT);
        System.out.println("Time   "+at.getArrivalTime().getFormattedTimeString());
        System.out.println("Period "+at.getFlyingTime().getFormattedTimeString());
        o.logout();
        o.stop();
    }
    
}
