/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Błąd zapisu raportu na dysku
 * @author Piotr Kowalski
 */
public class OgameCannotSaveReportException extends OgameException{

    public OgameCannotSaveReportException(String message) {
        super(message);
    }
    
}
