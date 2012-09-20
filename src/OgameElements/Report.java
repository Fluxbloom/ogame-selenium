/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.PlanetResources;
import OgameElementsUnchecked.Ships;
import OgameElementsUnchecked.Speed;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameToolBox.FarmingElement;
import OgameToolBox.FarmingList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa odpowiada raportowi w Ogame i zawiera wszystkie jego wewnętrzne operacje
 * @author Piotr Kowalski
 */
public class Report extends Message implements Comparable{
    /**
     * Konstruktor podstawowego raportuS
     * @param cords kordynaty
     * @param resources zasoby na planecie
     */
    public Report(Coords cords, PlanetResources resources) {
        this.cords = cords;
        this.resources = resources;
    }
    /**
     * Zwraca koordynaty z raportu
     * @return koordynaty z raportu
     */
    public Coords getCords() {
        return cords;
    }
    /**
     * Zwraca zapasy z planety
     * @return zapasy z planety
     */
    public PlanetResources getResources() {
        return resources;
    }
    
    /**
     * Zwraca stan obiektu
     * @return stan obiektu
     */
    
    @Override
    public String toString() {
        return "Report{" + "cords=" + cords + ", resources=" + resources + '}';
    }
    /**
     * Porównuje dwa raporty porządkując je względem sumy surowców
     * @param arg0 porównywany obiekt
     * @return różnica w ilości surowców na planetach
     */
    public String print() throws OgameFileNotFoundException, OgameIOException{
        return this.cords.shortPrint() + resources.toString();
    }
    @Override
    public int compareTo(Object arg0) {
        int sum = this.resources.getMetal()+this.resources.getCrystal()+this.resources.getDeuterium();
        Report arg = (Report) arg0;
        int other = arg.resources.getMetal()+arg.resources.getCrystal()+arg.resources.getDeuterium();
        return sum-other;
    }
    /**
     * Zwraca sumę surowców na planecie
     * @return suma surowców na planecie
     */
    public int sum(){
        return this.resources.getMetal()+this.resources.getCrystal()+this.resources.getDeuterium();
    }
    /**
     * Wyprowadza listę kordynatów z listy raportów
     * @param lr lista raportów
     * @return lista kordynatów
     */
    public static List<Coords> getCoordsArray(List<Report> lr){
        List<Coords> array = new ArrayList<Coords>();
        Iterator<Report> it = lr.iterator();
        while(it.hasNext()){
            array.add(it.next().getCords());
        }
        return array;
    }
    /**
     * Wyprowadza farming liste z listy raportów
     * @param lr lista raportów
     * @return farming lista
     */
    public static FarmingList getFarmingList(List<Report> lr,Planet p){
        FarmingList fl = new FarmingList();
        Iterator<Report> it = lr.iterator();
        Report temp;
        Fleet f;
        while(it.hasNext()){
            temp = it.next();
            f = new Fleet();
            double ships = ( (double) temp.sum()) / 10000.0;
            f.add(Ships.MT, (int) (ships+1));
            fl.add(new FarmingElement(temp.getCords(),p.getCoords().isSameSystem(temp.getCords())?Speed.S60:Speed.S100,f));
        }
        return fl;
    }
    /**
     * Sortuje listę raportów w porządku malejącycm
     * @param lista do posortowania w miejscu
     */
    public static void sortDESC(List<Report> lr){
        Collections.sort(lr);
        Collections.reverse(lr);
    }
    /**
     * Metoda dołacza elementy drugiej listy do pierwszej
     * @param joined lista łącząca 
     * @param joining lista dołączana
     */
    public static void joinLists(List<Report> joined, List<Report> joining){
        Iterator<Report> it = joining.iterator();
        while(it.hasNext()){
            joined.add(it.next());
        }
    }
    /**
     * Metoda wypisuje listę raportów do obiektu String
     * @param reports Lista raportów
     * @return String z wynikiem raportów
     * @throws OgameFileNotFoundException Błąd braku pliku z konfiguracją
     * @throws OgameIOException Błąd dostępu do pliku z konfiguracją
     */
    public static String printList(List<Report> reports) throws OgameFileNotFoundException, OgameIOException{
        String s ="";
        Iterator<Report> iter = reports.iterator();
        while(iter.hasNext()){
            s+=iter.next().print()+"\n";
        }
        return s;
    }
    
    private Coords cords;
    private PlanetResources resources;


}
