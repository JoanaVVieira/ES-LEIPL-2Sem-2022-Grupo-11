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
 * --------
 * CSV.java
 * --------
 * (C) Copyright 2003-2022, by David Gilbert.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 24-Nov-2003 : Version 1 (DG);
 *
 */

package org.jfree.data.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * A utility class for reading {@link CategoryDataset} data from a CSV file.
 * This initial version is very basic, and won't handle errors in the data
 * file very gracefully.
 */
public class CSV {

    private CSVProduct cSVProduct = new CSVProduct();

	/** The text delimiter. */
    private char textDelimiter;

    /**
     * Creates a new CSV reader where the field delimiter is a comma, and the
     * text delimiter is a double-quote.
     */
    public CSV() {
        this(',', '"');
    }

    /**
     * Creates a new reader with the specified field and text delimiters.
     *
     * @param fieldDelimiter  the field delimiter (usually a comma, semi-colon,
     *                        colon, tab or space).
     * @param textDelimiter  the text delimiter (usually a single or double
     *                       quote).
     */
    public CSV(char fieldDelimiter, char textDelimiter) {
        cSVProduct.setFieldDelimiter(fieldDelimiter);
        this.textDelimiter = textDelimiter;
    }

    /**
     * Reads a {@link CategoryDataset} from a CSV file or input source.
     *
     * @param in  the input source.
     *
     * @return A category dataset.
     *
     * @throws IOException if there is an I/O problem.
     */
    public CategoryDataset readCategoryDataset(Reader in) throws IOException {

        return cSVProduct.readCategoryDataset(in, this);

    }

    /**
     * Removes the string delimiters from a key (as well as any white space
     * outside the delimiters).
     *
     * @param key  the key (including delimiters).
     *
     * @return The key without delimiters.
     */
    public String removeStringDelimiters(String key) {
        String k = key.trim();
        if (k.charAt(0) == this.textDelimiter) {
            k = k.substring(1);
        }
        if (k.charAt(k.length() - 1) == this.textDelimiter) {
            k = k.substring(0, k.length() - 1);
        }
        return k;
    }

}
