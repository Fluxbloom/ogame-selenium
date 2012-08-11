/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class Resources implements Comparable {
    protected String metal;
    protected String crystal;
    protected String deuter;
    public Resources(String m, String c, String d){
        metal=m;
        crystal=c;
        deuter=d;
    }

    public String getCrystal() {
        return crystal;
    }

    public String getDeuter() {
        return deuter;
    }

    public String getMetal() {
        return metal;
    }

    @Override
    public String toString() {
        return "Resources{" + "metal=" + metal + ", crystal=" + crystal + ", deuter=" + deuter + '}';
    }
    
    @Override
    public int compareTo(Object o) {
        if (this.metal.compareTo( ( (Resources) o).metal) != 0) {
       return this.metal.compareTo( ( (Resources) o).metal);
                                                                       }
        if (this.crystal.compareTo( ( (Resources) o).crystal) != 0) {
        return this.crystal.compareTo( ( (Resources) o).crystal);
                                                                           }
        if (this.deuter.compareTo( ( (Resources) o).deuter) != 0) {
        return this.deuter.compareTo( ( (Resources) o).deuter);
                                                                         }
         
        return 0;
    }
    
    
    public static final Resources NO_RESOURCES = new Resources("0","0","0");
    public static final Resources ALL_RESOURCES = new Resources("-1","-1","-1");
}
