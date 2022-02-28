package RRPSS;

import java.util.Calendar;

/**
 * Used to print out the details of the Reservation Class.
 * Each Reservation Class has only one Reservation Printer.
 * @author YANGY
 *
 */
public class ReservationPrinter {
	/**
	 * Prints out the full details of the reservation.
	 * @param customerName this Reservation's customer's name.
	 * @param customerNumber this Reservation's customer's number.
	 * @param noPax this Reservation's number of customers seated.
	 * @param reservationDate this Reservation's date.
	 */
	public void printReservationDetails(String customerName, int customerNumber, int noPax, Calendar reservationDate ) {
		System.out.println("");
		System.out.println("========================================");
		System.out.println("Customer name: "+ customerName + "\nContact Number: "+ customerNumber);
		System.out.println("Reservation Date: "+reservationDate.getTime());
		System.out.println("No. of Customers: "+ noPax);
		System.out.println("");
	}
	/**
	 * Prints out only the customer's name.
	 * @param customerName this reservation's customer's name.
	 */
	public void printCustomerName(String customerName) {
		System.out.println(" Customer name: "+ customerName );
	}
}