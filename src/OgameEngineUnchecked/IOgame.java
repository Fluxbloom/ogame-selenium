/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.PlanetResources;
import OgameElementsUnchecked.Speed;
import OgameElementsUnchecked.Resources;
import OgameElementsUnchecked.ResearchingArea;
import OgameElementsUnchecked.Slots;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Events;
import OgameElementsUnchecked.Defence;
import OgameElements.Buildings;
import OgameElementsUnchecked.Coords;
import OgameElementsUnchecked.Coords.StartDestination;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Performance;
import OgameElementsUnchecked.Performance.Production;
import OgameElementsUnchecked.Performance.ResourceField;
import OgameElementsUnchecked.ShipyardShips;
import java.util.HashMap;
import java.util.List;

/**
 * Interfejs głównych metod gry. Stanowi zespoł wszystkich dostępnych dla użytkownika biblioteki akcji. 
 * W przypadku Ogame wszystkie te metody są implementowane przez abstrakcyjną klasę Ogame, 
 * a implementacje poszczególnych wersji są rozróżnianie w metodzie fabryki ogame
 * @author dyschemist
 */
public interface IOgame {

    /**************************************************************************
     ************************** METODY CZASÓW *********************************
     **************************************************************************/
    /**
     * Metoda oczekiwania 
     * @param miliseconds czas oczekiwania w milisekundach (1000 milisekund = 1 sekunda) 
     */
    abstract public void waitMilisecond(int miliseconds);

    /**
     * Metoda oczekiwania
     * @param seconds czas w sekundach oczekiwania
     */
    abstract public void wait(int seconds);

    /**
     * Metoda oczekiwania. Wartość minut ani sekund nie jest ograniczona z góry.
     * @param minute minuty oczekiwania
     * @param seconds sekundy oczekiwania
     */
    abstract public void wait(int minute, int seconds);

    /**
     * Metoda oczekiwania. Wartość minut,godzin ani sekund nie jest z góry ograniczona
     * @param hour godziny oczekiwania
     * @param minute minuty oczekiwania
     * @param seconds sekundy oczekiwania
     */
    abstract public void wait(int hour, int minute, int seconds);

    /**************************************************************************
     ************************** METODY LOGOWAN *********************************
     **************************************************************************/
    /**
     * Metoda startująca sterownik selenium
     * @throws OgameException serwer nie działa
     */
    abstract public void start() throws OgameException;

    /**
     * Metoda zamykająca sterownik selenium
     */
    abstract public void stop();

    /**
     * Logowanie z otwarciem przeglądarki
     * @param uni nazwa uniwersum
     * @param user login użytkownika
     * @param pass hasło użytkownika
     * @throws OgameException, brak dostępu do serwera, zły login lub hasło
     * 
     */
    abstract public void login(String uni, String user, String pass) throws OgameException;

    /**
     * Zwraca true jeśli nasza sesja w przeglądarce jest ważna
     * @return true jestli zalogowani, false jeśli potrzeba ponownie się zalogować
     */
    abstract public boolean isLogged();

    /**
     * Wylogowywuje
     * @throws OgameException przycisk nie widoczny 
     */
    abstract public void logout() throws OgameException;

    /**************************************************************************
     ************************** METODY PLANET *********************************
     **************************************************************************/
    /**
     * Zwraca ilosc planet gracza
     * @return ilość planet gracza
     * @throws OgameException 
     */
    abstract public int getPlanetCount() throws OgameException;

    /**
     * Gromadzi dane o danej planecie gracza
     * @param planetNumber numer planety na liście
     * @return obiekt planety zawierający nazwę i kordynaty
     * @throws OgameException nieodnalezione pola
     */
    abstract public Planet getPlanet(int planetNumber) throws OgameException;

    /**
     * Gromadzi dane o wszystkich planetach gracza
     * @return lista planet gracza
     * @throws OgameException  nieodnalezione pola
     */
    abstract public List<Planet> getPlanetList() throws OgameException;

    /**
     * Zmień planete na planete o określonym numerze
     * @param planetNumber numer planety na liście
     * @throws OgameException nieodnalezione pola
     */
    abstract public void changePlanet(int planetNumber) throws OgameException;

    /**
     * Zmień planetę na planetę o określonej nazwie. Gdy kilka o identycznej nazwie wtedy na pierwszą z nich w liście.
     * @param name nazwa planety na którą ma być dokonana zmiana
     * @throws OgameException nieodnaleziono planety o danej nazwie
     */
    abstract public void changePlanetByName(String name) throws OgameException;

    /**
     * Zmień planetę na planetę o określonych koordynatach
     * @param c kordynaty planety na którą ma być dokonana zmiana
     * @throws OgameException brak planety o podanych koordynatach
     */
    abstract public void changePlanetByCoords(Coords c) throws OgameException;

    /**
     * Zmień planetę na podaną tym obiektem
     * // TODO ta metoda domyślnie powinna pozwolić również na przełączenie się na księżyc
     * @param p Obiekt planety na którą ma być przełączenie
     * @throws OgameException brak planety o podanych kordynatach
     */
    abstract public void changePlanet(Planet p) throws OgameException;

    /**
     * Pobiera nazwy wszystkich planet na liście
     * @deprecated zalecane jest pobieranie calych planet
     * @return Lista nazw wszystkich planet
     * @throws OgameException brak odpowiednich pól
     */
    abstract public List<String> getPlanetNames() throws OgameException;

    /**
     * Pobiera kordynaty wszystkich planet gracza
     * @deprecated zalecane jest pobieranie calych planet
     * @return Lista kordynatów w postaci [X:XXX:XX]
     * @throws OgameException brak pól
     */
    abstract public List<String> getPlanetCoords() throws OgameException;

    /****************************************************************************
     * METODY DO wysyłania flot
     ****************************************************************************/
    abstract public void sendFleet(Planet p, Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException;

    /**
     * Wysyła flotę z danej planety
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param speed obiekt prędkości
     * @param m obiekt misji
     * @param r obiekt zasobow
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFleet(Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException;

    /**
     * Wysyła flotę z danej planety na pełnym tempie
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @param r obiekt zasobow
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFleet(Fleet f, Coords c, Mission m, Resources r) throws OgameException;

    /**
     * Wysyła flotę z danej planety bez zasobów na pełnym tempie
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFleet(Fleet f, Coords c, Mission m) throws OgameException;

    /**
     * Wysyła flotę z danej planety, w pełnym tempie i bez surowców na atak
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFleet(Fleet f, Coords c) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli flotę z pełnymi lukami 
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFSFleet(Fleet f, Coords c, Mission m) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli flotę z pełnymi lukami w misji atakuj
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFSFleet(Fleet f, Coords c) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli całą flotę z pełnymi lukami
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFSFleet(Coords c, Mission m) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli całą flotę z pełnymi lukami na misji atakuj
     * @param c obiekt kordynatów
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public void sendFSFleet(Coords c) throws OgameException;

    /* *************************************************************************
     * ************* WIDOK OGOLNY **********************************************
     * ************************************************************************/
    
    abstract public PlanetResources getResources();
    
    
    /* ************************************************************************
     * ************************* BUDYNKI **************************************
     * ************************************************************************/
    abstract public void build(Buildings b) throws OgameException;

    abstract public void research(ResearchingArea s) throws OgameException;

    abstract public void build(Defence d, int i) throws OgameException;

    abstract public void build(Defence d, String count) throws OgameException;

    abstract public void build(ShipyardShips s, int i) throws OgameException;

    abstract public void build(ShipyardShips s, String count) throws OgameException;

    abstract public List<Events> getEventList() throws OgameException;

    /**
     * Metoda pobierająca ilość statków znadująch się w obecnej chwili w soczni.
     * @return Metoda zwraca obiekt Fleet (tablice asocjacyjną) par - statek i jego ilość.
     * @throws OgameException, Błąd odczytu.
     */
    abstract public Fleet getPlanetFleet() throws OgameException;

    /**
     * <b>Metoda pobierająca wszytkie poziomy badań na planecie</b>.
     * @return Metoda zwraca obiekt HashMapę (tablicę asocjacyjną) par - rodzaj badania i jego poziom.
     * @throws OgameException 
     */
    abstract public HashMap<ResearchingArea, Integer> getPlanetStudy() throws OgameException;

    abstract public HashMap<Defence, Integer> getPlanetDefence() throws OgameException;

    abstract public void setResourcesSettings(ResourceField r, Production p) throws OgameException;

    abstract public void setResourcesSettings(Performance p) throws OgameException;
    // TODO fill in this methods

    /**
     * Metoda pobierająca poziomy infrastruktury(wszystkich budynków) w surowcach oraz stoczni.
     * @return Metoda zwraca obiekt HashMapę (tablicę asocjacyjną) par - budynek i jego poziom.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public HashMap<Buildings, Integer> getPlanetBuildings() throws OgameException;

    

    /**
     * Metoda pobierająca ile surowców jest potrzebnych do budowy budynku na poziom wyżej.
     * @param b Odpowiada za budynek, z którego zostaną pobrane ilości surowców potrzebne do zbudowania go na poziom wyżej.
     * @return Metoda zwraca obiekt PlanetResources zawierający zapisane zasoby surowców potrzebnych do zbudowania danego budynku.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public Resources getCost(Buildings b) throws OgameException;

    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbadania danej technologii na poziom wyżej.
     * @param s Odpowiada za badanie, z którego zostaną pobrane ilości surowców potrzebne do zbadania danej technologii na poziom wyżej. 
     * @return Metoda zwraca obiekt PlanetResources zawierający zapisane zasoby surowców potrzebnych do zbadania danej technologii.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public Resources getCost(ResearchingArea s) throws OgameException;

    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbudowania danego statku.
     * @param s Odpowiada za statek, z którego zostaną pobrane ilości surowców potrzebne do zbudowania go. 
     * @return Metoda zwraca obiekt Resources zawierający zapisane zasoby surowców potrzebnych do zbudowania danego statku.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public Resources getCost(ShipyardShips s) throws OgameException;

    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbudowania danej jednostki obronnej.
     * @param d Odpowiada za jednostkę obronną, z której zostaną pobrane ilości surowców potrzebne do jej zbudowania. 
     * @return Metoda zwraca obiekt Resources zawierający zapisane zasoby surowców potrzebnych do zbudowania danej jednostki obronnej.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public Resources getCost(Defence d) throws OgameException;

    /**
     * 
     * @param b Obiekt budynku
     * @return czas w sekundach
     * @throws OgameException 
     */
    abstract public long getProductionTime(Buildings b) throws OgameException;

    abstract public long getProductionTime(ResearchingArea s) throws OgameException;

    abstract public long getProductionTime(ShipyardShips s) throws OgameException;

    abstract public long getProductionTime(Defence d) throws OgameException;

    abstract public boolean isBuildQueueEmpty() throws OgameException;

    abstract public boolean isResearchQueueEmpty() throws OgameException;
    //TODO refactor this name

    abstract public boolean isConstructionQueueEmpty() throws OgameException;

    abstract public List<Slots> getSlots() throws OgameException; // moja :-)

    abstract public void turnBackFlight(Slots f) throws OgameException; //moja :-)

    abstract public int getSlotsTotal() throws OgameException;

    abstract public int getSlotsOccupied() throws OgameException;

    abstract public int getExpeditionsTotal() throws OgameException;

    abstract public int getExpeditionsOccupied() throws OgameException;

    abstract public Resources getPlanetHourlyProduction() throws OgameException;
}
