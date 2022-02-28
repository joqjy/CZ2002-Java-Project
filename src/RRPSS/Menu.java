package RRPSS;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * Represents the collection of menu items available in the restaurant.
 * @author Hans Farrell Soegeng
 *
 */
public class Menu {
	
	/**
	 * 2D ArrayList storing the collection of MenuItem.
	 */
	private ArrayList<ArrayList<MenuItem>> NewMenu_;
	
	/**
	 * The menu updater functionality class associated with the menu.
	 */
	private MenuUpdater menuUpdater;
	
	//Menu ArrayList where each row represents the category of the different dishes
	/**
	 * Initializes the default menu of the restaurant,
	 * creating the default menu items and storing it in the 2D ArrayList.
	 */
	public Menu() {
		NewMenu_ = new ArrayList<>(4);
		
		 //initializes 4 rows
		for(int i=0;i<4;i++) {
			NewMenu_.add(new ArrayList<>());
		}
		
		// Row 1 would be the main courses
		NewMenu_.get(0).add(new MainCourse(12.95,"Burger","A Delicious Beef Burger\n"));
		NewMenu_.get(0).add(new MainCourse(9.95,"Chicken Chop","A Slab of Chicken\n"));
		NewMenu_.get(0).add(new MainCourse(10.95,"Pork Chop ","A Slab of Pork\n" ));
		NewMenu_.get(0).add(new MainCourse(12.95,"Lamb Chop","A Lamb Chop\n"));
		NewMenu_.get(0).add(new MainCourse(8.95,"Spaghetti","Spaghetti and Meatballs\n"));
		
		// Row 2 would be the Drinks
		NewMenu_.get(1).add(new Drinks(2.95,"Coke","Original Flavoured Coca Cola\n"));
		NewMenu_.get(1).add(new Drinks(2.55,"Coke Zero","Coca Cola with Zero Sugar\n"));
		NewMenu_.get(1).add(new Drinks(2.95,"Coke Less Sugar","Coca Cola with Less Sugar\n"));
		NewMenu_.get(1).add(new Drinks(2.50,"Green Tea","Jasmine Green Tea (Pokka)\n"));
		NewMenu_.get(1).add(new Drinks(2.40,"Plain Water","The Healthiest Choice\n"));
		
		//Row 3 would be the Dessert
		NewMenu_.get(2).add(new Dessert(7.95,"Vanilla Ice Cream","Vanilla Flavoured Ice Cream with White Chocolate Chips\n"));
		NewMenu_.get(2).add(new Dessert(7.95,"Chocolate Ice Cream","Chocolate Flavoured Ice Cream with Chocolate Chips\n"));
		NewMenu_.get(2).add(new Dessert(6.95,"Strawberry Ice Cream","Strawberry Ice Cream with Strawberries\n"));
		NewMenu_.get(2).add(new Dessert(6.95,"Mint Ice Cream","Mint Ice Cream with Chocolate Chips\n"));
		NewMenu_.get(2).add(new Dessert(8.95,"Mango Ice Cream","Mango Ice Cream with Dried Mangos\n"));
		
		//Row 4 would be the promotion items
		NewMenu_.get(3).add(new PromotionSet(14.95,"Promotion Set:Burger","A Delicious Beef Burger served with French Fries and Coleslaw\n"));
		NewMenu_.get(3).add(new PromotionSet(11.95,"Promotion Set:Chicken Chop","A Slab of Chicken served with French Fries and Coleslaw\n"));
		NewMenu_.get(3).add(new PromotionSet(12.95,"Promotion Set:Pork Chop ","A Slab of Pork served with French Fries and Coleslaw\n"));
		NewMenu_.get(3).add(new PromotionSet(14.95,"Promotion Set:Lamb Chop","A Lamb Chop served with French Fries and Coleslaw\n"));
		NewMenu_.get(3).add(new PromotionSet(10.95,"Promotion Set:Spaghetti","Spaghetti and Meatballs with French Fries and Coleslaw\n"));
	}
	
	/**
	 * Gets the 2D ArrayList storing the menu items collection.
	 * @return NewMenu_ The 2D ArrayList storing the menu items collection.
	 */
	public ArrayList<ArrayList<MenuItem>> getMenu() {
	       return NewMenu_;
	}
	
	/**
	 * Prints out all menu items and their information in the menu.
	 */
	public void viewMenu() {
		System.out.println("");
		System.out.println("                               MENU                                ");
		System.out.println("===================================================================");
		for(int i=0;i<4;i++) {
			System.out.println(NewMenu_.get(i).get(0).getCategory());
			for(int j=0;j<NewMenu_.get(i).size();j++) {
				System.out.print((i) + "." + (j) + ": ");
				NewMenu_.get(i).get(j).printMenuItem();
			}
			System.out.println("-------------------------------------------------------------------");
		}
	}
	
	/**
	 * Edits the menu with functionalities including
	 * adding a menu item to the menu,
	 * editing a menu item in the menu,
	 * removing a menu item from the menu,
	 * viewing the menu.
	 */
	public void editMenu() { //edits the menu itself (add, edit or remove stuff)
							//calls for menuUpdater
		MenuUpdater menuUpdater = new MenuUpdater();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======== Edit Menu =======");
		System.out.println("|1. Add Menu Item        |");
		System.out.println("|2. Edit Menu Item       |");
		System.out.println("|3. Remove Menu Item     |");
		System.out.println("|4. Print Menu           |");
		System.out.println("|5. Done                 |");
		System.out.println("==========================");
		
		int i = Exception.getInteger();
		
		while(i!=5) {
			if(i < 1 || i > 5)
			{
				System.out.println("Input out of range! please choose again:");
			}
			
			switch(i) {
			case 1:
				menuUpdater.addMenuItem(NewMenu_);
				break;
			case 2:
				menuUpdater.editMenuItem(NewMenu_);
				break;
			case 3:
				menuUpdater.removeMenuitem(NewMenu_);
				break;
			case 4:
				viewMenu();
				break;
			default:
				break;
			}
			
			System.out.println("======== Edit Menu =======");
			System.out.println("|1. Add Menu Item        |");
			System.out.println("|2. Edit Menu Item       |");
			System.out.println("|3. Remove Menu Item     |");
			System.out.println("|4. Print Menu           |");
			System.out.println("|5. Done                 |");
			System.out.println("==========================");
			
			i = Exception.getInteger();
		}
	}
	
	/**
	 * Gets the price of a menu item in the menu.
	 * @param i The category number of the menu item.
	 * @param j The item number of the menu item in the category.
	 * @return The price of the menu item.
	 */
	public double getPrice(int i, int j) { //gets price
		return NewMenu_.get(i).get(j).getPrice();
	}
	
	/**
	 * Prints out the name and price of a menu item in the menu.
	 * @param i The category number of the menu item.
	 * @param j The item number of the menu item in the category.
	 */
	public void printMenuItemAndPrice(int i, int j){
		NewMenu_.get(i).get(j).printNameAndPrice();
	}
	
	/**
	 * Gets the item number of a menu item in the category.
	 * @param i The category number of the menu item.
	 * @param name The name of the menu item.
	 * @return j The item number in the category, -1 if the item does not exist.
	 */
	public int getMenuItemIndex(int i, String name) { //get index of menu item using name
		for(int j=0;j<NewMenu_.get(i).size();j++) {
			if(NewMenu_.get(i).get(j).getMenuItemName() == name) {
				return j;
			}
		}
		System.out.println("Menu item does not exist");
		return -1;
	}
	
	/**
	 * Gets the name of the menu item in the menu.
	 * @param i The category number of the menu item.
	 * @param j The item number in the category.
	 * @return The name of the menu item.
	 */
	public String getMenuItemName(int i, int j) { //get menu item name from index 
												 //bc index always changes when menu is edited
		return NewMenu_.get(i).get(j).getMenuItemName();
	}


}
