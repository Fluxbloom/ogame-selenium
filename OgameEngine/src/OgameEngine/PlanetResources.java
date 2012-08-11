/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author soncrash
 */
public class PlanetResources extends Resources {
    
    private String energy;
    
    public PlanetResources (String metal, String cristal, String deuter, String energy){
        super(metal,cristal,deuter);
        this.energy=energy;
    }

    public String getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "PlanetResources{" + "metal=" + metal + ", crystal=" + crystal + ", deuter=" + deuter +", energy=" + energy + '}';
    }

    
    
    
}
