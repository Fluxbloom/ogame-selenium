/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author plich
 */
public class HelpProperties {

    public HelpProperties() throws FileNotFoundException,IOException {
        String path;
        properties = new Properties();
        path = System.getProperty("user.dir")+"/conf/interpreter/help.properties";
        File file = new File(path);
        properties.load(new FileInputStream(file));
        init();
    }
    
     private void init() {
        functionChangePlanet = properties.getProperty("change_planet_function_name");
        // lang
    }

    public String getFunctionChangePlanet() {
        return functionChangePlanet;
    }

    public String getLang() {
        return lang;
    }
    
    
     
     
    private Properties properties;

    private String functionChangePlanet;
    private String lang;
    

}
