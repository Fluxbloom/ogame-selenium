/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author plich
 */
public class Technology {
   private String name;
    public static final Technology TECHNOLOGIA_ENERGETYCZNA = new Technology("TECHNOLOGIA_ENERGETYCZNA");
    public static final Technology TECHNOLOGIA_LASEROWA = new Technology("TECHNOLOGIA_LASEROWA");
    public static final Technology TECHNOLOGIA_JONOWA = new Technology("TECHNOLOGIA_JONOWA");
    public static final Technology TECHNOLOGIA_NADPRZESTRZENNA = new Technology("TECHNOLOGIA_NADPRZESTRZENNA");
    public static final Technology TECHNOLOGIA_PLAZMOWA = new Technology("TECHNOLOGIA_PLAZMOWA");
    public static final Technology TECHNOLOGIA_SZPIEGOWSKA = new Technology("TECHNOLOGIA_SZPIEGOWSKA");
    public static final Technology TECHNOLOGIA_KOMPUTEROWA = new Technology("TECHNOLOGIA_KOMPUTEROWA");
    public static final Technology ASTROFIZYKA = new Technology("ASTROFIZYKA");
    public static final Technology SIEC_BADAN = new Technology("SIEC_BADAN");
    public static final Technology ROZWOJ_GRAWITONOW = new Technology("ROZWOJ_GRAWITONOW");
    public static final Technology NAPED_SPALINOWY = new Technology("NAPED_SPALINOWY");
    public static final Technology NAPED_IMPULSOWY = new Technology("NAPED_IMPULSOWY");
    public static final Technology NAPED_NADPRZESTRZENNY = new Technology("NAPED_NADPRZESTRZENNY");
    public static final Technology TECHNOLOGIA_BOJOWA = new Technology("TECHNOLOGIA_BOJOWA");
    public static final Technology TECHNOLOGIA_OCHRONNA = new Technology("TECHNOLOGIA_OCHRONNA");
    public static final Technology OPANCERZENIE = new Technology("OPANCERZENIE");

    private Technology(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Study{" + "name=" + name + '}';
    }

    public String getName() {
        return name;
    }
    
}
