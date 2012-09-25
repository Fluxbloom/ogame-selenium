/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.OgameTest;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Klasa zawiera testy dotyczące kordynatów
 * @author Piotr Kowalski 
 */
public class CoordsTest extends OgameTest {

    public CoordsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void isSameSystemTest() throws OgameFileNotFoundException, OgameIOException {
        Coords c1 = new Coords(2, 33, 1),
                c2 = new Coords(2, 33, 2),
                c3 = new Coords(2, 34, 5),
                c4 = new Coords(2, 33, 1, Coords.MOON);
        Assert.assertTrue(c1.isSameSystem(c2));
        Assert.assertFalse(c1.isSameSystem(c3));
        Assert.assertTrue(c1.isSameSystem(c4));
    }

    @Test
    public void testMergeList() throws OgameFileNotFoundException, OgameIOException {
    Coords[] c = Coords.parseArray(new String[]{"1:1:1","1:2:1"}),
           d = Coords.parseArray(new String[]{"2:1:1","2:2:1"}) ;
    Coords[] e = Coords.mergeList(new Coords[][]{c,d});
    for (int i=0; i<e.length;i++){
        System.out.println(e[i].shortPrint());
    }
    }
}
