package RRPSS;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Represents the total sales of the restaurant
 * on a single day.
 * salesRevenue can have multiple orders.
 * @author YANGY
 *
 */
public class salesRevenue {
	/**
	 * The Total amount accumulated by multiple Orders from this salesRevenue.
	 */
	private double totalRevenue;
	/**
	 * An Arraylist of Orders for this salesRevenue.
	 */
	private ArrayList<Order> orders = new ArrayList<>();
	/**
	 * HashMap containing the number of MenuItems ordered for this salesRevenue.
	 */
	private Map<MenuItem, Integer> consolidated = new HashMap<MenuItem, Integer>();
	/**
	 * This salesRevenue current day.
	 */
	Calendar cal = Calendar.getInstance();
	static int dummy=1;
	/**
	 * default constructor, no parameters
	 * as no sales are made when first booting up
	 * RRPSS.
	 */
    public salesRevenue() {
    }
    /**
     * Constructor to create a new salesRevenue for
     * the NEXT day.
     * @param a Used to determine when a day needs to be added.
     */
    public salesRevenue(int a) {
    	cal.add(Calendar.DAY_OF_MONTH, dummy++);
    }
    /**
     * Method which adds to the order ArrayList.
     * @param order The Order to be added to the orders ArrayList
     */
	public void addOrderToSales(Order order) {
		orders.add(order);
	}
	/**
	 * Method which gets this salesRevenue totalRevenue.
	 * @return this salesRevenue totalRevenue.
	 */
	public double getTotalRevenue() {
		for(int i=0; i<orders.size();i++) {
			totalRevenue += orders.get(i).getTotalPrice();
		}
		return totalRevenue;
	}
	/**
	 * Method which consolidates all the accumulated added Orders
	 * to prevent multiple of the same instances from showing.
	 */
	public void consolidate() {
		for(int i=0; i<orders.size();i++) {
			Map<MenuItem, Integer> indivOrder = orders.get(i).getItems();
			for (Map.Entry<MenuItem, Integer> entry : indivOrder.entrySet()) {
				if(consolidated.containsKey(entry.getKey())) {
					int newQty = entry.getValue()+consolidated.get(entry.getKey());
					consolidated.replace(entry.getKey(),newQty);
				}
				else consolidated.putIfAbsent(entry.getKey(),entry.getValue());
			}
		}
	}
	/**
	 * Method which gets the date for this salesRevenue.
	 */
	public void getDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
		Date dates = cal.getTime();
		System.out.println(dateFormatter.format(dates));
	}
	/**
	 * Method which prints out this salesRevenue
	 */
	public void printSalesRevenue() {
		consolidate();
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		System.out.println("");
	    System.out.println(dateFormatter.format(now));
		System.out.println("Sales Revenue Report" + "\n===========================\n");
		
		for(Map.Entry<MenuItem, Integer> indivItem : consolidated.entrySet()) {
				System.out.println(indivItem.getKey().getMenuItemName() + " x " + indivItem.getValue() + " = "
						+ indivItem.getKey().getPrice() * indivItem.getValue());
		}
		
		System.out.println("----------------------------");
		System.out.printf("Net Revenue = $%.2f \n", getTotalRevenue());
		System.out.println("\n===========================\n");
		System.out.println("");
	}	
}