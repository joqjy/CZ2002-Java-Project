package RRPSS;

/**
 * Represents a Table Class with TWO seats.
 * @author YANGY
 *
 */
public class TwoSeats extends Table{
	/**
	 * Constructor which creates a Table with TWO seats.
	 *  @param tableNo this Table's number
	 */
	public TwoSeats(int tableNo) {
		super(tableNo);
		seats = 2;
	}
}
