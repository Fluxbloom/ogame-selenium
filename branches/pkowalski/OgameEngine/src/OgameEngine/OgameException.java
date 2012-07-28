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
}
