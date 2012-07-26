/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class StartDestination extends Destination {
    private StartDestination(){super();}
    static final public StartDestination PLANET = new StartDestination();
    static final public StartDestination MOON = new StartDestination();
}
