package org.jfree.data.statistics;


import java.io.Serializable;

public class HistogramDatasetProduct implements Serializable, Cloneable {
	/**
	* Adds a series to the dataset, using the specified number of bins, and sends a  {@link DatasetChangeEvent}  to all registered listeners.
	* @param key   the series key ( {@code  null}  not permitted).
	* @param values  the values ( {@code  null}  not permitted).
	* @param bins   the number of bins (must be at least 1).
	*/
	public void addSeries(Comparable key, double[] values, int bins, HistogramDataset histogramDataset) {
		double minimum = getMinimum(values);
		double maximum = getMaximum(values);
		histogramDataset.addSeries(key, values, bins, minimum, maximum);
	}

	/**
	* Returns the minimum value in an array of values.
	* @param values   the values ( {@code  null}  not permitted and zero-length array not permitted).
	* @return  The minimum value.
	*/
	public double getMinimum(double[] values) {
		if (values == null || values.length < 1) {
			throw new IllegalArgumentException("Null or zero length 'values' argument.");
		}
		double min = Double.MAX_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}

	/**
	* Returns the maximum value in an array of values.
	* @param values   the values ( {@code  null}  not permitted and zero-length array not permitted).
	* @return  The maximum value.
	*/
	public double getMaximum(double[] values) {
		if (values == null || values.length < 1) {
			throw new IllegalArgumentException("Null or zero length 'values' argument.");
		}
		double max = -Double.MAX_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}

	public Object clone() throws CloneNotSupportedException {
		return (HistogramDatasetProduct) super.clone();
	}
}