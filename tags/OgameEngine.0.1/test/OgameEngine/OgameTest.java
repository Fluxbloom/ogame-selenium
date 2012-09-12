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

/**
 * Klasa ogólna do testów
 * @author Piotr Kowalski
 */
public abstract class OgameTest {

    protected Ogame o;
    protected TestProperties prop;
    protected String uni;
    protected String nick;
    protected String pass;

    public OgameTest() {
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

    
}
