/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa odpowiada za dostarczenie obiektów, które pozwalają odróżniać księżyce, 
 * pola zniszczeń i planety w kordynatach planet
 * @author Piotr Kowalski
 */
public class Destination {

    /**
     * Domyślny konstruktor zapisujący nazwę danego obiektu. 
     * Konstruktor jest niedostępny zewnętrzenie, a wszystkie jego niezbędne obiekty są 
     * udostępnione przez stałe PLANET,MOON oraz DEBRIS
     * @param name Nazwa danego celu w kordynacie
     */
    
    protected Destination(String name) {
        this.name = name;
    }   
    /**
     * wypisywanie debugujące
     * @return stan obiektu
     */
    @Override
    public String toString() {
        return "Destination{" + "name=" + name + '}';
    }
    
    /**
     * Stałą odpowiadajaca planecie
     */
    static final public StartDestination PLANET = StartDestination.PLANET;
    /**
     * Stała odpowiadająca księzycowi
     */
    static final public StartDestination MOON = StartDestination.MOON;
    /**
     * Stała odpowiadająca polu zniszczeń
     */
    static final public Destination DEBRIS = new Destination("DEBRIS");
    
    /**
     * Pole odpowiada za nazwe i służy jedynie dla celów debugowania.
     */
    private String name;
}
