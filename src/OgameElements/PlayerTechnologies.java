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
public class PlayerTechnologies {
    public PlayerTechnologies() {
        this.playerTechnologies = new HashMap<Technology, Integer>();
    }

    public void add(Technology s, int count) {
        if (playerTechnologies.containsKey(s)) {
            playerTechnologies.put(s, new Integer(count + ((Integer) playerTechnologies.get(s)).intValue()));
        } else {
            playerTechnologies.put(s, new Integer(count));
        }
    }
    

    public void add(Technology s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(Technology s) {
        if (playerTechnologies.containsKey(s)) {
            return ((Integer) playerTechnologies.get(s)).intValue();
        } else {
            return 0;
        }
    }

    public static String toXMLNotVisible(){
        return "<"+xmlHeader+" visible=\"false\">\n</"+xmlHeader+">\n";
    }
    
    public String toReportString(){
        String result="Technologies:\n";
        Set<Entry<Technology,Integer>> set = this.playerTechnologies.entrySet();
        Iterator<Entry<Technology,Integer>> it = set.iterator();
        Entry<Technology,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+=technology2String.get(temp.getKey())+" - "+Integer.toString(temp.getValue().intValue())+"\n";
        }
        return result;
    }
    
    public String toXML(){
        String result="<"+xmlHeader+" visible=\"true\">\n";
        Set<Entry<Technology,Integer>> set = this.playerTechnologies.entrySet();
        Iterator<Entry<Technology,Integer>> it = set.iterator();
        Entry<Technology,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+="<"+xmlDefenceHeader+" type=\""+technology2String.get(temp.getKey())+"\">"+
                    Integer.toString(temp.getValue().intValue())+"</"+xmlDefenceHeader+">\n";
        }
        result +="</"+xmlHeader+">\n";
        return result;
    }
    
    static public PlayerTechnologies parseXML(Element root){
        PlayerTechnologies buildings;
        NodeList list = root.getElementsByTagName(xmlHeader);
        Element e = (Element) list.item(0);
        if (e.getAttribute("visible").compareTo("true")==0){
            buildings = new PlayerTechnologies();
            NodeList buildingList = e.getElementsByTagName(xmlDefenceHeader);
            Element temp;
            for (int i=0; i< buildingList.getLength();i++){
                temp = (Element) buildingList.item(i);
                buildings.add(string2Technology.get(temp.getAttribute("type")), new Integer(Integer.parseInt(temp.getTextContent())));
            }
        } else {
            buildings = null;
        }
        return buildings;
    }
    
    @Override
    public String toString() {
        String fleetString = "Technologies{";

        Set<Map.Entry<Technology, Integer>> set = this.playerTechnologies.entrySet();
        Iterator<Map.Entry<Technology, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<Technology, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
                first=false;
            }
            temp = it.next();
            fleetString += temp.getKey().getName() + "-" + temp.getValue().intValue();
        }
        return fleetString + '}';
    }
    HashMap<Technology, Integer> playerTechnologies;
    
    static public String xmlHeader = "technologies";
     static public String xmlDefenceHeader = "technology";
    static public final Map<String,Technology> string2Technology = new HashMap<String,Technology>();
    static public final Map<Technology,String> technology2String = new HashMap<Technology,String>();
    static {
        technology2String.put(Technology.ASTROFIZYKA,Technology.ASTROFIZYKA.getName());
        technology2String.put(Technology.NAPED_IMPULSOWY,Technology.NAPED_IMPULSOWY.getName());
        technology2String.put(Technology.NAPED_NADPRZESTRZENNY,Technology.NAPED_NADPRZESTRZENNY.getName());
        technology2String.put(Technology.NAPED_SPALINOWY, Technology.NAPED_SPALINOWY.getName());
        technology2String.put(Technology.OPANCERZENIE, Technology.OPANCERZENIE.getName());
        technology2String.put(Technology.ROZWOJ_GRAWITONOW, Technology.ROZWOJ_GRAWITONOW.getName());
        technology2String.put(Technology.SIEC_BADAN,Technology.SIEC_BADAN.getName());
        technology2String.put(Technology.TECHNOLOGIA_BOJOWA, Technology.TECHNOLOGIA_BOJOWA.getName());
        technology2String.put(Technology.TECHNOLOGIA_ENERGETYCZNA, Technology.TECHNOLOGIA_ENERGETYCZNA.getName());
        technology2String.put(Technology.TECHNOLOGIA_JONOWA,Technology.TECHNOLOGIA_JONOWA.getName());
        technology2String.put(Technology.TECHNOLOGIA_KOMPUTEROWA,Technology.TECHNOLOGIA_KOMPUTEROWA.getName());
        technology2String.put(Technology.TECHNOLOGIA_LASEROWA,Technology.TECHNOLOGIA_LASEROWA.getName());
        technology2String.put(Technology.TECHNOLOGIA_NADPRZESTRZENNA,Technology.TECHNOLOGIA_NADPRZESTRZENNA.getName());
        technology2String.put(Technology.TECHNOLOGIA_OCHRONNA, Technology.TECHNOLOGIA_OCHRONNA.getName());
        technology2String.put(Technology.TECHNOLOGIA_PLAZMOWA, Technology.TECHNOLOGIA_PLAZMOWA.getName());
        technology2String.put(Technology.TECHNOLOGIA_SZPIEGOWSKA,Technology.TECHNOLOGIA_SZPIEGOWSKA.getName());
        
        string2Technology.put(Technology.ASTROFIZYKA.getName(),Technology.ASTROFIZYKA);
        string2Technology.put(Technology.NAPED_IMPULSOWY.getName(),Technology.NAPED_IMPULSOWY);
        string2Technology.put(Technology.NAPED_NADPRZESTRZENNY.getName(),Technology.NAPED_NADPRZESTRZENNY);
        string2Technology.put(Technology.NAPED_SPALINOWY.getName(), Technology.NAPED_SPALINOWY);
        string2Technology.put(Technology.OPANCERZENIE.getName(), Technology.OPANCERZENIE);
        string2Technology.put(Technology.ROZWOJ_GRAWITONOW.getName(), Technology.ROZWOJ_GRAWITONOW);
        string2Technology.put(Technology.SIEC_BADAN.getName(),Technology.SIEC_BADAN);
        string2Technology.put(Technology.TECHNOLOGIA_BOJOWA.getName(), Technology.TECHNOLOGIA_BOJOWA);
        string2Technology.put(Technology.TECHNOLOGIA_ENERGETYCZNA.getName(), Technology.TECHNOLOGIA_ENERGETYCZNA);
        string2Technology.put(Technology.TECHNOLOGIA_JONOWA.getName(),Technology.TECHNOLOGIA_JONOWA);
        string2Technology.put(Technology.TECHNOLOGIA_KOMPUTEROWA.getName(),Technology.TECHNOLOGIA_KOMPUTEROWA);
        string2Technology.put(Technology.TECHNOLOGIA_LASEROWA.getName(),Technology.TECHNOLOGIA_LASEROWA);
        string2Technology.put(Technology.TECHNOLOGIA_NADPRZESTRZENNA.getName(),Technology.TECHNOLOGIA_NADPRZESTRZENNA);
        string2Technology.put(Technology.TECHNOLOGIA_OCHRONNA.getName(), Technology.TECHNOLOGIA_OCHRONNA);
        string2Technology.put(Technology.TECHNOLOGIA_PLAZMOWA.getName(), Technology.TECHNOLOGIA_PLAZMOWA);
        string2Technology.put(Technology.TECHNOLOGIA_SZPIEGOWSKA.getName(),Technology.TECHNOLOGIA_SZPIEGOWSKA);

        
        
    }
}
