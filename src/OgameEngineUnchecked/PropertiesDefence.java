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
public class PropertiesDefence extends MappingProperties{

    public PropertiesDefence() throws OgameFileNotFoundException, OgameIOException {
        load("defence.properties");
        init();
    }
    private void init() {
       defence_wr = properties.getProperty("defence_wr");//=id=details401
        defence_ll = properties.getProperty("defence_ll");//=id=details402
        defence_cl = properties.getProperty("defence_cl");//=id=details403
        defence_dg = properties.getProperty("defence_dg");//=id=details404
        defence_dj = properties.getProperty("defence_dj");//=id=details405
        defence_wp = properties.getProperty("defence_wp");//=id=details406
        defence_mp = properties.getProperty("defence_mp");//=id=details407
        defence_dp = properties.getProperty("defence_dp");//=id=details408
        defence_pr = properties.getProperty("defence_pr");//=id=details502
        defence_rm = properties.getProperty("defence_rm");
        defenceOK = properties.getProperty("defence_wr");//=//a[@class='build-it']
        defenceNEG = properties.getProperty("defence_wr");//=//a[@class='build-it_disabled']
        defence_number = properties.getProperty("defence_number");

         hm_wr = properties.getProperty("hm_wr");
        hm_ll = properties.getProperty("hm_ll");
        hm_cl = properties.getProperty("hm_cl");
        hm_dg = properties.getProperty("hm_dg");
        hm_dj = properties.getProperty("hm_dj");
        hm_wp = properties.getProperty("hm_wp");
        hm_mp = properties.getProperty("hm_mp");
        hm_dp = properties.getProperty("hm_dp");
        hm_pr = properties.getProperty("hm_pr");
        hm_rm = properties.getProperty("hm_rm");

    }
    
    public String getDefenceNEG() {
        return defenceNEG;
    }

    public String getDefenceOK() {
        return defenceOK;
    }

    public String getDefence_cl() {
        return defence_cl;
    }

    public String getDefence_dg() {
        return defence_dg;
    }

    public String getDefence_dj() {
        return defence_dj;
    }

    public String getDefence_dp() {
        return defence_dp;
    }

    public String getDefence_ll() {
        return defence_ll;
    }

    public String getDefence_mp() {
        return defence_mp;
    }

    public String getDefence_pr() {
        return defence_pr;
    }

    public String getDefence_rm() {
        return defence_rm;
    }

    public String getDefence_wp() {
        return defence_wp;
    }

    public String getDefence_wr() {
        return defence_wr;
    }
    
    public String getHm_cl() {
        return hm_cl;
    }

    public String getHm_dg() {
        return hm_dg;
    }

    public String getHm_dj() {
        return hm_dj;
    }

    public String getHm_dp() {
        return hm_dp;
    }

    public String getHm_ll() {
        return hm_ll;
    }

    public String getHm_mp() {
        return hm_mp;
    }
     public String getHm_pr() {
        return hm_pr;
    }

    public String getHm_rm() {
        return hm_rm;
    }

    public String getHm_wp() {
        return hm_wp;
    }

    public String getHm_wr() {
        return hm_wr;
    }
    
    public String getDefence_number() {
        return defence_number;
    }
    
    private String defence_wr;//=id=details401
    private String defence_ll;//=id=details402
    private String defence_cl;//=id=details403
    private String defence_dg;//=id=details404
    private String defence_dj;//=id=details405
    private String defence_wp;//=id=details406
    private String defence_mp;//=id=details407
    private String defence_dp;//=id=details408
    private String defence_pr;//=id=details502
    private String defence_rm;
    private String defenceOK;//=//a[@class='build-it']
    private String defenceNEG;//=//a[@class='build-it_disabled']
    private String defence_number;

    private String hm_wr;//=//div[@class="defense401"]/div/a/span/span
    private String hm_ll;//=//div[@class="defense402"]/div/a/span/span
    private String hm_cl;//=//div[@class="defense403"]/div/a/span/span
    private String hm_dg;//=//div[@class="defense404"]/div/a/span/span
    private String hm_dj;//=//div[@class="defense405"]/div/a/span/span
    private String hm_wp;//=//div[@class="defense406"]/div/a/span/span
    private String hm_mp;//=//div[@class="defense407"]/div/a/span/span
    private String hm_dp;//=//div[@class="defense408"]/div/a/span/span
    private String hm_pr;//=//div[@class="defense502"]/div/a/span/span
    private String hm_rm;//=//div[@class="defense503"]/div/a/span/span

}
