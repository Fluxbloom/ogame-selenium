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
            "2:42:5","2:43:4","2:43:6","2:45:9","2:46:9","2:46:10",
            "2:47:4","2:48:8",
            "2:50:6","2:50:7","2:50:10",
            "2:52:4","2:54:6","2:54:7","2:55:10","2:56:11","2:56:12",
            "2:58:12","2:59:11","2:61:10","2:62:6",
            "2:64:10","2:64:11","2:65:12",
            "2:67:4","2:67:7","2:67:9","2:69:7",
            "2:74:10","2:74:11"
                });
        Coords[] cAisha = Coords.parseArray(new String[]{
                    "2:91:6","2:97:4", "2:97:10","2:103:12", "2:105:7","2:105:12",
                    "2:107:9", "2:107:10", "2:107:12","2:108:7","2:112:6",
                    "2:114:6", "2:114:11", "2:114:12", "2:115:6", "2:115:7",
                    "2:118:11", "2:119:12", "2:122:10"
                //,"2:116:4","2:97:6", "2:97:11","2:103:8"
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
                    "2:155:4","2:156:5", 
                    "2:157:7", "2:157:10",
                    "2:159:4","2:159:5", "2:159:11",
                   "2:161:12", "2:163:6","2:169:9", "2:169:11", "2:169:12",
                    "2:170:4","2:170:6","2:170:11", "2:171:6","2:174:4"
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
           "2:188:10",
            "2:193:8","2:197:4","2:205:12","2:207:12", "2:208:7",
            "2:211:4","2:213:12","2:214:5"
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
         "2:224:6","2:224:10","2:228:6","2:228:7","2:229:10"   ,
         "2:230:6","2:234:5","2:235:4","2:235:5",
         "2:241:6","2:241:11",
        "2:247:4","2:258:4","2:250:3","2:250:11","2:251:11"//,"2:224:5","2:250:12" //obrona
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
                "3:18:10","3:18:11","3:19:7","3:20:12",
                "3:21:8","3:21:11","3:21:12",
                "3:25:7",
                "3:26:6",
                "3:28:8",
                "3:29:9",
                "3:29:10","3:30:4", "3:30:9",
                "3:34:6","3:34:8",//"3:34:10",
                "3:35:5","3:35:8","3:35:12",//"3:37:6",
                "3:39:6","3:39:7","3:40:6","3:40:8","3:41:10",
               "3:43:6","3:43:8","3:44:9"});
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
        Farmer f = new Farmer(aisha); // ustawiamy na planete z sondami + 1 wolny slot zostawiamy
        f.setStationarySonds(true);
        f.add(aisha, cAisha, farming);
        f.add(videl, cVidel, farming);
        f.add(hinata, cHinata, farming);
        f.add(tatsuki, cTatsuki, farming);
        f.add(nami, cNami, farming);
        f.add(hotaru, cHotaru,farming);
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
