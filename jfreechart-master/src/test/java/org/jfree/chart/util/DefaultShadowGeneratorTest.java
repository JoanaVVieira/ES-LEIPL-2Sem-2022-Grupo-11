package org.jfree.chart.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link DefaultShadowGenerator } class.
 */

public class DefaultShadowGeneratorTest {

	
	/**
	 * Tests for both constructors
	 * 
	 */
	 @Test
	public void testDefaultShadowGenerator() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator();
		DefaultShadowGenerator d2 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		assertEquals(d1, d2);	
	}
	
	
	/**
	 * Tests for obtain shadow size
	 * 
	 */
	 @Test
	public void testGetShadowSize() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		int s1 = 5;
		int s2 = 1;
		assertEquals(d1.getShadowSize(),s1);
		assertNotEquals(d1.getShadowSize(),s2);	
	}
	
	
	/**
	 * Tests for obtain shadow color
	 * 
	 */
	 @Test
	public void testGetShadowColor() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		assertEquals(d1.getShadowColor(),black);
		assertNotEquals(d1.getShadowColor(),white);	
	}
	
	
	
	
	/**
	 * Tests for obtain shadow opacity
	 * 
	 */
	 @Test
	public void testGetShadowOpacity() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		float o1 = 0.5f;
		float o2 = 1.0f;
		assertEquals(d1.getShadowOpacity(),o1);	
		assertNotEquals(d1.getShadowOpacity(),o2);	
	}
	
	
	/**
	 * Tests for obtain distance
	 * 
	 */
	 @Test
	public void testGetDistance() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		int c1 = 5;
		int c2 = 1;
		
		assertEquals(d1.getDistance(),c1);	
		assertNotEquals(d1.getDistance(),c2);	
	}
	
	
	
	/**
	 * Tests for obtain angle
	 * 
	 */
	 @Test
	public void testGetAngle() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		double a1 = -Math.PI / 4;
		double a2 = -Math.PI / 5;
		assertEquals(d1.getAngle(),a1);	
		assertNotEquals(d1.getAngle(),a2);	
	}
	
	
	/**
	 * Tests for calutate x-offset
	 * 
	 */
	 @Test
	public void testCalculateOffsetX() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		double a1 = -Math.PI / 4;
		int c1 = 5;
		int s1 = 5;
		int s2 = 4;
		int x1 = (int) (Math.cos(a1) * c1) - s1;
		int x2 = (int) (int) (Math.cos(a1) * c1) - s2;
		assertEquals(d1.calculateOffsetX(),x1);	
		assertNotEquals(d1.calculateOffsetX(),x2);	
	}
	
	/**
	 * Tests for calutate y-offset
	 * 
	 */
	 @Test
	public void testCalculateOffsetY() {
		DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
		double a1 = -Math.PI / 4;
		int c1 = 5;
		int s1 = 5;
		int s2 = 4;
		int x1 = (int) -(Math.sin(a1) * c1) - s1;
		int x2 = (int) -(Math.sin(a1) * c1) - s2;
		assertEquals(d1.calculateOffsetY(),x1);	
		assertNotEquals(d1.calculateOffsetY(),x2);	
	}
	 
	 
		/**
		 * Tests for a return of an imange containing the drop shadow
		 * 
		 */
		 @Test
		public void testCreateDropShadow() {
			DefaultShadowGenerator d1 = new DefaultShadowGenerator(5, Color.BLACK, 0.5f, 5, -Math.PI / 4);
			int s1 = 5;
			BufferedImage i1 = new BufferedImage(100+s1*2,100+s1*2,BufferedImage.TYPE_INT_ARGB);
			BufferedImage i2 = new BufferedImage(100+s1*2,100+s1*2,BufferedImage.TYPE_INT_ARGB);
			BufferedImage i3 = new BufferedImage(120+s1*2,100+s1*2,BufferedImage.TYPE_INT_ARGB);
			BufferedImage r1 = d1.createDropShadow(i1);
			BufferedImage r2 = d1.createDropShadow(i2);
			BufferedImage r3 = d1.createDropShadow(i3);		
			assertTrue(!r1.equals(r2));	
			assertTrue(!r1.equals(r3));	
		}
	 
		 

	 
	 
}
