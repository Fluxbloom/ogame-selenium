/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

/**
 *
 * @author dyschemist
 */
public class OgameException extends Exception {
    
    public OgameException(String message){
        super(message);
    }
    /* NOWE */
    public final static OgameException SELENIUM_SERVER_IS_DOWN = new OgameException("Selenium server is down");
    
    public final static OgameException UNSUPPORTED_MISSION = new OgameException("This action is unsupported");
    public final static OgameException MISSION_UNAVAILABLE_FOR_FLEET =new OgameException("THE FOLLOWING FLEET CANNOT BE ASSIGNED TO THIS TYPE OF MISSIONS");
    public final static OgameException PARSING_ERROR = new OgameException("Parsing error");
    public final static OgameException UNOWNED_PLANET = new OgameException("Cannot perform station to unowned planet");
    public final static OgameException WRONG_ACS_CODE = new OgameException("Wrong acs code");
    public final static OgameException TIMEOUT= new OgameException("Timeout");
    /*stare exceptiony*/
    
    public final static OgameException UNSUPPORTED = new OgameException("Method not supported");
    
    
    public final static OgameException LOGIN_NO_INTERNET_CONNECTION = new OgameException("No connection to internet");
    public final static OgameException LOGIN_PAGE_OFFLINE = new OgameException("The web server is offline");
    public final static OgameException LOGIN_WRONG_PASSWORD = new OgameException("Incorrect login or password");
    public final static OgameException LOGIN_BROWSER_CLOSED = new OgameException("Browser was closed");
    
}
