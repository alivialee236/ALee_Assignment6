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

public class Alcohol extends Beverage{
	
	private boolean isWeekend;//checks if it is the weekend
	private final double WEEKEND_PRICE = 0.6;//constant for additional weekend price
	
	//Constructor
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
		
	}
	
	//Methods
	
	/**
	 * checks for if it is the weekend
	 * @return true if it is the weekend
	 */
	public boolean isWeekend() {
		return isWeekend;
	}
	
	/**
	 * Calculates the price of the alcohol
	 * @return the price of an alcohol beverage
	 */
	@Override
	public double calcPrice() {
		
		double price = super.addSizePrice();
		if (isWeekend) {
			price += (WEEKEND_PRICE);
		}
		return price;
		
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return true if the name, type, size and base price and whether beverage 
	 * is offered in weekend or not are the same, false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Alcohol alcohol = (Alcohol)anotherBev;
		return (super.equals(anotherBev) && isWeekend == alcohol.isWeekend);
	}
	
	/**
	 * String representation of Alcohol beverage, includes the name, size, 
	 * whether or not beverage is offered in weekend and the price
	 * @return a string containing the information of an alcohol beverage
	 */
	@Override 
	public String toString() {
		return (super.toString() + "," + isWeekend + "," + calcPrice());
	}

}
