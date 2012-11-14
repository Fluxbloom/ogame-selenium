/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author dyschemist
 */
public class  ShipyardShips extends ShipyardProduct{
    
    protected ShipyardShips(String name){this.name=name;}
        public static final Ships LM = Ships.LM;//1
    public static final Ships CM = Ships.CM;//2
    public static final Ships KR = Ships.DT;//3
    public static final Ships OW = Ships.OW;//4
    public static final Ships PAN= Ships.PAN;//5
    public static final Ships BOMB = Ships.BOMB;//6
    public static final Ships NISZ = Ships.NISZ;//7
    public static final Ships GS = Ships.GS;//8
    public static final Ships MT = Ships.MT;//9
    public static final Ships DT= Ships.DT;//10
    public static final Ships KOL = Ships.KOL;//11
    public static final Ships REC = Ships.REC;//12
    public static final Ships SOND = Ships.SOND;//13

    public static final ShipyardShips SAT = new ShipyardShips("SAT");
    
}
