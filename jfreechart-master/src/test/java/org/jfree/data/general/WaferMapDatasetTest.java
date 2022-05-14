package org.jfree.data.general;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WaferMapDatasetTest {

    /**
     * Some tests for the GetUniqueValueCount() method.
     */
	@Test
	void testGetUniqueValueCount() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);
		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		assertEquals(2, d.getUniqueValueCount());
	}

    /**
     * Some tests for the GetMaxChipX() method.
     */
	@Test
	void testGetMaxChipX() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);

		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		d.setMaxChipX(20);
		assertEquals(20, d.getMaxChipX());
	}

    /**
     * Some tests for the GetMaxChipY() method.
     */
	@Test
	void testGetMaxChipY() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);

		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		d.setMaxChipY(20);
		assertEquals(20, d.getMaxChipY());
	}

    /**
     * Some tests for the GetChipSpace() method.
     */
	@Test
	void testGetChipSpace() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);

		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		d.setChipSpace(2.0);
		assertEquals(2.0, d.getChipSpace());
	}

}
