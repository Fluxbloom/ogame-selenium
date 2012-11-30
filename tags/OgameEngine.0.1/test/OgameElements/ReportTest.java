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
import java.util.ArrayList;
import java.util.List;
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
        PlanetFleet f = new PlanetFleet();
        f.add(Ships.LM, 2);
        f.add(Ships.MT, 5);
        f.add(ShipyardShips.SAT, 20);
        PlanetDefence def = new PlanetDefence();
        def.add(Defence.MALY_LASER, 5);
        def.add(Defence.DZIALO_GAUSSA, 4);
        PlanetBuildings buildings = new PlanetBuildings();
        buildings.add(Buildings.SHIPYARD, 6);
        buildings.add(Buildings.METAL_MINE, 4);
        PlayerTechnologies techs = new PlayerTechnologies();
        techs.add(Technology.TECHNOLOGIA_ENERGETYCZNA, 2);
        List<PlayerActivityStatuses> playerStatuses = new ArrayList<PlayerActivityStatuses>();
        playerStatuses.add(PlayerActivityStatuses.INACTIVE);
        playerStatuses.add(PlayerActivityStatuses.BANDIT);
    Report r = new Report(new Coords(2,195,6,Destination.MOON), playerStatuses,
            new Time(2012,5,11,6,7,13),new PlanetResources(300,200,100,50),
            new GalaxyStatusMinutes(17),
            f,def,buildings,techs);
    String path = System.getProperty("user.dir")+"/saves/farmer/test/";
    r.save(path);
    }
    
    @Test
    public void loadTest() throws OgameCannotLoadReportException, OgameFileNotFoundException, OgameIOException {
    String path = System.getProperty("user.dir")+"/saves/farmer/test/Report-2_195_6_M.xml";
    Report r  = Report.load(path);
    System.out.println(r.reportPrint());
    }
}
