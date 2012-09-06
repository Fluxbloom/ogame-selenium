/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import OgameEngineUnchecked.OgameException;
import OgameEngineUnchecked.Ogame;
import OgameElementsUnchecked.Events;
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
public class EventListTest {
    
    Ogame o;
    TestProperties prop;
    String uni;
    String nick;
    String pass;
    
    public EventListTest() throws IOException {
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
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void eventList() throws OgameException {
        try {
            o.wait(5);
            o.login(uni, nick, pass);
            List<Events> lista = o.getEventList();
            Iterator<Events> it = lista.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (OgameException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            o.logout();
        }
    }


    
}
