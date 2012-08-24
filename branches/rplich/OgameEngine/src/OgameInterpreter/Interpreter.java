/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameInterpreter;

import OgameEngine.*;
import OgameEngine.Fleet.Ships;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author plich
 */
public class Interpreter {

    Ogame o;

    public Interpreter() throws OgameException {
        o = Ogame.ogameFabric("uni116", "pl");
        o.login("Pegasus", "Plich", "starwars");
    }

    public void interpret(String s) throws OgameException {
        String help = "help";
        if (s.substring(0, help.length()).compareTo(help) == 0) {
            help(s.substring(help.length()));

        }
        // nadanie floty
        // -sendfleet
        // -sf

        String send1 = "sendfleet", send2 = "sf", chplanet = "chplanet";
        if (s.substring(0, send1.length()).compareTo(send1) == 0) {
            send(s.substring(send1.length()));
        } else if (s.substring(0, send2.length()).compareTo(send2) == 0) {
            send(s.substring(send2.length()));
        } else if (s.substring(0, chplanet.length()).compareTo(chplanet) == 0) {
            chplanet(s.substring(chplanet.length()));
        }
    }

    private void help(String substring) throws OgameException {
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
        if (param.compareTo("chplanet") == 0) {
            System.out.println("NAZWA\n"
                    + "    chplanet\n"
                    + "SKŁADNIA\n"
                    + "    chplanet opcja [dane planety]\n"
                    + "OPIS\n"
                    + "    Funkcja pozwala skakać miedzy planetami\n"
                    + "OPCJE\n"
                    + "    -c pozwala wybrac planete za pomoca wspolrzednych\n"
                    + "    -l pozwala wybrac planete za pomoca jej kolejnosci na liscie\n"
                    + "    -n --name pozwala wybrac planeta za pomoca jej nazwy\n");
        }
        if (param.compareTo("sendfleet") == 0 || param.compareTo("sf") == 0) {
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
}
