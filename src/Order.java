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
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	
	//Fields
	private static final int MIN_ORDER_NUM = 10000;//minimum order number generation
	private static final int MAX_ORDER_NUM = 90000;//maximum order number generation
	
	private int orderNo;//order number
	private int orderTime;//order time
	private Day orderDay;//order day
	private Customer cust;//customer
	private ArrayList<Beverage> beverages;//array list that holds beverages
	private boolean weekend;//determines whether it is the weekend or not
	
	//Constructor
	public Order (int orderTime, Day orderDay, Customer cust) {
		
		this.orderNo = generateOrder();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		this.beverages = new ArrayList<>();
		this.weekend = isWeekend();
		
		
		
	}
	
	//Methods
	/**
	 * Automatically generate order number
	 * @return a random order number between 10000 and 90000
	 */
	public int generateOrder() {
		
		Random rand = new Random();
		return (rand.nextInt(MAX_ORDER_NUM - MIN_ORDER_NUM + 1) + MIN_ORDER_NUM);
		
	}
	/**
	 * returns the order number
	 * @return order number
	 */
	public int getOrderNo() {
		return orderNo;
	}
	/**
	 * returns the order time
	 * @return order time
	 */
	public int getOrderTime() {
		return orderTime;
	}
	/**
	 * returns the order  day
	 * @return order  day
	 */
	public Day getOrderDay() {
		return orderDay;
	}
	/**
	 * 
	 * @return customer deep copy
	 */
	public Customer getCustomer() {
		return new Customer(cust);
	}
	/**
	 * @return true if the order day is 
	 * a weekend day (Saturday or Sunday)
	 */
	public boolean isWeekend() {
		return (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
	}
	
	/**
	 * returns the beverage listed in the itemNo of the order, 
	 * for example if itemNo is 0 this method will return the first
	 *  beverage in this order Note: this method returns the
	 *   shallow copy of the Beverage
	 *   @return the beverage listed in the itemNo of the 
	 *   order or null if there is no item in the order
	 */
	public Beverage getBeverage(int itemNo) {
		
		if (itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}else {
			return null;
		}
		
	}
	/**
	 * returns the total number of beverages ordered within this order
	 * @return the total number of beverages ordered within this order
	 */
	public int getTotalItems() {
		return beverages.size();
	}
	
	/**
	 * adds coffee order to this order
	 *@param bevName - beverage name
	 *@param size - beverage size
	 *@param extraShot - true if the coffee beverage 
	 *has extra shot , false otherwise
	 *@param  true if the coffee beverage 
	 *has extra syrup , false otherwise
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
		
	}
	/**
	 * adds alcohol order to this order
	 * @param bevName - beverage name
	 * @param size - beverage size
	 */
	public void  addNewBeverage(String bevName, Size size) {
		
		Alcohol alcohol = new Alcohol(bevName, size, this.weekend);
		beverages.add(alcohol);
		
	}
	/**
	 * Adds the Smoothie beverage to this order
	 *@param bevName - beverage name
	 *@param size - beverage size
	 *@param numOfFruits - number of fruits to be added
	 *@param addProtein - true if protein is added , false otherwise
	 */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
		
	}
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal() {
		
		double total = 0.0;
		for(Beverage beverage : beverages) {
			if(beverage.getType() == Type.COFFEE) {
				Coffee coffee = (Coffee) beverage;
				total += coffee.calcPrice();
			}else if(beverage.getType() == Type.ALCOHOL) {
				Alcohol alcohol = (Alcohol) beverage;
				total += alcohol.calcPrice();
			}else if(beverage.getType() == Type.SMOOTHIE) {
				Smoothie smoothie = (Smoothie) beverage;
				total += smoothie.calcPrice();
			}
		}
		return total;
	}
	
	/**
	 * returns the number of beverages of same type in an order
	 * @param type - the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(Type type) {
		
		int num = 0;
		for(Beverage beverage : beverages) {
			if (beverage.getType() == type) {
				
				num++;
				
			}
		}
		return num;
	}
	/**
	 * compare this order with another order based on the order number. 
	 * @return 0 if this order number is same as another order's order number,
	 *  1 if it is greater than another order's order number,
	 *  -1 if it smaller than another order's order number
	 */
	public int compareTo(Order anotherOrder) {
		
		return (Integer.compare(this.orderNo, anotherOrder.orderNo));
		
	}
	/**
	 * @return String representation of the order, Includes order number,
	 *  time , day, customer name and age and the list of beverages
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order No: ").append(orderNo).append("\n");
        sb.append("Time: ").append(orderTime).append("\n");
        sb.append("Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(cust.getName()).append("\n");
        sb.append("Age: ").append(cust.getAge()).append("\n");
        sb.append("Beverages:\n");
        for (Beverage beverage : beverages) {
            sb.append(beverage).append("\n");
        }
        return sb.toString();
	}
	
	
	
	
	
	
	
}
