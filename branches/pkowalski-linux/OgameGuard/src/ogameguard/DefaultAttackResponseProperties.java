/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author dyschemist
 */
public class DefaultAttackResponseProperties {
     private Properties properties;
    private String path;
    
    private int escapeMinutes;
    
    DefaultAttackResponseProperties() throws IOException {
        properties = new Properties();
        path = System.getProperty("user.dir") + "/conf/defaultAttackResponse.properties";
        properties.load(new FileInputStream(path));
        escapeMinutes =Integer.parseInt(properties.getProperty("escapeMinutes"));
    }

    public int getEscapeMinutes() {
        return escapeMinutes;
    }
    
    
}
