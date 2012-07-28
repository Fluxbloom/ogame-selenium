/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

/**
 *
 * @author dyschemist
 */
public class Planet {
    
    private int uni;
    private int sys;
    private int pos;

    public Planet(int uni, int sys, int pos) {
        this.uni = uni;
        this.sys = sys;
        this.pos = pos;
    }
    public Planet(String uni, String sys, String pos) {
        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos));
    }

    @Override
    public String toString() {
        return "Planet{" + "uni=" + uni + ", sys=" + sys + ", pos=" + pos + '}';
    }
    
    
    
    
}
