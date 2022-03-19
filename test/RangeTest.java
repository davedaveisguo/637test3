package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class RangeTest {

	private Double lowerbounnd;
	private Double upperbound;
    private Range range;
	private Double value;
	private Range range1;
    private Range range2;
	private Range base;
	private Double delta;
	

    /*
     * this test covers a normal range (1,4) and call scale(range,2) method with the range itself and a positive value.
     */
    @Test
	public void testScaleGreaterThan0ForScale() {
	    System.out.println("Running test scale > 0 ");
		
		range= new Range(1,4);

		assertEquals(new Range(2,8), Range.scale(range, 2) );
	}
    
    /*
     * this test covers a normal range (1,4) and call scale(range,2) method with the range itself and a negative value.
     */
	@Test
	public void testScaleSmallerThan0ForScale() {
	    System.out.println("Running test scale < 0 ");
		
		range= new Range(1,4);

		assertEquals(new Range(2,8), Range.scale(range, -2) );
	}
	
    /*
     * this test covers a min value of double for variable lowerbounnd and a normal decimal value of double for variable upperbound in method isNaNRange()
     */
	@Test
    public void testMinto15ForIsNaNRange() {
    	//System.out.println("Running testCase1() ");
    	lowerbounnd = Double.MIN_VALUE;
    	upperbound = 1.5;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    /*
     * this test covers a normal decimal value of double for variable lowerbounnd and a normal decimal value of double for variable upperbound in method isNaNRange()
     */
    @Test
    public void testNormalValueForIsNaNRange() {
    	//System.out.println("Running testCase2() ");
    	lowerbounnd = 1.5;
    	upperbound = 1.5;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    /*
     * this test covers a negative decimal value of double for variable lowerbounnd and a negative decimal value of double for variable upperbound in method isNaNRange()
     */
    @Test
    public void testNegativex2ForIsNaNRange() {
    	//System.out.println("Running testCase3() ");
    	lowerbounnd = -1.5;
    	upperbound = -1.5;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
	
    /*
     * this test covers a normal decimal value of double for variable lowerbounnd and a max value of double for variable upperbound in method isNaNRange()
     */
    @Test
    public void testDecimalMaxForIsNaNRange() {
    	//System.out.println("Running testCase4() ");
    	lowerbounnd = 1.5;
    	upperbound = Double.MAX_VALUE;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
    
    /*
     * this test covers a normal decimal value of double for variable lowerbounnd and a min value of double for variable upperbound in method isNaNRange()
     */
    @Test
    public void testDecimalMinForIsNaNRange() {
    	//System.out.println("Running testCase5() ");
    	lowerbounnd = 1.5;
    	upperbound = Double.MIN_VALUE;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }
	
    /*
     * this test covers a normal decimal value of double for variable lowerbounnd and a null for variable upperbound in method isNaNRange() 
     */
    @Test
    public void testDecimalNullForIsNaNRange() {
    	//System.out.println("Running testCase6() ");
    	lowerbounnd = 1.5;
    	upperbound = null;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(false, r.isNaNRange());
    }

	/*this test covers NaN value of double for variable lowerbounnd and a NaN value for variable upperbound in method isNaNRange() 
	 */
    @Test
    public void testNaNx2ForIsNaNRange() {
    	System.out.println("Running testCase7() ");
    	lowerbounnd = Double.NaN;
    	upperbound = Double.NaN;
    	Range r = new Range(lowerbounnd, upperbound);
        assertEquals(true, r.isNaNRange());
    }
    
	/*
	 * this test case has one range objects (NaN,Nan) and call method intersects(Double.NaN,Double.NaN) 
	 */
    @Test
	public void testNaNForIntersects() {
		System.out.println("Test Range NaN ");
		Range range = new Range(Double.NaN, Double.NaN);
		assertEquals("Should be false",false, range.intersects(Double.NaN, Double.NaN));
	}
   
	/*this test case has one range objects (Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY) - two extreme values and call method intersects(Double.NEGATIVE_INFINITY,Double.MIN_VALUE) 
	 */
    @Test
    public void testNegaInfinAndMinForIntersects() {
    	System.out.println("Test range Double.NEGATIVE_INFINITY, Double.MIN_VALUE intersection");
    	range1 = new Range(Double.NEGATIVE_INFINITY, Double.MIN_VALUE);
        assertEquals("Should be true",true, range1.intersects(Double.NEGATIVE_INFINITY, Double.MIN_VALUE));
    }
	
    /*
     * this test case has one range objects (Double.MAX_VALUE, Double.POSITIVE_INFINITY) - two extreme values and call method intersects(Double.MAX_VALUE, Double.POSITIVE_INFINITY) - two extreme values
     */
    @Test
    public void testMaxAndPostivInfinForIntersects() {
    	System.out.println("Test Double.MAX_VALUE, Double.POSITIVE_INFINITY intersection");
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY);
        assertEquals("Should be true",true, range1.intersects(Double.MAX_VALUE, Double.POSITIVE_INFINITY));
    }
    
	/*
	 * this test case has one range objects (3,6) - two normal values and call method intersects(4,10) - two normal values
     *the first starting point of the range < the second one in the intersects -> 3 > 4
     */
	@Test
    public void testRange36And410ForIntersects() {
    	System.out.println("Test Range 3,6 Intersec 4,10 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be true",true, range1.intersects(4,10));
    }
	
	/*
	 * this test case has one range objects (3,6) - two normal values and call method intersects(1,10) - two normal values
	 *the first starting point of the range > the second one in the intersects -> 3 > 1
	 */
    @Test
    public void testRange36And210ForIntersects() {
    	System.out.println("Test Range 3,6 Intersec 2,10 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be true",true, range1.intersects(1,10));
    }
    
    /*
     * this test case has one range objects (3,6) - two normal values and call method intersects(3,6) - two normal values
	 *the first  range = the second one  -> 3,6
	 */
    @Test
    public void Testrange36And210ForIntersects() {
    	System.out.println("Test Range 3,6 Intersec New Range 2,10 (NOM)");
    	range1 = new Range(3,6);
        assertEquals("Should be true",true, range1.intersects(new Range(3,6)));
    }
    
    /*
     * this test case has one range objects (1,10) and test the hashcode formula for the method hashCode()
	 *it is used to increase the coverage
	 */
	@Test
	public void testNormalValueForHashCode() {
	    System.out.println("Running hashCode ");
		
		range= new Range(1,10);
		int result;
		result = 29 * (int) (Double.doubleToLongBits(1) ^ (Double.doubleToLongBits(1) >>> 32)) + (int) (Double.doubleToLongBits(10) ^ (Double.doubleToLongBits(10) >>> 32));
        
		assertEquals(result, range.hashCode(),0);
	}
	
	/*
	 * this test case has one range objects (1,7) with normal range and test the getCentralValue formula for the method getCentralValue(range,value)
	 *it is used to increase the coverage
	 */
	@Test
	public void testNormalValueForGetValue() {
		System.out.println("Running testCase1() for testGetValueNormalRange");
		range= new Range(1,7);	
		assertEquals(4 , range.getCentralValue(),0.0000000001);
	}
	
    /*
     * this test case has one range objects (1,4) with normal range and expand it to another normal range 6 for the method expandToInclude(range,value)
     */
	@Test
	public void testExpandToUpperForExpandToInclude() {
	    System.out.println("Running testExpandToUpper() ");
		
		range= new Range(1,4);
		value = 6.0;
		
		assertEquals(new Range(1,6), Range.expandToInclude(range, value) );
	}
	
    /*
     * this test case has one range objects (1,4) with normal range and expand it to another normal decimal range 0.5 for the method expandToInclude(range,value)
     */
	@Test
	public void testExpandToLowerForExpandToInclude() {
		System.out.println("Running testExpandToLower() ");
		
		range= new Range(1,4);
		value = 0.5;
		
		assertEquals(new Range(0.5,4),  Range.expandToInclude(range, value));
	}
	
	/*
	 * this test case has one range objects (Double.MAX_VALUE,Double.MAX_VALUE) with max value of double and expand it to another max value of double 'Double.MAX_VALUE' for the method expandToInclude(range,value)
	 */
	@Test
	public void testExpandToMAXForExpandToInclude() {
		System.out.println("Running testExpandToMAX() ");
		
		range= new Range(Double.MAX_VALUE,Double.MAX_VALUE);
		value = Double.MAX_VALUE;
		
		assertEquals(new Range(Double.MAX_VALUE,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	/*
	 * this test case has one range objects (Double.MIN_VALUE,Double.MIN_VALUE) with min value of double and expand it to another min value of double 'Double.MIN_VALUE' for the method expandToInclude(range,value)
	 */
	@Test
	public void testExpandToMINForExpandToInclude() {
		System.out.println("Running testExpandToMIN() ");
		
		range= new Range(Double.MIN_VALUE,Double.MAX_VALUE);
		value = Double.MIN_VALUE;
		
		assertEquals(new Range(Double.MIN_VALUE,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	/*
	 * this test case has one range objects (Double.MAX_VALUE,Double.MAX_VALUE) with max value of double and expand it to another normal decimal value '0.5' for the method expandToInclude(range,value)
	 */
	@Test
	public void testExpandNormalToMAXForExpandToInclude() {
		System.out.println("Running testExpandNormalToMAX() ");
		
		range= new Range(Double.MAX_VALUE,Double.MAX_VALUE);
		value = 0.5;
		
		assertEquals(new Range(0.5,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	/*
	 * this test case has one range objects (Double.MIN_VALUE,Double.MIN_VALUE) with min value of double and expand it to another negative decimal value '-0.5' for the method expandToInclude(range,value)
	 */
	@Test
	public void testExpandNegativeNormalToMAXForExpandToInclude() {
		System.out.println("Running testExpandNegativeNormalToMAX() ");
		
		range= new Range(Double.MIN_VALUE,Double.MAX_VALUE);
		value = -0.5;
		
		assertEquals(new Range(-0.5,Double.MAX_VALUE), Range.expandToInclude(range, value));
	}
	
	/*
	 * this test case has one null range objects and expand it to another negative decimal value '-0.5' for the method expandToInclude(range,value)
	 */
	@Test
	public void testExpandeNormalToNULLForExpandToInclude() {
		System.out.println("Running testExpandeNormalToNULL() ");
		range= null;
		value = -0.5;
		
		assertEquals(new Range(-0.5,-0.5), Range.expandToInclude(range, value));
	}
	
	/*
	 * this test case has one range objects (1,4) with normal values of double and expand it to two normal margin '2,3' for the method expand(range,lower,upper)
	 */
	@Test
	public void testExpand14ForExpand() {
	    System.out.println("Running test Expand 1 4 ");
		
		range= new Range(1,4);

		assertEquals(new Range(-5,13), Range.expand(range, 2,3) );
	}
	
	/*
	 * this test case has one range objects (1,4) with normal values of double and expand it to one negative lower margin and one normal upper margin '-6,2' for the method expand(range,lower,upper)
	 */
	@Test
	public void testExpand62ForExpand() {
	    System.out.println("Running test Expand -6 2 ");
		
		range= new Range(1,4);

		assertEquals(new Range(-5,13), Range.expand(range, -6,2) );
	}
	
	/*this test case has one range objects (1,10) with normal values of double and test constrain method with normal value '15' for the method constrain(value)
	 *the value 15 is not within the range 1,10
	 */
	@Test
	public void testOutofTheRangeForConstrain() {
	    System.out.println("Running constrain 1,10 & 15 ");
		
		range= new Range(1,10);

		assertEquals(10, range.constrain(15),0);
	}
	
	/*
	 * this test case has one range objects (1,10) with normal values of double and test constrain method with negative value '-6' for the method constrain(value)
	 */
	@Test
	public void testNegForConstrain() {
	    System.out.println("Running constrain 1,10 & -6 ");
		
		range= new Range(1,10);

		assertEquals(1, range.constrain(-6),0);
	}
	
	/*this test case has one range objects (1,10) with normal values of double and test constrain method with normal value '5' for the method constrain(value)
	 *the value 5 is within the range 1,10
	 */
	@Test
	public void testwithinTheRangeForConstrain() {
	    System.out.println("Running constrain 1,10 & 5 ");
		
		range= new Range(1,10);

		assertEquals(5, range.constrain(5),0);
	}
	
	/*
	 * this test case has one range objects (1,10) with normal values of double and test constrain method with normal value '1' for the method constrain(value)
	 *the value 1 is the same as the lowerbounnd of the range object
	 */
	@Test
	public void testLowerBoundForConstrain() {
	    System.out.println("Running constrain 1,10 & 1 ");
		
		range= new Range(1,10);

		assertEquals(1, range.constrain(1),0);
	}
	
	/*
	 * this test case has one range objects (1,10) with normal values of double and test constrain method with normal value '10' for the method constrain(value)
	 * the value 10 is the same as the upperbound of the range object
	 */
	@Test
	public void testUpperBoundForConstrain() {
	    System.out.println("Running constrain 1,10 & 10 ");
		
		range= new Range(1,10);

		assertEquals(10, range.constrain(10),0);
	}
	
	/*
	 * this test case has two range objects, (Double.NaN,Double.NaN) and (Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY) 
	 *and it calls the method combine(range1,range2) to combine two extreme range objects
	 */
	@Test
    public void testTwoNaNRangeForCombine() {
    	System.out.println("Test case 1 : Combine two NaN Range objs");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = new Range(Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY);
        assertEquals("Result should be NaN",new Range(Double.NaN, Double.NaN), Range.combine(range1, range2));
    }
	
	/*
	 * this test case has two range objects, (Double.NEGATIVE_INFINITY,Double.MIN_VALUE) and (Double.NEGATIVE_INFINITY, Double.MIN_VALUE) 
	 * and it calls the method combine(range1,range2) to combine two extreme range objects
	 */
    @Test
    public void testNegInfinAndMinValueForCombine() {
    	System.out.println("Test case 2: NEGATIVE_INFINITY - MIN_VALUE");    	
    	range1 = new Range(Double.NEGATIVE_INFINITY, Double.MIN_VALUE);
    	range1 = new Range(Double.NEGATIVE_INFINITY,Double.MIN_VALUE);
        assertEquals(new Range(Double.NEGATIVE_INFINITY,Double.MIN_VALUE), Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two null range objects and it calls the method combine(range1,range2) to combine two extreme range objects (null)
	 */
    @Test
    public void testNullRangeForCombine() {
    	System.out.println("Test case 3: Combine two null Range obj");
    	range1 = null;
    	range2 = null;
        assertEquals("Result should be null",null, Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects,(Double.MAX_VALUE,Double.POSITIVE_INFINITY-1) and (Double.MAX_VALUE, Double.POSITIVE_INFINITY) 
	 * and it calls the method combine(range1,range2) to combine two extreme range objects
	 */
    @Test
    public void testPosInfinAndMaxValueForCombine() {
    	System.out.println("Test case 4: Combine Two POSITIVE_INFINITY,MAX_VALUE range obj");
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY-1);
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY);
    	assertEquals(new Range(Double.MAX_VALUE,Double.POSITIVE_INFINITY), Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (1.8) and (2,6) and it calls the method combine(range1,range2) to combine two normal range objects
	 */
    @Test
    public void testTwoValidRangeForCombine() {
    	System.out.println("Test case 5: Combine two valid range obj");
    	range1 = new Range(1,8);
    	range2 = new Range(2,6);
        assertEquals("Result should be range(1,8)",new Range(1,8), Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, null and (2,6) and it calls the method combine(range1,range2) to combine one normal range object and one null range object
	 */
    @Test
    public void testR1NullR2ValidForCombine() {
    	System.out.println("Test case 6: Combine range 1 null, range 2 valid range obj");
    	range1 = null;
    	range2 = new Range(2,6);
        assertEquals("Result should be 2,6",range2, Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, null and (Double.NaN,Double.NaN) 
	 * and it calls the method combine(range1,range2) to combine one Double.NaN range object and one null range object
	 */
	
    @Test
    public void testNullAndNaNForCombine() {
    	System.out.println("Test case 7: Combine null and Nan range obj");
    	range1 = null;
    	range2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Result should be NaN",new Range(Double.NaN, Double.NaN), Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (Double.NaN,Double.NaN) and null in different order
	 * and it calls the method combine(range1,range2) to combine one Double.NaN range object and one null range object
	 */
    @Test
    public void testNaNAndNullForCombine() {
    	System.out.println("Test case 8: Combine Nan and NaN range obj");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = null;
        assertEquals("Result should be NaN",new Range(Double.NaN, Double.NaN), Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (2,6) and null 
	 * and it calls the method combine(range1,range2) to combine one normal range object and one null range object
	 */
    @Test
    public void testR2NullR1ValidForCombine() {
    	System.out.println("Test case 9: Combine range 1 valid, range 2 null range obj");
    	range1 = new Range(2,6);
    	range2 = null;
        assertEquals("Result should be 2,6",range1, Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (Double.NaN,Double.NaN) and (Double.NaN,Double.NaN)
	 * and it calls the method combine(range1,range2) to combine two range objects with Double.NaN value
	 */
    @Test
    public void testTwoNaNForCombine() {
    	System.out.println("Test case 10: Combine two NaN range obj");
    	
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = new Range(Double.NaN, Double.NaN);
    	//int i = 1;
    	//range1.equals(i);

        assertEquals("Result should be NaN",range1, Range.combine(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (Double.NaN,Double.NaN) and (Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY) 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine two extreme range objects
	 */
	@Test
    public void testTwoNaNRangeForombineIgnoringNaN() {
    	System.out.println("Test case 1 : Combine two NaN Range objs");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = new Range(Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY);
        assertEquals("Result should be null",null, Range.combineIgnoringNaN(range1, range2));
    }
	
	/*
	 * this test case has two range objects, (Double.NEGATIVE_INFINITY,Double.MIN_VALUE) and (Double.NEGATIVE_INFINITY, Double.MIN_VALUE) 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine two extreme range objects
	 */
	@Test
    public void testcNegInfinAndMinValueForCombineIgnoringNaN() {
    	System.out.println("Test case 2: NEGATIVE_INFINITY - MIN_VALUE");    	
    	range1 = new Range(Double.NEGATIVE_INFINITY, Double.MIN_VALUE);
    	range1 = new Range(Double.NEGATIVE_INFINITY,Double.MIN_VALUE);
        assertEquals(new Range(Double.NEGATIVE_INFINITY,Double.MIN_VALUE), Range.combineIgnoringNaN(range1, range2));
    }
	
	/*
	 * this test case has two null range objects 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine two extreme range objects (null)
	 */
    @Test
    public void testNullRangeforCombineIgnoringNaN() {
    	System.out.println("Test case 3: Combine two null Range obj");
    	range1 = null;
    	range2 = null;
        assertEquals("Result should be null",null, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects,(Double.MAX_VALUE,Double.POSITIVE_INFINITY-1) and (Double.MAX_VALUE, Double.POSITIVE_INFINITY) 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine two extreme range objects
	 */
    @Test
    public void testPosInfinAndMaxValueForCombineIgnoringNaN() {
    	System.out.println("Test case 4: Combine Two POSITIVE_INFINITY,MAX_VALUE range obj");
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY-1);
    	range1 = new Range(Double.MAX_VALUE, Double.POSITIVE_INFINITY);
    	assertEquals(new Range(Double.MAX_VALUE,Double.POSITIVE_INFINITY), Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (1.8) and (2,6) 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine two normal range objects
	 */
    @Test
    public void testTwoValidRangeForCombineIgnoringNaN() {
    	System.out.println("Test case 5: Combine two valid range obj");
    	range1 = new Range(1,8);
    	range2 = new Range(2,6);
        assertEquals("Result should be range(1,8)",new Range(1,8), Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, null and (2,6) 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine one normal range object and one null range object
	 */
    @Test
    public void testR1NullR2ValidForCombineIgnoringNaN() {
    	System.out.println("Test case 6: Combine range 1 null, range 2 valid range obj");
    	range1 = null;
    	range2 = new Range(2,6);
        assertEquals("Result should be 2,6",range2, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, null and (Double.NaN,Double.NaN) 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine one Double.NaN range object and one null range object
	 */
    @Test
    public void testNullAndNaNForCombineIgnoringNaN() {
    	System.out.println("Test case 7: Combine null and Nan range obj");
    	range1 = null;
    	range2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Result should be null",null, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (Double.NaN,Double.NaN) and null in different order
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine one Double.NaN range object and one null range object
	 */
    @Test
    public void testNaNAndNullForCombineIgnoringNaN() {
    	System.out.println("Test case 8: Combine Nan and NaN range obj");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = null;
        assertEquals("Result should be null",null, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (2,6) and null 
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine one normal range object and one null range object
	 */
    @Test
    public void testR2NullR1ValidForCombineIgnoringNaN() {
    	System.out.println("Test case 9: Combine range 1 valid, range 2 null range obj");
    	range1 = new Range(2,6);
    	range2 = null;
        assertEquals("Result should be 2,6",range1, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (Double.NaN,Double.NaN) and (Double.NaN,Double.NaN)
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine two range objects with Double.NaN value
	 */
    @Test
    public void testTwoNaNForCombineIgnoringNaN() {
    	System.out.println("Test case 10: Combine two NaN range obj");
    	range1 = new Range(Double.NaN, Double.NaN);
    	range2 = new Range(Double.NaN, Double.NaN);
        assertEquals("Result should be null",null, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has two range objects, (1,2) and (Double.NaN, Double.NaN)
	 * and it calls the method combineIgnoringNaN(range1,range2) to combine one normal range object and one NaN range object
	 */
    @Test
    public void testPartialNaNForCombineIgnoringNaN() {
    	System.out.println("Test case 11: Combine Partia NaN range obj");
    	range1 = new Range(1, 2);
    	range2 = new Range(Double.NaN, Double.NaN);

        assertEquals("Result should be NaN",range1, Range.combineIgnoringNaN(range1, range2));
    }
    
	/*
	 * this test case has one range objects, (2,5), defined as base and it calls the method shift(base,delta) to shift it with a normal double value of 3 as the variable, delta
	 * It covers one normal range object and delta value.
	 */
	@Test
	public void testPositiveRangeAndPosDeltaForShift() {
		System.out.println("Running testPositiveRangeAndPosDelta() ");
		
		base= new Range(2,5);
		delta= 3.0;
		
		assertEquals(new Range(5.0,6.5), Range.shift(base, delta) );
	}
	
	/*
	 * this test case has one range objects, (1.2,5), defined as base and it calls the method shift(base,delta) to shift it with a negative value of -1.2 as the variable, delta
	 * It covers a starting range of 1.2 and a negative delta decimal value.
	 */
	@Test
	public void testPositiveRangeAndNegDeltaForShift() {
		System.out.println("Running testPositiveRangeAndNegDelta() ");
		
		base= new Range(1.2,5);
		delta= -1.2;
		
		assertEquals(new Range(0.0,3.8), Range.shift(base, delta) );
	}
	
	/*
	 * this test case has one normal range objects, (1,5), defined as base and it calls the method shift(base,delta) to shift it with a null as the variable, delta
	 * It covers a normal range object and a null delta.
	 */
	@Test (expected = NullPointerException.class )
	public void testPositiveRangeAndNullDeltaForShift() {
		System.out.println("Running testPositiveRangeAndNullDelta() ");
		
		base= new Range(1,5);
		delta= null;
		
		 Range.shift(base, delta);
		 
	}
	
	/*
	 * this test case has one range objects, (1,5), defined as base and it calls the method shift(base,delta) to shift it with a negative value of -1.5 as the variable, delta
	 * It covers a starting range of 1 and a negative delta decimal value.
	 */
	@Test
	public void testgetUpperBoundForShift() {
		System.out.println("Running testPositiveRangeAndNegDelta() ");
		
		base= new Range(1,5);
		delta= -1.5;
		
		assertEquals(-0.5, Range.shift(base, delta, true).getLowerBound() ,0.000001);
		assertEquals( 3.5, Range.shift(base, delta, true).getUpperBound() ,0.000001);
	}
	
	/*
	 * this test case has one range objects, (-1,5), defined as base and it calls the method shift(base,delta) to shift it with a negative value of 1.2 as the variable, delta.
	 * It covers a negative starting range of -1 and a negative delta decimal value.
	 */
	@Test
	public void testNegativeRangeAndPosDeltaForShift() {
		System.out.println("Running testNegativeRangeAndPosDelta() ");
		
		base= new Range(-1,5);
		delta= 1.2;
		
		assertEquals(0.2, Range.shift(base, delta, false).getLowerBound() ,0.000001);
		assertEquals(6.2, Range.shift(base, delta, false).getUpperBound() ,0.000001);
	}
	
	/*
	 * this test case has one range objects, (0,5), defined as base and it calls the method shift(base,delta) to shift it with a negative value of 1.2 as the variable, delta.
	 * It covers a starting range of 0 and a negative delta decimal value.
	 */
	@Test
	public void testZeroRangeAndPosDeltaForShift() {
		System.out.println("Running testZeroRangeAndPosDelta() ");
		
		base= new Range(0,5);
		delta= 1.2;
		
		assertEquals(1.2, Range.shift(base, delta, false).getLowerBound() ,0.000001);
		assertEquals(6.2, Range.shift(base, delta, false).getUpperBound() ,0.000001);
	}
	
	/*
	 * this test case has one normal range object (1,7) and it calls the method toString() to print the range
	 */
	@Test
	public void testDisplayRangeForToString() {
		System.out.println("Running testToString() for RangeToString");
		range= new Range(1,7);	
		assertEquals("Range[1.0,7.0]" , range.toString());
	}
	

}
