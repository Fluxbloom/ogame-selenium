/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import java.util.Calendar;
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
            map.put(string2Calendar(temp[0]), temp[1]);
        }
    }
    private Calendar string2Calendar(String s){
    return null;
    }
    private Calendar interpretTime(String str){
        
        return null;
    }
    
    private void executeCommand(String str){
        
    }
    
}
