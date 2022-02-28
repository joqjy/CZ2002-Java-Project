package RRPSS;

import java.util.*;

/**
 * Stores the order details of each table.
 * @author Hans Farrell Soegeng
 *
 */
public class Order {
	/**
	 * The unique identifier number to every order.
	 */
	public int OrderID;
	
	/**
	 * HashMap representing items and the quantity ordered for the table.
	 * Maps a MenuItem to its order quantity.
	 */
	private Map<MenuItem, Integer> items;

	/**
	 * Creates an OrderInvoice object associated to this order.
	 */
	private OrderInvoice invoice = new OrderInvoice();
	
	/**
	 * The server serving the table for the order.
	 */
	private String server;
	
	/**
	 * Creates a new Order for the associated table.
	 * @param OrderID This order's unique order ID.
	 * @param server This order's server.
	 */
	public Order (int OrderID, String server) {
		this.OrderID = OrderID;
		this.server = server;
		items = new HashMap<MenuItem, Integer>();
	}
	
	/**
	 * Gets the HashMap representing items and the quantity ordered for the table.
	 * @return items This HashMap.
	 */
	public Map<MenuItem, Integer> getItems() {
		return items;
	}
	
	/**
	 * Adds a MenuItem and its order quantity to the order.
	 * Adds the price multiplied by the order quantity to the totalPrice
	 * instance in the associated OrderInvoice object.
	 * @param item The MenuItem to be ordered.
	 * @param quantity The order quantity of the MenuItem.
	 */
	public void addItem(MenuItem item, int quantity) {
		if(quantity<=0) {
			return;
		}
		if(items.containsKey(item)) {
			items.replace(item, items.get(item) + quantity);
		}
		else {
			items.putIfAbsent(item, quantity);
		}
		invoice.totalPrice += item.getPrice() * quantity;
	}
	
	/**
	 * Decreases the order quantity of an ordered MenuItem.
	 * Decreases the price multiplied by the quantity from the totalPrice
	 * instance in the associated OrderInvoice object.
	 * @param item The ordered MenuItem.
	 * @param quantity The quantity to be removed.
	 */
	public void removeItem(MenuItem item, int quantity) {
		if(items.containsKey(item)) {
			if(items.get(item)>quantity) {
				items.replace(item, items.get(item) - quantity);
				invoice.totalPrice -= item.getPrice() * quantity;
				return;
			}
			else { //when quantity to remove is greater than or equal to existing quantity
				invoice.totalPrice -= item.getPrice() * items.get(item);
				items.remove(item); //delete
			}
		}
		else {
			System.out.println("Item not ordered");
		}
	}
	
	/**
	 * Prints out the order details for the table.
	 */
	public void printOrder() {
		invoice.printOrder(items, OrderID, server);
	}
	
	/**
	 * Asks user input for membership.
	 * Prints out the invoice for the table according to the membership status.
	 */
	public void printInvoice() {
		System.out.println("Are you a member? (true/false)");
		boolean member = Exception.getBoolean();
		invoice.printInvoice(items, OrderID, server,member);
	}
	
	/**
	 * Takes in the order for the table.
	 * This edits the order items and is able to print out the order details.
	 * @param menu The Menu object the order is based on.
	 */
	public void takeOrder(Menu menu) { //pass in the menu
		Scanner sc = new Scanner(System.in);
		System.out.println("Take Order\n"
				+ "1.Add Order\n"
				+ "2.Remove Order\n"
				+ "3.Print Order\n"
				+ "4.Done");
		
		int i = Exception.getInteger();
		
		while(i!=4) {
			if(i < 1 || i > 4)
			{
				System.out.println("Input value out of range! Please choose again:");
			}
			switch(i) {
			case 1:
				menu.viewMenu();
				System.out.println("What category?");
				int category = sc.nextInt();
				System.out.println("Which item?");
				int item = sc.nextInt();		
				System.out.println("How many?");
				int quantity = sc.nextInt();
				MenuItem menuItem = menu.getMenu().get(category).get(item);
				addItem(menuItem,quantity);
				break;
			case 2:
				//print the OrderList			
				for(int row=0;row<menu.getMenu().size();row++) {
					for(int col=0;col<menu.getMenu().get(row).size();col++) {
						if(items.containsKey(menu.getMenu().get(row).get(col))) {
							System.out.println(row + "." + col + " " + menu.getMenu().get(row).get(col).getMenuItemName());
						}
					}
				}
				System.out.println("What category?");
				int catToRemove = sc.nextInt();
				System.out.println("Which item?");
				int itemToRemove = sc.nextInt();		
				System.out.println("How many?");
				int quantityToRemove = sc.nextInt();
				MenuItem menuItemToRemove = menu.getMenu().get(catToRemove).get(itemToRemove);
				removeItem(menuItemToRemove,quantityToRemove);
				break;
			case 3:
				printOrder();
				break;
			default:
				break;
			}
			System.out.println("Take Order\n"
					+ "1.Add Order\n"
					+ "2.Remove Order\n"
					+ "3.Print Order\n"
					+ "4.Done");
		
			//i = sc.nextInt();
			//test exception
			i = Exception.getInteger();
		}
	}
	
	/**
	 * Gets the total price of the order.
	 * @return this price.
	 */
	public double getTotalPrice() {
		return invoice.getTotalPrice();
	}
	
}