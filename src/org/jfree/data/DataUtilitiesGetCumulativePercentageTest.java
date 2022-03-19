package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jmock.Expectations;
import org.jmock.Mockery;


public class DataUtilitiesGetCumulativePercentageTest extends DataUtilities {
	Mockery mockingContext = new Mockery();
	KeyedValues keyVal = mockingContext.mock(KeyedValues.class);
	
    @Test
    public void getCumulativePercentPositiveValues() {
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
    	
		assertEquals( 0.3, (double)result.getValue(0), 0.000000001d);
		assertEquals( 0.7, (double)result.getValue(1), 0.000000001d);
    }
    
    @Test
	public void getCumulativePercentWithLetters() {
		
		mockingContext.checking(new Expectations() {
			{
				allowing(keyVal).getItemCount();
				will(returnValue(3));
				allowing(keyVal).getKey(0);
				will(returnValue("x"));
				allowing(keyVal).getValue(0);
				will(returnValue(3));
				allowing(keyVal).getKey(1);
				will(returnValue("y"));
				allowing(keyVal).getValue(1);
				will(returnValue(4));
				allowing(keyVal).getKey(2);
				will(returnValue("z"));
				allowing(keyVal).getValue(2);
				will(returnValue(3));
			}
		});
		

		KeyedValues result = DataUtilities.getCumulativePercentages(keyVal);

		assertEquals( 0.3, result.getValue(0));
		assertEquals( 1.0, result.getValue(2));
	
	}

}

