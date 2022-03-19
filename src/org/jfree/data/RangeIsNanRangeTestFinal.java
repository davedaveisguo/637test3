package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeIsNanRangeTestFinal {

	private Double lowerbounnd;
	private Double upperbound;
    
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	System.out.println("Running setUp()");
    }
    
    @Test
    public void testCase1() {
    	System.out.println("Running testCase1() ");
    	lowerbounnd = Double.MIN_VALUE;
    	upperbound = 1.5;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    @Test
    public void testCase2() {
    	System.out.println("Running testCase2() ");
    	lowerbounnd = 1.5;
    	upperbound = 1.5;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    @Test
    public void testCase3() {
    	System.out.println("Running testCase3() ");
    	lowerbounnd = -1.5;
    	upperbound = -1.5;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    @Test
    public void testCase4() {
    	System.out.println("Running testCase4() ");
    	lowerbounnd = 1.5;
    	upperbound = Double.MAX_VALUE;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    @Test
    public void testCase5() {
    	System.out.println("Running testCase5() ");
    	lowerbounnd = 1.5;
    	upperbound = Double.MIN_VALUE;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    
    @Test
    public void testCase6() {
    	System.out.println("Running testCase6() ");
    	lowerbounnd = 1.5;
    	upperbound = null;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }




    @Test
    public void testCase7() {
    	System.out.println("Running testCase7() ");
    	lowerbounnd = Double.NaN;
    	upperbound = Double.NaN;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(true, r.isNaNRange());
    }
    

    
    
    @After
    public void tearDown() throws Exception {
		System.out.println("Running tearDown() ");
        lowerbounnd = null;
        assertNull(lowerbounnd);
        upperbound = null;
        assertNull(upperbound);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
