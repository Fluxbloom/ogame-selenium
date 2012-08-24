/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class Resources {
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

    public void setCrystal(String crystal) {
        this.crystal = crystal;
    }

    public void setDeuter(String deuter) {
        this.deuter = deuter;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    @Override
    public String toString() {
        return "Resources{" + "metal=" + metal + ", crystal=" + crystal + ", deuter=" + deuter + '}';
    }
    
    
    
    public static final Resources NO_RESOURCES = new Resources("0","0","0");
    public static final Resources ALL_RESOURCES = new Resources("-1","-1","-1");
}
