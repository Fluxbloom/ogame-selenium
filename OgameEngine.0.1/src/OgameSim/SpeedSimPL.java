/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;
import OgameElements.Ships;
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
    @Override
    public BattleResult sim(Fleet f1, FleetAndDefence f2) {
        selenium.open("http://websim.speedsim.net/index.php?lang=pl");
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
    }
    
}
