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
public class Smoothie extends Beverage{

	//Fields
	private int numOfFruits;
	private boolean addProtein;
	private final double FRUIT_COST = 0.5;
	private final double PROTEIN_COST = 1.5;	
	
	//Constructor
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein; 
		
	}
	
	//Methods
	/**
	 * return number of fruits
	 * @return number of fruits
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}
	/**
	 * Indicates whether or not protein is added
	 * @return whether or not protein is added
	 */
	public boolean getAddProtein() {
		return addProtein;
	}
	
	/**
	 * calculates and returns the alcohol
	 *  beverage price return price of alcohol beverage
	 * @return price of alcohol beverage
	 */
	@Override
	public double calcPrice() {
		double price = super.addSizePrice();;
		price += (numOfFruits * FRUIT_COST);
		if(addProtein) {
			price += PROTEIN_COST;
		}
		return price;
		
	}
	/**
	 * checks if this Beverage equals to anotherBev
	 * @return true if the name, type, size and base price, 
	 * number of Fruits and add protein are the same, false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Smoothie smoothie = (Smoothie)anotherBev;
		return (super.equals(anotherBev) && numOfFruits == smoothie.numOfFruits &&
				addProtein == smoothie.addProtein);
	}
	/**
	 * returns the string representation of a
	 *  Smoothie drink. Contains the name , size, whether 
	 * or not protein added , number of fruits and price
	 * @return the string representation of a Smoothie drink.
	 */
	@Override 
	public String toString() {
		return (super.toString() + "," + numOfFruits + "," + addProtein + "," + calcPrice());
	}

}
