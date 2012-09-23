/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElementsUnchecked;

/**
 *
 * @author plich
 */
public class Defence {
    private String name;
    private Defence(String name){this.name=name;};
    public static final Defence WYRZUTNIA_RAKIET = new Defence("WR");
    public static final Defence MALY_LASER = new Defence("LL");
    public static final Defence DUZY_LASER = new Defence("CL");
    public static final Defence DZIALO_GAUSSA = new Defence("DG");
    public static final Defence DZIALO_JONOWE = new Defence("DJ");
    public static final Defence WYRZUTNIA_PLAZMY = new Defence("PLASMA");
    public static final Defence MALA_POWLOKA = new Defence("MP");
    public static final Defence DUZA_POWLOKA = new Defence("DP");
    public static final Defence PRZECIWRAKIETA = new Defence("COUNTER_MISSILE");
    public static final Defence RAKITA_MIEDZYPLANETARNA = new Defence("MISSILE");

    @Override
    public String toString() {
        return "Defence{" + "name=" + name + '}';
    }
    
}
