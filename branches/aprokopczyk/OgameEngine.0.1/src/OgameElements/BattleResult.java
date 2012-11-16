/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 *
 * @author andrzej
 */
public class BattleResult {

    private Resources agressorLoss, defenderLoss, theoreticalProfit, realProfit;
    private DebrisResources pz;
    private Coords battlePlace;
    private int attacker_won, defender_won, collected, rounds, dtNumber, moon_probability, deuterCost;
    private TimePeriod flightTime;

    public BattleResult(Resources agressorLoss, Resources defenderLoss, Resources theoreticalProfit, Resources realProfit, DebrisResources pz,
            Coords battlePlace, int attacker_won, int defender_won, int collected, int rounds, int dtNumber, int moonprobability, int deuterCost, TimePeriod flightTime) {
        this.agressorLoss=agressorLoss;
        this.defenderLoss=defenderLoss;
        this.theoreticalProfit=theoreticalProfit;
        this.realProfit=realProfit;
        this.pz=pz;
        this.battlePlace=battlePlace;
        this.attacker_won=attacker_won;
        this.defender_won=defender_won;
        this.collected=collected;
        this.rounds=rounds;
        this.dtNumber=dtNumber;
        this.moon_probability=moonprobability;
        this.flightTime=flightTime;
        this.deuterCost=deuterCost;
        
        
    }

    /**
     * @return the agressorLoss
     */
    public Resources getAgressorLoss() {
        return agressorLoss;
    }

    /**
     * @return the defenderLoss
     */
    public Resources getDefenderLoss() {
        return defenderLoss;
    }

    /**
     * @return the theoreticalProfit
     */
    public Resources getTheoreticalProfit() {
        return theoreticalProfit;
    }

    /**
     * @return the realProfit
     */
    public Resources getRealProfit() {
        return realProfit;
    }

    /**
     * @return the pz
     */
    public DebrisResources getPz() {
        return pz;
    }

    /**
     * @return the battlePlace
     */
    public Coords getBattlePlace() {
        return battlePlace;
    }

    /**
     * @return the attacker_won
     */
    public int getAttacker_won() {
        return attacker_won;
    }

    /**
     * @return the defender_won
     */
    public int getDefender_won() {
        return defender_won;
    }

    /**
     * @return the collected
     */
    public int getCollected() {
        return collected;
    }

    /**
     * @return the rounds
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * @return the dtNumber
     */
    public int getDtNumber() {
        return dtNumber;
    }

    /**
     * @param agressorLoss the agressorLoss to set
     */
    public void setAgressorLoss(Resources agressorLoss) {
        this.agressorLoss = agressorLoss;
    }

    /**
     * @param defenderLoss the defenderLoss to set
     */
    public void setDefenderLoss(Resources defenderLoss) {
        this.defenderLoss = defenderLoss;
    }

    /**
     * @param theoreticalProfit the theoreticalProfit to set
     */
    public void setTheoreticalProfit(Resources theoreticalProfit) {
        this.theoreticalProfit = theoreticalProfit;
    }

    /**
     * @param realProfit the realProfit to set
     */
    public void setRealProfit(Resources realProfit) {
        this.realProfit = realProfit;
    }

    /**
     * @param pz the pz to set
     */
    public void setPz(DebrisResources pz) {
        this.pz = pz;
    }

    /**
     * @param battlePlace the battlePlace to set
     */
    public void setBattlePlace(Coords battlePlace) {
        this.battlePlace = battlePlace;
    }

    /**
     * @param attacker_won the attacker_won to set
     */
    public void setAttacker_won(int attacker_won) {
        this.attacker_won = attacker_won;
    }

    /**
     * @param defender_won the defender_won to set
     */
    public void setDefender_won(int defender_won) {
        this.defender_won = defender_won;
    }

    /**
     * @param collected the collected to set
     */
    public void setCollected(int collected) {
        this.collected = collected;
    }

    /**
     * @param rounds the rounds to set
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    /**
     * @param dtNumber the dtNumber to set
     */
    public void setDtNumber(int dtNumber) {
        this.dtNumber = dtNumber;
    }

    /**
     * @return the moon_probability
     */
    public int getMoon_probability() {
        return moon_probability;
    }

    /**
     * @return the flightTime
     */
    public TimePeriod getFlightTime() {
        return flightTime;
    }

    /**
     * @return the deuterCost
     */
    public int getDeuterCost() {
        return deuterCost;
    }
    public String toString(){
        return  "Bitwa na: "+battlePlace.toString()+"\nRezultat: Atakujacy wygral:"+Integer.toString(attacker_won)+" Obronca wygral:"+Integer.toString(defender_won)+" Zebrane:"+Integer.toString(collected)+" Ilosc rund:"+Integer.toString( rounds)+"\n Pole zniszczeń: "+pz.toString()+"\nSzansa na ksiezyc:"+Integer.toString(moon_probability)+"\nStraty agresora: " +agressorLoss.toString()+"\nStraty obroncy"+ defenderLoss.toString()+"\nTeoretyczny zysk: "+ theoreticalProfit.toString()+" Potrzeba duzych transporterow:"+Integer.toString(dtNumber) +"\nRzeczywisty zysk: "+ realProfit.toString()+"\nPotrzeba deuteru:"+Integer.toString(deuterCost)+"\nCzas lotu:"+flightTime.toString();
    }
}
