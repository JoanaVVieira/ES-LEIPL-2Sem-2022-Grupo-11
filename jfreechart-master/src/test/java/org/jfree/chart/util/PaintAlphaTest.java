package org.jfree.chart.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link PaintAlpha } class.
 */


public class PaintAlphaTest {

	
    /**
     * Test for verify the old value of Alpha
     */
    @Test
	public void testSetLegacyAlpha() {
		boolean p1 = PaintAlpha.setLegacyAlpha(false);
		boolean p2 = PaintAlpha.setLegacyAlpha(false);
		boolean p3 = PaintAlpha.setLegacyAlpha(true);
		boolean p4= PaintAlpha.setLegacyAlpha(true);
		assertEquals(p2,p3);
		assertNotEquals(p4,p3);
	}
	
 
    
    /**
     *  Test Dark method for Color
     */
    @Test
	public void testDarker() {
    	double factor = 0.7;
    	Color c1 = new Color((int)(255  * factor), (int)(0 * factor), (int)(0 * factor), 0);
    	Color c2 = new Color((int)(255  * factor), (int)(0 * factor), (int)(0 * factor), 0);
    	Color c3 = new Color((int)(255  * factor), (int)(255 * factor), (int)(0 * factor), 0);
		Color c4 = (Color) PaintAlpha.darker(c1);
		Color c5 = (Color) PaintAlpha.darker(c2);
		Color c6 = (Color) PaintAlpha.darker(c3);
		assertEquals(c4,c5);
		assertNotEquals(c5,c6);
	}
    
    
    
    
    
}
