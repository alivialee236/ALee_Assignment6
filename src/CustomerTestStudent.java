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
public class CustomerTestStudent {
	/**
	 * 
	 * tests whether age was returned correctly
	 */
	@Test
	public void testGetAge() {
		Customer cust = new Customer("Alivia", 21);
		assertEquals(21, cust.getAge());
	}
	/**
	 * 
	 * tests whether age was set correctly
	 */
	@Test
	public void testSetAge() {
		Customer cust = new Customer("Alivia", 21);
		cust.setAge(20);
		assertEquals(20, cust.getAge());
		
	}
	/**
	 * tests whether name was returned correctly
	 */
	@Test
	public void testGetName() {
		Customer cust = new Customer("Alivia", 21);
		assertEquals("Alivia", cust.getName());
	}
	/**
	 * tests whether name was set correctly
	 */
	@Test
	public void testSetName() {
		Customer cust = new Customer("Alivia", 21);
		cust.setName("A");
		assertEquals("A", cust.getName());
	}
	
	/**
	 * tests whether correct string is returned
	 */
	@Test
	public void testToString() {
		Customer cust = new Customer("Alivia", 21);
		String str = "Alivia,21";
		assertEquals(str, cust.toString());
	}
}
