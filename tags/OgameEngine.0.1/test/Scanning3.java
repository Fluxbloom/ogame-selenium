/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.AstronomicalObject;
import OgameElements.Coords;
import OgameElements.Fleet;
import OgameElements.GalaxyRow;
import OgameElements.Mission;
import OgameElements.Planet;
import OgameElements.Ships;
import OgameElements.TimePeriod;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class Scanning3 extends OgameTest{
    
    public Scanning3() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Test
    @Ignore
    public void scanDlaMadzi() throws OgameException {
        Planet hinata = new Planet(new Coords(2,199,7),"Hinata");
        List<GalaxyRow> all,idlers = new ArrayList<GalaxyRow>();
        int systems = 14;
        Fleet sonds = new Fleet();
        sonds.add(Ships.SOND, 3);
        o.start();
    o.login(uni, nick, pass);
    o.changePlanet(hinata);
    List<Coords> meinLand = Coords.coordsAroundSystem(new Coords(1,448,10), systems);
    List<Coords> sonne = Coords.coordsAroundSystem(new Coords(2,199,6), systems);
    all = o.getGalaxySystemView(meinLand);
    all.addAll(o.getGalaxySystemView(sonne));
    Iterator<GalaxyRow> ite = all.iterator();
    GalaxyRow temp2;
    while(ite.hasNext()){
            temp2 = ite.next();
            if (temp2.isEmpty()) continue;
            if (!temp2.isInactive()) continue;
            idlers.add(temp2);
        }
        ite = idlers.iterator();
        int max = o.getSlotsTotal()-o.getSlotsOccupied();
        int count=0, reports=0;
        TimePeriod maxTime;
        List<TimePeriod> arrivals = new ArrayList<TimePeriod>();
        while (ite.hasNext()){
            temp2 = ite.next();
            try{
            arrivals.add(o.sendFleet(sonds,temp2.getCoord() , Mission.SPY).getFlyingTime());
            count++;
            reports++;
            } catch( Exception ex){}
            if (count >= max){
                count=0;
                maxTime = TimePeriod.max(arrivals);
                arrivals = new ArrayList<TimePeriod>();
                o.wait(maxTime);
                max = o.getSlotsTotal()-o.getSlotsOccupied();
            }
        }
    
    o.logout();
    o.stop();
    }
    
    @Test
    public void hello() throws OgameException {
    o.start();
    o.login(uni, nick, pass);
    int systems = 17;
    List<AstronomicalObject> planets = o.getPlanetList();
    Iterator<AstronomicalObject> it = planets.iterator();
    List<GalaxyRow> all,idlers;
    Iterator<GalaxyRow> ite;
    AstronomicalObject temp;
    GalaxyRow temp2;
    Fleet sonds = new Fleet();
    sonds.add(Ships.SOND, 3);
    // zaczynamy skakanie po planetach
    while(it.hasNext()){
        try {
        idlers = new ArrayList<GalaxyRow>();
        temp = it.next();
        if (temp.isMoon()) continue; // ksiezyce jednak pomijamy
        o.changePlanet(temp);
        // tworzymy mape wszystkich idlerów w okolicy
        List<Coords> kordy = Coords.coordsAroundSystem(temp.getCoords(), systems);
        all = o.getGalaxySystemView(kordy);
        ite = all.iterator();
        while(ite.hasNext()){
            temp2 = ite.next();
            if (temp2.isEmpty()) continue;
            if (!temp2.isInactive()) continue;
            idlers.add(temp2);
        }
        ite = idlers.iterator();
        int max = o.getSlotsTotal()-o.getSlotsOccupied();
        int count=0, reports=0;
        TimePeriod maxTime;
        List<TimePeriod> arrivals = new ArrayList<TimePeriod>();
        while (ite.hasNext()){
            temp2 = ite.next();
            try{
            arrivals.add(o.sendFleet(sonds,temp2.getCoord() , Mission.SPY).getFlyingTime());
            count++;
            reports++;
            } catch( Exception ex){}
            if (count >= max){
                count=0;
                maxTime = TimePeriod.max(arrivals);
                arrivals = new ArrayList<TimePeriod>();
                o.wait(maxTime);
                max = o.getSlotsTotal()-o.getSlotsOccupied();
            }
        }
        }catch (Exception ex){}
        
    }
    
    o.logout();
    o.stop();
        
    }
}
