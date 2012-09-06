/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElementsUnchecked.Coords;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.Resources;
import OgameElementsUnchecked.Ships;
import OgameEngineUnchecked.Ogame;
import OgameEngineUnchecked.OgameException;
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
public class Farming {

    public Farming() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    Ogame o = Ogame.ogameFabric("116", "pl");
    String uni = "Pegasus";
    String nick = "Mystic";
    String pass = "SuperUltraSsjGoku2";
    Coords[] cAisha = Coords.parseArray(new String[]{
        "2:97:4","2:97:9","2:97:10",
        "2:98:8","2:101:7","2:102:5","2:105:7","2:108:4","2:108,7","2:109:9",
        "2:114:8","2:114:9","2:114:10",
        "2:115:6","2:115:7", "2:117:4"});
    Coords[] cVidel = Coords.parseArray(new String[]{
        "2:152:4","2:152:6","2:153:10","2:154:4","2:154:10","2:155:6","2:156:6",
        "2:157:5","2:157:6","2:157:7","2:157:11",
        "2:158:5","2:161:9","2:161:10","2:161:12",
        "2:162:4","2:162:6","2:163:6","2:165:8"});
    Coords[] cHinata = Coords.parseArray(new String[]{
        "2:191:10","2:193:8","2:194:11",
        "2:195:4","2:195:5","2:195:6","2:195:9",
        "2:196:4","2:196:6","2:196:9","2:202:7"});
    Coords[] cTatsuki = Coords.parseArray(new String[]{
        "2:236:4","2:236:5","2:236:6","2:236:9",
        "2:237:4","2:237:10",
        "2:238:5","2:238:8","2:238:9",
        "2:241:8","2:241:10",
        "2:242:7","2:242:8","2:243:12",
        "2:245:8","2:248:7","2:248:8","2:248:11"});
    Coords[] cNami = Coords.parseArray(new String[]{
        "2:55:6","2:55:7","2:55:9",
        "2:56:7","2:56:8","2:56:10","2:56:11","2:56:12",
        "2:59:11","2:63:4"});
    int iAisha = 0, iVidel = 0, iHinata = 0, iTatsuki = 0;
    //Planet aisha = new Planet(new Coords(2, 106, 6), "Aisha"),
    //        videl = new Planet(new Coords(2, 158, 7), "Videl"),
    //        hinata = new Planet(new Coords(2, 199, 7), "Hinata"),
    //        tatsuki = new Planet(new Coords(2, 244, 7), "Tatsuki");

    @Test
    @Ignore
    public void station() throws OgameException {
//        o.start();
//        o.login(uni, nick, pass);
//        o.changePlanet(aisha);
//        Fleet send = new Fleet();
//        send.add(Ships.SOND, -1);
//        o.sendFleet(send, tatsuki.getCoords(), Mission.STATION);
    }

    class AttackList {

        public AttackList(int fleets, Fleet fleet, Fleet fs, Coords[] farmingCoords, Planet planet) {
            this.fleets = fleets;
            this.fleet = fleet;
            this.farmingCoords = farmingCoords;
            this.planet = planet;
            this.fsfleet = fs;
        }

        public void attack() throws OgameException {
            o.changePlanet(planet);
            int i = 0;
            while (i < this.fleets - 1) {
                try {
                    o.sendFleet(fleet, this.farmingCoords[this.getFarmCounter()]);
                    i++;
                } catch (OgameException ex) {
                }
            }
            while (true) {
                try {
                    o.sendFleet(this.fsfleet, this.farmingCoords[this.getFarmCounter()], Mission.ATTACK, Resources.ALL_RESOURCES);
                    break;
                } catch (OgameException ex) {
                }
            }

        }

        private int getFarmCounter() {
            farmCounter = (farmCounter + 1) % (this.farmingCoords.length);
            return farmCounter;
        }
        private int fleets;
        private Fleet fleet;
        private final Fleet fsfleet;
        private Coords[] farmingCoords;
        private Planet planet;
        private int farmCounter = 0;
    }

    @Test
    public void farm() throws OgameException {
        Fleet farming = new Fleet();
        farming.add(Ships.MT, 3);
        Fleet fs = new Fleet();
        fs.add(Ships.MT, Ships.ALL);
        fs.add(Ships.LM, Ships.ALL);
        fs.add(Ships.KR, Ships.ALL);
        fs.add(Ships.OW, Ships.ALL);
        AttackList aisha = new AttackList(1, farming, fs, cAisha, new Planet(new Coords(2, 106, 6), "Aisha")),
                videl = new AttackList(1, farming, Fleet.WHOLE_FLEET, cVidel, new Planet(new Coords(2, 158, 7), "Videl")),
                hinata = new AttackList(1, farming, Fleet.WHOLE_FLEET, cHinata, new Planet(new Coords(2, 199, 7), "Hinata")),
                tatsuki = new AttackList(1, farming, Fleet.WHOLE_FLEET, cTatsuki, new Planet(new Coords(2, 244, 7), "Tatsuki")),
                nami = new AttackList(1, farming, fs, cNami, new Planet(new Coords(2, 57, 11), "Nami"));
        while (true) {
            try {
                o.start();
                o.login(uni, nick, pass);
                aisha.attack();
                videl.attack();
                hinata.attack();
                tatsuki.attack();
                nami.attack();

            } catch (OgameException ex) {
                Logger.getLogger(Farming.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    o.logout();
                } finally {
                    o.stop();
                    o.wait(2, 40, 17);
                }

            }

        }




    }

}
