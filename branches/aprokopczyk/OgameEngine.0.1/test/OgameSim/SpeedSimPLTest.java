/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;
import OgameElements.Ships;
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
        FleetAndDefence f2 = new FleetAndDefence();
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
