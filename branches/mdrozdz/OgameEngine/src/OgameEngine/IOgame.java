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
    abstract public void buildShip(ShipyardShips s, int i)throws OgameException;
    abstract public void buildShip(ShipyardShips s, String count)throws OgameException;
    abstract public List<Flights> getEventList() throws OgameException; //piotrek
    /**
     * Metoda pobierająca ilość statków znadująch się w obecnej chwili w soczni.
     * @return Metoda zwraca obiekt Fleet (tablice asocjacyjną) par - statek i jego ilość.
     * @throws OgameException, Błąd odczytu.
     */
    abstract public Fleet getPlanetFleet()throws OgameException;
    /**
     * <b>Metoda pobierająca wszytkie poziomy badań na planecie</b>.
     * @return Metoda zwraca obiekt HashMapę (tablicę asocjacyjną) par - rodzaj badania i jego poziom.
     * @throws OgameException 
     */
    abstract public HashMap<Study,Integer> getPlanetStudy()throws OgameException;
    abstract public HashMap<Defence,Integer> getPlanetDefence()throws OgameException;
    abstract public void setResourcesSettings(ResourceField r, Production p)throws OgameException; //plichu
    abstract public void setResourcesSettings(Performance p)throws OgameException; //plichu
    /**
     * Metoda pobierająca ile surowców jest potrzebnych do budowy budynku na poziom wyżej.
     * @param b Odpowiada za budynek, z którego zostaną pobrane ilości surowców potrzebne do zbudowania go na poziom wyżej.
     * @return Metoda zwraca obiekt PlanetResources zawierający zapisane zasoby surowców potrzebnych do zbudowania danego budynku.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public PlanetResources getBuildCost(Buildings b) throws OgameException;
    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbadania danej technologii na poziom wyżej.
     * @param s Odpowiada za badanie, z którego zostaną pobrane ilości surowców potrzebne do zbadania danej technologii na poziom wyżej. 
     * @return Metoda zwraca obiekt PlanetResources zawierający zapisane zasoby surowców potrzebnych do zbadania danej technologii.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public PlanetResources getStudyCost(Study s) throws OgameException;
    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbudowania danego statku.
     * @param s Odpowiada za statek, z którego zostaną pobrane ilości surowców potrzebne do zbudowania go. 
     * @return Metoda zwraca obiekt Resources zawierający zapisane zasoby surowców potrzebnych do zbudowania danego statku.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public Resources getShipyardCost(ShipyardShips s) throws OgameException;
    /**
     * Metoda pobierająca poziomy infrastruktury(wszystkich budynków) w surowcach oraz stoczni.
     * @return Metoda zwraca obiekt HashMapę (tablicę asocjacyjną) par - budynek i jego poziom.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public HashMap<Buildings,Integer> getPlanetBuildings() throws OgameException;
    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbudowania danej jednostki obronnej.
     * @param d Odpowiada za jednostkę obronną, z której zostaną pobrane ilości surowców potrzebne do jej zbudowania. 
     * @return Metoda zwraca obiekt Resources zawierający zapisane zasoby surowców potrzebnych do zbudowania danej jednostki obronnej.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public Resources getDefenceCost(Defence d) throws OgameException;

    //TODO Fill those methods
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
