/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine.Exceptions;

/**
 * Specjalna podklasa wyjątków obsługująca nieodnalezione przyciski
 * @author Piotr Kowalski
 */
public class OgameElementNotFoundException extends OgameException{
    /**
     * Konstruktor wyjątku z xpathem do brakującego przycisku
     * @param xpath 
     */
    public OgameElementNotFoundException(String xpath) {
        super("Ogame button not found "+xpath);
    }
    
    
    
}
