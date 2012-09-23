/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Klasa zbierająca najpowszechniejsze, obsługiwane i nie, wyjatki
 * @author Piotr Kowalski
 */
public class OgameException extends Exception {

    public OgameException(String message) {
        super(message);
    }
    /* NOWE */
    /**
     * Błąd wyłączonego serwera selenium
     */
    public final static OgameException SELENIUM_SERVER_IS_DOWN = new OgameException("Selenium server is down");
    // overview
    public final static OgameException PLANET_PARSING_ERROR = new OgameException("Planet parsing error");
    // buildings
    // lab
    // shipyard
    // defence
    // fleet
    /**
     * Brak floty na planecie
     */
    public final static OgameCannotSendFleetException FLEET_NO_FLEET_ON_PLANET = new OgameCannotSendFleetException("There is no fleet on this planet");
    /**
     * Misja nie jest jeszcze wspierana
     */
    public final static OgameCannotSendFleetException FLEET_UNSUPPORTED_MISSION = new OgameCannotSendFleetException("This action is unsupported");
    /**
     * Ta flota nie może pełnić tej misji
     */
    public final static OgameCannotSendFleetException FLEET_MISSION_UNAVAILABLE_FOR_FLEET = new OgameCannotSendFleetException("THE FOLLOWING FLEET CANNOT BE ASSIGNED TO THIS TYPE OF MISSIONS");
    /**
     * Nie można stacjonować na cudzej planecie
     */
    public final static OgameCannotSendFleetException FLEET_UNOWNED_PLANET_CANNOT_STATION = new OgameCannotSendFleetException("Cannot perform station to unowned planet");
    /**
     * Nieistniejący kod ACS
     */
    public final static OgameCannotSendFleetException FLEET_WRONG_ACS_CODE = new OgameCannotSendFleetException("Wrong acs code");
    // other 
    /**
     * Czas na załadowanie strony minął
     */
    public final static OgameException TIMEOUT = new OgameException("Timeout");
    /**
     * Błąd parsowania kordynatów
     */
    public final static OgameException COORDS_PARSING_ERROR = new OgameException("Coords parsing error");
    /*stare exceptiony*/
    /**
     * Niewspierana funkcja
     * @deprecated 
     */
    public final static OgameException UNSUPPORTED = new OgameException("Method not supported");
    /**
     * @deprecated
     */
    public final static OgameException LOGIN_NO_INTERNET_CONNECTION = new OgameException("No connection to internet");
    /**
     * @deprecated 
     */
    public final static OgameException LOGIN_PAGE_OFFLINE = new OgameException("The web server is offline");
    /**
     * @deprecated 
     */
    public final static OgameException LOGIN_WRONG_PASSWORD = new OgameException("Incorrect login or password");
    /**
     * @deprecated 
     */
    public final static OgameException LOGIN_BROWSER_CLOSED = new OgameException("Browser was closed");
}
