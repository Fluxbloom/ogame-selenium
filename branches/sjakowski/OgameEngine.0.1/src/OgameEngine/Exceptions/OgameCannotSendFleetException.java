/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Klasa błędów wysyłania flot
 * @author Piotr Kowalski
 */
public class OgameCannotSendFleetException extends OgameException{
    /**
     * Domyślny konstruktor z tekstem błędu
     * @param message 
     */
    public OgameCannotSendFleetException(String message) {
        super(message);
    }
    
    
    
}
