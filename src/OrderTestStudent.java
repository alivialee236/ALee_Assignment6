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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class OrderTestStudent {

	Order order1,
		  order2,
		  order3;
	@Before
	public void setUp() throws Exception {
		order1 = new Order(2, Day.MONDAY, new Customer("Al", 22));
		order2 = new Order(12, Day.SATURDAY, new Customer("Ali", 19));
		order3 = new Order(20, Day.MONDAY, new Customer("Alivia", 21));
	}

	@After
	public void tearDown() throws Exception {
		order1 = order2 = order3 = null;
	}
	
	/**
	 * tests if a random order number is generated within 10000-90000
	 */
	@Test
	public void testGenerateOrder() {
		
		int orderNo = order2.generateOrder();
		assertTrue(orderNo >= 10000 && orderNo <= 90000);
	}
	
	/**
	 * tests if the order number is returned correctly
	 */
	@Test
	public void testGetOrderNo() {
		
		int orderNo = order2.getOrderNo();
		assertEquals(orderNo, order2.getOrderNo());
	}
	
	/**
	 * tests if the order time is returned correctly
	 */
	@Test
	public void testGetOrderTime() {
		assertEquals(12, order2.getOrderTime());
	}
	/**
	 * tests if the order day is returned correctly
	 */
	@Test
	public void testGetOrderDay() {
		assertEquals(Day.SATURDAY, order2.getOrderDay());
	}
	
	/**
	 * tests if the customer is returned correctly
	 */
	@Test
	public void testGetCustomer() {
		Customer cust = new Customer(order2.getCustomer());
		assertEquals(order2.getCustomer().getName(), cust.getName());
		assertEquals(order2.getCustomer().getAge(), cust.getAge());
		
	}
	/**
	 * tests whether it is the weekend
	 */
	@Test
	public void testIsWeekend() {
		assertTrue(order2.isWeekend());
		assertFalse(order3.isWeekend());
		
	}
	/**
	 * tests whether the beverage was returned correctly
	 */
	@Test
	public void testGetBeverage() {
		order2.addNewBeverage("Vodka", Size.LARGE);
		order2.addNewBeverage("Black", Size.MEDIUM, true, false);
		order2.addNewBeverage("Strawberry", Size.SMALL, 4, true);
		Beverage beverage = order2.getBeverage(1);
		assertEquals("Black", beverage.getBevName());
		assertEquals(Size.MEDIUM, beverage.getSize());
	}
	/**
	 * tests whether the total items are returned correctly
	 */
	@Test
	public void testGetTotalItems() {
		order2.addNewBeverage("Vodka", Size.LARGE);
		order2.addNewBeverage("Black", Size.MEDIUM, true, false);
		assertEquals(2, order2.getTotalItems());
	}
	/**
	 * tests whether new beverage was added for all three beverage types
	 */
	@Test
	public void testAddNewBeverage() {
		order2.addNewBeverage("Vodka", Size.LARGE);
		order2.addNewBeverage("Black", Size.MEDIUM, true, false);
		order2.addNewBeverage("Strawberry", Size.SMALL, 4, true);
		assertEquals(3, order2.getTotalItems());
	}
	/**
	 * tests the order total is calculated correctly
	 */
	@Test
	public void testCalcOrderTotal() {
		order2.addNewBeverage("Vodka", Size.LARGE);
		order2.addNewBeverage("Black", Size.MEDIUM, true, false);
		order2.addNewBeverage("Strawberry", Size.SMALL, 4, true);
		order2.addNewBeverage("Black", Size.SMALL, false, false);
		assertEquals(3.6, order2.getBeverage(0).calcPrice(),.001);
		assertEquals(3.0, order2.getBeverage(1).calcPrice(),.001);
		assertEquals(5.5, order2.getBeverage(2).calcPrice(),.001);
		assertEquals(2.0, order2.getBeverage(3).calcPrice(),.001);
		assertEquals(14.1, order2.calcOrderTotal(), .001);
	}
	/**
	 * tests if the num of beverage type is returned correctly
	 */
	@Test
	public void testFindNumofBeveType() {
		order2.addNewBeverage("Vodka", Size.LARGE);
		order2.addNewBeverage("Black", Size.MEDIUM, true, false);
		order2.addNewBeverage("Black", Size.MEDIUM, true, true);
		order2.addNewBeverage("Latte", Size.MEDIUM, true, true);
		order2.addNewBeverage("Strawberry", Size.SMALL, 4, true);
		assertEquals(3, order2.findNumOfBeveType(Type.COFFEE),.001);
		
	}
	/**
	 * tests if the order numbers are compared correctly
	 */
	@Test
	public void testCompareTo() {
		assertEquals(0, order2.compareTo(order2));
		assertEquals(-1, order3.compareTo(order2));//Only true when order3 number is less than order 2's number
		
	}
	/**
	 * tests if the string is returned correctly
	 */
	@Test
	public void testToString() {
		order2.addNewBeverage("Vodka", Size.LARGE);
		order2.addNewBeverage("Black", Size.MEDIUM, true, false);
		order2.addNewBeverage("Black", Size.MEDIUM, true, true);
		String str = "Order No: " + order2.getOrderNo() + "\n" +
					 "Time: " + order2.getOrderTime() + "\n" +
					 "Day: " + order2.getOrderDay() + "\n" +
					 "Customer: " + order2.getCustomer().getName() + "\n" +
					 "Age: " + order2.getCustomer().getAge() + "\n" +
					 "Beverages:" + "\n" +
					 order2.getBeverage(0).toString() + "\n" +
					 order2.getBeverage(1).toString() + "\n" +
					 order2.getBeverage(2).toString() + "\n";
		assertEquals(str, order2.toString());
		
	}
	
	
	
	
}
