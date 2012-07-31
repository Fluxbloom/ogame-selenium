/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Coords.Destination;
import OgameEngine.Fleet.Ships;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class SeleniumStartTest {

    Ogame o;
    TestProperties prop;
    String uni;
    String nick;
    String pass;

    public SeleniumStartTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws IOException {
        o = Ogame.ogameFabric("116", "pl");
        prop = new TestProperties();
        uni = prop.getUniverse();
        nick = prop.getNick();
        pass = prop.getPass();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PropertiesTest() {
        System.out.println("Properties test");
        System.out.println(prop.toString());
    }

    @Test
    public void SeleniumStartTest() throws OgameException {

        o.login(uni, nick, pass);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        o.logout();
    }

    @Test
    @Ignore
    public void TrySendingFleet() throws OgameException {
        o.login(uni, nick, pass);
        Fleet f = new Fleet();
        f.add(Ships.SOND, 2);
        o.sendFleet(f, new Coords("2", "243", "6"), Speed.S70, Mission.MISSION_SPY, Resources.NO_RESOURCES);
        o.logout();
    }

    @Test
    @Ignore
    public void BuildMM() throws OgameException {
        o.login(uni, nick, pass);
        o.build(Buildings.MAGAZYN_METALU);
        o.wait(10);
    }

    @Test
    public void wykrycieListyPlanet() throws OgameException {
       o.login(uni, nick, pass);
       List<String> planety = o.getPlanetNames();
       Iterator<String> it = planety.iterator();
       while(it.hasNext()){
           System.out.println("Planeta "+it.next());
       }
       planety = o.getPlanetCoords();
       it = planety.iterator();
       while(it.hasNext()){
           System.out.println("Planeta "+it.next());
       }
       o.logout();
    }
    
    @Test
    public void eventList()throws OgameException{
        try{
        o.login(uni, nick, pass);
        List<Flights> lista = o.getEventList();
        Iterator<Flights> it = lista.iterator();
        while(it.hasNext()){
            System.err.println(it.next().toString());
        }
        } catch(OgameException ex){
            System.err.println(ex.getMessage());
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally {
        o.logout();
        }
    }

    
    @Test
    @Ignore
    public void farming() throws OgameException {
        o.login(uni, nick, pass);
        Fleet farmiaca = new Fleet();
        farmiaca.add(Ships.MT, 1);
        Fleet recki = new Fleet();
        recki.add(Ships.REC, 2);
        Fleet fs = Fleet.WHOLE_FLEET;
        Coords[] pz = new Coords[]{
        new Coords(2,100,4,Destination.PZ),
        new Coords(2,102,10,Destination.PZ),
        new Coords(2,107,8,Destination.PZ),
        new Coords(2,108,8,Destination.PZ),
        new Coords(2,108,12,Destination.PZ)
        };
        Coords[] farms = new Coords[]{
        new Coords(2,114,8),
        new Coords(2,112,8),
        new Coords(2,110,6),
        new Coords(2,109,10),
        new Coords(2,109,8)
        };
        Coords[] hinataFarms = new Coords[]{
        new Coords(2,107,8)
        };
        
        int aisha_fleets = 4;
        int hinata_fleets = 1;
        int pz_fleets = 1;
        o.changePlanetByName("Aisha");
        for (int i=0; i < pz_fleets;i++){
            try {
                o.sendFleet(recki, pz[i], Speed.S100, Mission.MISSION_RECYCLE, Resources.NO_RESOURCES);
                aisha_fleets--;
            } catch (OgameException ex) {
                Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        o.changePlanetByName("Hinata");
        for( int i=0; i< hinata_fleets-1; i++){
            o.sendFleet(fs, hinataFarms[i], Speed.S100, Mission.MISSION_ATTACK, Resources.ALL_RESOURCES);
        }
        o.changePlanet(1);
        int i;
        for(i=0; i< aisha_fleets; i++){
            o.sendFleet(farmiaca, farms[i], Speed.S100, Mission.MISSION_ATTACK, Resources.NO_RESOURCES);
        }
        o.sendFleet(fs, farms[i], Speed.S100, Mission.MISSION_ATTACK, Resources.ALL_RESOURCES);
        o.logout();
    }
}
