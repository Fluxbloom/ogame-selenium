/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
    @Ignore
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
    @Test 
    @Ignore
    public void slotsCountTest() throws OgameElementNotFoundException, OgameException{
                o.start();
        o.login(uni, nick, pass);
        int slotsTotal = o.getSlotsTotal(),
            slotsOcc = o.getSlotsOccupied(),
            expTotal = o.getExpeditionsTotal(),
            expOcc = o.getExpeditionsOccupied();
                o.logout();
        o.stop();
        System.out.println("Slots "+slotsOcc+"/"+slotsTotal+" ; "+expOcc+"/"+expTotal);
    }
    
    @Test
    public void sendTest() throws OgameException {
        o.start();
        o.login(uni, nick, pass);
        Moon nelliel = new Moon(new Coords(2,158,7,Destination.MOON),"Nelliel");
        Planet videl = new Planet( new Coords(2,158,7),"Videl",nelliel);
        Fleet fleet = new Fleet();
        fleet.add(Ships.BOMB, 1);
        o.sendFleet(videl, fleet, videl.getMoon().getCoords(), Speed.S10, Mission.STATION, Resources.NO_RESOURCES);
        o.logout();
        o.stop();
    }
}
