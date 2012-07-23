/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.io.IOException;
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
        o = new Ogame();
        prop =new TestProperties();
        uni = prop.getUniverse();
        nick = prop.getNick();
        pass = prop.getPass();
    }

    @After
    public void tearDown() {
    }


    @Test
    @Ignore
    public void PropertiesTest(){
        System.out.println("Properties test");
        System.out.println(prop.toString());
    }
    
    @Test
    @Ignore
    public void SeleniumStartTest() {

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
    public void TrySendingFleet(){
        o.login(uni, nick, pass);
        Fleet f = new Fleet();
        f.add(Ships.SOND, 2);
        o.sendFleet(f, new Cords("2","243","6"), Speed.S70 ,Mission.MISSION_SPY,Resources.NO_RESOURCES);
        o.logout();
    }
    @Test
    //@Ignore
    public void BuildMM(){
        o.login(uni, nick, pass);
        o.build(Buildings.KOPALNIA_METALU);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @Ignore
    public void StudyTB(){
        o.login(uni, nick, pass);
        o.study(Study.TECHNOLOGIA_LASEROWA);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @Ignore
    public void DefenceCL(){
        o.login(uni, nick, pass);
        o.defence(Defence.MALY_LASER);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumStartTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
