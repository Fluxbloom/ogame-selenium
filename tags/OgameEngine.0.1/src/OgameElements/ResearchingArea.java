/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author plich
 */
public class ResearchingArea {
   private String name;
    public static final ResearchingArea TECHNOLOGIA_ENERGETYCZNA = new ResearchingArea("TECHNOLOGIA_ENERGETYCZNA");
    public static final ResearchingArea TECHNOLOGIA_LASEROWA = new ResearchingArea("TECHNOLOGIA_LASEROWA");
    public static final ResearchingArea TECHNOLOGIA_JONOWA = new ResearchingArea("TECHNOLOGIA_JONOWA");
    public static final ResearchingArea TECHNOLOGIA_NADPRZESTRZENNA = new ResearchingArea("TECHNOLOGIA_NADPRZESTRZENNA");
    public static final ResearchingArea TECHNOLOGIA_PLAZMOWA = new ResearchingArea("TECHNOLOGIA_PLAZMOWA");
    public static final ResearchingArea TECHNOLOGIA_SZPIEGOWSKA = new ResearchingArea("TECHNOLOGIA_SZPIEGOWSKA");
    public static final ResearchingArea TECHNOLOGIA_KOMPUTEROWA = new ResearchingArea("TECHNOLOGIA_KOMPUTEROWA");
    public static final ResearchingArea ASTROFIZYKA = new ResearchingArea("ASTROFIZYKA");
    public static final ResearchingArea SIEC_BADAN = new ResearchingArea("SIEC_BADAN");
    public static final ResearchingArea ROZWOJ_GRAWITONOW = new ResearchingArea("ROZWOJ_GRAWITONOW");
    public static final ResearchingArea NAPED_SPALINOWY = new ResearchingArea("NAPED_SPALINOWY");
    public static final ResearchingArea NAPED_IMPULSOWY = new ResearchingArea("NAPED_IMPULSOWY");
    public static final ResearchingArea NAPED_NADPRZESTRZENNY = new ResearchingArea("NAPED_NADPRZESTRZENNY");
    public static final ResearchingArea TECHNOLOGIA_BOJOWA = new ResearchingArea("TECHNOLOGIA_BOJOWA");
    public static final ResearchingArea TECHNOLOGIA_OCHRONNA = new ResearchingArea("TECHNOLOGIA_OCHRONNA");
    public static final ResearchingArea OPANCERZENIE = new ResearchingArea("OPANCERZENIE");

    private ResearchingArea(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Study{" + "name=" + name + '}';
    }
    
}
