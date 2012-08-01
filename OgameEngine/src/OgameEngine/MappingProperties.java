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
    // LOGIN
    private String login_closed_login_frame;
    private String login_login_button;
    private String login_uni_target;//=id=serverLogin
    private String login_uni_pref;//=label=
    private String login_nick_target;//=name=login
    private String login_pass_target;//=name=pass
    private String login_login_with_pass_button;//=id=loginSubmit
    // LEFT MENU
    private String leftButtonPrzegladaj;
    private String leftButtonSurowce;
    private String leftButtonStacja;
    private String leftButtonBadania;
    private String leftButtonStocznia;
    private String leftButtonObrona;
    private String leftButtonFlota;
    private String leftButtonEventList;
    private String leftButtonResourceSettings;
    private String leftButtonFlightsList;
    private String logout_button;
    //CHANGE PLANET
    private String countplanet;//=//div[@id="countColonies"]/p/span
    private String countplanet_separator;//=/
    private int countplanet_result_pos;//=1
    private String changeplanetbyid;//=]
    private String changeplanetbyName;//=")]
    private String changeplanetgetName;//=//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-name"]
    private String changeplanetgetCoords;//=//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-koords"]
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
    private String buildBuilding_metal;//=xpath=(//a[@id='details'])[1]
    private String buildBuilding_crystal;//=xpath=(//a[@id='details'])[2]
    private String buildBuilding_deuterium;//=xpath=(//a[@id='details'])[3]
    private String buildBuilding_solar;//=xpath=(//a[@id='details'])[4]
    private String buildBuilding_fussion;//=xpath=(//a[@id='details'])[5]
    private String buildBuilding_solerSatellite;//=xpath=(//a[@id='details'])[6]
    private String buildBuilding_metalStorage;//=xpath=(//a[@id='details'])[7]
    private String buildBuilding_crystalStorage;//=xpath=(//a[@id='details'])[8]
    private String buildBuilding_deuteriumStorage;//=xpath=(//a[@id='details'])[9]
    private String buildBuilding_metalHideout;//=xpath=(//a[@id='details'])[10]
    private String buildBuilding_crystalHideout;//=xpath=(//a[@id='details'])[11]
    private String buildBuilding_deuteriumHideout;//=xpath=(//a[@id='details'])[12]
    private String buildBuilding_resourcesButtonDisabled;//=//a[@class='build-it_disabled']
    private String buildBuilding_resourcesButtonEnabled;//=//a[@class='build-it']
    private String buildBuilding_robots;//=id=details14
    private String buildBuilding_shipyard;//=id=details21
    private String buildBuilding_laboratory;//=id=details31
    private String buildBuilding_depositeStation;//=id=details34
    private String buildBuilding_missileSilo;//=id=details44
    private String buildBuilding_nanitas;//=id=details15
    private String buildBuilding_terraformer;//=id=details33
    // TODO missing moon building option
    private String buildBuilding_buildButtonDisabled;//=//a[@class='build-it_disabled']
    private String buildButtonEnabled;//=//a[@class='build-it']
    // STUDIES 
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
    private String defence_number;
// shipyard
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
    // event list
    private String event_list_root;//=//table[@id="eventContent"]/tbody/tr
    private String event_list_flight;//=//table[@id="eventContent"]/tbody/tr[%i]
    private String event_list_class_atribute;//=//table[@id="eventContent"]/tbody/tr[%i]@class
    private String event_list_class_atribute_enemy_alliance;//=allianceAttack
    private String event_list_class_atribute_friendly;//=eventFleet
    private String event_list_class_atribute_friendly_return;//=eventFleet odd
    private String event_list_atribute_count_down_time;//=/td[contains(@class,"countDown")]
    private String event_list_atribute_is_friendly;//=/td[contains(@class,"friendly")]
    private String event_list_atribute_is_neutral;//=/td[contains(@class,"neutral")]
    private String event_list_atribute_is_enemy;//=/td[contains(@class,"hostile")]
    private String event_list_atribute_is_spy;//=/td[@class="missionFleet"]/img[contains(@title,"Szpieguj")]
    private String event_list_atribute_is_attack;//=/td[@class="missionFleet"]/img[contains(@title,"Atakuj")]
    private String event_list_atribute_arrival_time;//=/td[@class="arrivalTime"]
    private String event_list_atribute_originFleet;//=/td[@class="originFleet"]
    private String event_list_atribute_originCoords;//=/td[@class="coordsOrigin"]/a
    private String event_list_atribute_detailsFleet;//=/td[@class="detailsFleet"]/span
    private String event_list_atribute_destFleet;//=/td[@class="destFleet"]
    private String event_list_atribute_destCoords;//=/td[@class="destCoords"]/a
    private String event_list_time_parser_day;//=c
    private String event_list_time_parser_hour;//=g
    private String event_list_time_parser_minute;//=min.
    private String event_list_time_parser_second;//=sek.
    //Performance
    private String performance_m;//=name=last1
    private String performance_k;//=name=last2
    private String performance_d;//=name=last3
    private String performance_es;//=name=last4
    private String performance_ef;//=name=last12
    private String performance_ss;//=name=last212
    private String performance_ok;//=//span[@class="factorbutton"/input
    private String performance_select;
    //Shipyard count
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
    //Study levels
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
    //Defence levels
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
    private String slots_usedFleets;//=//div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="current"]
    private String slots_maxFleets;//=//div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="all"]
    private String slots_useExp;//=//div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="current"]
    private String slots_maxExp;//=//div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="all"]
    private String slots_fleet_by_number;//=//div[contains(@id,"fleet")]
    private String slots_fleet_by_id;//=//div[contains(@id,"%i")]
    private String slots_fleetId_suffix;//=@id
    private String slots_fleetArrival_suffix;//=/span[contains(@id,"timer_")]
    private String slots_fleetMission_suffix;//=/span[contains(@class,"mission")]
    private String slots_fleetAllianceName_suffix;//=/span[contains(@class,"allianceName")]
    private String slots_fleetOriginPlanet_suffix;//=/span[@class="originData"]//a
    private String slots_fleetReversal_suffic;//=/span[contains(@class,"reversal")]
    private String slots_fleetReversal_titleAtribute_suffix;//=/span[contains(@class,"reversal")]@title
    private String slots_fleetTargetPlanet_suffix;//=/span[@class="destinationData"]//a
    private String slots_fleetComeBack_suffix;//=/span[contains(@id,"timerNext_")]
    private String slots_fleetComeBack_titleAtribute_suffix;//=/span[contains(@id,"timerNext_")]@title

    MappingProperties() throws IOException {
        Properties defaultPath = new Properties();
        defaultPath.load(new FileInputStream(
                System.getProperty("user.dir") + "/conf/defaultConfFile.properties"));
        this.path = System.getProperty("user.dir") + "/conf/" + defaultPath.getProperty("folder") + "/mappings.properties";
        // reading property file
        properties = new Properties();
        properties.load(new FileInputStream(path));
        this.url = properties.getProperty("start_url");
        this.browser = properties.getProperty("browser");
        this.gameUrl = properties.getProperty("game_url");
        this.timeout = properties.getProperty("timeout");
        // LOGIN PROPERTIES
        this.login_closed_login_frame = properties.getProperty("login_closed_login_frame_text");
        this.login_login_button = properties.getProperty("login_login_button");
        login_uni_target = properties.getProperty("login_uni_target");//=id=serverLogin
        login_uni_pref = properties.getProperty("login_uni_pref");//=label=
        login_nick_target = properties.getProperty("login_nick_target");//=name=login
        login_pass_target = properties.getProperty("login_pass_target");//=name=pass
        login_login_with_pass_button = properties.getProperty("login_login_with_pass_button");//=id=loginSubmit
        leftButtonEventList = properties.getProperty("leftButtonEventList");
        leftButtonResourceSettings = properties.getProperty("leftButtonResourceSettings");
        leftButtonFlightsList = properties.getProperty("leftButtonFlightsList");

        logout_button = properties.getProperty("logout_button");//=id=loginSubmit
        // LEFT MENU PROPERTIES
        this.leftButtonPrzegladaj = properties.getProperty("leftButtonPrzegladaj");
        this.leftButtonSurowce = properties.getProperty("leftButtonSurowce");
        this.leftButtonStacja = properties.getProperty("leftButtonStacja");
        this.leftButtonBadania = properties.getProperty("leftButtonBadania");
        this.leftButtonStocznia = properties.getProperty("leftButtonStocznia");
        this.leftButtonObrona = properties.getProperty("leftButtonObrona");
        this.leftButtonFlota = properties.getProperty("leftButtonFlota");
        // CHANGE PLANET
        countplanet = properties.getProperty("countplanet");//=//div[@id="countColonies"]/p/span
        countplanet_separator = properties.getProperty("countplanet_separator");//=/
        countplanet_result_pos = Integer.parseInt(properties.getProperty("countplanet_result_pos"));//=1
        changeplanetbyid = properties.getProperty("changeplanetbyid");//=//div[@id="myWorlds"]/div[contains(@class,"planet")][
        changeplanetbyName = properties.getProperty("changeplanetbyName");//=")]
        changeplanetgetName = properties.getProperty("changeplanetgetName");//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-name"]
        changeplanetgetCoords = properties.getProperty("changeplanetgetCoords");//div[@id="myWorlds"]/div[contains(@class,"planet")][%i]/a/span[@class="planet-koords"]
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
        buildBuilding_metal = properties.getProperty("building_km");
        buildBuilding_crystal = properties.getProperty("building_kc");
        buildBuilding_deuterium = properties.getProperty("building_ed");
        buildBuilding_solar = properties.getProperty("building_es");
        buildBuilding_fussion = properties.getProperty("building_ef");
        buildBuilding_solerSatellite = properties.getProperty("building_ss");
        buildBuilding_metalStorage = properties.getProperty("building_mm");
        buildBuilding_crystalStorage = properties.getProperty("building_mc");
        buildBuilding_deuteriumStorage = properties.getProperty("building_md");
        buildBuilding_metalHideout = properties.getProperty("building_sm");
        buildBuilding_crystalHideout = properties.getProperty("building_sc");
        buildBuilding_deuteriumHideout = properties.getProperty("building_sd");
        buildBuilding_resourcesButtonDisabled = properties.getProperty("building_resourcesNEG");
        buildBuilding_resourcesButtonEnabled = properties.getProperty("building_resourcesOK");
        buildBuilding_robots = properties.getProperty("building_fr");
        buildBuilding_shipyard = properties.getProperty("building_st");
        buildBuilding_laboratory = properties.getProperty("building_lb");
        buildBuilding_depositeStation = properties.getProperty("building_ds");
        buildBuilding_missileSilo = properties.getProperty("building_sr");
        buildBuilding_nanitas = properties.getProperty("building_fn");
        buildBuilding_terraformer = properties.getProperty("building_te");
        buildBuilding_buildButtonDisabled = properties.getProperty("building_stationNEG");
        buildButtonEnabled = properties.getProperty("building_stationOK");

        //study properties
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

        //obrona
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
        //shipyard
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

        // event list
        event_list_root = properties.getProperty("event_list_root");//table[@id="eventContent"]/tbody/tr
        event_list_flight = properties.getProperty("event_list_flight");//table[@id="eventContent"]/tbody/tr[%i]
        event_list_class_atribute = properties.getProperty("event_list_class_atribute");//table[@id="eventContent"]/tbody/tr[%i]@class
        event_list_class_atribute_enemy_alliance = properties.getProperty("event_list_class_atribute_enemy_alliance");//allianceAttack
        event_list_class_atribute_friendly = properties.getProperty("event_list_class_atribute_friendly");//eventFleet
        event_list_class_atribute_friendly_return = properties.getProperty("event_list_class_atribute_friendly_return");//eventFleet odd
        event_list_atribute_count_down_time = properties.getProperty("event_list_atribute_count_down_time");///td[contains(@class,"countDown")]
        event_list_atribute_is_friendly = properties.getProperty("event_list_atribute_is_friendly");///td[contains(@class,"friendly")]
        event_list_atribute_is_neutral = properties.getProperty("event_list_atribute_is_neutral");///td[contains(@class,"neutral")]
        event_list_atribute_is_enemy = properties.getProperty("event_list_atribute_is_enemy");///td[contains(@class,"hostile")]
        event_list_atribute_is_spy = properties.getProperty("event_list_atribute_is_spy");///td[@class="missionFleet"]/img[contains(@title,"Szpieguj")]
        event_list_atribute_is_attack = properties.getProperty("event_list_atribute_is_attack");///td[@class="missionFleet"]/img[contains(@title,"Atakuj")]
        event_list_atribute_arrival_time = properties.getProperty("event_list_atribute_arrival_time");///td[@class="arrivalTime"]
        event_list_atribute_originFleet = properties.getProperty("event_list_atribute_originFleet");///td[@class="originFleet"]
        event_list_atribute_originCoords = properties.getProperty("event_list_atribute_originCoords");///td[@class="coordsOrigin"]/a
        event_list_atribute_detailsFleet = properties.getProperty("event_list_atribute_detailsFleet");///td[@class="detailsFleet"]/span
        event_list_atribute_destFleet = properties.getProperty("event_list_atribute_destFleet");///td[@class="destFleet"]
        event_list_atribute_destCoords = properties.getProperty("event_list_atribute_destCoords");///td[@class="destCoords"]/a

        event_list_time_parser_day = properties.getProperty("event_list_time_parser_day");
        event_list_time_parser_hour = properties.getProperty("event_list_time_parser_hour");
        event_list_time_parser_minute = properties.getProperty("event_list_time_parser_minute");
        event_list_time_parser_second = properties.getProperty("event_list_time_parser_second");

        //Performance
        performance_m = properties.getProperty("performance_m");//=name=last1
        performance_k = properties.getProperty("performance_k");//=name=last1
        performance_d = properties.getProperty("performance_d");//=name=last1
        performance_es = properties.getProperty("performance_es");//=name=last1
        performance_ef = properties.getProperty("performance_ef");//=name=last1
        performance_ss = properties.getProperty("performance_ss");//=name=last1
        performance_ok = properties.getProperty("performance_ok");//=name=last1
        performance_select = properties.getProperty("performance_select");

        //Shipyard Details

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

        //Study Details

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

        //Defence Details

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
        // sloty
        slots_usedFleets = properties.getProperty("slots_usedFleets");////div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="current"]
        slots_maxFleets = properties.getProperty("slots_maxFleets");////div[@class="fleetStatus"]/span[@class="fleetSlots"]/span[@class="all"]
        slots_useExp = properties.getProperty("slots_useExp");////div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="current"]
        slots_maxExp = properties.getProperty("slots_maxExp");////div[@class="fleetStatus"]/span[@class="expSlots"]/span[@class="all"]
        slots_fleet_by_number = properties.getProperty("slots_fleet_by_number");////div[contains(@id,"fleet")]
        slots_fleet_by_id = properties.getProperty("slots_fleet_by_id");////div[contains(@id,"%i")]
        slots_fleetId_suffix = properties.getProperty("slots_fleetId_suffix");//@id
        slots_fleetArrival_suffix = properties.getProperty("slots_fleetArrival_suffix");///span[contains(@id,"timer_")]
        slots_fleetMission_suffix = properties.getProperty("slots_fleetMission_suffix");///span[contains(@class,"mission")]
        slots_fleetAllianceName_suffix = properties.getProperty("slots_fleetAllianceName_suffix");///span[contains(@class,"allianceName")]
        slots_fleetOriginPlanet_suffix = properties.getProperty("slots_fleetOriginPlanet_suffix");///span[@class="originData"]//a
        slots_fleetReversal_suffic = properties.getProperty("slots_fleetReversal_suffic");///span[contains(@class,"reversal")]
        slots_fleetReversal_titleAtribute_suffix = properties.getProperty("slots_fleetReversal_titleAtribute_suffix");///span[contains(@class,"reversal")]@title
        slots_fleetTargetPlanet_suffix = properties.getProperty("slots_fleetTargetPlanet_suffix");///span[@class="destinationData"]//a
        slots_fleetComeBack_suffix = properties.getProperty("slots_fleetComeBack_suffix");///span[contains(@id,"timerNext_")]
        slots_fleetComeBack_titleAtribute_suffix = properties.getProperty("slots_fleetComeBack_titleAtribute_suffix");///span[contains(@id,"timerNext_")]@title
    }

    public String getSlots_fleet_by_id(int i) {
        return slots_fleet_by_id.replace("%i", Integer.toString(i));
    }

    public String getSlots_fleet_by_number(int i) {
        return slots_fleet_by_number.replace("%i", Integer.toString(i));
    }

    public String getSlots_fleetAllianceName_suffix() {
        return slots_fleetAllianceName_suffix;
    }

    public String getSlots_fleetArrival_suffix() {
        return slots_fleetArrival_suffix;
    }

    public String getSlots_fleetComeBack_suffix() {
        return slots_fleetComeBack_suffix;
    }

    public String getSlots_fleetComeBack_titleAtribute_suffix() {
        return slots_fleetComeBack_titleAtribute_suffix;
    }

    public String getSlots_fleetId_suffix() {
        return slots_fleetId_suffix;
    }

    public String getSlots_fleetMission_suffix() {
        return slots_fleetMission_suffix;
    }

    public String getSlots_fleetOriginPlanet_suffix() {
        return slots_fleetOriginPlanet_suffix;
    }

    public String getSlots_fleetReversal_suffic() {
        return slots_fleetReversal_suffic;
    }

    public String getSlots_fleetReversal_titleAtribute_suffix() {
        return slots_fleetReversal_titleAtribute_suffix;
    }

    public String getSlots_fleetTargetPlanet_suffix() {
        return slots_fleetTargetPlanet_suffix;
    }

    public String getSlots_maxExp() {
        return slots_maxExp;
    }

    public String getSlots_maxFleets() {
        return slots_maxFleets;
    }

    public String getSlots_useExp() {
        return slots_useExp;
    }

    public String getSlots_usedFleets() {
        return slots_usedFleets;
    }
    
    

    public String getPerformance_d() {
        return performance_d;
    }

    public String getPerformance_ef() {
        return performance_ef;
    }

    public String getPerformance_es() {
        return performance_es;
    }

    public String getPerformance_k() {
        return performance_k;
    }

    public String getPerformance_m() {
        return performance_m;
    }

    public String getPerformance_ok() {
        return performance_ok;
    }

    public String getPerformance_ss() {
        return performance_ss;
    }

    public String getPerformance_select() {
        return performance_select;
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

    public String getEvent_list_time_parser_day() {
        return event_list_time_parser_day;
    }

    public String getEvent_list_time_parser_hour() {
        return event_list_time_parser_hour;
    }

    public String getEvent_list_time_parser_minute() {
        return event_list_time_parser_minute;
    }

    public String getEvent_list_time_parser_second() {
        return event_list_time_parser_second;
    }

    public String getEvent_list_atribute_is_attack() {
        return event_list_atribute_is_attack;
    }

    public String getEvent_list_atribute_is_enemy() {
        return event_list_atribute_is_enemy;
    }

    public String getEvent_list_atribute_is_spy() {
        return event_list_atribute_is_spy;
    }

    public String getEvent_list_atribute_arrival_time() {
        return event_list_atribute_arrival_time;
    }

    public String getEvent_list_atribute_count_down_time() {
        return event_list_atribute_count_down_time;
    }

    public String getEvent_list_atribute_destCoords() {
        return event_list_atribute_destCoords;
    }

    public String getEvent_list_atribute_destFleet() {
        return event_list_atribute_destFleet;
    }

    public String getEvent_list_atribute_detailsFleet() {
        return event_list_atribute_detailsFleet;
    }

    public String getEvent_list_atribute_is_friendly() {
        return event_list_atribute_is_friendly;
    }

    public String getEvent_list_atribute_is_neutral() {
        return event_list_atribute_is_neutral;
    }

    public String getEvent_list_atribute_originCoords() {
        return event_list_atribute_originCoords;
    }

    public String getEvent_list_atribute_originFleet() {
        return event_list_atribute_originFleet;
    }

    public String getEvent_list_class_atribute() {
        return event_list_class_atribute;
    }

    public String getEvent_list_class_atribute_enemy_alliance() {
        return event_list_class_atribute_enemy_alliance;
    }

    public String getEvent_list_class_atribute_friendly() {
        return event_list_class_atribute_friendly;
    }

    public String getEvent_list_class_atribute_friendly_return() {
        return event_list_class_atribute_friendly_return;
    }

    public String getEvent_list_flight(int i) {
        return event_list_flight.replace("%i", Integer.toString(i));
    }

    public String getEvent_list_root() {
        return event_list_root;
    }

    public String getLeftButtonEventList() {
        return leftButtonEventList;
    }

    public String getLeftButtonFlightsList() {
        return leftButtonFlightsList;
    }

    public String getLeftButtonResourceSettings() {
        return leftButtonResourceSettings;
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

    public String getLogout_button() {
        return logout_button;
    }

    public String getChangeplanetbyid(int i) {
        return changeplanetbyid.replace("%i", Integer.toString(i));
    }

    public String getChangeplanetbyName(String s) {
        return changeplanetbyName.replace("%s", s);
    }

    public String getCountplanet() {
        return countplanet;
    }

    public int getCountplanet_result_pos() {
        return countplanet_result_pos;
    }

    public String getCountplanet_separator() {
        return countplanet_separator;
    }

    public String getChangeplanetgetCoords(int i) {
        return changeplanetgetCoords.replace("%i", Integer.toString(i));
    }

    public String getChangeplanetgetName(int i) {
        return changeplanetgetName.replace("%i", Integer.toString(i));
    }

    public String getLogin_login_with_pass_button() {
        return login_login_with_pass_button;
    }

    public String getLogin_nick_target() {
        return login_nick_target;
    }

    public String getLogin_pass_target() {
        return login_pass_target;
    }

    public String getLogin_uni_pref() {
        return login_uni_pref;
    }

    public String getLogin_uni_target() {
        return login_uni_target;
    }

    public String getDefence_number() {
        return defence_number;
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
        return buildBuilding_depositeStation;
    }

    public String getBuilding_ed() {
        return buildBuilding_deuterium;
    }

    public String getBuilding_ef() {
        return buildBuilding_fussion;
    }

    public String getBuilding_es() {
        return buildBuilding_solar;
    }

    public String getBuilding_fn() {
        return buildBuilding_nanitas;
    }

    public String getBuilding_fr() {
        return buildBuilding_robots;
    }

    public String getBuilding_kc() {
        return buildBuilding_crystal;
    }

    public String getBuilding_km() {
        return buildBuilding_metal;
    }

    public String getBuilding_lb() {
        return buildBuilding_laboratory;
    }

    public String getBuilding_mc() {
        return buildBuilding_crystalStorage;
    }

    public String getBuilding_md() {
        return buildBuilding_deuteriumStorage;
    }

    public String getBuilding_mm() {
        return buildBuilding_metalStorage;
    }

    public String getBuilding_resourcesNEG() {
        return buildBuilding_resourcesButtonDisabled;
    }

    public String getBuilding_resourcesOK() {
        return buildBuilding_resourcesButtonEnabled;
    }

    public String getBuilding_sc() {
        return buildBuilding_crystalHideout;
    }

    public String getBuilding_sd() {
        return buildBuilding_deuteriumHideout;
    }

    public String getBuilding_sm() {
        return buildBuilding_metalHideout;
    }

    public String getBuilding_sr() {
        return buildBuilding_missileSilo;
    }

    public String getBuilding_ss() {
        return buildBuilding_solerSatellite;
    }

    public String getBuilding_st() {
        return buildBuilding_shipyard;
    }

    public String getBuilding_stationNEG() {
        return buildBuilding_buildButtonDisabled;
    }

    public String getBuilding_stationOK() {
        return buildButtonEnabled;
    }

    public String getBuilding_te() {
        return buildBuilding_terraformer;
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
