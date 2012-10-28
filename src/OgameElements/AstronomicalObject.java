/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * abstrakcyjna klasa łącząca planety i księżyce gracza
 * @author Piotr Kowalski
 */
abstract public class AstronomicalObject {

    public AstronomicalObject(Coords coords, String name) {
        this.coords = coords;
        this.name = name;
    }
    
        public boolean isPlanet(){
            return this.getClass().toString().compareTo(Planet.class.toString())==0;
        }
        
        public boolean isMoon(){
            return this.getClass().toString().compareTo(Moon.class.toString())==0;
        }

    public Coords getCoords() {
        return coords;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AstronomicalObject{" + "coords=" + coords + ", name=" + name + '}';
    }
    
        
        
        protected Coords coords;
        protected String name;
}
