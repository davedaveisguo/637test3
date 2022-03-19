package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesTest extends DataUtilities{

	private double[][] arr1 = { { 1.0, 2.0 }, { 3.0, 4.0 } };
	private double[][] arr2 = { { 1.0, 2.0 }, { 3.0, 4.0 } };
	private double[][] arr3 = { {} };
	private double[][] arr4 = { {} };
	private double[][] arr5 = { { 1.1, 2.0 }, { 3.0, 4.0 } };
	private double[][] arr6 = new double[2][2];
	private double[][] arr7 = new double[2][2];
	private double[][] arr8 = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.NEGATIVE_INFINITY } };
	private double[][] arr9 = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.POSITIVE_INFINITY } };
	private double[][] nullArray = null;
	private Number[][] expectedArray = { { 1.0, 2.0 }, { 3.0, 4.0 } };
	private Number[][] expectedNullArray = { {} };
	private Number[][] expectedNegativeInfinityArray = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.NEGATIVE_INFINITY } };
	private Number[][] expectedPositiveInfinityArray = { { 1.0, 2.0, 3.0 }, { 1.0, 2.0, Double.POSITIVE_INFINITY } };

	private Mockery mockingContext = new Mockery();
	private KeyedValues keyVal = mockingContext.mock(KeyedValues.class);
	private Values2D data = mockingContext.mock(Values2D.class);

	/*
	 * this test covers an empty array in method createNumberArray(double[] data)
	 */
	@Test
	public void testEmptyArrayForCreateNumberArray() {

		double[] arr = {};

		Number[] result = DataUtilities.createNumberArray(arr);

		Number[] expected = {};

		assertArrayEquals(expected, result);

	}

	/*
	 * this test covers an array with 3 elements in method
	 * createNumberArray(double[] data)
	 */
	@Test
	public void testDoubleTypeElementArrayForCreateNumberArray() {

		double[] arr = { 1.0, 2.0, 3.0 };

		Number[] result = DataUtilities.createNumberArray(arr);

		Number[] expected = { 1.0, 2.0, 3.0 };

		assertArrayEquals(expected, result);

	}

	/*
	 * this test covers an array contains non-double type elements in method
	 * createNumberArray(double[] data)
	 */
	@Test
	public void testNoDoubleTypeElementArrayForCreateNumberArray() {

		double[] arr = { 1, 2, 3 };

		Number[] result = DataUtilities.createNumberArray(arr);

		Number[] expected = { 1, 2, 3 };

		assertArrayEquals(expected, result);

	}
	
	/*
	 * this test covers normal length and normal values in method createNumberArray2D(double[][])
	 */
    @Test
    public void numberArrayCreat2DCheck() {
    	Number[][] arr2 = DataUtilities.createNumberArray2D(arr1);
      	assertArrayEquals("Array created matching expected array", expectedArray, arr2); 
           
    }
    
    /*
     * this test covers minimum length (empty array) and normal values in method createNumberArray2D(double[][]) 
     */
    @Test
    public void nullArrayCreat2DCheck() {
    	Number[][] arr4 = DataUtilities.createNumberArray2D(arr3);
    	assertArrayEquals("Arrays should match", expectedNullArray, arr4); 
           
    }
    
    /*
     * this test covers lower bound robustness testing of values using Negative Infinity value in method createNumberArray2D(double[][]) 
     */
    @Test
    public void negativeInfinityArrayCreat2DCheck() {
    	Number[][] arr7 = DataUtilities.createNumberArray2D(arr8);
    	assertArrayEquals("Arrays should match", expectedNegativeInfinityArray, arr7); 
           
    }
    
    
    /*
     * this test covers upper bound robustness testing of values using Positive Infinity value in method createNumberArray2D(double[][])
     */
    @Test
    public void posotiveInfinityArrayCreat2DCheck() {
    	Number[][] arr8 = DataUtilities.createNumberArray2D(arr9);
    	assertArrayEquals("Arrays should match", expectedPositiveInfinityArray, arr8); 
           
    }

    /*
     * this test covers an array of normal values and normal length in method equal(double[][], double[][])
     */
    @Test
    public void testForNormalValuesNormalLengthForEqual() {
        assertTrue("Arrays should be Equal", DataUtilities.equal(arr1, arr2)); 
        
    }
    
    /*
     * this test covers an array of min length (empty), using two empty arrays in method equal(double[][], double[][])
     */
    @Test
    public void testForEmptyArrayForEqual() {
        assertTrue("Arrays should be Equal", DataUtilities.equal(arr3, arr4)); 
            
    }
    
    /*
     * this test covers testing of an array of normal length comparing with an empty array in method equal(double[][], double[][])
     */
    @Test
    public void testForNormalLengthForEqual() {
        assertFalse("Arrays should not be Equal", DataUtilities.equal(arr3, arr2)); 
            
    }
    
    /*
     * this test covers testing of two arrays of normal values with equal length in method equal(double[][], double[][])
     */
    @Test
    public void testForNormalValuesForEqual() {
        assertFalse("Arrays should not be Equal", DataUtilities.equal(arr1, arr5)); 
            
    }
    
    /*
     * this test covers robustness testing (lower bound) using Negative Infinity values comparing equal sized length arrays 
     in method equal(double[][], double[][])
     */
    @Test
    public void testForLowerBoundInfinityForEqual() {
        arr6[0][0] = Double.NEGATIVE_INFINITY;
        arr7[0][0] = Double.NEGATIVE_INFINITY;
        assertTrue("Arrays should be Equal", DataUtilities.equal(arr6, arr7)); 
            
    }
   
    /*
     * this test covers robustness testing (upper bound) using Positive Infinity values comparing equal sized length arrays
       in method equal(double[][], double[][]) 
      */
    @Test
    public void testForUpperBoundInfinityForEqual() {
        arr6[0][0] = Double.POSITIVE_INFINITY;
        arr7[0][0] = Double.POSITIVE_INFINITY;
        assertTrue("Arrays should be Equal", DataUtilities.equal(arr6, arr7)); 
            
    }
   
    
    /*
     * this test covers robustness testing (upper and lowr bound) using Positive and negative Infinity values
      and equal sized length arrays  in method equal(double[][], double[][])
      */
    @Test 
    public void testForUpperLowerBoundInfinityForEqual() {
        arr6[0][0] = Double.POSITIVE_INFINITY;
        arr7[0][0] = Double.NEGATIVE_INFINITY;
        assertFalse("Arrays should not be Equal", DataUtilities.equal(arr6, arr7)); 
            
    }
     
    /*
     * this test covers robustness testing (upper bound) using an array of Positive Infinity values and an empty array
      in method equal(double[][], double[][])
      */
    @Test
    public void testForNormalValuesInfinityForEqual() {
        arr6[0][0] = Double.POSITIVE_INFINITY;
        assertFalse("Arrays should not be Equal", DataUtilities.equal(arr3, arr6)); 
            
    }
    
    /*
     * this test covers robustness testing comparing a null array and an array of normal values 
      in method equal(double[][], double[][])
     */
    @Test
    public void testForNullArrayForEqual() {
        assertTrue("Arrays should not be Equal", DataUtilities.equal(nullArray, arr1)); 
           
    }

    /*
     * this test covers robustness testing comparing an array of normal values and a null array
     in method equal(double[][], double[][]) 
     */
	@Test
	public void secondArrayNullCheck() {
		assertTrue("Arrays should not be Equal", DataUtilities.equal(arr1, nullArray));

	}

	
	/* this test covers an array with positive values in method clone(double[][]
	 * source)
	 */
	@Test
	public void testArrayWithPositiveValuesForClone() {

		double[][] arr = { { 1.0, 2.0 }, { 3.0, 4.0 } };

		double[][] result = DataUtilities.clone(arr);

		Number[][] expected = { { 1.0, 2.0 }, { 3.0, 4.0 } };

		assertArrayEquals(expected, result);

	}

	/*
	 * this test covers an array with negative values in method clone(double[][]
	 * source)
	 */
	@Test
	public void testArrayWithNegativeValuesForClone() {

		double[][] arr = { { -1.0, -2.0 }, { -3.0, -4.0 } };

		double[][] result = DataUtilities.clone(arr);

		Number[][] expected = { { -1.0, -2.0 }, { -3.0, -4.0 } };

		assertArrayEquals(expected, result);

	}

	/*
	 * this test covers an empty array in method clone(double[][] source)
	 */
	@Test
	public void testEmptyArrayForClone() {

		double[][] arr = {};

		double[][] result = DataUtilities.clone(arr);

		Number[][] expected = {};

		assertArrayEquals(expected, result);

	}

	/*
	 * this test covers below lower bound column index in method
	 * calculateColumnTotal(Values2D data, int column)
	 */
	@Test
	public void testBelowLowerBoundIndexForCalculateColumnTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(0, -1);
				will(returnValue(1.0));
				one(data).getValue(1, -1);
				will(returnValue(2.0));
				one(data).getValue(2, -1);
				will(returnValue(3.0));
				one(data).getValue(3, -1);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, -1);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers lower bound column index in method
	 * calculateColumnTotal(Values2D data, int column)
	 */
	@Test
	public void testLowerBoundIndexForCalculateColumnTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(0, 0);
				will(returnValue(1.0));
				one(data).getValue(1, 0);
				will(returnValue(2.0));
				one(data).getValue(2, 0);
				will(returnValue(3.0));
				one(data).getValue(3, 0);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, 0);

		assertEquals(10.0, result, .000000001d);
	}

	/*
	 * this test covers regular column index in method calculateColumnTotal(Values2D
	 * data, int column)
	 */
	@Test
	public void testRegularIndexForCalculateColumnTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(0, 1);
				will(returnValue(1.0));
				one(data).getValue(1, 1);
				will(returnValue(2.0));
				one(data).getValue(2, 1);
				will(returnValue(3.0));
				one(data).getValue(3, 1);
				will(returnValue(4.0));

			}
		});

		double result = DataUtilities.calculateColumnTotal(data, 1);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers upper bound column index in method
	 * calculateColumnTotal(Values2D data, int column)
	 */
	@Test
	public void testUpperBoundIndexForCalculateColumnTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(0, Integer.MAX_VALUE);
				will(returnValue(1.0));
				one(data).getValue(1, Integer.MAX_VALUE);
				will(returnValue(2.0));
				one(data).getValue(2, Integer.MAX_VALUE);
				will(returnValue(3.0));
				one(data).getValue(3, Integer.MAX_VALUE);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, Integer.MAX_VALUE);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers above upper bound column index in method
	 * calculateColumnTotal(Values2D data, int column)
	 */
	@Test
	public void testAboveUpperBoundIndexForCalculateColumnTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(0, Integer.MAX_VALUE + 1);
				will(returnValue(1.0));
				one(data).getValue(1, Integer.MAX_VALUE + 1);
				will(returnValue(2.0));
				one(data).getValue(2, Integer.MAX_VALUE + 1);
				will(returnValue(3.0));
				one(data).getValue(3, Integer.MAX_VALUE + 1);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, Integer.MAX_VALUE + 1);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers Nan column index in method calculateColumnTotal(Values2D
	 * data, int column)
	 */
	@Test
	public void testNaNIndexForCalculateColumnTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(0, 'a');
				will(returnValue(1.0));
				one(data).getValue(1, 'a');
				will(returnValue(2.0));
				one(data).getValue(2, 'a');
				will(returnValue(3.0));
				one(data).getValue(3, 'a');
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, 'a');

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers lower bound column index in method
	 * calculateColumnTotal(Values2D data, int column, int[] validRows)
	 */
	@Test
	public void testLowerBoundIndexForCalculateColumnTotalWithValidRows() {

		int[] validRows = { 0, 1, 2, 3 };
		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(validRows[0], 0);
				will(returnValue(1.0));
				one(data).getValue(validRows[1], 0);
				will(returnValue(2.0));
				one(data).getValue(validRows[2], 0);
				will(returnValue(3.0));
				one(data).getValue(validRows[3], 0);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, 0, validRows);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers Nan column index in method calculateColumnTotal(Values2D
	 * data, int column, int[] validRows)
	 */
	@Test
	public void testNaNIndexForCalculateColumnTotalWithValidRows() {
		int[] validRows = { 0, 1, 2, 3 };
		mockingContext.checking(new Expectations() {
			{
				one(data).getRowCount();
				will(returnValue(4));
				one(data).getValue(validRows[0], 'z');
				will(returnValue(1.0));
				one(data).getValue(validRows[1], 'z');
				will(returnValue(2.0));
				one(data).getValue(validRows[2], 'z');
				will(returnValue(3.0));
				one(data).getValue(validRows[3], 'z');
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(data, 'z', validRows);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers below lower bound row index in method
	 * calculateRowTotal(Values2D data, int row)
	 */
	@Test
	public void testBelowLowerBoundIndexForCalculateRowTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue(-1, 0);
				will(returnValue(1.0));
				one(data).getValue(-1, 1);
				will(returnValue(2.0));
				one(data).getValue(-1, 2);
				will(returnValue(3.0));
				one(data).getValue(-1, 3);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, -1);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers lower bound row index in method calculateRowTotal(Values2D
	 * data, int row)
	 */
	@Test
	public void testLowerBoundIndexForCalculateRowTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue(0, 0);
				will(returnValue(1.0));
				one(data).getValue(0, 1);
				will(returnValue(2.0));
				one(data).getValue(0, 2);
				will(returnValue(3.0));
				one(data).getValue(0, 3);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, 0);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers regular row index in method calculateRowTotal(Values2D data,
	 * int row)
	 */
	@Test
	public void testRegularIndexForCalculateRowTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue(1, 0);
				will(returnValue(1.0));
				one(data).getValue(1, 1);
				will(returnValue(2.0));
				one(data).getValue(1, 2);
				will(returnValue(3.0));
				one(data).getValue(1, 3);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, 1);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers upper bound row index in method calculateRowTotal(Values2D
	 * data, int row)
	 */
	@Test
	public void testUpperBoundIndexForCalculateRowTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue(Integer.MAX_VALUE, 0);
				will(returnValue(1.0));
				one(data).getValue(Integer.MAX_VALUE, 1);
				will(returnValue(2.0));
				one(data).getValue(Integer.MAX_VALUE, 2);
				will(returnValue(3.0));
				one(data).getValue(Integer.MAX_VALUE, 3);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, Integer.MAX_VALUE);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers above upper bound row index in method
	 * calculateRowTotal(Values2D data, int row)
	 */
	@Test
	public void testAboveUpperBoundIndexForCalculateRowTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue(Integer.MAX_VALUE + 1, 0);
				will(returnValue(1.0));
				one(data).getValue(Integer.MAX_VALUE + 1, 1);
				will(returnValue(2.0));
				one(data).getValue(Integer.MAX_VALUE + 1, 2);
				will(returnValue(3.0));
				one(data).getValue(Integer.MAX_VALUE + 1, 3);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, Integer.MAX_VALUE + 1);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers Nan row index in method calculateRowTotal(Values2D data, int
	 * row)
	 */
	@Test
	public void testNaNIndexForCalculateRowTotal() {

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue('a', 0);
				will(returnValue(1.0));
				one(data).getValue('a', 1);
				will(returnValue(2.0));
				one(data).getValue('a', 2);
				will(returnValue(3.0));
				one(data).getValue('a', 3);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, 'a');

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers lower bound row index in method calculateRowTotal(Values2D
	 * data, int row, int[] validCols)
	 */
	@Test
	public void testLowerBoundIndexForCalculateRowTotalWithValidCols() {
		int[] validCols = { 0, 1, 2, 3 };

		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue(0, validCols[0]);
				will(returnValue(1.0));
				one(data).getValue(0, validCols[1]);
				will(returnValue(2.0));
				one(data).getValue(0, validCols[2]);
				will(returnValue(3.0));
				one(data).getValue(0, validCols[3]);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, 0, validCols);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers Nan row index in method calculateRowTotal(Values2D data, int
	 * row, int[] validCols)
	 */
	@Test
	public void testNaNIndexForCalculateRowTotalWithValidCols() {
		int[] validCols = { 0, 1, 2, 3 };
		mockingContext.checking(new Expectations() {
			{
				one(data).getColumnCount();
				will(returnValue(4));
				one(data).getValue('z', validCols[0]);
				will(returnValue(1.0));
				one(data).getValue('z', validCols[1]);
				will(returnValue(2.0));
				one(data).getValue('z', validCols[2]);
				will(returnValue(3.0));
				one(data).getValue('z', validCols[3]);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(data, 'z', validCols);

		assertEquals(10.0, result, .000000001d);

	}

	/*
	 * this test covers positive values in getCumulativePercentages(KeyedValues
	 * data)
	 */
	@Test
	public void testPositiveValuesForGetCumulativePercent() {
		int val1 = 3;

		mockingContext.checking(new Expectations() {
			{
				allowing(keyVal).getItemCount();
				will(returnValue(val1));

				allowing(keyVal).getValue(0);
				will(returnValue(3));
				allowing(keyVal).getValue(1);
				will(returnValue(4));
				allowing(keyVal).getValue(2);
				will(returnValue(3));

				allowing(keyVal).getKey(0);
				will(returnValue(0));
				allowing(keyVal).getKey(1);
				will(returnValue(1));
				allowing(keyVal).getKey(2);
				will(returnValue(2));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(keyVal);

		assertEquals(0.3, (double) result.getValue(0), 0.000000001d);
		assertEquals(0.7, (double) result.getValue(1), 0.000000001d);
	}

	/*
	 * this test covers negative values in getCumulativePercentages(KeyedValues
	 * data)
	 */
	@Test
	public void testNegativeValuesForGetCumulativePercent() {
		int val1 = 3;

		mockingContext.checking(new Expectations() {
			{
				allowing(keyVal).getItemCount();
				will(returnValue(val1));

				allowing(keyVal).getValue(0);
				will(returnValue(-3));
				allowing(keyVal).getValue(1);
				will(returnValue(-4));
				allowing(keyVal).getValue(2);
				will(returnValue(-3));

				allowing(keyVal).getKey(0);
				will(returnValue(0));
				allowing(keyVal).getKey(1);
				will(returnValue(1));
				allowing(keyVal).getKey(2);
				will(returnValue(2));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(keyVal);

		assertEquals(0.3, (double) result.getValue(0), 0.000000001d);
		assertEquals(0.7, (double) result.getValue(1), 0.000000001d);
	}

	/*
	 * this test covers letter keys in getCumulativePercentages(KeyedValues data)
	 */
	@Test
	public void testLetterKeysForGetCumulativePercent() {

		mockingContext.checking(new Expectations() {
			{
				allowing(keyVal).getItemCount();
				will(returnValue(3));

				allowing(keyVal).getKey(0);
				will(returnValue("x"));
				allowing(keyVal).getKey(1);
				will(returnValue("y"));
				allowing(keyVal).getKey(2);
				will(returnValue("z"));

				allowing(keyVal).getValue(0);
				will(returnValue(3));
				allowing(keyVal).getValue(1);
				will(returnValue(4));
				allowing(keyVal).getValue(2);
				will(returnValue(3));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyVal);

		assertEquals(0.3, result.getValue(0));
		assertEquals(1.0, result.getValue(2));

	}

}
