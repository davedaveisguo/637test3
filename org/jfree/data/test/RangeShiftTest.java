package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeShiftTest {
	
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
	public void testPositiveRangeAndPosDelta() {
		System.out.println("Running testPositiveRangeAndPosDelta() ");
		
		base= new Range(2,5);
		delta= 3.0;
		
		assertEquals(new Range(5.0,6.5), Range.shift(base, delta) );
	}
	

	@Test
	public void testPositiveRangeAndNegDelta() {
		System.out.println("Running testPositiveRangeAndNegDelta() ");
		
		base= new Range(1.2,5);
		delta= -1.2;
		
		assertEquals(new Range(0.0,3.8), Range.shift(base, delta) );
	}
	
	@Test (expected = NullPointerException.class )
	public void testPositiveRangeAndNullDelta() {
		System.out.println("Running testPositiveRangeAndNullDelta() ");
		
		base= new Range(1,5);
		delta= null;
		
		 Range.shift(base, delta);
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