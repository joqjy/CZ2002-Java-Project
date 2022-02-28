package RRPSS;

/**
 * Represents menu items in the Promotion Set category.
 * @author Hans Farrell Soegeng
 *
 */
public class PromotionSet extends MenuItem{

	/**
	 * Creates a new menu item in the Promotion Set category
	 * @param price The price of the dish.
	 * @param name The name of the dish.
	 * @param description The description of the dish.
	 */
	public PromotionSet (double price, String name, String description) { //Creates a menu item
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = "Promotion Set";
	}
	
}
