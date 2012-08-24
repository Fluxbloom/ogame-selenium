/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.Destination;
import OgameEngine.Fleet.Ships;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class SeleniumStartTest {

    Ogame o;
    TestProperties prop;
    String uni;
    String nick;
    String pass;

    public SeleniumStartTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws IOException {
        o = Ogame.ogameFabric("116", "pl");
        prop = new TestProperties();
        uni = prop.getUniverse();
        nick = prop.getNick();
        pass = prop.getPass();
    }

    @After
    public void tearDown() {
    }

    @Test
    @Ignore
    public void PropertiesTest() {
        System.out.println("Properties test");
        System.out.println(prop.toString());
    }

    @Test
    @Ignore
    public void SeleniumStartTest() throws OgameException {

        o.login(uni, nick, pass);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.logout();
    }

    @Test
    @Ignore
    public void TrySendingFleet() throws OgameException {
        o.login(uni, nick, pass);
        Fleet f = new Fleet();
        f.add(Ships.SOND, 2);
        o.sendFleet(f, new Coords("2", "243", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.logout();
    }

    @Test
    @Ignore
    public void BuildMM() throws OgameException {
        o.login(uni, nick, pass);
        o.build(Buildings.MAGAZYN_METALU);
        o.wait(10);
    }

    
@Test
@Ignore
public void startFleet() throws OgameException{
    o.login(uni, nick, pass);
    o.changePlanetByCoords(new Coords(2,158,7));
    o.sendFleet(Fleet.WHOLE_FLEET, new Coords(2,158,8),Speed.S10, Mission.MISSION_TRANSPORT, Resources.ALL_RESOURCES);
    o.logout();
}    

    
    @Test
    @Ignore
    public void farming() throws OgameException {
        o.login(uni, nick, pass);
        Fleet farmiaca = new Fleet();
        farmiaca.add(Ships.MT, 1);
        Fleet recki = new Fleet();
        recki.add(Ships.REC, 2);
        Fleet fs = Fleet.WHOLE_FLEET;
        Coords[] pz = new Coords[]{
            new Coords(2, 100, 4, Destination.PZ),
            new Coords(2, 102, 10, Destination.PZ),
            new Coords(2, 107, 8, Destination.PZ),
            new Coords(2, 108, 8, Destination.PZ),
            new Coords(2, 108, 12, Destination.PZ)
        };
        Coords[] farms = new Coords[]{
            new Coords(2, 114, 8),
            new Coords(2, 112, 8),
            new Coords(2, 110, 6),
            new Coords(2, 109, 10),
            new Coords(2, 109, 8)
        };
        Coords[] hinataFarms = new Coords[]{
            new Coords(2, 107, 8)
        };

        int aisha_fleets = 4;
        int hinata_fleets = 1;
        int pz_fleets = 1;
        o.changePlanetByName("Aisha");
        for (int i = 0; i < pz_fleets; i++) {
            try {
                o.sendFleet(recki, pz[i], Speed.S100, Mission.MISSION_RECYCLE, Resources.NO_RESOURCES);
                aisha_fleets--;
            } catch (OgameException ex) {
                Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        o.changePlanetByName("Hinata");
        for (int i = 0; i < hinata_fleets - 1; i++) {
            o.sendFleet(fs, hinataFarms[i], Speed.S100, Mission.MISSION_ATTACK, Resources.ALL_RESOURCES);
        }
        o.changePlanet(1);
        int i;
        for (i = 0; i < aisha_fleets; i++) {
            o.sendFleet(farmiaca, farms[i], Speed.S100, Mission.MISSION_ATTACK, Resources.NO_RESOURCES);
        }
        o.sendFleet(fs, farms[i], Speed.S100, Mission.MISSION_ATTACK, Resources.ALL_RESOURCES);
        o.logout();
    }
    
    @Test
    @Ignore
    public void TrySpyLeftFarm() throws OgameException {
        o.login(uni, nick, pass);
        o.changePlanetByName("Braavos");
        Fleet f = new Fleet();
        f.add(Ships.SOND, 2);
        /*
        //Pentos
        o.sendFleet(f, new Coords("2", "196", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "196", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "196", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "203", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "202", "7"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "196", "9"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "200", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "200", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "198", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "198", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.wait(170);
        //Valyria
        o.sendFleet(f, new Coords("2", "244", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "243", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "238", "5"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "237", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "234", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "233", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "233", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "233", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        //o.sendFleet(f, new Coords("2", "231", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "229", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.wait(160);
        */
        //Braavos
        o.sendFleet(f, new Coords("2", "298", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "297", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "297", "5"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "296", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "295", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "294", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "294", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "293", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "293", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "292", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.wait(110);
        //Voltanis
        o.sendFleet(f, new Coords("2", "346", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "346", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "345", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "344", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "339", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "344", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "338", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "341", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "340", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "340", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        
        o.logout();
    }
    
    @Test
    @Ignore
    public void TrySpyRightFarm() throws OgameException {
        o.login(uni, nick, pass);
        o.changePlanetByName("Braavos");
        Fleet f = new Fleet();
        f.add(Ships.SOND, 2);
        //Pentos
        /*/o.sendFleet(f, new Coords("2", "215", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        //o.sendFleet(f, new Coords("2", "215", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        //o.sendFleet(f, new Coords("2", "210", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "208", "9"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "208", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "209", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "209", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "210", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "212", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "212", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.wait(170);
        //Valyria
        o.sendFleet(f, new Coords("2", "261", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "245", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "253", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "253", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "255", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "255", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
       //o.sendFleet(f, new Coords("2", "258", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "260", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "261", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "250", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.wait(160);
        //Braavos
        o.sendFleet(f, new Coords("2", "301", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        //o.sendFleet(f, new Coords("2", "300", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "303", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "303", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        //o.sendFleet(f, new Coords("2", "304", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "306", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "313", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "313", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        //o.sendFleet(f, new Coords("2", "313", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "314", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.wait(110);
        //Voltanis
        */o.sendFleet(f, new Coords("2", "350", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "350", "8"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "352", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "353", "10"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "354", "6"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "354", "9"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "352", "7"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "354", "12"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "352", "7"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.sendFleet(f, new Coords("2", "359", "4"), Speed.S100, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        
        o.logout();
    }
}
