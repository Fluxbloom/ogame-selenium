/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Events;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author andrzej
 */
public class EventTestAndrzej extends OgameTest{
    
    public EventTestAndrzej() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
     @Test
     public void hello() throws OgameException {
     o.start();
     o.login(uni, nick, pass);
     List<Events> eventy = o.getEventList();
     System.out.println(eventy.toString());
//     Iterator<Events> it = eventy.iterator();
//     while(it.hasNext()){
//         System.out.print
//     }
     o.logout();
     o.stop();
     
     }
}
