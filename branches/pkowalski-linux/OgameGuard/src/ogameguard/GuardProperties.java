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
public class GuardProperties {

    private Properties properties;
    private String path;
    private String uni_number;
    private String uni_lang;
    private String uni;
    private String nick;
    private String pass;
    private int refresh_hours;
    private int refresh_minutes;
    private int refresh_seconds;

    GuardProperties() throws IOException {
        properties = new Properties();
        path = System.getProperty("user.dir") + "/conf/guard.properties";
        properties.load(new FileInputStream(path));
        // reading property file
        uni_number=properties.getProperty("uni_number");
        uni_lang=properties.getProperty("uni_lang");
        uni = properties.getProperty("uni");
        nick = properties.getProperty("nick");
        pass = properties.getProperty("pass");

        refresh_hours = Integer.parseInt(properties.getProperty("refresh_hours"));
        refresh_minutes = Integer.parseInt(properties.getProperty("refresh_minutes"));
        refresh_seconds = Integer.parseInt(properties.getProperty("refresh_seconds"));
    }

    public int getRefresh_hours() {
        return refresh_hours;
    }

    public int getRefresh_minutes() {
        return refresh_minutes;
    }

    public int getRefresh_seconds() {
        return refresh_seconds;
    }

    public String getPass() {
        return pass;
    }

    public String getNick() {
        return nick;
    }

    public String getUni() {
        return uni;
    }

    public String getUni_lang() {
        return uni_lang;
    }

    public String getUni_number() {
        return uni_number;
    }
}
