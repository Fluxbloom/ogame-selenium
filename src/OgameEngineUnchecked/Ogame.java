/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import org.openqa.grid.selenium.GridLauncher;

/**
 * 
 * @author dyschemist
 */
public abstract class Ogame implements IOgame{
    
    protected Selenium selenium;
    public static Ogame ogameFabric(String uni,String lang){
        return new Ogame116pl();
    }
    
    /*************************************************************************
     *********************** METODY SELENIUM Z BLEDEM ************************
     *************************************************************************/
    
    protected String getText(String xpath) throws OgameElementNotFoundException{
        String s ;
        try {
        s= selenium.getText(xpath);
        } catch (SeleniumException ex){
            throw new OgameElementNotFoundException(xpath);
        }
        return s;
    }
    protected boolean isTextPresent(String text) {
        return selenium.isTextPresent(text);
    }
    protected boolean isElementPresent(String xpath){
        return selenium.isElementPresent(xpath);
    }
    protected void click(String xpath) throws OgameElementNotFoundException{
        try {
            selenium.click(xpath);
        }catch (SeleniumException ex){
            throw new OgameElementNotFoundException(xpath);
        }
    }
    protected void select(String xpath, String value) throws OgameElementNotFoundException, OgameException{
        if (!isElementPresent(xpath)) throw new OgameElementNotFoundException(xpath);
        try {
            selenium.select(xpath, value);
        }catch (SeleniumException ex){
            throw new OgameException(xpath+"->"+value);
        }
        
    }
    protected String getAttribute(String xpath) throws OgameElementNotFoundException{
        String s;
        try {
            s=selenium.getAttribute(xpath);
        }catch (SeleniumException ex){
            throw new OgameElementNotFoundException(xpath);
        }
        return s;
    }
    protected void type(String xpath, String text) throws OgameElementNotFoundException{
        try {
            selenium.type(xpath, text);
        }catch (SeleniumException ex){
            throw new OgameElementNotFoundException(xpath);
        }
    }

    
}
