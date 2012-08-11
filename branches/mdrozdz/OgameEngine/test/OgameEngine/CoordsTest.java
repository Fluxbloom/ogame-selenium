/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author soncrash
 */
public class CoordsTest {

    public CoordsTest() {
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
    // @Test
    // public void hello() {}

    @Test
    public void isEqualTest() {
        Coords c = new Coords(1, 1, 1);
        Coords d = new Coords(1, 1, 1);
        Assert.assertTrue(c.equals(d));
        Coords c2 = new Coords(1, 1, 1, Coords.MOON);
        Coords d2 = new Coords(1, 1, 1, Coords.PLANET);
        Assert.assertFalse(c2.equals(d2));
    }

    @Test
    public void parsingTest() {
        String a = "[2:2:7]";
        Coords exp = new Coords(2, 2, 7);
        Coords result = Coords.parse(a);
        Assert.assertTrue(result.equals(exp));
        a = "[2:2:8]";
        exp = new Coords(2, 2, 7);
        result = Coords.parse(a);
        Assert.assertFalse(result.equals(exp));
        a = "[2:2:20]";
        exp = new Coords(2, 2, 20);
        result = Coords.parse(a);
        Assert.assertTrue(result.equals(exp));
        a = "[2:2:20]";
        exp = new Coords(2, 2, 16);
        result = Coords.parse(a);
        System.err.println(result.toString());
        Assert.assertTrue(result.equals(exp));
        a = "2:2:7]";
        exp = new Coords(2, 2, 7);
        result = Coords.parse(a);
        Assert.assertTrue(result.equals(exp));
        a = "[2:02:7]";
        exp = new Coords(2, 2, 7);
        result = Coords.parse(a);
        Assert.assertTrue(result.equals(exp));
    }
}
