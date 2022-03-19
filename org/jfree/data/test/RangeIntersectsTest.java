package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeIntersectsTest {
    private Range range1;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    	System.out.println("setUpBeforeClass() @BeforeClass");
    }
    @Before
    public void setUp() throws Exception { 
    	System.out.println("SetUp() @before");
    }
	@Test
	public void NaNIntersects() {
		System.out.println("Test Range NaN ");
		Range range = new Range(Double.NaN, Double.NaN);
		assertEquals("Should be false",false, range.intersects(Double.NaN, Double.NaN));
	}
	
    @Test
    public void NegaInfinAndMinIntersects() {
    	System.out.println("Test range Double.NEGATIVE_INFINITY, Double.MIN_VALUE intersection");
    	range1 = new Range(Double.NEGATIVE_INFINITY, Double.MIN_VALUE);
        assertEquals("Should be true",true, range1.intersects(Double.NEGATIVE_INFINITY, Double.MIN_VALUE));
    }
    
    @Test
    public void MaxAndPostivInfinIntersects() {
    	System.out.println("Test Double.MAX_VALUE, Double.POSITIVE_INFINITY intersection");
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY);
        assertEquals("Should be true",true, range1.intersects(Double.MAX_VALUE, Double.POSITIVE_INFINITY));
    }
    @Test
    public void TestRange36AndIntersec410() {
    	System.out.println("Test Range 3,6 Intersec 4,10 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be true",true, range1.intersects(4,10));
    }
    @Test
    public void TestRange36AndIntersec210() {
    	System.out.println("Test Range 3,6 Intersec 2,10 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be true",true, range1.intersects(1,10));
    }
    @Test
    public void TestRange36AndIntersecRange210() {
    	System.out.println("Test Range 3,6 Intersec New Range 2,10 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be true",true, range1.intersects(new Range(3,6)));
    }
    /*
    @Test
    public void TestRange36AndIntersec12() {
    	System.out.println("Test Range 3,6 Intersec 1,2 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be false",false, range1.intersects(1,2));
    }
    */

   
    @After
    public void tearDown() throws Exception {
    	System.out.println("tearDown() @After - clean objs");
		range1 = null;
        assertNull(range1);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("tearDownAfterClass() @After");
    }
}