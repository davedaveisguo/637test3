package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.*;

public class DataUtilitiesCreateNumberArrayTest extends DataUtilities {
	@Test //test to create an empty array
	public void emptyArrayTest() {


		double[] arr = {}; 

		Number[] result = DataUtilities.createNumberArray(arr);
		
		Number[] expected= {};

		assertArrayEquals(expected,result);

	}
	
	@Test //test to create an array with 3 elements
	public void doubleTypeElementArrayTest() {
		
		
		double[] arr = {1.0, 2.0, 3.0}; 
		
		Number[] result = DataUtilities.createNumberArray(arr);
		
		Number[] expected= {1.0, 2.0, 3.0};

		assertArrayEquals(expected,result);

	}
	

	@Test //test to create an array contains non-double type elements 
	public void noDoubleTypeElementArrayTest() {

		System.out.println("running testcase3()");

		double[] arr = {1, 2, 3}; 

		Number[] result = DataUtilities.createNumberArray(arr);
		
		Number[] expected= {1, 2, 3};

		assertArrayEquals(expected,result);

	}
	
}