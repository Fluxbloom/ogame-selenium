/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa odpowiada elementom menu wiadomości
 * @author Piotr 
 */
public class Message {
      /**
     * Odpowiada wiadomości o powrocie floty
     */
    public final static MessageType RETURN_REPORT = MessageType.RETURN_REPORT;
    /**
     * Odpowiada wynikowi ekspedycji
     */
    public final static MessageType EXPEDITION_RESULT = MessageType.EXPEDITION_RESULT;
    /**
     * Odpowiada raportowi z bitwy
     */
    public final static MessageType WAR_REPORT = MessageType.WAR_REPORT;
    /**
     * Odpowiada akcji szpiegowskiej
     */
    public final static MessageType SPY_ACTIVITY = MessageType.SPY_ACTIVITY;
    /**
     * Odpowiada raportowi ze szpiegowania
     */
    public final static MessageType SPY_REPORT = MessageType.SPY_REPORT;
}
