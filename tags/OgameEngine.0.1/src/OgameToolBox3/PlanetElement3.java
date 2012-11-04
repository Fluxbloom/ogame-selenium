/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox3;

import OgameElements.AstronomicalObject;
import OgameElements.Coords;
import OgameElements.Fleet;
import OgameElements.GalaxyRow;
import OgameElements.Mission;
import OgameElements.Planet;
import OgameElements.Report;
import OgameElements.TimePeriod;
import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.Ogame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa otoczki planety
 * @author Piotr Kowalski
 */
public class PlanetElement3 {

    public PlanetElement3(Ogame o, Planet planet, int startCount, int range, String savePath) {
        this.engine = o;
        this.planet = planet;
        this.startCount = startCount;
        coords = new ArrayList<CoordsElement3>();
        this.range = range;
        this.savePath = savePath;
    }
    
    private List<GalaxyRow> getAllIdlers() throws OgameFileNotFoundException, OgameIOException, OgameElementNotFoundException, OgameException{
        List<GalaxyRow> all, idlers = new ArrayList<GalaxyRow>();
        Iterator<GalaxyRow> ite;
        AstronomicalObject temp;
        GalaxyRow temp2;
        List<Coords> kordy = Coords.coordsAroundSystem(planet.getCoords(), range);
        all = engine.getGalaxySystemView(kordy);
        ite = all.iterator();
        while (ite.hasNext()) {
            temp2 = ite.next();
            if (temp2.isEmpty()) {
                continue;
            }
            if (!temp2.isInactive()) {
                continue;
            }
            idlers.add(temp2);
        }
        return idlers;
    }
    
    private List<CoordsElement3> checkSavedReports(List<GalaxyRow> rows){
        Iterator<GalaxyRow> it = rows.iterator();
        List<CoordsElement3> idlersCoords = new ArrayList<CoordsElement3>();
        GalaxyRow temp;
        CoordsElement3 element;
        while (it.hasNext()){
            temp = it.next();
            element = new CoordsElement3(this.savePath,temp.getCoord());
            idlersCoords.add(element);
            element.loadReport();
        }
        return idlersCoords;
    }
    
    private void scanNewIdlers(List<CoordsElement3> list) throws OgameElementNotFoundException, OgameException{
        Iterator<CoordsElement3>  ite = list.iterator();
        CoordsElement3 temp;
        int max = engine.getSlotsTotal() - engine.getSlotsOccupied();
        int count = 0, reports = 0;
        TimePeriod maxTime;
        List<TimePeriod> arrivals = new ArrayList<TimePeriod>();
        while (ite.hasNext()) {
            temp = ite.next();
            if (temp.hasReport()) continue;
            try {
                arrivals.add(engine.sendFleet(this.scanning, temp.getCoords(), Mission.SPY).getFlyingTime());
                count++;
                reports++;
            } catch (Exception ex) {
            }
            if (count >= max) {
                count = 0;
                maxTime = TimePeriod.max(arrivals);
                arrivals = new ArrayList<TimePeriod>();
                engine.wait(maxTime);
                max = engine.getSlotsTotal() - engine.getSlotsOccupied();
            }
        }
        List<Report> raportList = engine.getReports(reports);
    }
    
    public void initIdlersList() throws OgameException {
        engine.changePlanet(planet);
        coords = new ArrayList<CoordsElement3>();
        List<GalaxyRow> idlers = this.getAllIdlers(); // wczytujemy wszystkich idlerów
        List<CoordsElement3> fullList = this.checkSavedReports(idlers);// sprawdzamy zapisane raporty
        this.scanNewIdlers(fullList);
        
        
    }
    private Planet planet;
    private List<CoordsElement3> coords;
    private Fleet farming, fs, scanning;
    private int startCount;
    private int range;
    private String savePath;
    private Ogame engine;
}
