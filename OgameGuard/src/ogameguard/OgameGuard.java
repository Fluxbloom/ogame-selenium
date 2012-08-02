/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Flights;
import OgameEngine.Ogame;
import OgameEngine.OgameException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author dyschemist
 */
public class OgameGuard {

    Ogame o;

    public OgameGuard(Ogame o) {
        this.o = o;
    }
    
    
    void login(String uni, String nick, String pass) throws OgameException{
        o.login(uni, nick, pass);
    }
    
    
    List<Flights> getEventList() throws OgameException{
        return o.getEventList(); 
    }
    
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    
    void check() throws OgameException {
            String uni = "Pegasus", nick ="Mystic", pass="SuperUltraSsjGoku2";
            Calendar now = GregorianCalendar.getInstance();
            this.login(uni, nick, pass);
            List<Flights> list = this.getEventList();
            Iterator<Flights> it = list.iterator();
            Flights temp;
            boolean isOkey = true;
            while(it.hasNext()){
                temp = it.next();
                if (temp.getType()==Flights.SPY){
                    isOkey=false;
                    System.out.println(sdf.format(now.getTime())+"->Jesteśmy skanowani");
                    break;
                } else if (temp.getType() == Flights.ATTACK){
                    isOkey=false;
                    System.out.println(sdf.format(now.getTime())+"->Jesteśmy atakowani");
                    break;
                }
            }
            if (isOkey){
                System.out.println(sdf.format(now.getTime())+"->Wszystko w porządku");
            }
            this.o.logout();
    }
    
    
    /**
     * @param args the command line arguments are ignored
     */
    public static void main(String[] args) {
        String uni = "116";
        String lang= "pl";
        int hour=0,minute=2,seconds=0;
        OgameGuard guard = new OgameGuard(Ogame.ogameFabric("uni", "pl"));
        while(true){
            try {
                guard.check();
            } catch(OgameException ex){
                
            }
            guard.o.wait(hour, minute, seconds);
        }
        
    }
}
