/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameElements.ArrivalTime;
import OgameElements.TimePeriodParser;
import OgameElements.Buildings;
import OgameEngine.Exceptions.OgameCannotSendFleetException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.PlanetResources;
import OgameElementsUnchecked.Resources;
import OgameElementsUnchecked.Speed;
import OgameElementsUnchecked.ResearchingArea;
import OgameElementsUnchecked.Slots;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Defence;
import OgameElements.BuildingsPlanet;
import OgameElements.Destination;
import OgameElements.Coords;
import OgameElements.SimpleTimePeriodParser;
import OgameElements.Time;
import OgameElements.TimeParser;
import OgameElements.TimePeriod;
import OgameElementsUnchecked.Events;
import OgameElementsUnchecked.Events.FriendOrFoe;
import OgameElementsUnchecked.Events.Multiplicity;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Performance;
import OgameElementsUnchecked.Performance.Production;
import OgameElementsUnchecked.Performance.ResourceField;
import OgameElementsUnchecked.Ships;
import OgameElementsUnchecked.ShipyardShips;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngineUnchecked.MappingProperties;
import com.thoughtworks.selenium.*;
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
 * Klasa implementująca metody Ogame dla uni166pl
 *
 * @author Piotr Kowalski & Rafał Plich & Michał Dróżdż
 */
class Ogame116pl extends Ogame {//extends SeleneseTestCase {

    public Ogame116pl() {
        init();
        logger.log(Level.INFO, "Inititializing Selenium instance ");
        try {
            selenium =
                    new DefaultSelenium("0.0.0.0", 4444,
                    mappings.getSelenium().getBrowser(), mappings.getSelenium().getUrl()) {

                        @Override
                        public void open(String url) {
                            commandProcessor.doCommand("open", new String[]{url, "true"});
                        }
                    };
        } catch (Exception ex) {
            logger.log(Level.WARNING, " [FAIL]");
        }
        logger.log(Level.INFO, " [DONE]");
    }

    /**************************************************************************
     ************************** METODY CZASÓW *********************************
     **************************************************************************/
    @Override
    public void waitMilisecond(int miliseconds) {
        logger.log(Level.INFO, "Will wait for {0} miliseconds", miliseconds);
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void wait(int seconds) {
        Calendar now = new GregorianCalendar();
        now.add(Calendar.SECOND, seconds);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        logger.log(Level.INFO, "Will wait for {0} seconds till {1}", new String[]{Integer.toString(seconds), sdf.format(now.getTime())});
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, null, ex);
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
    public void wait(TimePeriod t) {
        int days = t.getDays(),
                hours = t.getHours(),
                minutes = t.getMinutes(),
                seconds = t.getSeconds();
        wait(days * 24 + hours, minutes, seconds);
    }

    /**************************************************************************
     ************************** METODY LOGOWAN *********************************
     **************************************************************************/
    /**
     * Metoda startująca sterownik selenium
     * @throws OgameException serwer nie działa
     */
    @Override
    public void start() throws OgameException {
        logger.log(Level.INFO, "Starting selenium instance");
        try {
            selenium.start();
            selenium.windowMaximize();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, OgameException.SELENIUM_SERVER_IS_DOWN.getMessage());
            throw OgameException.SELENIUM_SERVER_IS_DOWN;
        }
    }

    /**
     * Metoda zamykająca sterownik selenium
     */
    @Override
    public void stop() {
        logger.log(Level.INFO, "Stoping selenium instance");
        try {
            selenium.close();
            selenium.stop();
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Cant close selenium driver");
        }
    }

    @Override
    public void login(String uni, String user, String pass) throws OgameException {
        logger.log(Level.CONFIG, "Loging to {0} with uni={1} user={2} and pass={3}",
                new String[]{
                    mappings.getSelenium().getGameUrl(),
                    uni,
                    user,
                    pass
                });
        try { //tlumaczymy selenium exception
            selenium.open(mappings.getSelenium().getGameUrl());
            // Jeśli zamknij widoczne to nic nie rób, jeśli 
            if (!isTextPresent(mappings.getLogin().getLoginFrameIsOpenText())) {
                // Jeśli nie obecny to
                click(mappings.getLogin().getLoginFrameOpeningButton());
            }
            selenium.select(mappings.getLogin().getSelectUni(), mappings.getLogin().getUniPrefix() + uni);
            selenium.type(mappings.getLogin().getUser(), user);
            selenium.type(mappings.getLogin().getPass(), pass);
            clickAndWait(mappings.getLogin().getLoginButton());
        } catch (SeleniumException ex) {
            logger.log(Level.SEVERE, "Inner Error {0}", ex.getMessage());
            if (ex.getMessage().compareTo("ERROR: Current window or frame is closed!") == 0) {
                throw OgameException.LOGIN_BROWSER_CLOSED;
            } else if (ex.getMessage().contains("Timed out after ")) {
                throw OgameException.LOGIN_NO_INTERNET_CONNECTION;
            }

        }
        if (selenium.isTextPresent(mappings.getLogin().getWrongPasswordText())) {
            throw OgameException.LOGIN_WRONG_PASSWORD;
        }
    }

    @Override
    public boolean isLogged() {
        logger.info("Check if logged");
        try {
            this.clickOverview();
            if (isElementPresent(mappings.getLogin().getLoginMetadata())) {
                return getAttribute(mappings.getLogin().getLoginMetadataContentAtribute()).compareTo(mappings.getLogin().getLoginMetadataContentAtributeValue()) == 0;
            } else {
                return false;
            }
        } catch (SeleniumException ex) {
            logger.log(Level.WARNING, ex.getMessage());
            return false;
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage());
            return false;
        }
    }

    @Override
    public void logout() throws OgameException {
        clickAndWait(mappings.getLogin().getLogoutButton());
    }

    /* *************************************************************************
     * ************* WIDOK OGOLNY **********************************************
     * ************************************************************************/
    private void clickAndWait(String s) throws OgameElementNotFoundException, OgameException {
        click(s);
        try {
            selenium.waitForPageToLoad(mappings.getSelenium().getTimeout());
        } catch (SeleniumException ex) {
            throw OgameException.TIMEOUT;
        }
    }

    private void clickOverview() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonPrzegladaj());
        wait(1);
    }

    private boolean isOverviewClicked() {
        if (isElementPresent(this.mappings.getOverview().getOverviewClickedElementPresent())) {
            return true;
        } else {
            return false;
        }
    }

    private void clickResourceBuildings() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonSurowce());
        wait(1);
    }

    private void clickStationBuildings() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonStacja());
        wait(1);
    }

    private void clickLab() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonBadania());
    }

    private void clickDefence() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonObrona());
        wait(1);
    }

    private void clickShipyard() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonStocznia());
        wait(1);
    }

    private void clickFleet() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonFlota());
        wait(1);
    }

    private void clickEventList() throws OgameElementNotFoundException, OgameException {
        this.clickOverview();
        if (!isTextPresent(mappings.getOverview().getLeftButtonEventListIsEmpty())) {
            click(mappings.getOverview().getLeftButtonEventList());
            wait(1);
        }
    }

    private void clickResourceSettings() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonResourceSettings());
        wait(1);
    }

    private void clickMovements() throws OgameElementNotFoundException, OgameException {
        clickAndWait(mappings.getOverview().getLeftButtonSlotsList());
        wait(1);
    }

    @Override
    public int getPlanetCount() throws OgameException {
        String s = getText(mappings.getOverview().getCountplanet());
        int i;
        try {
            i = Integer.parseInt(s.split(mappings.getOverview().getCountplanet_separator())[mappings.getOverview().getCountplanet_result_pos() - 1]);
        } catch (Exception ex) {
            throw OgameException.PLANET_PARSING_ERROR;
        }
        return i;
    }

    @Override
    public Planet getPlanet(int planetNumber) throws OgameException {
        String name = getText(mappings.getOverview().getChangeplanetgetName(planetNumber));
        Coords coords = Coords.parse(getText(mappings.getOverview().getChangeplanetgetCoords(planetNumber)));
        return new Planet(coords, name);
    }

    @Override
    public List<Planet> getPlanetList() throws OgameException {
        int size = this.getPlanetCount();
        List<Planet> result = new ArrayList<Planet>();
        Planet temp;
        for (int i = 1; i < size + 1; i++) {
            temp = this.getPlanet(i);
            result.add(temp);
        }
        return result;
    }

    @Override
    public void changePlanet(int planetNumber) throws OgameException {
        clickAndWait(mappings.getOverview().getChangeplanetbyid(planetNumber));
        wait(1);
    }

    // TODO poprawić obsługę planet powyżej 12 znaków
    @Override
    public void changePlanetByName(String name) throws OgameException {
        clickAndWait(mappings.getOverview().getChangeplanetbyName(name));
        wait(1);
    }

    @Override
    public void changePlanetByCoords(Coords c) throws OgameException {
        String xpath = mappings.getOverview().getChangeplanetbyCoords(c);
        clickAndWait(xpath);
        wait(1);
    }

    @Override
    public void changePlanet(Planet p) throws OgameException {
        this.changePlanetByCoords(p.getCoords());
    }

    @Override
    public List<String> getPlanetNames() throws OgameException {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<String>();
        for (int j = 1; j < i + 1; j++) {
            list.add(getText(mappings.getOverview().getChangeplanetgetName(j)));
        }
        return list;
    }

    @Override
    public List<String> getPlanetCoords() throws OgameException {
        int i = this.getPlanetCount();
        List<String> list = new ArrayList<String>();
        for (int j = 1; j < i + 1; j++) {
            list.add(getText(mappings.getOverview().getChangeplanetgetCoords(j)));
        }
        return list;
    }

    @Override
    public PlanetResources getResources() throws OgameElementNotFoundException {
        String metal = getText(mappings.getOverview().getResources_metal());
        String krysztal = getText(mappings.getOverview().getResources_crystal());
        String deuter = getText(mappings.getOverview().getResources_deuterium());
        String energy = getText(mappings.getOverview().getResources_energy());
        return new PlanetResources(metal, krysztal, deuter, energy);

    }

    @Override
    public boolean isBuildQueueEmpty() throws OgameElementNotFoundException, OgameException {
        if (!this.isOverviewClicked()) {
            this.clickOverview();
        }
        return isTextPresent(mappings.getOverview().getBuildingFree());
    }

    @Override
    public boolean isResearchQueueEmpty() throws OgameElementNotFoundException, OgameException {
        if (!this.isOverviewClicked()) {
            this.clickOverview();
        }
        return isTextPresent(mappings.getOverview().getStudyFree());
    }

    @Override
    public boolean isConstructionQueueEmpty() throws OgameElementNotFoundException, OgameException {
        if (!this.isOverviewClicked()) {
            this.clickOverview();
        }
        return isTextPresent(mappings.getOverview().getConstructingFree());
    }

    /* *************************************************************************
     * ***************** BUDYNKI ***********************************************
     * *************************************************************************/
    @Override
    public void build(Buildings b) throws OgameElementNotFoundException, OgameException {
        boolean buildQueue, labQueue, shipyardQueue;
        buildQueue = this.isBuildQueueEmpty();
        labQueue = this.isResearchQueueEmpty();
        PlanetResources available = this.getResources();
        PlanetResources needed = null;// TODO wymagane do budowy
        shipyardQueue = this.isConstructionQueueEmpty();
        if (b.isMoonBuilding()) {
            throw OgameException.UNSUPPORTED;
        } else if (b.isStationBuilding()) {
            this.clickStationBuildings();
            click(buildingMap.get(b));
            wait(1);
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (selenium.isElementPresent(mappings.getBuldings().getStationButtonDisabled())) {
                /*
                 * 1. brak surowcow 2. zajeta kolejka 3. stocznia pracuje 4. lab
                 * pracuje
                 */
                if (!available.isSufficient(needed)) {
                    throw new OgameException("Insufficient resources");
                }
                if (!buildQueue) {
                    throw new OgameException("Bulding queue is not empty");
                }
                if (b == Buildings.LABORATORY && !labQueue) {
                    throw new OgameException("Lab queue is not empty");
                }
                if (b == Buildings.SHIPYARD && !shipyardQueue) {
                    throw new OgameException("Shipyard is working");
                } else {
                    throw new OgameException("Unexpected error in build Buildings");
                }
            }
            this.clickAndWait(mappings.getBuldings().getStationButtonEnabled());
        } else {
            this.clickResourceBuildings();
            click(buildingMap.get(b));
            wait(1);
            //this.clickAndWait(buildingMap.get(b)); //selenium.click
            if (isElementPresent(mappings.getBuldings().getResourcesButtonDisabled())) {
                /*
                 * 1. brak surowcow 2. zajeta kolejka
                 */
                if (!available.isSufficient(needed)) {
                    throw new OgameException("Insufficient resources");
                }
                if (!buildQueue) {
                    throw new OgameException("Bulding queue is not empty");
                }
                if (b == Buildings.LABORATORY && !labQueue) {
                    throw new OgameException("Bulding queue is not empty");
                } else {
                    throw new OgameException("Unexpected error in build Buildings");
                }
            }
            this.clickAndWait(mappings.getBuldings().getResourcesButtonEnabled());
        }


    }

    /**
     * Funkcja zastępuje ciągi znaków przy pobieraniu ich z zasobów
     * @param s Ciąg pierwotny
     * @return Ciąg oczyszczony z śmieci
     */
    private int replaceHugeNumbers(String s) {
        Map<String, String> map = mappings.getBuldings().getHugeNumbersNames();
        Set<Entry<String, String>> set = map.entrySet();
        Entry<String, String> temp;
        int multiplyier = 1;
        double value;
        for (Iterator<Entry<String, String>> it = set.iterator(); it.hasNext();) {
            temp = it.next();
            s.replace(temp.getKey(), "");
            multiplyier *= Integer.parseInt(temp.getValue());
        }
        char thousandSep = '.';
        char fractionSep = ',';
        value = Double.parseDouble(s.replace(thousandSep, ' ').replace(" ", "").replace(fractionSep, '.'));
        return (int) (value * multiplyier); //trick ponieważ nie można wprost usunąć . jako regexp
    }

    @Override
    public PlanetResources getCost(Buildings b) throws OgameElementNotFoundException, OgameException {
        int metal = 0;
        int cristal = 0;
        int deuter = 0;
        int energy = 0;
        if (!b.isResourceBuilding()) {
            this.clickStationBuildings();
            click(buildingMap.get(b));
            this.wait(1);
            if (isElementPresent(mappings.getBuldings().getSta_metal())) {
                metal = replaceHugeNumbers(getText(mappings.getBuldings().getSta_metal_value()));
            }
            if (isElementPresent(mappings.getBuldings().getSta_cristal())) {
                cristal = replaceHugeNumbers(getText(mappings.getBuldings().getSta_cristal_value()));
            }
            if (isElementPresent(mappings.getBuldings().getSta_deuter())) {
                deuter = replaceHugeNumbers(getText(mappings.getBuldings().getSta_deuter_value()));
            }
            if (isElementPresent(mappings.getBuldings().getSta_energy())) {
                energy = replaceHugeNumbers(getText(mappings.getBuldings().getSta_energy_value()));
            }

        } else {
            this.clickResourceBuildings();
            click(buildingMap.get(b));
            this.wait(1);
            if (isElementPresent(mappings.getBuldings().getRes_metal())) {
                metal = replaceHugeNumbers(getText(mappings.getBuldings().getRes_metal_value()));
            }
            if (isElementPresent(mappings.getBuldings().getRes_crystal())) {
                cristal = replaceHugeNumbers(getText(mappings.getBuldings().getRes_crystal_value()));
            }
            if (isElementPresent(mappings.getBuldings().getRes_deuter())) {
                deuter = replaceHugeNumbers(getText(mappings.getBuldings().getRes_deuter_value()));
            }
            if (isElementPresent(mappings.getBuldings().getRes_energy())) {
                energy = replaceHugeNumbers(getText(mappings.getBuldings().getRes_energy_value()));
            }

        }
        return new PlanetResources(metal, cristal, deuter, energy);
    }

    @Override
    public TimePeriod getProductionTime(Buildings b) throws OgameElementNotFoundException, OgameException {
        TimePeriod cal = null;
        if (b.isMoonBuilding()) {
            throw OgameException.UNSUPPORTED;
        } else if (b.isStationBuilding()) {
            this.clickStationBuildings();
            click(buildingMap.get(b));
            this.wait(1);
            String s = getText(mappings.getBuldings().getTime_xpath());
            cal = buildingsTimeParser.parse(s);
        } else {
            this.clickResourceBuildings();
            click(buildingMap.get(b));
            this.wait(1);
            String s = getText(mappings.getBuldings().getTime_xpath());
            cal = buildingsTimeParser.parse(s);
        }
        return cal;
    }

    /* *************************************************************************
     * ***************** FLOTY *************************************************
     * *************************************************************************/
    private boolean isFleetAbleToAccessMission(Fleet f, Mission m, Coords c) throws OgameException {
        boolean result = true;
        if (m == Mission.ACS) {
            throw OgameException.FLEET_UNSUPPORTED_MISSION;
        } else if (m == Mission.KOLONIZE && f.get(Ships.KOL) == 0) {
            result = false;
        } else if (m == Mission.MOON_DESTRUCTION && f.get(Ships.GS) == 0 && c.getDest() != Coords.MOON) {
            result = false;
        } else if (m == Mission.RECYCLE && f.get(Ships.REC) == 0) {
            result = false;
        } else if (m == Mission.SPY && f.get(Ships.SOND) == 0) {
            result = false;
        } else if (m == Mission.EXPLORE && !c.isExploreable()) {
            result = false;
        } else if (m == Mission.RECYCLE && c.getDest() != Coords.PZ) {
            result = false;
        }
        return result;
    }

    private void sendFleetSetFleet(Fleet f) throws OgameElementNotFoundException {
        if (f == Fleet.WHOLE_FLEET) {
            click(mappings.getFleet().getFleetSend_sendAll());
        } else {
            HashMap<Ships, Integer> fleet = f.getFleet();
            Set set = fleet.entrySet();
            Iterator it = set.iterator();
            Ships temp2;
            Map.Entry<Ships, Integer> temp;
            while (it.hasNext()) {
                temp = (Map.Entry<Ships, Integer>) it.next();
                temp2 = temp.getKey();
                if (fleet.get(temp2).intValue() == Ships.ALL) {
                    click(shipsAllMap.get(temp2));
                } else {
                    type(shipsMap.get(temp2), ((Integer) fleet.get(temp2)).toString());
                }
            }
        }
    }

    private void sendFleetSetCords(Coords c) throws OgameElementNotFoundException {
        type(mappings.getFleet().getFleetSend_galaxy(), c.getSUniverse());
        type(mappings.getFleet().getFleetSend_system(), c.getSSystem());
        type(mappings.getFleet().getFleetSend_position(), c.getSPosition());
        if (c.getDest() == Destination.PLANET && isElementPresent(mappings.getFleet().getFleetSend_target_planet_deselected())) {
            click(mappings.getFleet().getFleetSend_target_planet_deselected());
        } else if (c.getDest() == Destination.MOON && isElementPresent(mappings.getFleet().getFleetSend_target_moon_deselected())) {
            click(mappings.getFleet().getFleetSend_target_moon_deselected());
        } else if (c.getDest() == Destination.DEBRIS && isElementPresent(mappings.getFleet().getFleetSend_target_debris_deselected())) {
            click(mappings.getFleet().getFleetSend_target_debris_deselected());
        }
    }

    private void sendFleetSetMission(Mission m, String time) throws OgameElementNotFoundException, OgameException {
        if (!isElementPresent(missionOffMap.get(m))) {
            click((String) missionMap.get(m));
        } else {
            throw OgameException.FLEET_MISSION_UNAVAILABLE_FOR_FLEET;
        }
        if (m == Mission.STAY) {
            select(mappings.getFleet().getFleetSend_holding_time(), mappings.getFleet().getFleetSend_holding_time_target_pref() + time);
        } else if (m == Mission.EXPLORE) {
            select(mappings.getFleet().getFleetSend_expedition_time(), mappings.getFleet().getFleetSend_expedition_time_target_pref() + time);
        }

    }

    private void sendFleetSetResources(Resources r) throws OgameElementNotFoundException {
        if (r == Resources.ALL_RESOURCES) {
            click(mappings.getFleet().getFleetSend_allResources());
        } else {
            // najpierw -1
            if (r.getDeuterium() == -1) {
                click(mappings.getFleet().getFleetSend_deuter_max());
            }
            if (r.getCrystal() == -1) {
                click(mappings.getFleet().getFleetSend_crystal_max());
            }
            if (r.getMetal() == -1) {
                click(mappings.getFleet().getFleetSend_metal_max());
            }

            // teraz -2
            if (r.getDeuterium() == -2) {
                click(mappings.getFleet().getFleetSend_deuter_max());
            }
            if (r.getCrystal() == -2) {
                click(mappings.getFleet().getFleetSend_crystal_max());
            }
            if (r.getMetal() == -2) {
                click(mappings.getFleet().getFleetSend_metal_max());
            }

            // teraz -3
            if (r.getDeuterium() < -2) {
                click(mappings.getFleet().getFleetSend_deuter_max());
            }
            if (r.getCrystal() < -2) {
                click(mappings.getFleet().getFleetSend_crystal_max());
            }
            if (r.getMetal() < -2) {
                click(mappings.getFleet().getFleetSend_metal_max());
            }
            // teraz reszta
            if (r.getDeuterium() > -1) {
                type(mappings.getFleet().getFleetSend_deuter(), r.getSDeuterium());
            }
            if (r.getCrystal() > -1) {
                type(mappings.getFleet().getFleetSend_crystal(), r.getSCrystal());
            }
            if (r.getMetal() > -1) {
                type(mappings.getFleet().getFleetSend_metal(), r.getSMetal());
            }
        }
    }

    //TODO pierwszy ekran - wczytanie ilość slotów i ekspedycji
    //TODO drugi ekran - czytanie czasu lotu na potrzeby sendFleetAtSlowest
    @Override
    public ArrivalTime sendFleet(Fleet f, Coords c, Speed speed, Mission m, Resources r)
            throws OgameCannotSendFleetException, OgameElementNotFoundException,
            OgameIOException, OgameFileNotFoundException, OgameException {
        // sprawdzamy czy flota ma dostępną misję
        logger.log(Level.INFO, "Sending fleet - {0} - {1} - {2} - {3} - {4}", new String[]{
                    f.toString(), c.toString(), speed.toString(), m.toString(), r.toString()
                });
        if (!this.isFleetAbleToAccessMission(f, m, c)) {
            logger.log(Level.WARNING, "Fleet cant go for such mission");
            throw OgameException.FLEET_MISSION_UNAVAILABLE_FOR_FLEET;
        }
        this.clickFleet();
        logger.log(Level.INFO, "First screen");
        if (isTextPresent(mappings.getFleet().getNo_fleet_text())) {
            throw OgameException.FLEET_NO_FLEET_ON_PLANET;
        }
        this.sendFleetSetFleet(f);
        if (isElementPresent(mappings.getFleet().getFleetSend_errorscreen1())) {
            logger.log(Level.WARNING, "Couldnt send fleet - screen 1");
            throw new OgameException("FLEET SEND FIRST SCREEN ERROR");
            /*
             * Możliwe przyczyny błędu
             * - brak wolnego slota
             * - niezaznaczono żadnych statków
             */
        }
        clickAndWait(mappings.getFleet().getFleetSend_okscreen1());
        wait(0, 1);
        if (m == Mission.STATION) {
            int i = 2;
            String temp, text;
            boolean found = false;
            while (isElementPresent(mappings.getFleet().getFleetSend_own_planet_options().replace("%i", Integer.toString(i)))) {
                temp = mappings.getFleet().getFleetSend_own_planet_options().replace("%i", Integer.toString(i));
                text = getText(temp);
                if (text.contains(c.shortPrint())) {
                    select(mappings.getFleet().getFleetSend_own_planet(), mappings.getFleet().getFleetSend_own_planet_target_pref() + text);
                    found = true;
                    break;
                }
                i++;
            }
            if (!found) {
                throw OgameException.FLEET_UNOWNED_PLANET_CANNOT_STATION;
            }
        } else if (m == Mission.ACS) {
            try {
                select(mappings.getFleet().getFleetSend_acs(), mappings.getFleet().getFleetSend_acs_target_pref() + m.getACSCode());
            } catch (OgameElementNotFoundException ex) {
                throw ex;
            } catch (OgameException ex) {
                throw OgameException.FLEET_WRONG_ACS_CODE;
            }
        } else {
            this.sendFleetSetCords(c);
        }
        select(mappings.getFleet().getFleetSend_speed(), mappings.getFleet().getFleetSend_speed_ans() + speed.getS());
        if (isElementPresent(mappings.getFleet().getFleetSend_errorscreen2())) {
            logger.log(Level.WARNING, "Couldnt send fleet - screen 2");
            throw new OgameException("FLEET SEND SECOND SCREEN ERROR");
            /*
             * Możliwe przyczyny błędu
             * - brak paliwa
             * - brak planety celu
             * - cel ten sam co baza
             */
        }
        try {
            clickAndWait(mappings.getFleet().getFleetSend_okscreen2());
        } catch (OgameException ex) {
            if (isElementPresent(mappings.getFleet().getFleetSend_galaxy())) {
                logger.log(Level.WARNING, "Couldnt send fleet - screen 2 - pop up error");
                throw new OgameException("FLEET SEND SECOND SCREEN ERROR");
            } else {
                throw ex;
            }
        }
        String t = m.getTime();
        sendFleetSetMission(m, t);
        sendFleetSetResources(r);
        TimeParser tp = new TimeParser(mappings.getFleet().getFlight_arrival_format());
        TimePeriodParser tpp = new SimpleTimePeriodParser(mappings.getFleet().getFlight_period_format());
        Time time;
        TimePeriod period;
        String textTime;
        if (Mission.STATION == m) {
            textTime = getText(mappings.getFleet().getFlight_period_label());
            period = tpp.parse(textTime);
            textTime = getText(mappings.getFleet().getFlight_arrival_label());
            for (int i = 0; i < 10 && textTime.length() != mappings.getFleet().getFlight_arrival_format().length(); i++) {
                this.waitMilisecond(100);
                textTime = getText(mappings.getFleet().getFlight_arrival_label());
                System.err.println("i="+i+" "+textTime);
            }
            time = tp.parse(textTime);
        } else {
            textTime = getText(mappings.getFleet().getFlight_period_label());
            period = tpp.parse(textTime);
            period.doubleTimePeriod();
            period.addHours(t);
            textTime = getText(mappings.getFleet().getFlight_arrival_back_label());
            for (int i = 0; i < 10 && textTime.length() != mappings.getFleet().getFlight_arrival_format().length(); i++) {
                this.waitMilisecond(100);
                textTime = getText(mappings.getFleet().getFlight_arrival_back_label());
                System.err.println("i="+i+" "+textTime);
            }
            time = tp.parse(textTime);

        }
        if (selenium.isElementPresent(mappings.getFleet().getFleetSend_errorscreen3())) {
            logger.log(Level.WARNING, "Couldnt send fleet - screen 3");
            throw new OgameException("FLEET SEND THIRD SCREEN ERROR");
            /**
             * Możliwe przyczyny błędu
             * - Maksymalna ilość ekspedycji przekroczona
             * 
             */
        }
        clickAndWait(mappings.getFleet().getFleetSend_okscreen3());
        this.clickOverview();
        return new ArrivalTime(time,period);
    }

    @Override
    public ArrivalTime sendFleet(Planet p, Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException {
        this.changePlanet(p);
        this.waitMilisecond(400);
        return this.sendFleet(p, f, c, speed, m, r);
    }

    @Override
    public ArrivalTime sendFleet(Fleet f, Coords c, Mission m, Resources r) throws OgameException {
        return this.sendFleet(f, c, Speed.S100, m, r);
    }

    @Override
    public ArrivalTime sendFleet(Fleet f, Coords c, Mission m) throws OgameException {
        return this.sendFleet(f, c, Speed.S100, m, Resources.NO_RESOURCES);
    }

    @Override
    public ArrivalTime sendFleet(Fleet f, Coords c) throws OgameException {
        return this.sendFleet(f, c, Speed.S100, Mission.ATTACK, Resources.NO_RESOURCES);
    }

    @Override
    public ArrivalTime sendFSFleet(Fleet f, Coords c, Mission m) throws OgameException {
        return this.sendFleet(f, c, Speed.S100, m, Resources.ALL_RESOURCES);
    }

    @Override
    public ArrivalTime sendFSFleet(Fleet f, Coords c) throws OgameException {
        return this.sendFleet(f, c, Speed.S100, Mission.ATTACK, Resources.ALL_RESOURCES);
    }

    @Override
    public ArrivalTime sendFSFleet(Coords c, Mission m) throws OgameException {
        return this.sendFleet(Fleet.WHOLE_FLEET, c, Speed.S100, m, Resources.ALL_RESOURCES);
    }

    @Override
    public ArrivalTime sendFSFleet(Coords c) throws OgameException {
        return this.sendFleet(Fleet.WHOLE_FLEET, c, Speed.S100, Mission.ATTACK, Resources.ALL_RESOURCES);
    }

    /* *************************************************************************
     * **** NIE SPRAWDZONE *****************************************************
     * *************************************************************************/
    @Override
    public void research(ResearchingArea s) throws OgameException {
        this.clickLab();
        selenium.click(studyMap.get(s));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.clickAndWait(buildingMap.get(b)); //selenium.click
        if (selenium.isElementPresent(mappings.getLab().getStudyNEG())) {
            return; // TODO some error here
        }
        this.clickAndWait(mappings.getLab().getStudyOK());
    }

    @Override
    public void build(Defence d, int i) throws OgameException {
        build(d, Integer.toString(i));
    }

    @Override
    public void build(Defence d, String count) throws OgameException {
        this.clickDefence();
        selenium.click(defenceMap.get(d));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.clickAndWait(buildingMap.get(b)); //selenium.click
        selenium.type(mappings.getDefence().getDefence_number(), count);
        if (selenium.isElementPresent(mappings.getDefence().getDefenceNEG())) {
            return; // TODO some error here
        }
        this.clickAndWait(mappings.getDefence().getDefenceOK());
    }

    @Override
    public void build(ShipyardShips s, int i) throws OgameException {
        build(s, Integer.toString(i));
    }

    @Override
    public void build(ShipyardShips s, String count) throws OgameException {
        this.clickShipyard();
        selenium.click(shipyardMap.get(s));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ogame116pl.class.getName()).log(Level.SEVERE, null, ex);
        }
        selenium.type(mappings.getShipyard().getShipyard_number(), count);
        if (selenium.isElementPresent(mappings.getShipyard().getShipyard_NEG())) {
            return; //dodac OgameException
        }
        clickAndWait(mappings.getShipyard().getShipyard_OK());
    }
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");

    private Calendar parseArrivalTime(String countDownTime, String arrivalTime) throws OgameException {
        int[] countDownList = new int[4];
        String day = mappings.getEvents().getEvent_list_time_parser_day();
        String hour = mappings.getEvents().getEvent_list_time_parser_hour();
        String min = mappings.getEvents().getEvent_list_time_parser_minute();
        String second = mappings.getEvents().getEvent_list_time_parser_second();
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
        if (selenium.isTextPresent(mappings.getOverview().getLeftButtonEventListIsEmpty())) {
            return new ArrayList<Events>();
        }
        int iloscFlot = selenium.getXpathCount(mappings.getEvents().getEvent_list_root()).intValue();
        String flightXPath;
        int id;
        FriendOrFoe nastawienie;
        Multiplicity mp;
        Calendar arrival;
        Coords origin;
        Coords target;
        String contentLink;
        Map<String, String> content;
        int size;
        List<Events> lista = new ArrayList<Events>();

        for (int i = 1; i < iloscFlot + 1; i++) {
            // konwersja na loty
            flightXPath = mappings.getEvents().getEvent_list_flight(i);
            // parsowanie id
            id = Integer.parseInt(selenium.getAttribute(flightXPath + mappings.getEvents().getEvent_list_id_atribute()).replace(mappings.getEvents().getEvent_list_id_atribute_prefix(), ""));
            // ustalanie typu lotu
            if (selenium.getAttribute(flightXPath + mappings.getEvents().getEvent_list_class_atribute()).compareTo(
                    mappings.getEvents().getEvent_list_class_atribute_friendly()) == 0
                    | selenium.getAttribute(flightXPath + mappings.getEvents().getEvent_list_class_atribute()).compareTo(
                    mappings.getEvents().getEvent_list_class_atribute_friendly_return()) == 0) {
                mp = Events.SINGLE_FLEET;
            } else if (selenium.getAttribute(flightXPath + mappings.getEvents().getEvent_list_class_atribute()).compareTo(
                    mappings.getEvents().getEvent_list_class_atribute_enemy_alliance()) == 0) {
                mp = Events.ACS_FLEET;
            } else {
                throw new OgameException("Error cannot recognized is fleet a single or ACS");
            }
            // sprawdźmy nastawienie floty
            if (selenium.isElementPresent(flightXPath + mappings.getEvents().getEvent_list_atribute_is_friendly())) {
                nastawienie = Events.FRIEND;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvents().getEvent_list_atribute_is_neutral())) {
                nastawienie = Events.NEUTRAL;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvents().getEvent_list_atribute_is_enemy())
                    & selenium.isElementPresent(flightXPath + mappings.getEvents().getEvent_list_atribute_is_spy())) {
                nastawienie = Events.SPY;
            } else if (selenium.isElementPresent(flightXPath + mappings.getEvents().getEvent_list_atribute_is_enemy())
                    & selenium.isElementPresent(flightXPath + mappings.getEvents().getEvent_list_atribute_is_attack())) {
                nastawienie = Events.ATTACK;
            } else {
                throw new OgameException("Error cannot recognized whether the fleet is friend or foe");
            }
            if (selenium.getText(flightXPath + mappings.getEvents().getEvent_list_atribute_count_down_time()).compareTo(mappings.getEvents().getEvent_list_time_parser_ingore()) == 0) {
                continue;
            }
            arrival = this.parseArrivalTime(
                    selenium.getText(flightXPath + mappings.getEvents().getEvent_list_atribute_count_down_time()),
                    selenium.getText(flightXPath + mappings.getEvents().getEvent_list_atribute_arrival_time()));
            if (mp == Events.SINGLE_FLEET) {
                origin = Coords.parse(selenium.getText(flightXPath + mappings.getEvents().getEvent_list_atribute_originCoords()));
            } else {
                origin = null;
            }
            target = Coords.parse(selenium.getText(flightXPath + mappings.getEvents().getEvent_list_atribute_destCoords()));
            size = Integer.parseInt(selenium.getText(flightXPath + mappings.getEvents().getEvent_list_atribute_detailsFleet()));
            // parsowanie składu floty
            contentLink = selenium.getAttribute(flightXPath + mappings.getEvents().getEvent_list_atribute_icon_movement());
            logger.log(Level.WARNING, "Cutting content");
            content = getContent(contentLink);
            lista.add(new Events(id, nastawienie, mp, arrival, origin, size, target));

        }

        return lista;

    }

    @Override
    public void setResourcesSettings(ResourceField r, Production p) throws OgameException {
        this.clickResourceSettings();
        this.selenium.select(this.performanceMap.get(r), mappings.getResources().getPerformance_select() + p.getS());
        this.selenium.click(this.mappings.getResources().getPerformance_ok());

    }

    @Override
    public void setResourcesSettings(Performance p) throws OgameException {
        this.clickResourceSettings();
        this.selenium.select(this.performanceMap.get(Performance.METAL), mappings.getResources().getPerformance_select() + p.getMetal().getS());
        this.selenium.select(this.performanceMap.get(Performance.KRYSZTAL), mappings.getResources().getPerformance_select() + p.getKrzysztal().getS());
        this.selenium.select(this.performanceMap.get(Performance.DEUTER), mappings.getResources().getPerformance_select() + p.getDeuter().getS());
        this.selenium.select(this.performanceMap.get(Performance.EL_SLONECZNA), mappings.getResources().getPerformance_select() + p.getEl_Sloneczna().getS());
        this.selenium.select(this.performanceMap.get(Performance.EL_FUZYJNA), mappings.getResources().getPerformance_select() + p.getEl_Fuzyjna().getS());
        this.selenium.select(this.performanceMap.get(Performance.SAT_SLONECZNA), mappings.getResources().getPerformance_select() + p.getSat_Sloneczna().getS());
        this.selenium.click(this.mappings.getResources().getPerformance_ok());
    }

    @Override
    public Fleet getPlanetFleet() throws OgameException {
        this.clickFleet();
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
    public HashMap<ResearchingArea, Integer> getPlanetStudy() throws OgameException {
        HashMap<ResearchingArea, Integer> result = new HashMap<ResearchingArea, Integer>();
        this.clickLab();
        Set set = this.technologyMap.entrySet(); // to jest pobranie listy wszystkich par technologia-xpath
        Iterator it = set.iterator();
        ResearchingArea temp;
        Map.Entry<ResearchingArea, String> temp2;
        String temp3;
        int i;
        while (it.hasNext()) {
            temp2 = (Map.Entry<ResearchingArea, String>) it.next();
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
        this.clickDefence();
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
    public HashMap<BuildingsPlanet, Integer> getPlanetBuildings() throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PlanetResources getCost(ResearchingArea s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PlanetResources getCost(ShipyardShips s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PlanetResources getCost(Defence d) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getProductionTime(ResearchingArea s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getProductionTime(ShipyardShips s) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getProductionTime(Defence d) throws OgameException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Slots> getSlots() throws OgameException {
        this.clickMovements();
        //int maxSlots = Integer.parseInt(selenium.getText(mappings.getSlots_maxFleets()));
        int useSlots = Integer.parseInt(selenium.getText(mappings.getSlots().getSlots_usedFleets()));
        List<Slots> result = new ArrayList<Slots>();
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
                xpath = mappings.getSlots().getSlots_fleet_by_number(i);
                // wczytywanie
                id = Integer.parseInt(selenium.getAttribute(xpath + mappings.getSlots().getSlots_fleetId_suffix()).replace(mappings.getSlots().getSlots_fleetId_remove(), ""));
                // czasy , dolot, powrot, zawrot
                arrival = new GregorianCalendar();
                arrival.setTime(slotParse.parse(selenium.getAttribute(xpath + mappings.getSlots().getSlots_fleetArrival_suffix())));

                {
                    String t = xpath + mappings.getSlots().getSlots_fleetReversal_titleAtribute_suffix(),
                            t2 = xpath + mappings.getSlots().getSlots_fleetReversal_suffix();
                    if (selenium.isElementPresent(t2)) {
                        returning = false;
                        reversal = new GregorianCalendar();
                        reversal.setTime(reversalParse.parse(selenium.getAttribute(t)));
                    }

                }
                {
                    String t = xpath + mappings.getSlots().getSlots_fleetComeBack_titleAtribute_suffix(),
                            t2 = xpath + mappings.getSlots().getSlots_fleetReversal_suffix();
                    if (selenium.isElementPresent(t2)) {
                        comeBack = new GregorianCalendar();
                        comeBack.setTime(comeBackParse.parse(selenium.getAttribute(t)));
                    }
                }


                //baza, cel
                // TODO czy planeta?
                baza = Coords.parse(selenium.getText(xpath + mappings.getSlots().getSlots_fleetOriginPlanet_suffix()));
                cel = Coords.parse(selenium.getText(xpath + mappings.getSlots().getSlots_fleetTargetPlanet_suffix()));
                //misja
                {
                    Set set = movementsMissionStringMapMission.entrySet();
                    Entry<String, Mission> missionTemp;
                    Iterator<Entry<String, Mission>> it = set.iterator();
                    while (it.hasNext()) {
                        missionTemp = it.next();
                        if (missionTemp.getKey().compareTo(selenium.getText(xpath + mappings.getSlots().getSlots_fleetMission_suffix()).replace(" ", "")) == 0) {
                            mission = missionTemp.getValue();
                            break;
                        }
                    }
                }
                // aliance
                temp = selenium.getText(xpath + mappings.getSlots().getSlots_fleetAllianceName_suffix());
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
        String xpath = mappings.getSlots().getSlots_fleet_by_id(f.getId());
        if (selenium.isElementPresent(xpath)) {
            selenium.click(xpath + mappings.getSlots().getSlots_fleetReversal_button_suffix());
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
        return Integer.parseInt(selenium.getText(mappings.getSlots().getSlots_maxFleets()));
    }

    @Override
    public int getSlotsOccupied() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots().getSlots_usedFleets()));
    }

    @Override
    public int getExpeditionsTotal() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots().getSlots_maxExp()));
    }

    @Override
    public int getExpeditionsOccupied() throws OgameException {
        this.clickMovements();
        return Integer.parseInt(selenium.getText(mappings.getSlots().getSlots_useExp()));
    }

    /**************************************************************************
     **************** METODY PRYWATNE ***************************************** 
     **************************************************************************/
    /* **
     * Inicjalizacja 
     */
    private void init() {
        initMappingProperties();
        initBuilding();
        initLab();
        initShipyard();
        initDefence();
        initFleet();
        initResources();
        initMovements();

    }

    private void initMappingProperties() {
        logger.log(Level.INFO, "Reading static mappings");
        mappings = MappingProperties.mappingPropertiesFabric();
        logger.log(Level.INFO, "[DONE]");
    }

    private void initBuilding() {
        logger.log(Level.INFO, "Initializing Building Map to Building String");
        buildingMap = new HashMap<Buildings, String>();
        buildingMap.put(Buildings.DEPOSITE_STATION, mappings.getBuldings().getDepositeStation());
        buildingMap.put(Buildings.DEUTERIUM_EXTRACTOR, mappings.getBuldings().getDeuteriumExtractor());
        buildingMap.put(Buildings.FUSSION_POWER_PLANT, mappings.getBuldings().getFussionPowerPlant());
        buildingMap.put(Buildings.SOLAR_POWER_PLANT, mappings.getBuldings().getSolarPowerPlant());
        buildingMap.put(Buildings.MANUFACTURE_OF_NANITAS, mappings.getBuldings().getNanitas());
        buildingMap.put(Buildings.MANUFACTURE_OF_ROBOTS, mappings.getBuldings().getRobots());
        buildingMap.put(Buildings.CRYSTAL_MINE, mappings.getBuldings().getCrystalMine());
        buildingMap.put(Buildings.METAL_MINE, mappings.getBuldings().getMetalMine());
        buildingMap.put(Buildings.LABORATORY, mappings.getBuldings().getLaboratory());
        buildingMap.put(Buildings.DEUTERIUM_STORAGE, mappings.getBuldings().getDeuteriumStorage());
        buildingMap.put(Buildings.CRYSTAL_STORAGE, mappings.getBuldings().getCrystalStorage());
        buildingMap.put(Buildings.METAL_STORAGE, mappings.getBuldings().getMetalStorage());
        buildingMap.put(Buildings.SOLAR_SATELLITE, mappings.getBuldings().getSatellites());
        buildingMap.put(Buildings.DEUTERIUM_HIDEOUT, mappings.getBuldings().getDeuteriumHideout());
        buildingMap.put(Buildings.CRYSTAL_HIDEOUT, mappings.getBuldings().getCrystalHideout());
        buildingMap.put(Buildings.METAL_HIDEOUT, mappings.getBuldings().getMetalHideout());
        buildingMap.put(Buildings.MISSILE_SILO, mappings.getBuldings().getMissileSilo());
        buildingMap.put(Buildings.SHIPYARD, mappings.getBuldings().getShipyardBuilding());
        buildingMap.put(Buildings.TERRAFORMER, mappings.getBuldings().getTerraformer());
        // TODO dopisać budynki księżycowe
        logger.log(Level.INFO, "[DONE]");
        buildingsTimeParser = new TimePeriodParser(
                this.mappings.getBuldings().getTime_weeks(),
                this.mappings.getBuldings().getTime_days(),
                this.mappings.getBuldings().getTime_hours(),
                this.mappings.getBuldings().getTime_minutes(),
                this.mappings.getBuldings().getTime_seconds());
    }

    private void initLab() {
        logger.log(Level.INFO, "Initializing Study Map");
        studyMap = new HashMap<ResearchingArea, String>();
        studyMap.put(ResearchingArea.ASTROFIZYKA, mappings.getLab().getStudy_af());
        studyMap.put(ResearchingArea.NAPED_IMPULSOWY, mappings.getLab().getStudy_ni());
        studyMap.put(ResearchingArea.NAPED_NADPRZESTRZENNY, mappings.getLab().getStudy_nn());
        studyMap.put(ResearchingArea.NAPED_SPALINOWY, mappings.getLab().getStudy_nn());
        studyMap.put(ResearchingArea.OPANCERZENIE, mappings.getLab().getStudy_op());
        studyMap.put(ResearchingArea.ROZWOJ_GRAWITONOW, mappings.getLab().getStudy_rg());
        studyMap.put(ResearchingArea.SIEC_BADAN, mappings.getLab().getStudy_sb());
        studyMap.put(ResearchingArea.TECHNOLOGIA_BOJOWA, mappings.getLab().getStudy_tb());
        studyMap.put(ResearchingArea.TECHNOLOGIA_ENERGETYCZNA, mappings.getLab().getStudy_te());
        studyMap.put(ResearchingArea.TECHNOLOGIA_JONOWA, mappings.getLab().getStudy_tj());
        studyMap.put(ResearchingArea.TECHNOLOGIA_KOMPUTEROWA, mappings.getLab().getStudy_tk());
        studyMap.put(ResearchingArea.TECHNOLOGIA_LASEROWA, mappings.getLab().getStudy_tl());
        studyMap.put(ResearchingArea.TECHNOLOGIA_NADPRZESTRZENNA, mappings.getLab().getStudy_tn());
        studyMap.put(ResearchingArea.TECHNOLOGIA_OCHRONNA, mappings.getLab().getStudy_to());
        studyMap.put(ResearchingArea.TECHNOLOGIA_PLAZMOWA, mappings.getLab().getStudy_tp());
        studyMap.put(ResearchingArea.TECHNOLOGIA_SZPIEGOWSKA, mappings.getLab().getStudy_ts());
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Initializing Tech map to Technology-level String");
        technologyMap = new HashMap<ResearchingArea, String>();
        technologyMap.put(ResearchingArea.TECHNOLOGIA_ENERGETYCZNA, mappings.getLab().getHm_te());//1
        technologyMap.put(ResearchingArea.TECHNOLOGIA_LASEROWA, mappings.getLab().getHm_tl());//2
        technologyMap.put(ResearchingArea.TECHNOLOGIA_JONOWA, mappings.getLab().getHm_tj());//3
        technologyMap.put(ResearchingArea.TECHNOLOGIA_NADPRZESTRZENNA, mappings.getLab().getHm_tn());//4
        technologyMap.put(ResearchingArea.TECHNOLOGIA_PLAZMOWA, mappings.getLab().getHm_tp());//5
        technologyMap.put(ResearchingArea.NAPED_SPALINOWY, mappings.getLab().getHm_ns());//6
        technologyMap.put(ResearchingArea.NAPED_IMPULSOWY, mappings.getLab().getHm_ni());//7
        technologyMap.put(ResearchingArea.NAPED_NADPRZESTRZENNY, mappings.getLab().getHm_nn());//8
        technologyMap.put(ResearchingArea.TECHNOLOGIA_SZPIEGOWSKA, mappings.getLab().getHm_ts());//9
        technologyMap.put(ResearchingArea.TECHNOLOGIA_KOMPUTEROWA, mappings.getLab().getHm_tk());//10
        technologyMap.put(ResearchingArea.ASTROFIZYKA, mappings.getLab().getHm_af());//11
        technologyMap.put(ResearchingArea.SIEC_BADAN, mappings.getLab().getHm_ms());//12
        technologyMap.put(ResearchingArea.ROZWOJ_GRAWITONOW, mappings.getLab().getHm_rg());//13
        technologyMap.put(ResearchingArea.TECHNOLOGIA_BOJOWA, mappings.getLab().getHm_tb());//13
        technologyMap.put(ResearchingArea.TECHNOLOGIA_OCHRONNA, mappings.getLab().getHm_to());//13
        technologyMap.put(ResearchingArea.OPANCERZENIE, mappings.getLab().getHm_op());//13
        logger.log(Level.INFO, "[DONE]");
    }

    private void initShipyard() {
        logger.log(Level.INFO, "Initializing Shipyard Map");
        shipyardMap = new HashMap<ShipyardShips, String>();
        shipyardMap.put(Ships.BOMB, mappings.getShipyard().getShipyard_bomb());
        shipyardMap.put(Ships.CM, mappings.getShipyard().getShipyard_cm());
        shipyardMap.put(Ships.DT, mappings.getShipyard().getShipyard_dt());
        shipyardMap.put(Ships.GS, mappings.getShipyard().getShipyard_gs());
        shipyardMap.put(Ships.KOL, mappings.getShipyard().getShipyard_skol());
        shipyardMap.put(Ships.KR, mappings.getShipyard().getShipyard_kraz());
        shipyardMap.put(Ships.LM, mappings.getShipyard().getShipyard_lm());
        shipyardMap.put(Ships.MT, mappings.getShipyard().getShipyard_mt());
        shipyardMap.put(Ships.NISZ, mappings.getShipyard().getShipyard_nisc());
        shipyardMap.put(Ships.OW, mappings.getShipyard().getShipyard_ow());
        shipyardMap.put(Ships.PAN, mappings.getShipyard().getShipyard_panc());
        shipyardMap.put(Ships.REC, mappings.getShipyard().getShipyard_rec());
        shipyardMap.put(Ships.SOND, mappings.getShipyard().getShipyard_ss());
        shipyardMap.put(Ships.SAT, mappings.getShipyard().getShipyard_sat());
        logger.log(Level.INFO, "[DONE]");
    }

    private void initDefence() {
        logger.log(Level.INFO, "Initializing Defence Map");
        defenceMap = new HashMap<Defence, String>();
        defenceMap.put(Defence.DUZA_POWLOKA, mappings.getDefence().getDefence_dp());
        defenceMap.put(Defence.DUZY_LASER, mappings.getDefence().getDefence_cl());
        defenceMap.put(Defence.DZIALO_GAUSSA, mappings.getDefence().getDefence_dg());
        defenceMap.put(Defence.DZIALO_JONOWE, mappings.getDefence().getDefence_dj());
        defenceMap.put(Defence.MALA_POWLOKA, mappings.getDefence().getDefence_mp());
        defenceMap.put(Defence.MALY_LASER, mappings.getDefence().getDefence_ll());
        defenceMap.put(Defence.PRZECIWRAKIETA, mappings.getDefence().getDefence_pr());
        defenceMap.put(Defence.RAKITA_MIEDZYPLANETARNA, mappings.getDefence().getDefence_rm());
        defenceMap.put(Defence.WYRZUTNIA_PLAZMY, mappings.getDefence().getDefence_wp());
        defenceMap.put(Defence.WYRZUTNIA_RAKIET, mappings.getDefence().getDefence_wr());
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Inititializing Defence map to Defence size String");
        defcountMap = new HashMap<Defence, String>();
        defcountMap.put(Defence.DUZA_POWLOKA, mappings.getDefence().getHm_dp());
        defcountMap.put(Defence.DUZY_LASER, mappings.getDefence().getHm_cl());
        defcountMap.put(Defence.DZIALO_GAUSSA, mappings.getDefence().getHm_dg());
        defcountMap.put(Defence.DZIALO_JONOWE, mappings.getDefence().getHm_dj());
        defcountMap.put(Defence.MALA_POWLOKA, mappings.getDefence().getHm_mp());
        defcountMap.put(Defence.MALY_LASER, mappings.getDefence().getHm_ll());
        defcountMap.put(Defence.PRZECIWRAKIETA, mappings.getDefence().getHm_pr());
        defcountMap.put(Defence.RAKITA_MIEDZYPLANETARNA, mappings.getDefence().getHm_rm());
        defcountMap.put(Defence.WYRZUTNIA_PLAZMY, mappings.getDefence().getHm_wp());
        defcountMap.put(Defence.WYRZUTNIA_RAKIET, mappings.getDefence().getHm_wr());
        logger.log(Level.INFO, "[DONE]");
    }

    private void initFleet() {
        logger.log(Level.INFO, "Initializing Mission Map to Mission String");
        missionMap = new HashMap<Mission, String>();
        missionMap.put(Mission.ACS, mappings.getFleet().getFleetSend_missionAcs());
        missionMap.put(Mission.ATTACK, mappings.getFleet().getFleetSend_missionAtk());
        missionMap.put(Mission.EXPLORE, mappings.getFleet().getFleetSend_missionExp());
        missionMap.put(Mission.KOLONIZE, mappings.getFleet().getFleetSend_missionKol());
        missionMap.put(Mission.MOON_DESTRUCTION, mappings.getFleet().getFleetSend_missionMoon());
        missionMap.put(Mission.RECYCLE, mappings.getFleet().getFleetSend_missionRec());
        missionMap.put(Mission.SPY, mappings.getFleet().getFleetSend_missionSzp());
        missionMap.put(Mission.STATION, mappings.getFleet().getFleetSend_missionSta());
        missionMap.put(Mission.STAY, mappings.getFleet().getFleetSend_missionZat());
        missionMap.put(Mission.TRANSPORT, mappings.getFleet().getFleetSend_missionTra());
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Initializing Mission Map To Mission is Off String");
        missionOffMap = new HashMap<Mission, String>();
        missionOffMap.put(Mission.ACS, mappings.getFleet().getFleetSend_missionAcs_off());
        missionOffMap.put(Mission.ATTACK, mappings.getFleet().getFleetSend_missionAtk_off());
        missionOffMap.put(Mission.EXPLORE, mappings.getFleet().getFleetSend_missionExp_off());
        missionOffMap.put(Mission.KOLONIZE, mappings.getFleet().getFleetSend_missionKol_off());
        missionOffMap.put(Mission.MOON_DESTRUCTION, mappings.getFleet().getFleetSend_missionMoon_off());
        missionOffMap.put(Mission.RECYCLE, mappings.getFleet().getFleetSend_missionRec_off());
        missionOffMap.put(Mission.SPY, mappings.getFleet().getFleetSend_missionSzp_off());
        missionOffMap.put(Mission.STATION, mappings.getFleet().getFleetSend_missionSta_off());
        missionOffMap.put(Mission.STAY, mappings.getFleet().getFleetSend_missionZat_off());
        missionOffMap.put(Mission.TRANSPORT, mappings.getFleet().getFleetSend_missionTra_off());
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Initializing Ships Map to Ship String");
        shipsMap = new HashMap<Ships, String>();
        shipsMap.put(Ships.BOMB, mappings.getFleet().getFleetSend_bomb());//1
        shipsMap.put(Ships.CM, mappings.getFleet().getFleetSend_cm());//2
        shipsMap.put(Ships.DT, mappings.getFleet().getFleetSend_dt());//3
        shipsMap.put(Ships.GS, mappings.getFleet().getFleetSend_gs());//4
        shipsMap.put(Ships.KOL, mappings.getFleet().getFleetSend_kol());//5
        shipsMap.put(Ships.KR, mappings.getFleet().getFleetSend_kr());//6
        shipsMap.put(Ships.LM, mappings.getFleet().getFleetSend_lm());//7
        shipsMap.put(Ships.MT, mappings.getFleet().getFleetSend_mt());//8
        shipsMap.put(Ships.NISZ, mappings.getFleet().getFleetSend_nisz());//9
        shipsMap.put(Ships.OW, mappings.getFleet().getFleetSend_ow());//10
        shipsMap.put(Ships.PAN, mappings.getFleet().getFleetSend_pan());//11
        shipsMap.put(Ships.REC, mappings.getFleet().getFleetSend_rec());//12
        shipsMap.put(Ships.SOND, mappings.getFleet().getFleetSend_sond());//13
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Initializing Ships Map to Ship Pick All String");
        shipsAllMap = new HashMap<Ships, String>();
        shipsAllMap.put(Ships.BOMB, mappings.getFleet().getFleetSend_bomb_all());//1
        shipsAllMap.put(Ships.CM, mappings.getFleet().getFleetSend_cm_all());//2
        shipsAllMap.put(Ships.DT, mappings.getFleet().getFleetSend_dt_all());//3
        shipsAllMap.put(Ships.GS, mappings.getFleet().getFleetSend_gs_all());//4
        shipsAllMap.put(Ships.KOL, mappings.getFleet().getFleetSend_kol_all());//5
        shipsAllMap.put(Ships.KR, mappings.getFleet().getFleetSend_kr_all());//6
        shipsAllMap.put(Ships.LM, mappings.getFleet().getFleetSend_lm_all());//7
        shipsAllMap.put(Ships.MT, mappings.getFleet().getFleetSend_mt_all());//8
        shipsAllMap.put(Ships.NISZ, mappings.getFleet().getFleetSend_nisz_all());//9
        shipsAllMap.put(Ships.OW, mappings.getFleet().getFleetSend_ow_all());//10
        shipsAllMap.put(Ships.PAN, mappings.getFleet().getFleetSend_pan_all());//11
        shipsAllMap.put(Ships.REC, mappings.getFleet().getFleetSend_rec_all());//12
        shipsAllMap.put(Ships.SOND, mappings.getFleet().getFleetSend_sond_all());//13
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Initializing Ships map to Fleet-Size String");
        fleetMap = new HashMap<Ships, String>();
        fleetMap.put(Ships.BOMB, mappings.getFleet().getHm_bomb());//1
        fleetMap.put(Ships.CM, mappings.getFleet().getHm_cm());//2
        fleetMap.put(Ships.DT, mappings.getFleet().getHm_dt());//3
        fleetMap.put(Ships.GS, mappings.getFleet().getHm_gs());//4
        fleetMap.put(Ships.KOL, mappings.getFleet().getHm_skol());//5
        fleetMap.put(Ships.KR, mappings.getFleet().getHm_kraz());//6
        fleetMap.put(Ships.LM, mappings.getFleet().getHm_lm());//7
        fleetMap.put(Ships.MT, mappings.getFleet().getHm_mt());//8
        fleetMap.put(Ships.NISZ, mappings.getFleet().getHm_nisc());//9
        fleetMap.put(Ships.OW, mappings.getFleet().getHm_ow());//10
        fleetMap.put(Ships.PAN, mappings.getFleet().getHm_panc());//11
        fleetMap.put(Ships.REC, mappings.getFleet().getHm_rec());//12
        fleetMap.put(Ships.SOND, mappings.getFleet().getHm_ss());//13
        logger.log(Level.INFO, "[DONE]");
    }

    private void initResources() {
        logger.log(Level.INFO, "Initializing Performance Map");
        performanceMap = new HashMap<Performance.ResourceField, String>();
        performanceMap.put(Performance.METAL, mappings.getResources().getPerformance_m());
        performanceMap.put(Performance.KRYSZTAL, mappings.getResources().getPerformance_k());
        performanceMap.put(Performance.DEUTER, mappings.getResources().getPerformance_d());
        performanceMap.put(Performance.EL_SLONECZNA, mappings.getResources().getPerformance_es());
        performanceMap.put(Performance.EL_FUZYJNA, mappings.getResources().getPerformance_ef());
        performanceMap.put(Performance.SAT_SLONECZNA, mappings.getResources().getPerformance_ss());
        logger.log(Level.INFO, "[DONE]");
    }

    private void initMovements() {
        logger.log(Level.INFO, "Initilizing String map to Mission Obj");
        movementsMissionStringMapMission = new HashMap<String, Mission>();
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.ACS), Mission.ACS);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.ATTACK), Mission.ATTACK);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.EXPLORE), Mission.EXPLORE);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.KOLONIZE), Mission.KOLONIZE);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.MOON_DESTRUCTION), Mission.MOON_DESTRUCTION);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.RECYCLE), Mission.RECYCLE);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.SPY), Mission.SPY);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.STATION), Mission.STATION);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.STAY), Mission.STAY);
        movementsMissionStringMapMission.put(mappings.getSlots().getSlotMissionID(Mission.TRANSPORT), Mission.TRANSPORT);
        logger.log(Level.INFO, "[DONE]");
        logger.log(Level.INFO, "Initializing parsers");
        slotParse = new SimpleDateFormat(mappings.getSlots().getSlots_parseArrival());
        reversalParse = new SimpleDateFormat(mappings.getSlots().getSlots_parseReversal());
        comeBackParse = new SimpleDateFormat(mappings.getSlots().getSlots_parseReturn());
        logger.log(Level.INFO, "[DONE]");
    }
    /***************************************************************************
     ***************** POLA PRYWATNE ******************************************* 
     ***************************************************************************/
    private MappingProperties mappings;
    private HashMap<Mission, String> missionMap;
    private HashMap<Mission, String> missionOffMap;
    private HashMap<Ships, String> shipsMap;
    private HashMap<Ships, String> shipsAllMap;
    private HashMap<Buildings, String> buildingMap;
    private HashMap<ResearchingArea, String> studyMap;
    private HashMap<Defence, String> defenceMap;
    private HashMap<ShipyardShips, String> shipyardMap;
    private HashMap<Performance.ResourceField, String> performanceMap;
    private HashMap<Ships, String> fleetMap;
    private HashMap<ResearchingArea, String> technologyMap;
    private HashMap<Defence, String> defcountMap;
    private HashMap<String, Mission> movementsMissionStringMapMission;
    private SimpleDateFormat slotParse;
    private SimpleDateFormat reversalParse;
    private SimpleDateFormat comeBackParse;
    private TimePeriodParser buildingsTimeParser;
    /***************************************************************************
     ********************* POLA I METODY STATYCZNE ***************************** 
     ***************************************************************************/
    private static final Logger logger = Logger.getLogger(Ogame116pl.class.getName());
}
