/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Fleet;
import OgameElements.Ships;
import OgameElements.TimePeriod;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import OgameToolBox3.Farmer3;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class Farming3 extends OgameTest {

    public Farming3() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void farming() {
        Fleet fs = new Fleet();
        fs.add(Ships.LM, Ships.ALL);
        fs.add(Ships.MT, Ships.ALL);
        fs.add(Ships.KR, Ships.ALL);
        fs.add(Ships.OW, Ships.ALL);
        fs.add(Ships.PAN, Ships.ALL);
        fs.add(Ships.NISZ, Ships.ALL);
        Farmer3 farmer = new Farmer3(o, 13, fs);
        TimePeriod await = new TimePeriod(0, 10, 0);
        try {
            o.start();
            o.login(uni, nick, pass);
            farmer.initPlanets();
            o.logout();
            o.stop();
        } catch (Exception ex) {
        }
        while (true) {
            try {
                await = new TimePeriod(0, 10, 0);
                o.start();
                o.login(uni, nick, pass);

                //await = f.scanAndFarm(o);
            } catch (OgameException ex) {
                System.err.println(ex.getMessage());
            } finally {
                try {
                    o.logout();
                } catch (OgameException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    o.stop();
                    o.wait(await);
                }

            }

        }
    }
}
