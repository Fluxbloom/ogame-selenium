/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author dyschemist
 */
public class Interpreter {
    
    SortedMap<Calendar,String> map;
    
    public Interpreter() {
    map = new TreeMap();
    }
    
    public void interpret(String[] str){
        String[] temp;
        for (int i=0; i< str.length; i++){
            temp = str[i].split(";");
            if (0==TimePrefixes.compareStringAndPrefix(temp[0].substring(0, 2), TimePrefixes.AT) ){
                System.out.println("AT");
            } else if (0==TimePrefixes.compareStringAndPrefix(temp[0].substring(0, 2), TimePrefixes.ON) ){
                System.out.println("ON"); 
            } else if (0==TimePrefixes.compareStringAndPrefix(temp[0].substring(0, 2), TimePrefixes.NW) ){
                System.out.println("NW");
            } else if (0==TimePrefixes.compareStringAndPrefix(temp[0].substring(0, 2), TimePrefixes.IN) ){
                System.out.println("IN");
            } else {
                System.out.println("NONE");
            }
            map.put(string2Calendar(temp[0]), temp[1]);
        }
    }
    static DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    static DateFormat fulldf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private Calendar string2Calendar(String s){
    return GregorianCalendar.getInstance();
    }
    private Calendar interpretTime(String str){
        
        return null;
    }
    
    private void executeCommand(String str){
        
    }
    
}
