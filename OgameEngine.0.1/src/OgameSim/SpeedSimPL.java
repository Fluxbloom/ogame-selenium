/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Coords;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;
import OgameElements.MilitaryTech;
import OgameElements.PropulsionTech;
import OgameElements.Ships;
import OgameElements.Defence;
import OgameElements.ShipyardProduct;
import com.thoughtworks.selenium.DefaultSelenium;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author andrzej
 */
public class SpeedSimPL extends Sim {

    public SpeedSimPL() throws FileNotFoundException, IOException {
        init();
         try {
            selenium =
                    new DefaultSelenium("0.0.0.0", 4444, "*chrome","http://") {

                        @Override
                        public void open(String url) {
                            commandProcessor.doCommand("open", new String[]{url, "true"});
                        }
                    };
        } catch (Exception ex) {
            //logger.log(Level.WARNING, " [FAIL]");
        }
        //logger.log(Level.INFO, " [DONE]");
        
    }
    
    @Override
    public void start() {
        System.out.println("Starting selenium instance");
        try {
            selenium.start();
            selenium.windowMaximize();
        } catch (Exception ex) {
            //logger.log(Level.SEVERE, OgameException.SELENIUM_SERVER_IS_DOWN.getMessage());
            //throw OgameException.SELENIUM_SERVER_IS_DOWN;
        }
    }

    /**
     * Metoda zamykająca sterownik selenium
     */
    @Override
    public void stop() {
        //logger.log(Level.INFO, "Stoping selenium instance");
        try {
            selenium.close();
            selenium.stop();
        } catch (Exception ex) {
            //logger.log(Level.WARNING, "Cant close selenium driver");
        }
    }

    
    private Map<Ships,String> ship2xpath;
    private Map<ShipyardProduct,String> defence2xpath;
    private Map<MilitaryTech,String> tech2xpath;
    @Override
    public BattleResult sim(Fleet f1, FleetAndDefence f2) {
        selenium.open("http://websim.speedsim.net/index.php?lang=pl");
        
        HashMap<ShipyardProduct,Integer>defender=f2.getFleet();
        
        Set<Entry<ShipyardProduct,Integer>> set1 = defender.entrySet();
        Iterator<Entry<ShipyardProduct,Integer>> it1 = set1.iterator();
        for (Entry<ShipyardProduct,Integer> temp1; it1.hasNext();){
            temp1 = it1.next();
            selenium.type(defence2xpath.get(temp1.getKey()), temp1.getValue().toString());
        }
        HashMap<Ships,Integer> attacker = f1.getFleet();
        Set<Entry<Ships,Integer>> set = attacker.entrySet();
        Iterator<Entry<Ships,Integer>> it = set.iterator();
        for (Entry<Ships,Integer> temp; it.hasNext();){
            temp = it.next();
            selenium.type(ship2xpath.get(temp.getKey()), temp.getValue().toString());
            
        }
        
                
                return null;
    }

    private void init() throws FileNotFoundException, IOException {
        PropertiesSpeedSimPL mappings = new PropertiesSpeedSimPL();
        ship2xpath = new HashMap<Ships,String>();
        ship2xpath.put(Ships.MT, mappings.getAttackerMT());
        ship2xpath.put(Ships.DT, mappings.getAttackerDT());
        ship2xpath.put(Ships.LM, mappings.getAttackerLM());
        ship2xpath.put(Ships.CM, mappings.getAttackerCM());
        ship2xpath.put(Ships.KR, mappings.getAttackerKr());
        ship2xpath.put(Ships.OW, mappings.getAttackerOW());
        ship2xpath.put(Ships.KOL, mappings.getAttackerKol());
        ship2xpath.put(Ships.REC, mappings.getAttackerRec());
        ship2xpath.put(Ships.SOND, mappings.getAttackerSond());
        ship2xpath.put(Ships.BOMB, mappings.getAttackerBomb());
        ship2xpath.put(Ships.NISZ, mappings.getAttackerNisz());
        ship2xpath.put(Ships.GS, mappings.getAttackerGS());
        ship2xpath.put(Ships.PAN, mappings.getAttackerPan());
        
        defence2xpath = new HashMap<ShipyardProduct, String>();
        defence2xpath.put(Ships.MT, mappings.getDefenderMT());
        defence2xpath.put(Ships.DT, mappings.getDefenderDT());
        defence2xpath.put(Ships.LM, mappings.getDefenderLM());
        defence2xpath.put(Ships.CM, mappings.getDefenderCM());
        defence2xpath.put(Ships.KR, mappings.getDefenderKr());
        defence2xpath.put(Ships.OW, mappings.getDefenderOW());
        defence2xpath.put(Ships.KOL, mappings.getDefenderKol());
        defence2xpath.put(Ships.REC, mappings.getDefenderRec());
        defence2xpath.put(Ships.SOND, mappings.getDefenderSond());
        defence2xpath.put(Ships.BOMB, mappings.getDefenderBomb());
        defence2xpath.put(Ships.NISZ, mappings.getDefenderNisz());
        defence2xpath.put(Ships.GS, mappings.getDefenderGS());
        defence2xpath.put(Ships.PAN, mappings.getDefenderPan());
        defence2xpath.put(Ships.SAT, mappings.getDefenderSS());
        
        defence2xpath.put(Defence.DUZA_POWLOKA, mappings.getDefenderDPO());
        defence2xpath.put(Defence.DUZY_LASER, mappings.getDefenderCDL());
        defence2xpath.put(Defence.DZIALO_GAUSSA, mappings.getDefenderDG());
        defence2xpath.put(Defence.DZIALO_JONOWE, mappings.getDefenderDJ());
        defence2xpath.put(Defence.MALA_POWLOKA, mappings.getDefenderMPO());
        defence2xpath.put(Defence.MALY_LASER, mappings.getDefenderLDL());
        defence2xpath.put(Defence.PRZECIWRAKIETA, mappings.getDefenderPR());
        defence2xpath.put(Defence.WYRZUTNIA_PLAZMY, mappings.getDefenderWP());
        defence2xpath.put(Defence.WYRZUTNIA_RAKIET, mappings.getDefenderWR());
        
           
        
        
        
        
    }

    @Override
    public BattleResult sim(Fleet f1, FleetAndDefence f2, MilitaryTech t1, MilitaryTech t2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BattleResult sim(Fleet f1, FleetAndDefence f2, MilitaryTech t1, MilitaryTech t2, PropulsionTech pt, Coords origin, Coords target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
