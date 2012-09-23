/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

/**
 * Klasa dostarcza obiekty do kordynatów, które mogą posłużyć za punkt startu: 
 * czyli planetę oraz księżyc
 * @author Piotr Kowalski
 */
public final class StartDestination extends Destination {
    /**
     * Domyślny konstruktor, który nadaje nazwę obiektom. Nazwa potrzebna jedynie do celów debugowania
     * @param name Nazwa celu;
     */
    private StartDestination(String name){super(name);}
    
    /**
     * Stała odpowiada miejscu startowemu - planecie
     */
    static final public StartDestination PLANET = new StartDestination("PLANET");
    /**
     * Stałą odpowiada miejscu startewemu - księzycowi
     */
    static final public StartDestination MOON = new StartDestination("MOON");
}
