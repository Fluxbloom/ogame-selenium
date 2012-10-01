/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.TestProperties;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Ogame;
import OgameElements.Planet;
import OgameElements.Coords;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
public class ChangePlanetTest {
    
        Ogame o;
    TestProperties prop;
    String uni;
    String nick;
    String pass;
    
    public ChangePlanetTest() throws IOException {
        o = Ogame.ogameFabric("116", "pl");
        prop = new TestProperties();
        uni = prop.getUniverse();
        nick = prop.getNick();
        pass = prop.getPass();
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    @Ignore
    public void changePlanetByName() throws OgameException{
        o.login(uni, nick, pass);
        o.changePlanetByName("Videl");
        o.wait(15);
        o.changePlanetByName("Hinata");
        o.wait(15);
        o.changePlanetByName("Aisha");
        o.logout();
        
    }
    @Test
    @Ignore
    public void changePlanetByCoords() throws OgameException, IOException{
        o.login(uni, nick, pass);
        o.changePlanetByCoords(new Coords(2,199,7));
        o.wait(15);
        o.changePlanetByCoords(new Coords(2,158,7));
        o.wait(15);
        o.changePlanetByCoords(new Coords(2,106,6));
        o.logout();
    }
    @Test
    @Ignore
    public void changePlanetById() throws OgameException{
        o.login(uni, nick, pass);
        o.changePlanet(2);
        o.wait(15);
        o.changePlanet(3);
        o.wait(15);
        o.changePlanet(1);
        o.logout();
    }

    @Test
    public void getPlanetListTest() throws OgameException{
        o.login(uni, nick, pass);
        List<Planet> lista = o.getPlanetList();
        Iterator<Planet> it = lista.iterator();
        for (Planet temp; it.hasNext();){
            temp = it.next();
            System.out.println(temp);
        }
        o.logout();
    }        
            
}
