/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameElements.Coords;

/**
 * Klasa reprezentuje planety posiadane przez gracza
 * @author Piotr Kowalski
 */
public class Planet extends AstronomicalObject {

    public Planet(Coords coords, String name) {
        super(coords, name);
    }

    public Planet(Coords coords, String name, int id) {
        super(coords, name);
        this.id = new Integer(id);
    }

    public Planet(Coords coords, String name, Moon moon) {
        super(coords, name);
        this.moon = moon;
    }

    public Planet(Coords coords, String name, int id, Moon moon) {
        super(coords, name);
        this.id = new Integer(id);
        this.moon = moon;
    }

    public Integer getId() {
        return id;
    }

    public Moon getMoon() {
        return moon;
    }

    @Override
    public String toString() {
        return "Planet{" + "coords=" + coords + ", name=" + name+ " moon=" + moon + ", id=" + id + '}';
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planet p = (Planet) obj;
        return this.coords.equals(p.coords);
    }
    private Moon moon;
    private Integer id = null;
}
