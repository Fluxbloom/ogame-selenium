/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Coords;
import OgameElements.TimePeriod;
import OgameElementsUnchecked.Fleet;
import OgameElementsUnchecked.Mission;
import OgameElementsUnchecked.Resources;
import OgameElementsUnchecked.Ships;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class Scanning extends OgameTest{
    
    public Scanning() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
   
    @Test
    public void scan() throws OgameException, IOException {
        Coords[] nami = Coords.parseArray(new String[]{
        "2:46:4","2:46:5","2:46:6","2:46:8",
        "2:47:4","2:47:5","2:47:9","2:47:10",
        "2:48:4","2:48:6","2:48:10","2:48:12",
        "2:49:4",
        "2:52:8",
        "2:53:8",
        "2:54:4","2:54:6","2:54:7","2:54:8",
        "2:55:6","2:55:7","2:55:9",
        "2:56:10","2:56:11","2:56:12",
        "2:58:8","2:58:12",
        "2:59:6","2:59:11",
        "2:60:12",
        "2:62:4","2:62:10",
        "2:63:4",
        "2:64:6","2:64:7","2:64:12",
        "2:65:4",
        "2:66:6",
        "2:67:9",
        "2:69:6","2:69:10",
        "2:70:10"
        });
        Coords[] aisha = Coords.parseArray(new String[]{
        "2:93:8","2:93:12",
        "2:95:6","2:95:12",
        "2:97:4","2:97:9","2:97:10","2:97:12",
        "2:98:8",
        "2:99:10",
        "2:101:6","2:101:7",
        "2:102:5",
        "2:103:4",
        "2:105:7",
        "2:106:10",
        "2:107:6",
        "2:108:7",
        "2:109:4",
        "2:111:12",
        "2:112:8",
        "2:113:10","2:113:12",
        "2:114:4","2:114:8","2:114:9","2:114:10",
        "2:115:6","2:115:7","2:115:10",
        "2:116:6",
        "2:117:4",
        "2:118:10"
        });
        Coords[] videl = Coords.parseArray(new String[]{
            "2:145:4","2:145:12",
            "2:146:10",
            "2:148:10",
            "2:149:6",
            "2:150:10",
            "2:151:11",
            "2:152:4","2:152:6",
            "2:153:6","2:153:10",
            "2:154:4","2:154:8","2:154:10",
            "2:155:6",
            "2:156:6","2:156:10",
            "2:157:5","2:157:6","2:157:7","2:157:11",
            "2:158:5",
            "2:159:10",
            "2:160:10",
            "2:161:9","2:161:10","2:161:12",
            "2:162:4","2:162:6",
            "2:163:6",
            "2:164:4",
            "2:165:8",
            "2:167:10",
            "2:169:4","2:169:7","2:169:8",
            "2:170:7",
            "2:171:6","2:171:8","2:171:12"
        });
        Coords[] hinata = Coords.parseArray(new String[]{
        "2:187:4",
        "2:190:6",
        "2:191:10",
        "2:192:6",
        "2:193:4","2:193:6","2:193:8",
        "2:194:4","2:194:11",
        "2:195:4","2:195:5","2:195:7",
        "2:196:4","2:196:6","2:196:9",
        "2:198:12",
        "2:200:4",
        "2:202:4","2:202:7",
        "2:203:6","2:203:8",
        "2:206:7","2:206:10",
        "2:208:9",
        "2:209:8",
        "2:211:4"
        });
        Coords[] tatsuki = Coords.parseArray(new String[]{
        "2:232:6","2:232:11",
        "2:234:10",
        "2:236:4",
        "2:236:5","2:236:6","2:236:9","2:236:12",
        "2:237:10",
        "2:238:8","2:238:9",
        "2:239:9",
        "2:241:8", "2:241:10",
        "2:242:7","2:242:8",
        "2:245:6","2:245:8",
        "2:248:7","2:248:8","2:248:12",
        "2:251:4","2:251:5","2:251:6","2:251:7","2:251:8","2:251:10",
        "2:252:6",
        "2:256:12",
        "2:257:4","2:257:6"
        });
        
Coords[] coords = tatsuki;
        int slots=10;
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(4);
        Fleet spyFleet = new Fleet();
        spyFleet.add(Ships.SOND, 3);
        List<TimePeriod> returns =new ArrayList<TimePeriod>();
        TimePeriod longest;
        for (int i=0;i<coords.length;i++){
            returns.add(o.sendFleet(spyFleet, coords[i], Mission.SPY, Resources.NO_RESOURCES).getFlyingTime());
            if((i+1)%slots==0){
                longest = TimePeriod.max(returns);
                o.wait(longest);
                returns = new ArrayList<TimePeriod>();
            }
        }
        o.logout();
        o.stop();
    }
}
