package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesRowTotalTest extends DataUtilities {

	private Mockery mockingContext = new Mockery();
	private Values2D data = mockingContext.mock(Values2D.class);
	
	@Before
	public void setUp() throws Exception {
	
	}
	
	@Test
	public void belowLowerBoundIndexTest() {
		
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
	
	@Test
	public void lowerBoundIndexTest() {
		
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
	
	@Test
	public void regularIndexTest() {
		
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
	@Test 
	public void upperBoundIndexTest() {
		
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
	
	@Test 
	public void aboveUpperBoundIndexTest() {
		
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
	
	@Test 
	public void NaNIndexTest() {
		
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

}