/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author plich
 */
public class Performance {
    private Production[] prod;
    public Performance(Production[] p){this.prod=p;}

    public Performance(Production metal, Production krysztal, Production deuter, Production el_sloneczna, Production el_fuzyjna, Production sat_sloneczna) {
        prod=new Production[6];
        prod[0]=metal;
        prod[1]=krysztal;
        prod[2]=deuter;
        prod[3]=el_sloneczna;
        prod[4]=el_fuzyjna;
        prod[5]=sat_sloneczna;
    
    }
    
    public Production getMetal(){
        return prod[0];
    }
    public Production getKrzysztal(){
        return prod[1];
    }
    public Production getDeuter(){
        return prod[2];
    }
    public Production getEl_Sloneczna(){
        return prod[3];
    }
    public Production getEl_Fuzyjna(){
        return prod[4];
    }
    public Production getSat_Sloneczna(){
        return prod[5];
    }
    
    public static final Production P10 = new Production("10%");
    public static final Production P20 = new Production("20%");
    public static final Production P30 = new Production("30%");
    public static final Production P40 = new Production("40%");
    public static final Production P50 = new Production("50%");
    public static final Production P60 = new Production("60%");
    public static final Production P70 = new Production("70%");
    public static final Production P80 = new Production("80%");
    public static final Production P90 = new Production("90%");
    public static final Production P100 = new Production("100%");
    
    public static final ResourceField METAL = new ResourceField("Metal");
    public static final ResourceField KRYSZTAL = new ResourceField("Krzysztal");
    public static final ResourceField DEUTER = new ResourceField("Deuter");
    public static final ResourceField EL_SLONECZNA = new ResourceField("El_Sloneczna");
    public static final ResourceField EL_FUZYJNA = new ResourceField("El_Fuzyjna");
    public static final ResourceField SAT_SLONECZNA = new ResourceField("Sat_Sloneczna");

    public static class ResourceField{
        private String s;
        private ResourceField(String s){this.s=s;}

        @Override
        public String toString() {
            return "ResourceField{" + "s=" + s + '}';
        }
 
    }
    public static class Production{
        private String s;
        private Production(String s){this.s=s;}

        @Override
        public String toString() {
            return "Production{" + "s=" + s + '}';
        }

        public String getS() {
            return s;
        }
        
        
    }
}
