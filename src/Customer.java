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
public class Customer {

	//Fields
	private String name;
	private int age;
	
	//Constructors
	public Customer (String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public Customer (Customer c) {
		
		this.name = c.name;
		this.age = c.age;
		
	}
	
	//Methods
	
	/**
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * sets age
	 * @param age
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * String representation of the customer 
	 * includes the name and age of the customer.
	 * @return String containing the customer information
	 */
	@Override 
	public String toString() {
		return (name + "," + age);
	}
}
