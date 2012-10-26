/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;
import OgameElements.Ships;
import OgameElements.Defence;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author andrzej
 */
public class SpeedSimPLTest {

    public SpeedSimPLTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class SpeedSimPL.
     */
    @Test
    @Ignore
    public void testStart() throws FileNotFoundException, IOException {
        System.out.println("start");
        SpeedSimPL instance = new SpeedSimPL();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class SpeedSimPL.
     */
    @Test
    @Ignore
    public void testStop() throws FileNotFoundException, IOException {
        System.out.println("stop");
        SpeedSimPL instance = new SpeedSimPL();
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sim method, of class SpeedSimPL.
     */
    @Test
    public void testSim() throws FileNotFoundException, IOException {
        System.out.println("sim");
        Fleet f1 = new Fleet();
        f1.add(Ships.MT, 3);
        f1.add(Ships.DT, 4);
        f1.add(Ships.LM, 5);
        f1.add(Ships.CM, 3);
        f1.add(Ships.KR, 4);
        f1.add(Ships.OW, 5);
        f1.add(Ships.KOL, 3);
        f1.add(Ships.REC, 4);
        f1.add(Ships.SOND, 5);
        f1.add(Ships.BOMB, 3);
        f1.add(Ships.NISZ, 4);
        f1.add(Ships.GS, 5);
        f1.add(Ships.PAN, 3);
        
        FleetAndDefence f2 = new FleetAndDefence();
        f2.add(Ships.MT, 1);
        f2.add(Ships.DT, 2);
        f2.add(Ships.LM, 3);
        f2.add(Ships.CM, 4);
        f2.add(Ships.KR, 1);
        f2.add(Ships.OW, 2);
        f2.add(Ships.KOL, 3);
        f2.add(Ships.REC, 4);
        f2.add(Ships.SOND, 1);
        f2.add(Ships.BOMB, 2);
        f2.add(Ships.NISZ, 3);
        f2.add(Ships.GS, 4);
        f2.add(Ships.PAN, 1);
        f2.add(Ships.SAT,4);
        
        
        f2.add(Defence.DUZA_POWLOKA, 1);
        f2.add(Defence.DUZY_LASER, 2);
        f2.add(Defence.DZIALO_GAUSSA, 3);
        f2.add(Defence.DZIALO_JONOWE, 4);
        f2.add(Defence.MALA_POWLOKA, 1);
        f2.add(Defence.MALY_LASER, 2);
        f2.add(Defence.PRZECIWRAKIETA, 3);
        f2.add(Defence.WYRZUTNIA_PLAZMY, 4);
        f2.add(Defence.WYRZUTNIA_RAKIET,5);
        Sim instance = new SpeedSimPL();
        BattleResult expResult = null;
        instance.start();
        BattleResult result = instance.sim(f1, f2);
        //instance.stop();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
