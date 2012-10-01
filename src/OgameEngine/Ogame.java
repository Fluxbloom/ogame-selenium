/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameElementNotFoundException;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa abstrakcyjna stanowiaca interfejs dla różnych algorytmów
 * @author Piotr Kowalski
 */
public abstract class Ogame implements IOgame {

    protected Ogame() {
        logger.log(Level.INFO, "Reading static mappings");
        mappings = PropertiesOgame.mappingPropertiesFabric();
    }

    /**
     * Metoda fabryki produkująca obiekt Ogame dla danego uniwersum
     * <p>Wspierane ukłądy<\p>
     * <ol>
     * <li> "116" - "pl" -> folder conf/uni116pl </li>
     * </ol>
     * @param uni String z numerem uni
     * @param lang String z kodem kraju
     * @return obiekt Ogame z implementacją algorytmów dla danego uni
     */
    public static Ogame ogameFabric(String uni, String lang) {
        if (lang.compareTo("pl") == 0) {
            if (uni.compareTo("uni116") == 0 || uni.compareTo("116") == 0) {
                return new Ogame116pl();
            }
        }
        return new Ogame116pl();
    }

    /*************************************************************************
     *********************** METODY SELENIUM Z BLEDEM ************************
     *************************************************************************/
    /**
     * Metoda pobierania tekstu z obsługą błędu
     * @param xpath xpath do pola z którego dokonany ma być odczyt
     * @return tekst reprezentujący pole
     * @throws OgameElementNotFoundException nie istnieje obiekt pod wskazanym xpathem 
     */
    protected String getText(String xpath) throws OgameElementNotFoundException {
        String s;
        try {
            try {
                s = selenium.getText(xpath);
            } catch (SeleniumException ex) {
                throw new OgameElementNotFoundException(xpath);
            }
        } catch (OgameElementNotFoundException ex) {
            try {
                this.waitMilisecond(mappings.getSelenium().getRetryTime());
                s = selenium.getText(xpath);
            } catch (SeleniumException ex2) {
                throw ex;
            }

        }
        return s;
    }

    /**
     * Metoda weryfikująca obecność tekstu na stronie
     * @param text szukany tekst
     * @return true jeśli tekst występuje, false w p.p.
     */
    protected boolean isTextPresent(String text) {
        return selenium.isTextPresent(text);
    }

    /**
     * Metoda weryfikująca obecność elementu na stronie 
     * @param xpath położenie szukanego elementu
     * @return true jeśli element obecny, false w p.p.
     */
    protected boolean isElementPresent(String xpath) {
        return selenium.isElementPresent(xpath);
    }

    /**
     * Metoda klikająca w link, przycisk
     * @param xpath położenie elementu
     * @throws OgameElementNotFoundException brak elementu pod wskazanym położeniem na stronie 
     */
    protected void click(String xpath) throws OgameElementNotFoundException {

        try {
            try {
            selenium.click(xpath);
        } catch (SeleniumException ex) {
            throw new OgameElementNotFoundException(xpath);
        }
        } catch (OgameElementNotFoundException ex) {
            try {
            selenium.click(xpath);
        } catch (SeleniumException ex2) {
            throw new OgameElementNotFoundException(xpath);
        }

        }
    }

    /**
     * Wybranie obiektu z pola combo
     * @param xpath położenie pola combo
     * @param value wartość na którą ustawione ma zostać pole combo
     * @throws OgameElementNotFoundException brak pola combo pod wskazanym miejscem
     * @throws OgameException błąd wyboru, timeout lub brak takiej wartości
     */
    protected void select(String xpath, String value) throws OgameElementNotFoundException, OgameException {
        if (!isElementPresent(xpath)) {
            throw new OgameElementNotFoundException(xpath);
        }
        try {
            selenium.select(xpath, value);
        } catch (SeleniumException ex) {
            throw new OgameException(xpath + "->" + value);
        }

    }

    /**
     * Pobranie wartości atrybutu bloku html
     * @param xpath położenie bloku html
     * @return wartość atrybutu jako string
     * @throws OgameElementNotFoundException brak bloku html pod wskazanym miejscem 
     */
    protected String getAttribute(String xpath) throws OgameElementNotFoundException {
        String s;
        try {
            s = selenium.getAttribute(xpath);
        } catch (SeleniumException ex) {
            throw new OgameElementNotFoundException(xpath);
        }
        return s;
    }

    /**
     * Wstawienie w polu input danych
     * @param xpath połozenie pola input
     * @param text tekst do umieszczenia w polu
     * @throws OgameElementNotFoundException brak pola input
     */
    protected void type(String xpath, String text) throws OgameElementNotFoundException {
        try {
            selenium.type(xpath, text);
        } catch (SeleniumException ex) {
            throw new OgameElementNotFoundException(xpath);
        }
    }

    /**
     * Pobranie ilości pasujący elementów xpath
     * @param xpath 
     * @return ilość pasujących
     * @throws OgameElementNotFoundException na wszelki wypadek
     */
    protected int getXpathCount(String xpath) throws OgameElementNotFoundException {
        try {
            return selenium.getXpathCount(xpath).intValue();
        } catch (SeleniumException ex) {
            throw new OgameElementNotFoundException(xpath);
        }
    }

    /**
     * Pobiera kod html spod danego linka
     * @param url link strony
     * @return kod html
     */
    protected String getHTMLContent(String url) {
        String result = "";
        selenium.openWindow(url, "temp");
        this.waitMilisecond(1000);
        selenium.selectWindow("temp");
        result = selenium.getHtmlSource();
        selenium.close();
        selenium.selectWindow(null);
        return result;
    }

    /**
     * TEST otwiera link w nowym oknie a następnie wybiera pary z tabeli i zapisuje pary z pierwszej i 
     * drugiej kolumny
     * @param contentLink link do otwarcia
     * @return pary z tabeli 
     */
    protected Map<String, String> getContent(String contentLink) {
        Map<String, String> result = new HashMap<String, String>();
        selenium.openWindow(contentLink, "temp");
        this.waitMilisecond(1000);
        selenium.selectWindow("temp");
        int count = selenium.getXpathCount("//tr").intValue();
        for (int i = 1; i < count + 1; i++) {
            if (selenium.isElementPresent("//tr[i]/td[2]".replace("i", Integer.toString(i)))) {
                result.put(
                        selenium.getText("//tr[i]/td[1]".replace("i", Integer.toString(i))),
                        selenium.getText("//tr[i]/td[2]".replace("i", Integer.toString(i))));
            }
        }
        selenium.close();
        selenium.selectWindow(null);
        Set set = result.entrySet();
        logger.log(Level.WARNING, "Obtained content");
        Iterator<Entry<String, String>> it = set.iterator();
        for (Entry<String, String> temp; it.hasNext();) {
            temp = it.next();
            logger.log(Level.WARNING, "{0}->{1}", new Object[]{temp.getKey(), temp.getValue()});
        }
        return result;
    }
    protected PropertiesOgame mappings;
    protected Selenium selenium;
    private static final Logger logger = Logger.getLogger(Ogame.class.getName());
}
