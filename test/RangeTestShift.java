package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestShift {

	private Range base;
	private Double delta;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() ");
		
	}
	
	@Test
	public void testCaseLB() {
		System.out.println("Running testCaseLB() ");
		
		base= new Range(Double.MIN_VALUE , Double.MIN_VALUE);
		delta= 1.5;
		
		assertEquals(new Range(Double.MIN_VALUE + 1.5,Double.MIN_VALUE), Range.shift(base, delta) );
	}
	

	@Test
	public void testPositiveValues() {
		System.out.println("Running testPositiveValues() ");
		
		base= new Range(1,20);
		delta= 1.5;
		
		assertEquals(new Range(2.5,20.0), Range.shift(base, delta) );
	}
	

	@Test
	public void testNegativeValues() {
		System.out.println("Running testNegativeValues() ");
		
		base= new Range(1,20);
		delta= -1.5;
		
		assertEquals(new Range(-0.5,20.0), Range.shift(base, delta) );
	}
	
	@Test
	public void testCaseUB() {
		System.out.println("Running testCaseUB() ");
		
		base=new Range(Double.MAX_VALUE , Double.MAX_VALUE);
		delta= 1.5;
		
		assertEquals(new Range(Double.MAX_VALUE + 1.5,Double.MAX_VALUE), Range.shift(base, delta) );
	}
	
	
	@Test
	public void testNullValueCase() {
		System.out.println("Running testNullValueCase() ");	
		base= new Range(1,20);
		delta= null;
		
		assertEquals(new Range(1,20), Range.shift(base, delta) );
	}
	

	
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running tearDown() ");
		base = null;
        assertNull(base);
        delta = null;
        assertNull(delta);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
