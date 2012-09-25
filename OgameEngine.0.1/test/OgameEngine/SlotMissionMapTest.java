/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngine;

import OgameEngine.PropertiesOgame;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dyschemist
 */
public class SlotMissionMapTest {
    
    PropertiesOgame map;
    
    public SlotMissionMapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
            map =PropertiesOgame.mappingPropertiesFabric();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void slotMissiomMapGetFromFile() {
    String[] values = new String[]{"ACS","ATTACK","COLONIZE","EXPLORE","RECYCLE",
        "TRANSPORT","STATION","SPY","STAY","MOON"}; 
    for (int i=0; i < values.length;i++){
        System.out.println("Mission="+values[i]+"->"+map.getSlots().getSlotMissionID(values[i]));
    }
    
        
    }
}
