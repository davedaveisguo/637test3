package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandToIncludeTest {

	private Range range;
	private Double value;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() ");		
	}

	@Test
	public void testExpandToUpper() {
	    System.out.println("Running testExpandToUpper() ");
		
		range= new Range(1,4);
		value = 6.0;
		
		assertEquals(new Range(1,6), Range.expandToInclude(range, value) );
	}

	@Test
	public void testExpandToLower() {
		System.out.println("Running testExpandToLower() ");
		
		range= new Range(1,4);
		value = 0.5;
		
		assertEquals(new Range(0.5,4),  Range.expandToInclude(range, value));
	}
	
	@Test
	public void testExpandToMAX() {
		System.out.println("Running testExpandToMAX() ");
		
		range= new Range(Double.MAX_VALUE,Double.MAX_VALUE);
		value = Double.MAX_VALUE;
		
		assertEquals(new Range(Double.MAX_VALUE,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	@Test
	public void testExpandToMIN() {
		System.out.println("Running testExpandToMIN() ");
		
		range= new Range(Double.MIN_VALUE,Double.MAX_VALUE);
		value = Double.MIN_VALUE;
		
		assertEquals(new Range(Double.MIN_VALUE,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	@Test
	public void testExpandNormalToMAX() {
		System.out.println("Running testExpandNormalToMAX() ");
		
		range= new Range(Double.MAX_VALUE,Double.MAX_VALUE);
		value = 0.5;
		
		assertEquals(new Range(0.5,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	@Test
	public void testExpandNegativeNormalToMAX() {
		System.out.println("Running testExpandNegativeNormalToMAX() ");
		
		range= new Range(Double.MIN_VALUE,Double.MAX_VALUE);
		value = -0.5;
		
		assertEquals(new Range(-0.5,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	
	@Test
	public void testExpandeNormalToNULL() {
		System.out.println("Running testExpandeNormalToNULL() ");
		range= null;
		value = -0.5;
		
		assertEquals(new Range(-0.5,-0.5), Range.expandToInclude(range, value));
	}
	
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running tearDown() ");
		range = null;
        assertNull(range);
        value = null;
        assertNull(value);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

}
