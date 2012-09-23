/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Coords;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Planet;
import OgameElementsUnchecked.Speed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasa odpowiada obiektowi listy farmiącej
 * @author Piotr Kowalski
 */
public class FarmingList {
    /**
     * Konstruktor pustej listy farmingowej
     */
    public FarmingList() {
        list = new ArrayList<FarmingElement>();
        it = list.iterator();
    }
    /**
     * Konstruktor listy farmingowej z tablicy kordynatów
     * @param c tablica kordynatów
     */
    public FarmingList(Coords[] c){
        list = new ArrayList<FarmingElement>();
        for (int i=0; i< c.length; i++){
            list.add(new FarmingElement(c[i]));
        }
        it =list.iterator();
    }
    /**
     * Konstruktor listy farmingowej z tablicy kordynatów z uwzględnieniem ataków w jednym układzie
     * @param c tablica kordynatów
     * @param p planeta nadanie - celem uniknięcia za krótkich ataków w jednym układzie. Ataki te są wysyłane na 60%
     */
    public FarmingList(Coords[] c,Planet p){
        list = new ArrayList<FarmingElement>();
        for (int i=0; i< c.length; i++){
            if (p.getCoords().isSameSystem(c[i])){
                list.add(new FarmingElement(c[i],Speed.S60));
            } else {
            list.add(new FarmingElement(c[i]));
            }
        }
        it =list.iterator();
    }
    /**
     * Konstruktor listy farmingowej z tablicy kordynatów z uwzględnieniem ataków w jednym układzie
     * @param c tablica kordynatów
     * @param farming flota na farming
     * @param p planeta nadanie - celem uniknięcia za krótkich ataków w jednym układzie. Ataki te są wysyłane na 60%
     */
    public FarmingList(Coords[] c,Fleet farming,Planet p){
        list = new ArrayList<FarmingElement>();
        for (int i=0; i< c.length; i++){
            if (p.getCoords().isSameSystem(c[i])){
                list.add(new FarmingElement(c[i],Speed.S60,farming));
            } else {
            list.add(new FarmingElement(c[i]));
            }
        }
        it =list.iterator();
    }
    /**
     * Konstruktor listy farmingowej z listy kordynatów z uwzględnieniem ataków w jednym układzie
     * @param c lista kordynatów
     * @param p planeta nadanie - celem uniknięcia za krótkich ataków w jednym układzie. Ataki te są wysyłane na 60%
     */
    public FarmingList(List<Coords> c,Planet p){
        Iterator<Coords> listt = c.iterator();
        Coords temp;
        while(listt.hasNext()){
            temp = listt.next();
            if (p.getCoords().isSameSystem(temp)){
                list.add(new FarmingElement(temp,Speed.S60));
            } else {
            list.add(new FarmingElement(temp));
            }
        }
        it =list.iterator();
    }
    /**
     * Dodaje kordynatat na listę
     * @param c kordynat
     */
    public void add(Coords c){
        list.add(new FarmingElement(c));
    }
    /**
     * Dodaje kordynatat na listę
     * @param c kordynat
     * @param p planeta do porównania w układzie
     */
    public void add(Coords c,Planet p){
        if (!p.getCoords().isSameSystem(c)){
            list.add(new FarmingElement(c));
        } else {
            list.add(new FarmingElement(c,Speed.S60));
        }
    }

    /**
     * Dodaje nowy element farmingu na listę
     * @param fe element farmingu
     */
    public void add(FarmingElement fe){
        list.add(fe);
        it=list.iterator();
    }
    /**
     * Zwraca następny element farmingu
     * @return następny element do farmingu
     */
    public FarmingElement next(){
        //it=(it==null?list.iterator():it);
        if (!it.hasNext()){
            it=list.iterator();
        }
        //System.err.println(" per  "+it.hasNext());
        FarmingElement temp =it.next();
        //System.err.println(" next "+temp.toString());
        return temp;
    }
    /**
     * Zwraca listę farmingową jako tablicę kordynatów
     * @return tablica kordynatów
     */
    public Coords[] getCoordsArray(){
        Coords[] c = new Coords[list.size()];
        Iterator<FarmingElement> iter = list.iterator();
        int i=0;
        for (FarmingElement temp; iter.hasNext();){
            temp = iter.next();
            c[i]=temp.getDestination();
            i++;
        }
        return c;
    }    
    private Iterator<FarmingElement> it;
    private List<FarmingElement> list;
    
}
