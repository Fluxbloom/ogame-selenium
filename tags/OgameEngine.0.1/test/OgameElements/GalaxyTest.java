/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import OgameEngine.Ogame116pl;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class GalaxyTest extends OgameTest {

    public GalaxyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws OgameElementNotFoundException, OgameException {
        o.start();
        o.login(uni, nick, pass);
        List<Coords> c = Coords.coordsSystemRange(new Coords(2,94,1), new Coords(2,103,1));
        List<GalaxyRow> list = o.getGalaxySystemView(c);
        Iterator<GalaxyRow> it = list.iterator();
        GalaxyRow temp;
        while(it.hasNext()){
            temp = it.next();
            if (temp.isEmpty()) continue;
            if (!temp.isInactive()) continue;
            System.out.println(temp.toString());
        }
        //o.logout();
        //o.stop();
    }
}
