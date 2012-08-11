/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Jest to klasa której obiekty odpowiadają kordynatom planet, pól zniszczeń oraz księżyców.</b>
 * Przy czym nie muszą wcale istnieć.
 * @author michald
 */
public class Coords {
    /**
     * Pole odpowiada numerowi galaktyki.
     */
    private String universe;
    /**
     * Pole odpowiada numerowi systemu.
     */
    private String system;
    /**
     * Pole odpowiada numerowo pozycji w systemie.
     */
    private String position;
    /**
     * Właściwości, które określają jakie kordynaty są dopuszczalne.
     */
    private CoordsProperties properties;
    /**
     * Odpowiada czy na danych kordynatach interesuje nas planeta, księżyc czy pole zniszczeń.
     */
    private Destination dest;
    /**
     * Udostępnia obiekt Destination
     * @return Zwraca czy celem jest planeta, księżyc czy pole zniszczeń.
     */
    public Destination getDest() {
        return dest;
    }
    /**
     * Ustawia obiekt Destination, na planete, księżyc lub pole zniszczeń.
     * @param dest Obiekt typu Destination, czyli określa planete, księżyc lub pole zniszczeń.
     */
    public void setDest(Destination dest) {
        this.dest = dest;
    }
    /**
     * Udostępnia String z numerem pozycji w układzie dla danego kordynatu.
     * @return Zwraca numer systemu pozycji kordynatu.
     */
    public String getPosition() {
        return position;
    }
    /**
     * Ustawia wartość pozycji w układzie planetarnym na podaną w parametrze.
     * Dodatkowo przeprowadza weryfikację poprawności ustawiając 1 dla wartości zbyt małych oraz 
     * maksymalną dla zbyt dużych.
     * @param position Obiekt typu String z numerem pozycji w układzie dla danego kordynatu.
     */
    public final void setPosition(String position) {
        int i;
        i=Integer.parseInt(position);
        this.position = Integer.toString(Math.max(1, Math.min(properties.getPositions(), i)));     
    }
    /**
     * Pobiera wartość systemu planetarnego dla danego kordynatu
     * @return String reprezentujący numer systemu planetarnego
     */
    public String getSystem() {
        return system;
    }
    /**
     * Ustawia wartość systemu planetarnego na podaną w parametrze.
     * Dodatkowo przeprowadza weryfikację poprawności ustawiając 1 dla wartości zbyt małych oraz 
     * maksymalną dla zbyt dużych.
     * @param system Obiekt typu String z numerem systemu planetarnego dla danego kordynatu.
     */
    public final void setSystem(String system) {
        int i;
        i=Integer.parseInt(system);
        this.position = Integer.toString(Math.max(1, Math.min(properties.getSystems(), i)));
    }
     /**
     * Pobiera wartość układu słonecznego dla danego kordynatu
     * @return String reprezentujący numer układu słonecznego.
     */
    public String getUniverse() {
        return universe;
    }
    /**
     * Ustawia wartość układu słonecznego na podaną w parametrze.
     * Dodatkowo przeprowadza weryfikację poprawności ustawiając 1 dla wartości zbyt małych oraz 
     * maksymalną dla zbyt dużych. 
     * @param universe Obiekt typu string z numerem układu słonecznego dla danego kordynatu.
     */
    public void setUniverse(String universe) {
        int i;
        i=Integer.parseInt(universe);
        this.position = Integer.toString(Math.max(1, Math.min(properties.getUniverses(), i)));
    }
    /**
     * Konstrukor tworzący kordynaty na planety.
     * @param uni String zawierający numer uniwersum.
     * @param sys String zawierający numer systemu.
     * @param pos String zawierający numer pozycji w systemie.
     */
    public Coords(String uni,String sys, String pos){
        this(uni,sys,pos,Coords.PLANET); // wywolanie innego konstruktora
    }
    /**
     * To jest domyślny konstruktor dla kordynatów.
     * @param uni String zawierający numer uniwersum.
     * @param sys String zawierający numer systemu.
     * @param pos String zawierający numer pozycji w systemie.
     * @param dest Obiekt planety, księżyca lub pól zniszczeń.
     */
    public Coords(String uni,String sys, String pos,Destination dest){
                try {
            this.properties=new CoordsProperties();
        } catch (IOException ex) {
            Logger.getLogger(Coords.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setUniverse(universe);
        this.setSystem(system);
        this.setPosition(position);
        this.dest=dest;
    }
    /**
     * Konstrukor tworzący kordynaty na planety.
     * Przyjmuje Intigery jako parametry.
     * @param uni Intiger zawierający numer uniwersum.
     * @param sys Intiger zawierający numer systemu.
     * @param pos Intiger zawierający numer pozycji w systemie.
     */
    public Coords(int uni,int sys, int pos){
        this(Integer.toString(uni),Integer.toString(sys),Integer.toString(pos),Coords.PLANET);        
        
    }
    /**
     * Konstruktor tworzący kordynaty na planetę, księżyc lub pole zniszczeń.
     * Przyjmuje Intigery jako parametry.
     * @param uni Intiger zawierający numer uniwersum.
     * @param sys Intiger zawierający numer systemu.
     * @param pos Intiger zawierający numer pozycji w systemie.
     * @param dest Obiekt planety, księżyca lub pól zniszczeń.
     */
    public Coords(int uni,int sys, int pos,Destination dest){
        this(Integer.toString(uni),Integer.toString(sys),Integer.toString(pos),dest);
    }

    @Override
    public boolean equals(Object obj) {
        Coords against = (Coords) obj;
        return this.universe.equals(against.universe)&this.system.equals(against.system)&
                this.position.equals(against.position)&this.dest==against.dest;
    }
    /**
     * 
     * @param s
     * @return 
     */
    public static Coords parse(String s){
                String[] str =s.replace("[", "").replace("]", "").split(":");
        return new Coords(str[0],str[1],str[2]);
    }


    /**
     * Odpowiada planecie w kordynacie.
     */
    static final public StartDestination PLANET = new StartDestination("PLANET");
    /**
     * Odpowiada księżycowi w kordynacie.
     */
    static final public StartDestination MOON = new StartDestination("MOON");
    /**
     * Odpowiada polu zniszczeń w kordynacie.
     */
    static final public Destination PZ =  new Destination("DEBRIS");

    @Override
    public String toString() {
        return "Coords{" + "universe=" + universe + ", system=" + system + ", position=" + position + ", dest=" + dest + '}';
    }

    public static class Destination {
        private String name;
    protected Destination(String name){this.name=name;}
        

        @Override
        public String toString() {
            return "Destination{" + "name=" + name + '}';
        }
    
    
}
    
    public static class StartDestination extends Destination {
    private StartDestination(String name){super(name);}
    
}
    public static class Planet {
    
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
    
 static class CoordsProperties {
    
    protected String path;
    protected Properties properties;
    
    private int universes;
    private int systems;
    private int positions;

    public int getPositions() {
        return positions;
    }

    public int getSystems() {
        return systems;
    }

    public int getUniverses() {
        return universes;
    }
    
    public CoordsProperties() throws IOException {
                Properties defaultPath = new Properties();
        defaultPath.load(new FileInputStream(
                System.getProperty("user.dir") + "/conf/defaultConfFile.properties")
                );
        this.path = System.getProperty("user.dir") + "/conf/"+defaultPath.getProperty("folder") +"/cords.properties";
        properties = new Properties();
        properties.load(new FileInputStream(path));
        universes=Integer.parseInt(properties.getProperty("universes"));
        systems=Integer.parseInt(properties.getProperty("systems"));
        positions=Integer.parseInt(properties.getProperty("positions"));
    }
}  
    
}
