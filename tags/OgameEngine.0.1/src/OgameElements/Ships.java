/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author dyschemist
 */
public final class Ships extends ShipyardShips {
    
    private Ships(String name){
        super(name);
    }
    public static final Ships LM = new Ships("LM");//1
    public static final Ships CM = new Ships("CM");//2
    public static final Ships KR = new Ships("KR");//3
    public static final Ships OW = new Ships("OW");//4
    public static final Ships PAN= new Ships("PAN");//5
    public static final Ships BOMB = new Ships("BOMB");//6
    public static final Ships NISZ = new Ships("NISZ");//7
    public static final Ships GS = new Ships("GS");//8
    public static final Ships MT = new Ships("MT");//9
    public static final Ships DT= new Ships("DT");//10
    public static final Ships KOL = new Ships("KOL");//11
    public static final Ships REC = new Ships("REC");//12
    public static final Ships SOND = new Ships("SS");//13

    public static final Integer ALL = -1;
}
