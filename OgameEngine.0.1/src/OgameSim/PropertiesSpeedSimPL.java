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

    /**
     * @return the attackerKol
     */
    public String getAttackerKol() {
        return attackerKol;
    }
}
