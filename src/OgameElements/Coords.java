/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.Exceptions.OgameParsingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa odpowiada tworom kordynatów w grze. Łączy ona w sobie zarówno trójkę kordynatów co też 
 * cel lub bazę w postaci flagi Planeta, Księzyc czy Pole zniszczeń
 * @author Piotr Kowalski
 */
public class Coords implements Comparable{
    /**
     * Główny konstruktor obiektów kordynatów
     * @param uni numer uniwersum ( z zakresu 1-maks)
     * @param sys numer systemu (z zakresu 1-maks)
     * @param pos numer pozycji (z zakresu 1-maks)
     * @param dest Obiekt typu celu
     * @throws OgameFileNotFoundException brak pliku konfiguracji kordynatów
     * @throws OgameIOException brak możliwości odczytu pliku konfiguracji kordynatów
     */
    public Coords(int uni,int sys, int pos,Destination dest) throws OgameFileNotFoundException, OgameIOException{
        this.properties = new PropertiesCoords();
        this.universe=Math.max(1, Math.min(properties.getUniverses(), uni));
        this.system=Math.max(1, Math.min(properties.getSystems(), sys));
        this.position=Math.max(1, Math.min(properties.getPositions(), pos));
        this.dest=dest;
    }
    /**
     * Konstruktor z domyślną planetą pobierający ciągi znaków 
     * @param uni numer uniwersum ( z zakresu 1-maks)
     * @param sys numer systemu (z zakresu 1-maks)
     * @param pos numer pozycji (z zakresu 1-maks)
     * @throws NumberFormatException błąd parsowania
     * @throws OgameFileNotFoundException brak pliku konfiguracji kordynatów
     * @throws OgameIOException brak możliwości odczytu pliku konfiguracji kordynatów
     */
    public Coords(String uni,String sys, String pos) throws OgameFileNotFoundException, OgameIOException {
        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos),Coords.PLANET);
    }
    /**
     * 
     * @param uni numer uniwersum ( z zakresu 1-maks)
     * @param sys numer systemu (z zakresu 1-maks)
     * @param pos numer pozycji (z zakresu 1-maks)
     * @param dest Obiekt typu celu
     * @throws NumberFormatException błąd parsowania
     * @throws OgameFileNotFoundException brak pliku konfiguracji kordynatów
     * @throws OgameIOException brak możliwości odczytu pliku konfiguracji kordynatów
     */
    public Coords(String uni,String sys, String pos,Destination dest) throws NumberFormatException, OgameFileNotFoundException, OgameIOException {
        this(Integer.parseInt(uni),Integer.parseInt(sys),Integer.parseInt(pos),dest);
    }
    /**
     * Konstruktor z domyślną planetą
     * @param uni numer uniwersum ( z zakresu 1-maks)
     * @param sys numer systemu (z zakresu 1-maks)
     * @param pos numer pozycji (z zakresu 1-maks)
     * @throws OgameFileNotFoundException brak pliku konfiguracji kordynatów
     * @throws OgameIOException brak możliwości odczytu pliku konfiguracji kordynatów
     */
    public Coords(int uni,int sys, int pos) throws OgameFileNotFoundException, OgameIOException {
        this(uni,sys,pos,Coords.PLANET);
    }

    /**
     * Pobiera cel
     * @return cel
     */

    public Destination getDest() {
        return dest;
    }
    /**
     * Ustawia cel
     * @param dest cel 
     */
    public void setDest(Destination dest) {
        this.dest = dest;
    }
    /**
     * Pobiera pozycję
     * @return pozycja
     */
    public int getPosition() {
        return position;
    }
    /**
     * Pobiera pozycje i zwraca jako string
     * @return pozycja
     */
    public String getSPosition() {
        return Integer.toString(position);
    }
    /**
     * Parsuje stringa i ustawia jako pozycję (zakres 1 - maks)
     * @param position pozycja
     */
    public void setPosition(String position) {
        int i;
        i=Integer.parseInt(position);
        this.position = Math.max(1, Math.min(properties.getPositions(), i));     
    }
    /**
     * Ustawiania pozycję na daną (zakres 1 - maks)
     * @param position pozycja
     */
    public void setPosition(int position){
        this.position = Math.max(1, Math.min(properties.getPositions(), position));
    }
    /**
     * Pobiera liczbe dla systemu
     * @return system
     */
    public int getSystem() {
        return system;
    }
    /**
     * Pobiera liczbe dla systemu jako string
     * @return system
     */
    public String getSSystem() {
        return Integer.toString(system);
    }
    /**
     * Ustawia system na wartość
     * @param system string z numerem systemu
     */
    public void setSystem(String system) {
        int i;
        i=Integer.parseInt(system);
        this.position = Math.max(1, Math.min(properties.getSystems(), i));
    }
    /**
     * Ustawia system na liczbę
     * @param system liczba z numerem systemu
     */
    public void setSystem(int system) {
        this.position = Math.max(1, Math.min(properties.getSystems(), system));
    }
    /**
     * Pobiera numer galaktyki
     * @return galaktyka
     */
    public int getUniverse() {
        return universe;
    }
    /**
     * Pobiera numer galaktyki jako string
     * @return galaktyka
     */
    public String getSUniverse() {
        return Integer.toString(universe);
    }
    /**
     * Ustawia galaktykę na liczbę z Stringa
     * @param universe galaktyka
     */
    public void setUniverse(String universe) {
        int i;
        i=Integer.parseInt(universe);
        this.position =Math.max(1, Math.min(properties.getUniverses(), i));
    }
    /**
     * Ustawia galaktykę na liczbę 
     * @param universe galaktyka
     */
    public void setUniverse(int universe) {
        this.position =Math.max(1, Math.min(properties.getUniverses(), universe));
    }
    
    /**
     * Funkcja korzysta z zasobu pliku coords.properties zawierającego tablice pozycji, które można eksplorować
     * @return TRUE jesli pozycja eksplorowalna, FALSE w p.p.
     */
    public boolean isExploreable(){
        boolean result = false;
        for (int i=0; i<properties.getExplorePos().length;i++){
            if(this.position==properties.getExplorePos()[i]){
                result= true;
                break;
            }
        }
        return result;
    } 
    /**
     * Metoda porównuje czy dany kordynat oraz przesłany dotyczą tego samego układu planetarnego
     * Dopisane z uwagi na krótkie czasy lotów i specjalną obsługę takich lotów
     * @param c Kordynat porównywany
     * @return TRUE jeśli ten sam uklad, FALSE w p.p.
     */
    public boolean isSameSystem(Coords c){
        if (this.system==c.system && this.universe==c.universe)
            return true;
        else return false;
    }
    
    
    /**
     * Opisuje stan obiektu
     * @return stan obiektu
     */
    @Override
    public String toString() {
        return "Coords{" + "universe=" + universe + ", system=" + system + ", position=" + position + ", dest=" + dest + '}';
    }
    /**
     * Porównuje dwa obiekty
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coords other = (Coords) obj;
        if (this.universe != other.universe) {
            return false;
        }
        if (this.system != other.system) {
            return false;
        }
        if (this.position != other.position) {
            return false;
        }
        if (this.dest != other.dest && (this.dest == null || !this.dest.equals(other.dest))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object arg0) {
        Coords c = (Coords) arg0;
        if (this.universe < c.universe){
            return -1000;
        } else if (this.universe > c.universe){
            return 1000;
        } else if (this.system < c.system){
            return -100;
        } else if (this.system > c.system){
            return 100;
        } else if (this.position < c.position){
            return -10;
        } else if(this.position>c.position){
            return 10;
        } else {
            return this.dest.compareTo(c.dest);
        }
    }
    
    

    /**
     * Przedstawia kordynat w postaci stringa parsowalnego
     * @return 
     */
    
    public String shortPrint() throws OgameFileNotFoundException, OgameIOException{
        if (prop==null){
            prop = new PropertiesCoords();
        }
        if (this.dest == Coords.PLANET){
            return "["+this.universe+":"+this.system+":"+this.position+"]";
        }
        else if (this.dest == Coords.MOON){
            return "["+this.universe+":"+this.system+":"+this.position+":"+prop.getMoon_markup()+"]";
        } else
            return "["+this.universe+":"+this.system+":"+this.position+":"+prop.getDebris_markup()+"]";
    }
    
    /**
     * Metoda zwracająca prosty string kordynatów pomijając dokładny cel i zapisujac w postaci [1:1:1]
     */
    public String simpleString() {
        return "["+this.universe+":"+this.system+":"+this.position+"]";
    }
    /**
     * Metoda statyczna parsowania ciagu znaków do kordynatów
     * Wspierane kordynaty "[1:1:1]", "1:1:1", "1:1:1:m" - księżyc, "1:1:1:pz" - pz
     * [1:1:1:m] - księżyc , [1:1:1:pz] - pole zniszczeń
     * @param s Sformatowany String
     * @return nowy obiekt kordynatów
     * @throws OgameException Błąd parsowania kordynatów
     */
    private static PropertiesCoords prop = null;
    public static Coords parse(String s) throws OgameFileNotFoundException, OgameIOException, OgameParsingException {
        if (prop == null) {
            prop = new PropertiesCoords();
        }
                String[] str =s.replace("[", "").replace("]", "").split(":");
        try {
            if (str.length ==3)
                return new Coords(str[0],str[1],str[2]);
            else if (str.length == 4){
                if (str[3].compareTo(prop.getDebris_markup())==0){
                    return new Coords(str[0],str[1],str[2],Coords.PZ);
                } else if (str[3].compareTo(prop.getMoon_markup())==0){
                    return new Coords(str[0],str[1],str[2],Coords.MOON);
                } else {
                    throw new OgameParsingException(s);
                }
            }else {
                    throw new OgameParsingException(s);
                }
        }catch(NumberFormatException ex){
            throw new OgameParsingException(s +" "+ex.getMessage());
        }
    }
    /**
     * Metoda parsuje tablice stringów na tablice kordynatów. 
     * Błędnie sparsowane stringi są odrzucane, dlatego należy zewnętrznie kontrolować rozmiar tablicy
     * @param s tablica stringów 
     * @return tablica kordynatów 
     */
    public static Coords[] parseArray(String[] s){
    List<Coords> list = new ArrayList<Coords>();
    Coords temp;
    Exception e=null;;
    for (int i=0; i< s.length; i++){
            try {
                temp = Coords.parse(s[i]);
                list.add(temp);
            } catch (OgameException ex) {
                logger.log(Level.WARNING, "Couldnt parse {0}", ex.getMessage() );
                if (ex == OgameException.COORDS_PARSING_ERROR){
                    logger.log(Level.WARNING, "Coord Parsing error {0}", ex.getMessage() );
                }
            } 
    }
    
    Coords[] coords = new Coords[list.size()];
    for (int i=0; i< coords.length; i++){
        coords[i]= list.get(i);
    }
    return coords;
}
     /**
     * Metoda łączycy kilka tablic kordynatów w jedną 
     * @param c tablica tablic kordynatów
     * @return tablica łączna
     */
    public static Coords[] mergeList(Coords[][] c){
        int totalsize = 0;
        for (int i=0; i<c.length;i++){
            totalsize += c[i].length;
        }
        Coords[] result = new Coords[totalsize];
        int k=0;
        for (int i=0;i<c.length;i++){
            for (int j=0;j<c[i].length;j++){
                result[k++]=c[i][j];
            }
        }
        return result;
    }
    /**
     * Tworzy liste kolejnych systemów pomiędzy kordem lewym a kordem prawym
     * @param left kord lewy
     * @param right kord prawy
     * @return lista układów pomiędzy
     */
    public static List<Coords> coordsSystemRange(Coords left, Coords right) throws OgameFileNotFoundException, OgameIOException{
        List<Coords> list = new ArrayList<Coords>();
        if (left.universe!=right.universe) { 
            list.add(left);
            list.add(right);
        } else {
            Coords l,r;
            l = left.compareTo(right)<0?left:right;
            r = left.compareTo(right)<0?right:left;
            list.add(l);
            int system = l.system;
            while (system<r.system){
                system++;
                list.add(new Coords(l.universe,system,l.position));   
            }
        }
        return list;
    }
    
     /**
     * Tworzy liste kolejnych systemów wokół danego kordynatów odległych ilość systemów
     * @param system kordynat centralny
     * @param systems maksymalna odległość pomiędzy kordami
     * @return lista układów pomiędzy
     */
    public static List<Coords> coordsAroundSystem(Coords system,int systems) throws OgameFileNotFoundException, OgameIOException {
        systems = systems>=0?systems:0;
        Coords left = new Coords(system.universe,system.system > systems?system.system-systems:1,system.position);
        Coords right  = new Coords(system.universe,system.system < prop.getSystems()-systems?system.system+systems:prop.getSystems(),system.position); 
        return Coords.coordsSystemRange(left, right);
    }
    /**
     * Stała odpowiadająca celowi planecie
     */
    static final public Destination PLANET = Destination.PLANET;
    /**
     * Stała odpowiadająca celowi księzycowi
     */
    static final public Destination MOON = Destination.MOON;
    /**
     * Stała odpowiadająca celowi polu zniszczeń
     */
    static final public Destination PZ = Destination.DEBRIS;
    
    private int universe;
    private int system;
    private int position;
    private Destination dest;
    private PropertiesCoords properties;
    private static final Logger logger = Logger.getLogger(Coords.class.getName());
}
