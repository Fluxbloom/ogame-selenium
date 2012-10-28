/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa reprezentująca moon gracza
 * @author Piotr Kowalski
 */
public class Moon extends AstronomicalObject{

    public Moon(Coords coords, String name) {
        super(coords, name);
    }

    public Moon(Coords coords){
        super(coords,"");
    }

    @Override
    public String toString() {
        return "Moon{" + "coords=" + coords + ", name=" + name+ '}';
    }
    
    
    
}
