/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Coords;
import OgameElements.Report;
import OgameElements.TimePeriod;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.Resources;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Ogame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa odpowiada zarządzanej liście planet do skanowania. Posiada cechy udparniajace ją na błędy
 * @author Piotr Kowalski
 */
public class ScanList {
    /**
     * Konstruktor główny
     * @param scanningList 
     */
    public ScanList(List<ScanElement> scanningList) {
        this.scanningList = scanningList;
    }
   /**
     * Kontruktor konwertujący z statycznej tablicy
     * @param scanningList lista kordów do skanowania
     */
    public ScanList(Coords[] scanningList) {
        List<ScanElement> list = new ArrayList<ScanElement>();
        for (int i=0; i < scanningList.length; i++){
            list.add(new ScanElement(scanningList[i]));
        }
        this.scanningList = list;
    }
    public ScanList(Coords[] scanningList, Fleet scanningFleet){
        List<ScanElement> list = new ArrayList<ScanElement>();
        for (int i=0; i < scanningList.length; i++){
            list.add(new ScanElement(scanningList[i],scanningFleet));
        }
        this.scanningList = list;
    }
  
    public List<Report> scan(Ogame o) throws OgameException{
        int slotsFree = o.getSlotsTotal()-o.getSlotsOccupied();
        List<TimePeriod> returns =new ArrayList<TimePeriod>();
        TimePeriod longest;
        Iterator<ScanElement> it = this.scanningList.iterator();
        int currentSend =0, totalsend=0;
        for (ScanElement temp;it.hasNext();){
            temp = it.next();
            try {
            returns.add(
                    o.sendFleet(temp.getScanFleet(),temp.getDestination(),temp.getSpeed(), 
                    Mission.SPY, Resources.NO_RESOURCES).getFlyingTime()
                    );
            } catch(OgameException ex){
                continue;
            }
            currentSend++;
            totalsend++;
            if (currentSend%slotsFree==0){
                longest = returns.isEmpty()?new TimePeriod(3,0,0):TimePeriod.max(returns);
                o.wait(longest);
                returns = new ArrayList<TimePeriod>();
                slotsFree = o.getSlotsTotal()-o.getSlotsOccupied();
                currentSend=0;
            }
        }

        return null;
    }
    /**
     * Metoda służąca do zalogowania skanowania i zakończenia działania 
     * @param o Obiekt Ogame
     * @param uni nazwa uni
     * @param nick login
     * @param pass hasło
     * @param p obiekt planety
     * @return Lista raportów ze skanowania
     */
    public List<Report> scanAndLogin(Ogame o, String uni, String nick, String pass, Planet p){
        //TODO do zrobienia
        return null;
    }
    
    
    private List<ScanElement> scanningList;
}
