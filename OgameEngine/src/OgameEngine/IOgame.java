/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.StartDestination;
import OgameEngine.Fleet.StockyardShips;
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
    abstract public void logout()throws OgameException;
    abstract public int getPlanetCount()throws OgameException;
    abstract public void changePlanet(int planetNumber)throws OgameException;
    abstract public void changePlanetByName(String name)throws OgameException;
    abstract public List<String> getPlanetNames()throws OgameException;
    abstract public List<String> getPlanetCoords()throws OgameException;
    abstract public void sendFleet(Fleet f,StartDestination d, Coords c, Speed speed, Mission m, Resources r) throws OgameException;
    abstract public void sendFleet(Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException;
    abstract public void sendFleet(Fleet f, Coords c, Mission m, Resources r) throws OgameException;
    abstract public void build(Buildings b)throws OgameException;
    abstract public void study(Study s)throws OgameException;
    abstract public void buildDefence(Defence d, int i)throws OgameException;
    abstract public void buildDefence(Defence d, String count)throws OgameException;
    abstract public void buildShip(StockyardShips s, int i)throws OgameException;
    abstract public void buildShip(StockyardShips s, String count)throws OgameException;
    abstract public List<Flights> getEventList() throws OgameException;
    abstract public Fleet getPlanetFleet()throws OgameException;
    abstract public HashMap<Study,Integer> getPlanetStudy()throws OgameException;
    abstract public HashMap<Defence,Integer> getPlanetDefence()throws OgameException;
    abstract public void setResourcesSettings(ResourceField r, Production p)throws OgameException;
    abstract public void setResourcesSettings(Performance p)throws OgameException;
}
