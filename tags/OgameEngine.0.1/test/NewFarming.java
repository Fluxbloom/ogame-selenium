/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Coords;
import OgameElements.Destination;
import OgameElements.TimePeriod;
import OgameElements.Fleet;
import OgameElements.Mission;
import OgameElements.Moon;
import OgameElements.Planet;
import OgameElements.Report;
import OgameElements.Ships;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import OgameToolBox.Farmer;
import OgameToolBox.PlanetElement;
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
            "2:73:4","2:69:7","2:68:12","2:67:11","2:67:3","2:63:10","2:59:12","2:59:11","2:59:9","2:57:8","2:54:6","2:52:7","2:51:8",
            "2:50:11","2:50:8","2:50:6","2:47:6","2:42:12"
                // obrona 2:50:9
                });
        Coords[] cAisha = Coords.parseArray(new String[]{
            "2:121:12","2:121:1","2:120:1","2:115:7","2:115:6","2:113:8","2:113:7","2:113:4","2:112:10","2:111:6","2:109:11","2:109:9",
            "2:105:10","2:106:12","2:105:7","2:104:5","2:103:4","2:102:8","2:102:7","2:101:6","2:99:11","2:99:8","2:98:10","2:91:6","2:122:1"
            
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
            "2:169:12","2:169:11","2:169:9","2:164:6","2:163:11", "2:163:8","2:163:6","2:162:11","2:160:10","2:159:12","2:157:7",
            "2:153:13","2:153:12","2:153:11","2:153:8", "2:152:8","2:150:10","2:149:11","2:146:9","2:146:6","2:146:5","2:146:4",
            "2:144:11"
            // obrona 2:170:12 2:153:14 
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
            "2:214:4","2:214:11","2:212:7","2:208:7","2:207:9","2:206:6","2:203:6","2:202:13","2:202:10","2:201:11", "2:201:9","2:195:12","2:193:13",
            "2:193:12","2:193:4","2:191:12","2:190:10","2:190:6","2:189:6","2:188:11","2:186:4"
            // obrona 2:210:6 2:214:10
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
            "2:260:6","2:259:11","2:258:6","2:258:4","2:248:12","2:247:9","2:247:4","2:243:11","2:243:10","2:237:7"
            
            // obrona 
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
            "3:49:4","3:46:8","3:38:12","3:35:7","3:32:10","3:26:6","3:21:10","3:20:10","3:19:5","3:18:10","3:18:11","3:20:12",
            "3:32:5"
            
            // obrona 3:49:5,3:18:6
        });
        Coords[] cErza = Coords.parseArray(new String[]{
            "4:357:12","4:357:4","4:349:12","4:345:6","4:345:5","4:343:12","4:343:7","4:343:6","4:335:12","4:335:10","4:335:9",
            "4:335:4"
        });
        
        Coords[] cJuvia = Coords.parseArray(new String[]{
            "3:198:8","3:196:7","3:196:4","3:194:5","3:193:12","3:192:6","3:191:8","3:190:13","3:190:8","3:189:13","3:184:5",
            "3:183:12","3:177:4","3:171:12","3:170:8","3:169:9","3:169:8","3:168:11","3:168:8",
            
            // obrona 3:187:9 3:172:13 3:172:12 
        });
        Fleet fs = new Fleet(), farming = new Fleet(),exp = new Fleet();
        fs.add(Ships.LM, Ships.ALL);
        //fs.add(Ships.CM, Ships.ALL);
        fs.add(Ships.MT, Ships.ALL);
        fs.add(Ships.KR, Ships.ALL);
        fs.add(Ships.OW, Ships.ALL);
        fs.add(Ships.PAN, Ships.ALL);
        //fs.add(Ships.NISZ,Ships.ALL); -- za wolne
        farming.add(Ships.MT, 5);
        exp.add(Ships.DT, 50);
        exp.add(Ships.CM, 60);
        boolean isFs = false;
        PlanetElement aisha = new PlanetElement(new Planet(new Coords(2, 106, 6), "Aisha"), fs, 1,isFs);
        PlanetElement videl = new PlanetElement(new Planet(new Coords(2, 158, 7), "Videl"), fs, 1,true);
        PlanetElement hinata = new PlanetElement(new Planet(new Coords(2, 199, 7), "Hinata"), fs, 1,isFs);
        PlanetElement tatsuki = new PlanetElement(new Planet(new Coords(2, 244, 7), "Tatsuki"), fs, 1,isFs);
        PlanetElement nami = new PlanetElement(new Planet(new Coords(2, 57, 11), "Nami"), fs, 1,isFs);
        PlanetElement hotaru = new PlanetElement(new Planet(new Coords(3,33,5),"Hotaru"),fs,1,isFs);
        PlanetElement juvia = new PlanetElement(new Planet(new Coords(3,182,8),"Juvia"),fs,1,isFs);
        PlanetElement erza = new PlanetElement(new Planet(new Coords(4,344,8),"Erza"),fs,1,isFs);
        Moon nelliel = new Moon(new Coords(2,158,7,Destination.MOON),"Nelliel");
        Farmer f = new Farmer(aisha,1); // ustawiamy na planete z sondami + 1 wolny slot zostawiamy
        f.setStationarySonds(true);
        f.add(aisha, cAisha, farming);
        f.add(videl, cVidel, farming);
        f.add(hinata, cHinata, farming);
        f.add(tatsuki, cTatsuki, farming);
        f.add(nami, cNami, farming);
        f.add(hotaru, cHotaru,farming);
        f.add(juvia, cJuvia, farming);
        f.add(erza, cErza, farming);
        TimePeriod await = new TimePeriod(0, 10, 0);
        Report.metal_price=1.0;
        Report.crystal_price = 1.5;
        Report.deuterium_price = 1.3;
        //o.wait(0,15, 0);
        int i =0;
        while (true) {
            try{
                await = new TimePeriod(0, 10, 0);
                o.start();
                o.login(uni, nick, pass);
                o.changePlanet(nelliel);
                try {
                    o.sendFleet(exp, new Coords(2,156,16), Mission.EXPLORE.setTime(2));
                }catch (Exception ex){}
                try {
                    o.sendFleet(exp, new Coords(2,157,16), Mission.EXPLORE.setTime(2));
                }catch (Exception ex){}
                try {
                    o.sendFleet(exp, new Coords(2,159,16), Mission.EXPLORE.setTime(2));
                }catch (Exception ex){}
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
