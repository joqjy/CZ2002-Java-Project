package RRPSS;

import java.util.*;

/**
 * Represents the menu updater functionality class for the menu.
 * @author Hans Farrell Soegeng
 *
 */
public class MenuUpdater {
	
	/**
	 * Adds a menu item to the menu.
	 * @param menu.
	 */
	public void addMenuItem(ArrayList<ArrayList<MenuItem>> menu) {
		System.out.println("======== Menu Categories ======");
		System.out.println("|0. Main Course               |");
		System.out.println("|1. Drinks                    |");
		System.out.println("|2. Desserts                  |");
		System.out.println("|3. Promotions                |");
		System.out.println("===============================");
		System.out.println("Please enter Category: ");

		int i = Exception.getInteger();
		
		while(i < 0 || i > 3)
		{
			System.out.println("Input value out of range! Please choose again: ");
			System.out.println("======== Menu Categories ======");
			System.out.println("|0. Main Course               |");
			System.out.println("|1. Drinks                    |");
			System.out.println("|2. Desserts                  |");
			System.out.println("|3. Promotions                |");
			System.out.println("===============================");
			System.out.println("Please enter Category: ");
			i = Exception.getInteger();
		}
		
		System.out.println("Enter price of dish:");
		double price = Exception.getDouble();
		System.out.println("Enter dish name:");
		//String dummy = sc.nextLine();
		String name = Exception.getString();
		System.out.println("Enter description of dish:");
		String description = Exception.getString(); 
		
		switch(i) {
			case 0:
				menu.get(i).add(new MainCourse(price,name,description)) ;
				break;
			case 1:
				menu.get(i).add(new Drinks(price,name,description));
				break;
			case 2:
				menu.get(i).add(new Dessert(price,name,description));
				break;
			case 3:
				menu.get(i).add(new PromotionSet(price,name,description));
				break;
			default: break;
		}
		System.out.println("Menu item added: " + name);
	}
	
	/**
	 * Select a menu item from the menu to be removed.
	 * @param menu.
	 */
	public void removeMenuitem(ArrayList<ArrayList<MenuItem>> menu) { //removes menu item
		System.out.println("======== Menu Categories ======");
		System.out.println("|0. Main Course               |");
		System.out.println("|1. Drinks                    |");
		System.out.println("|2. Desserts                  |");
		System.out.println("|3. Promotions                |");
		System.out.println("===============================");
		System.out.println("Please enter Category: ");
		
		int i = Exception.getInteger();
		while(i < 0 || i > 3)
		{
			System.out.println("Input value out of range! Please choose again: ");
			System.out.println("======== Menu Categories ======");
			System.out.println("|0. Main Course               |");
			System.out.println("|1. Drinks                    |");
			System.out.println("|2. Desserts                  |");
			System.out.println("|3. Promotions                |");
			System.out.println("===============================");
			System.out.println("Please enter Category: ");
			i = Exception.getInteger();
		}
		
		for(int j = 0;j<menu.get(i).size();j++) { //prints out every item in category
			System.out.print(j + ":");
			menu.get(i).get(j).printNameAndPrice();
		}
		if(menu.get(i).size()>0) {
			System.out.println("Which item?");
			
			//int j = sc.nextInt();
			//test exception handling
			int j = Exception.getInteger();
			
			while(j>=menu.get(i).size() || j<0) {
				System.out.println("Item selected out of range");
				j = Exception.getInteger();
			}
			menu.get(i).remove(j);
			System.out.println("Menu item removed");
		}
		else {
			System.out.println("No menu items in selected category");
		}
	}
	
	/**
	 * Select a menu item from the menu to be edited.
	 * @param menu.
	 */
	public void editMenuItem(ArrayList<ArrayList<MenuItem>> menu) { //Edits the menu item
		System.out.println("======== Menu Categories ======");
		System.out.println("|0. Main Course               |");
		System.out.println("|1. Drinks                    |");
		System.out.println("|2. Desserts                  |");
		System.out.println("|3. Promotions                |");
		System.out.println("|4. Complete Order            |");
		System.out.println("===============================");
		System.out.println("");
		System.out.println("Please enter Category");
		
		int i = Exception.getInteger();
		while(i < 0 || i > 3)
		{
			System.out.println("Input value out of range! Please choose again: ");
			System.out.println("======== Menu Categories ======");
			System.out.println("|0. Main Course               |");
			System.out.println("|1. Drinks                    |");
			System.out.println("|2. Desserts                  |");
			System.out.println("|3. Promotions                |");
			System.out.println("===============================");
			System.out.println("Please enter Category: ");
			i = Exception.getInteger();
		}
		
		for(int j = 0;j<menu.get(i).size();j++) { //prints out every item in category
			System.out.print(j + ":");
			menu.get(i).get(j).printNameAndPrice();
		}
		
		if(menu.get(i).size()>0) {
			System.out.println("Which item?");
			
			//int j = sc.nextInt(); //select specific menu item to edit
			//test exception handling
			int j = Exception.getInteger();
			
			if(j>menu.get(i).size() || j<0) {
				System.out.println("Item selected out of range");
				return;
			}
				menu.get(i).get(j).editMenuItem();
				System.out.println("Menu Item Edited");
		}
		else {
			System.out.println("No menu items in selected category");
		}
	}
}