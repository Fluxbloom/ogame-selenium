/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Klasa odczytuje statyczne dane zawarte w pliku selenium.properties
 * @author dyschemist
 */
public class PropertiesSelenium extends MappingProperties {

    /**
     * Domyślny konstruktor odczytujący dane z pliku selenium.properties 
     * w katalogu podanym w defaultConfFile.properties
     * @throws IOException wywołany przy błędzie odczytu pliku z dysku
     * @throws FileNotFoundException wywołany przy braku danego pliku
     */
    public PropertiesSelenium() throws OgameFileNotFoundException, OgameIOException {
        load("selenium.properties");
        init();
    }
    /**
     * Startowy adres url
     */
    private String url;

    /**
     * Pobiera startowy adres url
     * @return startowy url
     */
    public String getUrl() {
        return url;
    }
    /**
     * Nazwa sterownika przeglądarki
     */
    private String browser;

    /**
     * Pobiera nazwa sterownika przeglądarki
     * @return nazwa przeglądarki
     */
    public String getBrowser() {
        return browser;
    }
    /**
     * Adres url gry
     */
    private String gameUrl;

    /**
     * Pobiera adres url gry
     * @return adres url gry
     */
    public String getGameUrl() {
        return gameUrl;
    }
    /**
     * Czas do błędu przekroczenia czasu oczekiwania
     */
    private String timeout;

    /**
     * Pobiera czas do błędu przekroczenia czasu oczekiwania
     * @return Czas w milisekundach 
     */
    public String getTimeout() {

        return timeout;
    }

    /**
     * Metoda inicjalizuje pola wartościami z pliku properties. 
     * W przypadku błędnie podanego timeoutu wstawiana jest domyślna wartość 30 sec
     */
    private void init() {
        this.url = properties.getProperty("start_url");
        this.browser = properties.getProperty("browser");
        this.gameUrl = properties.getProperty("game_url");
        try {
            this.timeout = Integer.toString(Integer.parseInt(properties.getProperty("timeout")));
        } catch (NumberFormatException ex) {
            this.timeout = "30000";
            Logger.getLogger(PropertiesSelenium.class.getName()).warning("Error parsing timeout");
        }
    }
}
