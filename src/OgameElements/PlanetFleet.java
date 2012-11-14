/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author dyschemist
 */
public class PlanetFleet {
    public PlanetFleet() {
        this.fleetAndDefence = new HashMap<ShipyardShips, Integer>();
    }

    public void add(ShipyardShips s, int count) {
        if (fleetAndDefence.containsKey(s)) {
            fleetAndDefence.put(s, new Integer(count + ((Integer) fleetAndDefence.get(s)).intValue()));
        } else {
            fleetAndDefence.put(s, new Integer(count));
        }
    }

    public void add(ShipyardShips s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(ShipyardShips s) {
        if (fleetAndDefence.containsKey(s)) {
            return ((Integer) fleetAndDefence.get(s)).intValue();
        } else {
            return 0;
        }
    }

    public boolean isEmpty() {
        return this.fleetAndDefence.isEmpty();
    }
    
    public static String toXMLNotVisible(){
        return "<"+xmlHeader+" visible=\"false\">\n</"+xmlHeader+">\n";
    }
    
    public String toReportString(){
        String result="Fleet:\n";
        Set<Entry<ShipyardShips,Integer>> set = this.fleetAndDefence.entrySet();
        Iterator<Entry<ShipyardShips,Integer>> it = set.iterator();
        Entry<ShipyardShips,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+=shipyardShips2String.get(temp.getKey())+" - "+Integer.toString(temp.getValue().intValue())+"\n";
        }
        return result;
    }
    
    public String toXML(){
        String result="<"+xmlHeader+" visible=\"true\">\n";
        Set<Entry<ShipyardShips,Integer>> set = this.fleetAndDefence.entrySet();
        Iterator<Entry<ShipyardShips,Integer>> it = set.iterator();
        Entry<ShipyardShips,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+="<"+xmlShipHeader+" type=\""+shipyardShips2String.get(temp.getKey())+"\">"+
                    Integer.toString(temp.getValue().intValue())+"</"+xmlShipHeader+">\n";
        }
        result +="</"+xmlHeader+">\n";
        return result;
    }
    
    static public PlanetFleet parseXML(Element root){
        PlanetFleet fleet;
        NodeList list = root.getElementsByTagName(PlanetFleet.xmlHeader);
        Element e = (Element) list.item(0);
        if (e.getAttribute("visible").compareTo("true")==0){
            fleet = new PlanetFleet();
            NodeList shipList = e.getElementsByTagName(xmlShipHeader);
            Element temp;
            for (int i=0; i< shipList.getLength();i++){
                temp = (Element) shipList.item(i);
                fleet.add(string2ShipyardShips.get(temp.getAttribute("type")), new Integer(Integer.parseInt(temp.getTextContent())));
            }
        } else {
            fleet = null;
        }
        return fleet;
    }
    
    @Override
    public String toString() {
        String fleetString = "FleetAndSatellites{";

        Set<Map.Entry<ShipyardShips, Integer>> set = this.fleetAndDefence.entrySet();
        Iterator<Map.Entry<ShipyardShips, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<ShipyardShips, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
                first=false;
            }
            temp = it.next();
            fleetString += temp.getKey().name + "-" + (temp.getValue().intValue() == Ships.ALL ? "All " : temp.getValue().intValue());
        }
        return fleetString + '}';
    }
    HashMap<ShipyardShips, Integer> fleetAndDefence;
    
     static public String xmlHeader = "fleet";
     static public String xmlShipHeader = "ship";
    static public final Map<String,ShipyardShips> string2ShipyardShips = new HashMap<String,ShipyardShips>();
    static public final Map<ShipyardShips,String> shipyardShips2String = new HashMap<ShipyardShips,String>();
    static {
        string2ShipyardShips.put(Ships.LM.getName(), Ships.LM);
        string2ShipyardShips.put( Ships.CM.getName(), Ships.CM);
        string2ShipyardShips.put(Ships.KR.getName(), Ships.KR);
        string2ShipyardShips.put(Ships.OW.getName(), Ships.OW);
        string2ShipyardShips.put(Ships.BOMB.getName(), Ships.BOMB);
        string2ShipyardShips.put(Ships.PAN.getName(), Ships.PAN);
        string2ShipyardShips.put(Ships.NISZ.getName(),Ships.NISZ);
        string2ShipyardShips.put(Ships.GS.getName(), Ships.GS);
        string2ShipyardShips.put(Ships.MT.getName(), Ships.MT);
        string2ShipyardShips.put(Ships.DT.getName(),Ships.DT);
        string2ShipyardShips.put(Ships.KOL.getName(), Ships.KOL);
        string2ShipyardShips.put(Ships.REC.getName(), Ships.REC);
        string2ShipyardShips.put(ShipyardShips.SAT.getName(), ShipyardShips.SAT);
        string2ShipyardShips.put(Ships.SOND.getName(), Ships.SOND);
        shipyardShips2String.put(Ships.LM,Ships.LM.getName());
        shipyardShips2String.put(Ships.CM,Ships.CM.getName());
        shipyardShips2String.put(Ships.KR,Ships.KR.getName());
        shipyardShips2String.put(Ships.OW,Ships.OW.getName());
        shipyardShips2String.put(Ships.BOMB,Ships.BOMB.getName());
        shipyardShips2String.put(Ships.PAN,Ships.PAN.getName());
        shipyardShips2String.put(Ships.NISZ,Ships.NISZ.getName());
        shipyardShips2String.put(Ships.GS,Ships.GS.getName());
        shipyardShips2String.put(Ships.MT,Ships.MT.getName());
        shipyardShips2String.put(Ships.DT,Ships.DT.getName());
        shipyardShips2String.put(Ships.KOL,Ships.KOL.getName());
        shipyardShips2String.put(Ships.REC,Ships.REC.getName());
        shipyardShips2String.put(ShipyardShips.SAT,ShipyardShips.SAT.getName());
        shipyardShips2String.put(Ships.SOND,Ships.SOND.getName());
    }
}
