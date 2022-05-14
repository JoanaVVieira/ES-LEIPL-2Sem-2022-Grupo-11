package org.jfree.chart.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link StringUtils} class.
 */

public class StringUtilsTest {

	/**
	 * The string starts with the given starting text.
	 */
	 @Test
	public void testStartsWithIgnoreCase() {
		boolean t1 = StringUtils.startsWithIgnoreCase("AaAA", "AA");
		boolean t2 = StringUtils.startsWithIgnoreCase("BBAA", "A");
		boolean t3 = StringUtils.startsWithIgnoreCase("CC", "CCC");
		boolean t4 = StringUtils.startsWithIgnoreCase("BBCC", "CC");
		assertEquals(true,t1);
		assertEquals(false,t2);
		assertEquals(false,t3);
		assertNotEquals(true,t4);
	}
	 
	/**
	 * The string ends with the given ending text.
	 */
	 @Test
	public void testEndsWithIgnoreCase() {
		boolean t1 = StringUtils.endsWithIgnoreCase("AAAA", "a");
		boolean t2 = StringUtils.endsWithIgnoreCase("BbAb", "A");
		boolean t3 = StringUtils.endsWithIgnoreCase("CC", "CCC");
		boolean t4 = StringUtils.endsWithIgnoreCase("BBCc", "bb");
		assertEquals(true,t1);
		assertEquals(false,t2);
		assertEquals(false,t3);
		assertNotEquals(true,t4);
	}
}

