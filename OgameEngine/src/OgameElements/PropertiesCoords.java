/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameElements;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa odczytuje ustawienia dla dopuszczalnych kordynatów na danym uniwersum
 * W szczególności, chodzi tu o ilość planet, układów planetarnych, galaktyk 
 * oraz pozycji planetarnych których dotyczą się misje ekspedycji 
 * @author Piotr Kowalski
 */
class PropertiesCoords {

    /**
     * Domyślny konstruktor odczytujący dane z pliku configuracyjnego coords.properties
     * zapisanego w katalogu wskazanym w defaultConfFile.properties
     * @throws OgameFileNotFoundException brak pliku konfiguracji
     * @throws OgameIOException błąd dostępu do pliku (czterokrotny)
     */
    public PropertiesCoords() throws OgameFileNotFoundException, OgameIOException {
        load("coords.properties");
        init();
    }
    
    private void load(String name) throws OgameFileNotFoundException, OgameIOException{
        properties = new Properties();
        Properties defaultPath = new Properties();
        String defaultConfFilePath = System.getProperty("user.dir") + "/conf/defaultConfFile.properties";
        File main = new File(defaultConfFilePath);
        if (main.exists()) {
            try {
                defaultPath.load(new FileInputStream(main));
            } catch (FileNotFoundException ex) {
                logger.log(Level.SEVERE, "Missing file {0}", new String[]{defaultConfFilePath});
                throw new OgameFileNotFoundException(defaultConfFilePath);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Could read the source {0}", new String[]{defaultConfFilePath});
                int tries = 0;
                while (tries < 3) {
                    try {
                        defaultPath.load(new FileInputStream(main));
                        break;
                    } catch (IOException ex1) {
                        tries++;
                        logger.log(Level.SEVERE, "Could read the source {0} retry {1}",
                                new String[]{defaultConfFilePath, Integer.toString(tries)});
                        if (tries == 3) {
                            throw new OgameIOException(ex1);
                        }
                    }
                }

            }
        } else {
            throw new OgameFileNotFoundException(defaultConfFilePath);
        }
        path = System.getProperty("user.dir") + "/conf/" + defaultPath.getProperty("folder") + "/"+name;
        File conf = new File(path);
        if (conf.exists()) {
            try {
                properties.load(new FileInputStream(conf));
            } catch (FileNotFoundException ex) {
                logger.log(Level.SEVERE, "Missing file {0}", new String[]{path});
                throw new OgameFileNotFoundException(path);
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Could read the source {0}", new String[]{path});
                int tries = 0;
                while (tries < 3) {
                    try {
                        properties.load(new FileInputStream(conf));
                        break;
                    } catch (IOException ex1) {
                        tries++;
                        logger.log(Level.SEVERE, "Could read the source {0} retry {1}",
                                new String[]{path, Integer.toString(tries)});
                        if (tries == 3) {
                            throw new OgameIOException(ex1);
                        }
                    }
                }
            }
        } else {
            throw new OgameFileNotFoundException(path);
        }
    }
    
    private void init(){
        universes = Integer.parseInt(properties.getProperty("universes"));
        systems = Integer.parseInt(properties.getProperty("systems"));
        positions = Integer.parseInt(properties.getProperty("positions"));
        String[] exploreString = properties.getProperty("explore_positions").split(";");
        explorePos = new int[exploreString.length];
        for (int i = 0; i < explorePos.length; i++) {
            explorePos[i] = Integer.parseInt(exploreString[i]);
        }
        moon_markup= properties.getProperty("moon_markup");
        debris_markup=properties.getProperty("debris_markup");
    }
    /**
     * Odczytuje ilość pozycji dostępnych
     * @return ilość pozycji
     */
    public int getPositions() {
        return positions;
    }
    /**
     * Odczytuje ilość dostępnych układów planetarnych
     * @return ilośc układów planetarnych
     */
    public int getSystems() {
        return systems;
    }
    /**
     * Odczytuje ilość galaktyk
     * @return  ilość galaktyk
     */
    public int getUniverses() {
        return universes;
    }
    /**
     * Odczytuje pozycje na których można przeprowadzać ekspedycje
     * @return tablica pozycji na których można prowadzić ekspedycje
     */
    public int[] getExplorePos() {
        return explorePos;
    }
    /**
     * Odczytuje pozycje pliku konfiguracji
     * Dopisane na potrzebę logowania błędu
     * @return ścieżka do pliku konfiguracji
     */
    public String getPath() {
        return path;
    }
    /**
     * Pobiera suffix dla kordów pz
     * @return suffix kordów pz
     */
    public String getDebris_markup() {
        return debris_markup;
    }
    /**
     * Pobiera suffix dla kordów księżyca
     * @return suffix kordów księżyca
     */
    public String getMoon_markup() {
        return moon_markup;
    }
    
    
    
    private Properties properties;
    private String path;
    private int universes;
    private int systems;
    private int positions;
    private int[] explorePos;
    private String moon_markup;
    private String debris_markup;
    
    private static final Logger logger = Logger.getLogger(PropertiesCoords.class.getName());
}
