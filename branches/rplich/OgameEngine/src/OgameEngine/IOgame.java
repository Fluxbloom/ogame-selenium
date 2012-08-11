/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.StartDestination;
import OgameEngine.Fleet.ShipyardShips;
import OgameEngine.Performance.Production;
import OgameEngine.Performance.ResourceField;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dyschemist
 */
public interface IOgame {
    abstract public void wait(int seconds);
    abstract public void wait(int minute, int seconds);
    abstract public void wait(int hour, int minute, int seconds);
    abstract public void login(String uni, String user, String pass) throws OgameException;
    abstract public void relogin(String uni, String user, String pass) throws OgameException;
    abstract public boolean isLogged() throws OgameException;
    abstract public void logout()throws OgameException;
    abstract public void close();
    abstract public int getPlanetCount()throws OgameException;
    abstract public List<Planet> getPlanetList() throws OgameException;
    abstract public void changePlanet(int planetNumber)throws OgameException;
    abstract public void changePlanetByName(String name)throws OgameException;
    abstract public void changePlanetByCoords(Coords c) throws OgameException;
    abstract public List<String> getPlanetNames()throws OgameException;
    abstract public List<String> getPlanetCoords()throws OgameException;
    abstract public void sendFleet(Fleet f,StartDestination d, Coords c, Speed speed, Mission m, Resources r) throws OgameException;
    abstract public void sendFleet(Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException;
    abstract public void sendFleet(Fleet f, Coords c, Mission m, Resources r) throws OgameException;
    abstract public void build(Buildings b)throws OgameException;
    abstract public void study(Study s)throws OgameException;
    abstract public void buildDefence(Defence d, int i)throws OgameException;
    abstract public void buildDefence(Defence d, String count)throws OgameException;
    abstract public void buildShip(ShipyardShips s, int i)throws OgameException;
    abstract public void buildShip(ShipyardShips s, String count)throws OgameException;
    abstract public List<Events> getEventList() throws OgameException;
    abstract public Fleet getPlanetFleet()throws OgameException;
    abstract public HashMap<Study,Integer> getPlanetStudy()throws OgameException;
    abstract public HashMap<Defence,Integer> getPlanetDefence()throws OgameException;
    abstract public void setResourcesSettings(ResourceField r, Production p)throws OgameException;
    abstract public void setResourcesSettings(Performance p)throws OgameException;
    // TODO fill in this methods
    abstract public HashMap<Buildings,Integer> getPlanetBuildings() throws OgameException;
    abstract public Resources getBuildCost(Buildings b) throws OgameException;
    abstract public Resources getStudyCost(Study s) throws OgameException;
    abstract public Resources getShipyardCost(ShipyardShips s) throws OgameException;
    abstract public Resources getDefenceCost(Defence d) throws OgameException;
    /**
     * 
     * @param b Obiekt budynku
     * @return czas w sekundach
     * @throws OgameException 
     */
    abstract public long getBuildTime(Buildings b) throws OgameException;
    abstract public long getStudyTime(Study s) throws OgameException;
    abstract public long getShipyardTime(ShipyardShips s) throws OgameException;
    abstract public long getDefenceTime(Defence d) throws OgameException;
    
    abstract public boolean isBuildQueueEmpty() throws OgameException;
    abstract public boolean isLabQueueEmpty() throws OgameException;
    
    abstract public List<Slots> getSlots() throws OgameException; // moja :-)
    abstract public void turnBackFlight(Slots f) throws OgameException; //moja :-)
    abstract public int getSlotsTotal() throws OgameException;
    abstract public int getSlotsOccupied() throws OgameException;
    abstract public int getExpeditionsTotal() throws OgameException;
    abstract public int getExpeditionsOccupied() throws OgameException;
    
    abstract public Resources getPlanetHourlyProduction() throws OgameException;
}
