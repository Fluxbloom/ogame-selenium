/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Flights;
import OgameEngine.Ogame;
import OgameEngine.OgameException;
import java.io.IOException;
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
public class OgameGuard {

    Ogame o;
    static GuardProperties properties;

    public OgameGuard(Ogame o) {
        this.o = o;
        
    }
    
    
    void login(String uni, String nick, String pass) throws OgameException{
        o.login(uni, nick, pass);
    }
    
    
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    
    void check() throws OgameException {
            Calendar now = GregorianCalendar.getInstance();
            List<Flights> list = this.o.getEventList(); 
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
            
    }
    
    public static void main1(){
        try {
                properties = new GuardProperties();
            } catch (IOException ex) {
                Logger.getLogger(OgameGuard.class.getName()).log(Level.SEVERE, null, ex);
            }
            String uni_number = properties.getUni_number();
            String lang= properties.getUni_lang();
            int hour=0,minute=2,seconds=0;
            OgameGuard guard = new OgameGuard(Ogame.ogameFabric(uni_number, lang));
            String uni = properties.getUni(), 
                        nick =properties.getNick(),
                        pass=properties.getPass();
        try {
            guard.login(uni, nick, pass);
        } catch (OgameException ex) {
            guard.o.close();
            return;
        }
            while(true){
                try {
                    guard.check();
                } catch(OgameException ex){
                    try {
                        guard.o.logout();
                        guard.o.login(uni, nick, pass);
                    } catch (OgameException ex1) {
                        Logger.getLogger(OgameGuard.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                guard.o.wait(hour, minute, seconds);
            }
        
    }
    
    
    /**
     * @param args the command line arguments are ignored
     */
    public static void main(String[] args) {
       main1();  
    }
}
