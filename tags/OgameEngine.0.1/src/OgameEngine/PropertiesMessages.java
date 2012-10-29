/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameElements.Message;
import OgameElements.MessageType;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa służy do pobrania pól xpath do elementów związanych z menu wiadomości
 * @author Piotr Kowalski
 */
public class PropertiesMessages extends PropertiesOgame {

    /**
     * Domyślny konstruktor
     * @throws FileNotFoundException Błąd brakuje pliku 
     * @throws IOException Błąd odczytu zasobu dyskowego
     */
    public PropertiesMessages() throws OgameFileNotFoundException, OgameIOException {
        load("messages.properties");
        init();
    }

    /**
     * Inicjalizer dla pól
     */
    private void init() {
        messageItemCount = properties.getProperty("messageItemCount");
        messageItem = properties.getProperty("messageItem");
        messageTypeText = properties.getProperty("messageTypeText");
        messageUrlAtribute = properties.getProperty("messageUrlAtribute");
        {
            messageTypesMappings = new HashMap<MessageType, String>();
            String[] rows = properties.getProperty("messageTypesMappings").split(";;");
            String[] row;
            for (int i = 0; i < rows.length; i++) {
                row = rows[i].split(";");
                messageTypesMappings.put(mapStringToMessage(row[0]), row[1]);
            }
        }
        nextPage = properties.getProperty("nextPage");
        commander = properties.getProperty("commander").compareToIgnoreCase("true") == 0 ? true : false;
        spy_tab = properties.getProperty("spy_tab");
        battle_tab = properties.getProperty("battle_tab");
        player_tab = properties.getProperty("player_tab");
        expedition_tab = properties.getProperty("expedition_tab");
        ally_tab = properties.getProperty("ally_tab");
        other_tab = properties.getProperty("other_tab");
    }

    private MessageType mapStringToMessage(String s) {
        if (s.compareTo("Return") == 0) {
            return Message.RETURN_REPORT;
        } else if (s.compareTo("ExpResult") == 0) {
            return Message.EXPEDITION_RESULT;
        } else if (s.compareTo("WarReport") == 0) {
            return Message.WAR_REPORT;
        } else if (s.compareTo("SpyActivity") == 0) {
            return Message.SPY_ACTIVITY;
        } else if (s.compareTo("SpyReport") == 0) {
            return Message.SPY_REPORT;
        } else {
            return null;
        }
    }

    /**
     * Zwraca xpath do obliczenia ilość wiadomości systemowych
     * @return xpath do obliczenia ilość wiadomości systemowych
     */
    public String getMessageItemCount() {
        return messageItemCount;
    }

    /**
     * Zwraca xpath do i-tej wiadomości systemowej
     * @param i numer wiadomości na stronie
     * @return xpath do i-tej wiadomości systemowej
     */
    public String getMessageItem(int i) {
        return messageItem.replace("%i", Integer.toString(i));
    }

    /**
     * Zwraca końcówkę xpath do text do rozróżniania wiadomości
     * @return xpath do text do rozróżniania wiadomości
     */
    public String getMessageTypeText() {
        return messageTypeText;
    }

    /**
     * Zwraca asocjacje odszukanych textów {@see PropertiesMessages#getMessageTypeText} do typów wiadomości
     * @return asocjacje odszukanych textów do typów wiadomości
     */
    public Map<MessageType, String> getMessageTypesMappings() {
        return messageTypesMappings;
    }

    /**
     * Zwraca końcówkę xpath do ścieżki wiadomości z atrybutem url  
     * @return końcówka xpath do ścieżki wiadomości z atrybutem url 
     */
    public String getMessageUrlAtribute() {
        return messageUrlAtribute;
    }

    /**
     * Zwraca xpath do następnej strony
     * @return xpath do następnej strony
     */
    public String getNextPage() {
        return nextPage;
    }

    public String getAlly_tab() {
        return ally_tab;
    }

    public String getBattle_tab() {
        return battle_tab;
    }

    public boolean isCommander() {
        return commander;
    }

    public String getExpedition_tab() {
        return expedition_tab;
    }

    public String getMessageItem() {
        return messageItem;
    }

    public String getOther_tab() {
        return other_tab;
    }

    public String getPlayer_tab() {
        return player_tab;
    }

    public String getSpy_tab() {
        return spy_tab;
    }

    private String messageItemCount;
    private String messageItem;
    private String messageUrlAtribute;
    private String messageTypeText;
    private Map<MessageType, String> messageTypesMappings;
    private String nextPage;
    private boolean commander;
    private String spy_tab;
    private String battle_tab;
    private String player_tab;
    private String expedition_tab;
    private String ally_tab;
    private String other_tab;
}
