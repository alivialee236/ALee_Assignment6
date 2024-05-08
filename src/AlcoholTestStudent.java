/*
 * Class: CMSC203 CRN 30339
 * Instructor:Professor Grinberg
 * Description: Makes an application that creates orders through beverages 
 * and returns the prices of the total orders and monthly orders from the
 * prices of the drinks ordered by the customer
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Alivia Lee
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class AlcoholTestStudent {

	/**
	 * Tests whether the alcohol is being served on a weekend day
	 */
	@Test 
	public void testIsWeekend() {
		
		Alcohol sunday = new Alcohol("Vodka", Size.LARGE, true);
		assertTrue(sunday.isWeekend());
		Alcohol monday = new Alcohol("Vodka", Size.LARGE, false);
		assertFalse(monday.isWeekend());
		
	}
	/**
	 * Tests whether the additional price of .6 for the weekend is correct
	 * as well as the base/size pricing
	 */
	@Test 
	public void testCalcPrice() {
		
		Alcohol sunday = new Alcohol("Vodka", Size.LARGE, true);
		assertEquals(sunday.calcPrice(), 3.6, .001);
		Alcohol monday = new Alcohol("Vodka", Size.LARGE, false);
		assertEquals(monday.calcPrice(), 3.0, .001);
		
	}
	/**
	 * Tests whether two beverages are equal to one another
	 */
	@Test 
	public void testEquals() {
		
		Alcohol sunday = new Alcohol("Vodka", Size.LARGE, true);
		Alcohol saturday = new Alcohol("Vodka", Size.LARGE, true);
		Alcohol monday = new Alcohol("Vodka", Size.LARGE, false);
		
		assertTrue(sunday.equals(saturday));
		assertFalse(sunday.equals(monday));
	}
	
	/**
	 * tests whether the string was correctly returned
	 */
	@Test
	public void testToString() {
		Alcohol sunday = new Alcohol("Vodka", Size.LARGE, true);
		String str = "Vodka,LARGE,true,3.6";
		assertEquals(sunday.toString(), str);
	}
	
}
