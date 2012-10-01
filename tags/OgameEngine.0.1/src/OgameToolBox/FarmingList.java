/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox;

import OgameElements.Coords;
import OgameElements.Fleet;
import OgameElements.Planet;
import OgameElements.Speed;
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
        list = new ArrayList<FleetElement>();
        it = list.iterator();
    }
    /**
     * Konstruktor listy farmingowej z tablicy kordynatów
     * @param c tablica kordynatów
     */
    public FarmingList(Coords[] c){
        list = new ArrayList<FleetElement>();
        for (int i=0; i< c.length; i++){
            list.add(new FleetElement(c[i]));
        }
        it =list.iterator();
    }
    /**
     * Konstruktor listy farmingowej z tablicy kordynatów z uwzględnieniem ataków w jednym układzie
     * @param c tablica kordynatów
     * @param p planeta nadanie - celem uniknięcia za krótkich ataków w jednym układzie. Ataki te są wysyłane na 60%
     */
    public FarmingList(Coords[] c,Planet p){
        list = new ArrayList<FleetElement>();
        for (int i=0; i< c.length; i++){
            if (p.getCoords().isSameSystem(c[i])){
                list.add(new FleetElement(c[i],Speed.S60));
            } else {
            list.add(new FleetElement(c[i]));
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
        list = new ArrayList<FleetElement>();
        for (int i=0; i< c.length; i++){
            if (p.getCoords().isSameSystem(c[i])){
                list.add(new FleetElement(c[i],Speed.S60,farming));
            } else {
            list.add(new FleetElement(c[i]));
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
                list.add(new FleetElement(temp,Speed.S60));
            } else {
            list.add(new FleetElement(temp));
            }
        }
        it =list.iterator();
    }
    /**
     * Przekazuje listę planet do farmienia
     * @return 
     */
    List<FleetElement> getList() {
        return list;
    }
    /**
     * Resetuje flagę nadania floty
     */
    public void resetIsSend(){
        Iterator<FleetElement> iter = this.list.iterator();
        while(iter.hasNext()){
            iter.next().setLastSend(false);
        }
    }
    
    /**
     * Dodaje kordynatat na listę
     * @param c kordynat
     */
    public void add(Coords c){
        list.add(new FleetElement(c));
    }
    /**
     * Dodaje kordynatat na listę
     * @param c kordynat
     * @param p planeta do porównania w układzie
     */
    public void add(Coords c,Planet p){
        if (!p.getCoords().isSameSystem(c)){
            list.add(new FleetElement(c));
        } else {
            list.add(new FleetElement(c,Speed.S60));
        }
    }

    /**
     * Dodaje nowy element farmingu na listę
     * @param fe element farmingu
     */
    public void add(FleetElement fe){
        list.add(fe);
        it=list.iterator();
    }
    /**
     * Zwraca następny element farmingu
     * @return następny element do farmingu
     */
    public FleetElement next(){
        //it=(it==null?list.iterator():it);
        if (!it.hasNext()){
            it=list.iterator();
        }
        //System.err.println(" per  "+it.hasNext());
        FleetElement temp =it.next();
        //System.err.println(" next "+temp.toString());
        return temp;
    }
    /**
     * Zwraca listę farmingową jako tablicę kordynatów
     * @return tablica kordynatów
     */
    public Coords[] getCoordsArray(){
        Coords[] c = new Coords[list.size()];
        Iterator<FleetElement> iter = list.iterator();
        int i=0;
        for (FleetElement temp; iter.hasNext();){
            temp = iter.next();
            c[i]=temp.getDestination();
            i++;
        }
        return c;
    }    
    private Iterator<FleetElement> it;
    private List<FleetElement> list;
    
}
