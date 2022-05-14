package org.jfree.data.general;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WaferMapDatasetTest {

	@Test
	void testGetUniqueValueCount() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);
		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		assertEquals(2, d.getUniqueValueCount());
	}

	@Test
	void testGetMaxChipX() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);

		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		d.setMaxChipX(20);
		assertEquals(20, d.getMaxChipX());
	}

	@Test
	void testGetMaxChipY() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);

		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		d.setMaxChipY(20);
		assertEquals(20, d.getMaxChipY());
	}

	@Test
	void testGetChipSpace() {
		WaferMapDataset d = new WaferMapDataset(10, 10, 1);

		d.addValue(1, 5, 5);
		d.addValue(3, 2, 5);
		d.setChipSpace(2.0);
		assertEquals(2.0, d.getChipSpace());
	}

}
