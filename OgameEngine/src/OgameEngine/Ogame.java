/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 *
 * @author dyschemist
 */
public abstract class Ogame extends SeleneseTestCase implements IOgame{
    
    
    public static Ogame ogameFabric(String uni,String lang){
        return new Ogame116pl();
    }
}
