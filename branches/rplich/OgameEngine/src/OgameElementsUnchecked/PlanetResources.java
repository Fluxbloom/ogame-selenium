/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElementsUnchecked;

/**
 *
 * @author soncrash
 */
public class PlanetResources extends Resources {
   
    private int energy;
   
    public PlanetResources (int metal, int cristal, int deuter, int energy){
        super(metal,cristal,deuter);
        this.energy=energy;
    }

    public PlanetResources(String metal, String cristal, String deuter, String energy){
        this(Integer.parseInt(metal),Integer.parseInt(cristal),Integer.parseInt(deuter),Integer.parseInt(energy));
    }
    
    public int getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "PlanetResources{" + "metal=" + metal + ", crystal=" + crystal + ", deuter=" + deuterium +", energy=" + energy + '}';
    }

    public boolean isSufficient(PlanetResources needed){
        if (metal<needed.metal) return false;
        if (crystal<needed.crystal) return false;
        if (deuterium<needed.deuterium) return false;
        if (needed.energy>0 && energy<needed.energy) return false;
        return true;
    }
   
   
}

