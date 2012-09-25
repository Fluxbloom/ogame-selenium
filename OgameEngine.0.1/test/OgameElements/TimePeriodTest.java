/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameParsingError;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dyschemist
 */
public class TimePeriodTest {
    
    public TimePeriodTest() {
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

    TimePeriod time = new TimePeriod(51,3,15,6,18);
    TimePeriod tim2 = new TimePeriod(0,2,15,6,8);
    /**
     * Test of compareTo method, of class TimePeriod.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        TimePeriod p1 = new TimePeriod(1,25,2,4);
        TimePeriod p2 = new TimePeriod(2,1,2,4);
        
        int expResult = 0;
        int result = p1.compareTo(p2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getYears method, of class TimePeriod.
     */
    @Test
    public void testGetYears() {
        System.out.println("getYears");
        int expResult = 0;
        int result = time.getYears();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDays method, of class TimePeriod.
     */
    @Test
    public void testGetDays() {
        System.out.println("getDays");
        int expResult = 2;
        int result = tim2.getDays();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class TimePeriod.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        int expResult = 15;
        int result = time.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class TimePeriod.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        int expResult = 6;
        int result = time.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeconds method, of class TimePeriod.
     */
    @Test
    public void testGetSeconds() {
        System.out.println("getSeconds");
        int expResult = 18;
        int result = time.getSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormattedTimeString method, of class TimePeriod.
     */
    @Test
    public void testGetFormattedTimeString() {
        System.out.println("getFormattedTimeString");
        TimePeriod p = new TimePeriod(0,0,6,7,8);;
        String expResult = "0:0 6:7:8";
        String result = p.getFormattedTimeString();
        
        assertEquals(expResult, result);
    }


    @Test
            public void parsingTimePeriodTest() throws OgameParsingError {
        String tim ="1:54:11 h";
        TimePeriodParser tpp = new SimpleTimePeriodParser("HH:mm:ss 'h'");
        tpp.parse(tim);
    }
}
