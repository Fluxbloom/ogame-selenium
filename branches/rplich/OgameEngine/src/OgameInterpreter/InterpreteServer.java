/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import OgameEngine.OgameException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author plich
 */
public class InterpreteServer implements Runnable {

    public InterpreteServer() throws OgameException {
        queue = new HashMap<Calendar, String>();
        interpreter = new Interpreter();
    }

    public void add(Calendar cal, String command) {
        System.err.println("Add");
        synchronized (this) {
            queue.put(cal, command);
        }
    }

    private void execute() {
        Calendar now = new GregorianCalendar();
        System.err.println("Execute "+sdf.format(now.getTime()));
        System.err.println("Echo "+this.toString());
        if( queue.isEmpty()) return;
        System.err.println("Proceed");
        
        Set<Entry<Calendar, String>> set = queue.entrySet();
        Entry<Calendar, String> temp;
        for (Iterator<Entry<Calendar, String>> iter = set.iterator(); iter.hasNext();) {
            temp = iter.next();
            if (temp.getKey().before(now)) {
                try {
                    System.err.println("Interpret");
                    System.err.println(temp.getValue());
                    interpreter.interpret(temp.getValue());
                    queue.remove(temp.getKey());
                } catch (OgameException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
    
    public List<String> getQueue(){
        List<String> list = new ArrayList<String>();
        Set<Entry<Calendar, String>> set = queue.entrySet();
        Entry<Calendar, String> temp;
        for (Iterator<Entry<Calendar, String>> iter = set.iterator(); iter.hasNext();) {
            temp = iter.next();
            list.add(sdf.format(temp.getKey().getTime())+";"+temp.getValue());
        }
        return list;
    }

    @Override
    public String toString() {
        String s = "InterpreteServer{";
        String temp;
        List<String> list = this.getQueue();
        for (Iterator<String> iter = list.iterator();iter.hasNext();){
            temp = iter.next();
            s += temp+";";
        }
        return s + '}';
    }
    
    public void close(){
        this.run=false;
    }

    @Override
    public void run() {
        System.err.println("RUN!!!");
        while (this.run) {
            System.err.println("RUN!!!");
            
            synchronized (this) {
                try {
                execute();
                } catch (Exception ex){
                    System.err.println(ex.getMessage());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("INTERRRUPTED");
            }
        }
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yy:MM:dd HH:mm:ss");
    public void parse(String commandAndTime) throws ParseException{
        String sep = ";";
        String[] separated = commandAndTime.split(sep);
        
        Calendar cal = new GregorianCalendar();
        cal.setTime(sdf.parse(separated[0]));
        this.add(cal, separated[1]);
    }
    
    private Interpreter interpreter;
    private Map<Calendar, String> queue;
    private boolean run = true;
}
