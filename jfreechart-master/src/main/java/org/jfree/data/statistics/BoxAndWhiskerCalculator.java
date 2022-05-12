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
 * ----------------------------
 * BoxAndWhiskerCalculator.java
 * ----------------------------
 * (C) Copyright 2003-2022, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.statistics;

import org.jfree.chart.internal.Args;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A utility class that calculates the mean, median, quartiles Q1 and Q3, plus
 * a list of outlier values...all from an arbitrary list of
 * {@code Number} objects.
 */
public abstract class BoxAndWhiskerCalculator {

    /**
     * Calculates the statistics required for a {@link BoxAndWhiskerItem}
     * from a list of {@code Number} objects.  Any items in the list
     * that are {@code null}, not an instance of {@code Number}, or
     * equivalent to {@code Double.NaN}, will be ignored.
     *
     * @param values  a list of numbers (a {@code null} list is not
     *                permitted).
     *
     * @return A box-and-whisker item.
     */
    public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(
            List<? extends Number> values) {
        return calculateBoxAndWhiskerStatistics(values, true);
    }

    /**
     * Calculates the statistics required for a {@link BoxAndWhiskerItem}
     * from a list of {@code Number} objects.  Any items in the list
     * that are {@code null}, not an instance of {@code Number}, or
     * equivalent to {@code Double.NaN}, will be ignored.
     *
     * @param values  a list of numbers (a {@code null} list is not
     *                permitted).
     * @param stripNullAndNaNItems  a flag that controls the handling of null
     *     and NaN items.
     *
     * @return A box-and-whisker item.
     *
     * @since 1.0.3
     */
    public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(
            List<? extends Number> values, boolean stripNullAndNaNItems) {

        Args.nullNotPermitted(values, "values");

        double maxOutlier = maxOutlier(values, stripNullAndNaNItems);
		List vlist = samplingData(values, stripNullAndNaNItems);
		if (stripNullAndNaNItems) {
            for (Object obj : values) {
                if (obj instanceof Number) {
                    Number n = (Number) obj;
                    double v = n.doubleValue();
                    if (!Double.isNaN(v)) {
                        vlist.add(n);
                    }
                }
            }
        }
        else {
        }
        Collections.sort(vlist);

        double mean = Statistics.calculateMean(vlist, false);
        double median = Statistics.calculateMedian(vlist, false);
        double q1 = calculateQ1(vlist);
        double q3 = calculateQ3(vlist);

        double interQuartileRange = q3 - q1;

        double upperOutlierThreshold = q3 + (interQuartileRange * 1.5);
        double lowerOutlierThreshold = q1 - (interQuartileRange * 1.5);

        double lowerFaroutThreshold = q1 - (interQuartileRange * 2.0);

        double minRegularValue = Double.POSITIVE_INFINITY;
        double maxRegularValue = Double.NEGATIVE_INFINITY;
        double minOutlier = Double.POSITIVE_INFINITY;
        List<Number> outliers = new ArrayList<>();

        for (Object o : vlist) {
            maxRegularValue = maxRegularValue(upperOutlierThreshold, lowerOutlierThreshold, maxRegularValue, o);
			minRegularValue = minRegularValue(upperOutlierThreshold, lowerOutlierThreshold, minRegularValue, o);
			Number number = (Number) o;
            double value = number.doubleValue();
            if (value > upperOutlierThreshold) {
                outliers.add(number);
            }
            else if (value < lowerOutlierThreshold) {
                outliers.add(number);
                if (value < minOutlier && value >= lowerFaroutThreshold) {
                    minOutlier = value;
                }
            }
            else {
            }
            minOutlier = Math.min(minOutlier, minRegularValue);
        }

        return new BoxAndWhiskerItem(mean, median, q1, q3, minRegularValue,
                maxRegularValue, minOutlier, maxOutlier, outliers);

    }

    /**
     * Inside a sample, returns the minimum regular value
     *
     * @param upperOutlierThreshold  maximum of a non regular value
     * @param lowerOutlierThreshold minimum of a non regular value
     * @param lowerOutlierThreshold max regular value before testing it
     * @param o NaN to check it's value
     *
     * @return return the minimum regular value from a sample
     */
	private static double minRegularValue(double upperOutlierThreshold, double lowerOutlierThreshold,
			double minRegularValue, Object o) {
		Number number = (Number) o;
		double value = number.doubleValue();
		if (value > upperOutlierThreshold) {
		} else if (value < lowerOutlierThreshold) {
		} else {
			minRegularValue = Math.min(minRegularValue, value);
		}
		return minRegularValue;
	}

    /**
     * From a sample, calculates it's maximum outlier
     * 
     * @param values  a list of numbers (a {@code null} list is not
     *                permitted) from a sample
     * @param stripNullAndNaNItems  a flag that controls the handling of null
     *     and NaN items.
     *
     * @return the max outlier from the sample given
     */
	private static double maxOutlier(List<? extends Number> values, boolean stripNullAndNaNItems) {
		List vlist = samplingData(values, stripNullAndNaNItems);
		double q1 = calculateQ1(vlist);
		double q3 = calculateQ3(vlist);
		double interQuartileRange = q3 - q1;
		double upperOutlierThreshold = q3 + (interQuartileRange * 1.5);
		double lowerOutlierThreshold = q1 - (interQuartileRange * 1.5);
		double upperFaroutThreshold = q3 + (interQuartileRange * 2.0);
		double maxRegularValue = Double.NEGATIVE_INFINITY;
		double maxOutlier = Double.NEGATIVE_INFINITY;
		for (Object o : vlist) {
			maxRegularValue = maxRegularValue(upperOutlierThreshold, lowerOutlierThreshold, maxRegularValue, o);
			Number number = (Number) o;
			double value = number.doubleValue();
			if (value > upperOutlierThreshold) {
				if (value > maxOutlier && value <= upperFaroutThreshold) {
					maxOutlier = value;
				}
			}
			maxOutlier = Math.max(maxOutlier, maxRegularValue);
		}
		return maxOutlier;
	}

    /**
     * Inside a sample, returns the maximum regular value
     *
     * @param upperOutlierThreshold  maximum of a non regular value
     * @param lowerOutlierThreshold minimum of a non regular value
     * @param lowerOutlierThreshold max regular value before testing it
     * @param o NaN to check it's value
     *
     * @return return the max regular value from a sample
     */
	private static double maxRegularValue(double upperOutlierThreshold, double lowerOutlierThreshold,
			double maxRegularValue, Object o) {
		Number number = (Number) o;
		double value = number.doubleValue();
		if (value > upperOutlierThreshold) {
		} else if (value < lowerOutlierThreshold) {
		} else {
			maxRegularValue = Math.max(maxRegularValue, value);
		}
		return maxRegularValue;
	}

    /**
     * Helper to get the sample that we want to work in
     *
     * @param values  parameter that allows us to validate the List
     * @param stripNullAndNaNItems parameter that tells us if we want to evaluate stripping
     *
     * @return return the sample list to work on
     */
	private static List samplingData(List<? extends Number> values, boolean stripNullAndNaNItems) {
		List vlist;
		if (stripNullAndNaNItems) {
			vlist = new ArrayList(values.size());
		} else {
			vlist = values;
		}
		return vlist;
	}

    /**
     * Calculates the first quartile for a list of numbers in ascending order.
     * If the items in the list are not in ascending order, the result is
     * unspecified.  If the list contains items that are {@code null}, not
     * an instance of {@code Number}, or equivalent to
     * {@code Double.NaN}, the result is unspecified.
     *
     * @param values  the numbers in ascending order ({@code null} not
     *     permitted).
     *
     * @return The first quartile.
     */
    public static double calculateQ1(List values) {
        Args.nullNotPermitted(values, "values");

        double result = Double.NaN;
        int count = values.size();
        if (count > 0) {
            if (count % 2 == 1) {
                if (count > 1) {
                    result = Statistics.calculateMedian(values, 0, count / 2);
                }
                else {
                    result = Statistics.calculateMedian(values, 0, 0);
                }
            }
            else {
                result = Statistics.calculateMedian(values, 0, count / 2 - 1);
            }

        }
        return result;
    }

    /**
     * Calculates the third quartile for a list of numbers in ascending order.
     * If the items in the list are not in ascending order, the result is
     * unspecified.  If the list contains items that are {@code null}, not
     * an instance of {@code Number}, or equivalent to
     * {@code Double.NaN}, the result is unspecified.
     *
     * @param values  the list of values ({@code null} not permitted).
     *
     * @return The third quartile.
     */
    public static double calculateQ3(List values) {
        Args.nullNotPermitted(values, "values");
        double result = Double.NaN;
        int count = values.size();
        if (count > 0) {
            if (count % 2 == 1) {
                if (count > 1) {
                    result = Statistics.calculateMedian(values, count / 2,
                            count - 1);
                }
                else {
                    result = Statistics.calculateMedian(values, 0, 0);
                }
            }
            else {
                result = Statistics.calculateMedian(values, count / 2,
                        count - 1);
            }
        }
        return result;
    }

}