/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

import java.io.IOException;

/**
 * Klasa opisująca wyjątki braku dostępu do pliku
 * @author Piotr Kowalski
 */
public class OgameIOException extends OgameException{
    /**
     * Konstruktor błędu w oparciu o błąd 
     * @param exception błąd IO
     */
    public OgameIOException(IOException exception) {
        super("Couldn't read the file "+exception.getMessage());
        this.exception = exception;
    }
    /**
     * Nadpisanie metody wypisującej wyjątek 
     * @return 
     */
    @Override
    public String getMessage() {
        return super.getMessage()+" IO Error"+this.exception.getMessage();
    }
    
    private IOException exception;
    
}
