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
import java.util.Scanner;
public class BevShopDriverApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean orderMore = false,//user wants to order more
				validDay = false,//day is valid
				orderAlcohol = false,//user wants to order more alcohol
				orderCoffee = false,//user wants to order more coffee
				orderSmoothie = false;//user wants to order more smoothies
		BevShop store = new BevShop();
		int time,//user inputs time
			age,//user inputs age
			fruits,//amount of fruits chosen by user
			orderNum = 1;//orders in order
		String name,//user inputs name
			   currentDay,//user inputs current day
			   continueOrdering;//user puts yes or y to continue ordering
		Day day = null;
		
		
		do {
			System.out.println("The current order in process can have at most 3 alcoholic beverages.");
			System.out.println("The minimum age to order alcohol drink is 21");
			System.out.println("Start please a new order:");
			
			System.out.println("Would you please enter the time?");
			time = keyboard.nextInt();
			keyboard.nextLine();
			do {
				if(!store.isValidTime(time)) {//checks if the time is between 8-23
					System.out.println("Enter a valid time from 8-23");
					time = keyboard.nextInt();
					keyboard.nextLine();
				}
			}while(!store.isValidTime(time));//do loop while the time is not valid
			
			while(!validDay){//checks for if the day is valid otherwise catches exception
				System.out.println("Would you please enter the day?");
				currentDay = keyboard.nextLine().toUpperCase();
				try {
					day = Day.valueOf(currentDay.toUpperCase());
					validDay = true;
				}catch(IllegalArgumentException e){
					System.out.println("Not a valid day");
				}
			}	
			validDay = false;
			System.out.println("Would you please enter your name?");
			name = keyboard.nextLine();
			
			System.out.println("Would you please enter your age?");
			age = keyboard.nextInt();
			keyboard.nextLine();
			
			if (store.isValidAge(age)) {//checks for if age is over 20 for alcoholic beverage
				System.out.println("Your age is above 20 and you are eligible to order alcohol");
			}else {
				System.out.println("Your age is not above 20 and you are not eligible to order alcohol");
			}
			store.startNewOrder(time, day, name, age);//adds an order from user input
			System.out.println("Your total order for now is " + store.getCurrentOrder().calcOrderTotal());
			
			//order alcohol
			if (store.isValidAge(age)) {//checks again for valid age
				do {
					System.out.println("Would you please add an alcohol drink");
					
					store.processAlcoholOrder("Vodka", Size.MEDIUM);
					
					System.out.println("The current order of drinks is " + store.getCurrentOrder().getTotalItems());
					
					System.out.println("The Total Price on the Order: " + store.getCurrentOrder().calcOrderTotal());
					
					System.out.println("Would you like to add another alcoholic drink?");
					continueOrdering = keyboard.nextLine();
					if (!store.isEligibleForMore()) {
						System.out.println("You have reached the maximum # of alcoholic drinks");
					}
					if(continueOrdering.equalsIgnoreCase("yes") || continueOrdering.equalsIgnoreCase("y")) {
						orderAlcohol = true;
					}else {
						orderAlcohol = false;
					}
				}while(store.isEligibleForMore() && orderAlcohol);//continues loop while user says yes and they are eligible for more alcoholic drinks
			}
			
			//order coffee
			do {
				System.out.println("Would you please add some coffee drinks");
				store.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
				
				System.out.println("The current order of drinks is " + store.getCurrentOrder().getTotalItems());
				
				System.out.println("The Total Price on the Order: " + store.getCurrentOrder().calcOrderTotal());
				
				System.out.println("Would you like to add more coffee drinks?");
				continueOrdering = keyboard.nextLine();
	
				if(continueOrdering.equalsIgnoreCase("yes") || continueOrdering.equalsIgnoreCase("y")) {
					orderCoffee = true;
				}else {
					orderCoffee = false;
				}
			}while(orderCoffee);//continues loop as long as user wants
			
			//Order Smoothies
			do {
				System.out.println("Would you please add some Smoothie drinks");
				System.out.println("Please add a number of fruits");
				fruits = keyboard.nextInt();
				keyboard.nextLine();
				while (store.isMaxFruit(fruits)) {
					System.out.println("The maximum number of fruits is 5");
					fruits = keyboard.nextInt();
					keyboard.nextLine();
				}
				store.processSmoothieOrder("Banana Smoothie", Size.LARGE, fruits, true);
				
				System.out.println("The current order of drinks is " + store.getCurrentOrder().getTotalItems());
				
				System.out.println("The Total Price on the Order: " + store.getCurrentOrder().calcOrderTotal());
				
				System.out.println("Would you like to add more Smoothie drinks?");
				continueOrdering = keyboard.nextLine();
	
				if(continueOrdering.equalsIgnoreCase("yes") || continueOrdering.equalsIgnoreCase("y")) {
					orderSmoothie = true;
				}else {
					orderSmoothie = false;
				}
			}while(orderSmoothie);//continues loop as long as user wants
			
			System.out.println("The total price on the " + orderNum + " order is: " + store.getOrderAtIndex(orderNum-1).calcOrderTotal());
			System.out.println("Would you like to add another order?");
			orderNum++;
			continueOrdering = keyboard.nextLine();
			//Checks if user would like to add more orders
			if(continueOrdering.equalsIgnoreCase("yes") || continueOrdering.equalsIgnoreCase("y")) {
				orderMore = true;
				System.out.println("#------------------------------------#");
			}else {
				orderMore = false;
			}
			
		}while(orderMore);
		
		System.out.println("Total amount of Orders: " + store.totalNumOfMonthlyOrders());
		System.out.println("Total amount for all Orders: " + store.totalMonthlySale());
		keyboard.close();
	}
}
