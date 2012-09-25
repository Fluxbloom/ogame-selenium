/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Klasa odczytuje ścieżki xpath z pliku selenium.properties
 * @author Piotr Kowalski
 */
public class PropertiesSelenium extends PropertiesOgame {

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
     * Pobiera startowy adres url
     * @return startowy url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Pobiera nazwa sterownika przeglądarki
     * @return nazwa przeglądarki
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Pobiera adres url gry
     * @return adres url gry
     */
    public String getGameUrl() {
        return gameUrl;
    }

    /**
     * Pobiera czas do błędu przekroczenia czasu oczekiwania
     * @return Czas w milisekundach 
     */
    public String getTimeout() {

        return timeout;
    }

    /**
     * Pobiera czas dany stronie na załadowanie (w milisekundach)
     * @return czas na załadowanie strony
     */
    public int getLoadTime() {
        return loadTime;
    }

    /**
     * Pobiera czas (w milisekundach) po którym odbywa się ponowna próba dostępu do pola
     * @return czas powtórnej próby
     */
    public int getRetryTime() {
        return retryTime;
    }

    /**
     * Metoda inicjalizuje pola wartościami z pliku properties. 
     * W przypadku błędnie podanego timeoutu wstawiana jest domyślna wartość 30 sec
     */
    private void init() {
        this.url = properties.getProperty("start_url");
        this.browser = properties.getProperty("browser");
        this.gameUrl = properties.getProperty("game_url");
        this.timeout = Integer.toString(Integer.parseInt(properties.getProperty("timeout", "30000")));
        this.retryTime = Integer.parseInt(properties.getProperty("retry_time", "1000"));
        this.loadTime = Integer.parseInt(properties.getProperty("load_time", "5000"));

    }
    private String url;
    private String browser;
    private String gameUrl;
    private String timeout;
    private int loadTime;
    private int retryTime;
}
