package RRPSS;

/**
 * Represents the tables within the restaurant.
 * Table Class contains the Order and Reservation class.
 * Restaurant can have multiple tables, but only one table array.
 * @author YANGY
 *
 */


public abstract class Table {
	/**
	 *  The number assigned to this Table.
	 */
	protected int tableNo;
	/**
	 * The number of seats this Table has.
	 */
	protected int seats;
	
	/**
	 * The Order serial number assigned to this Table.
	 */
	public static int orderNo;
	
	/**
	 * The seated status of this Table, whether it is true or false.
	 */
	protected boolean seated = false;
	/**
	 * The reservation of this Table.
	 */
	private Reservation reservation = new Reservation();
	/**
	 * The order of this Table.
	 */
	private Order order;
	
	/**
	 * Constructor which creates a Table along with the number assigned
	 * this table.
	 * @param tableNo This table's number.
	 */
	
	public Table(int tableNo) {
		this.tableNo = tableNo;
	}
	
	//method to test for expired reservation booked in advance
	//method to test for non-expired reservation booked in advance
	/*public void DummyReservation() {
		reservation.DummyReservation();
	}*/
	
	//method to test for full reservation
	/*public void DummyReserve() {
		reservation.Dummy_Reservation();
	}*/
	
	/**
	 * Method to create an order for this Table.
	 * @param server Name of the server for this Table.
	 * @param menu Menu instance from the RRPSS.
	 */
	public void createOrder(String server,Menu menu) {
		seated = true;
		unreserveTable();
		orderNo++;
		order = new Order(orderNo,server);
		order.takeOrder(menu);
	}
	/**
	 * Method to edit the order for this Table.
	 * Able to add or remove items from Order.
	 * @param menu Menu instance from the RRPSS.
	 */
	public void editOrder(Menu menu) {
		order.takeOrder(menu);
	}
	/**
	 * Method that prints out the order for this Table.
	 */
	
	public void viewOrder() {
		order.printOrder();
	}
	/**
	 * Method that prints out the invoice/receipt for this Table.
	 */
	public void viewInvoice() {
		order.printInvoice();
		seated = false;
	}
	/**
	 * Method to get this table's assigned number.
	 * @return this Table's number.
	 */
	public int getTableNo() {
		return tableNo;
	}
	/**
	 * Method to get the total price of the order from this Table.
	 * @return this Table's Order's totalPrice.
	 */
	
	public double getTotalOrderPrice() {
		return order.getTotalPrice();
	}
	/**
	 * Method to get the number of seats of this Table.
	 * @return this Table's number of seats
	 */
	public int getTableSeats() {
		return seats;
	}
	/**
	 * Method to get the seated status of this Table.
	 * @return this Table's seated status.
	 */
	public boolean isSeated() {
		return seated;
	}
	/**
	 * Method to get the reservation status of this Table.
	 * @return this Table's reservation status.
	 */
	
	public boolean isReserved() {
		return reservation.getReservedStatus();
	}
	/**
	 * Method to create a valid reservation for this Table.
	 * @param noPax This Table's Reservation's number of customers.
	 */
	public void reserveTable(int noPax) { 
		reservation.ReserveTable(noPax);
	}
	/**
	 * Method to remove the reservation for this Table.
	 */
	
	public void unreserveTable() {
		reservation.cancelReservation();
	}
	/**
	 * Method to check if the reservation is still valid
	 * against the current time.
	 */
	public void checkIfReservationValid() {
		reservation.checkReservationValid();
	}
	/**
	 * Method to print out the full details of Reservation for
	 * this Table.
	 */
	public void displayReservationDetails() {
		reservation.displayReservationDetails();
	}
	/**
	 * Method to print out the name of the customer which made
	 * the Reservation for this Table.
	 */
	public void displayReservationCustomerName() {
		reservation.displayCustomerName();
	}
	/**
	 *Method to check whether the Table has been
	 *seated or Reserved. 
	 */
	
	public void checkTableStatus() {
		if (seated) System.out.println(" Seated");
		else if (reservation.getReservedStatus()) {
			System.out.print(" Reserved by");
			reservation.displayCustomerName();
		}
		else System.out.println(" Empty");
	}
	/**
	 * Method which gets the Order for this Table.
	 * @return this Table's Order.
	 */
	public Order retrieveOrder() {
		return order;
	}
	/**
	 * Method which prints out this Table's seats and assigned number.
	 * @param o Whether to print with a new line or not.
	 */
	public void printTableNoAndSeats(boolean o) {
		if(o)System.out.println("| " + tableNo + ":\t" + seats + " seats");
		else System.out.print("|" + tableNo + ":\t" + seats + " seats - ");
	}
	
}