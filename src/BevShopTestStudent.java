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
public class BevShopTestStudent {
	
	/**
	 * tests whether the time is between 8-23
	 */
	@Test public void testIsValidTime() {
		
		BevShop bevShop = new BevShop();
		assertTrue(bevShop.isValidTime(8));
		assertTrue(bevShop.isValidTime(23));
		assertFalse(bevShop.isValidTime(7));
		assertFalse(bevShop.isValidTime(24));
		
	}
	
	/**
	 * tests whether the return is 5 as the max fruits
	 */
	@Test
	public void testGetMaxNumOfFruits() {
		
		BevShop bevShop = new BevShop();
		assertEquals(5, bevShop.getMaxNumOfFruits());
		
	}
	/**
	 * tests whether the return is 21 as the min age for alcohol
	 */
	@Test
	public void testGetMinAgeForAlcohol() {
		
		BevShop bevShop = new BevShop();
		assertEquals(21, bevShop.getMinAgeForAlcohol());
		
	}
	/**
	 * tests whether the fruits exceeds the max of 5 fruits
	 */
	@Test
	public void testIsMaxFruit() {
		
		BevShop bevShop = new BevShop();
		assertTrue(bevShop.isMaxFruit(10));
		assertFalse(bevShop.isMaxFruit(4));
		
	}
	/**
	 * tests whether the return is 3 as the max order for alcohol
	 */
	@Test
	public void testGetMaxOrderForAlcohol() {
		
		BevShop bevShop = new BevShop();
		assertEquals(3, bevShop.getMaxOrderForAlcohol());
		
	}
	/**
	 * tests whether returns correct number of alcohol drinks in the order
	 */
	@Test
	public void testGetNumOfAlcoholDrink() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		assertEquals(2, bevShop.getNumOfAlcoholDrink());
		bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		assertEquals(3, bevShop.getNumOfAlcoholDrink());
		
	}
	
	@Test
	/**
	 * tests whether order is eligible for more alcohol
	 */
	public void testIsEligibleForMore() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		assertFalse(bevShop.isEligibleForMore());
		
	}
	
	@Test 
	/**
	 * tests whether customer is valid age
	 */
	public void testIsValidAge() {
		
		BevShop bevShop = new BevShop();
		assertTrue(bevShop.isValidAge(21));
		assertFalse(bevShop.isValidAge(20));
		
	}
	
	@Test
	/**
	 * tests whether a new order was created
	 */
	public void testStartNewOrder() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		assertEquals(1, bevShop.totalNumOfMonthlyOrders());
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 20);
		assertEquals(2, bevShop.totalNumOfMonthlyOrders());
		
	}
	
	@Test 
	/**
	 * tests whether a new coffee order was created
	 */
	public void testProcessCoffeeOrder() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		bevShop.processCoffeeOrder("Frappe", Size.LARGE, false, false);
		assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
		
	}
	
	@Test
	/**
	 * tests whether a new alcohol order was created
	 */
	public void testProcessAlcoholOrder() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		bevShop.processAlcoholOrder("Vodka", Size.LARGE);
		assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
		
	}
	@Test 
	/**
	 * tests whether a new smoothie order was created
	 */
	public void testProcessSmoothieOrder() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		bevShop.processSmoothieOrder("Banana smoothie", Size.LARGE, 5 , false);
		assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
		
	}
	@Test 
	/**
	 * tests whether the order was found correctly
	 */
	public void testFindOrder() {
		
		BevShop bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		bevShop.startNewOrder(10, Day.SUNDAY, "Alivia", 20);
		assertEquals(0, bevShop.findOrder(bevShop.getOrderAtIndex(0).getOrderNo()));
		assertEquals(1, bevShop.findOrder(bevShop.getOrderAtIndex(1).getOrderNo()));	
		
	}
	@Test 
	/**
	 * tests whether the order total was calculated correctly
	 */
	public void testTotalOrderPrice() {
		
		BevShop store = new BevShop();
		store.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store.processAlcoholOrder("Vodka", Size.SMALL);
		store.processCoffeeOrder("Frappe", Size.SMALL, false, true);
		store.processSmoothieOrder("Banana Smoothie", Size.LARGE, 5, true);
		assertEquals(12.1, store.totalOrderPrice(store.getOrderAtIndex(0).getOrderNo()),.001);		
		
	}
	
	@Test 
	/**
	 * tests whether the total of all the orders in the month was calculated correctly
	 */
	public void testTotalMonthlySale() {
		
		BevShop store1 = new BevShop();
		store1.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store1.processAlcoholOrder("Vodka", Size.SMALL);
		store1.processCoffeeOrder("Frappe", Size.SMALL, false, true);
		store1.processSmoothieOrder("Banana Smoothie", Size.LARGE, 5, true);
		store1.startNewOrder(9, Day.MONDAY, "Alivia", 21);
		store1.processAlcoholOrder("Vodka", Size.LARGE);
		assertEquals(15.1, store1.totalMonthlySale(), .001);
			
	}
	@Test 
	/**
	 * tests whether the number of orders were totaled correctly
	 */
	public void testTotalNumOfMonthlyOrders() {
		
		BevShop store1 = new BevShop();
		store1.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store1.processAlcoholOrder("Vodka", Size.SMALL);
		store1.processCoffeeOrder("Frappe", Size.SMALL, false, true);
		store1.processSmoothieOrder("Banana Smoothie", Size.LARGE, 5, true);
		store1.startNewOrder(9, Day.MONDAY, "Alivia", 21);
		store1.processAlcoholOrder("Vodka", Size.LARGE);
		assertEquals(2, store1.totalNumOfMonthlyOrders());
			
	}
	@Test 
	/**
	 * tests whether the current order is returned correctly
	 */
	public void testGetCurrentOrder() {
		
		BevShop store1 = new BevShop();
		store1.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store1.processAlcoholOrder("Vodka", Size.SMALL);
		store1.processCoffeeOrder("Frappe", Size.SMALL, false, true);
		store1.processSmoothieOrder("Banana Smoothie", Size.LARGE, 5, true);
		store1.startNewOrder(9, Day.MONDAY, "Al", 2);
		store1.processAlcoholOrder("Vodka", Size.LARGE);
		assertEquals(9, store1.getCurrentOrder().getOrderTime());
		assertEquals(Day.MONDAY, store1.getCurrentOrder().getOrderDay());
		assertEquals("Al", store1.getCurrentOrder().getCustomer().getName());
		assertEquals(2, store1.getCurrentOrder().getCustomer().getAge());
			
	}
	@Test 
	/**
	 * tests whether the order at index is returned correctly
	 */
	public void testGetOrderAtIndex() {
		
		BevShop store1 = new BevShop();
		store1.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store1.startNewOrder(9, Day.MONDAY, "Al", 2);
		store1.startNewOrder(9, Day.SATURDAY, "Ali", 24);
		store1.startNewOrder(9, Day.MONDAY, "Alvin", 12);
		assertEquals(24, store1.getOrderAtIndex(2).getCustomer().getAge());
		assertEquals("Alivia", store1.getOrderAtIndex(0).getCustomer().getName());
		assertEquals(Day.MONDAY, store1.getOrderAtIndex(3).getOrderDay());
		
			
	}
	@Test 
	/**
	 * tests whether the order at index is returned correctly
	 */
	public void testSortOrders() {
		
		BevShop store1 = new BevShop();
		store1.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store1.startNewOrder(9, Day.MONDAY, "Al", 2);
		store1.startNewOrder(9, Day.SATURDAY, "Ali", 24);
		store1.startNewOrder(9, Day.MONDAY, "Alvin", 12);
		
		int temp = store1.getOrderAtIndex(0).getOrderNo();
		
		store1.sortOrders();
		
		assertFalse(temp == store1.getOrderAtIndex(0).getOrderNo());//Will return correctly only when the first order is bigger than the other
			
	}
	@Test 
	/**
	 * tests whether the string is returned correctly
	 */
	public void testToString() {
		
		BevShop store1 = new BevShop();
		store1.startNewOrder(9, Day.SUNDAY, "Alivia", 21);
		store1.processAlcoholOrder("Vodka", Size.SMALL);
		store1.processCoffeeOrder("Frappe", Size.SMALL, false, true);
		store1.processSmoothieOrder("Banana Smoothie", Size.LARGE, 5, true);
		store1.startNewOrder(9, Day.MONDAY, "Al", 2);
		store1.processCoffeeOrder("Frappe", Size.SMALL, false, true);
		
		String str = "Total Monthly Sale: " + store1.totalMonthlySale() + "\n" +
					 "Total Number of Orders: " + store1.totalNumOfMonthlyOrders() + "\n" +
					 store1.getOrderAtIndex(0).toString() + "\n" +
					 store1.getOrderAtIndex(1).toString() + "\n";
		assertEquals(str, store1.toString());
		
			
	}
	
	
}
