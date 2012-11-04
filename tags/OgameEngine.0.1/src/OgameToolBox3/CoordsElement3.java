/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameToolBox3;

import OgameElements.Coords;
import OgameElements.Report;
import OgameEngine.Exceptions.OgameCannotSaveReportException;

/**
 * Opakowanie kordynatów
 * @author Piotr Kowalski
 */
public class CoordsElement3 {

    public CoordsElement3(String saveDir, Coords coords) {
        this.saveDir = saveDir;
        this.coords = coords;
        this.report = null;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
       
    public boolean loadReport(){
        
        return false;
    }
    
    public void saveReport() throws OgameCannotSaveReportException{
      String path = System.getProperty("user.dir")+"/saves/farmer/reports/";
      this.report.save(path);
    }
    
    public boolean hasReport(){
        return this.report==null?false:true;
    }

    public Coords getCoords() {
        return coords;
    }
    
            
    private String saveDir;        
    private Coords coords;
    private Report report;
    
}
