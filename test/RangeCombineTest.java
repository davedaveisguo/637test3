package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeCombineTest {
    private Range range1;
    private Range range2;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    	System.out.println("setUpBeforeClass() @BeforeClass");
    }
    @Before
    public void setUp() throws Exception { 
    	System.out.println("SetUp() @before");
    }
    @Test
    public void CombineTwoNaNRange() {
    	System.out.println("Test case 1 : Combine two NaN Range objs");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = new Range(Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY);
        assertEquals("Result should be NaN",new Range(Double.NaN, Double.NaN), Range.combine(range1, range2));
    }
    @Test
    public void CombineNegInfinAndMinValue() {
    	System.out.println("Test case 2: NEGATIVE_INFINITY - MIN_VALUE");    	
    	range1 = new Range(Double.NEGATIVE_INFINITY, Double.MIN_VALUE);
    	range1 = new Range(Double.NEGATIVE_INFINITY,Double.MIN_VALUE);
        assertEquals(new Range(Double.NEGATIVE_INFINITY,Double.MIN_VALUE), Range.combine(range1, range2));
    }
    @Test
    public void CombineNullRange() {
    	System.out.println("Test case 3: Combine two null Range obj");
    	range1 = null;
    	range2 = null;
        assertEquals("Result should be null",null, Range.combine(range1, range2));
    }
    @Test
    public void CombinePosInfinAndMaxValue() {
    	System.out.println("Test case 4: Combine Two POSITIVE_INFINITY,MAX_VALUE range obj");
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY-1);
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY);
    	assertEquals(new Range(Double.MAX_VALUE,Double.POSITIVE_INFINITY), Range.combine(range1, range2));
    }
    @Test
    public void CombineTwoValidRange() {
    	System.out.println("Test case 5: Combine two valid range obj");
    	range1 = new Range(1,8);
    	range2 = new Range(2,6);
        assertEquals("Result should be range(1,8)",new Range(1,8), Range.combine(range1, range2));
    }
    @Test
    public void CombineR1NullR2Valid() {
    	System.out.println("Test case 5: Combine range 1 null, range 2 valid range obj");
    	range1 = null;
    	range2 = new Range(2,6);
        assertEquals("Result should be 2,6",range2, Range.combine(range1, range2));
    }
    @Test
    public void CombineNullAndNaN() {
    	System.out.println("Test case 5: Combine null and Nan range obj");
    	range1 = null;
    	range2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Result should be NaN",new Range(Double.NaN, Double.NaN), Range.combine(range1, range2));
    }
    @Test
    public void CombineNaNAndNull() {
    	System.out.println("Test case 6: Combine Nan and NaN range obj");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = null;
        assertEquals("Result should be NaN",new Range(Double.NaN, Double.NaN), Range.combine(range1, range2));
    }
    @Test
    public void CombineR2NullR1Valid() {
    	System.out.println("Test case 7: Combine range 1 valid, range 2 null range obj");
    	range1 = new Range(2,6);
    	range2 = null;
        assertEquals("Result should be 2,6",range1, Range.combine(range1, range2));
    }
    @Test
    public void CombineTwoNaN() {
    	System.out.println("Test case 8: Combine two NaN range obj");
    	
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = new Range(Double.NaN, Double.NaN);
    	//int i = 1;
    	//range1.equals(i);

        assertEquals("Result should be NaN",range1, Range.combine(range1, range2));
    }
    @After
    public void tearDown() throws Exception {
    	System.out.println("tearDown() @After - clean objs");
		range1 = null;
        assertNull(range1);
        range2 = null;
        assertNull(range2);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("tearDownAfterClass() @After");
    }
}