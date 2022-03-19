package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeHashCodeTest {

	private Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() ");		
	}

	@Test
	public void testHashCode() {
	    System.out.println("Running hashCode ");
		
		range= new Range(1,10);
		int result;
		result = 29 * (int) (Double.doubleToLongBits(1) ^ (Double.doubleToLongBits(1) >>> 32)) + (int) (Double.doubleToLongBits(10) ^ (Double.doubleToLongBits(10) >>> 32));
        
		assertEquals(result, range.hashCode(),0);
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
