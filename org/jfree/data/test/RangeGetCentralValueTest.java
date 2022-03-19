package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeGetCentralValueTest {
	
	private Range range;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Running setUp() for GetCentralValue");
		
	}

	@Test
	public void testGetValueNormalRange() {
		System.out.println("Running testCase1() for testGetValueNormalRange");
		range= new Range(1,7);	
		assertEquals(4 , range.getCentralValue(),0.0000000001);
	}

	
	@After
	public void tearDown() throws Exception {
		System.out.println("Running tearDown() for GetCentralValue");
		range = null;
        assertNull(range);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
}