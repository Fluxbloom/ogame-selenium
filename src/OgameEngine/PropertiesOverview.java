/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameElements.Coords;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Klasa odczytuje statyczne dane zawarte w pliku overview.properties. 
 * Dane te dotyczą przycisków i pól zawartych w oknie podglądu, czyli domyślnym widoku
 * jak również dotyczą górnego paska oraz przełączania planet
 * @author dyschemist
 */
public class PropertiesOverview extends PropertiesOgame {

    /**
     * Domyślny konstruktor odczytujący dane z pliku overview.properties 
     * w katalogu podanym w defaultConfFile.properties
     * @throws IOException wywołany przy błędzie odczytu pliku z dysku
     * @throws FileNotFoundException wywołany przy braku danego pliku
     */
    public PropertiesOverview() throws OgameFileNotFoundException, OgameIOException {
        load("overview.properties");
        init();
    }

    private void init() {
        // LEFT MENU PROPERTIES
        leftButtonPrzegladaj = properties.getProperty("leftButtonPrzegladaj");
        leftButtonSurowce = properties.getProperty("leftButtonSurowce");
        leftButtonStacja = properties.getProperty("leftButtonStacja");
        leftButtonBadania = properties.getProperty("leftButtonBadania");
        leftButtonStocznia = properties.getProperty("leftButtonStocznia");
        leftButtonObrona = properties.getProperty("leftButtonObrona");
        leftButtonFlota = properties.getProperty("leftButtonFlota");
        leftButtonGalaxy = properties.getProperty("leftButtonGalaxy");
        leftButtonEventList = properties.getProperty("leftButtonEventList");
        leftButtonEventListIsEmpty = properties.getProperty("leftButtonEventListIsEmpty");
        leftButtonEventListIsListVisibleText = properties.getProperty("leftButtonEventListIsListVisibleText");
        leftButtonResourceSettings = properties.getProperty("leftButtonResourceSettings");
        leftButtonSlotsList = properties.getProperty("leftButtonFlightsList");
        leftButtonMessages=properties.getProperty("leftButtonMessages"); 
        // CHANGE PLANET
        countplanet = properties.getProperty("countplanet");//=//div[@id="countColonies"]/p/span
        countplanet_separator = properties.getProperty("countplanet_separator");//=/
        countplanet_result_pos = Integer.parseInt(properties.getProperty("countplanet_result_pos"));//=1
        changeplanetbyid = properties.getProperty("changeplanetbyid");//=//div[@id="myWorlds"]/div[contains(@class,"planet")][
        changeplanetbyName = properties.getProperty("changeplanetbyName");//=")]
        changeplanetbyCoords = properties.getProperty("changeplanetbyCoords");
        changeplanetgetName = properties.getProperty("changeplanetgetName");//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-name"]
        changeplanetgetCoords = properties.getProperty("changeplanetgetCoords");//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-koords"]
        // top resources
        resources_metal = properties.getProperty("resources_metal");
        resources_crystal = properties.getProperty("resources_crystal");
        resources_deuterium = properties.getProperty("resources_deuterium");
        resources_darkmatter = properties.getProperty("resources_darkmatter");
        resources_energy = properties.getProperty("resources_energy");

        buildingFree = properties.getProperty("buildingFree");//=Brak budynków w kolejce budowy.
        studyFree = properties.getProperty("studyFree");//=Twoje laboratorium w tej chwili nie pracuje.
        constructingFree = properties.getProperty("constructingFree");//=Brak statków/ Obrona w budowie

        overviewClickedElementPresent = properties.getProperty("overviewClickedElementPresent");


    }

    /**
     * Pobiera xpath do przycisku badań z lewego menu
     * @return xpath do przycisku
     */
    public String getLeftButtonBadania() {
        return leftButtonBadania;
    }

    /**
     * Pobiera xpath do przycisku wysyłania floty z lewego menu
     * @return xpath do przycisku
     */
    public String getLeftButtonFlota() {
        return leftButtonFlota;
    }

    /**
     * Pobiera xpath do przycisku budowania obrony z lewego menu
     * @return xpath do przycisku
     */
    public String getLeftButtonObrona() {
        return leftButtonObrona;
    }

    /**
     * Pobiera xpath do przycisku przeglądania z lewego menu (widok domyślny)
     * @return xpath do przycisku
     */
    public String getLeftButtonPrzegladaj() {
        return leftButtonPrzegladaj;
    }

    /**
     * Pobiera xpath do przycisku przeglądania budynkow stacji z lewego menu
     * @return xpath do przycisku
     */
    public String getLeftButtonStacja() {
        return leftButtonStacja;
    }

    /**
     * Pobiera xpath do przycisku stoczni z lewego menu
     * @return xpath do przycisku
     */
    public String getLeftButtonStocznia() {
        return leftButtonStocznia;
    }

    /**
     * Pobiera xpath do przycisku budynków wydobycia z lewego menu
     * @return xpath do przycisku
     */
    public String getLeftButtonSurowce() {
        return leftButtonSurowce;
    }

    /**
     * Pobiera xpath do elementu istniejącego tylko gdy nie ma żadnych bieżących eventów
     * @return xpath do elementu istniejącego tylko gdy nie ma żadnych bieżących eventów
     */
    public String getLeftButtonEventListIsEmpty() {
        return leftButtonEventListIsEmpty;
    }

    /**
     * Pobiera tekst wyświetlajacy się gdy lista eventów jest widoczna
     * @return tekst wyświetlajacy się gdy lista eventów jest widoczna
     */
    public String getLeftButtonEventListIsListVisibleText() {
        return leftButtonEventListIsListVisibleText;
    }

    /**
     * Pobiera xpath to przycisku otwierającego listę eventów
     * @return xpath do przycisku otwierającego listę eventów
     */
    public String getLeftButtonEventList() {
        return leftButtonEventList;
    }

    /**
     * Pobiera xpath do przycisku otwierającego listę slotów
     * @return xpath do przycisku otwierającego listę slotów
     */
    public String getLeftButtonSlotsList() {
        return leftButtonSlotsList;
    }

    /**
     * Pobiera xpath do przycisku otwierajaćego zarządzenie proukcją
     * @return xpath do przycisku otwierajaćego zarządzenie proukcją
     */
    public String getLeftButtonResourceSettings() {
        return leftButtonResourceSettings;
    }

    /**
     * Pobiera xpath do przycisku otwierającego wiadomości
     * @return xpath do przycisku otwierającego wiadomości
     */
    public String getLeftButtonMessages() {
        return leftButtonMessages;
    }
    /**
     * Pobiera xpath do przycisku otwierającego podgląd galaktyki
     * @return xpath do galaktyki
     */
    public String getLeftButtonGalaxy() {
        return leftButtonGalaxy;
    }

    
    
    /**
     * Tworzy dynamicznego xpatha do zmiany planety na te z podanym kordynatem
     * @param c kordynat planety na ktorą ma być zmieniona 
     * @throws OgameFileNotFoundException brak pliku konfiguracji kordynatów
     * @throws OgameIOException brak możliwości odczytu pliku konfiguracji kordynatów
     * @return xpath do zmiany planety
     */
    public String getChangeplanetbyCoords(Coords c) throws OgameFileNotFoundException, OgameIOException {
        return changeplanetbyCoords.replace("%i", c.shortPrint());
    }

    /**
     * Tworzy dynamicznego xpatha do zmiany planety na określony numer na liście
     * @param i numer na liście planet
     * @return xpath do zmiany planety
     */
    public String getChangeplanetbyid(int i) {
        return changeplanetbyid.replace("%i", Integer.toString(i));
    }

    /**
     * Tworzy dynamicznego xpatha do zmiany planety na planetę o określonej nazwie,
     * a dokładnie na pierwszą planetę zawierającą tą nazwę
     * @param s nazwa planety
     * @return xpath do zmiany planety na pasującą do wzorca
     */
    public String getChangeplanetbyName(String s) {
        return changeplanetbyName.replace("%s", s);
    }

    /**
     * Zwraca xpatha do pobrania ilości planet
     * @return xpath do pobrania ilości planet
     */
    public String getCountplanet() {
        return countplanet;
    }

    /**
     * Zwraca pozycję w tablicy z której odczytywana będzie ilość planet
     * @return pozycję w tablicy z której odczytana bedzie ilość planet
     */
    public int getCountplanet_result_pos() {
        return countplanet_result_pos;
    }

    /**
     * Zwraca separator rozdzielający w stringu zawierającym liczbę planet
     * @return znak rozdzielający w stringu zawierającym liczbę planet
     */
    public String getCountplanet_separator() {
        return countplanet_separator;
    }

    /**
     * Zwraca xpath do odczytu kordynatów i-tej planety na liście
     * @param i numer planety na liście
     * @return xpath do pobrania koordynatów
     */
    public String getChangeplanetgetCoords(int i) {
        return changeplanetgetCoords.replace("%i", Integer.toString(i));
    }

    /**
     * Zwraca xpath do odczytu nazwy i-tej planety na liście
     * @param i numer planety na liście
     * @return xpath do pobrania nazwy planety
     */
    public String getChangeplanetgetName(int i) {
        return changeplanetgetName.replace("%i", Integer.toString(i));
    }

    /**
     * Zwraca xpath do pola z ilością kryształu na planecie
     * @return xpath do pola z kryształem
     */
    public String getResources_crystal() {
        return resources_crystal;
    }

    /**
     * Zwraca xpath do pola z antymaterią
     * @return xpath do pola z antymaterią
     */
    public String getResources_darkmatter() {
        return resources_darkmatter;
    }

    /**
     * Zwraca xpath do pola z deuterem
     * @return xpath do pola z deuterem
     */
    public String getResources_deuterium() {
        return resources_deuterium;
    }

    /**
     * Zwraca xpath do pola z energia
     * @return xpath do pola z energią
     */
    public String getResources_energy() {
        return resources_energy;
    }

    /**
     * Zwraca xpath do pola z metalem
     * @return 
     */
    public String getResources_metal() {
        return resources_metal;
    }
    
    public String getBuildingFree() {
        return buildingFree;
    }

    public String getConstructingFree() {
        return constructingFree;
    }

    public String getStudyFree() {
        return studyFree;
    }

    public String getOverviewClickedElementPresent() {
        return overviewClickedElementPresent;
    }
    
    
    
    // LEFT MENU
    private String leftButtonPrzegladaj;
    private String leftButtonSurowce;
    private String leftButtonStacja;
    private String leftButtonBadania;
    private String leftButtonStocznia;
    private String leftButtonObrona;
    private String leftButtonFlota;
    private String leftButtonGalaxy;
    private String leftButtonEventList;
    private String leftButtonEventListIsEmpty;
    private String leftButtonEventListIsListVisibleText;
    private String leftButtonResourceSettings;
    private String leftButtonSlotsList;
    private String leftButtonMessages;
    //CHANGE PLANET
    private String countplanet;//=//div[@id="countColonies"]/p/span
    private String countplanet_separator;//=/
    private int countplanet_result_pos;//=1
    private String changeplanetbyid;//=]
    private String changeplanetbyName;//=")]
    private String changeplanetbyCoords;
    private String changeplanetgetName;//=//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-name"]
    private String changeplanetgetCoords;//=//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-koords"]
    // TOP resources
    private String resources_metal;//=id=resources_metal
    private String resources_crystal;//=id=resources_crystal
    private String resources_deuterium;//=id=resources_deuterium
    private String resources_darkmatter;//id=darkmatter
    private String resources_energy;//id=resources_energy
    // bottom queues
    private String buildingFree;//=Brak budynków w kolejce budowy.
    private String studyFree;//=Twoje laboratorium w tej chwili nie pracuje.
    private String constructingFree;//=Brak statków/ Obrona w budowie
    private String overviewClickedElementPresent;//podgląd jest widoczny
}
