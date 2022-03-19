package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.*;



public class DataUtilitiesEqualTest extends DataUtilities {

   private double[][] arr1 = { { 1.0, 2.0 }, { 3.0, 4.0 } };
   private double[][] arr2 = { { 1.0, 2.0 }, { 3.0, 4.0 } };
   private double[][] arr3 = {{}};    
   private double[][] arr4 = {{}};    
   private double[][] arr5 = { { 1.1, 2.0 }, { 3.0, 4.0 } };
   private double[][] arr6 = new double [2][2];
   private double[][] arr7 = new double [2][2];
   private double[][] nullArray = null;

    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	
    @Before
    public void setUp() throws Exception { 
      	
    }
    
       
    @Test
    public void arraysEquivalencyCheck() {
    	assertTrue("Arrays should be Equal", DataUtilities.equal(arr1, arr2)); 
    	//boolean to check if two arrays of equal value and length are considered equal by the equal method
           
    }
    
    
    @Test
    public void arraysNullCheck() {
    	assertTrue("Arrays should be Equal", DataUtilities.equal(arr3, arr4)); 
    	//boolean to check if two arrays of null values and equal length are considered equal by the equal method
            
    }
    
    @Test
    public void arraysEquivalencyNullCheck() {
    	assertFalse("Arrays should not be Equal", DataUtilities.equal(arr3, arr2)); 
    	//boolean to check if one array of null and another array are considered equal by the equal method
            
    }
    
    @Test
    public void arraysDifferentValuesCheck() {
    	assertFalse("Arrays should not be Equal", DataUtilities.equal(arr1, arr5)); 
    	//boolean to check if arrays of different values are considered not equal
            
    }
    
    @Test
    public void arraysNegativeValuesCheck() {
    	arr6[0][0] = Double.NEGATIVE_INFINITY;
    	arr7[0][0] = Double.NEGATIVE_INFINITY;
    	assertTrue("Arrays should be Equal", DataUtilities.equal(arr6, arr7)); 
    	//boolean to check for robustness using Negative infinity values
            
    }
    
    @Test
    public void arraysPositiveValuesCheck() {
    	arr6[0][0] = Double.POSITIVE_INFINITY;
    	arr7[0][0] = Double.POSITIVE_INFINITY;
    	assertTrue("Arrays should be Equal", DataUtilities.equal(arr6, arr7)); 
    	//boolean to check for robustness using Positive infinity values
            
    }
   
    @Test
    public void arraysVariedValuesCheck() {
    	arr6[0][0] = Double.POSITIVE_INFINITY;
    	arr7[0][0] = Double.NEGATIVE_INFINITY;
    	assertFalse("Arrays should not be Equal", DataUtilities.equal(arr6, arr7)); 
    	//boolean to check if one array of extreme positive and extreme negative infinity are considered not equal by the equal method
            
    }
        
    @Test
    public void arraysNullPositiveValuesCheck() {
    	arr6[0][0] = Double.POSITIVE_INFINITY;
    	assertFalse("Arrays should not be Equal", DataUtilities.equal(arr3, arr6)); 
    	//boolean to check if one array of null value and extreme values such as positive infinity are considered not equal by the equal method
            
    }
    
    @Test
    public void firstArrayNullCheck() {
    	assertTrue("Arrays should not be Equal", DataUtilities.equal(nullArray, arr1)); 
           
    }
    
    @Test
    public void secondArrayNullCheck() {
    	assertTrue("Arrays should not be Equal", DataUtilities.equal(arr1, nullArray)); 
           
    }

    @After
    public void tearDown() throws Exception { // set all arrays to null to free the memory
    	Arrays.fill(arr1, null);
    	Arrays.fill(arr2, null);
    	Arrays.fill(arr3, null);
    	Arrays.fill(arr4, null);
    	Arrays.fill(arr5, null);
    	Arrays.fill(arr6, null);
    	Arrays.fill(arr7, null);

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


}
