/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

/**
 *
 * @author dyschemist
 */
public class LoggingProperties {
    
    private Properties properties;
    private String path;
    private boolean logStd;
private Level logStdLEVEL;
private boolean logFile;
private Level logFileLEVEL;
private String logFilePath;

private static HashMap<String,Level> levelMap;

    LoggingProperties() throws IOException {
        levelMap = new HashMap<String,Level>();
        levelMap.put("ALL", Level.ALL);
        levelMap.put("CONFIG", Level.CONFIG);
        levelMap.put("FINE", Level.FINE);
        levelMap.put("FINER", Level.FINER);
        levelMap.put("FINEST", Level.FINEST);
        levelMap.put("INFO", Level.INFO);
        levelMap.put("OFF", Level.OFF);
        levelMap.put("SEVERE", Level.SEVERE);
        levelMap.put("WARNING", Level.WARNING);
        properties = new Properties();
        path = System.getProperty("user.dir") + "/conf/logging.properties";
        properties.load(new FileInputStream(path));
        logStd= properties.getProperty("log.std").compareTo("TRUE")==0?true:false;
        logFile=properties.getProperty("log.file").compareTo("TRUE")==0?true:false;
        logFilePath = properties.getProperty("log.file.path");
        Set<Entry<String,Level>> set = levelMap.entrySet();
        Iterator<Entry<String,Level>> it = set.iterator();
        for (Entry<String,Level> temp ; it.hasNext();){
            temp=it.next();
            if(temp.getKey().compareTo(properties.getProperty("log.std.LEVEL"))==0){
                this.logStdLEVEL=temp.getValue();
            }
            if(temp.getKey().compareTo(properties.getProperty("log.file.LEVEL"))==0){
                this.logFileLEVEL=temp.getValue();
            }
        }
    }

    public boolean isLogFile() {
        return logFile;
    }

    public Level getLogFileLEVEL() {
        return logFileLEVEL;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public String getLogFilePath() {
        return logFilePath.replace("%d", sdf.format(Calendar.getInstance().getTime()));
    }

    public boolean isLogStd() {
        return logStd;
    }

    public Level getLogStdLEVEL() {
        return logStdLEVEL;
    }


    
}
