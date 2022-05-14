package org.jfree.data;

import org.jfree.chart.TestUtils;
import org.jfree.chart.internal.CloneUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link KeyedValuesItemKey} class.
 */

public class KeyedValuesItemKeyTest {

	/**
     * Some checks for the equals() method.
     */
    @Test
    public void testEquals() {
    	KeyedValuesItemKey<String> k1 = new KeyedValuesItemKey<String>("R1");
    	assertEquals(true, k1.equals(k1));
    	
    	KeyedValuesItemKey<String> k2 = new KeyedValuesItemKey<String>("R2");
    	assertEquals(false, k1.equals(k2));
    }

	/**
     * Some checks for the getKey() method.
     */
    @Test
    public void testGetKey() {
    	KeyedValuesItemKey<String> k1 = new KeyedValuesItemKey<String>("C1");
    	assertEquals("C1", k1.getKey());
    	
    }
    
	/**
     * Some checks for the toString() method.
     */
    @Test
    public void testToString() {
    	KeyedValuesItemKey<String> k1 = new KeyedValuesItemKey<String>("R1");
    	assertEquals(k1.toString(), "KeyedValuesItemKey["+k1.getKey().toString()+"]");
    	
    }
    
	/**
     * Some checks for the toJSONString() method.
     */
    @Test
    public void testToJSONString() {
    	KeyedValuesItemKey<String> k1 = new KeyedValuesItemKey<String>("R1");
    	assertEquals(k1.toJSONString(), "{\"key\": \""+k1.getKey().toString()+"\"}");
    	
    }
	
}
