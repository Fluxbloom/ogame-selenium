/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import com.thoughtworks.selenium.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa z wykorzystaniem Selenium do grania w ogame
 * @author dyschemist
 */
public class Ogame extends SeleneseTestCase {
    
    MappingProperties mappings;
    HashMap<Mission, String> missionMap;
    HashMap<Ships, String> shipsMap;
    HashMap<Buildings, String> buildingMap;
    HashMap<Study, String> studyMap;
    HashMap<Defence, String> defenceMap;
    
    public Ogame() {
        System.out.print("Reading static mappings");
        try {
            mappings = new MappingProperties();
        } catch (IOException ex) {
            System.err.println(" [FAIL]");
        }
        System.out.println("[DONE]");
        System.out.print("Creating Mission Map");
        missionMap = new HashMap<Mission, String>();
        missionMap.put(Mission.MISSION_ACS, mappings.getFleetSend_missionAcs());
        missionMap.put(Mission.MISSION_ATTACK, mappings.getFleetSend_missionAtk());
        missionMap.put(Mission.MISSION_EXPLORE, mappings.getFleetSend_missionExp());
        missionMap.put(Mission.MISSION_KOLONIZE, mappings.getFleetSend_missionKol());
        missionMap.put(Mission.MISSION_MOON, mappings.getFleetSend_missionMoon());
        missionMap.put(Mission.MISSION_RECYCLE, mappings.getFleetSend_missionRec());
        missionMap.put(Mission.MISSION_SPY, mappings.getFleetSend_missionSzp());
        missionMap.put(Mission.MISSION_STATION, mappings.getFleetSend_missionSta());
        missionMap.put(Mission.MISSION_STAY, mappings.getFleetSend_missionZat());
        missionMap.put(Mission.MISSION_TRANSPORT, mappings.getFleetSend_missionTra());
        System.out.println("[DONE]");
        System.out.print("Creating Mission Map");
        shipsMap = new HashMap<Ships, String>();
        shipsMap.put(Ships.BOMB, mappings.getFleetSend_bomb());
        shipsMap.put(Ships.CM, mappings.getFleetSend_cm());
        shipsMap.put(Ships.DT, mappings.getFleetSend_dt());
        shipsMap.put(Ships.GS, mappings.getFleetSend_gs());
        shipsMap.put(Ships.KOL, mappings.getFleetSend_kol());
        shipsMap.put(Ships.KR, mappings.getFleetSend_kr());
        shipsMap.put(Ships.LM, mappings.getFleetSend_lm());
        shipsMap.put(Ships.NISZ, mappings.getFleetSend_nisz());
        shipsMap.put(Ships.OW, mappings.getFleetSend_ow());
        shipsMap.put(Ships.PAN, mappings.getFleetSend_pan());
        shipsMap.put(Ships.REC, mappings.getFleetSend_rec());
        shipsMap.put(Ships.SOND, mappings.getFleetSend_sond());
        System.out.println("[DONE]");
        System.out.print("Creating Building Map");
        buildingMap = new HashMap<Buildings, String>();
        buildingMap.put(Buildings.DEPOZYT, mappings.getBuilding_ds());
        buildingMap.put(Buildings.EKSTRAKTOR_DEUTERU, mappings.getBuilding_ed());
        buildingMap.put(Buildings.ELEKTROWNIA_FUZYJNA, mappings.getBuilding_ef());
        buildingMap.put(Buildings.ELEKTROWNIA_SLONECZNA, mappings.getBuilding_es());
        buildingMap.put(Buildings.FABRYKA_NANITOW, mappings.getBuilding_fn());
        buildingMap.put(Buildings.FABRYKA_ROBOTOW, mappings.getBuilding_fr());
        buildingMap.put(Buildings.KOPALNIA_KRYSZTALU, mappings.getBuilding_kc());
        buildingMap.put(Buildings.KOPALNIA_METALU, mappings.getBuilding_km());
        buildingMap.put(Buildings.LABORATORIUM_BADAWCZE, mappings.getBuilding_lb());
        buildingMap.put(Buildings.MAGAZYN_DEUTERU, mappings.getBuilding_md());
        buildingMap.put(Buildings.MAGAZYN_KRYSZTALU, mappings.getBuilding_mc());
        buildingMap.put(Buildings.MAGAZYN_METALU, mappings.getBuilding_mm());
        buildingMap.put(Buildings.SATELITA_SLONECZNA, mappings.getBuilding_ss());
        buildingMap.put(Buildings.SCHOWEK_DEUTERU, mappings.getBuilding_sd());
        buildingMap.put(Buildings.SCHOWEK_KRYSZTALU, mappings.getBuilding_sc());
        buildingMap.put(Buildings.SCHOWEK_METALU, mappings.getBuilding_sm());
        buildingMap.put(Buildings.SILOS_RAKIETOWY, mappings.getBuilding_sr());
        buildingMap.put(Buildings.STOCZNIA, mappings.getBuilding_st());
        buildingMap.put(Buildings.TERRAFORMER, mappings.getBuilding_te());
        System.out.println("[DONE]");
        System.out.print("Inititializing Selenium instance ");
        studyMap = new HashMap<Study, String>();
        studyMap.put(Study.ASTROFIZYKA, mappings.getStudy_af());
        studyMap.put(Study.NAPED_IMPULSOWY, mappings.getStudy_ni());
        studyMap.put(Study.NAPED_NADPRZESTRZENNY, mappings.getStudy_nn());
        studyMap.put(Study.NAPED_SPALINOWY, mappings.getStudy_nn());
        studyMap.put(Study.OPANCERZENIE, mappings.getStudy_op());
        studyMap.put(Study.ROZWOJ_GRAWITONOW, mappings.getStudy_rg());
        studyMap.put(Study.SIEC_BADAN, mappings.getStudy_sb());
        studyMap.put(Study.TECHNOLOGIA_BOJOWA, mappings.getStudy_tb());
        studyMap.put(Study.TECHNOLOGIA_ENERGETYCZNA, mappings.getStudy_te());
        studyMap.put(Study.TECHNOLOGIA_JONOWA, mappings.getStudy_tj());
        studyMap.put(Study.TECHNOLOGIA_KOMPUTEROWA, mappings.getStudy_tk());
        studyMap.put(Study.TECHNOLOGIA_LASEROWA, mappings.getStudy_tl());
        studyMap.put(Study.TECHNOLOGIA_NADPRZESTRZENNA, mappings.getStudy_tn());
        studyMap.put(Study.TECHNOLOGIA_OCHRONNA, mappings.getStudy_to());
        studyMap.put(Study.TECHNOLOGIA_PLAZMOWA, mappings.getStudy_tp());
        studyMap.put(Study.TECHNOLOGIA_SZPIEGOWSKA, mappings.getStudy_ts());        
        System.out.println("[DONE]");
        System.out.print("Inititializing Selenium instance ");
        defenceMap = new HashMap<Defence, String>();
        defenceMap.put(Defence.DUZA_POWLOKA, mappings.getDefence_dp());
        defenceMap.put(Defence.DUZY_LASER, mappings.getDefence_cl());
        defenceMap.put(Defence.DZIALO_GAUSSA, mappings.getDefence_dg());
        defenceMap.put(Defence.DZIALO_JONOWE, mappings.getDefence_dj());
        defenceMap.put(Defence.MALA_POWLOKA, mappings.getDefence_mp());
        defenceMap.put(Defence.MALY_LASER, mappings.getDefence_ll());
        defenceMap.put(Defence.PRZECIWRAKIETA, mappings.getDefence_pr());
        defenceMap.put(Defence.RAKITA_MIEDZYPLANETARNA, mappings.getDefence_rm());
        defenceMap.put(Defence.WYRZUTNIA_PLAZMY, mappings.getDefence_wp());
        defenceMap.put(Defence.WYRZUTNIA_RAKIET, mappings.getDefence_wr());
       
        System.out.println("[DONE]");
        System.out.print("Inititializing Selenium instance ");
        try {
            selenium = new DefaultSelenium("0.0.0.0", 4444, mappings.getBrowser(), mappings.getUrl()) {
                
                @Override
                public void open(String url) {
                    commandProcessor.doCommand("open", new String[]{url, "true"});
                }
            };
        } catch (Exception ex) {
            System.err.println(" [FAIL]");
        }
        System.out.println(" [DONE]");
        
    }
    
    private void start() {
        System.out.print("Starting selenium ");
        try {
            selenium.start();
            selenium.windowMaximize();
        } catch (Exception ex) {
            System.err.println("[FAIL]");
        }
        System.out.println("[DONE]");
    }
    
    private void stop() {
        System.out.print("Stoping selenium ");
        try {
            selenium.close();
            selenium.stop();
            super.tearDown();
        } catch (Exception ex) {
            System.err.println("[FAIL]");
        }
        System.out.println("[DONE]");
    }
    
    private void clickAndWait(String s) {
        selenium.click(s);
        selenium.waitForPageToLoad(mappings.getTimeout());
    }
    
    private void clickPrzeglad() {
        clickAndWait(mappings.getLeftButtonPrzegladaj());
    }
    
    private void clickSurowce() {
        clickAndWait(mappings.getLeftButtonSurowce());
    }
    
    private void clickStacja() {
        clickAndWait(mappings.getLeftButtonStacja());
    }
    
    private void clickBadania() {
        clickAndWait(mappings.getLeftButtonBadania());
    }
    
    private void clickObrona() {
        clickAndWait(mappings.getLeftButtonObrona());
    }
    
    private void clickStocznia() {
        clickAndWait(mappings.getLeftButtonStocznia());
    }
    
    private void clickFlota() {
        clickAndWait(mappings.getLeftButtonFlota());
    }
    
    private void sendFleetSetFleet(Fleet f) {
        if (f == Fleet.WHOLE_FLEET) {
            selenium.click(mappings.getFleetSend_sendAll());
        } else {
            HashMap<Ships, Integer> fleet = f.getFleet();
            Set set = fleet.entrySet();
            Iterator it = set.iterator();
            Ships temp2;
            Map.Entry<Ships,Integer> temp;
            while (it.hasNext()) {
                temp = (Map.Entry<Ships,Integer>) it.next();
                temp2 = temp.getKey();
                selenium.type(shipsMap.get(temp2), ((Integer) fleet.get(temp2)).toString());
            }
        }
    }
    
    private void sendFleetSetCords(Cords c) {
        selenium.type(mappings.getFleetSend_galaxy(), c.getUniverse());
        selenium.type(mappings.getFleetSend_system(), c.getSystem());
        selenium.type(mappings.getFleetSend_position(), c.getPosition());
    }
    
    private void sendFleetSetMission(Mission m) {
        selenium.click((String) missionMap.get(m));
    }
    
    private void sendFleetSetResources(Resources r) {
        if (r == Resources.ALL_RESOURCES) {
            selenium.click(mappings.getFleetSend_allResources());
        } else {
            selenium.type(mappings.getFleetSend_metal(), r.getMetal());
            selenium.type(mappings.getFleetSend_crystal(), r.getCrystal());
            selenium.type(mappings.getFleetSend_deuter(), r.getDeuter());
        }
    }
   
    
    public void login(String uni, String user, String pass) {
        this.start();
        selenium.open(mappings.getGameUrl());
        // Jeśli zamknij widoczne to nic nie rób, jeśli 
        if (!selenium.isTextPresent(mappings.getLogin_closed_login_frame())) {
            // Jeśli nie obecny to
            selenium.click(mappings.getLogin_login_button());
        }
        selenium.select("id=serverLogin", "label=" + uni);
        selenium.type("name=login", "");
        selenium.type("name=login", user);
        selenium.type("name=pass", "");
        selenium.type("name=pass", pass);
        selenium.click("id=loginSubmit");
        selenium.waitForPageToLoad("30000");
        
    }
    
    public void logout() {
        // Wylogowanie
        selenium.click("link=Wyloguj");
        selenium.waitForPageToLoad("30000");
        this.stop();
    }
    
    public void sendFleet(Fleet f, Cords c, Speed speed, Mission m, Resources r) {
        this.clickFlota();
        this.sendFleetSetFleet(f);
        if (selenium.isElementPresent(mappings.getFleetSend_errorscreen1())) {
            System.err.println("Couldnt send fleet - screen 1");
            return;
        } //TODO error tutaj
        clickAndWait(mappings.getFleetSend_okscreen1());
        this.sendFleetSetCords(c);
        selenium.select(mappings.getFleetSend_speed(), mappings.getFleetSend_speed_ans() + speed.getS());
        if (selenium.isElementPresent(mappings.getFleetSend_errorscreen2())) {
            System.err.println("Couldnt send fleet - screen 2");
            return;
        } // TODO error tutaj
        clickAndWait(mappings.getFleetSend_okscreen2());
        sendFleetSetMission(m);
        sendFleetSetResources(r);
        if (selenium.isElementPresent(mappings.getFleetSend_errorscreen3())) {
            System.err.println("Couldnt send fleet - screen 3");
            return;
        } // TODO error tu
        clickAndWait(mappings.getFleetSend_okscreen3());
    }

    public void build(Buildings b){
        if(b==Buildings.FABRYKA_ROBOTOW || b==Buildings.STOCZNIA || b==Buildings.LABORATORIUM_BADAWCZE || b==Buildings.DEPOZYT || b==Buildings.SILOS_RAKIETOWY || b==Buildings.FABRYKA_NANITOW || b==Buildings.TERRAFORMER){
            this.clickStacja();
            selenium.click(buildingMap.get(b));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ogame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getBuilding_stationNEG())){
                return; // TODO some error here
            }
            this.clickAndWait(mappings.getBuilding_stationOK());
        }else{ 
            this.clickSurowce();
                        selenium.click(buildingMap.get(b));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ogame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getBuilding_resourcesNEG())){
                System.err.print("element not present");
                return; // TODO some error here
            }
            this.clickAndWait(mappings.getBuilding_resourcesOK());
        }
        
        
    }

    
    public void study(Study s){
            this.clickBadania();
            selenium.click(studyMap.get(s));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ogame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getStudyNEG())){
                return; // TODO some error here
            }
            this.clickAndWait(mappings.getStudyOK());
    }
    
        public void defence(Defence d){
            this.clickObrona();
            selenium.click(defenceMap.get(d));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ogame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getDefenceNEG())){
                return; // TODO some error here
            }
            this.clickAndWait(mappings.getDefenceOK());
    }
    
}
