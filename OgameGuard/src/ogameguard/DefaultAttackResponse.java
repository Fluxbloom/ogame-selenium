/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Coords.Planet;
import OgameEngine.Flights;
import OgameEngine.Ogame;
import OgameEngine.Slots;
import java.io.IOException;
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
public class DefaultAttackResponse implements AttackResponse {
    
    private DefaultAttackResponseProperties properties;
    private int escapeMinutes;
    
    public DefaultAttackResponse() {
        try {
            properties = new DefaultAttackResponseProperties();
        } catch (IOException ex) {
            Logger.getLogger(DefaultAttackResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.escapeMinutes = properties.getEscapeMinutes();
    }

    @Override
    public void response(Ogame o,List<Flights> attackList, List<Slots> autoFleet) {
        Iterator<Flights> it = attackList.iterator();
        Calendar now = GregorianCalendar.getInstance();
        now.add(Calendar.MINUTE, (-1)*escapeMinutes);
        Planet planeta;
        for (Flights temp = it.next(); it.hasNext(); temp=it.next()){
            // TODO tłumaczanie na akcje
            /*
             * 1. Trzeba sprawdzić czy czas zgodny
             */
              if (temp.getArrivalTime().after(now)){
                  planeta = temp.getDest();
                  
             /* 2. Czy flota na planecie
             * 3. Jeśli trzeba podnieść to
             * 4. Zapisać stan flot
             * 5. Podniesc flote
             * 6. Sprawdzić która flota się pojawiła
             * 7. Dorzucić flotę do automatycznych
             */
              }
        }
        
    }
    
}
