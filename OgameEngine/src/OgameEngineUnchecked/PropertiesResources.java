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
 *
 * @author dyschemist
 */
public class PropertiesResources extends MappingProperties{

    public PropertiesResources() throws OgameFileNotFoundException, OgameIOException {
    load("resource.properties");
    init();
    }
    
    private void init(){
     performance_m = properties.getProperty("performance_m");//=name=last1
        performance_k = properties.getProperty("performance_k");//=name=last1
        performance_d = properties.getProperty("performance_d");//=name=last1
        performance_es = properties.getProperty("performance_es");//=name=last1
        performance_ef = properties.getProperty("performance_ef");//=name=last1
        performance_ss = properties.getProperty("performance_ss");//=name=last1
        performance_ok = properties.getProperty("performance_ok");//=name=last1
        performance_select = properties.getProperty("performance_select");

    }
    
    public String getPerformance_d() {
        return performance_d;
    }

    public String getPerformance_ef() {
        return performance_ef;
    }

    public String getPerformance_es() {
        return performance_es;
    }

    public String getPerformance_k() {
        return performance_k;
    }

    public String getPerformance_m() {
        return performance_m;
    }

    public String getPerformance_ok() {
        return performance_ok;
    }

    public String getPerformance_ss() {
        return performance_ss;
    }

    public String getPerformance_select() {
        return performance_select;
    }
    
    private String performance_m;//=name=last1
    private String performance_k;//=name=last2
    private String performance_d;//=name=last3
    private String performance_es;//=name=last4
    private String performance_ef;//=name=last12
    private String performance_ss;//=name=last212
    private String performance_ok;//=//span[@class="factorbutton"/input
    private String performance_select;

    
    
}
