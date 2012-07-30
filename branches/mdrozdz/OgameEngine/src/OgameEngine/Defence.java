/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author plich
 */
public class Defence {
    private String name;
    public static final Defence WYRZUTNIA_RAKIET = new Defence("WYRZUTNIA_RAKIET");
    public static final Defence MALY_LASER = new Defence("MALY_LASER");
    public static final Defence DUZY_LASER = new Defence("DUZY_LASER");
    public static final Defence DZIALO_GAUSSA = new Defence("DZIALO_GAUSSA");
    public static final Defence DZIALO_JONOWE = new Defence("DZIALO_JONOWE");
    public static final Defence WYRZUTNIA_PLAZMY = new Defence("WYRZUTNIA_PLAZMY");
    public static final Defence MALA_POWLOKA = new Defence("MALA_POWLOKA");
    public static final Defence DUZA_POWLOKA = new Defence("DUZA_POWLOKA");
    public static final Defence PRZECIWRAKIETA = new Defence("PRZECIWRAKIETA");
    public static final Defence RAKITA_MIEDZYPLANETARNA = new Defence("RAKITA_MIEDZYPLANETARNA");

    private Defence(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Defence{" + "name=" + name + '}';
    }
    
    
    
}
