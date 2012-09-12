/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.Exceptions.OgameFileNotFoundException;
import OgameEngine.Exceptions.OgameIOException;
import OgameEngineUnchecked.MappingProperties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa sluzy do odczytywania danych dotyczących ścieżek xpath do pół w menu budynków
 * // TODO dodac pola dla księżyców
 * @author Piotr Kowalski
 */
public class PropertiesBuildings extends MappingProperties {

    /**
     * Domyślny konstruktor
     * @throws FileNotFoundException Błąd brakuje pliku 
     * @throws IOException Błąd odczytu zasobu dyskowego
     */
    public PropertiesBuildings() throws OgameFileNotFoundException, OgameIOException {
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
        shipyardBuilding = properties.getProperty("building_st");
        laboratory = properties.getProperty("building_lb");
        depositeStation = properties.getProperty("building_ds");
        missileSilo = properties.getProperty("building_sr");
        nanitas = properties.getProperty("building_fn");
        terraformer = properties.getProperty("building_te");
        stationButtonDisabled = properties.getProperty("building_stationNEG");
        stationButtonEnabled = properties.getProperty("building_stationOK");

        //Buildings Resources Needed

        res_crystal = properties.getProperty("res_cristal");//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]
        res_crystal_value = properties.getProperty("res_cristal_value");//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]/span
        res_metal = properties.getProperty("res_metal");//li[@class="metal tipsStandard" and contains(@title,"Metal")]
        res_metal_value = properties.getProperty("res_metal_value");//li[@class="metal tipsStandard" and contains(@title,"Metal")]/span
        res_deuter = properties.getProperty("res_deuter");//li[@class="metal tipsStandard" and contains(@title,"Deuter")]
        res_deuter_value = properties.getProperty("res_deuter_value");//li[@class="metal tipsStandard" and contains(@title,"Deuter")]/span
        res_energy = properties.getProperty("res_energy");//li[@class="metal tipsStandard" and contains(@title,"Energia")]
        res_energy_value = properties.getProperty("res_energy_value");//li[@class="metal tipsStandard" and contains(@title,"Energia")]/span

        //Stations Resources Needed

        sta_cristal = properties.getProperty("sta_cristal");//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]
        sta_cristal_value = properties.getProperty("sta_cristal_value");//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]/span
        sta_metal = properties.getProperty("sta_metal");//li[@class="metal tipsStandard" and contains(@title,"Metal")]
        sta_metal_value = properties.getProperty("sta_metal_value");//li[@class="metal tipsStandard" and contains(@title,"Metal")]/span
        sta_deuter = properties.getProperty("sta_deuter");//li[@class="metal tipsStandard" and contains(@title,"Deuter")]
        sta_deuter_value = properties.getProperty("sta_deuter_value");//li[@class="metal tipsStandard" and contains(@title,"Deuter")]/span
        sta_energy = properties.getProperty("sta_energy");//li[@class="metal tipsStandard" and contains(@title,"Energia")]
        sta_energy_value = properties.getProperty("sta_energy_value");//l
        
        // hugeNumbersNames mapping
        {
        hugeNumbersNames = new HashMap<String,String>();
        String s = properties.getProperty("hugeNumbersNames");
        String[] str = s.split(";;"),temp;
        for (int i=0; i< str.length; i++){
            temp = str[i].split(";");
            hugeNumbersNames.put(temp[0], temp[1]);
        }
        }
        
        
        time_xpath = properties.getProperty("time_xpath");
        time_weeks = properties.getProperty("time_weeks");
        time_days = properties.getProperty("time_days");
        time_hours = properties.getProperty("time_hours");
        time_minutes = properties.getProperty("time_minutes");
        time_seconds = properties.getProperty("time_seconds");

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

    /**
     * Zwraca xpath do magazynu kryształu
     * @return xpath
     */
    
    public String getCrystalStorage() {
        return crystalStorage;
    }

    /**
     * Zwraca xpath do magazynu deuteru
     * @return xpath
     */
    
    public String getDeuteriumStorage() {
        return deuteriumStorage;
    }

    /**
     * Zwraca xpath do magazynu metalu
     * @return xpath
     */
    
    public String getMetalStorage() {
        return metalStorage;
    }

    /**
     * Zwraca xpath do przycisku zablokowanej budowy
     * @return xpath
     */
    
    public String getResourcesButtonDisabled() {
        return resourcesButtonDisabled;
    }

    /**
     * Zwraca xpath do przycisku odblokowanej budowy
     * @return xpath
     */
    
    public String getResourcesButtonEnabled() {
        return resourcesButtonEnabled;
    }

    /**
     * Zwraca xpath do skrytki kryształu
     * @return xpath
     */
    
    public String getCrystalHideout() {
        return crystalHideout;
    }
    /**
     * Zwraca xpath do skrytki deuteru
     * @return xpath
     */
    public String getDeuteriumHideout() {
        return deuteriumHideout;
    }

    /**
     * Zwraca xpath do skrytki metalu
     * @return xpath
     */
    public String getMetalHideout() {
        return metalHideout;
    }

    /**
     * Zwraca xpath do silosa
     * @return xpath
     */
    public String getMissileSilo() {
        return missileSilo;
    }

    /**
     * Zwraca xpath do pseudo budynku satelit słonecznych
     * @return xpath
     */
    public String getSatellites() {
        return satellites;
    }

    /**
     * Zwraca xpath do budynku stoczni
     * @return xpath
     */
    public String getShipyardBuilding() {
        return shipyardBuilding;
    }

    /**
     * Zwraca xpath do zablokowanego przycisku budowy
     * @return 
     */
    public String getStationButtonDisabled() {
        return stationButtonDisabled;
    }
    /**
     * Zwraca xpath do odblokowanego przycisku budowy
     * @return 
     */
    public String getStationButtonEnabled() {
        return stationButtonEnabled;
    }
    /**
     * Zwraca xpath do terraformera
     * @return 
     */
    public String getTerraformer() {
        return terraformer;
    }
    /**
     * Pobiera element zawierający dane o krysztale
     * @return xpath do root elementu krysztalu
     */
    public String getRes_crystal() {
        return res_crystal;
    }
    /**
     * Pobiera xpath to elementu z liczbą kryształów
     * @return xpath do liczby kryształów
     */
    public String getRes_crystal_value() {
        return res_crystal_value;
    }
    /**
     * Pobiera element zawierający dane o deuterze
     * @return xpath do root elementu deuteru
     */
    public String getRes_deuter() {
        return res_deuter;
    }
/**
     * Pobiera xpath to elementu z liczbą deuteru
     * @return xpath do liczby deuteru
     */
    public String getRes_deuter_value() {
        return res_deuter_value;
    }
    /**
     * Pobiera element zawierający dane o deuterze
     * @return xpath do root elementu deuteru
     */
    public String getRes_energy() {
        return res_energy;
    }
/**
     * Pobiera xpath to elementu z liczbą energii
     * @return xpath do liczby energii
     */
    public String getRes_energy_value() {
        return res_energy_value;
    }
    /**
     * Pobiera element zawierający dane o metalu
     * @return xpath do root elementu metalu
     */
    public String getRes_metal() {
        return res_metal;
    }
/**
     * Pobiera xpath to elementu z liczbą metalu
     * @return xpath do liczby metalu
     */
    public String getRes_metal_value() {
        return res_metal_value;
    }
    /**
     * Pobiera element zawierający dane o kryształu
     * @return xpath do root elementu kryształu
     */
    public String getSta_cristal() {
        return sta_cristal;
    }
/**
     * Pobiera xpath to elementu z liczbą kryształów
     * @return xpath do liczby kryształów
     */
    public String getSta_cristal_value() {
        return sta_cristal_value;
    }
    /**
     * Pobiera element zawierający dane o deuterze
     * @return xpath do root elementu deuteru
     */
    public String getSta_deuter() {
        return sta_deuter;
    }
/**
     * Pobiera xpath to elementu z liczbą deuteru
     * @return xpath do liczby deuteru
     */
    public String getSta_deuter_value() {
        return sta_deuter_value;
    }
    /**
     * Pobiera element zawierający dane o energii
     * @return xpath do root elementu energii
     */
    public String getSta_energy() {
        return sta_energy;
    }
/**
     * Pobiera xpath to elementu z liczbą energii
     * @return xpath do liczby energii
     */
    public String getSta_energy_value() {
        return sta_energy_value;
    }
    /**
     * Pobiera element zawierający dane o metalu
     * @return xpath do root elementu metalu
     */
    public String getSta_metal() {
        return sta_metal;
    }
/**
     * Pobiera xpath to elementu z liczbą metalu
     * @return xpath do liczby metalu
     */
    public String getSta_metal_value() {
        return sta_metal_value;
    }
    /**
     * Pobiera mappowania zastępników skrótów dużych liczb
     * @return mapowanie skrótów dużych liczb
     */
    public Map<String, String> getHugeNumbersNames() {
        return hugeNumbersNames;
    }

    
    /**
     * Pobiera string to pola z czasem budowy
     * @return xpath
     */
    public String getTime_xpath() {
        return time_xpath;
    }
    /**
     * Pobiera znacznik pola do dni
     * @return znacznik dni
     */
    public String getTime_days() {
        return time_days;
    }
    /**
     * Pobiera znacznik do pola godzin
     * @return znacznik godzin
     */
    public String getTime_hours() {
        return time_hours;
    }
/**
     * Pobiera znacznik minut
     * @return znacznik minut
     */
    public String getTime_minutes() {
        return time_minutes;
    }
/**
     * Pobiera znacznik sekund
     * @return znacznik sekund
     */
    public String getTime_seconds() {
        return time_seconds;
    }

    /**
     * Pobiera znacznik tygodni
     * @return znacznik tygodni
     */
    public String getTime_weeks() {
        return time_weeks;
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
    private String shipyardBuilding;//=id=details21
    private String laboratory;//=id=details31
    private String depositeStation;//=id=details34
    private String missileSilo;//=id=details44
    private String nanitas;//=id=details15
    private String terraformer;//=id=details33
    private String resourcesButtonDisabled;//=//a[@class='build-it_disabled']
    private String resourcesButtonEnabled;//=//a[@class='build-it']
    private String stationButtonDisabled;//=//a[@class='build-it_disabled']
    private String stationButtonEnabled;//=//a[@class='build-it']
    //Buildings Resources Needed
    private String res_crystal;//=//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]
    private String res_crystal_value;//=//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]/span
    private String res_metal;//=//li[@class="metal tipsStandard" and contains(@title,"Metal")]
    private String res_metal_value;//=//li[@class="metal tipsStandard" and contains(@title,"Metal")]/span
    private String res_deuter;//=//li[@class="metal tipsStandard" and contains(@title,"Deuter")]
    private String res_deuter_value;//=//li[@class="metal tipsStandard" and contains(@title,"Deuter")]/span
    private String res_energy;//=//li[@class="metal tipsStandard" and contains(@title,"Energia")]
    private String res_energy_value;//=//li[@class="metal tipsStandard" and contains(@title,"Energia")]/span
    //Station Resources Needed
    private String sta_cristal;//=//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]
    private String sta_cristal_value;//=//li[@class="metal tipsStandard" and contains(@title,"Kryształ")]/span
    private String sta_metal;//=//li[@class="metal tipsStandard" and contains(@title,"Metal")]
    private String sta_metal_value;//=//li[@class="metal tipsStandard" and contains(@title,"Metal")]/span
    private String sta_deuter;//=//li[@class="metal tipsStandard" and contains(@title,"Deuter")]
    private String sta_deuter_value;//=//li[@class="metal tipsStandard" and contains(@title,"Deuter")]/span
    private String sta_energy;//=//li[@class="metal tipsStandard" and contains(@title,"Energia")]
    private String sta_energy_value;//=//li[@class="metal tipsStandard" and contains(@title,"Energia")]/span
    
    private Map<String,String> hugeNumbersNames;
    
    private String time_xpath;
    private String time_weeks;
    private String time_days;
    private String time_hours;
    private String time_minutes;
    private String time_seconds;
}
