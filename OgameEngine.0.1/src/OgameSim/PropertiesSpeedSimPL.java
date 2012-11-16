/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameSim;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author andrzej
 */
public class PropertiesSpeedSimPL {

    public PropertiesSpeedSimPL() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir") + "/conf/sim/speedsimpl.properties";
        File main = new File(path);
        properties.load(new FileInputStream(main));
        this.attackerMT = properties.getProperty("attacker_mt");
        this.attackerDT = properties.getProperty("attacker_dt");
        this.attackerLM = properties.getProperty("attacker_lm");
        this.attackerCM = properties.getProperty("attacker_cm");
        this.attackerKr = properties.getProperty("attacker_kr");
        this.attackerOW = properties.getProperty("attacker_ow");
        this.attackerKol = properties.getProperty("attacker_kol");
        this.attackerPan = properties.getProperty("attacker_pan");
        this.attackerGS = properties.getProperty("attacker_gs");
        this.attackerBomb = properties.getProperty("attacker_bomb");
        this.attackerNisz = properties.getProperty("attacker_nisz");
        this.attackerRec = properties.getProperty("attacker_rec");
        this.attackerSond = properties.getProperty("attacker_sond");
        this.attackerRM = properties.getProperty("attacker_rm");
        this.defenderMT = properties.getProperty("defender_mt");
        this.defenderDT = properties.getProperty("defender_dt");
        this.defenderLM = properties.getProperty("defender_lm");
        this.defenderCM = properties.getProperty("defender_cm");
        this.defenderKr = properties.getProperty("defender_kr");
        this.defenderOW = properties.getProperty("defender_ow");
        this.defenderKo = properties.getProperty("defender_ko");
        this.defenderPan = properties.getProperty("defender_pan");
        this.defenderGS = properties.getProperty("defender_gs");
        this.defenderBomb = properties.getProperty("defender_bomb");
        this.defenderNisz = properties.getProperty("defender_nisz");
        this.defenderKol = properties.getProperty("defender_kol");
        this.defenderRec = properties.getProperty("defender_rec");
        this.defenderSond = properties.getProperty("defender_sond");
        this.defenderSS = properties.getProperty("defender_ss");
        this.defenderWR = properties.getProperty("defender_wr");
        this.defenderLDL = properties.getProperty("defender_ldl");
        this.defenderCDL = properties.getProperty("defender_cdl");
        this.defenderDG = properties.getProperty("defender_dg");
        this.defenderDJ = properties.getProperty("defender_dj");
        this.defenderWP = properties.getProperty("defender_wp");
        this.defenderMPO = properties.getProperty("defender_mpo");
        this.defenderDPO = properties.getProperty("defender_dpo");
        this.defenderPR = properties.getProperty("defender_pr");
        this.adress = properties.getProperty("adress");
        this.submitButton = properties.getProperty("submitButton");
        this.pz_surowce = properties.getProperty("pz_surowce");
        this.atacker_loss = properties.getProperty("atacker_loss");
        this.defender_loss = properties.getProperty("defender_loss");
        this.theoretical_profit = properties.getProperty("theoretical_profit");
        this.real_profit = properties.getProperty("real_profit");
        this.metal = properties.getProperty("metal");
        this.crystal = properties.getProperty("crystal");
        this.deuter = properties.getProperty("deuter");
        this.resource_value = properties.getProperty("resource_value");
        this.coords = properties.getProperty("coords");
        this.basicint = properties.getProperty("basicint");
        this.atacker_won = properties.getProperty("atacker_won");
        this.defender_won = properties.getProperty("defender_won");
        this.round_number = properties.getProperty("round_number");
        this.recycler_number = properties.getProperty("recycler_number");
        this.flight_time = properties.getProperty("flight_time");

        this.battle_place = properties.getProperty("battle_place");
        this.result = properties.getProperty("result");
        this.moon_prob = properties.getProperty("moon_prob");
        this.deuter_need = properties.getProperty("deuter_need");
        this.flight = properties.getProperty("flight");
        this.collected = properties.getProperty("collected");
        this.dt=properties.getProperty("dt");
        

    }

    public String getAttackerMT() {
        return attackerMT;
    }

    /**
     * @return the attackerDT
     */
    public String getAttackerDT() {
        return attackerDT;
    }

    /**
     * @return the attackerLM
     */
    public String getAttackerLM() {
        return attackerLM;
    }

    /**
     * @return the attackerCM
     */
    public String getAttackerCM() {
        return attackerCM;
    }

    /**
     * @return the attackerKr
     */
    public String getAttackerKr() {
        return attackerKr;
    }

    /**
     * @return the attackerOW
     */
    public String getAttackerOW() {
        return attackerOW;
    }

    /**
     * @return the attackerPan
     */
    public String getAttackerPan() {
        return attackerPan;
    }

    /**
     * @return the attackerGS
     */
    public String getAttackerGS() {
        return attackerGS;
    }

    /**
     * @return the attackerBomb
     */
    public String getAttackerBomb() {
        return attackerBomb;
    }

    /**
     * @return the attackerNisz
     */
    public String getAttackerNisz() {
        return attackerNisz;
    }

    /**
     * @return the attackerRec
     */
    public String getAttackerRec() {
        return attackerRec;
    }

    /**
     * @return the attackerSond
     */
    public String getAttackerSond() {
        return attackerSond;
    }

    /**
     * @return the attackerRM
     */
    public String getAttackerRM() {
        return attackerRM;
    }

    /**
     * @return the defenderMT
     */
    public String getDefenderMT() {
        return defenderMT;
    }

    /**
     * @return the defenderDT
     */
    public String getDefenderDT() {
        return defenderDT;
    }

    /**
     * @return the defenderLM
     */
    public String getDefenderLM() {
        return defenderLM;
    }

    /**
     * @return the defenderCM
     */
    public String getDefenderCM() {
        return defenderCM;
    }

    /**
     * @return the defenderKr
     */
    public String getDefenderKr() {
        return defenderKr;
    }

    /**
     * @return the defenderOW
     */
    public String getDefenderOW() {
        return defenderOW;
    }

    /**
     * @return the defenderKo
     */
    public String getDefenderKo() {
        return defenderKo;
    }

    /**
     * @return the defenderPan
     */
    public String getDefenderPan() {
        return defenderPan;
    }

    /**
     * @return the defenderGS
     */
    public String getDefenderGS() {
        return defenderGS;
    }

    /**
     * @return the defenderBomb
     */
    public String getDefenderBomb() {
        return defenderBomb;
    }

    /**
     * @return the defenderNisz
     */
    public String getDefenderNisz() {
        return defenderNisz;
    }

    /**
     * @return the defenderKol
     */
    public String getDefenderKol() {
        return defenderKol;
    }

    /**
     * @return the defenderRec
     */
    public String getDefenderRec() {
        return defenderRec;
    }

    /**
     * @return the defenderSond
     */
    public String getDefenderSond() {
        return defenderSond;
    }

    /**
     * @return the defenderSS
     */
    public String getDefenderSS() {
        return defenderSS;
    }

    /**
     * @return the defenderWR
     */
    public String getDefenderWR() {
        return defenderWR;
    }

    /**
     * @return the defenderLDL
     */
    public String getDefenderLDL() {
        return defenderLDL;
    }

    /**
     * @return the defenderCDL
     */
    public String getDefenderCDL() {
        return defenderCDL;
    }

    /**
     * @return the defenderDG
     */
    public String getDefenderDG() {
        return defenderDG;
    }

    /**
     * @return the defenderDJ
     */
    public String getDefenderDJ() {
        return defenderDJ;
    }

    /**
     * @return the defenderWP
     */
    public String getDefenderWP() {
        return defenderWP;
    }

    /**
     * @return the defenderMPO
     */
    public String getDefenderMPO() {
        return defenderMPO;
    }

    /**
     * @return the defenderDPO
     */
    public String getDefenderDPO() {
        return defenderDPO;
    }

    /**
     * @return the defenderPR
     */
    public String getDefenderPR() {
        return defenderPR;
    }
    private String attackerMT;
    private String attackerDT;
    private String attackerLM;
    private String attackerCM;
    private String attackerKr;
    private String attackerOW;
    private String attackerPan;
    private String attackerGS;
    private String attackerBomb;
    private String attackerNisz;
    private String attackerKol;
    private String attackerRec;
    private String attackerSond;
    private String attackerRM;
    private String defenderMT;
    private String defenderDT;
    private String defenderLM;
    private String defenderCM;
    private String defenderKr;
    private String defenderOW;
    private String defenderKo;
    private String defenderPan;
    private String defenderGS;
    private String defenderBomb;
    private String defenderNisz;
    private String defenderKol;
    private String defenderRec;
    private String defenderSond;
    private String defenderSS;
    private String defenderWR;
    private String defenderLDL;
    private String defenderCDL;
    private String defenderDG;
    private String defenderDJ;
    private String defenderWP;
    private String defenderMPO;
    private String defenderDPO;
    private String defenderPR;
    private String adress;
    private String submitButton;
    private String pz_surowce, atacker_loss, defender_loss, theoretical_profit, real_profit, battle_place, result, moon_prob, deuter_need, flight;
    private String metal, crystal, deuter, resource_value, coords, basicint, atacker_won, defender_won, round_number, recycler_number, flight_time,collected,dt;

    /**
     * @return the attackerKol
     */
    public String getAttackerKol() {
        return attackerKol;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @return the submitButton
     */
    public String getSubmitButton() {
        return submitButton;
    }

    /**
     * @return the pz_surowce
     */
    public String getPz_surowce() {
        return pz_surowce;
    }

    /**
     * @return the atacker_loss
     */
    public String getAtacker_loss() {
        return atacker_loss;
    }

    /**
     * @return the defender_loss
     */
    public String getDefender_loss() {
        return defender_loss;
    }

    /**
     * @return the theoretical_profit
     */
    public String getTheoretical_profit() {
        return theoretical_profit;
    }

    /**
     * @return the real_profit
     */
    public String getReal_profit() {
        return real_profit;
    }

    /**
     * @return the pz_metal
     */
    public String getPz_metal() {
        return getMetal();
    }

    /**
     * @return the metal
     */
    public String getMetal() {
        return metal;
    }

    /**
     * @return the crystal
     */
    public String getCrystal() {
        return crystal;
    }

    /**
     * @return the deuter
     */
    public String getDeuter() {
        return deuter;
    }

    /**
     * @return the resource_value
     */
    public String getResource_value() {
        return resource_value;
    }

    /**
     * @return the coords
     */
    public String getCoords() {
        return coords;
    }

    /**
     * @return the basicint
     */
    public String getBasicint() {
        return basicint;
    }

    /**
     * @return the atacker_won
     */
    public String getAtacker_won() {
        return atacker_won;
    }

    /**
     * @return the defender_won
     */
    public String getDefender_won() {
        return defender_won;
    }

    /**
     * @return the round_number
     */
    public String getRound_number() {
        return round_number;
    }

    /**
     * @return the recycler_number
     */
    public String getRecycler_number() {
        return recycler_number;
    }

    /**
     * @return the flight_time
     */
    public String getFlight_time() {
        return flight_time;
    }

    /**
     * @return the battle_place
     */
    public String getBattle_place() {
        return battle_place;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @return the moon_prob
     */
    public String getMoon_prob() {
        return moon_prob;
    }

    /**
     * @return the deuter_need
     */
    public String getDeuter_need() {
        return deuter_need;
    }

    /**
     * @return the flight
     */
    public String getFlight() {
        return flight;
    }

    /**
     * @return the collected
     */
    public String getCollected() {
        return collected;
    }

    /**
     * @return the dt
     */
    public String getDt() {
        return dt;
    }
}
