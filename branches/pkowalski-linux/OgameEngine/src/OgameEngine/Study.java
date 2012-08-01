/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author plich
 */
public class Study {
   private String name;
    public static final Study TECHNOLOGIA_ENERGETYCZNA = new Study("TECHNOLOGIA_ENERGETYCZNA");
    public static final Study TECHNOLOGIA_LASEROWA = new Study("TECHNOLOGIA_LASEROWA");
    public static final Study TECHNOLOGIA_JONOWA = new Study("TECHNOLOGIA_JONOWA");
    public static final Study TECHNOLOGIA_NADPRZESTRZENNA = new Study("TECHNOLOGIA_NADPRZESTRZENNA");
    public static final Study TECHNOLOGIA_PLAZMOWA = new Study("TECHNOLOGIA_PLAZMOWA");
    public static final Study TECHNOLOGIA_SZPIEGOWSKA = new Study("TECHNOLOGIA_SZPIEGOWSKA");
    public static final Study TECHNOLOGIA_KOMPUTEROWA = new Study("TECHNOLOGIA_KOMPUTEROWA");
    public static final Study ASTROFIZYKA = new Study("ASTROFIZYKA");
    public static final Study SIEC_BADAN = new Study("SIEC_BADAN");
    public static final Study ROZWOJ_GRAWITONOW = new Study("ROZWOJ_GRAWITONOW");
    public static final Study NAPED_SPALINOWY = new Study("NAPED_SPALINOWY");
    public static final Study NAPED_IMPULSOWY = new Study("NAPED_IMPULSOWY");
    public static final Study NAPED_NADPRZESTRZENNY = new Study("NAPED_NADPRZESTRZENNY");
    public static final Study TECHNOLOGIA_BOJOWA = new Study("TECHNOLOGIA_BOJOWA");
    public static final Study TECHNOLOGIA_OCHRONNA = new Study("TECHNOLOGIA_OCHRONNA");
    public static final Study OPANCERZENIE = new Study("OPANCERZENIE");

    private Study(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Study{" + "name=" + name + '}';
    }
    
}
