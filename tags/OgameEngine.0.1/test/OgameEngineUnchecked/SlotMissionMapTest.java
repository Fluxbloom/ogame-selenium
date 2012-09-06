/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OgameEngineUnchecked;

import OgameEngineUnchecked.MappingProperties;
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
    
    MappingProperties map;
    
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
            map =MappingProperties.mappingPropertiesFabric();
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
