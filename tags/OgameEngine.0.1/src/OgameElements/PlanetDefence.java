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
public class PlanetDefence {
      public PlanetDefence() {
        this.planetDefence = new HashMap<Defence, Integer>();
    }

    public void add(Defence s, int count) {
        if (planetDefence.containsKey(s)) {
            planetDefence.put(s, new Integer(count + ((Integer) planetDefence.get(s)).intValue()));
        } else {
            planetDefence.put(s, new Integer(count));
        }
    }
    

    public void add(Defence s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(Defence s) {
        if (planetDefence.containsKey(s)) {
            return ((Integer) planetDefence.get(s)).intValue();
        } else {
            return 0;
        }
    }

    public static String toXMLNotVisible(){
        return "<"+xmlHeader+" visible=\"false\">\n</"+xmlHeader+">\n";
    }
    
    public String toReportString(){
        String result="Defence:\n";
        Set<Entry<Defence,Integer>> set = this.planetDefence.entrySet();
        Iterator<Entry<Defence,Integer>> it = set.iterator();
        Entry<Defence,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+=defence2String.get(temp.getKey())+" - "+Integer.toString(temp.getValue().intValue())+"\n";
        }
        return result;
    }
    
    public String toXML(){
        String result="<"+xmlHeader+" visible=\"true\">\n";
        Set<Entry<Defence,Integer>> set = this.planetDefence.entrySet();
        Iterator<Entry<Defence,Integer>> it = set.iterator();
        Entry<Defence,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+="<"+xmlDefenceHeader+" type=\""+defence2String.get(temp.getKey())+"\">"+
                    Integer.toString(temp.getValue().intValue())+"</"+xmlDefenceHeader+">\n";
        }
        result +="</"+xmlHeader+">\n";
        return result;
    }
    
    static public PlanetDefence parseXML(Element root){
        PlanetDefence defence;
        NodeList list = root.getElementsByTagName(xmlHeader);
        Element e = (Element) list.item(0);
        if (e.getAttribute("visible").compareTo("true")==0){
            defence = new PlanetDefence();
            NodeList defenceList = e.getElementsByTagName(xmlDefenceHeader);
            Element temp;
            for (int i=0; i< defenceList.getLength();i++){
                temp = (Element) defenceList.item(i);
                defence.add(string2Defence.get(temp.getAttribute("type")), new Integer(Integer.parseInt(temp.getTextContent())));
            }
        } else {
            defence = null;
        }
        return defence;
    }
    
    @Override
    public String toString() {
        String fleetString = "Defence{";

        Set<Map.Entry<Defence, Integer>> set = this.planetDefence.entrySet();
        Iterator<Map.Entry<Defence, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<Defence, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
                first = false;
            }
            temp = it.next();
            fleetString += temp.getKey().name + "-" + temp.getValue().intValue();
        }
        return fleetString + '}';
    }
    HashMap<Defence, Integer> planetDefence;
    
    static public String xmlHeader = "defence";
     static public String xmlDefenceHeader = "gun";
    static public final Map<String,Defence> string2Defence = new HashMap<String,Defence>();
    static public final Map<Defence,String> defence2String = new HashMap<Defence,String>();
    static {
        string2Defence.put(Defence.DUZA_POWLOKA.name, Defence.DUZA_POWLOKA);
        string2Defence.put(Defence.DUZY_LASER.name, Defence.DUZY_LASER);
        string2Defence.put(Defence.DZIALO_GAUSSA.name, Defence.DZIALO_GAUSSA);
        string2Defence.put(Defence.DZIALO_JONOWE.name, Defence.DZIALO_JONOWE);
        string2Defence.put(Defence.MALA_POWLOKA.name, Defence.MALA_POWLOKA);
        string2Defence.put(Defence.MALY_LASER.name, Defence.MALY_LASER);
        string2Defence.put(Defence.PRZECIWRAKIETA.name,Defence.PRZECIWRAKIETA);
        string2Defence.put(Defence.RAKITA_MIEDZYPLANETARNA.name, Defence.RAKITA_MIEDZYPLANETARNA);
        string2Defence.put(Defence.WYRZUTNIA_PLAZMY.name, Defence.WYRZUTNIA_PLAZMY);
        string2Defence.put(Defence.WYRZUTNIA_RAKIET.name,Defence.WYRZUTNIA_RAKIET);
        
        defence2String.put(Defence.DUZA_POWLOKA,Defence.DUZA_POWLOKA.name);
        defence2String.put(Defence.DUZY_LASER,Defence.DUZY_LASER.name);
        defence2String.put(Defence.DZIALO_GAUSSA,Defence.DZIALO_GAUSSA.name);
        defence2String.put(Defence.DZIALO_JONOWE, Defence.DZIALO_JONOWE.name);
        defence2String.put(Defence.MALA_POWLOKA, Defence.MALA_POWLOKA.name);
        defence2String.put(Defence.MALY_LASER, Defence.MALY_LASER.name);
        defence2String.put(Defence.PRZECIWRAKIETA,Defence.PRZECIWRAKIETA.name);
        defence2String.put(Defence.RAKITA_MIEDZYPLANETARNA, Defence.RAKITA_MIEDZYPLANETARNA.name);
        defence2String.put(Defence.WYRZUTNIA_PLAZMY, Defence.WYRZUTNIA_PLAZMY.name);
        defence2String.put(Defence.WYRZUTNIA_RAKIET,Defence.WYRZUTNIA_RAKIET.name);
    }
}
