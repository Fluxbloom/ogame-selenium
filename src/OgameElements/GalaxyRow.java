/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa ma oddawać skład wiersza w podglądzie galaktyki
 * @author Piotr Kowalski
 */
public class GalaxyRow implements Comparable{

    public GalaxyRow(Coords coord, GalaxyStatus status, String name, GalaxyStatus moon, GalaxyStatus debris, String playerName, String ally) {
        this.coord = coord;
        this.status = status;
        this.name = name;
        this.moon = moon;
        this.debris = debris;
        this.playerName = playerName;
        this.ally = ally;
    }
    
    public GalaxyRow(Coords coord, GalaxyStatus status, String name, GalaxyStatus moon, GalaxyStatus debris, String playerName,List<PlayerStatuses> statuses, String ally) {
        this.coord = coord;
        this.status = status;
        this.name = name;
        this.moon = moon;
        this.debris = debris;
        this.playerName = playerName;
        this.statuses = statuses;
        this.ally = ally;
    }

    public boolean isInactive(){
        if (this.statuses.contains(GalaxyRow.VACATION)){
            return false;
        }else if(this.statuses.contains(GalaxyRow.INACTIVE) || this.statuses.contains(GalaxyRow.LONG_INACTIVE)){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEmpty(){
        return this.status==GalaxyRow.EMPTY?true:false;
    }
    
    public Coords getCoord() {
        return coord;
    }

    
    
    @Override
    public String toString() {
        String s;
        try {
            s = coord.shortPrint();
        } catch (Exception ex){
            s= coord.toString();
        }
        Iterator<PlayerStatuses> it = this.statuses.iterator();
        String st = "{";
        while(it.hasNext()){
            st+=it.next().print();
        }
        st+="}";
        return "GR{" + "C=" + s + ",Stat=" + status + ",Name=" + name + ",M=" + moon + ",D=" + debris + ",Player=" + playerName + ", S=" + statuses + ", ally=" + ally + '}';
    }

    @Override
    public int compareTo(Object arg0) {
        GalaxyRow gr = (GalaxyRow) arg0;
        return this.coord.compareTo(gr.coord);
    }

    

    private Coords coord;
    private GalaxyStatus status;
    private String name;
    private GalaxyStatus moon;
    private GalaxyStatus debris;
    private String playerName;
    List<PlayerStatuses> statuses = new ArrayList<PlayerStatuses>();
    private String ally;
    
    static public final GalaxyStatus EMPTY = new GalaxyStatus("Empty");
    static public final GalaxyStatus NO_ACTIVITY = new GalaxyStatus("no activity");
    static public final GalaxyStatus ACTIVITY = new GalaxyStatus("activity");
    
    static public final PlayerStatuses INACTIVE = new PlayerStatuses("i");
    static public final PlayerStatuses LONG_INACTIVE = new PlayerStatuses("I");
    static public final PlayerStatuses VACATION = new PlayerStatuses("u");
    static public final PlayerStatuses NOOB = new PlayerStatuses("s");
    static public final PlayerStatuses OUTLAW = new PlayerStatuses("o");
    static public final PlayerStatuses BANNED = new PlayerStatuses("g");
    static public final PlayerStatuses HONOUR = new PlayerStatuses("ph");
    static public final PlayerStatuses STARLORD = new PlayerStatuses("starl");
    static public final PlayerStatuses BANDIT = new PlayerStatuses("bandit");
    static public final PlayerStatuses NORMAL = new PlayerStatuses("n");
    
    
    static public class GalaxyStatus {
        protected GalaxyStatus(String name){
            this.name=name;
        }
        
        private String name;

        @Override
        public String toString() {
            return "GS{" + "name=" + name + '}';
        }
    }
    static public class GalaxyStatusMinutes extends GalaxyStatus {

        public GalaxyStatusMinutes(int minutes) {
            super("minutes");
            this.minutes=minutes;
        }

        public int getMinutes() {
            return minutes;
        }

        @Override
        public String toString() {
            return "GSM{" + "minutes=" + minutes + '}';
        }

        private int minutes;
    }
    
    static public class PlayerStatuses {
        protected PlayerStatuses(String status){
            this.status=status;
        }

        @Override
        public String toString() {
            return "PlayerStatuses{" + "status=" + status + '}';
        }
        
        public String print(){
            return "("+status+")";
        }
        
        
        
        private String status;
    }
    
}
