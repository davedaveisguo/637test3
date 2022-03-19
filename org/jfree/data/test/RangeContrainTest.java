package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeContrainTest {

	private Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() ");		
	}

	@Test
	public void testConstrain15() {
	    System.out.println("Running constrain 1,10 & 15 ");
		
		range= new Range(1,10);

		assertEquals(10, range.constrain(15),0);
	}
	@Test
	public void testConstrain6() {
	    System.out.println("Running constrain 1,10 & -6 ");
		
		range= new Range(1,10);

		assertEquals(1, range.constrain(-6),0);
	}
	
	@Test
	public void testConstrain5() {
	    System.out.println("Running constrain 1,10 & 5 ");
		
		range= new Range(1,10);

		assertEquals(5, range.constrain(5),0);
	}
	@Test
	public void testConstrain1() {
	    System.out.println("Running constrain 1,10 & 1 ");
		
		range= new Range(1,10);

		assertEquals(1, range.constrain(1),0);
	}
	@Test
	public void testConstrain10() {
	    System.out.println("Running constrain 1,10 & 10 ");
		
		range= new Range(1,10);

		assertEquals(10, range.constrain(10),0);
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
