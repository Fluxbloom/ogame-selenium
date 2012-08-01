/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author plich
 */
public class Buildings {

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    private Buildings(String name) {this.name=name;}
    public static final Buildings KOPALNIA_METALU = new Buildings("METAL MINE");
    public static final Buildings KOPALNIA_KRYSZTALU = new Buildings("CRISTAL MINE");
    public static final Buildings EKSTRAKTOR_DEUTERU = new Buildings("DEUTERIUM EXTRACTOR");
    public static final Buildings ELEKTROWNIA_SLONECZNA = new Buildings("SOLAR POWER PLANT");
    public static final Buildings ELEKTROWNIA_FUZYJNA = new Buildings("FUSSION POWER PLANT");
    public static final Buildings SATELITA_SLONECZNA = new Buildings("SOLAR SATELLITE");
    public static final Buildings MAGAZYN_METALU = new Buildings("METAL STORAGE");
    public static final Buildings MAGAZYN_KRYSZTALU = new Buildings("CRYSTAL STORAGE");
    public static final Buildings MAGAZYN_DEUTERU = new Buildings("DEUTERIUM STORAGE");
    public static final Buildings SCHOWEK_METALU = new Buildings("METAL HIDEOUT");
    public static final Buildings SCHOWEK_KRYSZTALU = new Buildings("CRYSTAL HIDEOUT");
    public static final Buildings SCHOWEK_DEUTERU = new Buildings("DEUTERIUM HIDEOUT");
    public static final Buildings FABRYKA_ROBOTOW = new Buildings("MANUFACTURE OF ROBOTS");
    public static final Buildings STOCZNIA = new Buildings("SHIPYARD");
    public static final Buildings LABORATORIUM_BADAWCZE = new Buildings("LABORATORY");
    public static final Buildings DEPOZYT = new Buildings("DEPOSITE STATION");
    public static final Buildings SILOS_RAKIETOWY = new Buildings("MISSILE SILO");
    public static final Buildings FABRYKA_NANITOW = new Buildings("MANUFACTURE OF NANITAS");
    public static final Buildings TERRAFORMER = new Buildings("TERRAFORMER");

    @Override
    public String toString() {
        return "Buildings{" + "name=" + name + '}';
    }
    
}
