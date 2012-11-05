/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Klasa oddaje możliwe statusy gracza w podglądzie galaktyki i raportach szpiegowskich
 * @author Piotr Kowalski
 */
public class PlayerActivityStatuses {

    protected PlayerActivityStatuses(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PlayerStatuses{" + "status=" + status + '}';
    }

    public String print() {
        return "(" + status + ")";
    }

    public static String statusesList(List<PlayerActivityStatuses> list){
        String result ="{";
        Iterator<PlayerActivityStatuses> it = list.iterator();
        while(it.hasNext()){
            result+=(it.next().status);
            if (it.hasNext())
                result+=",";
        }
        return result+"}";
    }
    
    public static String toXML(List<PlayerActivityStatuses> player){
        String result ="<"+xmlHeader+">\n";
        for (int i=0;i<player.size();i++){
            result+="<"+xmlStatusHeader+">"+player.get(i).getStatus()+"</"+xmlStatusHeader+">\n";
        }
        result+="</"+xmlHeader+">\n";
        return result;
    }
    
    static public List<PlayerActivityStatuses> parseXML(Element root){
        List<PlayerActivityStatuses> result = new ArrayList<PlayerActivityStatuses>();
        NodeList list = root.getElementsByTagName(xmlHeader);
        if (list.getLength()>0){
            Element e = (Element) list.item(0);
            NodeList statuses = e.getElementsByTagName(xmlStatusHeader);
            for (int i=0;i<statuses.getLength();i++){
                result.add(string2PlayerActivityStatuses.get(statuses.item(i).getTextContent()));
            }
        }
        return result;
    }
    
    static public final String xmlHeader = "statuses";
    static public final String xmlStatusHeader = "status";
    static public final Map<String,PlayerActivityStatuses> string2PlayerActivityStatuses = new HashMap<String,PlayerActivityStatuses>();
    
    static public final PlayerActivityStatuses INACTIVE = new PlayerActivityStatuses("i");
    static public final PlayerActivityStatuses LONG_INACTIVE = new PlayerActivityStatuses("I");
    static public final PlayerActivityStatuses VACATION = new PlayerActivityStatuses("u");
    static public final PlayerActivityStatuses NOOB = new PlayerActivityStatuses("s");
    static public final PlayerActivityStatuses STRONG = new PlayerActivityStatuses("d");
    static public final PlayerActivityStatuses OUTLAW = new PlayerActivityStatuses("o");
    static public final PlayerActivityStatuses BANNED = new PlayerActivityStatuses("g");
    static public final PlayerActivityStatuses HONOUR = new PlayerActivityStatuses("ph");
    static public final PlayerActivityStatuses STARLORD = new PlayerActivityStatuses("starl");
    static public final PlayerActivityStatuses BANDIT = new PlayerActivityStatuses("bandit");
    static public final PlayerActivityStatuses NORMAL = new PlayerActivityStatuses("n");
    static {
        string2PlayerActivityStatuses.put(INACTIVE.status, INACTIVE);
        string2PlayerActivityStatuses.put(LONG_INACTIVE.status, LONG_INACTIVE);
        string2PlayerActivityStatuses.put(VACATION.status, VACATION);
        string2PlayerActivityStatuses.put(NOOB.status, NOOB);
        string2PlayerActivityStatuses.put(STRONG.status, STRONG);
        string2PlayerActivityStatuses.put(OUTLAW.status, OUTLAW);
        string2PlayerActivityStatuses.put(BANNED.status, BANNED);
        string2PlayerActivityStatuses.put(HONOUR.status, HONOUR);
        string2PlayerActivityStatuses.put(STARLORD.status, STARLORD);
        string2PlayerActivityStatuses.put(BANDIT.status, BANDIT);
        string2PlayerActivityStatuses.put(NORMAL.status, NORMAL);
    }
    private String status;
}
