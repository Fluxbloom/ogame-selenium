/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import java.util.Calendar;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author plich
 */
public class InterpreteServerTest {
    
    public InterpreteServerTest() {
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


    /**
     * Test of parse method, of class InterpreteServer.
     */
    @Test
    public void testParse() throws Exception {
        String commandAndTime1 = "12:09:12 21:56:00;chplanet -l 4",
               commandAndTime2 = "12:09:12 21:57:00;chplanet -l 2",
               commandAndTime3 = "12:09:12 21:55:00;chplanet -l 3";
        

        InterpreteServer instance = new InterpreteServer();
        Thread server = new Thread(instance);
        server.start();
        
        instance.parse(commandAndTime1);
        instance.parse(commandAndTime1);
        instance.parse(commandAndTime2);
        instance.parse(commandAndTime3);
        server.join();
        //instance.parse(commandAndTime);
    }
}
