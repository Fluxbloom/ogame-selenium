/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElementsUnchecked;

/**
 *
 * @author dyschemist
 */
public class Resources {
    protected int metal;
    protected int crystal;
    protected int deuterium;
    public Resources(String m, String c, String d){
        metal=Integer.parseInt(m);
        crystal=Integer.parseInt(c);
        deuterium=Integer.parseInt(d);
    }
    public Resources(int metal, int crystal, int deuterium){
        this.metal=metal;
        this.crystal=crystal;
        this.deuterium=deuterium;
    }

    public String getSCrystal() {
        return Integer.toString(crystal);
    }

    public String getSDeuterium() {
        return Integer.toString(deuterium);
    }

    public String getSMetal() {
        return Integer.toString(metal);
    }

    public int getCrystal() {
        return crystal;
    }

    public int getDeuterium() {
        return deuterium;
    }

    public int getMetal() {
        return metal;
    }

    
    
    @Override
    public String toString() {
        return "Resources{" + "metal=" + metal + ", crystal=" + crystal + ", deuter=" + deuterium + '}';
    }
    
    
    
    public static final Resources NO_RESOURCES = new Resources("0","0","0");
    public static final Resources ALL_RESOURCES = new Resources("-1","-1","-1");
}
