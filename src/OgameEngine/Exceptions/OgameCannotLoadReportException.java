/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Błąd odczytu raportu z dysku
 * @author Piotr Kowalski
 */
public class OgameCannotLoadReportException extends OgameException{

    public OgameCannotLoadReportException(String message) {
        super(message);
    }
    
}
