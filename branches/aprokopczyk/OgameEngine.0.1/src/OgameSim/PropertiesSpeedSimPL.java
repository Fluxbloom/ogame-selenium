/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author andrzej
 */
public class PropertiesSpeedSimPL {
    

    public PropertiesSpeedSimPL() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir") + "/conf/sim/speedsimpl.properties";
        File main = new File(path);
        properties.load(new FileInputStream(main));
        this.attackerMT = properties.getProperty("attacker_mt");
    }

    public String getAttackerMT() {
        return attackerMT;
    }
    
    
    
    
    private String attackerMT;
        
        
}
