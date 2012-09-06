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
public class PropertiesLab extends MappingProperties {

    public PropertiesLab() throws FileNotFoundException, IOException {
        load("lab.properties");
        init();
    }

    private void init() {
        study_te = properties.getProperty("study_te");
        study_tl = properties.getProperty("study_tl");
        study_tj = properties.getProperty("study_tj");
        study_tn = properties.getProperty("study_tn");
        study_tp = properties.getProperty("study_tp");
        study_ts = properties.getProperty("study_ts");
        study_tk = properties.getProperty("study_tk");
        study_af = properties.getProperty("study_af");
        study_sb = properties.getProperty("study_sb");
        study_rg = properties.getProperty("study_rg");
        study_ns = properties.getProperty("study_ns");
        study_ni = properties.getProperty("study_ni");
        study_nn = properties.getProperty("study_nn");
        study_tb = properties.getProperty("study_tb");
        study_to = properties.getProperty("study_to");
        study_op = properties.getProperty("study_op");
        studyOK = properties.getProperty("studyOK");
        studyNEG = properties.getProperty("studyNEG");

        hm_te = properties.getProperty("hm_te");
        hm_tl = properties.getProperty("hm_tl");
        hm_tj = properties.getProperty("hm_tj");
        hm_tn = properties.getProperty("hm_tn");
        hm_tp = properties.getProperty("hm_tp");
        hm_ns = properties.getProperty("hm_ns");
        hm_ni = properties.getProperty("hm_ni");
        hm_nn = properties.getProperty("hm_nn");
        hm_ts = properties.getProperty("hm_ts");
        hm_tk = properties.getProperty("hm_tk");
        hm_af = properties.getProperty("hm_af");
        hm_ms = properties.getProperty("hm_ms");
        hm_rg = properties.getProperty("hm_rg");
        hm_tb = properties.getProperty("hm_tb");
        hm_to = properties.getProperty("hm_to");
        hm_op = properties.getProperty("hm_op");

    }
    
    public String getStudyNEG() {
        return studyNEG;
    }

    public String getStudyOK() {
        return studyOK;
    }

    public String getStudy_af() {
        return study_af;
    }

    public String getStudy_ni() {
        return study_ni;
    }

    public String getStudy_nn() {
        return study_nn;
    }

    public String getStudy_ns() {
        return study_ns;
    }

    public String getStudy_op() {
        return study_op;
    }

    public String getStudy_rg() {
        return study_rg;
    }

    public String getStudy_sb() {
        return study_sb;
    }

    public String getStudy_tb() {
        return study_tb;
    }

    public String getStudy_te() {
        return study_te;
    }

    public String getStudy_tj() {
        return study_tj;
    }

    public String getStudy_tk() {
        return study_tk;
    }

    public String getStudy_tl() {
        return study_tl;
    }

    public String getStudy_tn() {
        return study_tn;
    }

    public String getStudy_to() {
        return study_to;
    }

    public String getStudy_tp() {
        return study_tp;
    }

    public String getStudy_ts() {
        return study_ts;
    }
    
    
    public String getHm_af() {
        return hm_af;
    }

    public String getHm_ms() {
        return hm_ms;
    }

    public String getHm_ni() {
        return hm_ni;
    }

    public String getHm_nn() {
        return hm_nn;
    }

    public String getHm_ns() {
        return hm_ns;
    }

    public String getHm_op() {
        return hm_op;
    }

    public String getHm_rg() {
        return hm_rg;
    }

    public String getHm_tb() {
        return hm_tb;
    }

    public String getHm_te() {
        return hm_te;
    }

    public String getHm_tj() {
        return hm_tj;
    }

    public String getHm_tk() {
        return hm_tk;
    }

    public String getHm_tl() {
        return hm_tl;
    }

    public String getHm_tn() {
        return hm_tn;
    }

    public String getHm_to() {
        return hm_to;
    }

    public String getHm_tp() {
        return hm_tp;
    }

    public String getHm_ts() {
        return hm_ts;
    }
    
    
    private String study_te;//=id=details113
    private String study_tl;//=id=details120
    private String study_tj;//=id=details121
    private String study_tn;//=id=details114
    private String study_tp;//=id=details122
    private String study_ts;//=id=details106
    private String study_tk;//=id=details108
    private String study_af;//=id=details124
    private String study_sb;//=id=details123
    private String study_rg;//=id=details199
    private String study_ns;//=id=details115
    private String study_ni;//=id=details117
    private String study_nn;//=id=details118
    private String study_tb;//=id=details109
    private String study_to;//=id=details110
    private String study_op;//=id=details111
    private String studyOK;//a[@class='build-it']
    private String studyNEG;//=//a[@class='build-it_disabled']

    private String hm_te;//=//div[@class="research113"]/div/a/span/span
    private String hm_tl;//=//div[@class="research120"]/div/a/span/span
    private String hm_tj;//=//div[@class="research121"]/div/a/span/span
    private String hm_tn;//=//div[@class="research114"]/div/a/span/span
    private String hm_tp;//=//div[@class="research122"]/div/a/span/span
    private String hm_ns;//=//div[@class="research115"]/div/a/span/span
    private String hm_ni;//=//div[@class="research117"]/div/a/span/span
    private String hm_nn;//=//div[@class="research118"]/div/a/span/span
    private String hm_ts;//=//div[@class="research106"]/div/a/span/span
    private String hm_tk;//=//div[@class="research108"]/div/a/span/span
    private String hm_af;//=//div[@class="research124"]/div/a/span/span
    private String hm_ms;//=//div[@class="research123"]/div/a/span/span
    private String hm_rg;//=//div[@class="research199"]/div/a/span/span
    private String hm_tb;//=//div[@class="research109"]/div/a/span/span
    private String hm_to;//=//div[@class="research110"]/div/a/span/span
    private String hm_op;//=//div[@class="research111"]/div/a/span/span

}
