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
class MappingProperties {

    protected String path;
    protected Properties properties;
    private String url;
    private String browser;
    private String gameUrl;
    private String timeout;
    private String login_closed_login_frame;
    private String login_login_button;
    // LEFT MENU
    private String leftButtonPrzegladaj;
    private String leftButtonSurowce;
    private String leftButtonStacja;
    private String leftButtonBadania;
    private String leftButtonStocznia;
    private String leftButtonObrona;
    private String leftButtonFlota;
    // FLEET SEND MENU
    private String fleetSend_lm;
    private String fleetSend_cm;
    private String fleetSend_kr;
    private String fleetSend_ow;
    private String fleetSend_pan;
    private String fleetSend_bomb;
    private String fleetSend_nisz;
    private String fleetSend_gs;
    private String fleetSend_mt;
    private String fleetSend_dt;
    private String fleetSend_kol;
    private String fleetSend_rec;
    private String fleetSend_sond;
    private String fleetSend_sendAll;
    private String fleetSend_okscreen1;//=//a[@class="on" and @id="continue"]
    private String fleetSend_errorscreen1;//=//a[@class="off" and @id="continue"]
    private String fleetSend_galaxy;
    private String fleetSend_system;
    private String fleetSend_position;
    private String fleetSend_speed;
    private String fleetSend_speed_ans;
    private String fleetSend_okscreen2;//=//a[@class="on" and @id="continue"]
    private String fleetSend_errorscreen2;//=//a[@class="off" and @id="continue"]
    private String fleetSend_missionExp;
    private String fleetSend_missionKol;
    private String fleetSend_missionRec;
    private String fleetSend_missionTra;
    private String fleetSend_missionSta;
    private String fleetSend_missionSzp;
    private String fleetSend_missionZat;
    private String fleetSend_missionAtk;
    private String fleetSend_missionAcs;
    private String fleetSend_missionMoon;
    private String fleetSend_metal;
    private String fleetSend_crystal;
    private String fleetSend_deuter;
    private String fleetSend_allResources;
    private String fleetSend_okscreen3;//=//a[@class="on" and @id="start"]
    private String fleetSend_errorscreen3;//=//a[@class="off" and @id="start"]
    // building
    private String building_km;//=xpath=(//a[@id='details'])[1]
    private String building_kc;//=xpath=(//a[@id='details'])[2]
    private String building_ed;//=xpath=(//a[@id='details'])[3]
    private String building_es;//=xpath=(//a[@id='details'])[4]
    private String building_ef;//=xpath=(//a[@id='details'])[5]
    private String building_ss;//=xpath=(//a[@id='details'])[6]
    private String building_mm;//=xpath=(//a[@id='details'])[7]
    private String building_mc;//=xpath=(//a[@id='details'])[8]
    private String building_md;//=xpath=(//a[@id='details'])[9]
    private String building_sm;//=xpath=(//a[@id='details'])[10]
    private String building_sc;//=xpath=(//a[@id='details'])[11]
    private String building_sd;//=xpath=(//a[@id='details'])[12]
    private String building_resourcesNEG;//=//a[@class='build-it_disabled']
    private String building_resourcesOK;//=//a[@class='build-it']
    private String building_fr;//=i`d=details14
    private String building_st;//=id=details21
    private String building_lb;//=id=details31
    private String building_ds;//=id=details34
    private String building_sr;//=id=details44
    private String building_fn;//=id=details15
    private String building_te;//=id=details33
    private String building_stationNEG;//=//a[@class='build-it_disabled']
    private String building_stationOK;//=//a[@class='build-it']

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

    public MappingProperties() throws IOException {
        this.path = System.getProperty("user.dir") + "/conf/mappings.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        this.url = properties.getProperty("start_url");
        this.browser = properties.getProperty("browser");
        this.gameUrl = properties.getProperty("game_url");
        this.timeout = properties.getProperty("timeout"); 
        // LEFT MENU PROPERTIES
        this.login_closed_login_frame = properties.getProperty("login_closed_login_frame_text");
        this.login_login_button = properties.getProperty("login_login_button");
        this.leftButtonPrzegladaj = properties.getProperty("leftButtonPrzegladaj");
        this.leftButtonSurowce = properties.getProperty("leftButtonSurowce");
        this.leftButtonStacja = properties.getProperty("leftButtonStacja");
        this.leftButtonBadania = properties.getProperty("leftButtonBadania");
        this.leftButtonStocznia = properties.getProperty("leftButtonStocznia");
        this.leftButtonObrona = properties.getProperty("leftButtonObrona");
        this.leftButtonFlota = properties.getProperty("leftButtonFlota");
        // FLEET SEND MENU
        fleetSend_lm = properties.getProperty("fleetSend_lm");
        fleetSend_cm = properties.getProperty("fleetSend_cm");
        fleetSend_kr = properties.getProperty("fleetSend_kr");
        fleetSend_ow = properties.getProperty("fleetSend_ow");
        fleetSend_pan = properties.getProperty("fleetSend_pan");
        fleetSend_bomb = properties.getProperty("fleetSend_bomb");
        fleetSend_nisz = properties.getProperty("fleetSend_nisz");
        fleetSend_gs = properties.getProperty("fleetSend_gs");
        fleetSend_mt = properties.getProperty("fleetSend_mt");
        fleetSend_dt = properties.getProperty("fleetSend_dt");
        fleetSend_kol = properties.getProperty("fleetSend_kol");
        fleetSend_rec = properties.getProperty("fleetSend_rec");
        fleetSend_sond = properties.getProperty("fleetSend_sond");
        fleetSend_sendAll = properties.getProperty("fleetSend_sendAll");
        fleetSend_okscreen1 = properties.getProperty("fleetSend_okscreen1");
        fleetSend_errorscreen1 = properties.getProperty("fleetSend_errorscreen1");
        fleetSend_galaxy = properties.getProperty("fleetSend_galaxy");
        fleetSend_system = properties.getProperty("fleetSend_system");
        fleetSend_position = properties.getProperty("fleetSend_position");
        fleetSend_speed = properties.getProperty("fleetSend_speed");
        fleetSend_speed_ans = properties.getProperty("fleetSend_speed_ans");
        fleetSend_okscreen2 = properties.getProperty("fleetSend_okscreen2");
        fleetSend_errorscreen2 = properties.getProperty("fleetSend_errorscreen2");
        fleetSend_missionExp = properties.getProperty("fleetSend_missionExp");
        fleetSend_missionKol = properties.getProperty("fleetSend_missionKol");
        fleetSend_missionRec = properties.getProperty("fleetSend_missionRec");
        fleetSend_missionTra = properties.getProperty("fleetSend_missionTra");
        fleetSend_missionSta = properties.getProperty("fleetSend_missionSta");
        fleetSend_missionSzp = properties.getProperty("fleetSend_missionSzp");
        fleetSend_missionZat = properties.getProperty("fleetSend_missionZat");
        fleetSend_missionAtk = properties.getProperty("fleetSend_missionAtk");
        fleetSend_missionAcs = properties.getProperty("fleetSend_missionAcs");
        fleetSend_missionMoon = properties.getProperty("fleetSend_missionMoon");
        fleetSend_metal = properties.getProperty("fleetSend_metal");
        fleetSend_crystal = properties.getProperty("fleetSend_crystal");
        fleetSend_deuter = properties.getProperty("fleetSend_deuter");
        fleetSend_allResources = properties.getProperty("fleetSend_allResources");
        fleetSend_okscreen3 = properties.getProperty("fleetSend_okscreen3");
        fleetSend_errorscreen3 = properties.getProperty("fleetSend_errorscreen3");
        
        //build properties
        building_km=properties.getProperty("building_km");
        building_kc=properties.getProperty("building_kc");
        building_ed=properties.getProperty("building_ed");
        building_es=properties.getProperty("building_es");
        building_ef=properties.getProperty("building_ef");
        building_ss=properties.getProperty("building_ss");
        building_mm=properties.getProperty("building_mm");
        building_mc=properties.getProperty("building_mc");
        building_md=properties.getProperty("building_md");
        building_sm=properties.getProperty("building_sm");
        building_sc=properties.getProperty("building_sc");
        building_sd=properties.getProperty("building_sd");
        building_resourcesNEG=properties.getProperty("building_resourcesNEG");
        building_resourcesOK=properties.getProperty("building_resourcesOK");
        building_fr=properties.getProperty("building_fr");
        building_st=properties.getProperty("building_st");
        building_lb=properties.getProperty("building_lb");
        building_ds=properties.getProperty("building_ds");
        building_sr=properties.getProperty("building_sr");
        building_fn=properties.getProperty("building_fn");
        building_te=properties.getProperty("building_te");
        building_stationNEG=properties.getProperty("building_stationNEG");
        building_stationOK=properties.getProperty("building_stationOK");
        
        //study properties
        study_te=properties.getProperty("study_te");
        study_tl=properties.getProperty("study_tl");
        study_tj=properties.getProperty("study_tj");
        study_tn=properties.getProperty("study_tn");
        study_tp=properties.getProperty("study_tp");
        study_ts=properties.getProperty("study_ts");
        study_tk=properties.getProperty("study_tk");
        study_af=properties.getProperty("study_af");
        study_sb=properties.getProperty("study_sb");
        study_rg=properties.getProperty("study_rg");
        study_ns=properties.getProperty("study_ns");
        study_ni=properties.getProperty("study_ni");
        study_nn=properties.getProperty("study_nn");
        study_tb=properties.getProperty("study_tb");
        study_to=properties.getProperty("study_to");
        study_op=properties.getProperty("study_op");
        studyOK=properties.getProperty("studyOK");
        studyNEG=properties.getProperty("studyNEG");
        
        //obrona
        defence_wr=properties.getProperty("defence_wr");//=id=details401
        defence_ll=properties.getProperty("defence_ll");//=id=details402
        defence_cl=properties.getProperty("defence_cl");//=id=details403
        defence_dg=properties.getProperty("defence_dg");//=id=details404
        defence_dj=properties.getProperty("defence_dj");//=id=details405
        defence_wp=properties.getProperty("defence_wp");//=id=details406
        defence_mp=properties.getProperty("defence_mp");//=id=details407
        defence_dp=properties.getProperty("defence_dp");//=id=details408
        defence_pr=properties.getProperty("defence_pr");//=id=details502
        defence_rm=properties.getProperty("defence_rm");
        defenceOK=properties.getProperty("defence_wr");//=//a[@class='build-it']
        defenceNEG=properties.getProperty("defence_wr");//=//a[@class='build-it_disabled']
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

    
    
    public String getBuilding_ds() {
        return building_ds;
    }

    public String getBuilding_ed() {
        return building_ed;
    }

    public String getBuilding_ef() {
        return building_ef;
    }

    public String getBuilding_es() {
        return building_es;
    }

    public String getBuilding_fn() {
        return building_fn;
    }

    public String getBuilding_fr() {
        return building_fr;
    }

    public String getBuilding_kc() {
        return building_kc;
    }

    public String getBuilding_km() {
        return building_km;
    }

    public String getBuilding_lb() {
        return building_lb;
    }

    public String getBuilding_mc() {
        return building_mc;
    }

    public String getBuilding_md() {
        return building_md;
    }

    public String getBuilding_mm() {
        return building_mm;
    }

    public String getBuilding_resourcesNEG() {
        return building_resourcesNEG;
    }

    public String getBuilding_resourcesOK() {
        return building_resourcesOK;
    }

    public String getBuilding_sc() {
        return building_sc;
    }

    public String getBuilding_sd() {
        return building_sd;
    }

    public String getBuilding_sm() {
        return building_sm;
    }

    public String getBuilding_sr() {
        return building_sr;
    }

    public String getBuilding_ss() {
        return building_ss;
    }

    public String getBuilding_st() {
        return building_st;
    }

    public String getBuilding_stationNEG() {
        return building_stationNEG;
    }

    public String getBuilding_stationOK() {
        return building_stationOK;
    }

    public String getBuilding_te() {
        return building_te;
    }

    public String getBrowser() {
        return browser;
    }

    public String getFleetSend_allResources() {
        return fleetSend_allResources;
    }

    public String getFleetSend_bomb() {
        return fleetSend_bomb;
    }

    public String getFleetSend_cm() {
        return fleetSend_cm;
    }

    public String getFleetSend_crystal() {
        return fleetSend_crystal;
    }

    public String getFleetSend_deuter() {
        return fleetSend_deuter;
    }

    public String getFleetSend_dt() {
        return fleetSend_dt;
    }

    public String getFleetSend_errorscreen1() {
        return fleetSend_errorscreen1;
    }

    public String getFleetSend_errorscreen2() {
        return fleetSend_errorscreen2;
    }

    public String getFleetSend_errorscreen3() {
        return fleetSend_errorscreen3;
    }

    public String getFleetSend_galaxy() {
        return fleetSend_galaxy;
    }

    public String getFleetSend_gs() {
        return fleetSend_gs;
    }

    public String getFleetSend_kol() {
        return fleetSend_kol;
    }

    public String getFleetSend_kr() {
        return fleetSend_kr;
    }

    public String getFleetSend_lm() {
        return fleetSend_lm;
    }

    public String getFleetSend_metal() {
        return fleetSend_metal;
    }

    public String getFleetSend_missionAcs() {
        return fleetSend_missionAcs;
    }

    public String getFleetSend_missionAtk() {
        return fleetSend_missionAtk;
    }

    public String getFleetSend_missionExp() {
        return fleetSend_missionExp;
    }

    public String getFleetSend_missionKol() {
        return fleetSend_missionKol;
    }

    public String getFleetSend_missionMoon() {
        return fleetSend_missionMoon;
    }

    public String getFleetSend_missionRec() {
        return fleetSend_missionRec;
    }

    public String getFleetSend_missionSta() {
        return fleetSend_missionSta;
    }

    public String getFleetSend_missionSzp() {
        return fleetSend_missionSzp;
    }

    public String getFleetSend_missionTra() {
        return fleetSend_missionTra;
    }

    public String getFleetSend_missionZat() {
        return fleetSend_missionZat;
    }

    public String getFleetSend_mt() {
        return fleetSend_mt;
    }

    public String getFleetSend_nisz() {
        return fleetSend_nisz;
    }

    public String getFleetSend_okscreen1() {
        return fleetSend_okscreen1;
    }

    public String getFleetSend_okscreen2() {
        return fleetSend_okscreen2;
    }

    public String getFleetSend_okscreen3() {
        return fleetSend_okscreen3;
    }

    public String getFleetSend_ow() {
        return fleetSend_ow;
    }

    public String getFleetSend_pan() {
        return fleetSend_pan;
    }

    public String getFleetSend_position() {
        return fleetSend_position;
    }

    public String getFleetSend_rec() {
        return fleetSend_rec;
    }

    public String getFleetSend_sendAll() {
        return fleetSend_sendAll;
    }

    public String getFleetSend_sond() {
        return fleetSend_sond;
    }

    public String getFleetSend_speed() {
        return fleetSend_speed;
    }

    public String getFleetSend_speed_ans() {
        return fleetSend_speed_ans;
    }

    public String getFleetSend_system() {
        return fleetSend_system;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public String getLeftButtonBadania() {
        return leftButtonBadania;
    }

    public String getLeftButtonFlota() {
        return leftButtonFlota;
    }

    public String getLeftButtonObrona() {
        return leftButtonObrona;
    }

    public String getLeftButtonPrzegladaj() {
        return leftButtonPrzegladaj;
    }

    public String getLeftButtonStacja() {
        return leftButtonStacja;
    }

    public String getLeftButtonStocznia() {
        return leftButtonStocznia;
    }

    public String getLeftButtonSurowce() {
        return leftButtonSurowce;
    }

    public String getLogin_closed_login_frame() {
        return login_closed_login_frame;
    }

    public String getLogin_login_button() {
        return login_login_button;
    }

    public String getTimeout() {
        return timeout;
    }

    public String getUrl() {
        return url;
    }

}
