/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2022, by David Gilbert and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------------
 * DatasetUtilsTest.java
 * ---------------------
 * (C) Copyright 2003-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.json.impl;

import java.io.BufferedWriter;

import java.io.FileReader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.io.CSV;
import org.jfree.data.io.CSVProduct;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.jfree.data.json.impl.*;

/**
 * Tests for the {@link JSONValue} class.
 */
public class JSONValueTest {


    /**
     * Some tests to verify that Java does what I think it does!
     */
    @Test
    public void testJava() {
        assertTrue(Double.isNaN(Math.min(1.0, Double.NaN)));
        assertTrue(Double.isNaN(Math.max(1.0, Double.NaN)));
    }

    /**
     * Some tests for the toJSONString() method.
     * @throws IOException 
     */
    @Test
    public void testtoJSONString() throws IOException {
    	Double doub = 1.0;
    	Double doub_1 = Double.NaN;
    	
    	float ft = 1;
    	float ft_1 = Float.NaN;
    	
    	Number num = 1;
    	Number num_1 = null;
    	
    	boolean bol = true;
    	boolean bol_1 = false;
    	
    	String st = "test";
    	
    	assertEquals(JSONValue.toJSONString(st), "\"test\"");
    	assertEquals(JSONValue.toJSONString(null), "null");
    	assertEquals(JSONValue.toJSONString(doub_1), "null");
    	assertEquals(JSONValue.toJSONString(doub), doub.toString());
    	
    	assertEquals(JSONValue.toJSONString(ft), String.valueOf(ft));
    	assertEquals(JSONValue.toJSONString(ft_1), "null");
    	assertEquals(JSONValue.toJSONString(num), String.valueOf(num));
    	assertEquals(JSONValue.toJSONString(num_1), String.valueOf(num_1));
    	assertEquals(JSONValue.toJSONString(bol), String.valueOf(bol));
    	assertEquals(JSONValue.toJSONString(bol_1), String.valueOf(bol_1));

    
    }
    
    /**
     * Some tests for the escape() method.
     */
    @Test
    public void testEscape() {
    	String s= null;
    	assertEquals(JSONValue.escape(s), null);
    }
    
}
