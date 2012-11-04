/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameElements.ArrivalTime;
import OgameElements.AstronomicalObject;
import OgameElements.Buildings;
import OgameEngine.Exceptions.OgameException;
import OgameElements.Planet;
import OgameElements.PlanetResources;
import OgameElements.Speed;
import OgameElements.Resources;
import OgameElements.ResearchingArea;
import OgameElements.Slots;
import OgameElements.Mission;
import OgameElements.Events;
import OgameElements.Defence;
import OgameElements.BuildingsPlanet;
import OgameElements.Coords;
import OgameElements.Report;
import OgameElements.Time;
import OgameElements.TimePeriod;
import OgameElements.Fleet;
import OgameElements.GalaxyRow;
import OgameElements.Performance;
import OgameElements.Performance.Production;
import OgameElements.Performance.ResourceField;
import OgameElements.ShipyardShips;
import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.Exceptions.OgameParsingException;
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

    /**
     * Meoda oczekiwania przez czas podany w wait period
     * @param t obiekt czasu oczekiwania
     */
    abstract public void wait(TimePeriod t);
    /**
     * Metoda oczekiwania aż do podanego czasu
     * @param t Czas końca oczekiwania
     */
    abstract public void waitTill(Time t);
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

    /* *************************************************************************
     * ************* WIDOK OGOLNY **********************************************
     * ************************************************************************/
    
    
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
    abstract public Planet getPlanet(int planetNumber) throws OgameElementNotFoundException, OgameFileNotFoundException, OgameIOException, OgameParsingException;

    /**
     * Gromadzi dane o wszystkich planetach gracza
     * @return lista planet gracza
     * @throws OgameException  nieodnalezione pola
     */
    abstract public List<AstronomicalObject> getPlanetList() throws OgameElementNotFoundException, OgameFileNotFoundException, OgameIOException, OgameParsingException;

    /**
     * Zmień planete na planete o określonym numerze
     * @param planetNumber numer planety na liście
     * @throws OgameException nieodnalezione pola
     */
    abstract public void changePlanet(int planetNumber) throws OgameException;
    
     /**
     * Zmień planete na ksiezyc o określonym numerze
     * @param planetNumber numer ksiezyca na liście
     * @throws OgameException nieodnalezione pola
     */
    abstract public void changeMoon(int planetNumber) throws OgameException;

    /**
     * Zmień planetę na planetę o określonej nazwie. Gdy kilka o identycznej nazwie wtedy na pierwszą z nich w liście.
     * @param name nazwa planety na którą ma być dokonana zmiana
     * @throws OgameException nieodnaleziono planety o danej nazwie
     */
    abstract public void changePlanetByName(String name) throws OgameException;

    /**
     * Zmień planetę na podaną tym obiektem
     * @param p Obiekt planety na którą ma być przełączenie
     * @throws OgameException brak planety o podanych kordynatach
     */
    // TODO ta metoda domyślnie powinna pozwolić również na przełączenie się na księżyc
    abstract public void changePlanet(AstronomicalObject p) throws OgameException;

    /**
     * Pobiera zasoby na danej planecie
     * @return obiekt zasobów na planecie
     */
    abstract public PlanetResources getResources() throws OgameElementNotFoundException;
    
    /**
     * Sprawdza czy kolejka budowy na danej planecie jest pusta
     * @return true jeśli pusta, false w p.p.
     * @throws OgameElementNotFoundException błędny text do wyszukania
     * @throws OgameException inny błąd timeout np, albo brak serwera Selenium
     */
    abstract public boolean isBuildQueueEmpty() throws OgameElementNotFoundException, OgameException;
    /**
     * Sprawdza czy kolejka badań na danej planecie jest pusta
     * @return true jeśli pusta, false w p.p.
     * @throws OgameElementNotFoundException błędny text do wyszukania
     * @throws OgameException inny błąd timeout np, albo brak serwera Selenium
     */
    abstract public boolean isResearchQueueEmpty() throws OgameElementNotFoundException, OgameException;
    /**
     * Sprawdza czy kolejka stoczni na danej planecie jest pusta
     * @return true jeśli pusta, false w p.p.
     * @throws OgameElementNotFoundException błędny text do wyszukania
     * @throws OgameException inny błąd timeout np, albo brak serwera Selenium
     */
    abstract public boolean isConstructionQueueEmpty() throws OgameElementNotFoundException, OgameException;
    
    /****************************************************************************
     * METODY DO wysyłania flot
     ****************************************************************************/

    /**
     * Wysyła flotę z planety p
     * @param p planeta
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param speed obiekt prędkości
     * @param m obiekt misji
     * @param r obiekt zasobow
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFleet(Planet p, Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException;

    /**
     * Wysyła flotę z danej planety
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param speed obiekt prędkości
     * @param m obiekt misji
     * @param r obiekt zasobow
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFleet(Fleet f, Coords c, Speed speed, Mission m, Resources r) throws OgameException;

    /**
     * Wysyła flotę z danej planety na pełnym tempie
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @param r obiekt zasobow
    * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFleet(Fleet f, Coords c, Mission m, Resources r) throws OgameException;

    /**
     * Wysyła flotę z danej planety bez zasobów na pełnym tempie
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFleet(Fleet f, Coords c, Mission m) throws OgameException;

    /**
     * Wysyła flotę z danej planety, w pełnym tempie i bez surowców na atak
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFleet(Fleet f, Coords c) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli flotę z pełnymi lukami 
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFSFleet(Fleet f, Coords c, Mission m) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli flotę z pełnymi lukami w misji atakuj
     * @param f obiekt floty
     * @param c obiekt kordynatów
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFSFleet(Fleet f, Coords c) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli całą flotę z pełnymi lukami
     * @param c obiekt kordynatów
     * @param m obiekt misji
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFSFleet(Coords c, Mission m) throws OgameException;

    /**
     * Wysyła flotę fsa z danej planety czyli całą flotę z pełnymi lukami na misji atakuj
     * @param c obiekt kordynatów
     * @return Obiekt czasu powrotu (jednostronny dla stacjonuj, powrotny dla reszty misji)
     * @throws OgameException różne błedy, od braków pól do błędów nadania floty
     */
    abstract public ArrivalTime sendFSFleet(Coords c) throws OgameException;

    /**
     * Pobiera ilość dostępny ogólnie slotów
     * @return ilość możliwych slotów
     * @throws OgameElementNotFoundException brak xpatha
     * @throws OgameException inny błąd
     */
    abstract public int getSlotsTotal() throws OgameElementNotFoundException,OgameException;
 /**
     * Pobiera ilość zajętych obecnie slotów
     * @return ilość zajętych slotów
     * @throws OgameElementNotFoundException brak xpatha
     * @throws OgameException inny błąd
     */
    abstract public int getSlotsOccupied() throws OgameElementNotFoundException,OgameException;
     /**
     * Pobiera ilość dostępny ekspedycji
     * @return ilość możliwych ekspedycji
     * @throws OgameElementNotFoundException brak xpatha
     * @throws OgameException inny błąd
     */
    abstract public int getExpeditionsTotal() throws OgameElementNotFoundException,OgameException;
     /**
     * Pobiera ilość zajętych ekspedycji
     * @return ilość zajętych ekspedycji
     * @throws OgameElementNotFoundException brak xpatha
     * @throws OgameException inny błąd
     */
    abstract public int getExpeditionsOccupied() throws OgameElementNotFoundException,OgameException;
    
    // TODO dotąd są zrobione
    /* ***********************************************************************/
    
    /* ************************************************************************
     * ************************* BUDYNKI **************************************
     * ************************************************************************/
    /**
     * Metoda buduje wskazany budynek na planecie
     * UWAGA! Metoda nie wspiera jeszcze księżyców
     * @param b Obiekt budynku
     * @throws OgameElementNotFoundException, nieistniejące pole
     * @throws OgameException 
     */
    // TODO obsuga księżyców
    abstract public void build(Buildings b) throws OgameElementNotFoundException,OgameException;

     /**
     * Metoda pobierająca ile surowców jest potrzebnych do budowy budynku na poziom wyżej.
     * @param b Odpowiada za budynek, z którego zostaną pobrane ilości surowców potrzebne do zbudowania go na poziom wyżej.
     * @return Metoda zwraca obiekt PlanetResources zawierający zapisane zasoby surowców potrzebnych do zbudowania danego budynku.
     * @throws OgameElementNotFoundException, nieistniejące pole
     * @throws OgameException, Błąd Odczytu. 
     */
    // TODO obsuga księżyców
    abstract public PlanetResources getCost(Buildings b) throws OgameElementNotFoundException,OgameException;
    
   /**
     * Metoda pobiera czas potrzebny do wzniesienia budynku
     * @param b Obiekt budynku
     * @return czas przeformatowany do obiektu kalendarza
     * @throws OgameElementNotFoundException, nieistniejące pole
     * @throws OgameException 
     */
    // TODO obsuga księżyców
    abstract public TimePeriod getProductionTime(Buildings b) throws OgameElementNotFoundException,OgameException;
    
    /* ************************************************************************
     * ************************* WIADOMOSCI *********************************
     * ************************************************************************/
    /**
     * Metoda pobiera określoną ilość ostatnich raportów szpiegowskich
     * @param count ilość raportów
     * @return raporty szpiegowskie
     * @throws OgameElementNotFoundException brak elementu
     * @throws OgameException inny błąd
     */
    abstract public List<Report> getReports(int count) throws OgameElementNotFoundException, OgameException;
    
     /* ************************************************************************
     * ************************* GALAKTYKA  ************************************
     * ************************************************************************/   
    
    abstract public GalaxyRow getGalaxyView(Coords c) throws OgameElementNotFoundException, OgameException;
    
    abstract public List<GalaxyRow> getGalaxyView(List<Coords> c) throws OgameElementNotFoundException, OgameException;
    
    abstract public List<GalaxyRow> getGalaxySystemView(Coords c) throws OgameElementNotFoundException, OgameException;
    
    abstract public List<GalaxyRow> getGalaxySystemView(List<Coords> c) throws OgameElementNotFoundException, OgameException;
    
    /* ************************************************************************/
    
    /* ************************************************************************
     * ************************* LABORATORIUM *********************************
     * ************************************************************************/
    
    abstract public void research(ResearchingArea s) throws OgameException;

    /**
     * <b>Metoda pobierająca wszytkie poziomy badań na planecie</b>.
     * @return Metoda zwraca obiekt HashMapę (tablicę asocjacyjną) par - rodzaj badania i jego poziom.
     * @throws OgameException 
     */
    abstract public HashMap<ResearchingArea, Integer> getPlanetStudy() throws OgameException;
    
    /* ************************************************************************
     * ************************* STOCZNIA     *********************************
     * ************************************************************************/
    
    abstract public void build(ShipyardShips s, int i) throws OgameException;

    abstract public void build(ShipyardShips s, String count) throws OgameException;
    
    /* ************************************************************************
     * ************************* OBRONA  *********************************
     * ************************************************************************/
    
    abstract public void build(Defence d, int i) throws OgameException;

    abstract public void build(Defence d, String count) throws OgameException;

    /* ************************************************************************
     * ******************************* Floty  *********************************
     * ************************************************************************/
    
    /**
     * Metoda pobierająca ilość statków znadująch się w obecnej chwili w soczni.
     * @return Metoda zwraca obiekt Fleet (tablice asocjacyjną) par - statek i jego ilość.
     * @throws OgameException, Błąd odczytu.
     */
    abstract public Fleet getPlanetFleet() throws OgameException;
    
    /* ************************************************************************
     * ************************* Lista wydarzeń  ******************************
     * ************************************************************************/
    /**
     * Pobiera listę wydarzeń
     * @return Obiekt listy wydarzeń
     * @throws OgameException 
     */
    abstract public List<Events> getEventList() throws OgameException;

   
    
    

    

    abstract public HashMap<Defence, Integer> getPlanetDefence() throws OgameException;

    abstract public void setResourcesSettings(ResourceField r, Production p) throws OgameException;

    abstract public void setResourcesSettings(Performance p) throws OgameException;
    // TODO fill in this methods

    /**
     * Metoda pobierająca poziomy infrastruktury(wszystkich budynków) w surowcach oraz stoczni.
     * @return Metoda zwraca obiekt HashMapę (tablicę asocjacyjną) par - budynek i jego poziom.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public HashMap<BuildingsPlanet, Integer> getPlanetBuildings() throws OgameException;


    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbadania danej technologii na poziom wyżej.
     * @param s Odpowiada za badanie, z którego zostaną pobrane ilości surowców potrzebne do zbadania danej technologii na poziom wyżej. 
     * @return Metoda zwraca obiekt PlanetResources zawierający zapisane zasoby surowców potrzebnych do zbadania danej technologii.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public PlanetResources getCost(ResearchingArea s) throws OgameException;
    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbudowania danego statku.
     * @param s Odpowiada za statek, z którego zostaną pobrane ilości surowców potrzebne do zbudowania go. 
     * @return Metoda zwraca obiekt Resources zawierający zapisane zasoby surowców potrzebnych do zbudowania danego statku.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public PlanetResources getCost(ShipyardShips s) throws OgameException;

    /**
     * Metoda pobierająca ile surowców jest potrzebnych do zbudowania danej jednostki obronnej.
     * @param d Odpowiada za jednostkę obronną, z której zostaną pobrane ilości surowców potrzebne do jej zbudowania. 
     * @return Metoda zwraca obiekt Resources zawierający zapisane zasoby surowców potrzebnych do zbudowania danej jednostki obronnej.
     * @throws OgameException, Błąd Odczytu. 
     */
    abstract public PlanetResources getCost(Defence d) throws OgameException;

    

    abstract public long getProductionTime(ResearchingArea s) throws OgameException;

    abstract public long getProductionTime(ShipyardShips s) throws OgameException;

    abstract public long getProductionTime(Defence d) throws OgameException;



    abstract public List<Slots> getSlots() throws OgameException; // moja :-)

    abstract public void turnBackFlight(Slots f) throws OgameException; //moja :-)


    abstract public Resources getPlanetHourlyProduction() throws OgameException;
}
