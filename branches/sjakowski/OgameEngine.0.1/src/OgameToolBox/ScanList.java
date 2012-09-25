/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Coords;
import OgameElements.Report;
import OgameElements.TimePeriod;
import OgameElements.Fleet;
import OgameElements.Mission;
import OgameElements.PlanetResources;
import OgameElements.PlanetResources;
import OgameElements.Resources;
import OgameElements.Ships;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Ogame;
import java.util.ArrayList;
import java.util.Collections;
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
    public ScanList(List<FleetElement> scanningList) {
        this.scanningList = scanningList;
    }

    /**
     * Kontruktor konwertujący z statycznej tablicy
     * @param scanningList lista kordów do skanowania
     */
    public ScanList(Coords[] scanningList) {
        List<FleetElement> list = new ArrayList<FleetElement>();
        for (int i = 0; i < scanningList.length; i++) {
            list.add(new FleetElement(scanningList[i]));
        }
        this.scanningList = list;
    }
    /**
     * Konstruktor z dodatkową flotą definiowaną do skanowania
     * @param scanningList tablica planet do skanowania
     * @param scanningFleet flota skanująca
     */
    public ScanList(Coords[] scanningList, Fleet scanningFleet) {
        List<FleetElement> list = new ArrayList<FleetElement>();
        for (int i = 0; i < scanningList.length; i++) {
            list.add(new FleetElement(scanningList[i], scanningFleet));
        }
        this.scanningList = list;
    }
    /**
     * Tworzy listę skanowania z listy farmingowej
     * @param lista 
     */
    public ScanList(FarmingList lista){
        this.scanningList = lista.getList();
    }
    
    public List<Report> scan(Ogame o) throws OgameException {
        List<Report> skipList = new ArrayList<Report>();
        int slotsFree = o.getSlotsTotal() - o.getSlotsOccupied();
        System.out.println("Will scan with " + slotsFree + " fleets");
        List<TimePeriod> returns = new ArrayList<TimePeriod>();
        TimePeriod longest;
        Iterator<FleetElement> it = this.scanningList.iterator();
        int currentSend = 0, totalsend = 0;
        for (FleetElement temp; it.hasNext();) {
            temp = it.next();
            if (temp.isLastSend()) {// jesli poprzednio atakowany to odpuszczamy jego skanowanie
                // ale nie możemy stracić go z listy, tworzymy więc sztuczny raport
                skipList.add(new Report(temp.getDestination(),new PlanetResources(0,0,0,0)));
                continue;
            } 
            try {
                returns.add(
                        o.sendFleet(scanningFleet, temp.getDestination(), temp.getSpeed(),
                        Mission.SPY, Resources.NO_RESOURCES).getFlyingTime());
            } catch (OgameException ex) {
                continue;
            }
            currentSend++;
            totalsend++;
            if (currentSend % slotsFree == 0 && !returns.isEmpty()) {
                longest = TimePeriod.max(returns);// ponowna próba za 10 minut
                o.wait(longest);
                returns = new ArrayList<TimePeriod>();
                slotsFree = o.getSlotsTotal() - o.getSlotsOccupied();
                currentSend = 0;
                System.out.println("Will scan with " + slotsFree + " fleets");
            }
        }
        if (!returns.isEmpty()) {
            longest = TimePeriod.max(returns);
            o.wait(longest);
        }
        List<Report> list = o.getReports(totalsend);
        list.addAll(skipList);
        Collections.sort(list);
        Collections.reverse(list); // porządkujemy rosnąco
        return list;
    }
    private static final Fleet sondFleet = new Fleet();
    static {
        sondFleet.add(Ships.SOND, 3);
    }

    private List<FleetElement> scanningList;
    private Fleet scanningFleet = ScanList.sondFleet;
}
