/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.Ogame116pl;
import OgameEngine.OgameTest;
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
    public void changeMoonTest() throws OgameFileNotFoundException, OgameIOException, OgameException{
        o.start();
        o.login(uni, nick, pass);
        Moon moon = new Moon(new Coords(2,158,7,Destination.MOON),"Nelliel");
        List<AstronomicalObject> list = o.getPlanetList();
        o.logout();
        o.stop();
    }
}
