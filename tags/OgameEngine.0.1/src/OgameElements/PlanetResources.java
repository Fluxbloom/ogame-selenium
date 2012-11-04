/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameResourceParsingException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Michał Dróżdż & Piotr Kowalski
 */
public class PlanetResources extends Resources {
   
    private int energy;
   
    public PlanetResources (int metal, int cristal, int deuter, int energy){
        super(metal,cristal,deuter);
        this.energy=energy;
    }

    public PlanetResources(String metal, String cristal, String deuter, String energy){
        this(Integer.parseInt(metal),Integer.parseInt(cristal),Integer.parseInt(deuter),Integer.parseInt(energy));
    }
    
    public int getEnergy() {
        return energy;
    }

    public String toXML(){
        String result ="<"+PlanetResources.xmlHeader+">\n";
        result+="<"+PlanetResources.xmlMetalHeader+">"+this.metal+"</"+PlanetResources.xmlMetalHeader+">\n";
        result+="<"+PlanetResources.xmlCrystalHeader+">"+this.crystal+"</"+PlanetResources.xmlCrystalHeader+">\n";
        result+="<"+PlanetResources.xmlDeuteriumHeader+">"+this.deuterium+"</"+PlanetResources.xmlDeuteriumHeader+">\n";
        result+="<"+PlanetResources.xmlEnergyHeader+">"+this.energy+"</"+PlanetResources.xmlEnergyHeader+">\n";
        result+="</"+PlanetResources.xmlHeader+">\n";
        return result;             
    }
    
    static public PlanetResources parseXML(Element root) throws OgameResourceParsingException{
        PlanetResources resource=null;
        NodeList resources = root.getElementsByTagName(PlanetResources.xmlHeader);
        Node temp;
        NodeList field;
        Node innerTemp;
        int metal=0,crystal=0,deuterium=0,energy=0;
        if (resources.getLength()>0){
            temp = resources.item(0); 
            // odczyt metal
            field = temp.getChildNodes();
            for (int i =0; i< field.getLength();i++){
                innerTemp = field.item(i);
                if (innerTemp.getNodeName().compareTo(xmlMetalHeader)==0){
                    metal = Integer.parseInt(innerTemp.getTextContent());
                } else if (innerTemp.getNodeName().compareTo(xmlCrystalHeader)==0){
                   crystal = Integer.parseInt(innerTemp.getTextContent());
                } else if (innerTemp.getNodeName().compareTo(xmlDeuteriumHeader)==0){
                   deuterium = Integer.parseInt(innerTemp.getTextContent());
                } else if (innerTemp.getNodeName().compareTo(xmlEnergyHeader)==0){
                   energy = Integer.parseInt(innerTemp.getTextContent());
                }
            }
            resource = new PlanetResources(metal,crystal,deuterium,energy);
        }
        if (resource==null) throw new OgameResourceParsingException();
        return resource;
    }
    
    @Override
    public String toString() {
        return "PlanetResources{" + "metal=" + metal + ", crystal=" + crystal + ", deuter=" + deuterium +", energy=" + energy + '}';
    }

    public boolean isSufficient(PlanetResources needed){
        if (metal<needed.metal) return false;
        if (crystal<needed.crystal) return false;
        if (deuterium<needed.deuterium) return false;
        if (needed.energy>0 && energy<needed.energy) return false;
        return true;
    }
   
    static public String xmlHeader = "resources";
    static public String xmlMetalHeader = "metal";
    static public String xmlCrystalHeader = "crystal";
    static public String xmlDeuteriumHeader = "deuterium";
    static public String xmlEnergyHeader = "energy";
}

