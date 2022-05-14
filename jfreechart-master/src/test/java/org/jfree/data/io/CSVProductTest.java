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

package org.jfree.data.io;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.jfree.data.category.CategoryDataset;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Tests for the {@link CSV} class.
 */
public class CSVProductTest {

    /**
     * Some tests to verify that Java does what I think it does!
     */
    @Test
    public void testJava() {
        assertTrue(Double.isNaN(Math.min(1.0, Double.NaN)));
        assertTrue(Double.isNaN(Math.max(1.0, Double.NaN)));
    }

    /**
     * Some tests for the readCategoryDataset() method.
     * @throws IOException 
     */
    @Test
    public void testReadCategoryDataset() throws IOException {
    	CSV test = new CSV();
    	Reader reader = new StringReader("Test");
    	CSVProduct csv_test = new CSVProduct();
    	
    	
    	assertTrue(csv_test.readCategoryDataset(reader, test) instanceof CategoryDataset);
    
    }
    /**
     * Some tests for the setFieldDelimiter() method.
     * @throws IOException 
     */
    @Test
    public void testSetFieldDelimiter() throws IOException {
    	CSVProduct csv_test = new CSVProduct();	
    	char compareDelimiter = '\"';
    	csv_test.setFieldDelimiter(compareDelimiter);
    	assertTrue(csv_test.getFieldDelimiter() == compareDelimiter);
    }
}
