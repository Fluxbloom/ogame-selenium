/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;


import OgameEngine.Exceptions.OgameException;
import org.junit.*;

/**
 *
 * @author plich
 */
public class SendInterpreteTEST {
    
    public SendInterpreteTEST() {
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
    public void send1Interpret() throws OgameException {
    Interpreter i = new Interpreter();
    i.interpret("sendfleet -m attack -dt 3 -c 2:244:7  --metal 100");
    }
}
