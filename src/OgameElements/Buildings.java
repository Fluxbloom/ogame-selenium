/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Jest to klasa wszystkich budynkow, mozliwych do zbudowania na planecie, dostepnych w ogame.
 * Klasa nie pozwala na tworzenie nowych budynków i można wykorzystać jedynie te utworzone w klasie.
 * Lista dostępnych budynków:
 * <ul>
 * <li>Kopalnia metalu</li>
 * <li>Kopalnia kryształu</li>
 * <li>Ekstraktor deuteru</li>
 * <li>Elektrownia słoneczna</li>
 * <li>Elektrownia fuzyjna</li>
 * <li>Satelita słoneczna</li>
 * <li>Magazyn metalu</li>
 * <li>Magazyn kryształu</li>
 * <li>Magazyn deuteru</li>
 * <li>Schowek metalu</li>
 * <li>Schowek kryształu</li>
 * <li>Schowek deuteru</li>
 * <li>Fabryka robotów</li>
 * <li>Stocznia</li>
 * <li>Laboratorium badawcze</li>
 * <li>Depozyt sojuszniczy</li>
 * <li>Silos rakietowy</li>
 * <li>Fabryka nanitów</li>
 * <li>Terraformer</li>
 * </ul>
 * @author Rafał Plich mailto:plich@wp.eu
 */
public class Buildings {
    /**
     * Pole zawiera nazwę budynku
     */
    private String name;

    /**
     * Zwraca nazwę budynku
     *
     * @return Nazwa tego budynku
     */
    public String getName() {
        return name;
    }
    /**
     * Prywatny i jedyny konstruktor 
     * @param name Nazwa dla budynku
     */
    private Buildings(String name) {this.name=name;}
    /**
     * Statyczny budynek odpowiadający kopalni metalu
     */
    public static final Buildings METAL_MINE = new Buildings("METAL MINE");
    /**
     * Statyczny budynek odpowiadający kopalni kryształu
     */
    public static final Buildings CRYSTAL_MINE = new Buildings("CRISTAL MINE");
    /**
     * Statyczny budynek odpowadający ekstaraktorowi deuteru
     */
    public static final Buildings EKSTRAKTOR_DEUTERU = new Buildings("DEUTERIUM EXTRACTOR");
    /**  
     * Statyczny budynek odpowadający elektrowni słonecznej
     */
    public static final Buildings ELEKTROWNIA_SLONECZNA = new Buildings("SOLAR POWER PLANT");
    /**
     * Satyczny budynek odpowiadający elektorwni fuzyjnej
     */
    public static final Buildings ELEKTROWNIA_FUZYJNA = new Buildings("FUSSION POWER PLANT");
    /**
     * Statyczny budynek odpowiadający satelicie słonecznej
     */
    public static final Buildings SOLAR_SATELLITE = new Buildings("SOLAR SATELLITE");
    /**
     * Statyczny Budynek odpowiadający magazynowi metalu
     */
    public static final Buildings METAL_STORAGE = new Buildings("METAL STORAGE");
    /**
     * Statyczny Budynek odpowiadający magazynowi kryształu
     */
    public static final Buildings CRYSTAL_STORAGE = new Buildings("CRYSTAL STORAGE");
    /**
     * Statyczny Budynek odpowiadający magazynowi deuteru
     */
    public static final Buildings DEUTERIUM_STORAGE = new Buildings("DEUTERIUM STORAGE");
    /**
     * Statyczny Budynek odpowiadający schowkowi metalu
     */
    public static final Buildings METAL_HIDEOUT = new Buildings("METAL HIDEOUT");
    /**
     * Statyczny Budynek odpowiadający schowkowi kryształu
     */
    public static final Buildings CRYSTAL_HIDEOUT = new Buildings("CRYSTAL HIDEOUT");
    /**
     * Statyczny Budynek odpowiadający schowkowi deuteru
     */
    public static final Buildings DEUTERIUM_HIDEOUT = new Buildings("DEUTERIUM HIDEOUT");
    /**
     * Statyczny Budynek odpowiadający fabryce robotów
     */
    public static final Buildings MANUFACTURE_OF_ROBOTS = new Buildings("MANUFACTURE OF ROBOTS");
    /**
     * Statyczny Budynek odpowiadający stoczni
     */
    public static final Buildings SHIPYARD = new Buildings("SHIPYARD");
    /**
     * Statyczny Budynek odpowiadający laboratorium badawczemu
     */
    public static final Buildings LABORATORY = new Buildings("LABORATORY");
    /**
     * Statyczny Budynek odpowiadający depozytowi
     */
    public static final Buildings DEPOSITE_STATION = new Buildings("DEPOSITE STATION");
    /**
     * Statyczny Budynek odpowiadający silosowi rakietowemu
     */
    public static final Buildings MISSILE_SILO = new Buildings("MISSILE SILO");
    /**
     * Statyczny Budynek odpowiadający fabryce nanitów
     */
    public static final Buildings MANUFACTURE_OF_NANITAS = new Buildings("MANUFACTURE OF NANITAS");
    /**
     * Statyczny Budynek odpowiadający terraformerowi
     */
    public static final Buildings TERRAFORMER = new Buildings("TERRAFORMER");

    /**
     * wypisuje nazwe danego budynku
     * @return sformatowany string opisujący dany budynek
     */
    @Override
    public String toString() {
        return "Buildings{" + "name=" + name + '}';
    }
    
}
