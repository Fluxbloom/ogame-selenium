/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.Destination;
import OgameEngine.Coords.Planet;
import OgameEngine.Coords.StartDestination;
import OgameEngine.Fleet.Ships;
import OgameEngine.Fleet.ShipyardShips;
import OgameEngine.Flights.FriendOrFoe;
import OgameEngine.Flights.Multiplicity;
import OgameEngine.Performance.Production;
import OgameEngine.Performance.ResourceField;
import com.thoughtworks.selenium.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa z wykorzystaniem Selenium do grania w ogame
 *
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
    private HashMap<Buildings, String> buildinglvlMap;
    private HashMap<Buildings, String> stationlvlMap;

    public Ogame116pl() {
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
        System.out.print("Initializing studyMap");
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
        System.out.print("Inititializing defenceMap");
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
        System.out.print("Creating Shipyard Map");
        shipyardMap = new HashMap<ShipyardShips, String>();
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
        System.out.print("Inititializing Selenium instance ");
        System.out.print("Creating Shipyard Map");
        performanceMap = new HashMap<Performance.ResourceField, String>();
        performanceMap.put(Performance.METAL, mappings.getPerformance_m());
        performanceMap.put(Performance.KRYSZTAL, mappings.getPerformance_k());
        performanceMap.put(Performance.DEUTER, mappings.getPerformance_d());
        performanceMap.put(Performance.EL_SLONECZNA, mappings.getPerformance_es());
        performanceMap.put(Performance.EL_FUZYJNA, mappings.getPerformance_ef());
        performanceMap.put(Performance.SAT_SLONECZNA, mappings.getPerformance_ss());
        System.out.println("[DONE]");
        System.out.print("Creating Fleet Map");
        fleetMap = new HashMap<Ships, String>();
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
        System.out.print("Creating Technology Map");
        technologyMap = new HashMap<Study, String>();
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
        System.out.print("Creating defcountMap");
        defcountMap = new HashMap<Defence, String>();
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
        System.out.print("Creating Building Level Map");
        buildinglvlMap = new HashMap<Buildings, String>();
        buildinglvlMap.put(Buildings.EKSTRAKTOR_DEUTERU, mappings.getHowm_ed());
        buildinglvlMap.put(Buildings.ELEKTROWNIA_FUZYJNA, mappings.getHowm_ef());
        buildinglvlMap.put(Buildings.ELEKTROWNIA_SLONECZNA, mappings.getHowm_es());
        buildinglvlMap.put(Buildings.KOPALNIA_KRYSZTALU, mappings.getHowm_kk());
        buildinglvlMap.put(Buildings.KOPALNIA_METALU, mappings.getHowm_km());
        buildinglvlMap.put(Buildings.MAGAZYN_DEUTERU, mappings.getHowm_md());
        buildinglvlMap.put(Buildings.MAGAZYN_KRYSZTALU, mappings.getHowm_mk());
        buildinglvlMap.put(Buildings.MAGAZYN_METALU, mappings.getHowm_mm());
        buildinglvlMap.put(Buildings.SATELITA_SLONECZNA, mappings.getHowm_ss());
        buildinglvlMap.put(Buildings.SCHOWEK_DEUTERU, mappings.getHowm_od());
        buildinglvlMap.put(Buildings.SCHOWEK_KRYSZTALU, mappings.getHowm_ok());
        buildinglvlMap.put(Buildings.SCHOWEK_METALU, mappings.getHowm_om());
        System.out.println("[DONE]");
        System.out.print("Creating Station Level Map");
        stationlvlMap = new HashMap<Buildings, String>();
        stationlvlMap.put(Buildings.FABRYKA_NANITOW, mappings.getHowm_fn());
        stationlvlMap.put(Buildings.FABRYKA_ROBOTOW, mappings.getHowm_fr());
        stationlvlMap.put(Buildings.LABORATORIUM_BADAWCZE, mappings.getHowm_lb());
        stationlvlMap.put(Buildings.DEPOZYT, mappings.getHowm_ds());
        stationlvlMap.put(Buildings.SILOS_RAKIETOWY, mappings.getHowm_sr());
        stationlvlMap.put(Buildings.STOCZNIA, mappings.getHowm_st());
        stationlvlMap.put(Buildings.TERRAFORMER, mappings.getHowm_tr());
        
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

    // TODO gdy nie widoczny lewy panel powinno się przelogować ponownie
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

    private void clickEventList() {
        this.clickPrzeglad();
        selenium.click(mappings.getLeftButtonEventList());
        wait(1);
    }

    private void clickResourceSettings() {
        clickAndWait(mappings.getLeftButtonResourceSettings());
    }

    private void clickFlights() {
        clickAndWait(mappings.getLeftButtonFlightsList());
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
        for (int i = 0; i < 3; i++) {
            try {
                selenium.open(mappings.getGameUrl());
                selenium.waitForPageToLoad(mappings.getTimeout());

                // Jeśli zamknij widoczne to nic nie rób, jeśli 
                if (!selenium.isTextPresent(mappings.getLogin_closed_login_frame())) {
                    // Jeśli nie obecny to
                    selenium.click(mappings.getLogin_login_button());
                }
                selenium.select(mappings.getLogin_uni_target(), mappings.getLogin_uni_pref() + uni);
                selenium.type(mappings.getLogin_nick_target(), user);
                selenium.type(mappings.getLogin_pass_target(), pass);
                clickAndWait(mappings.getLogin_login_with_pass_button());
                break;
            } catch (Exception ex) {
                System.err.println("Cannot login");
                if (i == 2) {
                    throw new OgameException("Fail to login");
                }
            }
        }
    }

    @Override
    public void logout() throws OgameException {
        // Wylogowanie
        clickAndWait(mappings.getLogout_button());
        this.stop();
    }

    @Override
    public int getPlanetCount() throws OgameException {
        String s = selenium.getText(mappings.getCountplanet());
        return Integer.parseInt(s.split(mappings.getCountplanet_separator())[mappings.getCountplanet_result_pos() - 1]);
    }

    @Override
    public void changePlanet(int planetNumber) throws OgameException {
        clickAndWait(mappings.getChangeplanetbyid(planetNumber));
    }

    @Override
    public void changePlanetByName(String name) throws OgameException {
        clickAndWait(mappings.getChangeplanetbyName(name));
    }

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
        String str = mappings.getStudyNEG();
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
        List<String> list = new ArrayList<String>();
        for (int j = 1; j < i + 1; j++) {
            list.add(selenium.getText(mappings.getChangeplanetgetName(j)));
        }
        return list;
    }

    @Override
    public List<String> getPlanetCoords() throws OgameException {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<String>();
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

    private Planet parsePlanet(String s) {
        String[] str = s.replace("[", "").replace("]", "").split(":");
        return new Planet(str[0], str[1], str[2]);
    }

    @Override
    public List<Flights> getEventList() throws OgameException {
        // najpierw ilosc pozycji
        this.clickEventList();
        int iloscFlot = selenium.getXpathCount(mappings.getEvent_list_root()).intValue();
        String flightXPath;

        FriendOrFoe nastawienie;
        Multiplicity mp;
        Calendar arrival;
        Planet origin;
        Planet target;
        int size;
        List<Flights> lista = new ArrayList<Flights>();

        for (int i = 1; i < iloscFlot + 1; i++) {
            // konwersja na loty
            flightXPath = mappings.getEvent_list_flight(i);
            if (selenium.getAttribute(flightXPath + mappings.getEvent_list_class_atribute()).compareTo(
                    mappings.getEvent_list_class_atribute_friendly()) == 0
                    | selenium.getAttribute(flightXPath + mappings.getEvent_list_class_atribute()).compareTo(
                    mappings.getEvent_list_class_atribute_friendly_return()) == 0) {
                mp = Flights.SINGLE_FLEET;
            } else if (selenium.getAttribute(flightXPath + mappings.getEvent_list_class_atribute()).compareTo(
                    mappings.getEvent_list_class_atribute_enemy_alliance()) == 0) {
                mp = Flights.ACS_FLEET;
            } else {
                throw new OgameException("Error cannot recognized is fleet is single od ACS");
            }
            // sprawdźmy nastawienie floty
            if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_friendly())) {
                nastawienie = Flights.FRIEND;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_neutral())) {
                nastawienie = Flights.NEUTRAL;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_enemy())
                    & selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_spy())) {
                nastawienie = Flights.SPY;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_enemy())
                    & selenium.isElementPresent(flightXPath + mappings.getEvent_list_atribute_is_attack())) {
                nastawienie = Flights.ATTACK;
            } else {
                throw new OgameException("Error cannot recognized whether the fleet is friend or foe");
            }
            arrival = this.parseArrivalTime(
                    selenium.getText(flightXPath + mappings.getEvent_list_atribute_count_down_time()),
                    selenium.getText(flightXPath + mappings.getEvent_list_atribute_arrival_time()));
            origin = this.parsePlanet(selenium.getText(flightXPath + mappings.getEvent_list_atribute_originCoords()));
            target = this.parsePlanet(selenium.getText(flightXPath + mappings.getEvent_list_atribute_destCoords()));
            size = Integer.parseInt(selenium.getText(flightXPath + mappings.getEvent_list_atribute_detailsFleet()));

            lista.add(new Flights(nastawienie, mp, arrival, origin, size, target));

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
        //throw new UnsupportedOperationException("Not supported yet.");
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
        HashMap<Study, Integer> result = new HashMap<Study, Integer>();
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
        HashMap<Defence, Integer> result = new HashMap<Defence, Integer>();
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
        HashMap<Buildings, Integer> result = new HashMap<Buildings, Integer>();
        this.clickSurowce();
        Set set = this.buildinglvlMap.entrySet();
        Iterator it = set.iterator();
        Buildings temp;
        Map.Entry<Buildings, String> temp2;
        String temp3;
          int i;
        while (it.hasNext()) {
            temp2 = (Map.Entry<Buildings, String>) it.next();
            temp = temp2.getKey();
            temp3 = selenium.getText(temp2.getValue());
            temp3 = temp3.replace(selenium.getText(temp2.getValue() + "/span"), "").replace(" ", ""); //usuwanie wewnetrznego spana i spacji.
            i = Integer.parseInt(temp3);
            result.put(temp, new Integer(temp3));     
        }
         this.clickStacja();
        Set set1 = this.stationlvlMap.entrySet();
        Iterator it1 = set1.iterator();
        Buildings temp6;
        Map.Entry<Buildings, String> temp4; //temp2
        String temp5;                       //temp3
        int j;                              //int j
        while (it1.hasNext()) {
            temp4 = (Map.Entry<Buildings, String>) it1.next();
            temp6 = temp4.getKey();          //temp
            temp5 = selenium.getText(temp4.getValue());
            temp5 = temp5.replace(selenium.getText(temp4.getValue() + "/span"), "").replace(" ", ""); //usuwanie wewnetrznego spana i spacji.
            j = Integer.parseInt(temp5);
            result.put(temp6, new Integer(temp5));     
        }
        
        return result;
         
    }
  
    @Override
    public PlanetResources getBuildCost(Buildings b) throws OgameException {
        String metal = "0";
        String cristal = "0";
        String deuter = "0";
        String energy = "0";
        if (b == Buildings.FABRYKA_ROBOTOW || b == Buildings.STOCZNIA || b == Buildings.LABORATORIUM_BADAWCZE || b == Buildings.DEPOZYT || b == Buildings.SILOS_RAKIETOWY || b == Buildings.FABRYKA_NANITOW || b == Buildings.TERRAFORMER) {
            this.clickStacja();
            selenium.click(buildingMap.get(b));
            this.wait(1);
            if (selenium.isElementPresent(mappings.getSta_metal())) {
                metal = selenium.getText(mappings.getSta_metal_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getSta_cristal())) {
                cristal = selenium.getText(mappings.getSta_cristal_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getSta_deuter())) {
                deuter = selenium.getText(mappings.getSta_deuter_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getSta_energy())) {
                energy = selenium.getText(mappings.getSta_energy_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }

        } else {
            this.clickSurowce();
            selenium.click(buildingMap.get(b));
            this.wait(1);
            if (selenium.isElementPresent(mappings.getRes_metal())) {
                metal = selenium.getText(mappings.getRes_metal_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getRes_cristal())) {
                cristal = selenium.getText(mappings.getRes_cristal_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getRes_deuter())) {
                deuter = selenium.getText(mappings.getRes_deuter_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getRes_energy())) {
                energy = selenium.getText(mappings.getRes_energy_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            
        }
        return new PlanetResources(metal,cristal,deuter,energy);
    }

    @Override
    public PlanetResources getStudyCost(Study s) throws OgameException {
           String metal = "0";
           String cristal = "0";
           String deuter = "0";
           String energy = "0";
            this.clickBadania();
            selenium.click(studyMap.get(s));
            this.wait(1);
            if (selenium.isElementPresent(mappings.getTech_metal())) {
                metal = selenium.getText(mappings.getTech_metal_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getTech_cristal())) {
                cristal = selenium.getText(mappings.getTech_cristal_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getTech_deuter())) {
                deuter = selenium.getText(mappings.getTech_deuter_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getTech_energy())) {
                energy = selenium.getText(mappings.getTech_energy_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            return new PlanetResources(metal,cristal,deuter,energy);
    }

    @Override
    public Resources getShipyardCost(ShipyardShips s) throws OgameException {
           String metal = "0";
           String cristal = "0";
           String deuter = "0";
            this.clickStocznia();
            selenium.click(shipyardMap.get(s));
            this.wait(1);
            if (selenium.isElementPresent(mappings.getShip_metal())) {
                metal = selenium.getText(mappings.getShip_metal_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getShip_cristal())) {
                cristal = selenium.getText(mappings.getShip_cristal_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getShip_deuter())) {
                deuter = selenium.getText(mappings.getShip_deuter_value()).replace("Mln", "000000").replace(" ", "").replace('.', '!').replace("!", "");
            }
            
            return new Resources(metal,cristal,deuter);
    }

    @Override
    public Resources getDefenceCost(Defence d) throws OgameException {
           String metal = "0";
           String cristal = "0";
           String deuter = "0";
            this.clickObrona();
            selenium.click(defenceMap.get(d));
            this.wait(1);
            if (selenium.isElementPresent(mappings.getDef_metal())) {
                metal = selenium.getText(mappings.getDef_metal_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getDef_cristal())) {
                cristal = selenium.getText(mappings.getDef_cristal_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            if (selenium.isElementPresent(mappings.getDef_deuter())) {
                deuter = selenium.getText(mappings.getDef_deuter_value()).replace(" ", "").replace('.', '!').replace("!", "");
            }
            
            return new Resources(metal,cristal,deuter);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void turnBackFlight(Slots f) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Resources getPlanetHourlyProduction() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSlotsTotal() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSlotsOccupied() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getExpeditionsTotal() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getExpeditionsOccupied() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
