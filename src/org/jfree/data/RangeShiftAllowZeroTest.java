package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeShiftAllowZeroTest {
	
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
	public void testPositiveRangeAndNegDelta() {
		System.out.println("Running testPositiveRangeAndNegDelta() ");
		
		base= new Range(1,5);
		delta= -1.5;
		
		assertEquals(-0.5, Range.shift(base, delta, true).getLowerBound() ,0.000001);
		assertEquals( 3.5, Range.shift(base, delta, true).getUpperBound() ,0.000001);
	}
	
	
	@Test
	public void testNegativeRangeAndPosDelta() {
		System.out.println("Running testNegativeRangeAndPosDelta() ");
		
		base= new Range(-1,5);
		delta= 1.2;
		
		assertEquals(0.2, Range.shift(base, delta, false).getLowerBound() ,0.000001);
		assertEquals(6.2, Range.shift(base, delta, false).getUpperBound() ,0.000001);
	}
	
	@Test
	public void testZeroRangeAndPosDelta() {
		System.out.println("Running testZeroRangeAndPosDelta() ");
		
		base= new Range(0,5);
		delta= 1.2;
		
		assertEquals(1.2, Range.shift(base, delta, false).getLowerBound() ,0.000001);
		assertEquals(6.2, Range.shift(base, delta, false).getUpperBound() ,0.000001);
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