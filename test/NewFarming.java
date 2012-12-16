/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Buildings;
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
                "2:73:12","2:67:11","2:67:3","2:63:10","2:59:13","2:59:12", "2:59:9","2:57:8","2:54:10","2:52:7","2:50:11",
                "2:50:9","2:50:8","2:42:8",
                // 1 dp 2:59:10
                });
        Coords[] cKushina = Coords.parseArray(new String[]{
            "2:122:8","2:121:12","2:121:1","2:115:12","2:115:7","2:115:6","2:113:7","2:113:4","2:109:9",
            "2:106:12","2:105:11","2:106:7","2:105:6","2:102:8","2:102:7","2:99:11","2:99:8","2:94:10",
            "2:90:11"
            
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
            "2:169:12","2:168:11","2:159:12","2:158:4","2:155:10","2:153:12","2:146:4"
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
            "2:215:13","2:214:11","2:214:10","2:214:4","2:212:7","2:208:7","2:202:10","2:201:11","2:201:9","2:197:6",
            "2:195:12","2:190:10","2:189:6","2:188:11","2:186:4","2:182:8","2:216:7"
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
            "2:261:6","2:261:5","2:247:9","2:243:10","2:230:11","2:230:8","2:228:9","2:227:7"
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
            "3:49:5","3:47:11","3:45:7","3:27:12","3:20:10","3:19:5","3:18:10","3:18:6"
        });
        Coords[] cJuvia = Coords.parseArray(new String[]{
            "3:198:8","3:196:4","3:194:5","3:192:6","3:191:8","3:190:8","3:187:9","3:172:12","3:168:11"
        });
        Coords[] cErza = Coords.parseArray(new String[]{
            "4:349:12","4:343:12","4:343:7","4:343:6","4:335:12","4:335:10","4:334:8","4:330:8","4:339:8"
            // obrona 4:340:6 1ldl
            // recznie 4:339:8
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
        PlanetElement kushina = new PlanetElement(new Planet(new Coords(2, 106, 6), "Kushina"), fs, 1,isFs);
        PlanetElement videl = new PlanetElement(new Planet(new Coords(2, 158, 7), "Videl"), fs, 1,isFs);
        PlanetElement hinata = new PlanetElement(new Planet(new Coords(2, 199, 7), "Hinata"), fs, 1,isFs);
        PlanetElement tatsuki = new PlanetElement(new Planet(new Coords(2, 244, 7), "Tatsuki"), fs, 1,isFs);
        PlanetElement nami = new PlanetElement(new Planet(new Coords(2, 57, 11), "Nami"), fs, 1,isFs);
        PlanetElement hotaru = new PlanetElement(new Planet(new Coords(3,33,5),"Hotaru"),fs,1,isFs);
        PlanetElement juvia = new PlanetElement(new Planet(new Coords(3,182,8),"Juvia"),fs,1,isFs);
        PlanetElement erza = new PlanetElement(new Planet(new Coords(4,344,8),"Erza"),fs,1,isFs);
        Moon nelliel = new Moon(new Coords(2,158,7,Destination.MOON),"Nelliel");
        Farmer f = new Farmer(kushina); // ustawiamy na planete z sondami + 1 wolny slot zostawiamy
        f.setStationarySonds(true);
        f.add(kushina, cKushina, farming);
        f.add(videl, cVidel, farming);
        f.add(hinata, cHinata, farming);
        f.add(tatsuki, cTatsuki, farming);
        f.add(nami, cNami, farming);
        f.add(hotaru, cHotaru,farming);
        f.add(juvia, cJuvia, farming);
        f.add(erza, cErza, farming);
        TimePeriod await = new TimePeriod(0, 10, 0);
        Report.metal_price=1.0;
        Report.crystal_price = 1.4;
        Report.deuterium_price = 1.1;
        //o.wait(1,20, 0);
        int i =0;
        boolean budowac = true;
        while (true) {
            try{
                await = new TimePeriod(0, 10, 0);
                o.start();
                o.login(uni, nick, pass);
                o.changePlanet(nelliel);
                try {
                    o.sendFleet(exp, new Coords(2,157,16), Mission.EXPLORE);
                }catch (Exception ex){}
                try {
                    o.sendFleet(exp, new Coords(2,159,16), Mission.EXPLORE);
                }catch (Exception ex){}
                try {
                    o.sendFleet(exp, new Coords(2,158,16), Mission.EXPLORE);
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
