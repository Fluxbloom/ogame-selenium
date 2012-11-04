/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameTimeParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Klasa reprezentuje czasy ukończenia lub rozpoczęcia danej akcji w ogame 
 * @author Piotr Kowalski
 */
public class Time {

    /**
     * Konstruktor generujący obecny czas
     */
    public Time() {
        this.time = new GregorianCalendar();
    }
    
    /**
     * Domyślny konstruktor klasy Time
     * @param year rok
     * @param month miesiac
     * @param day dzien
     * @param hour godzina
     * @param minute minuta
     * @param second sekunda
     */
    
    public Time(int year, int month, int day, int hour, int minute, int second) {
        time = new GregorianCalendar();
        time.set(Calendar.YEAR, year);
        time.set(Calendar.MONTH, month);
        time.set(Calendar.DAY_OF_MONTH, day);
        time.set(Calendar.HOUR_OF_DAY, hour);
        time.set(Calendar.MINUTE, minute);
        time.set(Calendar.SECOND, second);
    }
    
    /**
     * Konstruktor pomocniczy oparty o obiekt kalendarza
     * @param time 
     */
    public Time(Calendar time) {
        this.time = time;
    }
    /**
     * Pomocnicza metoda wyciągająca obiekt kalendarza
     * @return obiekt kalendarza z daną datą
     */
    public Calendar getTime() {
        return time;
    }
    
    /**
     * Metoda dodaje okres czasu do bieżacego obiektu Time
     * !! działa jedynie dla dodatnich czasów
     * @param period okres czasu o jaki przesuwany jest obiekt Time
     */
    public void add(TimePeriod period) {
        Calendar left = this.time,
                right = period.getTime();
        left.add(Calendar.DATE, right.get(Calendar.DAY_OF_YEAR) - 1);
        left.add(Calendar.HOUR_OF_DAY, right.get(Calendar.HOUR_OF_DAY));
        left.add(Calendar.MINUTE, right.get(Calendar.MINUTE));
        left.add(Calendar.SECOND, right.get(Calendar.SECOND));
    }
    

    /**
     * Metoda duplikowania obiektów typu Time
     * @return Kopia obiektu Time
     * @throws CloneNotSupportedException Błąd braku funkcji klonowania
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Time((Calendar) this.time.clone());
    }

    /**
     * Metoda statyczna dodająca dwie daty
     * @param base podstawowy czas
     * @param period różnica czasu
     * @return przesunięty czas
     */
    public static Time add(Time base, TimePeriod period) {
        Time newTime = base;
        try {
            newTime = (Time) base.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar left = newTime.time,
                right = period.getTime();
        left.add(Calendar.DATE, right.get(Calendar.DAY_OF_YEAR) - 1);
        left.add(Calendar.HOUR_OF_DAY, right.get(Calendar.HOUR_OF_DAY));
        left.add(Calendar.MINUTE, right.get(Calendar.MINUTE));
        left.add(Calendar.SECOND, right.get(Calendar.SECOND));
        return newTime;
    }
    
    public String toXML(){
        String result="<"+xmlHeader+">";
        result+=sdf.format(this.time.getTime());
        result+="</"+xmlHeader+">\n";
        return result;
    }
    
    static public Time parseXML(Element root) throws OgameTimeParseException{
        Time result = null;
        NodeList list = root.getElementsByTagName(xmlHeader);
        if (list.getLength()>0){
            String time = list.item(0).getTextContent();
            Calendar cal = new GregorianCalendar();
            try {
                cal.setTime(sdf.parse(time));
                result = new Time(cal);
            } catch (ParseException ex) {
               throw new OgameTimeParseException();
            }
            
        }
        return result;
    }
    
    /**
     * Domyślny format wyświetlania
     */
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
    /**
     * Zwraca string opisujący okres czasu.
     * @return 
     */
    public String getFormattedTimeString(){
        return sdf.format(this.time.getTime());
    }
    
    private Calendar time;
    public static String xmlHeader="time";
}
