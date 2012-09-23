/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Klasa odczytuje statyczne dane zawarte w pliku login.properties. 
 * Dane te dotyczą przycisków i pól zawartych w oknie logowania do serwera oraz przycisk wylogowywania
 * @author dyschemist
 */
public class PropertiesLogin extends MappingProperties {

    /**
     * Domyślny konstruktor odczytujący dane z pliku login.properties 
     * w katalogu podanym w defaultConfFile.properties
     * @throws IOException wywołany przy błędzie odczytu pliku z dysku
     * @throws FileNotFoundException wywołany przy braku danego pliku
     */
    public PropertiesLogin() throws OgameFileNotFoundException, OgameIOException {
        load("login.properties");
        init();
    }
    /**
     * Zawiera tekst przycisku w przycisku zamykającym formularz logowania
     */
    private String loginFrameIsOpenText;

    /**
     * Zwraca tekst w przycisku zamykającym formularz logowania
     * @return tekst w przycisku zamykającym formularz logowania
     */
    public String getLoginFrameIsOpenText() {
        return loginFrameIsOpenText;
    }
    /**
     * Xpath do przycisku otwierającego formularz logowania
     */
    private String loginFrameOpeningButton;

    /**
     * Zwraca xpath do przycisku otwierającego formularz logowania
     * @return xpath do przycisku otwierającego formularz logowania
     */
    public String getLoginFrameOpeningButton() {
        return loginFrameOpeningButton;
    }
    /**
     * Xpath do pola select wyboru uniwersum
     */
    private String selectUni;

    /**
     * Zwraca xpath do comboboxu wyboru uniwersum
     * @return xpath do pola select wyboru uniwersum
     */
    public String getSelectUni() {
        return selectUni;
    }
    /**
     * Zwraca przedrostek nazwy uniwersum do zaznaczenia w comboboxie wyboru uniwersum
     */
    private String uniPrefix;

    /** 
     * Zwraca przedrostek nazwy uniwersum do zaznaczenia w comboboxie wyboru uniwersum
     * @return przedrostek nazwy
     */
    public String getUniPrefix() {
        return uniPrefix;
    }
    /**
     * xpath do pola dla nazwy gracza
     */
    private String user;

    /**
     * Zwraca xpath do pola dla nazwy gracza
     * @return xpath do pola dla nazwy gracza
     */
    public String getUser() {
        return user;
    }
    /**
     * xpath do pola dla hasła gracza
     */
    private String pass;

    /**
     * Zwraca xpath do pola dla hasła gracza
     * @return xpath do pola dla hasła gracza
     */
    public String getPass() {
        return pass;
    }
    /**
     * Xpath do przycisku logującego
     */
    private String loginButton;
    /**
     * Zwraca xpath do przycisku logującego
     * @return xpath do przycisku logującego
     */
    public String getLoginButton() {
        return loginButton;
    }
    /**
     * xpath do metadanych widocznych po zalogowaniu
     */
    private String loginMetadata;
    /**
     * Zwraca xpath do metadanych widocznych po zalogowaniu
     * @return xpath do metadanych widocznych po zalogowaniu
     */
    public String getLoginMetadata() {
        return loginMetadata;
    }
    /**
     * xpath do atrybutu metadanych widocznego po zalogowaniu
     */
    private String loginMetadataContentAtribute;
    /**
     * Zwraca xpath do atrybutu metadanych widocznego po zalogowaniu
     * @return xpath do atrybutu metadanych widocznego po zalogowaniu
     */
    public String getLoginMetadataContentAtribute() {
        return loginMetadataContentAtribute;
    }
    /**
     * odpowiedź oczekiwaną do odnalezienia w metadanych przy udanym zalogowaniu
     */
    private String loginMetadataContentAtributeValue;
    /**
     * Zwraca odpowiedź oczekiwaną do odnalezienia w metadanych przy udanym zalogowaniu
     * @return odpowiedź oczekiwana do odnalezienia w metadanych przy udanym zalogowaniu
     */
    public String getLoginMetadataContentAtributeValue() {
        return loginMetadataContentAtributeValue;
    }
    /**
     * tekst oczekiwany po błędnym zalogowaniu się
     */
    private String wrongPasswordText;
    /**
     * Zwraca tekst oczekiwany po błędnym zalogowaniu się
     * @return tekst oczekiwany po błędnym zalogowaniu się
     */
    public String getWrongPasswordText() {
        return wrongPasswordText;
    }
    /**
     * xpath do przycisku wylogowującego
     */
    private String logoutButton;
    /**
     * Zwraca xpath do przycisku wylogowującego
     * @return xpath do przycisku wylogowującego
     */
    public String getLogoutButton() {
        return logoutButton;
    }

    /**
     * Metoda inicjalizuje pola wartościami z pliku properties. 
     * 
     */
    private void init() {
        loginFrameIsOpenText = properties.getProperty("loginFrameIsOpenText");
        loginFrameOpeningButton = properties.getProperty("loginFrameOpeningButton");
        selectUni = properties.getProperty("selectUni");//=id=serverLogin
        uniPrefix = properties.getProperty("uniPrefix");//=label=
        user = properties.getProperty("user");//=name=login
        pass = properties.getProperty("pass");//=name=pass
        loginButton = properties.getProperty("loginButton");//=id=loginSubmit
        logoutButton = properties.getProperty("logoutButton");//=id=loginSubmit
        loginMetadata = properties.getProperty("loginMetadata");//meta[@name="ogame-universe"]@content
        loginMetadataContentAtribute = properties.getProperty("loginMetadataContentAtribute");//meta[@name="ogame-universe"]@content
        loginMetadataContentAtributeValue = properties.getProperty("loginMetadataContentAtributeValue");//uni116.ogame.pl
        wrongPasswordText = properties.getProperty("wrongPasswordText");
    }
}
