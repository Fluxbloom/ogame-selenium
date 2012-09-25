/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Buildings;
import OgameElements.Coords;
import OgameElements.TimePeriod;
import OgameElements.Fleet;
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
                    "2:45:9", "2:46:5", "2:46:6", "2:46:9", "2:46:10",
                    "2:47:4", "2:54:7", "2:56:11", "2:56:12",
                    "2:65:4", "2:67:9"
                });
        Coords[] cAisha = Coords.parseArray(new String[]{
                    "2:91:6", "2:97:8", "2:97:10", "2:97:12",
                    "2:105:7", "2:107:8", "2:107:9",
                    "2:111:8", "2:114:8", "2:114:9", "2:114:10", "2:115:6", "2:115:7",
                    "2:119:7", "2:119:12"
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
                    "2:152:4", "2:153:10",
                    "2:157:5", "2:157:6", "2:157:7",
                    "2:159:11",
                    "2:161:12", "2:163:6",
                    "2:169:7", "2:169:8", "2:169:9", "2:169:11", "2:169:12",
                    "2:170:7", "2:173:10"
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
                    "2:185:5", "2:185:6", "2:191:10", "2:193:8",
                    "2:206:7", "2:206:10", "2:209:8"
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
                   "2:236:12","2:238:8","2:243:8","2:245:8",
        "2:247:4","2:251:4","2:251:5","2:251:7"
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
            "3:42:12","3:42:4","3:40:6","3:38:7","3:38:12","3:35:8",
            "3:21:8","3:21:12", "3:29:6","3:30:4","3:30:9"});
        Fleet fs = new Fleet(), farming = new Fleet();
        fs.add(Ships.LM, Ships.ALL);
        fs.add(Ships.MT, Ships.ALL);
        fs.add(Ships.KR, Ships.ALL);
        fs.add(Ships.OW, Ships.ALL);
        fs.add(Ships.PAN, Ships.ALL);
        farming.add(Ships.MT, 5);
        PlanetElement aisha = new PlanetElement(new Planet(new Coords(2, 106, 6), "Aisha"), fs, 1);
        PlanetElement videl = new PlanetElement(new Planet(new Coords(2, 158, 7), "Videl"), fs, 1);
        PlanetElement hinata = new PlanetElement(new Planet(new Coords(2, 199, 7), "Hinata"), fs, 1);
        PlanetElement tatsuki = new PlanetElement(new Planet(new Coords(2, 244, 7), "Tatsuki"), fs, 1);
        PlanetElement nami = new PlanetElement(new Planet(new Coords(2, 57, 11), "Nami"), fs, 1);
        PlanetElement hotaru = new PlanetElement(new Planet(new Coords(3,33,5),"Hotaru"),fs,1);
        Farmer f = new Farmer(videl); // ustawiamy na planete z sondami + 1 wolny slot zostawiamy
        f.setStationarySonds(true);
        f.add(aisha, cAisha, farming);
        f.add(videl, cVidel, farming);
        f.add(hinata, cHinata, farming);
        f.add(tatsuki, cTatsuki, farming);
        f.add(nami, cNami, farming);
        f.add(hotaru, cHotaru,farming);
        TimePeriod await = new TimePeriod(0, 10, 0);
        //o.wait(2,30,0);
        while (true) {
            try {
                await = new TimePeriod(0, 10, 0);
                o.start();
                o.login(uni, nick, pass);
                await = f.scanAndFarm(o);
            } catch (OgameException ex) {
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
