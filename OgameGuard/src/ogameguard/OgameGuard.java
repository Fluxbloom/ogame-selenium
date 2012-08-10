/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ogameguard;

import OgameEngine.Events;
import OgameEngine.Ogame;
import OgameEngine.OgameException;
import OgameEngine.Slots;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author dyschemist
 */
public class OgameGuard {

    static final Logger logger = Logger.getLogger(OgameGuard.class.getName());
    Ogame o;
    List<Events> eventList;
    List<Slots> autoFleet;
    static GuardProperties properties;
    SpyResponse spyResponse;
    AttackResponse attackResponse;

    public OgameGuard(Ogame o) {
        this.o = o;
        this.spyResponse = new DefaultSpyResponse();
        this.attackResponse = new DefaultAttackResponse();
        this.autoFleet = new ArrayList<Slots>();
    }
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    /**
     * @param args the command line arguments are ignored
     */
    public static void main(String[] args) throws IOException {
        //BasicConfigurator.configure();

        /*
         * Ustawienia logowania
         */
        SimpleFormatter formatter = new SimpleFormatter();
        LoggingProperties loggingProperties = new LoggingProperties();
        if (loggingProperties.isLogStd()) {
            ConsoleHandler console = new ConsoleHandler();
            console.setFormatter(formatter);
            console.setLevel(loggingProperties.getLogStdLEVEL());
            logger.addHandler(console);
        }
        if (loggingProperties.isLogFile()) {
            FileHandler fileHandler = new FileHandler(loggingProperties.getLogFilePath());
            fileHandler.setFormatter(formatter);
            fileHandler.setLevel(loggingProperties.getLogFileLEVEL());
            logger.addHandler(fileHandler);
        }
        /*
         * Aplikacja rusza
         */
        logger.log(Level.INFO, "Aplication start");
        logger.info("Reading properties");
        /*
         * Zaczytanie propertiesów 
         */
        try {
            properties = new GuardProperties();
            logger.info("Reading properties [DONE]");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Nie można odczytać pliku properties");
            logger.severe("Property file IO Exception");
            return;
        }
        logger.info("Creating guard instance");
        OgameGuard guard = new OgameGuard(Ogame.ogameFabric(properties.getUni_number(), properties.getUni_lang()));
        /*
         * Podwoja nieskonczona petla
         */
        while (true) {
            try {
                logger.info("Logging into ogame server");
                logger.log(Level.CONFIG, "Uni={0} nick= {1} pass={2}", new Object[]{properties.getUni(), properties.getNick(), properties.getPass()});
                guard.o.login(properties.getUni(), properties.getNick(), properties.getPass());
                try {
                    while (true) {
                        logger.info("Will now play :)");
                        guard.play();
                        logger.log(Level.INFO, "Will wait for {0}:{1}:{2}", new Object[]{properties.getRefresh_hours(), properties.getRefresh_minutes(), properties.getRefresh_seconds()});
                        guard.o.wait(properties.getRefresh_hours(), properties.getRefresh_minutes(), properties.getRefresh_seconds());

                    }
                } catch (Exception ex) {
                    logger.log(Level.ALL, "Program will terminate due to {0}", ex.getMessage());
                    try {
                        guard.o.logout();
                    } catch (OgameException ex1) {
                        guard.o.close();
                        logger.log(Level.WARNING, "Exception on logout, will just close the selenium instance, error message {0}", ex1.getMessage());
                    }
                }

            } catch (OgameException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
    }

    private void play() {
        try {
            this.checkIfLogin();
            eventList = o.getEventList();
            logEventList();
            List<Events> spyActions = checkIfSpied();
            spyResponse.response(o, spyActions, autoFleet);
            //List<Flights> attackActions = checkIfAttacked();
            //attackResponse.response(o,attackActions, autoFleet);
            //checkAutoFleets();
            /*
             * 2. Sprawdź czy atakowany lub szpiegowany
             * 3. Odpowiedź na szpiegowanie
             * 4. Kolejka ucieczek
             * 5. Kolejka budowy
             * 6. Kolejka stoczni
             * 7. Kolejka badań
             * 8. Kolejka flot
             */
        } catch (OgameException ex) {
            System.err.println(ex.getMessage());
            if (ex == OgameException.LOGIN_WRONG_PASSWORD) {
                JOptionPane.showMessageDialog(null, "Podano złe hasło,login lub nazwę uniwersum.");
                JOptionPane.showMessageDialog(null, "Program przerywa swoje działanie");
                System.exit(1);
            } else if (ex == OgameException.LOGIN_BROWSER_CLOSED) {
                JOptionPane.showMessageDialog(null, "Wyłączono okno przeglądarki");
            } else if (ex == OgameException.LOGIN_NO_INTERNET_CONNECTION) {
                JOptionPane.showMessageDialog(null, "Brak połaczenia z internetem");
            }
        }
    }

    private void checkIfLogin() throws OgameException {
        if (!o.isLogged()) {
            o.relogin(properties.getUni(), properties.getNick(), properties.getPass());
        }
    }

    private List<Events> checkIfSpied() {
        List<Events> spies = new ArrayList<Events>();
        Iterator<Events> it = eventList.iterator();
        for (Events temp = it.next(); it.hasNext(); ) {
            temp = it.next();
            if (temp.getType() == Events.SPY) {
                spies.add(temp);
            }
        }
        return spies;
    }

    private List<Events> checkIfAttacked() {
        List<Events> attacks = new ArrayList<Events>();
        Iterator<Events> it = eventList.iterator();
        for (Events temp; it.hasNext(); ) {
            temp = it.next();
            if (temp.getType() == Events.ATTACK) {
                attacks.add(temp);
            }
        }
        return attacks;
    }

    public void responseToAttack() {
//        Iterator<Events> it = attackList.iterator();
//        Calendar now = GregorianCalendar.getInstance();
//        now.add(Calendar.MINUTE, (-1)*escapeMinutes);
//        Coords planeta;
//        for (Events temp = it.next(); it.hasNext(); temp=it.next()){
//            // TODO tłumaczanie na akcje
//            /*
//             * 1. Trzeba sprawdzić czy czas zgodny
//             */
//              if (temp.getArrivalTime().after(now)){
//                  planeta = temp.getDest();
//                  
//             /* 2. Czy flota na planecie
//             * 3. Jeśli trzeba podnieść to
//             * 4. Zapisać stan flot
//             * 5. Podniesc flote
//             * 6. Sprawdzić która flota się pojawiła
//             * 7. Dorzucić flotę do automatycznych
//             */
//              }
//        }
        
    }
    
    private void checkAutoFleets() {
        //TODO dopisac wnetrze
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void logEventList() {
        Calendar now = GregorianCalendar.getInstance();
        Iterator<Events> it = eventList.iterator();
        logger.log(Level.INFO, "-------------------------------------------------");
        logger.log(Level.INFO, "Time: {0}", sdf.format(now.getTime()));
        if (eventList.isEmpty()) {
            logger.log(Level.INFO, "Brak wszelkich lotów");
        } else {
            for (Events temp; it.hasNext(); ) {
                temp = it.next();
                logger.log(Level.INFO, "Fleet: {0} ->{1} on time {2} as {3}", new Object[]{(temp.getOrigin() == null ? "X" : temp.getOrigin().shortPrint()), temp.getDest().shortPrint(), sdf.format(temp.getArrivalTime().getTime()), temp.getType().getName()});
            }
        }
        logger.log(Level.INFO, "-------------------------------------------------");
    }
}
