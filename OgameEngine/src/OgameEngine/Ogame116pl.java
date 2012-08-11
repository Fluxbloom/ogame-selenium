/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.Destination;
import OgameEngine.Coords.StartDestination;
import OgameEngine.Fleet.Ships;
import OgameEngine.Fleet.ShipyardShips;
import OgameEngine.Events.FriendOrFoe;
import OgameEngine.Events.Multiplicity;
import OgameEngine.Performance.Production;
import OgameEngine.Performance.ResourceField;
import com.thoughtworks.selenium.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa z wykorzystaniem Selenium do grania w ogame
 * @author dyschemist
 */
class Ogame116pl extends Ogame {//extends SeleneseTestCase {

    private MappingProperties mappings;
    private HashMap<Mission, String> missionMap;
    private HashMap<Ships, String> shipsMap;
    private HashMap<Buildings, String> buildingMap;
    private HashMap<Study, String> studyMap;
    private HashMap<Defence, String> defenceMap;
    private HashMap<ShipyardShips, String> shipyardMap;
    private HashMap<Performance.ResourceField, String> performanceMap;
    private HashMap<Ships, String> fleetMap;
    private HashMap<Study, String> technologyMap;
    private HashMap<Defence, String> defcountMap;
    private HashMap<String, Mission> slotMissionMap;
    private SimpleDateFormat slotParse;
    private SimpleDateFormat reversalParse;
    private SimpleDateFormat comeBackParse;

    public Ogame116pl() {
        System.out.print("Reading static mappings");
        try {
            mappings = new MappingProperties();
        } catch (IOException ex) {
            System.err.println(" [FAIL]");
        }
        System.out.println("[DONE]");
        System.out.print("Initializing Mission Map");
        missionMap = new HashMap<>();
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
        System.out.print("Initializing Ships Map");
        shipsMap = new HashMap<>();
        shipsMap.put(Ships.BOMB, mappings.getFleetSend_bomb());//1
        shipsMap.put(Ships.CM, mappings.getFleetSend_cm());//2
        shipsMap.put(Ships.DT, mappings.getFleetSend_dt());//3
        shipsMap.put(Ships.GS, mappings.getFleetSend_gs());//4
        shipsMap.put(Ships.KOL, mappings.getFleetSend_kol());//5
        shipsMap.put(Ships.KR, mappings.getFleetSend_kr());//6
        shipsMap.put(Ships.LM, mappings.getFleetSend_lm());//7
        shipsMap.put(Ships.MT, mappings.getFleetSend_mt());//8
        shipsMap.put(Ships.NISZ, mappings.getFleetSend_nisz());//9
        shipsMap.put(Ships.OW, mappings.getFleetSend_ow());//10
        shipsMap.put(Ships.PAN, mappings.getFleetSend_pan());//11
        shipsMap.put(Ships.REC, mappings.getFleetSend_rec());//12
        shipsMap.put(Ships.SOND, mappings.getFleetSend_sond());//13
        System.out.println("[DONE]");
        System.out.print("Initializing Building Map");
        buildingMap = new HashMap<>();
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
        System.out.print("Initializing Study Map");
        studyMap = new HashMap<>();
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
        System.out.print("Initializing Defence Map");
        defenceMap = new HashMap<>();
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
        System.out.print("Initializing Shipyard Map");
        shipyardMap = new HashMap<>();
        shipyardMap.put(Ships.BOMB, mappings.getShipyard_bomb());
        shipyardMap.put(Ships.CM, mappings.getShipyard_cm());
        shipyardMap.put(Ships.DT, mappings.getShipyard_dt());
        shipyardMap.put(Ships.GS, mappings.getShipyard_gs());
        shipyardMap.put(Ships.KOL, mappings.getShipyard_skol());
        shipyardMap.put(Ships.KR, mappings.getShipyard_kraz());
        shipyardMap.put(Ships.LM, mappings.getShipyard_lm());
        shipyardMap.put(Ships.MT, mappings.getShipyard_mt());
        shipyardMap.put(Ships.NISZ, mappings.getShipyard_nisc());
        shipyardMap.put(Ships.OW, mappings.getShipyard_ow());
        shipyardMap.put(Ships.PAN, mappings.getShipyard_panc());
        shipyardMap.put(Ships.REC, mappings.getShipyard_rec());
        shipyardMap.put(Ships.SOND, mappings.getShipyard_ss());
        shipyardMap.put(Ships.SAT, mappings.getShipyard_sat());
        System.out.println("[DONE]");
        System.out.print("Initializing Performance Map");
        performanceMap = new HashMap<>();
        performanceMap.put(Performance.METAL, mappings.getPerformance_m());
        performanceMap.put(Performance.KRYSZTAL, mappings.getPerformance_k());
        performanceMap.put(Performance.DEUTER, mappings.getPerformance_d());
        performanceMap.put(Performance.EL_SLONECZNA, mappings.getPerformance_es());
        performanceMap.put(Performance.EL_FUZYJNA, mappings.getPerformance_ef());
        performanceMap.put(Performance.SAT_SLONECZNA, mappings.getPerformance_ss());
        System.out.println("[DONE]");
        System.out.print("Initializing Fleet-Size Map");
        fleetMap = new HashMap<>();
        fleetMap.put(Ships.BOMB, mappings.getHm_bomb());//1
        fleetMap.put(Ships.CM, mappings.getHm_cm());//2
        fleetMap.put(Ships.DT, mappings.getHm_dt());//3
        fleetMap.put(Ships.GS, mappings.getHm_gs());//4
        fleetMap.put(Ships.KOL, mappings.getHm_skol());//5
        fleetMap.put(Ships.KR, mappings.getHm_kraz());//6
        fleetMap.put(Ships.LM, mappings.getHm_lm());//7
        fleetMap.put(Ships.MT, mappings.getHm_mt());//8
        fleetMap.put(Ships.NISZ, mappings.getHm_nisc());//9
        fleetMap.put(Ships.OW, mappings.getHm_ow());//10
        fleetMap.put(Ships.PAN, mappings.getHm_panc());//11
        fleetMap.put(Ships.REC, mappings.getHm_rec());//12
        fleetMap.put(Ships.SOND, mappings.getHm_ss());//13
        System.out.println("[DONE]");
        System.out.print("Initializing Technology-level Map");
        technologyMap = new HashMap<>();
        technologyMap.put(Study.TECHNOLOGIA_ENERGETYCZNA, mappings.getHm_te());//1
        technologyMap.put(Study.TECHNOLOGIA_LASEROWA, mappings.getHm_tl());//2
        technologyMap.put(Study.TECHNOLOGIA_JONOWA, mappings.getHm_tj());//3
        technologyMap.put(Study.TECHNOLOGIA_NADPRZESTRZENNA, mappings.getHm_tn());//4
        technologyMap.put(Study.TECHNOLOGIA_PLAZMOWA, mappings.getHm_tp());//5
        technologyMap.put(Study.NAPED_SPALINOWY, mappings.getHm_ns());//6
        technologyMap.put(Study.NAPED_IMPULSOWY, mappings.getHm_ni());//7
        technologyMap.put(Study.NAPED_NADPRZESTRZENNY, mappings.getHm_nn());//8
        technologyMap.put(Study.TECHNOLOGIA_SZPIEGOWSKA, mappings.getHm_ts());//9
        technologyMap.put(Study.TECHNOLOGIA_KOMPUTEROWA, mappings.getHm_tk());//10
        technologyMap.put(Study.ASTROFIZYKA, mappings.getHm_af());//11
        technologyMap.put(Study.SIEC_BADAN, mappings.getHm_ms());//12
        technologyMap.put(Study.ROZWOJ_GRAWITONOW, mappings.getHm_rg());//13
        technologyMap.put(Study.TECHNOLOGIA_BOJOWA, mappings.getHm_tb());//13
        technologyMap.put(Study.TECHNOLOGIA_OCHRONNA, mappings.getHm_to());//13
        technologyMap.put(Study.OPANCERZENIE, mappings.getHm_op());//13
        System.out.println("[DONE]");
        System.out.print("Inititializing defcountMap");
        defcountMap = new HashMap<>();
        defcountMap.put(Defence.DUZA_POWLOKA, mappings.getHm_dp());
        defcountMap.put(Defence.DUZY_LASER, mappings.getHm_cl());
        defcountMap.put(Defence.DZIALO_GAUSSA, mappings.getHm_dg());
        defcountMap.put(Defence.DZIALO_JONOWE, mappings.getHm_dj());
        defcountMap.put(Defence.MALA_POWLOKA, mappings.getHm_mp());
        defcountMap.put(Defence.MALY_LASER, mappings.getHm_ll());
        defcountMap.put(Defence.PRZECIWRAKIETA, mappings.getHm_pr());
        defcountMap.put(Defence.RAKITA_MIEDZYPLANETARNA, mappings.getHm_rm());
        defcountMap.put(Defence.WYRZUTNIA_PLAZMY, mappings.getHm_wp());
        defcountMap.put(Defence.WYRZUTNIA_RAKIET, mappings.getHm_wr());
        System.out.println("[DONE]");
        System.out.print("Initilizing Slot Mission Map");
        slotMissionMap = new HashMap<>();
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_ACS), Mission.MISSION_ACS);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_ATTACK), Mission.MISSION_ATTACK);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_EXPLORE), Mission.MISSION_EXPLORE);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_KOLONIZE), Mission.MISSION_KOLONIZE);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_MOON), Mission.MISSION_MOON);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_RECYCLE), Mission.MISSION_RECYCLE);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_SPY), Mission.MISSION_SPY);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_STATION), Mission.MISSION_STATION);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_STAY), Mission.MISSION_STAY);
        slotMissionMap.put(mappings.getSlotMissionID(Mission.MISSION_TRANSPORT), Mission.MISSION_TRANSPORT);
        System.out.println("[DONE]");


        System.out.print("Initializing parsers");
        this.slotParse = new SimpleDateFormat(mappings.getSlots_parseArrival());
        this.reversalParse = new SimpleDateFormat(mappings.getSlots_parseReversal());
        this.comeBackParse = new SimpleDateFormat(mappings.getSlots_parseReturn());
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

    void start() {
        System.out.print("Starting selenium ");
        try {
            selenium.start();
            selenium.windowMaximize();
        } catch (Exception ex) {
            System.err.println("[FAIL]");
        }
        System.out.println("[DONE]");
    }

    void stop() {
        System.out.print("Stoping selenium ");
        try {
            selenium.close();
            selenium.stop();
        } catch (Exception ex) {
            System.err.println("[FAIL]");
        }
        System.out.println("[DONE]");

    }

    private void clickAndWait(String s) {
        selenium.click(s);
        selenium.waitForPageToLoad(mappings.getTimeout());
    }

    // TODO gdy nie widoczny lewy panel powinno się przelogować ponownie
    private void clickPrzeglad() {
        wait(1);
        clickAndWait(mappings.getLeftButtonPrzegladaj());
        wait(1);
    }

    private void clickSurowce() {
        clickAndWait(mappings.getLeftButtonSurowce());
        wait(1);
    }

    private void clickStacja() {
        clickAndWait(mappings.getLeftButtonStacja());
        wait(1);
    }

    private void clickBadania() {
        clickAndWait(mappings.getLeftButtonBadania());
    }

    private void clickObrona() {
        clickAndWait(mappings.getLeftButtonObrona());
        wait(1);
    }

    private void clickStocznia() {
        clickAndWait(mappings.getLeftButtonStocznia());
        wait(1);
    }

    private void clickFlota() {
        clickAndWait(mappings.getLeftButtonFlota());
        wait(1);
    }

    private void clickEventList() {
        this.clickPrzeglad();
        wait(1);
        if (!selenium.isTextPresent(mappings.getLeftButtonEventList_empty())){
            selenium.click(mappings.getLeftButtonEventList());
            wait(1);
        }
    }

    private void clickResourceSettings() {
        clickAndWait(mappings.getLeftButtonResourceSettings());
        wait(1);
    }

    private void clickMovements() {
        clickAndWait(mappings.getLeftButtonFlightsList());
        wait(1);
    }

    private boolean sendFleetCheckIfAble(Fleet f, Mission m) throws OgameException {
        boolean result = true;
        if (m == Mission.MISSION_ACS) {
            throw OgameException.UNSUPPORTED_MISSION;
        } else if (m == Mission.MISSION_EXPLORE && f.get(Ships.KOL) == 0) {
            result = false;
        } else if (m == Mission.MISSION_MOON && f.get(Ships.GS) == 0) {
            result = false;
        } else if (m == Mission.MISSION_RECYCLE && f.get(Ships.REC) == 0) {
            result = false;
        } else if (m == Mission.MISSION_SPY && f.get(Ships.SOND) == 0) {
            result = false;
        }
        return result;
    }

    private void sendFleetSetFleet(Fleet f) {
        if (f == Fleet.WHOLE_FLEET) {
            selenium.click(mappings.getFleetSend_sendAll());
        } else {
            HashMap<Ships, Integer> fleet = f.getFleet();
            Set set = fleet.entrySet();
            Iterator it = set.iterator();
            Ships temp2;
            Map.Entry<Ships, Integer> temp;
            while (it.hasNext()) {
                temp = (Map.Entry<Ships, Integer>) it.next();
                temp2 = temp.getKey();
                selenium.type(shipsMap.get(temp2), ((Integer) fleet.get(temp2)).toString());
            }
        }
    }

    private void sendFleetSetCords(Coords c, Destination d) {
        if (d == Destination.PLANET && selenium.isElementPresent(mappings.getFleetSend_start_planet_deselected())) {
            selenium.click(mappings.getFleetSend_start_planet_deselected());
        } else if (d == Destination.MOON && selenium.isElementPresent(mappings.getFleetSend_start_moon_deselected())) {
            selenium.click(mappings.getFleetSend_start_moon_deselected());
        }
        selenium.type(mappings.getFleetSend_galaxy(), c.getUniverse());
        selenium.type(mappings.getFleetSend_system(), c.getSystem());
        selenium.type(mappings.getFleetSend_position(), c.getPosition());
        if (c.getDest() == Destination.PLANET && selenium.isElementPresent(mappings.getFleetSend_target_planet_deselected())) {
            selenium.click(mappings.getFleetSend_target_planet_deselected());
        } else if (c.getDest() == Destination.MOON && selenium.isElementPresent(mappings.getFleetSend_target_moon_deselected())) {
            selenium.click(mappings.getFleetSend_target_moon_deselected());
        } else if (c.getDest() == Destination.PZ && selenium.isElementPresent(mappings.getFleetSend_target_debris_deselected())) {
            selenium.click(mappings.getFleetSend_target_debris_deselected());
        }
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

    /*
     * METODY PUBLICZNE 
     */
    @Override
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void wait(int minute, int seconds) {
        wait(minute * 60 + seconds);
    }

    @Override
    public void wait(int hour, int minute, int seconds) {
        wait(hour * 60 + minute, seconds);
    }



    @Override
    public void login(String uni, String user, String pass) throws OgameException {
        this.start();
        try {
        selenium.open(mappings.getGameUrl());
        // Jeśli zamknij widoczne to nic nie rób, jeśli 
        if (!selenium.isTextPresent(mappings.getLogin_closed_login_frame())) {
            // Jeśli nie obecny to
            selenium.click(mappings.getLogin_login_button());
        }
        selenium.select(mappings.getLogin_uni_target(), mappings.getLogin_uni_pref() + uni);
        selenium.type(mappings.getLogin_nick_target(), user);
        selenium.type(mappings.getLogin_pass_target(), pass);
        clickAndWait(mappings.getLogin_login_with_pass_button());
        } catch (SeleniumException ex){
            System.err.println("Inner Error "+ex.getMessage());
            if (ex.getMessage().compareTo("ERROR: Current window or frame is closed!")==0) {
                throw OgameException.LOGIN_BROWSER_CLOSED;
            } else if (ex.getMessage().contains("Timed out after ")){
                throw OgameException.LOGIN_NO_INTERNET_CONNECTION;
            }
            
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        if (selenium.isTextPresent(mappings.getLogin_wrongPassword())){
            throw OgameException.LOGIN_WRONG_PASSWORD;
        }
    }

    @Override
    public boolean isLogged() throws OgameException {
        try {
            selenium.refresh();
            this.wait(1);
            if (selenium.isElementPresent(mappings.getLogin_isLoggedIn_xpath())){
             return selenium.getAttribute(mappings.getLogin_isLoggedIn_xpath_atribute()).compareTo(mappings.getLogin_isLoggedIn_response())==0;
            } else
                return false;
        } catch (SeleniumException ex) {
            System.err.println(ex.getMessage());
            return false;
        } catch ( Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void relogin(String uni, String user, String pass) throws OgameException {
        selenium.open(mappings.getGameUrl());


        // Jeśli zamknij widoczne to nic nie rób, jeśli 
        if (!selenium.isTextPresent(mappings.getLogin_closed_login_frame())) {
            // Jeśli nie obecny to
            selenium.click(mappings.getLogin_login_button());
        }
        selenium.select(mappings.getLogin_uni_target(), mappings.getLogin_uni_pref() + uni);
        selenium.type(mappings.getLogin_nick_target(), user);
        selenium.type(mappings.getLogin_pass_target(), pass);
        clickAndWait(mappings.getLogin_login_with_pass_button());
    }

    @Override
    public void logout() throws OgameException {
        // Wylogowanie
        try {
        clickAndWait(mappings.getLogout_button());
        } finally {
        this.stop();
        }
    }

    @Override
    public void close() {
        this.stop();
    }

    @Override
    public int getPlanetCount() throws OgameException {
        String s = selenium.getText(mappings.getCountplanet());
        return Integer.parseInt(s.split(mappings.getCountplanet_separator())[mappings.getCountplanet_result_pos() - 1]);
    }

    @Override
    public List<Planet> getPlanetList() throws OgameException {
        int size = this.getPlanetCount();
        List<Planet> result = new ArrayList<Planet>();
        Planet temp;
        String name;
        Coords coords;
        for (int i=1;i<size+1;i++){
            name = selenium.getText(mappings.getChangeplanetgetName(i));
            coords = Coords.parse(selenium.getText(mappings.getChangeplanetgetCoords(i)));
            temp = new Planet(coords,name);
            result.add(temp);
        }
        return result;
    }

    @Override
    public void changePlanet(int planetNumber) throws OgameException {
        clickAndWait(mappings.getChangeplanetbyid(planetNumber));
        wait(1);
    }

    @Override
    public void changePlanetByName(String name) throws OgameException {
        clickAndWait(mappings.getChangeplanetbyName(name));
        wait(1);
    }
    
    @Override
    public void changePlanetByCoords(Coords c) throws OgameException {
        String xpath = mappings.getChangeplanetbyCoords(c);
        clickAndWait(xpath);
        wait(1);
    }

    // TODO Wymaga kolejnych popraw
    /*
     * 1. brak obsługi błędu braku floty na planecie
     * 2. Może jednak zmontować ten ACS
     * 3. można poprawić stacjonowanie
     * 4. Czy misja określa cel planety
     * 5. blokada celow przy esploracji
     * 6. Same sondy nie mogą nic prócz szpiegowania i stacjonowana
     */
    @Override
    public void sendFleet(Fleet f, StartDestination d, Coords c, Speed speed, Mission m, Resources r) throws OgameException {
        // sprawdzamy czy flota ma dostępną misję
        if (!this.sendFleetCheckIfAble(f, m)) {
            throw new OgameException("THE FOLLOWING FLEET CANNOT BE ASSIGNED TO THIS TYPE OF MISSIONS");
        }
        this.clickFlota();
        wait(0, 1);
        System.out.print("Set Fleet ");
        this.sendFleetSetFleet(f);
        System.out.println(" [DONE]");
        if (selenium.isElementPresent(mappings.getFleetSend_errorscreen1())) {
            System.err.println("Couldnt send fleet - screen 1");
            throw new OgameException("FLEET SEND FIRST SCREEN ERROR");
        }
        clickAndWait(mappings.getFleetSend_okscreen1());
        wait(0, 1);
        this.sendFleetSetCords(c, d);
        selenium.select(mappings.getFleetSend_speed(), mappings.getFleetSend_speed_ans() + speed.getS());
        if (selenium.isElementPresent(mappings.getFleetSend_errorscreen2())) {
            System.err.println("Couldnt send fleet - screen 2");
            throw new OgameException("FLEET SEND SECOND SCREEN ERROR");
        }
        clickAndWait(mappings.getFleetSend_okscreen2());
        sendFleetSetMission(m);
        sendFleetSetResources(r);
        if (selenium.isElementPresent(mappings.getFleetSend_errorscreen3())) {
            System.err.println("Couldnt send fleet - screen 3");
            throw new OgameException("FLEET SEND THIRD SCREEN ERROR");
        }
        clickAndWait(mappings.getFleetSend_okscreen3());
        this.clickPrzeglad();
    }

    @Override
    public void sendFleet(Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException {
        this.sendFleet(f, StartDestination.PLANET, c, speed, m, r);

    }

    @Override
    public void sendFleet(Fleet f, Coords c, Mission m, Resources r) throws OgameException {
        this.sendFleet(f, StartDestination.PLANET, c, Speed.S100, m, r);
    }

    @Override
    public void build(Buildings b) throws OgameException {
        if (b == Buildings.FABRYKA_ROBOTOW || b == Buildings.STOCZNIA || b == Buildings.LABORATORIUM_BADAWCZE || b == Buildings.DEPOZYT || b == Buildings.SILOS_RAKIETOWY || b == Buildings.FABRYKA_NANITOW || b == Buildings.TERRAFORMER) {
            this.clickStacja();
            selenium.click(buildingMap.get(b));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getBuilding_stationNEG())) {
                return; // TODO some error here
            }
            this.clickAndWait(mappings.getBuilding_stationOK());
        } else {
            this.clickSurowce();
            selenium.click(buildingMap.get(b));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getBuilding_resourcesNEG())) {
                System.err.print("element not present");
                return; // TODO some error here
            }
            this.clickAndWait(mappings.getBuilding_resourcesOK());
        }


    }

    @Override
    public void study(Study s) throws OgameException {
        this.clickBadania();
        selenium.click(studyMap.get(s));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.clickAndWait(buildingMap.get(b)); //selenium.click
        if (selenium.isElementPresent(mappings.getStudyNEG())) {
            return; // TODO some error here
        }
        this.clickAndWait(mappings.getStudyOK());
    }

    @Override
    public void buildDefence(Defence d, int i) throws OgameException {
        buildDefence(d, Integer.toString(i));
    }

    @Override
    public void buildDefence(Defence d, String count) throws OgameException {
        this.clickObrona();
        selenium.click(defenceMap.get(d));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.clickAndWait(buildingMap.get(b)); //selenium.click
        selenium.type(mappings.getDefence_number(), count);
        if (selenium.isElementPresent(mappings.getDefenceNEG())) {
            return; // TODO some error here
        }
        this.clickAndWait(mappings.getDefenceOK());
    }

    @Override
    public void buildShip(ShipyardShips s, int i) throws OgameException {
        buildShip(s, Integer.toString(i));
    }

    @Override
    public void buildShip(ShipyardShips s, String count) throws OgameException {
        this.clickStocznia();
        selenium.click(shipyardMap.get(s));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
        selenium.type(mappings.getShipyard_number(), count);
        if (selenium.isElementPresent(mappings.getShipyard_NEG())) {
            return; //dodac OgameException
        }
        clickAndWait(mappings.getShipyard_OK());
    }

    @Override
    public List<String> getPlanetNames() throws OgameException {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<>();
        for (int j = 1; j < i + 1; j++) {
            list.add(selenium.getText(mappings.getChangeplanetgetName(j)));
        }
        return list;
    }

    @Override
    public List<String> getPlanetCoords() throws OgameException {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<>();
        for (int j = 1; j < i + 1; j++) {
            list.add(selenium.getText(mappings.getChangeplanetgetCoords(j)));
        }
        return list;
    }
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");

    private Calendar parseArrivalTime(String countDownTime, String arrivalTime) throws OgameException {
        int[] countDownList = new int[4];
        String day = mappings.getEvent_list_time_parser_day();
        String hour = mappings.getEvent_list_time_parser_hour();
        String min = mappings.getEvent_list_time_parser_minute();
        String second = mappings.getEvent_list_time_parser_second();
        countDownList[0] = Integer.parseInt(
                countDownTime.substring(0, Math.max(countDownTime.indexOf(day), 0)).isEmpty()
                ? "0" : countDownTime.substring(0, Math.max(countDownTime.indexOf(day), 0)).replace(" ", ""));
        countDownTime = countDownTime.substring(Math.max(countDownTime.indexOf(day) + day.length(), 0));
        countDownList[1] = Integer.parseInt(
                countDownTime.substring(0, Math.max(countDownTime.indexOf(hour), 0)).isEmpty()
                ? "0" : countDownTime.substring(0, Math.max(countDownTime.indexOf(hour), 0)).replace(" ", ""));
        countDownTime = countDownTime.substring(Math.max(countDownTime.indexOf(hour) + hour.length(), 0));
        countDownList[2] = Integer.parseInt(
                countDownTime.substring(0, Math.max(countDownTime.indexOf(min), 0)).isEmpty()
                ? "0" : countDownTime.substring(0, Math.max(countDownTime.indexOf(min), 0)).replace(" ", ""));
        countDownTime = countDownTime.substring(Math.max(countDownTime.indexOf(min) + min.length(), 0));
        countDownList[3] = Integer.parseInt(
                countDownTime.substring(0, Math.max(countDownTime.indexOf(second), 0)).isEmpty()
                ? "0" : countDownTime.substring(0, Math.max(countDownTime.indexOf(second), 0)).replace(" ", ""));
        String[] str = arrivalTime.split(":");
        int[] i = new int[3];
        i[0] = Integer.parseInt(str[0]);
        i[1] = Integer.parseInt(str[1]);
        i[2] = Integer.parseInt(str[2].substring(0, str[2].indexOf(" ")));
        Calendar result = new GregorianCalendar();
        int t = countDownList[0] * 24 + countDownList[1];
        result.add(Calendar.HOUR_OF_DAY, t);
        result.add(Calendar.MINUTE, countDownList[2]);
        result.add(Calendar.SECOND, countDownList[3]);
        result.set(Calendar.HOUR_OF_DAY, i[0]);
        result.set(Calendar.MINUTE, i[1]);
        result.set(Calendar.SECOND, i[2]);
        return result;
    }

    @Override
    public List<Events> getEventList() throws OgameException {
        // najpierw ilosc pozycji
        this.clickEventList();
        if (selenium.isTextPresent(mappings.getLeftButtonEventList_empty()))
            return new ArrayList<>();
        int iloscFlot = selenium.getXpathCount(mappings.getEvent_list_root()).intValue();
        String flightXPath;
        int id;
        FriendOrFoe nastawienie;
        Multiplicity mp;
        Calendar arrival;
        Coords origin;
        Coords target;
        String contentLink;
        Map<String,String> content; 
        int size;
        List<Events> lista = new ArrayList<>();

        for (int i = 1; i < iloscFlot + 1; i++) {
            // konwersja na loty
            flightXPath = mappings.getEvent_list_flight(i);
            // parsowanie id
            id = Integer.parseInt(selenium.getAttribute(flightXPath+mappings.getEvent_list_id_atribute()).replace(mappings.getEvent_list_id_atribute_prefix(), "")); 
            // ustalanie typu lotu
            if (selenium.getAttribute(flightXPath + mappings.getEvent_list_class_atribute()).compareTo(
                    mappings.getEvent_list_class_atribute_friendly()) == 0
                    | selenium.getAttribute(flightXPath + mappings.getEvent_list_class_atribute()).compareTo(
                    mappings.getEvent_list_class_atribute_friendly_return()) == 0) {
                mp = Events.SINGLE_FLEET;
            } else if (selenium.getAttribute(flightXPath + mappings.getEvent_list_class_atribute()).compareTo(
                    mappings.getEvent_list_class_atribute_enemy_alliance()) == 0) {
                mp = Events.ACS_FLEET;
            } else {
                throw new OgameException("Error cannot recognized is fleet a single or ACS");
            }
            // sprawdźmy nastawienie floty
            if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_friendly())) {
                nastawienie = Events.FRIEND;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_neutral())) {
                nastawienie = Events.NEUTRAL;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_enemy())
                    & selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_spy())) {
                nastawienie = Events.SPY;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_enemy())
                    & selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_attack())) {
                nastawienie = Events.ATTACK;
            } else {
                throw new OgameException("Error cannot recognized whether the fleet is friend or foe");
            }
            if (selenium.getText(flightXPath + mappings.getEvent_list_atribute_count_down_time()).compareTo(mappings.getEvent_list_time_parser_ingore())==0) continue;
            arrival = this.parseArrivalTime(
                    selenium.getText(flightXPath + mappings.getEvent_list_atribute_count_down_time()),
                    selenium.getText(flightXPath + mappings.getEvent_list_atribute_arrival_time()));
            if (mp == Events.SINGLE_FLEET) {
                origin = Coords.parse(selenium.getText(flightXPath + mappings.getEvent_list_atribute_originCoords()));
            } else {
                origin = null;
            }
            target = Coords.parse(selenium.getText(flightXPath + mappings.getEvent_list_atribute_destCoords()));
            size = Integer.parseInt(selenium.getText(flightXPath + mappings.getEvent_list_atribute_detailsFleet()));
            // parsowanie składu floty
            contentLink=selenium.getAttribute(flightXPath+mappings.getEvent_list_atribute_icon_movement());
            System.err.println("Cutting content");
            content = getContent(contentLink);
            lista.add(new Events(id,nastawienie, mp, arrival, origin, size, target));

        }

        return lista;

    }

    @Override
    public void setResourcesSettings(ResourceField r, Production p) throws OgameException {
        this.clickResourceSettings();
        this.selenium.select(this.performanceMap.get(r), mappings.getPerformance_select() + p.getS());
        this.selenium.click(this.mappings.getPerformance_ok());

    }

    @Override
    public void setResourcesSettings(Performance p) throws OgameException {
        this.clickResourceSettings();
        this.selenium.select(this.performanceMap.get(Performance.METAL), mappings.getPerformance_select() + p.getMetal().getS());
        this.selenium.select(this.performanceMap.get(Performance.KRYSZTAL), mappings.getPerformance_select() + p.getKrzysztal().getS());
        this.selenium.select(this.performanceMap.get(Performance.DEUTER), mappings.getPerformance_select() + p.getDeuter().getS());
        this.selenium.select(this.performanceMap.get(Performance.EL_SLONECZNA), mappings.getPerformance_select() + p.getEl_Sloneczna().getS());
        this.selenium.select(this.performanceMap.get(Performance.EL_FUZYJNA), mappings.getPerformance_select() + p.getEl_Fuzyjna().getS());
        this.selenium.select(this.performanceMap.get(Performance.SAT_SLONECZNA), mappings.getPerformance_select() + p.getSat_Sloneczna().getS());
        this.selenium.click(this.mappings.getPerformance_ok());
    }

    @Override
    public Fleet getPlanetFleet() throws OgameException {
        this.clickFlota();
        Fleet result = new Fleet();
        Set set = fleetMap.entrySet();
        Iterator it = set.iterator();
        Ships temp;
        Map.Entry<Ships, String> temp2;
        String temp3;
        int i;
        while (it.hasNext()) {
            temp2 = (Map.Entry<Ships, String>) it.next();
            temp = temp2.getKey();
            temp3 = selenium.getAttribute(temp2.getValue());
            temp3 = temp3.substring(temp3.indexOf("(") + 1, temp3.indexOf(")"));
            i = Integer.parseInt(temp3);
            if (i > 0) {
                result.add(temp, temp3);
            }
        }
        return result;
    }

    @Override
    public HashMap<Study, Integer> getPlanetStudy() throws OgameException {
        HashMap<Study, Integer> result = new HashMap<>();
        this.clickBadania();
        Set set = this.technologyMap.entrySet(); // to jest pobranie listy wszystkich par technologia-xpath
        Iterator it = set.iterator();
        Study temp;
        Map.Entry<Study, String> temp2;
        String temp3;
        int i;
        while (it.hasNext()) {
            temp2 = (Map.Entry<Study, String>) it.next();
            temp = temp2.getKey();
            temp3 = selenium.getText(temp2.getValue());
            temp3 = temp3.replace(selenium.getText(temp2.getValue() + "/span"), "").replace(" ", ""); //usuwanie wewnetrznego spana i spacji.
            i = Integer.parseInt(temp3);
            if (i > 0) {
                result.put(temp, new Integer(temp3));
            }
        }
        return result;

    }

    @Override
    public HashMap<Defence, Integer> getPlanetDefence() throws OgameException {
        HashMap<Defence, Integer> result = new HashMap<>();
        this.clickObrona();
        Set set = this.defcountMap.entrySet(); // to jest pobranie listy wszystkich par technologia-xpath
        Iterator it = set.iterator();
        Defence temp;
        Map.Entry<Defence, String> temp2;
        String temp3;
        int i;
        while (it.hasNext()) {
            temp2 = (Map.Entry<Defence, String>) it.next();
            temp = temp2.getKey();
            temp3 = selenium.getText(temp2.getValue());
            temp3 = temp3.replace(selenium.getText(temp2.getValue() + "/span"), "").replace(" ", ""); //usuwanie wewnetrznego spana i spacji.
            i = Integer.parseInt(temp3);
            if (i > 0) {
                result.put(temp, new Integer(temp3));
            }
        }
        return result;

    }

    @Override
    public HashMap<Buildings, Integer> getPlanetBuildings() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Resources getBuildCost(Buildings b) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Resources getStudyCost(Study s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Resources getShipyardCost(ShipyardShips s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Resources getDefenceCost(Defence d) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getBuildTime(Buildings b) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getStudyTime(Study s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getShipyardTime(ShipyardShips s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getDefenceTime(Defence d) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isBuildQueueEmpty() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isLabQueueEmpty() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Slots> getSlots() throws OgameException {
        this.clickMovements();
        //int maxSlots = Integer.parseInt(selenium.getText(mappings.getSlots_maxFleets()));
        int useSlots = Integer.parseInt(selenium.getText(mappings.getSlots_usedFleets()));
        List<Slots> result = new ArrayList<>();
        // TODO obrobka slotow
        String xpath;
        int id;
        Calendar arrival, reversal, comeBack;
        Coords baza, cel;
        Mission mission;
        String allianceName;
        String temp, temp2;
        Slots tempSlot = null;
        boolean returning = true;
        for (int i = 1; i < useSlots + 1; i++) {
            try {
                // Blok inicjalizacyjny
                returning = true;
                reversal = null;
                comeBack = null;
                mission = null;
                xpath = mappings.getSlots_fleet_by_number(i);
                // wczytywanie
                id = Integer.parseInt(selenium.getAttribute(xpath + mappings.getSlots_fleetId_suffix()).replace(mappings.getSlots_fleetId_remove(), ""));
                // czasy , dolot, powrot, zawrot
                arrival = new GregorianCalendar();
                arrival.setTime(slotParse.parse(selenium.getAttribute(xpath + mappings.getSlots_fleetArrival_suffix())));

                {
                    String t = xpath + mappings.getSlots_fleetReversal_titleAtribute_suffix(),
                            t2 = xpath + mappings.getSlots_fleetReversal_suffix();
                    if (selenium.isElementPresent(t2)) {
                        returning = false;
                        reversal = new GregorianCalendar();
                        reversal.setTime(reversalParse.parse(selenium.getAttribute(t)));
                    }

                }
                {
                    String t = xpath + mappings.getSlots_fleetComeBack_titleAtribute_suffix(),
                            t2 = xpath + mappings.getSlots_fleetReversal_suffix();
                    if (selenium.isElementPresent(t2)) {
                        comeBack = new GregorianCalendar();
                        comeBack.setTime(comeBackParse.parse(selenium.getAttribute(t)));
                    }
                }


                //baza, cel
                // TODO czy planeta?
                baza = Coords.parse(selenium.getText(xpath + mappings.getSlots_fleetOriginPlanet_suffix()));
                cel = Coords.parse(selenium.getText(xpath + mappings.getSlots_fleetTargetPlanet_suffix()));
                //misja
                {
                    Set set = slotMissionMap.entrySet();
                    Entry<String, Mission> missionTemp;
                    Iterator<Entry<String, Mission>> it = set.iterator();
                    while (it.hasNext()) {
                        missionTemp = it.next();
                        if (missionTemp.getKey().compareTo(selenium.getText(xpath + mappings.getSlots_fleetMission_suffix()).replace(" ", "")) == 0) {
                            mission = missionTemp.getValue();
                            break;
                        }
                    }
                }
                // aliance
                temp = selenium.getText(xpath + mappings.getSlots_fleetAllianceName_suffix());
                if (temp.isEmpty()) {
                    allianceName = null;
                } else {
                    allianceName = temp;
                }

                if (allianceName == null) {
                    if (returning) {
                        tempSlot = new Slots(id, arrival, cel, baza, mission);
                    } else {
                        tempSlot = new Slots(id, arrival, cel, comeBack, reversal, baza, mission);
                    }
                } else {
                    if (returning) {
                        tempSlot = new Slots(id, arrival, cel, baza, allianceName, mission);
                    } else {
                        tempSlot = new Slots(id, arrival, cel, comeBack, reversal, baza, allianceName, mission);
                    }
                }
                result.add(tempSlot);
            } catch (ParseException ex) {
                throw new OgameException("Time parse exception");
            }
        }
        return result;
    }

    @Override
    public void turnBackFlight(Slots f) throws OgameException {
        this.clickMovements();
        String xpath = mappings.getSlots_fleet_by_id(f.getId());
        if (selenium.isElementPresent(xpath)) {
            selenium.click(xpath + mappings.getSlots_fleetReversal_button_suffix());
            wait(1);
        } else {
            throw new OgameException("No fleet of following ID number");
        }
    }

    @Override
    public Resources getPlanetHourlyProduction() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSlotsTotal() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots_maxFleets()));
    }

    @Override
    public int getSlotsOccupied() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots_usedFleets()));
    }

    @Override
    public int getExpeditionsTotal() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots_maxExp()));
    }

    @Override
    public int getExpeditionsOccupied() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots_useExp()));
    }

    private Map<String, String> getContent(String contentLink) {
        Map<String,String> result = new HashMap<>();
        selenium.openWindow(contentLink,"temp");
        wait(1);
        selenium.selectWindow("temp");
        int count = selenium.getXpathCount("//tr").intValue();
        for (int i=1; i<count+1; i++){
            if (selenium.isElementPresent("//tr[i]/td[2]".replace("i", Integer.toString(i)))){
                result.put(
                        selenium.getText("//tr[i]/td[1]".replace("i", Integer.toString(i))),
                        selenium.getText("//tr[i]/td[2]".replace("i", Integer.toString(i))));
            }
        }
        selenium.close();
        selenium.selectWindow(null);
        Set set = result.entrySet();
        System.err.println("Obtained content");
        Iterator<Entry<String,String>> it = set.iterator();
        for (Entry<String,String> temp; it.hasNext();){
            temp = it.next();
            System.err.println(temp.getKey()+"->"+temp.getValue());
        }
        return result;
    }

}
