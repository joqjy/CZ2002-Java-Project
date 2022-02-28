package RRPSS;

/**
 * Represents menu items in the Drinks category.
 * @author Hans Farrell Soegeng
 *
 */
public class Drinks extends MenuItem{
	

	/**
	 * Creates a new menu item in the Drinks category.
	 * @param price The price of the dish.
	 * @param name The name of the dish.
	 * @param description The description of the dish.
	 */
	public Drinks(double price, String name, String description) { //Creates a menu item
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = "Drinks";
	}

}
