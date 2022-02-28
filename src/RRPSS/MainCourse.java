package RRPSS;

/**
 * Represents menu items in the Main Course category.
 * @author Hans Farrell Soegeng
 *
 */
public class MainCourse extends MenuItem {

	/**
	 * Creates a new menu item in the Main Course category.
	 * @param price The price of the dish.
	 * @param name the name of the dish.
	 * @param description The description of the dish.
	 */
	public MainCourse(double price, String name, String description) { //Creates a menu item
		this.price = price;
		this.name = name;
		this.description = description;
		this.category = "Main Course";
	}
	
}
