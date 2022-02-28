package RRPSS;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Entails the Reservation created for a table.
 * ONLY one Reservation per table.
 * @author YANGY
 *
 */

public class Reservation {
	/**
	 * The boolean for Reservation status of the table.
	 */
	private boolean isReserved = false;
	/**
	 * Formatter to print out the required date.
	 */
	SimpleDateFormat dateFormatter = new SimpleDateFormat("HHmm, MMMM d, yyyy");
	 /**
	  * The number of people within this Reservation.
	  */
	private int noPax;
	/**
	 * The date of this reservation.
	 */
	private Calendar reservationDate;
	/**
	 * Reservation Printer to print out details of this reservation.
	 */
	private ReservationPrinter reservationPrinter = new ReservationPrinter();
	/**
	 * Reservation Checker to determine if this reservation is valid.
	 */
	private ReservationChecker reservationChecker = new ReservationChecker();
	/**
	 * Name of customer who reserved this reservation.
	 */
	private String customerName;
	/**
	 * Contact number of customer who reserved this reservation.
	 */
	private int customerNumber;
	
	/**
	 * Default Constructor of Reservation.
	 * No parameters reside within as Reservation does not exist
	 * when booting up RRPSS.
	 */
	public Reservation() {
	}
	
	//method to test for expired reservation
	//method to show non-expired reservation
	/*public void DummyReservation() {
		this.reservationDate = Calendar.getInstance();
		
		//change second parameter to -1 to show expired reservation
		this.reservationDate.add(Calendar.HOUR_OF_DAY, -1);
		this.customerName = "Tom";
		this.customerNumber = 90091919;
		isReserved = true;
	}*/
	
	//method to test for full reservation
	/*public void Dummy_Reservation() {
		this.reservationDate = Calendar.getInstance();
		this.reservationDate.add(Calendar.HOUR_OF_DAY, 1);
		this.customerName = "Sarah";
		this.customerNumber = 91234567;
		isReserved = true;
	}*/
	/**
	 * Method to create reservation for a table.
	 * @param noPax This Reservation's number of customers
	 */
	public void ReserveTable(int noPax) {
		System.out.println("");
		System.out.println("=========== Time of Reservation? ==========");
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);     
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    
	    cal.add(Calendar.HOUR_OF_DAY, 1 );
	    
	   	cal.set(Calendar.MINUTE, 0);
	   	
	  
		for (int i = 1;i<= 7;i++) {
			  if (cal.get(Calendar.HOUR_OF_DAY) == 23) break;
			  
			  Date dates = cal.getTime();
			  System.out.println("|" + i +".Available Dates: "+dateFormatter.format(dates)+"|");
			  cal.add(Calendar.MINUTE, 30 );
		}
		
		System.out.println("===========================================");
		int c = Exception.getInteger();
		
		int minute = 0;
		minute = minute + ((c - 1)*30);
		
		this.noPax = noPax;
		
		System.out.println("Name of Customer?:");
		customerName = Exception.getString();
		
		System.out.println("Customer Contact?:");
		customerNumber = Exception.getContact();
		
		isReserved = true;
		
		this.reservationDate = new GregorianCalendar(year, month, day, hour + 1, minute);
		System.out.println("Reservation Date: "+reservationDate.getTime());
	}
	/**
	 * Method to get the status of Reservation
	 * Whether it is reserved or not.
	 * @return this Reservation's status.
	 */
	//get methods
	public boolean getReservedStatus() {
		return isReserved;
	}
	/**
	 * Method to get the date of Reservation.
	 * @return this Reservation's date.
	 */
	public Calendar getReservationDate() {
		return this.reservationDate;
	}
	/**
	 * Method to get the number of customers for the  Reservation.
	 * @return this Reservation's number of customers.
	 */
	public int getReservationPax() {
		return noPax;
	}
	
	//method to test for full restaurant but there are unseated tables
	/*public boolean getIsAvailable() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.MINUTE, 90 );
		return reservationDate.after(currentDate);
	}*/
	/**
	 * Method to change Reservation status to false
	 * thereby canceling the reservation.
	 */
	public void cancelReservation() {
		isReserved = false;
	} 
	/**
	 * Method to check whether reservation is still valid
	 * against the current time.
	 */
	public void checkReservationValid() {
		if (reservationChecker.checkReservation(reservationDate)) {
			System.out.println("The following reservation has been cancelled");
			displayReservationDetails();
			cancelReservation();	
		}
	}
	/**
	 * Method to display the reservation details
	 * such as the customer's name, contact number,
	 * how many people within the reservation and it's date.
	 */
	public void displayReservationDetails() {
		reservationPrinter.printReservationDetails(customerName, customerNumber, noPax, reservationDate);
	}
	/**
	 * Method to print out the Name of the customer
	 * who reserved the table.
	 */
	public void displayCustomerName() {
		reservationPrinter.printCustomerName(customerName);
	} 
}
