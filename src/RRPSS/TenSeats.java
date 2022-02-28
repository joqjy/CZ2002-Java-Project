package RRPSS;

/**
 * Represents a Table Class with TEN seats.
 * @author YANGY
 *
 */

public class TenSeats extends Table {
	
	/**
	 * Constructor which creates a Table with TEN seats.
	 *  @param tableNo this Table's number
	 */
	public TenSeats(int tableNo) {
		super(tableNo);
		seats = 10;
	}	
}
