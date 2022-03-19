package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeToStringTest {
	
	private Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() for RangeToString");
		
	}

	@Test
	public void testToString() {
		System.out.println("Running testToString() for RangeToString");
		range= new Range(1,7);	
		assertEquals("Range[1.0,7.0]" , range.toString());
	}

	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running tearDown() for RangeToString");
		range = null;
        assertNull(range);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
}