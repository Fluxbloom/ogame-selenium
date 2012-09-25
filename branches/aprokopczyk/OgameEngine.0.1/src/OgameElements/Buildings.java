/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa gromadząca budynki na planecie i księżycu
 * @author Piotr Kowalski
 */
abstract public class Buildings {
    /**
     * Konstruktor dla klas dziedziczących
     * @param name nazwa budynku
     */
    protected Buildings(String name){
        this.name = name;
    }
    
    /**
     * Zwraca nazwę budynku
     *
     * @return Nazwa tego budynku
     */
    public String getName() {
        return name;
    }

    /**
     * Sprawdza czy budynek jest księżycowy
     * @return 
     */
    public boolean isMoonBuilding(){
        if (this.getClass().getName().compareTo(BuildingsMoon.class.getName())==0){
            return true;
        } else
            return false;
    }
    
    /**
     * Sprawdza czy budynek jest budynkiem zasobów
     * @return 
     */
    public boolean isResourceBuilding(){
         if (this == Buildings.CRYSTAL_HIDEOUT || this == Buildings.CRYSTAL_MINE || this == Buildings.CRYSTAL_STORAGE ||
             this == Buildings.DEUTERIUM_EXTRACTOR|| this == Buildings.DEUTERIUM_HIDEOUT|| this == Buildings.DEUTERIUM_STORAGE || 
             this == Buildings.METAL_HIDEOUT|| this == Buildings.METAL_MINE|| this == Buildings.METAL_STORAGE ||
             this == Buildings.FUSSION_POWER_PLANT|| this == Buildings.SOLAR_POWER_PLANT   ) {
             return true;
         }
         else return false;
            
    }
    /**
     * Sprawdza czy budynek jest budynkiem stacji
     * @return 
     */
    public boolean isStationBuilding(){
         if (this == Buildings.MANUFACTURE_OF_ROBOTS || this == Buildings.SHIPYARD || 
             this == Buildings.LABORATORY || this == Buildings.DEPOSITE_STATION || 
             this == Buildings.MISSILE_SILO || this == Buildings.MANUFACTURE_OF_NANITAS || 
             this == Buildings.TERRAFORMER) {
             return true;
         }
         else return false;
            
    }
    
    /**
     * wypisuje nazwe danego budynku
     * @return sformatowany string opisujący dany budynek
     */
    @Override
    public String toString() {
        return "Buildings{" + "name=" + name + '}';
    }
    
     /**
     * Statyczny budynek odpowiadający kopalni metalu
     */
    public static final BuildingsPlanet METAL_MINE = BuildingsPlanet.METAL_MINE;
    /**
     * Statyczny budynek odpowiadający kopalni kryształu
     */
    public static final BuildingsPlanet CRYSTAL_MINE =BuildingsPlanet.CRYSTAL_MINE;
    /**
     * Statyczny budynek odpowadający ekstaraktorowi deuteru
     */
    public static final BuildingsPlanet DEUTERIUM_EXTRACTOR = BuildingsPlanet.DEUTERIUM_EXTRACTOR;
    /**  
     * Statyczny budynek odpowadający elektrowni słonecznej
     */
    public static final BuildingsPlanet SOLAR_POWER_PLANT = BuildingsPlanet.SOLAR_POWER_PLANT;
    /**
     * Satyczny budynek odpowiadający elektorwni fuzyjnej
     */
    public static final BuildingsPlanet FUSSION_POWER_PLANT = BuildingsPlanet.FUSSION_POWER_PLANT;
    /**
     * Statyczny budynek odpowiadający satelicie słonecznej //szybki fix, budujemy satelitę w stoczni
     */
    public static final ShipyardShips SOLAR_SATELLITE = BuildingsPlanet.SOLAR_SATELLITE;
    /**
     * Statyczny Budynek odpowiadający magazynowi metalu
     */
    public static final BuildingsPlanet METAL_STORAGE = BuildingsPlanet.METAL_STORAGE;
    /**
     * Statyczny Budynek odpowiadający magazynowi kryształu
     */
    public static final BuildingsPlanet CRYSTAL_STORAGE = BuildingsPlanet.CRYSTAL_STORAGE;
    /**
     * Statyczny Budynek odpowiadający magazynowi deuteru
     */
    public static final BuildingsPlanet DEUTERIUM_STORAGE = BuildingsPlanet.DEUTERIUM_STORAGE;
    /**
     * Statyczny Budynek odpowiadający schowkowi metalu
     */
    public static final BuildingsPlanet METAL_HIDEOUT = BuildingsPlanet.METAL_HIDEOUT;
    /**
     * Statyczny Budynek odpowiadający schowkowi kryształu
     */
    public static final BuildingsPlanet CRYSTAL_HIDEOUT = BuildingsPlanet.CRYSTAL_HIDEOUT;
    /**
     * Statyczny Budynek odpowiadający schowkowi deuteru
     */
    public static final BuildingsPlanet DEUTERIUM_HIDEOUT = BuildingsPlanet.DEUTERIUM_HIDEOUT;
    /**
     * Statyczny Budynek odpowiadający fabryce robotów
     */
    public static final BuildingsPlanet MANUFACTURE_OF_ROBOTS = BuildingsPlanet.MANUFACTURE_OF_ROBOTS;
    /**
     * Statyczny Budynek odpowiadający stoczni
     */
    public static final BuildingsPlanet SHIPYARD = BuildingsPlanet.SHIPYARD;
    /**
     * Statyczny Budynek odpowiadający laboratorium badawczemu
     */
    public static final BuildingsPlanet LABORATORY = BuildingsPlanet.LABORATORY;
    /**
     * Statyczny Budynek odpowiadający depozytowi
     */
    public static final BuildingsPlanet DEPOSITE_STATION = BuildingsPlanet.DEPOSITE_STATION;
    /**
     * Statyczny Budynek odpowiadający silosowi rakietowemu
     */
    public static final BuildingsPlanet MISSILE_SILO = BuildingsPlanet.MISSILE_SILO;
    /**
     * Statyczny Budynek odpowiadający fabryce nanitów
     */
    public static final BuildingsPlanet MANUFACTURE_OF_NANITAS = BuildingsPlanet.MANUFACTURE_OF_NANITAS;
    /**
     * Statyczny Budynek odpowiadający terraformerowi
     */
    public static final BuildingsPlanet TERRAFORMER = BuildingsPlanet.TERRAFORMER;
    
        /**
     * Budynek stacji księżycowej
     */
    public static final BuildingsMoon MOON_STATION = BuildingsMoon.MOON_STATION;
    /**
     * Budynek falangi ksieżycowej
     */
    public static final BuildingsMoon MOON_FALANG= BuildingsMoon.MOON_FALANG;
    /**
     * Budynek teleportera
     */
    public static final BuildingsMoon MOON_TELEPORTER = BuildingsMoon.MOON_TELEPORTER;
    
    private String name;
}
