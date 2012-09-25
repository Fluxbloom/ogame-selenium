/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameElements.Coords;

/**
 *
 * @author dyschemist
 */
    public class Planet {
        private Coords coords;
        private String name;

        public Planet(Coords coords, String name) {
            this.coords = coords;
            this.name = name;
        }

        public Coords getCoords() {
            return coords;
        }

        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return "Planet{" + "coords=" + coords + ", name=" + name + '}';
        }
        
        
        
//    private int uni;
//    private int sys;
//    private int pos;
//
//    public Planet(int uni, int sys, int pos) {
//        this.uni = uni;
//        this.sys = sys;
//        this.pos = pos;
//    }
//    public Planet(String uni, String sys, String pos) {
//        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos));
//    }
//    public static Planet parse(String s){
//                String[] str =s.replace("[", "").replace("]", "").split(":");
//        return new Planet(str[0],str[1],str[2]);
//    }
//
//    @Override
//    public String toString() {
//        return "Planet{" + "uni=" + uni + ", sys=" + sys + ", pos=" + pos + '}';
//    }
//    public String shortPrint(){
//        return "["+this.uni+":"+this.sys+":"+this.pos+"]";
//    }
//        public int getPos() {
//            return pos;
//        }
//
//        public int getSys() {
//            return sys;
//        }
//
//        public int getUni() {
//            return uni;
//        }

    @Override
    public boolean equals(Object obj) {
         if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planet p = (Planet) obj;
        return this.coords.equals(p.coords);
    }
    
}
