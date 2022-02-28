package RRPSS;

/**
 * Represents the menu items in the Dessert category.
 * @author Hans Farrell Soegeng
 *
 */
public class Dessert extends MenuItem{
	

	/**
	 * Creates a new menu item in the Dessert category.
	 * @param price The price of the dish.
	 * @param name The name of the dish.
	 * @param description The description of the dish.
	 */
	public Dessert (double price, String name, String description) { //Creates a menu item
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = "Dessert";
	}	
}
