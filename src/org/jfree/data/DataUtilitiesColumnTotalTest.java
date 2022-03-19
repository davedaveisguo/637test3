package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesColumnTotalTest extends DataUtilities {

	private Mockery mockingContext = new Mockery();
	private Values2D data = mockingContext.mock(Values2D.class);
	
	@Before
	public void setUp() throws Exception {
		
	
	}

	@Test 
	public void belowLowerBoundIndexTest() {
		
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
	
	@Test 
	public void lowerBoundIndexTest() {
		
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
	@Test 
	public void RegularIndexTest() {
		
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
	
	@Test 
	public void upperBoundIndexTest() {
		
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
	
	@Test 
	public void aboveUpperBoundIndexTest() {
		
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
	
	@Test 
	public void NaNIndexTest() {
		
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
	

	

}