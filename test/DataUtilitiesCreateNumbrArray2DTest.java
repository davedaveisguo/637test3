package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;
import org.junit.*;



public class DataUtilitiesCreateNumbrArray2DTest extends DataUtilities {

   private double[][] arr1 = { { 1.0, 2.0 }, { 3.0, 4.0 } };
   private Number[][] expectedArray = { { 1.0, 2.0 }, { 3.0, 4.0 } };
  
   private double[][] arr3 = {{}};    
   private Number[][] expectedNullArray = {{}};
   
   private double[][] arr6 =  { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.NEGATIVE_INFINITY } };
   private Number[][] expectedNegativeInfinityArray = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.NEGATIVE_INFINITY } };
   
   private double[][] arr9 =  { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.POSITIVE_INFINITY } };
   private Number[][] expectedPositiveInfinityArray = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.POSITIVE_INFINITY } };
 
   



    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	
    @Before
    public void setUp() throws Exception { 
      	
    }
    
       
    @Test
    public void numberArrayCreat2DCheck() {
    	Number[][] arr2 = DataUtilities.createNumberArray2D(arr1);
      	assertArrayEquals("Array created matching expected array", expectedArray, arr2); 
    	//2D array of double values created and compared to Number array
           
    }
    
    @Test
    public void nullArrayCreat2DCheck() {
    	Number[][] arr4 = DataUtilities.createNumberArray2D(arr3);
    	assertArrayEquals("Arrays should match", expectedNullArray, arr4); 
    	//2D array using Null created and compared to Number array
           
    }
    
    @Test
    public void negativeInfinityArrayCreat2DCheck() {
    	Number[][] arr7 = DataUtilities.createNumberArray2D(arr6);
    	assertArrayEquals("Arrays should match", expectedNegativeInfinityArray, arr7); 
    	//2D array using Negative Infinity created and compared to Number Array
           
    }
    
    
    
    @Test
    public void posotiveInfinityArrayCreat2DCheck() {
    	Number[][] arr8 = DataUtilities.createNumberArray2D(arr9);
    	assertArrayEquals("Arrays should match", expectedPositiveInfinityArray, arr8); 
    	//2D array using Positive Infinity created and compared to Number array
           
    }

    

    @After
    public void tearDown() throws Exception { // set all created arrays to null to free the memory
    	Arrays.fill(arr1, null);
    	Arrays.fill(arr3, null);
    	Arrays.fill(arr6, null);
    	Arrays.fill(arr9, null);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


}
