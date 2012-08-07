/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Flights;
import OgameEngine.Ogame;
import OgameEngine.Slots;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dyschemist
 */
public class DefaultSpyResponse implements SpyResponse {

    static final Logger logger = Logger.getLogger(DefaultSpyResponse.class.getName());
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    @Override
    public void response(Ogame o, List<Flights> list, List<Slots> sloty) {
        Calendar now = GregorianCalendar.getInstance();
        Iterator<Flights> it = list.iterator();
        logger.log(Level.INFO, "-------------------------------------------------");
        logger.log(Level.INFO, "Time: {0}", sdf.format(now.getTime()));
        if (list.isEmpty()) {
            logger.log(Level.INFO, "Brak wszelkich lotów");
        } else {
            for (Flights temp; it.hasNext(); ) {
                temp = it.next();
                logger.log(Level.INFO, "Fleet: {0} ->{1} on time {2} as {3}", new Object[]{
                            (temp.getOrigin() == null ? "X" : temp.getOrigin().shortPrint()), temp.getDest().shortPrint(), sdf.format(temp.getArrivalTime().getTime()), temp.getType().getName()});
            }
        }
        logger.log(Level.INFO, "-------------------------------------------------");
    }
}
