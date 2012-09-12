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

    int rounds = 7;
    int minutes = 0, seconds = 0;
    
    @Test
    public void farm() throws OgameException, IOException {
        Coords[] cAisha = Coords.parseArray(new String[]{
        "2:95:6","2:97:4","2:97:12","2:102:5","2:105:7","2:114:8","2:114:9","2:114:10","2:115:6",
        "2:115:7","2:115:10"//"2:103:4",<-- obrona
        });
    Coords[] cVidel = Coords.parseArray(new String[]{
        "2:148:10","2:150:10","2:151:11","2:152:4","2:152:6","2:153:10","2:154:10","2:157:6","2:157:7",
        "2:158:5","2:161:12","2:162:4","2:163:6","2:165:8","2:169:7","2:169:8","2:170:7"//"2:161:10", <-- obrona
            });
    Coords[] cHinata = Coords.parseArray(new String[]{
        "2:191:10","2:193:4","2:195:4","2:195:7","2:196:4","2:206:7","2:206:10","2:209:8",
        });//"2:193:8",
    Coords[] cTatsuki = Coords.parseArray(new String[]{
        "2:236:5","2:236:6","2:238:8","2:238:9","2:241:10","2:242:7","2:242:8","2:245:8","2:248:7",
        "2:248:12","2:251:4","2:251:5","2:251:7","2:257:6"//"2:236:12",<- obrona
    });
    Coords[] cNami = Coords.parseArray(new String[]{
        "2:46:5","2:46:6","2:47:4","2:47:10","2:48:10","2:52:8","2:54:6","2:55:6","2:55:7",
        "2:56:11","2:56:12","2:59:6","2:59:11","2:62:10","2:65:4","2:67:9"
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
        AttackList aisha = new AttackList(1, farming, fullfs, cAisha, 
                new Planet(new Coords(2, 106, 6), "Aisha")),
                videl = new AttackList(2, farming, fullfs, cVidel, 
                new Planet(new Coords(2, 158, 7), "Videl")),
                hinata = new AttackList(1, farming, fullfs, cHinata, new Planet(new Coords(2, 199, 7), "Hinata")),
                tatsuki = new AttackList(2, farming, fullfs, cTatsuki, new Planet(new Coords(2, 244, 7), "Tatsuki")),
                nami = new AttackList(2, farming, fullfs, cNami, new Planet(new Coords(2, 57, 11), "Nami"));
        o.wait(minutes, seconds);
        aisha.skip(rounds);
        videl.skip(rounds);
        hinata.skip(rounds);
        tatsuki.skip(rounds);
        nami.skip(rounds);
        List<TimePeriod> returns;
        TimePeriod temp,await= new TimePeriod(2,57,17);
        List<TimePeriod> allReturns = new ArrayList<TimePeriod>();
        while (true) {
            try {
                allReturns = new ArrayList<TimePeriod>();
                await = new TimePeriod(2,57,17);
                o.start();
                o.login(uni, nick, pass);
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
