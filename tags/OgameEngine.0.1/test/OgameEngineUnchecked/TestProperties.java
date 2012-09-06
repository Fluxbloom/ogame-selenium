/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author dyschemist
 */
class TestProperties {
     protected String path; 
     protected Properties properties;
     
     private String universe;
     private String nick;
     private String pass;

    public TestProperties()throws IOException{
        this.path= System.getProperty("user.dir")+"/conf/test.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        this.universe = properties.getProperty("universe");
        this.nick = properties.getProperty("nick");
        this.pass = properties.getProperty("pass"); 
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        properties.setProperty("nick", nick);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        properties.setProperty("pass", pass);
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
        properties.setProperty("universe", universe);
    }

    @Override
    public String toString() {
        return "TestProperties{" + "path=" + path + ", universe=" + universe + ", nick=" + nick + ", pass=" + pass + '}';
    }
    
    

  

    
}
