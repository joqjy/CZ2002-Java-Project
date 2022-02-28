package RRPSS;

import java.util.*;

/**
 * Stores the invoice information of every order object.
 * @author Hans Farrell Soegeng
 *
 */
public class OrderInvoice {
	
	/**
	 * The total price of the ordered items.
	 */
	protected double totalPrice = 0;
	
	/**
	 * Creates a new OrderInvoice object associated to the order.
	 */
	public OrderInvoice(){	
	}
	
	/**
	 * Prints out the items ordered with its quantity and total price.
	 * @param items The HashMap storing the information on ordered items.
	 * @param OrderID The unique identifier to every order.
	 * @param server The server serving the table.
	 */
	public void printOrder(Map<MenuItem, Integer> items,int OrderID, String server) {
		System.out.println("");
		System.out.println("Western Foodelicia Route 315");
		System.out.println("******************************");
		System.out.println("21 Nanyang Link, 637371");
		System.out.println("");
		System.out.println("Order No. \t" + OrderID);
		System.out.println("Served by \t" + server);
		System.out.println("==============================");
		for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
			System.out.printf("%-26s x%d\n",entry.getKey().getMenuItemName(), entry.getValue());
			//System.out.println(entry.getKey().getMenuItemName() + " x" + entry.getValue());
		}
		System.out.println("------------------------------");
		System.out.printf("Subtotal : $%.2f\n", totalPrice);
		System.out.println("==============================");
		System.out.println("");
	
	}
	
	/**
	 * Prints the tab after the order is completed according to the customer's membership status.
	 * @param items The HashMap storing the information on ordered items.
	 * @param OrderID The unique identifier to every order.
	 * @param server The server serving the table.
	 * @param member Boolean value representing customer's membership.
	 */
	public void printInvoice(Map<MenuItem, Integer> items,int OrderID, String server, boolean member) {
		Date now = new Date();
		System.out.println("");
		System.out.println("Western Foodelicia Route 315");
		System.out.println("*******************************");
		System.out.println("21 Nanyang Link, 637371");
		System.out.println("");
		System.out.println(now.toString());
		System.out.println("");
		System.out.println("Order No. \t" + OrderID);
		System.out.println("Served by \t" + server);
		System.out.println("=====================================");
		for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
			System.out.printf("%-27s x%d $%.2f\n",entry.getKey().getMenuItemName(), entry.getValue(), entry.getKey().getPrice()*entry.getValue());
			//System.out.println(entry.getKey().getMenuItemName()  + " x" + entry.getValue());
		}
		System.out.println("-------------------------------------");
		System.out.printf("%-18s $%.2f\n", "Subtotal : ",totalPrice);
		if(member) {
			System.out.printf("%-18s $%.2f \n", "Member Discount : ", 0.1*totalPrice);
			totalPrice*=0.9;
		}
		System.out.printf("%-18s $%.2f\n","GST : ", 0.07*totalPrice);
		System.out.printf("%-18s $%.2f\n", "Service Charge : ", 0.1*0.07*totalPrice);
		System.out.println("-------------------------------------");
		System.out.printf("%-18s $%.2f\n","TOTAL : ", 1.07*1.10*totalPrice);
		System.out.println("");
		System.out.println("=====================================");
		System.out.println("Thank you for dining with us!");
		System.out.println("");
		totalPrice*=1.07;
		totalPrice*=1.10;
	}
	
	/**
	 * Gets the total price of the order.
	 * @return totalPrice The total price.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

}