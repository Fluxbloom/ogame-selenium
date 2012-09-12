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
 * Klasa odczytuje statyczne dane zawarte w pliku fleet.properties. 
 * Dane te dotyczą przycisków i pól zawartych w oknach wysyłania flot
 * @author dyschemist
 */
public class PropertiesFleet extends MappingProperties {

    public PropertiesFleet() throws OgameFileNotFoundException, OgameIOException {
        load("fleet.properties");
        init();
    }

    private void init() {
        no_fleet_text = properties.getProperty("no_fleet_text");

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
        fleetSend_lm_all = properties.getProperty("fleetSend_lm_all");
        fleetSend_cm_all = properties.getProperty("fleetSend_cm_all");
        fleetSend_kr_all = properties.getProperty("fleetSend_kr_all");
        fleetSend_ow_all = properties.getProperty("fleetSend_ow_all");
        fleetSend_pan_all = properties.getProperty("fleetSend_pan_all");
        fleetSend_bomb_all = properties.getProperty("fleetSend_bomb_all");
        fleetSend_nisz_all = properties.getProperty("fleetSend_nisz_all");
        fleetSend_gs_all = properties.getProperty("fleetSend_gs_all");
        fleetSend_mt_all = properties.getProperty("fleetSend_mt_all");
        fleetSend_dt_all = properties.getProperty("fleetSend_dt_all");
        fleetSend_kol_all = properties.getProperty("fleetSend_kol_all");
        fleetSend_rec_all = properties.getProperty("fleetSend_rec_all");
        fleetSend_sond_all = properties.getProperty("fleetSend_sond_all");
        fleetSend_sendAll = properties.getProperty("fleetSend_sendAll");
        fleetSend_okscreen1 = properties.getProperty("fleetSend_okscreen1");
        fleetSend_errorscreen1 = properties.getProperty("fleetSend_errorscreen1");
        fleetSend_start_planet_selected = properties.getProperty("fleetSend_start_planet_selected");
        fleetSend_start_planet_deselected = properties.getProperty("fleetSend_start_planet_deselected");
        fleetSend_start_moon_selected = properties.getProperty("fleetSend_start_moon_selected");
        fleetSend_start_moon_deselected = properties.getProperty("fleetSend_start_moon_deselected");
        fleetSend_target_planet_selected = properties.getProperty("fleetSend_target_planet_selected");
        fleetSend_target_planet_deselected = properties.getProperty("fleetSend_target_planet_deselected");
        fleetSend_target_moon_selected = properties.getProperty("fleetSend_target_moon_selected");
        fleetSend_target_moon_deselected = properties.getProperty("fleetSend_target_moon_deselected");
        fleetSend_target_debris_selected = properties.getProperty("fleetSend_target_debris_selected");
        fleetSend_target_debris_deselected = properties.getProperty("fleetSend_target_debris_deselected");
        fleetSend_galaxy = properties.getProperty("fleetSend_galaxy");
        fleetSend_system = properties.getProperty("fleetSend_system");
        fleetSend_position = properties.getProperty("fleetSend_position");
        fleetSend_speed = properties.getProperty("fleetSend_speed");
        fleetSend_speed_ans = properties.getProperty("fleetSend_speed_ans");
        fleetSend_own_planet = properties.getProperty("fleetSend_own_planet");// =//select[@class="planets"]
        fleetSend_own_planet_target_pref = properties.getProperty("fleetSend_own_planet_target_pref");//=label=
        fleetSend_own_planet_options = properties.getProperty("fleetSend_own_planet_options");
        fleetSend_acs = properties.getProperty("fleetSend_acs");// =//select[@class="planets"]
        fleetSend_acs_target_pref = properties.getProperty("fleetSend_acs_target_pref");//=label=
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
        fleetSend_missionExp_off = properties.getProperty("fleetSend_missionExp_off");
        fleetSend_missionKol_off = properties.getProperty("fleetSend_missionKol_off");
        fleetSend_missionRec_off = properties.getProperty("fleetSend_missionRec_off");
        fleetSend_missionTra_off = properties.getProperty("fleetSend_missionTra_off");
        fleetSend_missionSta_off = properties.getProperty("fleetSend_missionSta_off");
        fleetSend_missionSzp_off = properties.getProperty("fleetSend_missionSzp_off");
        fleetSend_missionZat_off = properties.getProperty("fleetSend_missionZat_off");
        fleetSend_missionAtk_off = properties.getProperty("fleetSend_missionAtk_off");
        fleetSend_missionAcs_off = properties.getProperty("fleetSend_missionAcs_off");
        fleetSend_missionMoon_off = properties.getProperty("fleetSend_missionMoon_off");
        fleetSend_metal = properties.getProperty("fleetSend_metal");
        fleetSend_crystal = properties.getProperty("fleetSend_crystal");
        fleetSend_deuter = properties.getProperty("fleetSend_deuter");
        fleetSend_metal_max = properties.getProperty("fleetSend_metal_max");
        fleetSend_crystal_max = properties.getProperty("fleetSend_crystal_max");
        fleetSend_deuter_max = properties.getProperty("fleetSend_deuter_max");
        fleetSend_allResources = properties.getProperty("fleetSend_allResources");
        fleetSend_expedition_time = properties.getProperty("fleetSend_expedition_time");//=//select[@name="expeditiontime"]
        fleetSend_expedition_time_target_pref = properties.getProperty("fleetSend_expedition_time_target_pref");//=label=
        fleetSend_holding_time = properties.getProperty("fleetSend_holding_time");//=//select[@name="holdingtime"]
        fleetSend_holding_time_target_pref = properties.getProperty("fleetSend_holding_time_target_pref");//=label=

        flight_period_label = properties.getProperty("flight_period_label");
        flight_period_format = properties.getProperty("flight_period_format");
        flight_arrival_label = properties.getProperty("flight_arrival_label");
                flight_arrival_back_label = properties.getProperty("flight_arrival_back_label");
        flight_arrival_format = properties.getProperty("flight_arrival_format");

        fleetSend_okscreen3 = properties.getProperty("fleetSend_okscreen3");
        fleetSend_errorscreen3 = properties.getProperty("fleetSend_errorscreen3");

        shipyardCountXpath = properties.getProperty("hm");
        shipyardCountLM = properties.getProperty("hm_lm");
        shipyardCountCM = properties.getProperty("hm_cm");
        shipyardCountKRK = properties.getProperty("hm_kraz");
        hm_ow = properties.getProperty("hm_ow");
        hm_panc = properties.getProperty("hm_panc");
        hm_bomb = properties.getProperty("hm_bomb");
        hm_nisc = properties.getProperty("hm_nisc");
        hm_gs = properties.getProperty("hm_gs");
        hm_mt = properties.getProperty("hm_mt");
        hm_dt = properties.getProperty("hm_dt");
        hm_skol = properties.getProperty("hm_skol");
        hm_rec = properties.getProperty("hm_rec");
        hm_ss = properties.getProperty("hm_ss");

    }

    public String getNo_fleet_text() {
        return no_fleet_text;
    }

    public String getFlight_arrival_format() {
        return flight_arrival_format;
    }

    public String getFlight_arrival_label() {
        return flight_arrival_label;
    }

    public String getFlight_arrival_back_label() {
        return flight_arrival_back_label;
    }

    public String getFlight_period_format() {
        return flight_period_format;
    }

    public String getFlight_period_label() {
        return flight_period_label;
    }

    /* *************************************************************************
     * ******* Nie uporządkowane gettery ***************************************
     * *************************************************************************/
    public String getFleetSend_expedition_time() {
        return fleetSend_expedition_time;
    }

    public String getFleetSend_expedition_time_target_pref() {
        return fleetSend_expedition_time_target_pref;
    }

    public String getFleetSend_holding_time() {
        return fleetSend_holding_time;
    }

    public String getFleetSend_holding_time_target_pref() {
        return fleetSend_holding_time_target_pref;
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

    public String getFleetSend_missionAcs_off() {
        return fleetSend_missionAcs_off;
    }

    public String getFleetSend_missionAtk_off() {
        return fleetSend_missionAtk_off;
    }

    public String getFleetSend_missionExp_off() {
        return fleetSend_missionExp_off;
    }

    public String getFleetSend_missionKol_off() {
        return fleetSend_missionKol_off;
    }

    public String getFleetSend_missionMoon_off() {
        return fleetSend_missionMoon_off;
    }

    public String getFleetSend_missionRec_off() {
        return fleetSend_missionRec_off;
    }

    public String getFleetSend_missionSta_off() {
        return fleetSend_missionSta_off;
    }

    public String getFleetSend_missionSzp_off() {
        return fleetSend_missionSzp_off;
    }

    public String getFleetSend_missionTra_off() {
        return fleetSend_missionTra_off;
    }

    public String getFleetSend_missionZat_off() {
        return fleetSend_missionZat_off;
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

    public String getFleetSend_bomb_all() {
        return fleetSend_bomb_all;
    }

    public String getFleetSend_cm_all() {
        return fleetSend_cm_all;
    }

    public String getFleetSend_dt_all() {
        return fleetSend_dt_all;
    }

    public String getFleetSend_gs_all() {
        return fleetSend_gs_all;
    }

    public String getFleetSend_kol_all() {
        return fleetSend_kol_all;
    }

    public String getFleetSend_kr_all() {
        return fleetSend_kr_all;
    }

    public String getFleetSend_lm_all() {
        return fleetSend_lm_all;
    }

    public String getFleetSend_mt_all() {
        return fleetSend_mt_all;
    }

    public String getFleetSend_nisz_all() {
        return fleetSend_nisz_all;
    }

    public String getFleetSend_ow_all() {
        return fleetSend_ow_all;
    }

    public String getFleetSend_pan_all() {
        return fleetSend_pan_all;
    }

    public String getFleetSend_rec_all() {
        return fleetSend_rec_all;
    }

    public String getFleetSend_sond_all() {
        return fleetSend_sond_all;
    }

    public String getFleetSend_start_moon_deselected() {
        return fleetSend_start_moon_deselected;
    }

    public String getFleetSend_start_moon_selected() {
        return fleetSend_start_moon_selected;
    }

    public String getFleetSend_start_planet_deselected() {
        return fleetSend_start_planet_deselected;
    }

    public String getFleetSend_start_planet_selected() {
        return fleetSend_start_planet_selected;
    }

    public String getFleetSend_target_debris_deselected() {
        return fleetSend_target_debris_deselected;
    }

    public String getFleetSend_target_debris_selected() {
        return fleetSend_target_debris_selected;
    }

    public String getFleetSend_target_moon_deselected() {
        return fleetSend_target_moon_deselected;
    }

    public String getFleetSend_target_moon_selected() {
        return fleetSend_target_moon_selected;
    }

    public String getFleetSend_target_planet_deselected() {
        return fleetSend_target_planet_deselected;
    }

    public String getFleetSend_target_planet_selected() {
        return fleetSend_target_planet_selected;
    }

    public String getFleetSend_own_planet() {
        return fleetSend_own_planet;
    }

    public String getFleetSend_own_planet_target_pref() {
        return fleetSend_own_planet_target_pref;
    }

    public String getFleetSend_own_planet_options() {
        return fleetSend_own_planet_options;
    }

    public String getFleetSend_acs() {
        return fleetSend_acs;
    }

    public String getFleetSend_acs_target_pref() {
        return fleetSend_acs_target_pref;
    }

    public String getFleetSend_crystal_max() {
        return fleetSend_crystal_max;
    }

    public String getFleetSend_deuter_max() {
        return fleetSend_deuter_max;
    }

    public String getFleetSend_metal_max() {
        return fleetSend_metal_max;
    }

    public String getHm_bomb() {
        return shipyardCountXpath.replace("%s", hm_bomb);
    }

    public String getHm_cm() {
        return shipyardCountXpath.replace("%s", shipyardCountCM);
    }

    public String getHm_dt() {
        return shipyardCountXpath.replace("%s", hm_dt);
    }

    public String getHm_gs() {
        return shipyardCountXpath.replace("%s", hm_gs);
    }

    public String getHm_kraz() {
        return shipyardCountXpath.replace("%s", shipyardCountKRK);
    }

    public String getHm_lm() {
        return shipyardCountXpath.replace("%s", shipyardCountLM);
    }

    public String getHm_mt() {
        return shipyardCountXpath.replace("%s", hm_mt);
    }

    public String getHm_nisc() {
        return shipyardCountXpath.replace("%s", hm_nisc);
    }

    public String getHm_ow() {
        return shipyardCountXpath.replace("%s", hm_ow);
    }

    public String getHm_panc() {
        return shipyardCountXpath.replace("%s", hm_panc);
    }

    public String getHm_rec() {
        return shipyardCountXpath.replace("%s", hm_rec);
    }

    public String getHm_skol() {
        return shipyardCountXpath.replace("%s", hm_skol);
    }

    public String getHm_ss() {
        return shipyardCountXpath.replace("%s", hm_ss);
    }
    private String no_fleet_text;
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
    private String fleetSend_lm_all;//=id=button204
    private String fleetSend_cm_all;//=id=button_205
    private String fleetSend_kr_all;//=id=button_206
    private String fleetSend_ow_all;//=id=button_207
    private String fleetSend_pan_all;//=id=button_215
    private String fleetSend_bomb_all;//=id=button_211
    private String fleetSend_nisz_all;//=id=button_213
    private String fleetSend_gs_all;//=id=button_214
    private String fleetSend_mt_all;//=id=button_202
    private String fleetSend_dt_all;//=id=button_203
    private String fleetSend_kol_all;//=id=button_208
    private String fleetSend_rec_all;//=id=button_209
    private String fleetSend_sond_all;//=id=button_210
    private String fleetSend_sendAll;
    private String fleetSend_okscreen1;//=//a[@class="on" and @id="continue"]
    private String fleetSend_errorscreen1;//=//a[@class="off" and @id="continue"]
    private String fleetSend_start_planet_selected;//=//td[@id="start"]/div[@class="target"]/a[contains(@class,"planet_selected")]
    private String fleetSend_start_planet_deselected;//=//td[@id="start"]/div[@class="target"]/a[contains(@class,"planet")]
    private String fleetSend_start_moon_selected;//=//td[@id="start"]/div[@class="target"]/a[contains(@class,"moon_selected")]
    private String fleetSend_start_moon_deselected;//=//td[@id="start"]/div[@class="target"]/a[contains(@class,"moon")]
    private String fleetSend_target_planet_selected;//=//td[@id="target"]/div[@class="target"]/a[contains(@class,"planet_selected")]
    private String fleetSend_target_planet_deselected;//=//td[@id="target"]/div[@class="target"]/a[contains(@class,"planet")]
    private String fleetSend_target_moon_selected;//=//td[@id="target"]/div[@class="target"]/a[contains(@class,"moon_selected")]
    private String fleetSend_target_moon_deselected;//=//td[@id="target"]/div[@class="target"]/a[contains(@class,"moon")]
    private String fleetSend_target_debris_selected;//=//td[@id="target"]/div[@class="target"]/a[contains(@class,"moon_selected")]
    private String fleetSend_target_debris_deselected;//=//td[@id="target"]/div[@class="target"]/a[contains(@class,"moon")]
    private String fleetSend_galaxy;
    private String fleetSend_system;
    private String fleetSend_position;
    private String fleetSend_speed;
    private String fleetSend_speed_ans;
    private String fleetSend_own_planet;//=//select[@class="planets"]
    private String fleetSend_own_planet_target_pref;//=label=
    private String fleetSend_own_planet_options;
    private String fleetSend_acs;//=//select[@class="combatunits"]
    private String fleetSend_acs_target_pref;//=label=
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
    private String fleetSend_missionExp_off;
    private String fleetSend_missionKol_off;
    private String fleetSend_missionRec_off;
    private String fleetSend_missionTra_off;
    private String fleetSend_missionSta_off;
    private String fleetSend_missionSzp_off;
    private String fleetSend_missionZat_off;
    private String fleetSend_missionAtk_off;
    private String fleetSend_missionAcs_off;
    private String fleetSend_missionMoon_off;
    private String fleetSend_metal;
    private String fleetSend_crystal;
    private String fleetSend_deuter;
    private String fleetSend_metal_max;
    private String fleetSend_crystal_max;
    private String fleetSend_deuter_max;
    private String fleetSend_allResources;
    private String fleetSend_expedition_time;//=//select[@name="expeditiontime"]
    private String fleetSend_expedition_time_target_pref;//=label=
    private String fleetSend_holding_time;//=//select[@name="holdingtime"]
    private String fleetSend_holding_time_target_pref;//=label=
    
    private String flight_period_label;
    private String flight_period_format;
    private String flight_arrival_label;
    private String flight_arrival_back_label;
    private String flight_arrival_format;
    
    private String fleetSend_okscreen3;//=//a[@class="on" and @id="start"]
    private String fleetSend_errorscreen3;//=//a[@class="off" and @id="start"]
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
