/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author plich
 */
public class Performance {
    private Production[] prod;
    private Performance(Production[] p){this.prod=p;}
    
    public static final Production P10 = new Production("10");
    public static final Production P20 = new Production("20");
    public static final Production P30 = new Production("30");
    public static final Production P40 = new Production("40");
    public static final Production P50 = new Production("50");
    public static final Production P60 = new Production("60");
    public static final Production P70 = new Production("70");
    public static final Production P80 = new Production("80");
    public static final Production P90 = new Production("90");
    public static final Production P100 = new Production("100");
    
    public static final ResourceField METAL = new ResourceField("Metal");
    public static final ResourceField KRYSZTAL = new ResourceField("Krzysztal");
    public static final ResourceField DEUTER = new ResourceField("Deuter");
    public static final ResourceField EL_SLONECZNA = new ResourceField("El_Sloneczna");
    public static final ResourceField EL_FUZYJNA = new ResourceField("El_Fuzyjna");
    public static final ResourceField SAT_SLONECZNA = new ResourceField("Sat_Sloneczna");

    public static class ResourceField{
        String s;
        private ResourceField(String s){this.s=s;}

        @Override
        public String toString() {
            return "ResourceField{" + "s=" + s + '}';
        }
 
    }
    public static class Production{
        String s;
        private Production(String s){this.s=s;}

        @Override
        public String toString() {
            return "Production{" + "s=" + s + '}';
        }
        
    }
}
