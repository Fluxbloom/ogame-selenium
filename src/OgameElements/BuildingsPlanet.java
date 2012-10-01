/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.logging.Logger;


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
 * @author Rafał Plich & Piotr Kowalski
 */
public class BuildingsPlanet extends Buildings{

    /**
     * Prywatny i jedyny konstruktor 
     * @param name Nazwa dla budynku
     */
    private BuildingsPlanet(String name) {
        super(name);
    }

    /**
     * Statyczny budynek odpowiadający kopalni metalu
     */
    static final BuildingsPlanet METAL_MINE = new BuildingsPlanet("METAL MINE");
    /**
     * Statyczny budynek odpowiadający kopalni kryształu
     */
    static final BuildingsPlanet CRYSTAL_MINE = new BuildingsPlanet("CRISTAL MINE");
    /**
     * Statyczny budynek odpowadający ekstaraktorowi deuteru
     */
     static final BuildingsPlanet DEUTERIUM_EXTRACTOR = new BuildingsPlanet("DEUTERIUM EXTRACTOR");
    /**  
     * Statyczny budynek odpowadający elektrowni słonecznej
     */
     static final BuildingsPlanet SOLAR_POWER_PLANT = new BuildingsPlanet("SOLAR POWER PLANT");
    /**
     * Satyczny budynek odpowiadający elektorwni fuzyjnej
     */
     static final BuildingsPlanet FUSSION_POWER_PLANT = new BuildingsPlanet("FUSSION POWER PLANT");
    /**
     * Statyczny budynek odpowiadający satelicie słonecznej
     */
     static final ShipyardShips SOLAR_SATELLITE = ShipyardShips.SAT;
    /**
     * Statyczny Budynek odpowiadający magazynowi metalu
     */
     static final BuildingsPlanet METAL_STORAGE = new BuildingsPlanet("METAL STORAGE");
    /**
     * Statyczny Budynek odpowiadający magazynowi kryształu
     */
     static final BuildingsPlanet CRYSTAL_STORAGE = new BuildingsPlanet("CRYSTAL STORAGE");
    /**
     * Statyczny Budynek odpowiadający magazynowi deuteru
     */
     static final BuildingsPlanet DEUTERIUM_STORAGE = new BuildingsPlanet("DEUTERIUM STORAGE");
    /**
     * Statyczny Budynek odpowiadający schowkowi metalu
     */
     static final BuildingsPlanet METAL_HIDEOUT = new BuildingsPlanet("METAL HIDEOUT");
    /**
     * Statyczny Budynek odpowiadający schowkowi kryształu
     */
     static final BuildingsPlanet CRYSTAL_HIDEOUT = new BuildingsPlanet("CRYSTAL HIDEOUT");
    /**
     * Statyczny Budynek odpowiadający schowkowi deuteru
     */
     static final BuildingsPlanet DEUTERIUM_HIDEOUT = new BuildingsPlanet("DEUTERIUM HIDEOUT");
    /**
     * Statyczny Budynek odpowiadający fabryce robotów
     */
     static final BuildingsPlanet MANUFACTURE_OF_ROBOTS = new BuildingsPlanet("MANUFACTURE OF ROBOTS");
    /**
     * Statyczny Budynek odpowiadający stoczni
     */
     static final BuildingsPlanet SHIPYARD = new BuildingsPlanet("SHIPYARD");
    /**
     * Statyczny Budynek odpowiadający laboratorium badawczemu
     */
     static final BuildingsPlanet LABORATORY = new BuildingsPlanet("LABORATORY");
    /**
     * Statyczny Budynek odpowiadający depozytowi
     */
     static final BuildingsPlanet DEPOSITE_STATION = new BuildingsPlanet("DEPOSITE STATION");
    /**
     * Statyczny Budynek odpowiadający silosowi rakietowemu
     */
     static final BuildingsPlanet MISSILE_SILO = new BuildingsPlanet("MISSILE SILO");
    /**
     * Statyczny Budynek odpowiadający fabryce nanitów
     */
     static final BuildingsPlanet MANUFACTURE_OF_NANITAS = new BuildingsPlanet("MANUFACTURE OF NANITAS");
    /**
     * Statyczny Budynek odpowiadający terraformerowi
     */
     static final BuildingsPlanet TERRAFORMER = new BuildingsPlanet("TERRAFORMER");


    

    
    private static final Logger logger = Logger.getLogger(BuildingsPlanet.class.getName());
}
