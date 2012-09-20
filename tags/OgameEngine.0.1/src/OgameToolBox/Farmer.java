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
import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.Ogame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Klasa wykonywalna w procesie farmienia
 * @author Piotr Kowalski
 */
public class Farmer {

    /**
     * Konstruktor nowego obiektu farmiącego
     */
    public Farmer() {
        list = new HashMap<PlanetElement, FarmingList>();
        this.planetWithSonds = null;
        this.freeSlotsLeft=0;
    }

    /**
     * Konstruktor nowego obiektu farmiącego
     * @param planetWithSonds obiekt planety z sondami
     */
    public Farmer(Planet planetWithSonds) {
        list = new HashMap<PlanetElement, FarmingList>();
        this.planetWithSonds = planetWithSonds;
        this.freeSlotsLeft=0;
    }
    
    /**
     * Konstruktor zostawiajacy pewną ilość wolnych slotów
     * @param planetWithSonds planeta z sondami
     * @param freeSlotsLeft ilość slotów która mają pozostać wolne (nie powinno blokować możliwości nadania fs-a)
     */
    public Farmer(Planet planetWithSonds,int freeSlotsLeft) {
        list = new HashMap<PlanetElement, FarmingList>();
        this.planetWithSonds = planetWithSonds;
        this.freeSlotsLeft=freeSlotsLeft;
    }

    /**
     * Dodanie listy farmingowej z planety
     * @param p planeta
     * @param fl lista farmingowa
     */
    public void add(PlanetElement p, FarmingList fl) {
        list.put(p, fl);
    }

    /**
     * Dodanie kordów do farmienia z planety
     * @param p planeta
     * @param c tablica kordynatów
     */
    public void add(PlanetElement p, Coords[] c) {
        list.put(p, new FarmingList(c, p.getPlanet()));
    }
    
        /**
     * Dodanie kordów do farmienia z planety
     * @param p planeta
     * @param farming flota farmiąca
     * @param c tablica kordynatów
     */
    public void add(PlanetElement p, Coords[] c,Fleet farming) {
        list.put(p, new FarmingList(c,farming, p.getPlanet()));
    }

    /**
     * Dodanie pojedynczego kordu do listy danej planety
     * @param p planeta
     * @param c kordynat
     */
    public void add(PlanetElement p, Coords c) {
        FarmingList temp = list.get(p);
        temp.add(c, p.getPlanet());
    }

    public TimePeriod farm(Ogame o) throws OgameElementNotFoundException, OgameException {
        List<TimePeriod> returns = new ArrayList<TimePeriod>();
        Set<Entry<PlanetElement, FarmingList>> set = this.list.entrySet();
        Iterator<Entry<PlanetElement, FarmingList>> it = set.iterator();
        int i;
        int size;
        FarmingList fl;
        FarmingElement fe;
        
        for (Entry<PlanetElement, FarmingList> temp; it.hasNext();) {
            temp = it.next();
            o.changePlanet(temp.getKey().getPlanet());
            i = 0;
            size = temp.getKey().isFs() ? temp.getKey().getFleetCount() - 1 : temp.getKey().getFleetCount();
            while (i < size) {
                try {
                    fl = temp.getValue();
                    fe = fl.next();
                    returns.add(o.sendFleet(fe.getFleet(), fe.getDestination(), fe.getSpeed(), Mission.ATTACK, Resources.NO_RESOURCES).getFlyingTime());
                    i++;
                } catch (OgameException ex) {
                    System.err.println(ex.getMessage());
                    if (ex == OgameException.FLEET_NO_FLEET_ON_PLANET) {
                        // throw ex;
                    }
                } catch (Exception ex){
                    System.err.println(ex.getMessage());
                }
            }
            while (temp.getKey().isFs()&&size>-1) {
                try {
                    fe = temp.getValue().next();
                    returns.add(o.sendFleet(temp.getKey().getFsFleet(), fe.getDestination(), fe.getSpeed(), Mission.ATTACK, Resources.ALL_RESOURCES).getFlyingTime());
                    break;
                } catch (OgameException ex) {
                    if (ex == OgameException.FLEET_NO_FLEET_ON_PLANET) {
                        // throw ex;
                    }
                }
            }
        }
        TimePeriod max = TimePeriod.max(returns);
        return max;
    }
    
    public TimePeriod scanAndFarm(Ogame o) throws OgameException {
        if (this.planetWithSonds!=null){
            o.changePlanet(planetWithSonds);
        }
        
        ScanList tempScan;
        List<Report> tempList;
        Map<PlanetElement,FarmingList> newlist = new HashMap<PlanetElement,FarmingList>();
        List<ReportElement> joinedRaportList = new ArrayList<ReportElement>();
        try {
        Set<Entry<PlanetElement,FarmingList>> set = list.entrySet();
        Iterator<Entry<PlanetElement,FarmingList>> it = set.iterator();
        for (Entry<PlanetElement,FarmingList> temp;it.hasNext();){
            temp = it.next();
            tempScan=new ScanList(temp.getValue().getCoordsArray());
            tempList = tempScan.scan(o);
            System.out.println(temp.getKey().getPlanet().getName()+"\n"+Report.printList(tempList));
            // twardy kawałek
            // z planet gdzie ma być fs do wspólnej tablicy zrzucamy wszystko prócz pierwszego elementu
            // z planet gdzie fs nie ma być możemy wrzucić wszystko
            ReportElement.join(joinedRaportList,temp.getKey().isFs()?ReportElement.createListSkipFirst(temp.getKey(), tempList):ReportElement.createList(temp.getKey(), tempList));
            newlist.put(temp.getKey(),Report.getFarmingList(tempList, temp.getKey().getPlanet())); // new FarmingList(Report.getCoordsArray(tempList),temp.getKey().getPlanet())
            
        }
        // Teraz joinedRaportList zawiera wszystkie raporty w parze z planetami, trzeba posortować
        ReportElement.sortDESC(joinedRaportList);
        System.out.println(ReportElement.printList(joinedRaportList)); 
        // Teraz przypisujemy wartości flot na każdą planetę
        int totalFleets = o.getSlotsTotal()-o.getSlotsOccupied()-this.freeSlotsLeft;
        int assignedFleets=0;
        // najpierw +1 flota tam gdzie fs
        Set<Entry<PlanetElement,FarmingList>> set2 = newlist.entrySet();
        Iterator<Entry<PlanetElement,FarmingList>> it2 = set2.iterator();
        for (Entry<PlanetElement,FarmingList> temp;it2.hasNext();){
            temp = it2.next();
            if (temp.getKey().isFs()) {
                temp.getKey().setFleetCount(1);
                assignedFleets++;
            }
            else temp.getKey().setFleetCount(0);
        }
        // teraz pozostałe najlepsze
        Iterator<ReportElement> iter = joinedRaportList.iterator();
        PlanetElement pe;
        for (int i=0; i <totalFleets-assignedFleets & iter.hasNext();i++){
            pe=iter.next().getPlanetElement();
            pe.setFleetCount(pe.getFleetCount()+1);
        }
        this.list=newlist;
        } catch (OgameException ex){}
        finally{
        return farm(o);
        }
    }
    
    private Map<PlanetElement, FarmingList> list;
    private Planet planetWithSonds;
    private int freeSlotsLeft;
    
}
