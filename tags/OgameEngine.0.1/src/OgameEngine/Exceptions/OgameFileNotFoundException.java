/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Klasa realizująca błąd braku pliku konfiguracyjnego
 * @author Piotr Kowalski
 */
public class OgameFileNotFoundException extends OgameException{

    /**
     * Konstruktor błędu
     * @param message komunikat błędu
     */
    public OgameFileNotFoundException(String message) {
        super("File not found "+message);
    }
    
}
