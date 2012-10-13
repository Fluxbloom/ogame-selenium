/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Buildings;
import OgameElements.PlanetResources;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author andrzej
 */
public class TestAndrzejLogin extends OgameTest{
    
    public TestAndrzejLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void tescik() throws OgameException {
        o.start();
        o.login(uni, nick, pass);
        PlanetResources p= o.getCost(Buildings.CRYSTAL_MINE);
        System.out.println(p.toString());
        o.logout();
        o.stop();
    }
}
