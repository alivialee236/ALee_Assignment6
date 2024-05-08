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
public class SmoothieTestStudent {
	/**
	 * tests whether the number of fruits was returned correctly
	 */
	@Test
	public void testGetNumOfFruits() {
		Smoothie smoothie = new Smoothie("Banana", Size.LARGE, 4, true);
		assertEquals(4, smoothie.getNumOfFruits());
	}
	/**
	 * tests whether protein was added or not
	 */
	@Test
	public void testGetAddProtein() {
		Smoothie smoothie = new Smoothie("Banana", Size.LARGE, 4, true);
		Smoothie smoothie1 = new Smoothie("Banana", Size.LARGE, 4, false);
		assertTrue(smoothie.getAddProtein());
		assertFalse(smoothie1.getAddProtein());
	}
	
	/**
	 * tests whether the price is calculated correctly
	 */
	@Test
	public void testCalcPrice() {
		Smoothie smoothie = new Smoothie("Banana", Size.LARGE, 4, true);
		Smoothie smoothie1 = new Smoothie("Banana", Size.SMALL, 2, false);
		assertEquals(6.5, smoothie.calcPrice(), .001);
		assertEquals(3.0, smoothie1.calcPrice(), .001);
		
	}
	/**
	 * tests whether the smoothies are compared correctly
	 */
	@Test
	public void testEquals() {
		Smoothie smoothie = new Smoothie("Banana", Size.LARGE, 4, true);
		Smoothie smoothie1 = new Smoothie("Banana", Size.LARGE, 4, true);
		Smoothie smoothie2 = new Smoothie("Banana", Size.SMALL, 2, false);
		assertTrue(smoothie.equals(smoothie1));
		assertFalse(smoothie.equals(smoothie2));
	}
	/**
	 * tests whether the string is returned correctly
	 */
	@Test 
	public void testToString() {
		Smoothie smoothie = new Smoothie("Banana", Size.LARGE, 4, true);
		String str = "Banana,LARGE,4,true,6.5";
		assertEquals(str, smoothie.toString());
	}

}
