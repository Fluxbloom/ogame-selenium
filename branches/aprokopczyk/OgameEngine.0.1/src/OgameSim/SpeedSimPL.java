/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import OgameElements.BattleResult;
import OgameElements.Coords;
import OgameElements.DebrisResources;
import OgameElements.Fleet;
import OgameElements.FleetAndDefence;
import OgameElements.PropulsionTech;
import OgameElements.Ships;
import OgameElements.Defence;
import OgameElements.MilitaryTech;
import OgameElements.Resources;
import OgameElements.ShipyardProduct;
import OgameElements.TimePeriod;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import com.thoughtworks.selenium.DefaultSelenium;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author andrzej
 */
public class SpeedSimPL extends Sim {

    public SpeedSimPL() throws FileNotFoundException, IOException {
        init();
        try {
            selenium =
                    new DefaultSelenium("0.0.0.0", 4444, "*chrome", "http://") {
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
    private Map<Ships, String> ship2xpath;
    private Map<ShipyardProduct, String> defence2xpath;
    //private Map<MilitaryTech, String> tech2xpath;
    private PropertiesSpeedSimPL mappings;

    @Override
    public BattleResult sim(Fleet f1, FleetAndDefence f2) {
        selenium.open(mappings.getAdress());
        HashMap<ShipyardProduct, Integer> defender = f2.getFleet();

        Set<Entry<ShipyardProduct, Integer>> set1 = defender.entrySet();
        Iterator<Entry<ShipyardProduct, Integer>> it1 = set1.iterator();
        for (Entry<ShipyardProduct, Integer> temp1; it1.hasNext();) {
            temp1 = it1.next();
            selenium.type(defence2xpath.get(temp1.getKey()), temp1.getValue().toString());
        }
        HashMap<Ships, Integer> attacker = f1.getFleet();
        Set<Entry<Ships, Integer>> set = attacker.entrySet();
        Iterator<Entry<Ships, Integer>> it = set.iterator();
        for (Entry<Ships, Integer> temp; it.hasNext();) {
            temp = it.next();
            selenium.type(ship2xpath.get(temp.getKey()), temp.getValue().toString());

        }
        selenium.click(mappings.getSubmitButton());
        return parseResult();

        
    }

    private BattleResult parseResult() {
        Resources agressorLoss, defenderLoss, theoreticalProfit, realProfit;
        DebrisResources pz;
        Coords battlePlace=null;
        int attacker_won=0, defender_won=0, collected=0, rounds=0, dtNumber=0, moon, deuterCost;
        TimePeriod flightTime;
        
        BattleResult br;


        String resultLine;
         resultLine = selenium.getText(mappings.getBattle_place());
         String[] coords;
      
         coords = parsetd(resultLine, mappings.getCoords(), mappings.getCoords()).split(":");
        
       
         try {
            
         battlePlace = new Coords(coords[0], coords[1], coords[2],Coords.PLANET);
         
       
         } catch (OgameFileNotFoundException ex) {
         Logger.getLogger(SpeedSimPL.class.getName()).log(Level.SEVERE, null, ex);
         } catch (OgameIOException ex) {
         Logger.getLogger(SpeedSimPL.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        resultLine = selenium.getText(mappings.getResult());
      

        String res = parsetd(resultLine, mappings.getAtacker_won(), mappings.getBasicint());
        if (res != null) {
            attacker_won = Integer.parseInt(res);
        }

        String res1 = parsetd(resultLine, mappings.getDefender_won(), mappings.getBasicint());
        if (res1 != null) {
            defender_won = Integer.parseInt(res1);
        }

        String res2 = parsetd(resultLine, mappings.getCollected(), mappings.getBasicint());
        if (res2 != null) {
            collected = Integer.parseInt(res2);
        }

        String res3 = parsetd(resultLine, mappings.getRound_number(), mappings.getBasicint());
        if (res3 != null) {
            rounds = Integer.parseInt(res3);
        }
        resultLine = selenium.getText(mappings.getPz_surowce());

        pz = new DebrisResources(parsetd(resultLine, mappings.getMetal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getCrystal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getRecycler_number(), mappings.getBasicint()));

        resultLine = selenium.getText(mappings.getMoon_prob());
        moon = Integer.parseInt(parsetd(resultLine, mappings.getBasicint(), mappings.getBasicint()));
        resultLine = selenium.getText(mappings.getAtacker_loss());
        agressorLoss = new Resources(parsetd(resultLine, mappings.getMetal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getCrystal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getDeuter(), mappings.getResource_value()).replace(".", ""));
        resultLine = selenium.getText(mappings.getDefender_loss());
        defenderLoss = new Resources(parsetd(resultLine, mappings.getMetal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getCrystal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getDeuter(), mappings.getResource_value()).replace(".", ""));
        resultLine = selenium.getText(mappings.getTheoretical_profit());
        theoreticalProfit = new Resources(parsetd(resultLine, mappings.getMetal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getCrystal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getDeuter(), mappings.getResource_value()).replace(".", ""));
        dtNumber = Integer.parseInt(parsetd(resultLine, mappings.getBasicint(), mappings.getBasicint()));



        resultLine = selenium.getText(mappings.getReal_profit());
        realProfit = new Resources(parsetd(resultLine, mappings.getMetal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getCrystal(), mappings.getResource_value()).replace(".", ""), parsetd(resultLine, mappings.getDeuter(), mappings.getResource_value()).replace(".", ""));
        
        resultLine = selenium.getText(mappings.getDeuter_need());
        deuterCost=Integer.parseInt(parsetd(resultLine, mappings.getDeuter(), mappings.getResource_value()).replace(".", ""));
       
        resultLine = selenium.getText(mappings.getFlight());
        String time[]=parsetd(resultLine, mappings.getFlight_time(), mappings.getFlight_time()).split(":");
        flightTime=new TimePeriod(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[1]));
        
        







      return  new BattleResult(agressorLoss, defenderLoss, theoreticalProfit, realProfit, pz, battlePlace, attacker_won, defender_won, collected, rounds, dtNumber, moon, deuterCost, flightTime);
   
    
    }

    private String parsetd(String txt2parse, String longexp, String shortexp) {
        String result;
        Pattern patlong = Pattern.compile(longexp);
        Pattern patshort = Pattern.compile(shortexp);
        Matcher mat = patlong.matcher(txt2parse);
        if (mat.find()) {
            result = mat.group();
            mat = patshort.matcher(result);
            if (mat.find()) {
                return mat.group();
            }

        }
        return null;



    }

    private void init() throws FileNotFoundException, IOException {
        mappings = new PropertiesSpeedSimPL();
        ship2xpath = new HashMap<Ships, String>();
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

    
    public BattleResult sim(Fleet f1, FleetAndDefence f2, MilitaryTech t1, MilitaryTech t2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public BattleResult sim(Fleet f1, FleetAndDefence f2, MilitaryTech t1, MilitaryTech t2, PropulsionTech pt, Coords origin, Coords target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
