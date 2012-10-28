/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameParsingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa tworzy parser dla obiektów czasów
 * @author Piotr Kowalski
 */
public class TimeParser {
    // TODO przerobić komentarz w tabelkę
    /**
     * Konstruktor domyślny oparty o string formatu zgodny  SimpleDateFormat
     * Letter   Date or Time Component   Presentation       Examples
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

     * @param pattern 
     */
    public TimeParser(String pattern) {
        format = new SimpleDateFormat(pattern);
    }
    /**
     * Tworzy obiekt Time z stringa z czasem
     * @param string string do parsowania
     * @return obiekt Time z sparsowanym czasem
     * @throws OgameParsingException błąð parsowania
     */
    public Time parse(String string) throws OgameParsingException{
        Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(string));
        } catch (ParseException ex) {
            logger.log(Level.SEVERE, "Parsing error: {0}", string);
            throw new OgameParsingException(ex.getMessage());
        }
        return new Time(cal);
    }
    /**
     * Formatuje obiket Time do postaci Stringa
     * @param t obiekt czasu
     * @return String z sformatowanym czasem
     */
    public String format(Time t){
        Calendar cal = t.getTime();
        return format.format(cal.getTime());
    }
    

    private SimpleDateFormat format;
    
    private static final Logger logger = Logger.getLogger(TimeParser.class.getName());
}
