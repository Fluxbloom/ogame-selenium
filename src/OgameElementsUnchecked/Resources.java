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

    public Resources(String m, String c, String d) {
        metal = Integer.parseInt(m);
        crystal = Integer.parseInt(c);
        deuterium = Integer.parseInt(d);
    }

    public Resources(int metal, int crystal, int deuterium) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
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

    public void add(ResourceTypes type, int value) {
        if (type == METAL) {
            this.metal += value;
            this.metal = this.metal>0?this.metal:0;
        } else if (type == CRYSTAL) {
            this.crystal += value;
            this.crystal = this.crystal>0?this.crystal:0;
        } else if (type == DEUTERIUM) {
            this.deuterium+= value;
            this.deuterium = this.deuterium>0?this.deuterium:0;
        }

    }

    public void subtract(ResourceTypes type, int value) {
        if (type == METAL) {
            this.metal -= value;
            this.metal = this.metal>0?this.metal:0;
        } else if (type == CRYSTAL) {
            this.crystal -= value;
            this.crystal = this.crystal>0?this.crystal:0;
        } else if (type == DEUTERIUM) {
            this.deuterium-= value;
            this.deuterium = this.deuterium>0?this.deuterium:0;
        }
    }

    @Override
    public String toString() {
        return "Resources{" + "metal=" + (metal<0?"All":metal) + ", crystal=" + (crystal<0?"All":crystal) 
                + ", deuterium=" + (deuterium<0?"All":deuterium) + '}';
    }
    public static final Resources NO_RESOURCES = new Resources("0", "0", "0");
    public static final Resources ALL_RESOURCES = new Resources("-1", "-1", "-1");
    public static final ResourceTypes METAL = ResourceTypes.METAL;
    public static final ResourceTypes CRYSTAL = ResourceTypes.CRYSTAL;
    public static final ResourceTypes DEUTERIUM = ResourceTypes.DEUTERIUM;
    public static final PlanetResourceTypes ENERGY = PlanetResourceTypes.ENERGY;
}
