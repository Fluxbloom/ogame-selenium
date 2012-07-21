package OgameInterprete;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameInterpreter.Interpreter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class TestInterpret {
    
    public TestInterpret() {
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
    public void interpretTest() {
    String[] str = new String[]{
        "ON 2012-09-18 23:00:00 ; LOGIN UNI USER PASS",
        "AT 23:07:06 ; BUILD KM",
        "NW ; SEND 2 MT TO 2:30:7 SPEED 100 RESOURCES ALL",
        "IN 5m  ; LOGOUT"};
    Interpreter i = new Interpreter();
    i.interpret(str);
    
    }
}
