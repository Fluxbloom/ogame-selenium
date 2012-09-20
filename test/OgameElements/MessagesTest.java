/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
        List<Report> list = o.getReports(6);
        Collections.sort(list);
        Iterator<Report> it = list.iterator();
        for (Report temp;it.hasNext();){
            temp = it.next();
            System.out.println(temp.toString());
        }
        o.wait(5);
        o.logout();
        o.stop();
    }
}
