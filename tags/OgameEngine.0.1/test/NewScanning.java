/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import OgameElements.Coords;
import OgameElements.Report;
import OgameEngine.Exceptions.OgameElementNotFoundException;
import OgameEngine.Exceptions.OgameException;
import OgameEngine.OgameTest;
import OgameToolBox.ScanList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class NewScanning extends OgameTest {

    public NewScanning() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void scan() throws OgameException {
        //scanNami();
        //scanAisha();
        //scanVidel();
        scanHinata();
        scanTatsuki();
    }

    private void scanNami() throws OgameException {
        Coords[] cNami = Coords.parseArray(new String[]{
                    "2:46:5", "2:46:6", "2:47:10", "2:50:6", "2:54:6", "2:55:6", "2:55:7",
                    "2:59:11", "2:65:4", "2:67:9"
                });
        Coords[] cNami2 = Coords.parseArray(new String[]{
                    "2:45:9", "2:46:4", "2:46:5", "2:46:6", "2:46:9", "2:46:10",
                    "2:47:4", "2:47:5", "2:50:6", "2:54:6", "2:54:7", "2:56:11", "2:56:12",
                    "2:61:10", "2:64:7", "2:65:4", "2:67:9"
                });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(3);
        ScanList nami = new ScanList(cNami2);
        List<Report> raportyNami = nami.scan(o);
        for (int i = 0; i < raportyNami.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyNami.get(i).print());
        }
        o.logout();
        o.stop();

    }

    private void scanAisha() throws OgameException {
        Coords[] cAisha = Coords.parseArray(new String[]{
                    "2:105:7", "2:97:12", "2:90:4", "2:115:7", "2:115:6", "2:114:10", "2:114:9", "2:111:8", "2:107:9", "2:107:8"
                });

        Coords[] cAisha2 = Coords.parseArray(new String[]{
                    "2:91:6", "2:97:4", "2:97:8", "2:97:9", "2:97:10", "2:97:12",
                    "2:98:8", "2:105:7", "2:107:8", "2:107:9", "2:107:10",
                    "2:111:8", "2:114:8", "2:114:9", "2:114:10", "2:115:6", "2:115:7",
                    "2:117:4", "2:119:7", "2:119:12", "2:120:4"
                });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(3);
        ScanList aisha = new ScanList(cAisha2);
        List<Report> raportyAisha = aisha.scan(o);
        for (int i = 0; i < raportyAisha.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyAisha.get(i).print());
        }
        o.logout();
        o.stop();
    }

    private void scanVidel() throws OgameException {
        Coords[] cVidel = Coords.parseArray(new String[]{
                    "2:151:11", "2:152:4", "2:153:10", "2:154:6", "2:156:6", "2:156:10",
                    "2:157:5", "2:157:6", "2:157:7", "2:157:11",
                    "2:159:4", "2:159:5", "2:159:11",
                    "2:161:9", "2:161:10", "2:161:12", "2:163:6",
                    "2:169:7", "2:169:8", "2:169:9", "2:169:11", "2:169:12",
                    "2:170:7", "2:171:6", "2:173:10"
                });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(3);
        ScanList aisha = new ScanList(cVidel);
        List<Report> raportyAisha = aisha.scan(o);
        for (int i = 0; i < raportyAisha.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyAisha.get(i).print());
        }
        o.logout();
        o.stop();
    }

    private void scanTatsuki() throws OgameException {
        Coords[] cVidel = Coords.parseArray(new String[]{
        "2:236:12","2:238:8","2:238:9","2:239:9","2:242:7","2:242:8","2:243:8","2:245:8",
        "2:247:4","2:251:4","2:251:5","2:251:7"
        });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(3);
        ScanList aisha = new ScanList(cVidel);
        List<Report> raportyAisha = aisha.scan(o);
        for (int i = 0; i < raportyAisha.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyAisha.get(i).print());
        }
        o.logout();
        o.stop();
    }

    private void scanHinata() throws OgameException {
        Coords[] cVidel = Coords.parseArray(new String[]{
                    "2:185:5", "2:185:6", "2:191:10", "2:193:8", "2:194:11", "2:195:5", "2:195:7",
                    "2:198:12", "2:199:6", "2:199:11", "2:206:6", "2:206:10", "2:208:9", "2:209:8", "2:211:4",});
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(3);
        ScanList aisha = new ScanList(cVidel);
        List<Report> raportyAisha = aisha.scan(o);
        for (int i = 0; i < raportyAisha.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyAisha.get(i).print());
        }
        o.logout();
        o.stop();
    }

    @Test
    @Ignore
    public void getReportTest() throws OgameElementNotFoundException, OgameException {
        o.start();
        o.login(uni, nick, pass);
        List<Report> raporty = o.getReports(21);
        Report.sortDESC(raporty);
        for (int i = 0; i < raporty.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raporty.get(i).print());
        }
        o.logout();
        o.stop();
    }
}
