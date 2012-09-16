/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import OgameEngine.*;
import OgameEngine.Fleet.Ships;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author plich
 */
public class Interpreter {

    public Interpreter() throws OgameException {
        o = Ogame.ogameFabric("uni116", "pl");
        o.login("Pegasus", "Plich", "starwars");
        init();
    }

    private void init() {
        try {
            helpProperties = new HelpProperties();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String interpret(String s) throws OgameException {
        //o.start();
        
        String help = "help",send1 = "sendfleet", send2 = "sf", chplanet = "chplanet", build = "build", study = "study", buildShip = "buildShip";
        if (s.substring(0, help.length()).compareTo(help) == 0) {
            return help(s.substring(help.length()));
        } else  if (s.substring(0, send1.length()).compareTo(send1) == 0) {
            send(s.substring(send1.length()));
        } else if (s.substring(0, send2.length()).compareTo(send2) == 0) {
            send(s.substring(send2.length()));
        } else if (s.substring(0, chplanet.length()).compareTo(chplanet) == 0) {
            chplanet(s.substring(chplanet.length()));
        } else if (s.substring(0, build.length()).compareTo(build) == 0) {
            build(s.substring(build.length()));
        } else if (s.substring(0, study.length()).compareTo(study) == 0) {
            study(s.substring(study.length()));
        } else if (s.substring(0, buildShip.length()).compareTo(buildShip) == 0) {
            buildShip(s.substring(buildShip.length()));
        }
        return null;
    }

    private String load(String path) {
        String result = "";
        File file = new File(path);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            while (dis.available()!=0){
                result+=dis.readLine()+"\n";
            }
            dis.close();
            bis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    private String help(String substring) throws OgameException {
        String[] s = substring.split(" ");
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
        String param;
        Iterator<String> it = params.iterator();
        param = it.next();
        String dir = System.getProperty("user.dir")+"/help/"+helpProperties.getLang()+"/";
        if (param.compareTo(helpProperties.getFunctionChangePlanet()) == 0) {
            return load(dir+"changeplanet.txt");
        } else if (param.compareTo("sendfleet") == 0 || param.compareTo("sf") == 0) {
            System.out.println("NAZWA\n"
                    + "	sendfleet - wyslij flote\n"
                    + "	sf	  -     -||-\n"
                    + "\n"
                    + "SKLADNIA\n"
                    + "sendfleet {[opcja] wartosc}, {[opcja] wartosc},...\n"
                    + "OPIS\n"
                    + "	funkcja do wysylania flot\n"
                    + "\n"
                    + "OPCJE\n"
                    + "	WYBOR STATKOW\n"
                    + "		-lm [wartosc]   lekki mysliwiec\n"
                    + "		-cm [wartosc]   ciezki mysliwiec\n"
                    + "		-kr [wartosc]   krazownik\n"
                    + "		-ow [wartosc]   okret wojenny\n"
                    + "		-pan [wartosc]  pancernik\n"
                    + "		-bom [wartosc]  bombowiec\n"
                    + "		-nisz [wartosc] niszczyciel\n"
                    + "		-gs [wartosc]   gwiazda smierci\n"
                    + "		-mt [wartosc]   maly transporter\n"
                    + "		-dt [wartosc]   duzy transporter\n"
                    + "		-kol [wartosc]  kolonizator\n"
                    + "		-rec [wartosc]  recykler\n"
                    + "		-sond [wartosc] sonda szpiegowska\n"
                    + "\n"
                    + "	-c wprowadzwnie współrzędnych planety na ktora bedzie wyslana flota\n"
                    + "\n"
                    + "	WYBOR MISJI\n"
                    + "		pierw piszemy '-m' potem typ misji\n"
                    + "		-m\n"
                    + "		   acs	     laczenie ataku\n"
                    + "		   attack    atakuje flote i obrone twojego przeciwnika\n"
                    + "	           explore   wysyla twoje statki na granice wszechswiata na ekspedycje\n"
                    + "		   colonize  kolonizuje nowa planete\n"
                    + "		   moon      niszczy ksiezyc twojego wroga\n"
                    + "		   recycle   wysyla recyklery na pole zniszczen\n"
                    + "		   spy       szpieguje swiaty obcych imperiow\n"
                    + "		   station   wysyla twoja flote na inna planete\n"
                    + "		   stay      broni planety twojego sojusznika\n"
                    + "		   transport transportuje twoje surowce\n"
                    + "\n"
                    + "	WYBOR SUROWCOW\n"
                    + "		--metal [wartosc] ile metalu ma zabrac flota\n"
                    + "		--crystal [wartosc] ile krysztalu ma zabrac flota\n"
                    + "		--deuter [wartosc] ile deuteru ma zabrac flota");
        }
        return null;
    }

    private void chplanet(String substring) throws OgameException {
        String[] s = substring.split(" ");
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
        String param, value;
        Coords c = null;
        Iterator<String> it = params.iterator();
        param = it.next();
        value = it.next();
        if (param.compareTo("-c") == 0) {
            o.changePlanetByCoords(Coords.parse(value));
        } else if (param.compareTo("-l") == 0) {
            o.changePlanet(Integer.parseInt(value));
        } else if (param.compareTo("-n") == 0) {
            o.changePlanetByName(value);
        } else if (param.compareTo("--name") == 0) {
            o.changePlanetByName(value);
        }
        //else o.changePlanetByName(param);
    }

    private void buildDefence(String substring) throws OgameException {
        String[] s = substring.split(" ");
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
        String param, value;
        Iterator<String> it = params.iterator();
        param = it.next();
        value = it.next();
        Map<String,Defence> mapString2Defence = new HashMap<String,Defence>();
        mapString2Defence.put("-dp", Defence.DUZA_POWLOKA);
        mapString2Defence.put("-dl", Defence.DUZY_LASER);// TODO dokończyć
        o.buildDefence(mapString2Defence.get(param), value);
        if (param.compareTo("-dp") == 0) {
            o.buildDefence(Defence.DUZA_POWLOKA, value);
        } else if (param.compareTo("-dl") == 0) {
            o.buildDefence(Defence.DUZY_LASER, value);
        } else if (param.compareTo("-dg") == 0) {
            o.buildDefence(Defence.DZIALO_GAUSSA, value);
        } else if (param.compareTo("-dj") == 0) {
            o.buildDefence(Defence.DZIALO_JONOWE, value);
        } else if (param.compareTo("-mp") == 0) {
            o.buildDefence(Defence.MALA_POWLOKA, value);
        } else if (param.compareTo("-ml") == 0) {
            o.buildDefence(Defence.MALY_LASER, value);
        } else if (param.compareTo("-pr") == 0) {
            o.buildDefence(Defence.PRZECIWRAKIETA, value);
        } else if (param.compareTo("-rm") == 0) {
            o.buildDefence(Defence.RAKITA_MIEDZYPLANETARNA, value);
        } else if (param.compareTo("-wp") == 0) {
            o.buildDefence(Defence.WYRZUTNIA_PLAZMY, value);
        } else if (param.compareTo("-wr") == 0) {
            o.buildDefence(Defence.WYRZUTNIA_RAKIET, value);
        }
    }

    private void buildShip(String substring) throws OgameException {
        String[] s = substring.split(" ");
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
        String param, value;
        Iterator<String> it = params.iterator();
        param = it.next();
        value = it.next();
        if (param.compareTo("-bomb") == 0) {
            o.buildShip(Fleet.Ships.BOMB, value);
        } else if (param.compareTo("-cm") == 0) {
            o.buildShip(Fleet.Ships.CM, value);
        } else if (param.compareTo("-dt") == 0) {
            o.buildShip(Fleet.Ships.DT, value);
        } else if (param.compareTo("-gs") == 0) {
            o.buildShip(Fleet.Ships.GS, value);
        } else if (param.compareTo("-kol") == 0) {
            o.buildShip(Fleet.Ships.KOL, value);
        } else if (param.compareTo("-kr") == 0) {
            o.buildShip(Fleet.Ships.KR, value);
        } else if (param.compareTo("-lm") == 0) {
            o.buildShip(Fleet.Ships.LM, value);
        } else if (param.compareTo("-mt") == 0) {
            o.buildShip(Fleet.Ships.MT, value);
        } else if (param.compareTo("-nisz") == 0) {
            o.buildShip(Fleet.Ships.NISZ, value);
        } else if (param.compareTo("-ow") == 0) {
            o.buildShip(Fleet.Ships.OW, value);
        } else if (param.compareTo("-pan") == 0) {
            o.buildShip(Fleet.Ships.PAN, value);
        } else if (param.compareTo("-rec") == 0) {
            o.buildShip(Fleet.Ships.REC, value);
        } else if (param.compareTo("-sat") == 0) {
            o.buildShip(Fleet.Ships.SAT, value);
        } else if (param.compareTo("-sond") == 0) {
            o.buildShip(Fleet.Ships.SOND, value);
        }
    }

    private void build(String substring) throws OgameException {
        String[] s = substring.split(" ");
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
        String param;
        Iterator<String> it = params.iterator();
        param = it.next();
        if (param.compareTo("depozyt") == 0) {
            o.build(Buildings.DEPOZYT);
        } else if (param.compareTo("ekstraktor_deuteru") == 0) {
            o.build(Buildings.EKSTRAKTOR_DEUTERU);
        } else if (param.compareTo("elektrownia_fuzyjna") == 0) {
            o.build(Buildings.ELEKTROWNIA_FUZYJNA);
        } else if (param.compareTo("elektrownia_sloneczna") == 0) {
            o.build(Buildings.ELEKTROWNIA_SLONECZNA);
        } else if (param.compareTo("fabryka_nanitow") == 0) {
            o.build(Buildings.FABRYKA_NANITOW);
        } else if (param.compareTo("fabryka_robotow") == 0) {
            o.build(Buildings.FABRYKA_ROBOTOW);
        } else if (param.compareTo("kopalnia_krysztalu") == 0) {
            o.build(Buildings.KOPALNIA_KRYSZTALU);
        } else if (param.compareTo("kopalnia_metalu") == 0) {
            o.build(Buildings.KOPALNIA_METALU);
        } else if (param.compareTo("laboratorium") == 0) {
            o.build(Buildings.LABORATORIUM_BADAWCZE);
        } else if (param.compareTo("magazyn_deuteru") == 0) {
            o.build(Buildings.MAGAZYN_DEUTERU);
        } else if (param.compareTo("magazyn_krysztalu") == 0) {
            o.build(Buildings.MAGAZYN_KRYSZTALU);
        } else if (param.compareTo("magazyn_metalu") == 0) {
            o.build(Buildings.MAGAZYN_METALU);
        } else if (param.compareTo("satelita") == 0) {
            o.build(Buildings.SATELITA_SLONECZNA);
        } else if (param.compareTo("schowek_deuteru") == 0) {
            o.build(Buildings.SCHOWEK_DEUTERU);
        } else if (param.compareTo("schowek_krysztalu") == 0) {
            o.build(Buildings.SCHOWEK_KRYSZTALU);
        } else if (param.compareTo("schowek_metalu") == 0) {
            o.build(Buildings.SCHOWEK_METALU);
        } else if (param.compareTo("silos") == 0) {
            o.build(Buildings.SILOS_RAKIETOWY);
        } else if (param.compareTo("stocznia") == 0) {
            o.build(Buildings.STOCZNIA);
        } else if (param.compareTo("terraformer") == 0) {
            o.build(Buildings.TERRAFORMER);
        }
    }

    private void study(String substring) throws OgameException {
        String[] s = substring.split(" ");
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
        String param;
        Iterator<String> it = params.iterator();
        param = it.next();
        if (param.compareTo("astrofizyka") == 0) {
            o.study(Study.ASTROFIZYKA);
        } else if (param.compareTo("naped_impulsowy") == 0) {
            o.study(Study.NAPED_IMPULSOWY);
        } else if (param.compareTo(" naped_nadprzestrzenny") == 0) {
            o.study(Study.NAPED_NADPRZESTRZENNY);
        } else if (param.compareTo("naped_spalinowy") == 0) {
            o.study(Study.NAPED_SPALINOWY);
        } else if (param.compareTo("opanzerzenie") == 0) {
            o.study(Study.OPANCERZENIE);
        } else if (param.compareTo("grawitony") == 0) {
            o.study(Study.ROZWOJ_GRAWITONOW);
        } else if (param.compareTo("siec_badan") == 0) {
            o.study(Study.SIEC_BADAN);
        } else if (param.compareTo("technologia_bojowa") == 0) {
            o.study(Study.TECHNOLOGIA_BOJOWA);
        } else if (param.compareTo("technoogia_energetyczna") == 0) {
            o.study(Study.TECHNOLOGIA_ENERGETYCZNA);
        } else if (param.compareTo("technologia_jonowa") == 0) {
            o.study(Study.TECHNOLOGIA_JONOWA);
        } else if (param.compareTo("technologia_komputerowa") == 0) {
            o.study(Study.TECHNOLOGIA_KOMPUTEROWA);
        } else if (param.compareTo("ekstraktor_deuteru") == 0) {
            o.study(Study.TECHNOLOGIA_LASEROWA);
        } else if (param.compareTo("ekstraktor_deuteru") == 0) {
            o.study(Study.TECHNOLOGIA_NADPRZESTRZENNA);
        } else if (param.compareTo("ekstraktor_deuteru") == 0) {
            o.study(Study.TECHNOLOGIA_OCHRONNA);
        } else if (param.compareTo("ekstraktor_deuteru") == 0) {
            o.study(Study.TECHNOLOGIA_PLAZMOWA);
        } else if (param.compareTo("ekstraktor_deuteru") == 0) {
            o.study(Study.TECHNOLOGIA_SZPIEGOWSKA);
        }

    }

    private void send(String substring) throws OgameException {
        String[] s = substring.split(" ");
//        for(int i = 0; i< s.length; i++){
//            System.out.println("i="+i+" s="+s[i]);
//        }
        List<String> params = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].isEmpty()) {
                params.add(s[i]);
            }
        }
//        for (Iterator<String> it = params.iterator();it.hasNext();){
//            System.out.println("s = "+it.next());
//        }
        String param, value;
        Fleet f = new Fleet();
        Coords c = null;
        Resources res = Resources.NO_RESOURCES;
        Mission m = null;
        for (Iterator<String> it = params.iterator(); it.hasNext();) {
            param = it.next();
            value = it.next();
            //statki
            Map<String,Ships> mapString2Ships = null;
            if (mapString2Ships.containsKey(param)){}
            if (param.compareTo("-bomb") == 0) {
                f.add(Ships.BOMB, Integer.parseInt(value));
            } else if (param.compareTo("-cm") == 0) {
                f.add(Ships.CM, Integer.parseInt(value));
            } else if (param.compareTo("-dt") == 0) {
                f.add(Ships.DT, Integer.parseInt(value));
            } else if (param.compareTo("-gs") == 0) {
                f.add(Ships.GS, Integer.parseInt(value));
            } else if (param.compareTo("-kol") == 0) {
                f.add(Ships.KOL, Integer.parseInt(value));
            } else if (param.compareTo("-kr") == 0) {
                f.add(Ships.KR, Integer.parseInt(value));
            } else if (param.compareTo("-lm") == 0) {
                f.add(Ships.LM, Integer.parseInt(value));
            } else if (param.compareTo("-mt") == 0) {
                f.add(Ships.MT, Integer.parseInt(value));
            } else if (param.compareTo("-nisz") == 0) {
                f.add(Ships.NISZ, Integer.parseInt(value));
            } else if (param.compareTo("-ow") == 0) {
                f.add(Ships.OW, Integer.parseInt(value));
            } else if (param.compareTo("-pan") == 0) {
                f.add(Ships.PAN, Integer.parseInt(value));
            } else if (param.compareTo("-rec") == 0) {
                f.add(Ships.REC, Integer.parseInt(value));
            } else if (param.compareTo("-sond") == 0) {
                f.add(Ships.SOND, Integer.parseInt(value));
            } //kordynaty
            else if (param.compareTo("-c") == 0) {
                c = Coords.parse(value);
            } //surowce
            else if (param.compareTo("--metal") == 0) {
                if (res == Resources.NO_RESOURCES) {
                    res = new Resources(value, "0", "0");
                } else {
                    res.setMetal(value);
                }
            } else if (param.compareTo("--crystal") == 0) {
                if (res == Resources.NO_RESOURCES) {
                    res = new Resources("0", value, "0");
                } else {
                    res.setCrystal(value);
                }
            } else if (param.compareTo("--deuter") == 0) {
                if (res == Resources.NO_RESOURCES) {
                    res = new Resources("0", "0", value);
                } else {
                    res.setDeuter(value);
                }
            } //typ misji
            else if (param.compareTo("-m") == 0 || param.compareTo("--mission") == 0) {
                if (value.compareTo("attack") == 0) {
                    m = Mission.MISSION_ATTACK;
                } else if (value.compareTo("acs") == 0) {
                    m = Mission.MISSION_ACS;
                } else if (value.compareTo("explore") == 0) {
                    m = Mission.MISSION_EXPLORE;
                } else if (value.compareTo("colonize") == 0) {
                    m = Mission.MISSION_KOLONIZE;
                } else if (value.compareTo("moon") == 0) {
                    m = Mission.MISSION_MOON;
                } else if (value.compareTo("recycle") == 0) {
                    m = Mission.MISSION_RECYCLE;
                } else if (value.compareTo("spy") == 0) {
                    m = Mission.MISSION_SPY;
                } else if (value.compareTo("station") == 0) {
                    m = Mission.MISSION_STATION;
                } else if (value.compareTo("stay") == 0) {
                    m = Mission.MISSION_STAY;
                } else if (value.compareTo("transport") == 0) {
                    m = Mission.MISSION_TRANSPORT;
                }
            }
        }
        // nadanie
        o.sendFleet(f, c, m, res);
    }

    public static void main(String args[]) throws IOException, OgameException {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        String str;
        Interpreter i = new Interpreter();
        do {
            System.out.print("> ");
            str = br.readLine();
            i.interpret(str);
        } while (str.substring(0, 4).compareTo("quit") != 0);
    }
    HelpProperties helpProperties;
    Ogame o;
}
