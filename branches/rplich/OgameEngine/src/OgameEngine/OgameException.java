/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class OgameException extends Exception {
    
    public OgameException(String message){
        super(message);
    }
    
    public final static OgameException UNSUPPORTED_MISSION = new OgameException("UNSUPPORTED MISSION");
    public final static OgameException UNSUPPORTED = new OgameException("Method not supported");
    
    public final static OgameException LOGIN_NO_INTERNET_CONNECTION = new OgameException("No connection to internet");
    public final static OgameException LOGIN_PAGE_OFFLINE = new OgameException("The web server is offline");
    public final static OgameException LOGIN_WRONG_PASSWORD = new OgameException("Incorrect login or password");
    public final static OgameException LOGIN_BROWSER_CLOSED = new OgameException("Browser was closed");
    
}
