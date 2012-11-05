/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameCannotLoadReportException;
import OgameEngine.Exceptions.OgameCannotSaveReportException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.Exceptions.OgameResourceParsingException;
import OgameEngine.Exceptions.OgameTimeParseException;
import OgameToolBox.FleetElement;
import OgameToolBox.FarmingList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Klasa odpowiada raportowi w Ogame i zawiera wszystkie jego wewnętrzne operacje
 * @author Piotr Kowalski
 */
public class Report extends Message implements Comparable{
    
    static private final List<PlayerActivityStatuses> normal = new ArrayList<PlayerActivityStatuses>();
    static {
        normal.add(PlayerActivityStatuses.NORMAL);
    }
    /**
     * Konstruktor podstawowego raportu
     * @param cords kordynaty
     * @param resources zasoby na planecie
     */
    public Report(Coords cords, PlanetResources resources) {
        this(cords,normal,null,resources,null,null,null,null,null);
    }

    public Report(Coords cords, Time time, PlanetResources resources, GalaxyStatus status, 
            PlanetFleet fleet, PlanetDefence defence, PlanetBuildings buildings, 
            PlayerTechnologies techs) {
        this(cords,normal,time,resources,status,fleet,defence,buildings,techs);
    }

    public Report(Coords cords,List<PlayerActivityStatuses> playerStatus, Time time, PlanetResources resources, GalaxyStatus status, PlanetFleet fleet, PlanetDefence defence, PlanetBuildings buildings, PlayerTechnologies techs) {
        this.cords = cords;
        this.playerStatus = playerStatus;
        this.time = time;
        this.resources = resources;
        this.status = status;
        this.fleet = fleet;
        this.defence = defence;
        this.buildings = buildings;
        this.techs = techs;
    }

    
    /**
     * Zwraca koordynaty z raportu
     * @return koordynaty z raportu
     */
    public Coords getCords() {
        return cords;
    }
    /**
     * Zwraca zapasy z planety
     * @return zapasy z planety
     */
    public PlanetResources getResources() {
        return resources;
    }
    
    /**
     * Zwraca stan obiektu
     * @return stan obiektu
     */
    
    @Override
    public String toString() {
        return "Report{" + "cords=" + cords + ", resources=" + resources + '}';
    }
    /**
     * Porównuje dwa raporty porządkując je względem sumy surowców
     * @param arg0 porównywany obiekt
     * @return różnica w ilości surowców na planetach
     */
    public String print() throws OgameFileNotFoundException, OgameIOException{
        return this.cords.shortPrint() + resources.toString();
    }
    
    public String reportPrint(){
        String report = "Report from "+this.cords.toReportString() + " at "+this.time.getFormattedTimeString()+"\n";
        report+=this.resources.toString()+"\n";
        report+="Activity ? "+this.status.reportPrint()+" "+
                PlayerActivityStatuses.statusesList(this.playerStatus)+"\n";
        report+=this.fleet!=null?this.fleet.toReportString():"";
        report+=this.defence!=null?this.defence.toReportString():"";
        report+=this.buildings!=null?this.buildings.toReportString():"";
        report+=this.techs!=null?this.techs.toReportString():"";
        return report;
    }
    
    @Override
    public int compareTo(Object arg0) {
        double sum = this.resources.getMetal()*Report.metal_price+
                this.resources.getCrystal()*Report.crystal_price+
                this.resources.getDeuterium()*Report.deuterium_price;
        Report arg = (Report) arg0;
        double other = arg.resources.getMetal()*Report.metal_price+
                arg.resources.getCrystal()*Report.crystal_price+
                arg.resources.getDeuterium()*Report.deuterium_price;
        return sum-other>0?1:sum-other<0?-1:0;
    }
    /**
     * Zwraca sumę surowców na planecie
     * @return suma surowców na planecie
     */
    public int sum(){
        return this.resources.getMetal()+this.resources.getCrystal()+this.resources.getDeuterium();
    }
   
    static public Report load(String file) throws OgameCannotLoadReportException {
        Report report=null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(file);
            Element root = dom.getDocumentElement();
            // wczytujemy kordynat
            Coords coords = Coords.parserXML(root);
            // wczytujemy status gracza
            List<PlayerActivityStatuses> playerStatuses = PlayerActivityStatuses.parseXML(root); 
            // wczytujemy czas raportu
            Time time = Time.parseXML(root); 
            // wczytujemy zasoby
            PlanetResources resources = PlanetResources.parseXML(root);
            // wczytujemy aktywnosc
            GalaxyStatus status = GalaxyStatus.parseXML(root);
            // wczytujemy floty
            PlanetFleet fleet = PlanetFleet.parseXML(root);
            // wczytujemy obronę
            PlanetDefence defence = PlanetDefence.parseXML(root);
            // wczytujemy budynki
            PlanetBuildings buildings = PlanetBuildings.parseXML(root);
            // wczytujemy techy
            PlayerTechnologies techs = PlayerTechnologies.parseXML(root);
            // tworzymy obiekt
            report = new Report(coords,playerStatuses,time,resources,status,fleet,defence,buildings,techs);
        } catch (ParserConfigurationException ex) {
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch (SAXException ex ){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch (IOException ex){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch ( NumberFormatException ex){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch (OgameFileNotFoundException ex){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch (OgameIOException ex){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch( OgameResourceParsingException ex){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        } catch(  OgameTimeParseException ex){
            throw new OgameCannotLoadReportException("Report in "+file+" original exception"+ex.getMessage());
        }
        return report;
    }
      
    static FileWriter fostream;
    static FileInputStream fistream;
    static BufferedWriter out;
    static BufferedReader in;
    
    public void save(String file) throws OgameCannotSaveReportException{
        try {
        fostream = new FileWriter(file+"Report-"+this.cords.toReportString()+".xml");
        out = new BufferedWriter(fostream);
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        out.write("<report>\n");
        out.write(this.cords.toXML());
        out.write(PlayerActivityStatuses.toXML(this.playerStatus));
        out.write(this.time.toXML());
        out.write(this.resources.toXML());
        out.write(this.status.toXML());
        out.write(this.fleet==null?PlanetFleet.toXMLNotVisible():this.fleet.toXML());
        out.write(this.defence==null?PlanetDefence.toXMLNotVisible():this.defence.toXML());
        out.write(this.buildings==null?PlanetBuildings.toXMLNotVisible():this.buildings.toXML());
        out.write(this.techs==null?PlayerTechnologies.toXMLNotVisible():this.techs.toXML());
        out.write("</report>");
        out.close();
        } catch (IOException ex){
            throw new OgameCannotSaveReportException("Report to "+file+" ex="+ex.getMessage());
        }
    }

    
    /**
     * Wyprowadza listę kordynatów z listy raportów
     * @param lr lista raportów
     * @return lista kordynatów
     */
    public static List<Coords> getCoordsArray(List<Report> lr){
        List<Coords> array = new ArrayList<Coords>();
        Iterator<Report> it = lr.iterator();
        while(it.hasNext()){
            array.add(it.next().getCords());
        }
        return array;
    }
    /**
     * Wyprowadza farming liste z listy raportów
     * @param lr lista raportów
     * @return farming lista
     */
    public static FarmingList getFarmingList(List<Report> lr,Planet p){
        FarmingList fl = new FarmingList();
        Iterator<Report> it = lr.iterator();
        Report temp;
        Fleet f;
        while(it.hasNext()){
            temp = it.next();
            f = new Fleet();
            double ships = ( (double) temp.sum()) / 10000.0;
            f.add(Ships.MT, (int) (ships+1));
            fl.add(new FleetElement(temp.getCords(),p.getCoords().isSameSystem(temp.getCords())?Speed.S60:Speed.S100,f));
        }
        return fl;
    }
    /**
     * Sortuje listę raportów w porządku malejącycm
     * @param lista do posortowania w miejscu
     */
    public static void sortDESC(List<Report> lr){
        Collections.sort(lr);
        Collections.reverse(lr);
    }
    /**
     * Metoda dołacza elementy drugiej listy do pierwszej
     * @param joined lista łącząca 
     * @param joining lista dołączana
     */
    public static void joinLists(List<Report> joined, List<Report> joining){
        Iterator<Report> it = joining.iterator();
        while(it.hasNext()){
            joined.add(it.next());
        }
    }
    /**
     * Metoda wypisuje listę raportów do obiektu String
     * @param reports Lista raportów
     * @return String z wynikiem raportów
     * @throws OgameFileNotFoundException Błąd braku pliku z konfiguracją
     * @throws OgameIOException Błąd dostępu do pliku z konfiguracją
     */
    public static String printList(List<Report> reports) throws OgameFileNotFoundException, OgameIOException{
        String s ="";
        Iterator<Report> iter = reports.iterator();
        while(iter.hasNext()){
            s+=iter.next().print()+"\n";
        }
        return s;
    }
    
    private Coords cords;
    private List<PlayerActivityStatuses> playerStatus;
    private Time time;
    private PlanetResources resources;
    private GalaxyStatus status;
    private PlanetFleet fleet;
    private PlanetDefence defence;
    private PlanetBuildings buildings;
    private PlayerTechnologies techs;

    public static double metal_price=1.0;
    public static double crystal_price=3.0;
    public static double deuterium_price=1.0;

}
