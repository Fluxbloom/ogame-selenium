/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa gromadzi dostępne rodzaje wiadomości raportów
 * @author Piotr Kowalski
 */
public class MessageType {

    /**
     * Domyślny konstruktor, który nie pozwala tworzyć zewnętrznych obiektów
     * @param name nazwa raportu
     */
    protected MessageType(String name) {
        this.name = name;
    }

    /**
     * Generuje stan obiektu jako String
     * @return stan obiektu
     */
    @Override
    public String toString() {
        return "ReportType{" + "name=" + name + '}';
    }
    /**
     * Odpowiada wiadomości o powrocie floty
     */
    public final static MessageType RETURN_REPORT = new MessageType("RETURN_REPORT");
    /**
     * Odpowiada wynikowi ekspedycji
     */
    public final static MessageType EXPEDITION_RESULT = new MessageType("EXPEDITION_RESULT");
    /**
     * Odpowiada raportowi z bitwy
     */
    public final static MessageType WAR_REPORT = new MessageType("WAR_REPORT");
    /**
     * Odpowiada akcji szpiegowskiej
     */
    public final static MessageType SPY_ACTIVITY = new MessageType("SPY_ACTIVITY");
    /**
     * Odpowiada raportowi ze szpiegowania
     */
    public final static MessageType SPY_REPORT = new MessageType("SPY_REPORT");
    private String name;
}
