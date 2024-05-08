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
import java.lang.Object;

public abstract class Beverage extends Object {
	
	//Fields
	private String bevName;//beverage name
	private Type type;//type in alcohol, coffee, or smoothie
	private Size size;//size in small, medium, or large
	protected final double BASE_PRICE = 2.0;//base price of drinks
	protected final double SIZE_PRICE = 0.5;//additional prices for sizes
	
	//Constructors
	public Beverage(String bevName, Type type, Size size) {
		
		this.bevName = bevName;
		this.type = type;
		this.size = size;
		
	}
	
	//Methods
	public abstract double calcPrice();
	
	/**
	 * 
	 * @return the base price
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * 
	 * @return the beverage name
	 */
	public String getBevName() {
		return bevName;
	}
	
	/**
	 * 
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}
	
	/**
	 * Calculates a new price by adding the size price to the base price. 
	 * There is no additional cost for small size, 
	 * for medium and large beverages the additional cost of size price is added to 
	 * base price For example if the base price is 2 and SIZE_PRICE is .5 then the 
	 * cost of small beverage is 2, the medium beverage is 2.5
	 * and the large beverage is 3.
	 * @return A new price that by adding the size price to the base price
	 */
	public double addSizePrice() {
		double newPrice = BASE_PRICE;
		if (size == Size.MEDIUM ) {
			newPrice += SIZE_PRICE;
		}else if (size == Size.LARGE) {
			newPrice += (SIZE_PRICE + SIZE_PRICE);
		}
		return newPrice;
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return the base price true if the name, type, size , false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Beverage beverage = (Beverage) anotherBev;
		return (bevName.equals(beverage.bevName) && type == beverage.type 
				&& size == beverage.size);
	}
	
	/**
	 * Represents a Beverage object in String with the format of bevName,size
	 * @return a String representation of beverage
	 */
	@Override 
	public String toString() {
		return (bevName + "," + size);
	}
	
	
}
