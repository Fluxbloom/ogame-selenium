/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.OgameTest;
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
public class OverviewTest extends OgameTest{
    
    public OverviewTest()  {
    }
 
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Ignore
    @Test
    public void getResourcesTest() throws OgameElementNotFoundException, OgameException{
        o.start();
        o.login(uni, nick, pass);
        Resources pr = (Resources)o.getResources();
        System.out.println(((Resources)pr).toString());
        pr.subtract(Resources.DEUTERIUM, 2000);
        System.out.println(pr.toString());
        o.logout();
        o.stop();
    }
    
    @Test
    public void getAndIterateAllPlanets() throws OgameException{
        o.start();
        o.login(uni, nick, pass);
        List<AstronomicalObject> list = o.getPlanetList();
        Iterator<AstronomicalObject> it = list.iterator();
        while(it.hasNext()){
            o.changePlanet(it.next());
            o.wait(20);
        }
        o.logout();
        o.stop();
    }        
    
    
}
