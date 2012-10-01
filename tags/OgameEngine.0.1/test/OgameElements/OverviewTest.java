/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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
}
