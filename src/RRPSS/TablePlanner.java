package RRPSS;

/**
 * A Table Planner class which holds an array
 * of multiple Tables with different number of seats.
 * Only ONE Table Planner per Restaurant.
 * @author YANGY
 *
 */

public class TablePlanner {
	/**
	 * The seating capacity(number of reserved + seated) of
	 * this TablePlanner.
	 */
	private int capacity;
	/**
	 * The number of seated Tables of this TablePlanner.
	 */
	private int seated;
	/**
	 * The number of reserved Tables of this TablePlanner.
	 */
	private int reserved;
	/**
	 * The Array of Tables for this Table Planner.
	 */
	private Table[] tables = new Table[21];
	
	/**
	 * Default constructor class which creates a 
	 * fixed number of tables and their seats.
	 */
	
	public TablePlanner() {
		//Table[] tables = new Table[21];
		for(int i = 0;i<10;i++) {
			tables[i] = new TwoSeats(i);
		}
		for(int i = 10;i<16;i++) {
			tables[i] = new FourSeats(i);
		}
		for(int i = 16;i<18;i++) {
			tables[i] = new SixSeats(i);
		}
		for(int i = 18;i<20;i++) {
			tables[i] = new EightSeats(i);
		}
		tables[20] = new TenSeats(20);
		
		//Used to test for expired reservation booked in advance
		//Used to test for non-expired reservation booked in advance
		//tables[20].DummyReservation(); 
		
		//Used to test for full reservation
		/*for(int j=0;j<21;j++) {  //for full reservation
			tables[j].DummyReserve();
		}*/
	}
	/**
	 * Method to get the Table instance at the i'th position of the array.
	 * @param i I'th position of this TableArray.
	 * @return Table at the i'th position of this TableArray.
	 */
	public Table getTable(int i) {
		return tables[i];
	}
	/**
	 * Method to update the values 
	 * of capacity,seated and reserved
	 * for this TablePlanner.
	 */
	public void updateValues() {
		capacity = 0;
		reserved = 0;
		seated = 0;
		for(int i = 0;i<21;i++) {
			if (tables[i].isReserved()) reserved++;
			if (tables[i].isSeated()) seated++;
		}
		capacity = seated + reserved;
	}
	/**
	 * Method to get the number of reserved
	 * tables for this TableArray.
	 * @return this TableArray number of reserved tables.
	 */
	public int getReserved() {
		return reserved;
	}
	/**
	 * Method to get the number of used(seated and reserved)
	 * tables for this TableArray.
	 * @return this TableArray number of used tables.
	 */
	
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Method to get the number of seated
	 * tables for this TableArray.
	 * @return this TableArray number of seated tables.
	 */
	
	public int getSeated() {
		return seated;
	}
	/**
	 * Method to prevent incorrect input which
	 * leads to an exception.
	 * @param choice the User's choice of which method to execute.
	 * @return the Suitable/correct choice.
	 */
	public int checkCapacity(int choice) {
		if(capacity == 21) {
			while(choice == 5){
				System.out.println("Restaurant is full! You can no longer create reservation bookings.");
				choice = Exception.getInteger();
			}
		}
		if(seated==21) {
			while(choice == 2) {
				System.out.println("Restaurant is fully seated! You can no longer create orders.");
				choice = Exception.getInteger();
			}
		}
		
		if(seated == 0) {
			while(choice == 3 || choice == 4 || choice == 8) {
				System.out.println("There are currently no orders.");
				choice = Exception.getInteger();
			}
		}
		return choice;
	}
}

