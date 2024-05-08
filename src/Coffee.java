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
public class Coffee extends Beverage{
	
	//Fields
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRA_SHOT = 0.5;
	private final double EXTRA_SYRUP = 0.5;
	
	//Constructor
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;

	}
	
	//Methods
	/**
	 * Indicates whether or not extra shot is added
	 * @return extra shot
	 */
	public boolean getExtraShot() {
		return extraShot;
	}
	
	/**
	 * Indicates whether or not extra syrup is added
	 * @return extra syrup
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	/**
	 * Calculates the price based on base price,
	 *  size, extra coffee shot and extra syrup
	 *  @return the price of the coffee
	 */
	@Override
	public double calcPrice() {
		
		double price = super.addSizePrice();
		if (extraShot) {
			price += EXTRA_SHOT;
		}else {
			
		}
		if (extraSyrup) {
			price += EXTRA_SYRUP;
		}else {
			
		}
		return price;
		
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return true if the name, type, size and base price and
	 *  whether or not it contains extra shot and extra syrup false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Coffee coffee = (Coffee)anotherBev;
		return (super.equals(anotherBev) && extraShot == coffee.extraShot && 
				extraSyrup == coffee.extraSyrup);
	}
	
	/**
	 * Represents a Coffee beverage in the following String format:
	 *  name,size, whether it contains extra shot,
	 *   extra syrup and the price
	 *   @return String representation of a Coffee
	 */
	@Override 
	public String toString() {
		return (super.toString() + "," + extraShot + "," + extraSyrup + "," + calcPrice());
	}
	
}
