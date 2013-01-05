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
          "2:73:12","2:72:7","2:72:4","2:72:3","2:71:13","2:71:6","2:63:9","2:59:13","2:59:10","2:54:10","2:54:6",
          "2:50:9","2:43:8","2:42:8","2:42:5","2:41:7"
          
          // obrona "2:64:10".
                });
        Coords[] cKushina = Coords.parseArray(new String[]{
            "2:122:8","2:122:5","2:118:4","2:115:12","2:115:7","2:115:6","2:115:4","2:109:11","2:101:10","2:101:4",
            "2:97:8","2:94:10","2:93:8","2:91:6","2:90:11"
            // obrona "2:109:10","2:100:6",
                });
        Coords[] cVidel = Coords.parseArray(new String[]{
           "2:169:12","2:169:11","2:169:9","2:167:6","2:164:6","2:163:6","2:162:4","2:161:12","2:158:4","2:157:7",
           "2:156:5","2:147:11","2:141:11","2:141:10","2:141:7","2:141:4"
           
           // obrona "2:161:9"
                });
        Coords[] cHinata = Coords.parseArray(new String[]{
            "2:216:7","2:214:6","2:214:4","2:209:11","2:197:6","2:195:12","2:192:9","2:189:8","2:188:11","2:182:8"
            
            // obrona "2:199:10"
                });
        Coords[] cTatsuki = Coords.parseArray(new String[]{
            "2:258:4","2:246:12","2:237:4","2:232:11","2:232:10","2:232:6","2:231:4","2:229:6"
            
            //obrona "2:260:7","2:240:12",
                });
        Coords[] cHotaru = Coords.parseArray( new String[]{
            "3:47:11","3:45:7","3:44:5","3:27:12","3:27:5","3:26:6","3:21:10"
        });
        Coords[] cJuvia = Coords.parseArray(new String[]{
            "3:197:10","3:190:11","3:187:12","3:186:4","3:182:6","3:177:8","3:176:12","3:174:11","3:173:7",
            "3:170:8","3:166:10"
            
            // obrona "3:170:5"
        });
        Coords[] cErza = Coords.parseArray(new String[]{
            "4:340:6","4:334:8","4:330:8"
                
            // obrona "4:335:8","4:335:6", "4:335:7", "4:335:5",  "4:327:7", 
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
        Report.crystal_price = 1.4;
        Report.deuterium_price = 1.1;
        o.wait(1,0, 0);
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
                }catch (Exception ex){
                    System.out.println("Błąd pierwszego wysłania");
                    try{
                        o.sendFleet(exp, new Coords(2,157,16), Mission.EXPLORE);
                    }
                    catch(Exception ex2){}
                }
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
