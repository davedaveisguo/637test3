package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandTest {

	private Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() ");		
	}

	@Test
	public void testExpand14() {
	    System.out.println("Running test Expand 1 4 ");
		
		range= new Range(1,4);

		assertEquals(new Range(-5,13), Range.expand(range, 2,3) );
	}
	@Test
	public void testExpand62() {
	    System.out.println("Running test Expand -6 2 ");
		
		range= new Range(1,4);

		assertEquals(new Range(-5,13), Range.expand(range, -6,2) );
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
