/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Report;
import OgameElements.Planet;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa łącząca reporty z planetami
 * @author Piotr Kowalski
 */
public class ReportElement implements Comparable {
    /**
     * Konstruktor elementów
     * @param report obiekt raportu
     * @param planetElement element planety z której raport pochodzi
     */
    public ReportElement(Report report, PlanetElement planetElement) {
        this.report = report;
        this.planetElement = planetElement;
    }
    /**
     * Zwraca element planety z danej pary
     * @return element planety
     */
    public PlanetElement getPlanetElement() {
        return planetElement;
    }
    /**
     * Zwraca raport z danej pary
     * @return raport
     */
    public Report getReport() {
        return report;
    } 
    
    /**
     * Metoda porządkująca
     * @param arg0 obiekt z którym porównywany jest nasz
     * @return dodanie gdy większy, ujemne gdy mniejszy, 0 gdy równy
     */
    @Override
    public int compareTo(Object arg0) {
       ReportElement re = (ReportElement) arg0;
        return this.report.compareTo(re.report);
    }
    /**
     * Sortuje malejąca listę w miejscu
     * @param list do sortowania
     */
    public static void sortDESC(List<ReportElement> list){
        Collections.sort(list);
        Collections.reverse(list);
    }
    
    /**
     * Metoda dołacza elementy drugiej listy do pierwszej
     * @param joined lista łącząca 
     * @param joining lista dołączana
     */    
    public static void join(List<ReportElement> joined, List<ReportElement> joining){
        Iterator<ReportElement> it = joining.iterator();
        while(it.hasNext()){
            joined.add(it.next());
        }
    }
    /**
     * Metoda tworzy listę Raport Elementów z obiektu elementu planey od listy raportów
     * @param p element planety do którego przypisane są raporty
     * @param lr lista raportów
     * @return lista raport elementów
     */
    public static List<ReportElement> createList(PlanetElement p, List<Report> lr){
        List<ReportElement> lre = new ArrayList<ReportElement>();
        Iterator<Report> it = lr.iterator();
        while(it.hasNext()){
            lre.add(new ReportElement(it.next(),p));
        }
        return lre;
    }
    
    /**
     * Metoda tworzy listę Raport Elementów z obiektu elementu planey od listy raportów
     * ale pomija pierwszy raport (jako zajęty do fs-a)
     * @param p element planety do którego przypisane są raporty
     * @param lr lista raportów
     * @return lista raport elementów
     */
    public static List<ReportElement> createListSkipFirst(PlanetElement p, List<Report> lr){
        List<ReportElement> lre = new ArrayList<ReportElement>();
        Iterator<Report> it = lr.iterator();
        it.next();
        while(it.hasNext()){
            lre.add(new ReportElement(it.next(),p));
        }
        return lre;
    }
    
    
    public static String printList(List<ReportElement> list) throws OgameFileNotFoundException, OgameIOException{
        String s ="";
        Iterator<ReportElement> it = list.iterator();
        ReportElement temp;
        while(it.hasNext()){
            temp = it.next();
            s+= temp.planetElement.getPlanet().getName()+"->"+temp.report.print()+"\n";
        }
        return s;
    }
    private Report report;
    private PlanetElement planetElement;
}
