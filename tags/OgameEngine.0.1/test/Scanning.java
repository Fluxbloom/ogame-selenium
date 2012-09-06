/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElementsUnchecked.Coords;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Resources;
import OgameElementsUnchecked.Ships;
import OgameEngineUnchecked.Ogame;
import OgameEngineUnchecked.OgameException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class Scanning {
    
    public Scanning() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    Ogame o = Ogame.ogameFabric("116", "pl");
    String uni = "Pegasus";
    String user = "Mystic";
    String pass = "SuperUltraSsjGoku2";
    
    
    
    @Test
    public void scan() throws OgameException {
Coords[] coords = Coords.parseArray(new String[]{
//        "2:97:4","2:97:9","2:97:10",
//        "2:98:8","2:101:7","2:102:5","2:105:7","2:108:4","2:108,7","2:109:9",
//        "2:114:8","2:114:9","2:114:10",
//        "2:115:6","2:115:7", "2:117:4",
//        "2:152:4","2:152:6",
//        "2:153:10","2:154:4","2:154:10","2:155:6","2:156:6",
//        "2:157:5","2:157:6","2:157:7","2:157:11",
        "2:158:5","2:161:9","2:161:10","2:161:12",
        "2:162:4","2:162:6","2:163:6","2:165:8",
        "2:191:10","2:193:8","2:194:11",
        "2:195:4","2:195:5","2:195:6","2:195:9",
        "2:196:4","2:196:6","2:196:9","2:202:7",
        "2:236:4","2:236:5","2:236:6","2:236:9",
        "2:237:4","2:237:10",
        "2:238:5","2:238:8","2:238:9",
        "2:241:8","2:241:10",
        "2:242:7","2:242:8","2:243:12",
        "2:245:8","2:248:7","2:248:8","2:248:11",
        "2:55:6","2:55:7","2:55:9",
        "2:56:7","2:56:8","2:56:10","2:56:11","2:56:12",
        "2:59:11","2:63:4"});
        int slots=8;
        o.start();
        o.login(uni, user, pass);
        Fleet spyFleet = new Fleet();
        spyFleet.add(Ships.SOND, 3);
        for (int i=0;i<coords.length-1;i++){
            o.sendFleet(spyFleet, coords[i], Mission.SPY, Resources.NO_RESOURCES);
            if((i+1)%slots==0){
                o.wait(5, 0);
            }
        }
        o.logout();
        o.stop();
    }
}
