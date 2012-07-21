/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class Speed {
    private String s;
    private Speed(String s){this.s=s;}
    
    public static final Speed S10 = new Speed("10");
    public static final Speed S20 = new Speed("20");
    public static final Speed S30 = new Speed("30");
    public static final Speed S40 = new Speed("40");
    public static final Speed S50 = new Speed("50");
    public static final Speed S60 = new Speed("60");
    public static final Speed S70 = new Speed("70");
    public static final Speed S80 = new Speed("80");
    public static final Speed S90 = new Speed("90");
    public static final Speed S100 =new Speed("100");

    public String getS() {
        return s;
    }
    
}
