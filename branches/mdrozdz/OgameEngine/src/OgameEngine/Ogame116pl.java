/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Flights.FriendOrFoe;
import OgameEngine.Flights.Multiplicity;
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
 * @author dyschemist
 */
class Ogame116pl extends Ogame {//extends SeleneseTestCase {

    private MappingProperties mappings;
    private HashMap<Mission, String> missionMap;
    private HashMap<Ships, String> shipsMap;
    private HashMap<Buildings, String> buildingMap;
    private HashMap<Study, String> studyMap;
    private HashMap<Defence, String> defenceMap;
    private HashMap<StockyardShips, String> shipyardMap;
    private HashMap<Ships, String> fleetMap;


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
        shipyardMap = new HashMap<StockyardShips, String>();
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
        
        System.out.print("Creating Mission Map");
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

    private void sendFleetSetCords(Cords c, Destination d) {
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
    public void login(String uni, String user, String pass) {
        this.start();
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
    public void logout() {
        // Wylogowanie
        clickAndWait(mappings.getLogout_button());
        this.stop();
    }

    @Override
    public int getPlanetCount() {
        String s = selenium.getText(mappings.getCountplanet());
        return Integer.parseInt(s.split(mappings.getCountplanet_separator())[mappings.getCountplanet_result_pos() - 1]);
    }

    @Override
    public void changePlanet(int planetNumber) {
        clickAndWait(mappings.getChangeplanetbyid(planetNumber));
    }

    @Override
    public void changePlanetByName(String name) {
        clickAndWait(mappings.getChangeplanetbyName(name));
    }

    @Override
    public void sendFleet(Fleet f, StartDestination d, Cords c, Speed speed, Mission m, Resources r) throws OgameException {
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
    public void sendFleet(Fleet f, Cords c, Speed speed, Mission m, Resources r) throws OgameException {
        this.sendFleet(f, StartDestination.PLANET, c, speed, m, r);

    }

    @Override
    public void sendFleet(Fleet f, Cords c, Mission m, Resources r) throws OgameException {
        this.sendFleet(f, StartDestination.PLANET, c, Speed.S100, m, r);
    }

    @Override
    public void build(Buildings b) {
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
    public void study(Study s) {
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
    public void buildDefence(Defence d, int i) {
        buildDefence(d, Integer.toString(i));
    }

    @Override
    public void buildDefence(Defence d, String count) {
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
    public void buildShip(StockyardShips s, int i) {
        buildShip(s, Integer.toString(i));
    }

    @Override
    public void buildShip(StockyardShips s, String count) {
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
    public List<String> getPlanetNames() {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<String>();
        for (int j = 1; j < i + 1; j++) {
            list.add(selenium.getText(mappings.getChangeplanetgetName(j)));
        }
        return list;
    }

    @Override
    public List<String> getPlanetCoords() {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<String>();
        for (int j = 1; j < i + 1; j++) {
            list.add(selenium.getText(mappings.getChangeplanetgetCoords(j)));
        }
        return list;
    }
private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
    private Calendar parseArrivalTime(String countDownTime, String arrivalTime){
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
        i[0]=Integer.parseInt(str[0]);
        i[1]=Integer.parseInt(str[1]);
        i[2]=Integer.parseInt(str[2].substring(0, str[2].indexOf(" ")));
        Calendar result= new GregorianCalendar();
        int t =countDownList[0]*24+countDownList[1];
        result.add(Calendar.HOUR_OF_DAY, t);
        result.add(Calendar.MINUTE, countDownList[2]);
        result.add(Calendar.SECOND, countDownList[3]);
        result.set(Calendar.HOUR_OF_DAY, i[0]);
        result.set(Calendar.MINUTE, i[1]);
        result.set(Calendar.SECOND, i[2]);
        return result;
    }
    private Planet parsePlanet(String s){
        String[] str =s.replace("[", "").replace("]", "").split(":");
        return new Planet(str[0],str[1],str[2]);
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
            origin = this.parsePlanet(selenium.getText(flightXPath + mappings.getEvent_list_atribute_originCoords())) ;
            target = this.parsePlanet(selenium.getText(flightXPath + mappings.getEvent_list_atribute_destCoords()));
            size = Integer.parseInt(selenium.getText(flightXPath + mappings.getEvent_list_atribute_detailsFleet()));
            
            lista.add(new Flights(nastawienie,mp,arrival,origin,size,target));
            
        }

        return lista;
        

    }
    /*
     * Testowe metody
     */
//    @Override
//    void test() {
//        this.clickEventList();
//        int j = selenium.getXpathCount(mappings.getTest2()).intValue();
//        for (int i=1; i<j+1;i++)
//        System.out.println(selenium.getText(mappings.getTest1(i)));
//    }

    /**
     * Metoda tworzy nowy obiekt zasobów;
     * @return zwraca za pomoca funckji ilosc metalu,krysztalu i deuteru
     */
    @Override
    public Resources getResources() {
        String metal = selenium.getText(mappings.getResources_m());
        String krysztal = selenium.getText(mappings.getResources_k());
        String deuter = selenium.getText(mappings.getResources_d());
        return new Resources(metal,krysztal,deuter);
        
    }

    @Override
    public Fleet getPlanetFleet() {
        this.clickFlota();
        Fleet result = new Fleet();
        Set set = fleetMap.entrySet();
        Iterator it = set.iterator();
        Ships temp;
        Map.Entry<Ships,String> temp2;
        String temp3;
        int i;
        while (it.hasNext()){
            temp2 = (Map.Entry<Ships,String>)it.next();
            temp = temp2.getKey();
            temp3 = selenium.getAttribute(temp2.getValue());
            temp3 = temp3.substring(temp3.indexOf("(")+1, temp3.indexOf(")"));
            i = Integer.parseInt(temp3);
            if (i >0)
                result.add(temp, temp3);
        }
        return result;
    }
    /*
     * HashMap<Ships, Integer> fleet 
     * = f.getFleet();
            Set set = fleet.entrySet();
            Iterator it = set.iterator();
            Ships temp2;
            Map.Entry<Ships, Integer> temp;
            while (it.hasNext()) {
                temp = (Map.Entry<Ships, Integer>) it.next();
                temp2 = temp.getKey();
                selenium.type(shipsMap.get(temp2), ((Integer) fleet.get(temp2)).toString());
            }
     */
    
}
