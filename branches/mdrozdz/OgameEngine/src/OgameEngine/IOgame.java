/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.util.List;

/**
 *
 * @author dyschemist
 */
public interface IOgame {
    abstract public void wait(int seconds);
    abstract public void wait(int minute, int seconds);
    abstract public void wait(int hour, int minute, int seconds);
    abstract public void login(String uni, String user, String pass);
    abstract public void logout();
    abstract public int getPlanetCount();
    abstract public void changePlanet(int planetNumber);
    abstract public void changePlanetByName(String name);
    abstract public List<String> getPlanetNames();
    abstract public List<String> getPlanetCoords();
    abstract public void sendFleet(Fleet f,StartDestination d, Cords c, Speed speed, Mission m, Resources r) throws OgameException;
    abstract public void sendFleet(Fleet f, Cords c, Speed speed, Mission m, Resources r) throws OgameException;
    abstract public void sendFleet(Fleet f, Cords c, Mission m, Resources r) throws OgameException;
    abstract public void build(Buildings b);
    abstract public void study(Study s);
    abstract public void buildDefence(Defence d, int i);
    abstract public void buildDefence(Defence d, String count);
    abstract public void buildShip(StockyardShips s, int i);
    abstract public void buildShip(StockyardShips s, String count);
    abstract public List<Flights> getEventList() throws OgameException;
    abstract public Resources getResources();
    abstract public Fleet getPlanetFleet();
}
