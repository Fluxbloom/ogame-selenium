/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Klasa sluzy do odczytywania danych dotyczących ścieżek xpath do pół w menu budynków
 * // TODO missing moon building option
 * @author dyschemist
 */
public class PropertiesBuildings extends MappingProperties {
    /**
     * Domyślny konstruktor
     * @throws FileNotFoundException Błąd brakuje pliku 
     * @throws IOException Błąd odczytu zasobu dyskowego
     */
    public PropertiesBuildings() throws FileNotFoundException, IOException {
        load("building.properties");
        init();
    }
    /**
     * Inicjalizer dla pól
     */
    private void init() {
        metalMine = properties.getProperty("building_km");
        crystalMine = properties.getProperty("building_kc");
        deuteriumExtractor = properties.getProperty("building_ed");
        solarPowerPlant = properties.getProperty("building_es");
        fussionPowerPlant = properties.getProperty("building_ef");
        satellites = properties.getProperty("building_ss");
        metalStorage = properties.getProperty("building_mm");
        crystalStorage = properties.getProperty("building_mc");
        deuteriumStorage = properties.getProperty("building_md");
        metalHideout = properties.getProperty("building_sm");
        crystalHideout = properties.getProperty("building_sc");
        deuteriumHideout = properties.getProperty("building_sd");
        resourcesButtonDisabled = properties.getProperty("building_resourcesNEG");
        resourcesButtonEnabled = properties.getProperty("building_resourcesOK");
        robots = properties.getProperty("building_fr");
        shipyard = properties.getProperty("building_st");
        laboratory = properties.getProperty("building_lb");
        depositeStation = properties.getProperty("building_ds");
        missileSilo = properties.getProperty("building_sr");
        nanitas = properties.getProperty("building_fn");
        terraformer = properties.getProperty("building_te");
        stationButtonDisabled = properties.getProperty("building_stationNEG");
        stationButtonEnabled = properties.getProperty("building_stationOK");


    }
    
    /**
     * Zwraca xpath do budowy depozytu
     * @return xpath
     */
    public String getDepositeStation() {
        return depositeStation;
    }
    /**
     * Zwraca xpath do ekstraktora deuteru
     * @return xpath
     */
    public String getDeuteriumExtractor() {
        return deuteriumExtractor;
    }
    
    /**
     * Zwraca xpath do elektrowni fuzyjnej
     * @return xpath
     */

    public String getFussionPowerPlant() {
        return fussionPowerPlant;
    }
    /**
     * Zwraca xpath do elektrowni słonecznej
     * @return xpath
     */
    public String getSolarPowerPlant() {
        return solarPowerPlant;
    }
    /**
     * Zwraca xpath do budowy nanitów
     * @return xpath
     */
    public String getNanitas() {
        return nanitas;
    }
    /**
     * Zwraca xpath do budowy fabryki robotów
     * @return xpath
     */
    public String getRobots() {
        return robots;
    }
    /**
     * zwraca xpath do kopalni kryształu
     * @return xpath
     */
    public String getCrystalMine() {
        return crystalMine;
    }
    /**
     * zwraca xpath do kopalni metalu
     * @return xpath
     */
    public String getMetalMine() {
        return metalMine;
    }
    /**
     * zwraca xpath do laboratorium
     * @return xpath
     */
    public String getLaboratory() {
        return laboratory;
    }

    public String getCrystalStorage() {
        return crystalStorage;
    }

    public String getDeuteriumStorage() {
        return deuteriumStorage;
    }

    public String getMetalStorage() {
        return metalStorage;
    }

    public String getResourcesButtonDisabled() {
        return resourcesButtonDisabled;
    }

    public String getResourcesButtonEnabled() {
        return resourcesButtonEnabled;
    }

    public String getCrystalHideout() {
        return crystalHideout;
    }

    public String getDeuteriumHideout() {
        return deuteriumHideout;
    }

    public String getMetalHideout() {
        return metalHideout;
    }

    public String getMissileSilo() {
        return missileSilo;
    }

    public String getSatellites() {
        return satellites;
    }

    public String getShipyardBuilding() {
        return shipyard;
    }

    public String getStationButtonDisabled() {
        return stationButtonDisabled;
    }

    public String getStationBuildingEnabled() {
        return stationButtonEnabled;
    }

    public String getTerraformer() {
        return terraformer;
    }
    
    private String metalMine;//=xpath=(//a[@id='details'])[1]
    private String crystalMine;//=xpath=(//a[@id='details'])[2]
    private String deuteriumExtractor;//=xpath=(//a[@id='details'])[3]
    private String solarPowerPlant;//=xpath=(//a[@id='details'])[4]
    private String fussionPowerPlant;//=xpath=(//a[@id='details'])[5]
    private String satellites;//=xpath=(//a[@id='details'])[6]
    private String metalStorage;//=xpath=(//a[@id='details'])[7]
    private String crystalStorage;//=xpath=(//a[@id='details'])[8]
    private String deuteriumStorage;//=xpath=(//a[@id='details'])[9]
    private String metalHideout;//=xpath=(//a[@id='details'])[10]
    private String crystalHideout;//=xpath=(//a[@id='details'])[11]
    private String deuteriumHideout;//=xpath=(//a[@id='details'])[12]

    private String robots;//=id=details14
    private String shipyard;//=id=details21
    private String laboratory;//=id=details31
    private String depositeStation;//=id=details34
    private String missileSilo;//=id=details44
    private String nanitas;//=id=details15
    private String terraformer;//=id=details33

    private String resourcesButtonDisabled;//=//a[@class='build-it_disabled']
    private String resourcesButtonEnabled;//=//a[@class='build-it']
    private String stationButtonDisabled;//=//a[@class='build-it_disabled']
    private String stationButtonEnabled;//=//a[@class='build-it']

}
