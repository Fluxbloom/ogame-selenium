/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameParsingError;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa pozwala na parsowanie prostych Stringów do postaci TimePeriod
 * @author Piotr Kowalski
 */
public class SimpleTimePeriodParser extends TimePeriodParser {
    // TODO przerobić na tabele html
    /**
     * Konstruktor prostego parsera TimePeriod
     * Obsługuje on jedynie stało pozycyjne parsowania tak jak SimpleDateFormat
     * * Letter   Date or Time Component   Presentation       Examples
G        Era designator             Text                AD
y        Year                       Year                1996;    96
M        Month in year               Month               July; Jul; 07
w        Week in year               Number               27
W        Week in month               Number               2
D        Day in year               Number               189
d        Day in month               Number               10
F        Day of week in month       Number               2
E        Day in week               Text               Tuesday; Tue
a        Am/pm marker               Text               PM
H        Hour in day (0-23)       Number               0
k        Hour in day (1-24)       Number               24
K        Hour in am/pm (0-11)       Number               0
h        Hour in am/pm (1-12)       Number               12
m        Minute in hour           Number               30
s        Second in minute           Number               55
S        Millisecond                Number               978
z        Time zone                   General time zone   Pacific Standard Time; PST; GMT-08:00
Z        Time zone                  RFC 822 time zone   -0800

     * @param pattern String z wzorcem
     */
    public SimpleTimePeriodParser(String pattern) {
        this.format=new SimpleDateFormat(pattern);
    }
    /**
     * Nadpisanie metody parsowania
     * @param s String do parsowania
     * @return sparsowany obiekt TimePeriod
     * @throws OgameParsingError błąd parsowania
     */
    @Override
    public TimePeriod parse(String s) throws OgameParsingError {
        
        try {
            return new TimePeriod(format.parse(s) );
        } catch (ParseException ex) {
            throw new OgameParsingError(s+" vs pattern ="+pattern);
        }
    }
    
    
    
    
    private SimpleDateFormat format;
    private String pattern;
}
