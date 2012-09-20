/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Coords;
import OgameElements.TimePeriod;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.Resources;
import OgameElementsUnchecked.Ships;
import OgameElementsUnchecked.Speed;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class Farming extends OgameTest{

    public Farming() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    //int iAisha = 0, iVidel = 0, iHinata = 0, iTatsuki = 0;
    //Planet aisha = new Planet(new Coords(2, 106, 6), "Aisha"),
    //        videl = new Planet(new Coords(2, 158, 7), "Videl"),
    //        hinata = new Planet(new Coords(2, 199, 7), "Hinata"),
    //        tatsuki = new Planet(new Coords(2, 244, 7), "Tatsuki");

    class AttackList {

        public AttackList(int fleets, Fleet fleet, Fleet fs, Coords[] farmingCoords, Planet planet) {
            this.fleets = fleets;
            this.fleet = fleet;
            this.fsfleet = fs;
            this.farmingCoords = farmingCoords;
            this.planet = planet;
            this.fs=true;
        }

        public AttackList(int fleets, Fleet fleet, Fleet fsfleet, Coords[] farmingCoords, Planet planet, boolean fs) {
            this.fleets = fleets;
            this.fleet = fleet;
            this.fsfleet = fsfleet;
            this.farmingCoords = farmingCoords;
            this.planet = planet;
            this.fs = fs;
        }
        
        

        public List<TimePeriod> attack() throws OgameException {
            List<TimePeriod> returns = new ArrayList<TimePeriod>();
            o.changePlanet(planet);
            int i = 0;
            int size = fs?this.fleets-1:this.fleets;
            int counter;
            while (i < size) {
                try {
                    counter =this.getFarmCounter(); 
                    if (!planet.getCoords().isSameSystem(this.farmingCoords[counter]))
                        returns.add(o.sendFleet(fleet, this.farmingCoords[counter]).getFlyingTime());
                    else 
                        returns.add(o.sendFleet(fleet, this.farmingCoords[counter], Speed.S60, Mission.ATTACK, Resources.NO_RESOURCES).getFlyingTime());
                    i++;
                } catch (OgameException ex) {
                    if (ex == OgameException.FLEET_NO_FLEET_ON_PLANET){
                       // throw ex;
                    }
                }
            }
            while (fs) {
                try {
                    counter =this.getFarmCounter();
                    if (!planet.getCoords().isSameSystem(this.farmingCoords[counter]))
                        returns.add(o.sendFleet(this.fsfleet, this.farmingCoords[counter], Mission.ATTACK, Resources.ALL_RESOURCES).getFlyingTime());
                    else 
                        returns.add(o.sendFleet(this.fsfleet, this.farmingCoords[counter], Speed.S60, Mission.ATTACK, Resources.ALL_RESOURCES).getFlyingTime()); 
                    break;
                } catch (OgameException ex) {
                    if (ex == OgameException.FLEET_NO_FLEET_ON_PLANET){
                        //throw ex;
                    }
                }
            }
            return returns;
        }

        void skip(int rounds){
            for (int i=0; i<rounds*this.fleets;i++){
                getFarmCounter();
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
        private boolean fs;
    }

    int rounds = 0;
    int minutes = 0, seconds = 0;
    
    @Test
    public void farm() throws OgameException, IOException {
            Coords[] cNami = Coords.parseArray(new String[]{
         "2:45:9", "2:46:4", "2:46:5", "2:46:6", "2:46:9", "2:46:10",
                    "2:47:4", "2:47:5", "2:50:6", "2:54:6", "2:54:7", "2:56:11", "2:56:12", 
                    "2:61:10", "2:64:7", "2:65:4", "2:67:9"
        });
        Coords[] cAisha = Coords.parseArray(new String[]{
 "2:91:6",  "2:97:4", "2:97:8", "2:97:9", "2:97:10", "2:97:12",
                    "2:98:8", "2:105:7", "2:107:8","2:107:9","2:107:10",
                    "2:111:8","2:114:8","2:114:9","2:114:10","2:115:6","2:115:7",
                    "2:117:4", "2:119:7","2:119:12", "2:120:4"        });
    Coords[] cVidel = Coords.parseArray(new String[]{
        "2:170:7","2:169:11","2:169:9","2:169:8","2:169:7","2:165:8","2:169:12","2:173:10","2:154:10","2:153:10"
            });
    Coords[] cHinata = Coords.parseArray(new String[]{
        "2:209:8","2:206:10","2:206:7","2:196:4","2:185:6"
        });
    Coords[] cTatsuki = Coords.parseArray(new String[]{
        "2:235:5","2:236:6","2:251:7","2:251:5","2:248:12","2:245:8","2:242:8","2:258:4"
    });

        Fleet farming = new Fleet();
        farming.add(Ships.MT, 3);
        Fleet fs = new Fleet();
        Fleet fullfs =new Fleet();
        fs.add(Ships.MT, Ships.ALL);
        fs.add(Ships.LM, Ships.ALL);
        fullfs.add(Ships.MT, Ships.ALL);
        fullfs.add(Ships.LM, Ships.ALL);
        fullfs.add(Ships.KR, Ships.ALL);
        fullfs.add(Ships.OW, Ships.ALL);
        Fleet exp = new Fleet();
        exp.add(Ships.CM, Ships.ALL);
        exp.add(Ships.DT, Ships.ALL);
        Fleet trans = new Fleet();
        trans.add(Ships.MT, 170);
        AttackList aisha = new AttackList(3, farming, fullfs, cAisha, 
                new Planet(new Coords(2, 106, 6), "Aisha")),
                videl = new AttackList(1, farming, fullfs, cVidel, 
                new Planet(new Coords(2, 158, 7), "Videl")),
                hinata = new AttackList(1, farming, fullfs, cHinata, 
                new Planet(new Coords(2, 199, 7), "Hinata")),
                tatsuki = new AttackList(3, farming, fullfs, cTatsuki, 
                new Planet(new Coords(2, 244, 7), "Tatsuki")),
                nami = new AttackList(3, farming, fullfs, cNami, 
                new Planet(new Coords(2, 57, 11), "Nami"));
        o.wait(minutes, seconds);
        aisha.skip(rounds);
        videl.skip(rounds);
        hinata.skip(rounds);
        tatsuki.skip(rounds);
        nami.skip(rounds);
        List<TimePeriod> returns;
        TimePeriod temp,await= new TimePeriod(2,57,17);
        List<TimePeriod> allReturns = new ArrayList<TimePeriod>();
        boolean ifTrans = true;
        while (true) {
            try {
                allReturns = new ArrayList<TimePeriod>();
                await = new TimePeriod(0,10,0);
                o.start();
                o.login(uni, nick, pass);
                try {
                o.changePlanet(new Planet(new Coords(2, 106, 6), "Aisha"));
                o.sendFleet(exp, new Coords(2, 107, 16), Mission.EXPLORE.setTime(1));
                } catch( Exception ex){System.err.println("Brak floty ekspedycyjnej na aisha");}
                try {
                o.changePlanet(new Planet(new Coords(2, 158, 7), "Videl"));
                o.sendFleet(exp, new Coords(2, 157, 16), Mission.EXPLORE.setTime(1));
                } catch( Exception ex){System.err.println("Brak floty ekspedycyjnej na videl");}
                returns = aisha.attack();
                temp = TimePeriod.max(returns);
                allReturns.add(temp);
                returns = videl.attack();
                temp = TimePeriod.max(returns);
                allReturns.add(temp);
                returns = hinata.attack();
                temp = TimePeriod.max(returns);
                allReturns.add(temp);
                returns = tatsuki.attack();
                temp = TimePeriod.max(returns);
                allReturns.add(temp);
                returns = nami.attack();
                temp = TimePeriod.max(returns);
                allReturns.add(temp);
                await = TimePeriod.max(allReturns);
            } catch (OgameException ex) {
                Logger.getLogger(Farming.class.getName()).log(Level.SEVERE, null, ex);
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
