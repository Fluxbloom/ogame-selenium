/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.io.IOException;
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
public class LoginTest {

    Ogame o;
    TestProperties prop;
    String uni;
    String nick;
    String pass;

    public LoginTest() {
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
    public void noInternetConnection() throws OgameException {
        try {
            o.login(uni, nick, pass);
            o.wait(0, 30);
            System.err.println("Przeglądarka on "+o.isLogged());
            o.logout();
            
        } catch (OgameException ex){
            System.err.println("Ogame Exception "+ex.getMessage());
        }
        finally {
            ((Ogame116pl) o).stop();
        }
    }

    @Test
    public void isLoggedIn() throws OgameException {
        try {
           o.login(uni, nick, pass);
            o.wait(0,20);
            System.out.println(o.isLogged());
        } finally {
            o.close();
        }
    }
}
