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
public class CoffeeTestStudent {

	/**
	 * tests if there is an extra shot
	 */
	@Test
	public void testGetExtraShot() {
		Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, true);
		assertEquals(true, coffee.getExtraShot());
		Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, false, true);
		assertEquals(false, coffee1.getExtraShot());
	}
	/**
	 * tests if there is extra syrup
	 */
	@Test
	public void testGetExtraSyrup() {
		Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, true);
		assertEquals(true, coffee.getExtraSyrup());
		Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, false);
		assertEquals(false, coffee1.getExtraSyrup());
	}
	/**
	 * tests the price of the coffee
	 */
	@Test
	public void testCalcPrice() {
		Coffee coffee = new Coffee("Latte", Size.SMALL, true, true);
		Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, true);
		Coffee coffee2 = new Coffee("Latte", Size.SMALL, false, false);
		assertEquals(3.0, coffee.calcPrice(),.001);
		assertEquals(3.5, coffee1.calcPrice(),.001);
		assertEquals(2.0, coffee2.calcPrice(),.001);
	}
	/**
	 * tests whether two coffees are equal
	 */
	@Test
	public void testEquals() {
		Coffee coffee = new Coffee("Latte", Size.SMALL, true, true);
		Coffee coffee1 = new Coffee("Latte", Size.SMALL, true, true);
		Coffee coffee2 = new Coffee("Latte", Size.SMALL, true, false);
		assertTrue(coffee1.equals(coffee));
		assertFalse(coffee2.equals(coffee));
	}
	/**
	 * tests whether the string returned is correct
	 */
	@Test
	public void testToString() {
		Coffee coffee = new Coffee("Latte", Size.SMALL, true, true);
		String str = "Latte,SMALL,true,true,3.0";
		assertEquals(str, coffee.toString());
	}
	
	
	
	
	
	
}
