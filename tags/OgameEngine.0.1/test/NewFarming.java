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
            "2:68:12","2:68:10","2:67:11","2:67:3","2:63:10","2:59:12","2:59:9","2:57:8","2:56:12","2:54:10","2:54:6",
            "2:52:7","2:51:8","2:50:11","2:50:9","2:50:8","2:50:6", "2:42:12","2:42:10","2:42:8"
            // obrona 2:50:4 
                
                });
        Coords[] cKushina = Coords.parseArray(new String[]{
           "2:122:1","2:121:12","2:121:1","2:121:8","2:120:1","2:115:12","2:115:7","2:115:6","2:113:8",
            "2:113:7","2:113:4","2:112:10","2:111:6","2:122:8","2:109:11","2:109:9","2:105:10","2:106:12","2:105:7","2:104:5",
            "2:103:4","2:102:8","2:102:7","2:101:6","2:99:11","2:99:8","2:94:10","2:91:6"
                // obrona ,"2:123:1"
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
        "2:169:12","2:169:11","2:169:9","2:168:11","2:163:11","2:163:6","2:161:12","2:160:10","2:159:12","2:157:9","2:158:4",
        "2:157:7","2:155:10","2:154:11","2:153:12","2:152:8","2:150:10","2:149:11","2:146:9","2:146:6","2:146:5","2:146:4",
        "2:146:4"
            
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
        "2:216:8","2:216:7","2:215:13","2:214:11","2:214:10","2:214:4","2:212:7","2:209:11","2:208:7",
        "2:202:13","2:202:10","2:201:11","2:201:9","2:201:4","2:195:12","2:191:12","2:190:10","2:190:6","2:189:6","2:188:11",
        "2:186:4","2:182:8"
        // obrona 2:187:10 
            
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
        "2:261:6","2:261:5","2:260:6","2:259:11","2:247:9","2:247:4","2:243:11","2:243:10","2:237:7","2:230:11","2:228:9",
        "2:227:7"
        
        // obrona 2:230:8 
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
        "3:49:5","3:49:4","3:47:11","3:45:7","3:44:5","3:38:12","3:38:7","3:31:4","3:20:10","3:19:5","3:18:10","3:18:6"
        
        // obrona 3:16:12 
        });
        Coords[] cJuvia = Coords.parseArray(new String[]{
        "3:198:8","3:196:7","3:196:4","3:194:5","3:193:12","3:192:6","3:191:8","3:190:13","3:190:8","3:187:9","3:184:5","3:183:12",
        "3:172:13","3:170:8","3:168:11","3:168:8","3:166:10"
                
                // obrona 3:172:12 3:168:10 
        });
        Coords[] cErza = Coords.parseArray(new String[]{
        "4:349:12","4:345:6","4:343:12","4:343:7","4:343:6","4:335:12","4:335:10","4:335:9","4:335:4","4:334:8","4:330:8"
        
        // obrona 4:340:6, 4:339:8
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
        Farmer f = new Farmer(kushina,1); // ustawiamy na planete z sondami + 1 wolny slot zostawiamy
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
        Report.crystal_price = 1.0;
        Report.deuterium_price = 1.0;
        //o.wait(1,45, 0);
        int i =0;
        boolean budowac = true;
        while (true) {
            try{
                await = new TimePeriod(0, 10, 0);
                o.start();
                o.login(uni, nick, pass);
//                o.changePlanet(nelliel);
//                try {
//                    o.sendFleet(exp, new Coords(2,158,16), Mission.EXPLORE);
//                }catch (Exception ex){}
//                try {
//                    o.sendFleet(exp, new Coords(2,158,16), Mission.EXPLORE);
//                }catch (Exception ex){}
//                try {
//                    o.sendFleet(exp, new Coords(2,158,16), Mission.EXPLORE);
//                }catch (Exception ex){}
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
