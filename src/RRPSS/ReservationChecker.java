package RRPSS;

import java.util.Calendar;

/**
 * Used to Check whether the reservation is still valid.
 * @author YANGY
 *
 */
public class ReservationChecker {
	/**
	 * Method to check if reservation Date is still valid against
	 * the current time.
	 * @param reservationDate This Reservation's date
	 * @return boolean of whether reservation is still valid or not.
	 */
	public boolean checkReservation(Calendar reservationDate) {
		Calendar currentDate = Calendar.getInstance();
		reservationDate.add(Calendar.MINUTE, 45 );
		if(currentDate.after(reservationDate)) {
			reservationDate.add(Calendar.MINUTE, -45 );
			return true; //returns true if time now is after reservation
			
		}
		else {
			reservationDate.add(Calendar.MINUTE, -45 );
			return false;
		}
	}
}