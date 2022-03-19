package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.*;

public class DataUtilitiesCloneTest extends DataUtilities {

	@Test
	public void arrayWithPositiveValuesCloneTest() {
		
		double[][] arr = { {1.0, 2.0}, {3.0, 4.0} };
		
		double[][] result = DataUtilities.clone(arr);

		Number[][] expected = {{1.0, 2.0}, {3.0, 4.0}};
		
		assertArrayEquals(expected, result);
		
	}

	@Test
	public void emptyArrayCloneTest() {
		
		double[][] arr = {};
		
		double[][] result = DataUtilities.clone(arr);

		Number[][] expected = {};
		
		assertArrayEquals(expected, result);
		
	}

}
