/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author dyschemist
 */
public class PropertiesShipyard extends MappingProperties{

    public PropertiesShipyard() throws FileNotFoundException, IOException {
        load("shipyard.properties");
        init();
    }
        private void init() {
       shipyard_lm = properties.getProperty("shipyard_lm");//=id=details204
        shipyard_cm = properties.getProperty("shipyard_cm");//=id=details205
        shipyard_kraz = properties.getProperty("shipyard_kraz");//=id=details206
        shipyard_ow = properties.getProperty("shipyard_ow");//=id=details207
        shipyard_panc = properties.getProperty("shipyard_panc");//=id=details215
        shipyard_bomb = properties.getProperty("shipyard_bomb");//=id=details211
        shipyard_nisc = properties.getProperty("shipyard_nisc");//=id=details213
        shipyard_gs = properties.getProperty("shipyard_gw");//=id=details214
        shipyard_mt = properties.getProperty("shipyard_mt");//=id=details202
        shipyard_dt = properties.getProperty("shipyard_dt");//=id=details203
        shipyard_skol = properties.getProperty("shipyard_skol");//=id=details208
        shipyard_rec = properties.getProperty("shipyard_rec");//=id=details209
        shipyard_ss = properties.getProperty("shipyard_ss");//=id=details210
        shipyard_sat = properties.getProperty("shipyard_sat");//=id=details212
        shipyard_NEG = properties.getProperty("shipyard_NEG");//=//a[@class='build-it_disabled']
        shipyard_OK = properties.getProperty("shipyard_OK");//=//a[@class='build-it']
        shipyard_number = properties.getProperty("shipyard_number");

        

    }
         public String getShipyard_NEG() {
        return shipyard_NEG;
    }

    public String getShipyard_OK() {
        return shipyard_OK;
    }

    public String getShipyard_bomb() {
        return shipyard_bomb;
    }

    public String getShipyard_cm() {
        return shipyard_cm;
    }

    public String getShipyard_dt() {
        return shipyard_dt;
    }

    public String getShipyard_gs() {
        return shipyard_gs;
    }

    public String getShipyard_kraz() {
        return shipyard_kraz;
    }

    public String getShipyard_lm() {
        return shipyard_lm;
    }

    public String getShipyard_mt() {
        return shipyard_mt;
    }

    public String getShipyard_nisc() {
        return shipyard_nisc;
    }

    public String getShipyard_number() {
        return shipyard_number;
    }

    public String getShipyard_ow() {
        return shipyard_ow;
    }

    public String getShipyard_panc() {
        return shipyard_panc;
    }

    public String getShipyard_rec() {
        return shipyard_rec;
    }

    public String getShipyard_sat() {
        return shipyard_sat;
    }

    public String getShipyard_skol() {
        return shipyard_skol;
    }

    public String getShipyard_ss() {
        return shipyard_ss;
    }
        
        
        
        
        
        
    // build
    private String shipyard_lm;//=id=details204
    private String shipyard_cm;//=id=details205
    private String shipyard_kraz;//=id=details206
    private String shipyard_ow;//=id=details207
    private String shipyard_panc;//=id=details215
    private String shipyard_bomb;//=id=details211
    private String shipyard_nisc;//=id=details213
    private String shipyard_gs;//=id=details214
    private String shipyard_mt;//=id=details202
    private String shipyard_dt;//=id=details203
    private String shipyard_skol;//=id=details208
    private String shipyard_rec;//=id=details209
    private String shipyard_ss;//=id=details210
    private String shipyard_sat;//=id=details212
    private String shipyard_NEG;//=//a[@class='build-it_disabled']
    private String shipyard_OK;//=//a[@class='build-it']
    private String shipyard_number;//=id=number
    // get size
    private String shipyardCountXpath;//li[@id="%s"]/div/a@title
    private String shipyardCountLM;//=button204
    private String shipyardCountCM;//=button205
    private String shipyardCountKRK;//=button206
    private String hm_ow;//=button207
    private String hm_panc;//=button215
    private String hm_bomb;//=button211
    private String hm_nisc;//=button213
    private String hm_gs;//=button214
    private String hm_mt;//=button202
    private String hm_dt;//=button203
    private String hm_skol;//=button208
    private String hm_rec;//=button209
    private String hm_ss;//=button210

}
