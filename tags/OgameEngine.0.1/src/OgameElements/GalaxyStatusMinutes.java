/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa oddaje aktywność gracza pod postącia minutek
 * @author Piotr Kowalski
 */
public class GalaxyStatusMinutes extends GalaxyStatus {

    public GalaxyStatusMinutes(int minutes) {
        super("minutes");
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String reportPrint() {
        return "Last active "+minutes+" ago";
    }

    @Override
    public String toXML() {
        String result = "<" + xmlHeader +" "+xmlMinutesAtribute+"=\"true\">";
        result += this.minutes;
        result += "</"+xmlHeader+">\n";
        return result;
    }

    @Override
    public String toString() {
        return "GSM{" + "minutes=" + minutes + '}';
    }
    private int minutes;
    
}
