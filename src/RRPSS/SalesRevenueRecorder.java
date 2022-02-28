package RRPSS;

import java.util.*;

/**
 * Entails all the sales Revenue for the RRPSS.
 * Sales Revenue Recorder holds multiple instances
 * of salesRevenue.
 * Only one SalesRevenueRecorder per Restaurant.
 */
public class SalesRevenueRecorder {
	/**
	 * The ArrayList which will hold all
	 * instances of salesRevenue.
	 */
	private ArrayList<salesRevenue> records = new ArrayList<salesRevenue>();
	
	/**
	 * Method which returns the ArrayList of salesRevenue.
	 * @return this SalesRevenueRecorder's records.
	 */
	public ArrayList<salesRevenue> getRecords() {
		return records;
	}
	/**
	 * Method which adds salesRevenue to the records ArrayList.
	 * @param salesRev This records' new instance to be added.
	 */
	public void addToRecords(salesRevenue salesRev) {
		records.add(salesRev);
	}
	/**
	 * Method which prints out the salesRevenue
	 * for a selected date(which has passed).
	 */
	public void retrieveSales() {
		System.out.println("");
		System.out.println("List of Sales Revenue Report (By Day)");
		for(int i=0;i<records.size();i++) {
			System.out.print("|" + i + ": ");
			records.get(i).getDate();
		}
		System.out.println("");
		System.out.println("Which day would you like to retrieve?");
		int choice = Exception.getInteger();
		
		while(choice < 0 || choice >  records.size())
		{
			System.out.println("Input out of range! Please enter again:");
			choice = Exception.getInteger();
		}
		
		records.get(choice).printSalesRevenue();
	}
}

