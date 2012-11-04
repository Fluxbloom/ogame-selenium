/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.NodeList;

/**
 * Klasa oddaje statusy aktywności w podglądzie galaktyki
 * @author Piotr Kowalski
 */
public class GalaxyStatus {

    protected GalaxyStatus(String name) {
        this.name = name;
    }
    private String name;

    public String reportPrint(){
        return name;
    }
    
    @Override
    public String toString() {
        return "GS{" + "name=" + name + '}';
    }

    public boolean isMinutes(){
        if (this.getClass().getName().compareTo(GalaxyStatusMinutes.class.getName())==0){
            return true;
        }
        else return false;
    }
    
    public String toXML() {
        String result = "<" + xmlHeader +" "+xmlMinutesAtribute+"=\"false\">";
        result += this.name;
        result += "</"+xmlHeader+">\n";
        return result;
    }

    static public GalaxyStatus parseXML(Element root) {
        GalaxyStatus gx = null;
        NodeList list = root.getElementsByTagName(xmlHeader); 
        Element temp;
        if (list.getLength()>0){
            temp = (Element) list.item(0); 
            if (temp.getAttribute(GalaxyStatus.xmlMinutesAtribute).compareTo("true")==0){// minutki
                gx = new GalaxyStatusMinutes(Integer.parseInt(temp.getTextContent()));
            }  else if (temp.getTextContent().compareTo(ACTIVITY.name)==0){
                gx = ACTIVITY;
            } else if (temp.getTextContent().compareTo(NO_ACTIVITY.name)==0){
                gx = NO_ACTIVITY;
            }else {
                gx=EMPTY;
            }
        }
        return gx;
    }
    static public final GalaxyStatus EMPTY = new GalaxyStatus("Empty");
    static public final GalaxyStatus NO_ACTIVITY = new GalaxyStatus("no activity");
    static public final GalaxyStatus ACTIVITY = new GalaxyStatus("activity");
    static public final String xmlHeader = "activity";
    static public final String xmlMinutesAtribute = "minutes";
}
