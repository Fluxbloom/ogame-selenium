/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa gromadzi w sobie okres czasu np. czas dolotu , lub budowy budynku
 * @author Piotr Kowalski
 */
public class TimePeriod implements Comparable{

    /**
     * Domyślny konstruktor klasy TimePeriod
     * @param weeks ilość tygodni
     * @param days ilość dni
     * @param hours ilość godzin
     * @param minutes ilość minut
     * @param seconds ilość sekund
     */
    
    public TimePeriod(int weeks, int days, int hours, int minutes, int seconds) {
        time = new GregorianCalendar();
        time.set(Calendar.YEAR, 0);
        time.set(Calendar.MONTH, 0);
        time.set(Calendar.WEEK_OF_YEAR, 1);
        time.set(Calendar.DAY_OF_YEAR, 1);
        time.add(Calendar.WEEK_OF_YEAR, weeks);
        time.add(Calendar.DAY_OF_YEAR, days);
        time.set(Calendar.HOUR_OF_DAY, hours);
        time.set(Calendar.MINUTE, minutes);
        time.set(Calendar.SECOND, seconds);
    }
        /**
     * Domyślny konstruktor klasy TimePeriod
     * @param days ilość dni
     * @param hours ilość godzin
     * @param minutes ilość minut
     * @param seconds ilość sekund
     */
    
    public TimePeriod(int days, int hours, int minutes, int seconds) {
        this(0,days,hours,minutes,seconds);
    }
    /**
     * Domyślny konstruktor klasy TimePeriod
     * @param hours ilość godzin
     * @param minutes ilość minut
     * @param seconds ilość sekund
     */
    
    public TimePeriod(int hours, int minutes, int seconds) {
        this(0,0,hours,minutes,seconds);
    }
    /**
     * Zapasowy konstruktor, np dla celów kopiowania
     * @param time obiekt kalendarza przechodujący czas 
     */
    TimePeriod(Calendar time) {
        this.time = time;
    }
    /**
     * Zapasowy konstruktor ale używający obiektów Date
     * @param date 
     */
    TimePeriod(Date date){
        this.time = new GregorianCalendar();
        this.time.setTime(date);
    }
    /**
     * Pomocniczy getter do pobrania kalendarza
     * @return 
     */
    Calendar getTime() {
        return time;
    }
    /**
     * Dodaje wyznaczoną ilość godzin do czasu trwania
     * @param hours ilość godzin (koniecznie liczba dodatnia)
     */
    public void addHours(int hours){
        this.time.add(Calendar.HOUR_OF_DAY, hours);
    }
    /**
     * Dodaje wyznaczoną ilość godzin do czasu trwania
     * @param hours ilość godzin (koniecznie liczba dodatnia)
     */
    public void addHours(String hours){
        addHours(Integer.parseInt(hours));
    }
    /**
     * Dodaje dwa okresy czasu do siebie 
     * UWaga! oba muszą okresami dodatnimi
     * @param period Okres o który powiększamy czas
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
     * Podwaja dany okres czasu 
     */
    public void doubleTimePeriod(){
        this.add(this);
    }

    //TODO sprawdzić to compareTo
    @Override
    public int compareTo(Object arg0) {
        TimePeriod t = (TimePeriod) arg0;
        return this.time.compareTo(t.time);
    }
    
    /**
     * Zwraca ilość lat 
     * @return ilość lat
     */
    public int getYears(){
        return this.time.get(Calendar.YEAR)-1970;
    }
    
    /**
     * Zwraca ilość dni
     * @return ilość dni
     */
    public int getDays(){
        return this.time.get(Calendar.DAY_OF_YEAR)-1;
    }
    /**
     * Zwraca ilość godzin
     * @return ilość godzin
     */
    public int getHours(){
        return this.time.get(Calendar.HOUR_OF_DAY);
    }
    /**
     * Zwraca minuty
     * @return minuty
     */
    public int getMinutes(){
        return this.time.get(Calendar.MINUTE);
    }
    /**
     * Zwraca sekundy
     * @return sekundy
     */
    public int getSeconds(){
        return this.time.get(Calendar.SECOND);
    }
    

    /**
     * Zwraca string opisujący okres czasu.
     * @return 
     */
    public String getFormattedTimeString(){
        return getYears()+":"+getDays()+" "+getHours()+":"+getMinutes()+":"+getSeconds();
    }
        /**
     * Zwraca string opisujący okres czasu.
     * @return 
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yy:MM:dd HH:mm:ss");
    public String getSimplyFormattedTimeString(){
        return sdf.format(this.time.getTime());
    }
    /**
     * Zwraca najdłużysz okres czasu
     * @param p tablica okresów oczekiwań
     * @return najdłuższy okres oczekiwania
     */
    static public TimePeriod max(TimePeriod[] p){
        if (p.length==0) throw new IndexOutOfBoundsException("TimePeriods empty list");
        TimePeriod max = p[0];
        for (int i=1; i< p.length;i++){
            if (max.compareTo(p[i])<0){
                max = p[i];
            }
        }
        return max;
    }
        /**
     * Zwraca najdłużysz okres czasu
     * @param p Lista dynamiczna okresów oczekiwań
     * @return najdłuższy okres oczekiwania
     */
    static public TimePeriod max(List<TimePeriod> p){
        if (p.isEmpty()) throw new IndexOutOfBoundsException("TimePeriods empty list");
        Iterator<TimePeriod> it = p.iterator();
        TimePeriod max = it.next();
        for (TimePeriod temp; it.hasNext();){
            temp=it.next();
            if (max.compareTo(temp)<0){
                max = temp;
            }
        }
        return max;
    }
    
    /**
     * Zwraca najkrótszy okres czasu
     * @param p tablica okresów oczekiwań
     * @return najkrótszy okres oczekiwania
     */
    static public TimePeriod min(TimePeriod[] p){
        if (p.length==0) throw new IndexOutOfBoundsException("TimePeriods empty list");
        TimePeriod max = p[0];
        for (int i=1; i< p.length;i++){
            if (max.compareTo(p[i])>0){
                max = p[i];
            }
        }
        return max;
    }
        /**
     * Zwraca najkrótszy okres czasu
     * @param p Lista dynamiczna okresów oczekiwań
     * @return najkrótszy okres oczekiwania
     */
    static public TimePeriod min(List<TimePeriod> p){
        if (p.isEmpty()) throw new IndexOutOfBoundsException("TimePeriods empty list");
        Iterator<TimePeriod> it = p.iterator();
        TimePeriod max = it.next();
        for (TimePeriod temp; it.hasNext();){
            temp=it.next();
            if (max.compareTo(temp)>0){
                max = temp;
            }
        }
        return max;
    }
    
    
    private Calendar time;
}
