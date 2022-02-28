package RRPSS;

import java.util.Scanner;

/**
 * Represents a menu item object in the Menu.
 * @author Hans Farrell Soegeng
 *
 */
public abstract class MenuItem {
	//class diagram can remove MenuItem(), getSales()
	//Main Course[0], Drinks[1], desert[2], promotion[3]
	//public enum Category{MAINCOURSE, DRINKS, DESSERT, PROMOTIONSET};
	/**
	 * The price of the dish.
	 */
	protected double price = 0;
	
	/**
	 * The name of the dish.
	 */
	protected String name;
	
	/**
	 * The description of the dish.
	 */
	protected String description;
	
	/**
	 * The category the dish belongs to.
	 */
	protected String category;
	
	/**
	 * Gets the category of the dish.
	 * @return category.
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Gets the price of the dish.
	 * @return price.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Gets the name of the dish.
	 * @return name.
	 */
	public String getMenuItemName() {
		return name;
	}
	
	/**
	 * Gets the description of the dish.
	 * @return description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Changes an information of the dish.
	 */
	public void editMenuItem(){
		System.out.println("=== Which part of the item would you like to edit? ===");
		System.out.println("|1. Name                                             |");
		System.out.println("|2. Price                                            |");
		System.out.println("|3. Description                                      |");
		System.out.println("======================================================");
		
		int choice = Exception.getInteger();
		
		//confirm that integer is within range
		while(choice < 1 || choice > 3)
		{
			System.out.print("Input value out of range. Please try again: ");
			choice = Exception.getInteger();
			
			System.out.println("=== Which part of the item would you like to edit? ===");
			System.out.println("|1. Name                                             |");
			System.out.println("|2. Price                                            |");
			System.out.println("|3. Description                                      |");
			System.out.println("======================================================");
		}
		
		//String dummy = sc.nextLine(); //to get rid of input buffer
		switch(choice) {
		case 1: System.out.println("Enter New Name: ");
				this.name = Exception.getString();
				break;
		case 2: System.out.println("Enter New Price: ");
				this.price = Exception.getDouble();
				break;
		case 3: System.out.println("Enter New Description: ");
				this.description = Exception.getString();
				break;	
		}//edits the menu item
	}
	
	/**
	 * Prints out the information of the dish.
	 */
	public void printMenuItem() {
		System.out.printf("%-30s $%.2f%n", name,price);
		System.out.println(description);
	}
	
	/**
	 * Prints out the name and price of the dish.
	 */
	public void printNameAndPrice() {
		System.out.printf("%-30s $%.2f%n\n", name,price);
	}

}