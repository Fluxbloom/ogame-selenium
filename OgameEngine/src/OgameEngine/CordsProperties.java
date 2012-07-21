/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author dyschemist
 */
public class CordsProperties {
    
    protected String path;
    protected Properties properties;
    
    private int universes;
    private int systems;
    private int positions;

    public int getPositions() {
        return positions;
    }

    public int getSystems() {
        return systems;
    }

    public int getUniverses() {
        return universes;
    }
    
    public CordsProperties() throws IOException {
        this.path = System.getProperty("user.dir") + "/conf/cords.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        universes=Integer.parseInt(properties.getProperty("universes"));
        systems=Integer.parseInt(properties.getProperty("systems"));
        positions=Integer.parseInt(properties.getProperty("positions"));
    }
}
