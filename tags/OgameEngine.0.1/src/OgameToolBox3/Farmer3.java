/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox3;

import OgameElements.AstronomicalObject;
import OgameElements.Fleet;
import OgameElements.Planet;
import OgameElements.Ships;
import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.Exceptions.OgameParsingException;
import OgameEngine.Ogame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa tworząca obiekt farmiący 
 * @author Piotr Kowalski
 */
public class Farmer3 {

    public Farmer3(Ogame o,int range, Fleet scanning, Fleet fs, Fleet defaultFarming) {
        this.engine = o;
        this.range = range;
        this.scanning = scanning;
        this.fs = fs;
        this.defaultFarming = defaultFarming;
    }

    private static final Fleet defaultFarmingFleet = new Fleet(), scanningDefault = new Fleet();
    
    static {
        defaultFarmingFleet.add(Ships.MT, 5);
        scanningDefault.add(Ships.SOND, 3);
    }
    
    public Farmer3(Ogame o,int range, Fleet fs) {
        this.engine = o;
        this.range = range;
        this.fs = fs;
    }
    
    
    public void initPlanets() throws OgameElementNotFoundException, OgameFileNotFoundException, OgameIOException, OgameParsingException{
        List<AstronomicalObject> planetsAndMoons;
        try {
             planetsAndMoons= engine.getPlanetList();
        } catch (OgameException ex) {
             planetsAndMoons = engine.getPlanetList();
        }
        this.planets = new ArrayList<PlanetElement3>();
        Iterator<AstronomicalObject> iter = planetsAndMoons.iterator();
        AstronomicalObject temp;
        while(iter.hasNext()){
            temp = iter.next();
            if (!temp.isPlanet()) continue;
            this.planets.add(new PlanetElement3(engine,(Planet) temp,1,this.range,saveDir));
        }
    }
    
    /**
     * zasięg planet danego obiektu farmiącego
     */
    private int range; 
    private Fleet scanning;
    private Fleet fs;
    private Fleet defaultFarming;
    private Ogame engine;
    
    private List<PlanetElement3> planets;
    
    private static final String saveDir = System.getProperty("user.dir")+"/saves/farmer/reports/";
}
