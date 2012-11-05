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
 * @author Piotr Kowalski
 */
public class PlanetBuildings {
    public PlanetBuildings() {
        this.planetDefence = new HashMap<Buildings, Integer>();
    }

    public void add(Buildings s, int count) {
        if (planetDefence.containsKey(s)) {
            planetDefence.put(s, new Integer(count + ((Integer) planetDefence.get(s)).intValue()));
        } else {
            planetDefence.put(s, new Integer(count));
        }
    }
    

    public void add(Buildings s, String str) {
        add(s, Integer.parseInt(str));
    }

    public int get(Buildings s) {
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
        String result="Buildings:\n";
        Set<Entry<Buildings,Integer>> set = this.planetDefence.entrySet();
        Iterator<Entry<Buildings,Integer>> it = set.iterator();
        Entry<Buildings,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+=buildings2String.get(temp.getKey())+" - "+Integer.toString(temp.getValue().intValue())+"\n";
        }
        return result;
    }
    
    public String toXML(){
        String result="<"+xmlHeader+" visible=\"true\">\n";
        Set<Entry<Buildings,Integer>> set = this.planetDefence.entrySet();
        Iterator<Entry<Buildings,Integer>> it = set.iterator();
        Entry<Buildings,Integer> temp;
        while(it.hasNext()){
            temp = it.next();
            result+="<"+xmlDefenceHeader+" type=\""+buildings2String.get(temp.getKey())+"\">"+
                    Integer.toString(temp.getValue().intValue())+"</"+xmlDefenceHeader+">\n";
        }
        result +="</"+xmlHeader+">\n";
        return result;
    }
    
    static public PlanetBuildings parseXML(Element root){
        PlanetBuildings buildings;
        NodeList list = root.getElementsByTagName(xmlHeader);
        Element e = (Element) list.item(0);
        if (e.getAttribute("visible").compareTo("true")==0){
            buildings = new PlanetBuildings();
            NodeList buildingList = e.getElementsByTagName(xmlDefenceHeader);
            Element temp;
            for (int i=0; i< buildingList.getLength();i++){
                temp = (Element) buildingList.item(i);
                buildings.add(string2Buildings.get(temp.getAttribute("type")), new Integer(Integer.parseInt(temp.getTextContent())));
            }
        } else {
            buildings = null;
        }
        return buildings;
    }
    
    @Override
    public String toString() {
        String fleetString = "Buildings{";

        Set<Map.Entry<Buildings, Integer>> set = this.planetDefence.entrySet();
        Iterator<Map.Entry<Buildings, Integer>> it = set.iterator();
        boolean first = true;
        for (Map.Entry<Buildings, Integer> temp; it.hasNext();) {
            if (!first) {
                fleetString += ";";
                first=false;
            }
            temp = it.next();
            fleetString += temp.getKey().getName() + "-" + temp.getValue().intValue();
        }
        return fleetString + '}';
    }
    HashMap<Buildings, Integer> planetDefence;
    
    static public String xmlHeader = "buildings";
     static public String xmlDefenceHeader = "building";
    static public final Map<String,Buildings> string2Buildings = new HashMap<String,Buildings>();
    static public final Map<Buildings,String> buildings2String = new HashMap<Buildings,String>();
    static {
        buildings2String.put(Buildings.METAL_MINE,Buildings.METAL_MINE.getName());
        buildings2String.put(Buildings.CRYSTAL_MINE,Buildings.CRYSTAL_MINE.getName());
        buildings2String.put(Buildings.DEUTERIUM_EXTRACTOR,Buildings.DEUTERIUM_EXTRACTOR.getName());
        buildings2String.put(Buildings.METAL_STORAGE, Buildings.METAL_STORAGE.getName());
        buildings2String.put(Buildings.CRYSTAL_STORAGE, Buildings.CRYSTAL_STORAGE.getName());
        buildings2String.put(Buildings.DEUTERIUM_STORAGE, Buildings.DEUTERIUM_STORAGE.getName());
        buildings2String.put(Buildings.METAL_HIDEOUT,Buildings.METAL_HIDEOUT.getName());
        buildings2String.put(Buildings.CRYSTAL_HIDEOUT, Buildings.CRYSTAL_HIDEOUT.getName());
        buildings2String.put(Buildings.DEUTERIUM_HIDEOUT, Buildings.DEUTERIUM_HIDEOUT.getName());
        buildings2String.put(Buildings.SOLAR_POWER_PLANT,Buildings.SOLAR_POWER_PLANT.getName());
        buildings2String.put(Buildings.FUSSION_POWER_PLANT,Buildings.FUSSION_POWER_PLANT.getName());
        buildings2String.put(Buildings.MANUFACTURE_OF_ROBOTS,Buildings.MANUFACTURE_OF_ROBOTS.getName());
        buildings2String.put(Buildings.MANUFACTURE_OF_NANITAS,Buildings.MANUFACTURE_OF_NANITAS.getName());
        buildings2String.put(Buildings.LABORATORY, Buildings.LABORATORY.getName());
        buildings2String.put(Buildings.MISSILE_SILO, Buildings.MISSILE_SILO.getName());
        buildings2String.put(Buildings.SHIPYARD, Buildings.SHIPYARD.getName());
        buildings2String.put(Buildings.TERRAFORMER,Buildings.TERRAFORMER.getName());
        buildings2String.put(Buildings.MOON_FALANG, Buildings.MOON_FALANG.getName());
        buildings2String.put(Buildings.MOON_ROBOTS, Buildings.MOON_ROBOTS.getName());
        buildings2String.put(Buildings.MOON_SHIPYARD,Buildings.MOON_SHIPYARD.getName());
        
        string2Buildings.put(Buildings.METAL_MINE.getName(),Buildings.METAL_MINE);
        string2Buildings.put(Buildings.CRYSTAL_MINE.getName(),Buildings.CRYSTAL_MINE);
        string2Buildings.put(Buildings.DEUTERIUM_EXTRACTOR.getName(),Buildings.DEUTERIUM_EXTRACTOR);
        string2Buildings.put(Buildings.METAL_STORAGE.getName(), Buildings.METAL_STORAGE);
        string2Buildings.put(Buildings.CRYSTAL_STORAGE.getName(), Buildings.CRYSTAL_STORAGE);
        string2Buildings.put(Buildings.DEUTERIUM_STORAGE.getName(), Buildings.DEUTERIUM_STORAGE);
        string2Buildings.put(Buildings.METAL_HIDEOUT.getName(),Buildings.METAL_HIDEOUT);
        string2Buildings.put(Buildings.CRYSTAL_HIDEOUT.getName(), Buildings.CRYSTAL_HIDEOUT);
        string2Buildings.put(Buildings.DEUTERIUM_HIDEOUT.getName(), Buildings.DEUTERIUM_HIDEOUT);
        string2Buildings.put(Buildings.SOLAR_POWER_PLANT.getName(),Buildings.SOLAR_POWER_PLANT);
        string2Buildings.put(Buildings.FUSSION_POWER_PLANT.getName(),Buildings.FUSSION_POWER_PLANT);
        string2Buildings.put(Buildings.MANUFACTURE_OF_ROBOTS.getName(),Buildings.MANUFACTURE_OF_ROBOTS);
        string2Buildings.put(Buildings.MANUFACTURE_OF_NANITAS.getName(),Buildings.MANUFACTURE_OF_NANITAS);
        string2Buildings.put(Buildings.LABORATORY.getName(), Buildings.LABORATORY);
        string2Buildings.put(Buildings.MISSILE_SILO.getName(), Buildings.MISSILE_SILO);
        string2Buildings.put(Buildings.SHIPYARD.getName(), Buildings.SHIPYARD);
        string2Buildings.put(Buildings.TERRAFORMER.getName(),Buildings.TERRAFORMER);
        string2Buildings.put(Buildings.MOON_FALANG.getName(), Buildings.MOON_FALANG);
        string2Buildings.put(Buildings.MOON_ROBOTS.getName(), Buildings.MOON_ROBOTS);
        string2Buildings.put(Buildings.MOON_SHIPYARD.getName(),Buildings.MOON_SHIPYARD);

        
        
    }
}
