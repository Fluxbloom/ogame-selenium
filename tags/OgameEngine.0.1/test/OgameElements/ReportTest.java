/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameCannotLoadReportException;
import OgameEngine.Exceptions.OgameCannotSaveReportException;
import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngine.OgameTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class ReportTest extends OgameTest{
    
    public ReportTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Test
    public void saveTest() throws  OgameCannotSaveReportException, OgameFileNotFoundException, OgameIOException {
    Report r = new Report(new Coords(2,195,6,Destination.MOON),new Time(2012,5,11,6,7,13),new PlanetResources(300,200,100,50),
            new GalaxyStatusMinutes(17),
            null,null,null,null);
    String path = System.getProperty("user.dir")+"/saves/farmer/test/";
    r.save(path);
    }
    
    @Test
    public void loadTest() throws OgameCannotLoadReportException, OgameFileNotFoundException, OgameIOException {
    String path = System.getProperty("user.dir")+"/saves/farmer/test/Report-2:195:6(M).xml";
    Report r  = Report.load(path);
    System.out.println(r.reportPrint());
    }
}
