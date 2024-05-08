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
import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	
	private ArrayList<Order> orders = new ArrayList<>();
	private static final int MIN_AGE_FOR_ALCOHOL = 21;//minimum age for alcohol
	private static final int MAX_ORDER_FOR_ALCOHOL = 3;//maximum age for alcohol
	private static final int MIN_TIME = 8;//minimum time
	private static final int MAX_TIME = 23;//maximum time
	private static final int MAX_FRUIT = 5;//max fruits added to smoothies
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean isValidTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}
	
	/**
	 * @return maximum number of fruits to smoothies
	 */
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	/**
	 * @return minimum age for alcoholic drinks
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * @param numOfFruits is the number of fruits
	 * @return true if numOfFruits exceeds the maximum amount
	 */
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}
	
	/**
	 * @return maximum orders for alcoholic drinks
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * returns the number of alcohol drinks for the current order
	 * @return returns the number of alcohol drinks for the current order
	 */
	public int getNumOfAlcoholDrink() {
		
		if (orders.isEmpty()) {
			return 0;
		}
		Order currentOrder = orders.get(orders.size()-1);
		return currentOrder.findNumOfBeveType(Type.ALCOHOL);
			
	}
	
	/**
	 * checks if the number of alcohol beverages 
	 * for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order 
	 * has reached the maximum , false otherwise
	 */
	public boolean isEligibleForMore() {
		return (getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL);
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age - the age
	 * @return returns true if age is more than
	 *  minimum eligible age , false otherwise
	 */
	public boolean isValidAge(int age) {
		return (age >= MIN_AGE_FOR_ALCOHOL);
	}
	
	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 *@param time - time of the order
	 *@param day - day of the order of type DAY
	 *@param customerName - customer name
	 *@param customerAge - customer age
	 */
	public void startNewOrder(int time, Day day, String name, int age) {
		
		Order newOrder = new Order(time, day, new Customer(name, age));
		orders.add(newOrder);
	}
	
	/**
	 * process the Coffee order for the 
	 * current order by adding it to the current order
	 *@param bevName - beverage name
	 *@param size - beverage size
	 *@param extraShot - true if the coffee beverage 
	 *has extra shot , false otherwise
	 *@param  true if the coffee beverage 
	 *has extra syrup , false otherwise
	 * 
	 */
	public void processCoffeeOrder(String bevName, Size size, 
			boolean extraShot, boolean extraSyrup) {
		
		if (!orders.isEmpty()) {
			Order currentOrder = orders.get(orders.size() - 1);
			currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		}
		
	}
	
	/**
	 * process the Alcohol order for the
	 *  current order by adding it to the current order
	 *  @param bevName - beverage name
	 *  @param size - beverage size
	 */
	public void processAlcoholOrder(String bevName, Size size) {
		
		if (!orders.isEmpty()) {
			Order currentOrder = orders.get(orders.size() - 1);
			currentOrder.addNewBeverage(bevName, size);
		}
		
	}
	
	/**
	 * process the Smoothie order for the 
	 * current order by adding it to the current order
	 *@param bevName - beverage name
	 *@param size - beverage size
	 *@param numOfFruits - number of fruits to be added
	 *@param addProtein - true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, Size size, 
			int numOfFruits, boolean addProtein) {
		
		if (!orders.isEmpty()) {
			Order currentOrder = orders.get(orders.size() - 1);
			currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
		}
		
	}
	
	/**
	 * locate an order based on the order number
	 * @param orderNo - the order number
	 * @return the index of the order in the list 
	 * of Orders if found or -1 if not found
	 */
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1; 
	}
	
	/**
	 * locates an order in the list of orders 
	 * and returns the total value on the order.
	 * @param orderNo - the order number
	 * @return the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
		
		int index = findOrder(orderNo);
		if(index!= -1) {
			Order order = orders.get(index);
			double total = 0.0;
			total = order.calcOrderTotal();
			return total;
		}
		return 0.0;
	}
	
	/**
	 * Calculates the total sale of all 
	 * the orders for this beverage shop
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
		double totalSale = 0;
		for (Order order : orders) {
			totalSale += order.calcOrderTotal();
		}
		return totalSale;
	}
	
	/**
	 * returns total numbers of orders within the month
	 * @return total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	/**
	 * returns the current Order located 
	 * in the index in the list of orders.
	 *  Notes: this method returns the shallow copy of the order
	 *  @return shallow copy of the current order
	 */
	public Order getCurrentOrder() {
		return orders.get(orders.size()-1);
	}
	
	/**
	 * returns Order in the list of orders at the index Notes: 
	 * this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	/**
	 * sorts the orders by orders numbers
	 *  within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders() {
		
		for(int i = 0; i < orders.size()-1;i++) {
			int index = i;
			for (int j = i+1; j < orders.size()-1; j++) {
				if(orders.get(j).getOrderNo() < orders.get(index).getOrderNo()) {
					index = j;
				}
			}
			
			Order temp = orders.get(index);
			orders.set(index, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	/**
	 * returns the string representation 
	 * of all the orders and the total monthly sale
	 * @return returns the information of all the orders
	 */
	@Override
	public String toString() {
        
		StringBuilder builder = new StringBuilder();
	    builder.append("Total Monthly Sale: ").append(totalMonthlySale()).append("\n");
	    builder.append("Total Number of Orders: ").append(totalNumOfMonthlyOrders()).append("\n");
	    for (Order order : orders) {
	            builder.append(order.toString()).append("\n");
	    }
	    return builder.toString();
    }
	
	
}
