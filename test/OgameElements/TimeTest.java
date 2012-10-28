/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameParsingException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testy sprawdzające obiekty czasu Time
 * @author dyschemist
 */
public class TimeTest extends OgameTest{
    
    public TimeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testParsingTime() throws OgameParsingException{
        String s = "09.09.12 23:34:27";
        TimeParser tp = new TimeParser("dd.MM.yy HH:mm:ss");
        Time t = tp.parse(s);
        System.out.println("Time   "+t.getFormattedTimeString());
    }
}
