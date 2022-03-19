package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeScaleTest {

	private Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() ");		
	}

	@Test
	public void testScaleGreaterThan0() {
	    System.out.println("Running test scale > 0 ");
		
		range= new Range(1,4);

		assertEquals(new Range(2,8), Range.scale(range, 2) );
	}
	@Test
	public void testScaleSmallerThan0() {
	    System.out.println("Running test scale < 0 ");
		
		range= new Range(1,4);

		assertEquals(new Range(2,8), Range.scale(range, -2) );
	}
	
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running tearDown() ");
		range = null;
        assertNull(range);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
