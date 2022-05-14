package org.jfree.chart.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link DirectionalGradientPaintTransformer } class.
 */

public class DirectionalGradientPaintTransformerTest {
	
	/**
	 * Test the transformed paint
	 */
	@Test
	public void testTransformPaint() {
		GradientPaint t1 = new GradientPaint(0, 20, Color.BLUE, 20, 0, Color.BLUE, false);
		 
		DirectionalGradientPaintTransformer dgtp = new DirectionalGradientPaintTransformer();
		GradientPaint p = new GradientPaint(10, 10, Color.BLUE, 10, 10, Color.BLUE, false);
		GradientPaint gp1 = dgtp.transform(p, new Rectangle(0, 0, 20, 20));

        assertEquals(t1.getPoint1(), gp1.getPoint1());
        assertEquals(t1.getPoint2(), gp1.getPoint2());
        assertEquals(t1.getColor1(), gp1.getColor1());
        assertEquals(t1.getColor2(), gp1.getColor2());
	}
	
	/**
	 * Test the transformed paint: start point is upper left corner and
	 * end point is lower right corner
	 */
	@Test
	public void testTransformEndPointLowerRightCorner() {
		GradientPaint t1 = new GradientPaint(0, 0, Color.BLUE, 20, 20, Color.BLUE, false);
		 
		DirectionalGradientPaintTransformer dgtp = new DirectionalGradientPaintTransformer();
		GradientPaint p = new GradientPaint(0, 0, Color.BLUE, 10, 10, Color.BLUE, false);
		GradientPaint gp1 = dgtp.transform(p, new Rectangle(0, 0, 20, 20));

        assertEquals(t1.getPoint1(), gp1.getPoint1());
        assertEquals(t1.getPoint2(), gp1.getPoint2());
        assertEquals(t1.getColor1(), gp1.getColor1());
        assertEquals(t1.getColor2(), gp1.getColor2());
	}
	
	/**
	 * Test the transformed paint: start point is upper left corner and
	 * end point is either lower left corner or end point is upper right corner
	 */
	@Test
	public void testTransformEndPointLowerLeftCorner() {
		GradientPaint t1 = new GradientPaint(0, 0, Color.BLUE, 0, 20, Color.BLUE, false);
		GradientPaint t2 = new GradientPaint(0, 0, Color.BLUE, 20, 0, Color.BLUE, false);

		DirectionalGradientPaintTransformer dgtp = new DirectionalGradientPaintTransformer();
		GradientPaint p1 = new GradientPaint(0, 0, Color.BLUE, 0, 10, Color.BLUE, false);
		GradientPaint gp1 = dgtp.transform(p1, new Rectangle(0, 0, 20, 20));

        assertEquals(t1.getPoint1(), gp1.getPoint1());
        assertEquals(t1.getPoint2(), gp1.getPoint2());
        assertEquals(t1.getColor1(), gp1.getColor1());
        assertEquals(t1.getColor2(), gp1.getColor2());
        		 
		GradientPaint p2 = new GradientPaint(0, 0, Color.BLUE, 10, 0, Color.BLUE, false);
		GradientPaint gp2 = dgtp.transform(p2, new Rectangle(0, 0, 20, 20));

        assertEquals(t2.getPoint1(), gp2.getPoint1());
        assertEquals(t2.getPoint2(), gp2.getPoint2());
        assertEquals(t2.getColor1(), gp2.getColor1());
        assertEquals(t2.getColor2(), gp2.getColor2());
	}
	
}
