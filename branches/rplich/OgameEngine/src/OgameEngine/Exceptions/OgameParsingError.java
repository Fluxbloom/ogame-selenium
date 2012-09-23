/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Klasa błędu parsowania
 * @author Piotr Kowalski
 */
public class OgameParsingError extends OgameException {

    /**
     * Domyślny konstruktor błędu parsowania
     * @param message 
     */
    public OgameParsingError(String message) {
        super(message);
    }

    /**
     * Poprawienie wyświetlania wiadomości o błędzie
     * @return 
     */
    @Override
    public String getMessage() {
        return "Parsing error : "+super.getMessage();
    }
    
    
    
    
    
}
