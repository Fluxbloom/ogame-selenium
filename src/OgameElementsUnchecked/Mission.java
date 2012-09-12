/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElementsUnchecked;


/**
 *
 * @author dyschemist
 */
public class Mission {
    private String name;
    private String acsCode;
    private int time;
    private Mission(String name){  this.name=name;
    acsCode="";
    time=0;}
    
    public static final Mission EXPLORE =new Mission("EXPLORE");
    public static final Mission KOLONIZE=new Mission("COLONIZE");
    public static final Mission RECYCLE =new Mission("RECYCLE");
    public static final Mission TRANSPORT=new Mission("TRANSPORT");
    public static final Mission STATION=new Mission("STATION");
    public static final Mission SPY=new Mission("SPY");
    public static final Mission STAY=new Mission("STAY");
    public static final Mission ATTACK=new Mission("ATTACK");
    public static final Mission ACS=new Mission("ACS");
    public static final Mission MOON_DESTRUCTION=new Mission("MOON");

    @Override
    public String toString() {
        return "Mission{" + "name=" + name + '}';
    }

    public String getName() {
        return name;
    }
    
    
    
    public Mission setACSCode(String s){
        this.acsCode=s;
        return this;
    }
    
    public Mission setTime(int t){
        this.time = t;
        return this;
    }
    
    public String getACSCode(){
        String code = this.acsCode;
        this.acsCode="";
        return code;
    }
    
    public String getTime(){
        if (Mission.STAY==this || Mission.EXPLORE==this){
        String stime = Integer.toString(this.time);
        this.time=1;
        return stime;
        } else {
            return "0";
        }
    }
    
}
