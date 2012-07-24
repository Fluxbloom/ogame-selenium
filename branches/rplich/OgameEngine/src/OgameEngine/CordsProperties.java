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
class CordsProperties {
    
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
                Properties defaultPath = new Properties();
        defaultPath.load(new FileInputStream(
                System.getProperty("user.dir") + "/conf/defaultConfFile.properties")
                );
        this.path = System.getProperty("user.dir") + "/conf/"+defaultPath.getProperty("folder") +"/cords.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        universes=Integer.parseInt(properties.getProperty("universes"));
        systems=Integer.parseInt(properties.getProperty("systems"));
        positions=Integer.parseInt(properties.getProperty("positions"));
    }
}
