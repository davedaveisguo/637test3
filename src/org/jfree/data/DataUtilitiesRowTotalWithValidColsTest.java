package org.jfree.data;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesRowTotalWithValidColsTest {
	private Mockery mockingContext = new Mockery();
	private Values2D data = mockingContext.mock(Values2D.class);
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void lowerBoundIndexTest() {
		int [] validCols = {0,1,2,3};
		
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
	
	@Test 
	public void NaNIndexTest() {
		int [] validCols = {0,1,2,3};
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
}
