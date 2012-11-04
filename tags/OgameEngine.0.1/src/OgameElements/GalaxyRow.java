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
    
    public GalaxyRow(Coords coord, GalaxyStatus status, String name, GalaxyStatus moon, GalaxyStatus debris, String playerName,List<PlayerActivityStatuses> statuses, String ally) {
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
        Iterator<PlayerActivityStatuses> it = this.statuses.iterator();
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
    List<PlayerActivityStatuses> statuses = new ArrayList<PlayerActivityStatuses>();
    private String ally;
    
    static public final GalaxyStatus EMPTY = GalaxyStatus.EMPTY;
    static public final GalaxyStatus NO_ACTIVITY = GalaxyStatus.NO_ACTIVITY;
    static public final GalaxyStatus ACTIVITY = GalaxyStatus.ACTIVITY;
    
    static public final PlayerActivityStatuses INACTIVE = PlayerActivityStatuses.INACTIVE;
    static public final PlayerActivityStatuses LONG_INACTIVE = PlayerActivityStatuses.LONG_INACTIVE;
    static public final PlayerActivityStatuses VACATION = PlayerActivityStatuses.VACATION;
    static public final PlayerActivityStatuses NOOB = PlayerActivityStatuses.NOOB;
    static public final PlayerActivityStatuses STRONG = PlayerActivityStatuses.STRONG;
    static public final PlayerActivityStatuses OUTLAW = PlayerActivityStatuses.OUTLAW;
    static public final PlayerActivityStatuses BANNED = PlayerActivityStatuses.BANNED;
    static public final PlayerActivityStatuses HONOUR = PlayerActivityStatuses.HONOUR;
    static public final PlayerActivityStatuses STARLORD = PlayerActivityStatuses.STARLORD;
    static public final PlayerActivityStatuses BANDIT = PlayerActivityStatuses.BANDIT;
    static public final PlayerActivityStatuses NORMAL = PlayerActivityStatuses.NORMAL;
    
    
    
    
    
   
    
}
