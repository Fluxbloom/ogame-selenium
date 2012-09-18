/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class MessagesTest extends OgameTest {

    public MessagesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void getReportTest() throws OgameException {
        o.start();
        o.login(uni, nick, pass);
        o.getReports(16);
        o.wait(5);
        o.logout();
        o.stop();
    }
}
