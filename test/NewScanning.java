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
        //o.wait(20, 0);
        //scanNami();
        scanAisha();
        scanVidel();
        //scanHinata();
        //scanTatsuki();
        //scanHotaru();
    }

    private void scanNami() throws OgameException {
        Coords[] cNami = Coords.parseArray(new String[]{
            "2:40:9","2:42:5","2:43:4","2:43:6","2:45:4","2:45:9","2:45:12","2:46:9","2:46:10",
            "2:47:4","2:47:5","2:47:8","2:48:7","2:48:8",
            "2:50:6","2:50:7","2:50:10",
            "2:52:4","2:54:6","2:54:7","2:55:10","2:56:11","2:56:12",
            "2:58:12","2:59:11","2:60:6","2:61:10","2:62:6",
            "2:64:10","2:64:11","2:64:12","2:65:12",
            "2:67:4","2:67:7","2:67:9","2:67:12","2:68:8","2:69:7","2:69:10","2:70:4","2:72:8",
            "2:74:10","2:74:11","2:75:6"
                    });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(1);
        ScanList nami = new ScanList(cNami);
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
                    "2:90:4","2:90:8","2:90:12","2:91:6","2:91:7",
                    "2:93:4","2:94:12","2:96:8", 
                    "2:97:4","2:97:6", "2:97:9", "2:97:10", "2:97:11","2:98:12","2:100:10",
                    "2:103:4","2:103:5","2:103:8","2:103:12","2:105:4", "2:105:7","2:105:12",
                    "2:107:8","2:107:9", "2:107:10", "2:107:12","2:108:4","2:108:7","2:112:6",
                    "2:112:13", "2:114:6", "2:114:11", "2:114:12", "2:115:6", "2:115:7","2:115:8",
                    "2:116:4","2:118:11", "2:119:7","2:119:10", "2:119:12", "2:120:4","2:122:10"
                });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(2);
        ScanList aisha = new ScanList(cAisha);
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
            "2:142:10","2:142:11","2:146:6","2:149:4","2:149:6",
            "2:155:4","2:156:5", "2:156:6",
                    "2:157:7", "2:157:10","2:157:12","2:158:11",
                    "2:159:4","2:159:5", "2:159:11",
                   "2:161:12", "2:163:6","2:166:4","2:167:6","2:167:12","2:168:4","2:168:12",
                    "2:169:9", "2:169:11", "2:169:12",
                    "2:170:4","2:170:6","2:170:11", "2:171:6","2:172:4","2:173:4","2:173:9","2:173:12",
                    "2:174:4","2:175:6","2:175:11"
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
            "2:183:10","2:188:10","2:190:10","2:190:11","2:191:10","2:193:6",
            "2:193:8","2:194:12","2:195:4", "2:195:6","2:197:4","2:198:10","2:200:6","2:200:10",
            "2:201:10","2:205:12", "2:208:4", "2:208:7",
            "2:208:9","2:210:10", "2:211:4","2:211:6","2:213:4","2:213:12","2:214:5","2:215:10","2:215:12","2:216:10"});
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(4);
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
         "2:224:5","2:224:6","2:224:10","2:226:7","2:227:8","2:228:6","2:228:7","2:229:6","2:229:10"   ,
         "2:230:6","2:231:11","2:231:12","2:234:5","2:235:4","2:235:5","2:235:6","2:235:11",
         "2:241:6","2:241:8","2:241:10","2:241:11","2:242:12","2:243:8",
         "2:243:12","2:244:6","2:244:10","2:245:6",
        "2:247:4","2:247:6","2:250:3","2:250:6","2:250:11","2:250:12","2:251:11","2:253:8","2:257:8","2:258:4",
        "2:259:6","2:261:8","2:261:10","2:261:12"
        });
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(5);
        ScanList aisha = new ScanList(cVidel);
        List<Report> raportyAisha = aisha.scan(o);
        for (int i = 0; i < raportyAisha.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyAisha.get(i).print());
        }
        o.logout();
        o.stop();
    }

    
    private void scanHotaru() throws OgameException{
    Coords[] cHotaru= Coords.parseArray(new String[]{
                "3:21:8","3:21:11",//"3:21:12",
                "3:22:8", "3:22:10",//"3:22:12",
                "3:27:4",//"3:27:6",
                "3:28:4","3:29:6","3:29:10","3:30:4", "3:30:9",
                "3:34:6","3:34:8",//"3:34:10",
                "3:35:5","3:35:8","3:35:12","3:37:6",
                "3:39:6","3:39:7","3:37:10","3:40:6","3:40:8","3:41:10",
               "3:43:6","3:43:8","3:44:9"});
    
        o.start();
        o.login(uni, nick, pass);
        o.changePlanet(3);
        ScanList hotaru = new ScanList(cHotaru);
        List<Report> raportyHotaru = hotaru.scan(o);
        for (int i = 0; i < raportyHotaru.size(); i++) {
            System.out.println("Numer " + i);
            System.out.println(raportyHotaru.get(i).print());
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
