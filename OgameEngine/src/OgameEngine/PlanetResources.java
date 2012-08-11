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

    public boolean isSufficient(PlanetResources needed){
        if (Integer.parseInt(metal)<Integer.parseInt(needed.metal)) return false;
        if (Integer.parseInt(crystal)<Integer.parseInt(needed.crystal)) return false;
        if (Integer.parseInt(deuter)<Integer.parseInt(needed.deuter)) return false;
        if (Integer.parseInt(needed.energy)>0 && Integer.parseInt(energy)<Integer.parseInt(needed.energy)) return false;
        return true;
    }
   
   
}

