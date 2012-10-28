/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameParsingException;

/**
 * Klasa utworzona do pomocy w zarządzaniu czasami
 * @author Piotr Kowalski
 */
public class TimePeriodParser {

    /**
     * Konstruktor z parametrami do parsowania
     * @param week oznaczenie dla tygodnia w parsowaniu
     * @param day oznaczenia dla dnia w parsowaniu
     * @param hour oznaczenie dla godziny w parsowaniu
     * @param minute oznaczenie dla minuty w parsowaniu
     * @param second oznaczenie dla sekund w parsowaniu
     */
    public TimePeriodParser(String week, String day, String hour, String minute, String second) {
        this.week = week;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    /**
     * Konstruktor dla klas pochodnych
     */
    protected TimePeriodParser(){
        
    }
    
    /**
     * Funkcja parsująca string
     * @param s String parsowany
     * @return Obiekt Kalendarza stanowiący różnicę czasów 
     */
    public TimePeriod parse(String s) throws OgameParsingException {
        int weeks = 0, days = 0, hours = 0, minutes = 0, seconds = 0;
        String[] str;
        // week
        if (s.contains(week)) {
            str = s.split(week);
            weeks = Integer.parseInt(str[0].replace(" ", ""));
            s = str.length > 1 ? str[1] : "";
        }
        // day
        if (s.contains(day)) {
            str = s.split(day);
            days = Integer.parseInt(str[0].replace(" ", ""));
            s = str.length > 1 ? str[1] : "";
        }
        //hour 
        if (s.contains(hour)) {
            str = s.split(hour);
            hours = Integer.parseInt(str[0].replace(" ", ""));
            s = str.length > 1 ? str[1] : "";
        }
        //minute 
        if (s.contains(minute)) {
            str = s.split(minute);
            minutes = Integer.parseInt(str[0].replace(" ", ""));
            s = str.length > 1 ? str[1] : "";
        }
        // second
        if (s.contains(second)) {
            str = s.split(second);
            seconds = Integer.parseInt(str[0].replace(" ", ""));
            s = str.length > 1 ? str[1] : "";
        }
        if (weeks==0 && days ==0 && hours==0 && minutes ==0 && seconds ==0)
            throw new OgameParsingException("Time period parsing of "+s);
        return new TimePeriod(weeks,days,hours,minutes,seconds);
    }
    private String week;
    private String day;
    private String hour;
    private String minute;
    private String second;
}
