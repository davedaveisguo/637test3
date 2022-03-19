package org.jfree.data;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesColumnTotalWithValidRowsTest {
	private Mockery mockingContext = new Mockery();
	private Values2D data = mockingContext.mock(Values2D.class);
	
	@Test 
	public void lowerBoundIndexTest() {
		
		int [] validRows = {0,1,2,3};
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
	
	
	@Test 
	public void NaNIndexTest() {
		int [] validRows = {0,1,2,3};
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
	


	

}