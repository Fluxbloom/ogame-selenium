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
    private String metal;
    private String crystal;
    private String deuter;
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
    
    
    public static final Resources NO_RESOURCES = new Resources("0","0","0");
    public static final Resources ALL_RESOURCES = new Resources("-1","-1","-1");
}
