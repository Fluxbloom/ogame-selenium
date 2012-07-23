/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

/**
 *
 * @author dyschemist
 */
class TimePrefixes {

    private String prefix;

    public String getPrefix() {
        return prefix;
    }
    
    private TimePrefixes(String s) {prefix=s;}
    
    static TimePrefixes AT = new TimePrefixes("AT");
    static TimePrefixes ON = new TimePrefixes("ON");
    static TimePrefixes NW = new TimePrefixes("NW");
    static TimePrefixes IN = new TimePrefixes("IN");
           
    static int compareStringAndPrefix(String s, TimePrefixes t){
        return s.compareTo(t.getPrefix());
    }
}
