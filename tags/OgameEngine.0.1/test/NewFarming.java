/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Buildings;
import OgameElements.Coords;
import OgameElements.TimePeriod;
import OgameElements.Fleet;
import OgameElements.Mission;
import OgameElements.Planet;
import OgameElements.Ships;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import OgameToolBox.Farmer;
import OgameToolBox.PlanetElement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class NewFarming extends OgameTest {

    public NewFarming() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void farm() throws OgameException {

        Coords[] cNami = Coords.parseArray(new String[]{
            "2:62:5","2:59:11","2:57:4","2:56:12","2:56:11","2:54:8","2:54:6","2:52:6","2:50:12","2:50:11","2:50:8","2:49:7","2:48:8","2:47:4",
            "2:46:5","2:45:6"
                });
        Coords[] cAisha = Coords.parseArray(new String[]{
                    "2:119:4","2:118:12","2:118:5","2:116:12","2:116:4","2:115:7","2:115:6","2:113:6","2:112:6","2:112:4","2:109:11","2:107:12",
                    "2:105:7","2:97:4","2:97:6","2:97:11","2:103:8"
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
                    "2:171:4","2:170:6","2:170:4","2:169:12","2:169:11","2:169:9","2:168:10","2:163:6","2:168:5","2:161:12","2:157:7",
                    "2:151:4","2:146:10"
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
           "2:212:12","2:211:6","2:205:12","2:196:12","2:193:6"
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
         "2:257:10","2:254:10","2:251:12","2:251:11","2:251:6","2:250:12","2:250:11","2:250:3","2:249:12","2:247:4","2:241:6","2:235:9",
         "2:234:5"
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
                "3:44:9","3:38:12","3:38:11","3:38:9","3:38:7","3:32:10","3:32:5","3:31:13","3:30:11","3:29:9","3:28:8","3:26:6","3:25:7",
        "3:20:12"});
        
        Coords[] cErza = Coords.parseArray(new String[]{
             "4:347:4","4:346:10","4:340:12","4:340:8"
        });
        Fleet fs = new Fleet(), farming = new Fleet(),exp = new Fleet();
        fs.add(Ships.LM, Ships.ALL);
        fs.add(Ships.MT, Ships.ALL);
        fs.add(Ships.KR, Ships.ALL);
        fs.add(Ships.OW, Ships.ALL);
        fs.add(Ships.PAN, Ships.ALL);
        farming.add(Ships.MT, 5);
        exp.add(Ships.DT, 100);
        PlanetElement aisha = new PlanetElement(new Planet(new Coords(2, 106, 6), "Aisha"), fs, 1);
        PlanetElement videl = new PlanetElement(new Planet(new Coords(2, 158, 7), "Videl"), fs, 1);
        PlanetElement hinata = new PlanetElement(new Planet(new Coords(2, 199, 7), "Hinata"), fs, 1);
        PlanetElement tatsuki = new PlanetElement(new Planet(new Coords(2, 244, 7), "Tatsuki"), fs, 1);
        PlanetElement nami = new PlanetElement(new Planet(new Coords(2, 57, 11), "Nami"), fs, 1);
        PlanetElement hotaru = new PlanetElement(new Planet(new Coords(3,33,5),"Hotaru"),fs,1);
        PlanetElement erza = new PlanetElement(new Planet(new Coords(4,344,8),"Erza"),fs,1);
        Farmer f = new Farmer(aisha); // ustawiamy na planete z sondami + 1 wolny slot zostawiamy
        f.setStationarySonds(true);
        f.add(aisha, cAisha, farming);
        f.add(videl, cVidel, farming);
        f.add(hinata, cHinata, farming);
        f.add(tatsuki, cTatsuki, farming);
        f.add(nami, cNami, farming);
        f.add(hotaru, cHotaru,farming);
        f.add(erza, cErza, farming);
        TimePeriod await = new TimePeriod(0, 10, 0);
        //o.wait(59, 0);
        while (true) {
            try {
                await = new TimePeriod(0, 10, 0);
                o.start();
                o.login(uni, nick, pass);
                await = f.scanAndFarm(o);
            } catch (OgameException ex) {
                System.err.println(ex.getMessage());
            } finally {
                try {
                    o.logout();
                } finally {
                    o.stop();
                    o.wait(await);
                }

            }
            
        }

    }
}
