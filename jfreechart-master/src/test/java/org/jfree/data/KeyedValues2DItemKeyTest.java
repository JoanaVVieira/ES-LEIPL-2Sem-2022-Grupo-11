package org.jfree.data;

import org.jfree.chart.TestUtils;
import org.jfree.chart.internal.CloneUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link KeyedValues2DItemKey} class.
 */
public class KeyedValues2DItemKeyTest {
	
	/**
     * Some checks for the equals() method.
     */
    @Test
    public void testEquals() {
    	KeyedValues2DItemKey<String,String> k1 = new KeyedValues2DItemKey<String,String>("R1", "C1");
    	assertEquals(true, k1.equals(k1));
    	
    	KeyedValues2DItemKey<String,String> k2 = new KeyedValues2DItemKey<String,String>("R1", "C2");
    	assertEquals(false, k1.equals(k2));
    	
    	KeyedValues2DItemKey<String,String> k3 = new KeyedValues2DItemKey<String,String>("R2", "C1");
    	assertEquals(false, k1.equals(k3));
    }
    
	/**
     * Some checks for the compareTo() method.
     */
    @Test
    public void testCompareTo() {
    	KeyedValues2DItemKey<String,String> k1 = new KeyedValues2DItemKey<String,String>("R1", "C1");
    	assertEquals(0, k1.compareTo(k1));
    	
    }
    
	/**
     * Some checks for the getColumnKey() method.
     */
    @Test
    public void testGetColumnKey() {
    	KeyedValues2DItemKey<String,String> k1 = new KeyedValues2DItemKey<String,String>("R1", "C1");
    	assertEquals("C1", k1.getColumnKey());
    	
    }
    
	/**
     * Some checks for the getRowKey() method.
     */
    @Test
    public void testGetRowKey() {
    	KeyedValues2DItemKey<String,String> k1 = new KeyedValues2DItemKey<String,String>("R1", "C1");
    	assertEquals("R1", k1.getRowKey());
    	
    }
    
	/**
     * Some checks for the toString() method.
     */
    @Test
    public void testToString() {
    	KeyedValues2DItemKey<String,String> k1 = new KeyedValues2DItemKey<String,String>("R1", "C1");
    	assertEquals(k1.toString(), "Values2DItemKey[row="+k1.getRowKey().toString()+",column="+k1.getColumnKey().toString()+"]");
    	
    }
    
	/**
     * Some checks for the toJSONString() method.
     */
    @Test
    public void testToJSONString() {
    	KeyedValues2DItemKey<String,String> k1 = new KeyedValues2DItemKey<String,String>("R1", "C1");
    	assertEquals(k1.toJSONString(), "{\"rowKey\": \""+k1.getRowKey().toString()+"\", "+"\"columnKey\": \""+k1.getColumnKey().toString()+"\"}");
    	
    }

}
