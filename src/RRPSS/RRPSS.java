package RRPSS;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * The RRPSS System containing all the multiple functions
 * and the main method.
 * @author YANGY
 *
 */
public class RRPSS {

	public static void main(String[] args) {
		/*
		 * Creates a scanner class to read inputs.
		 */
		Scanner sc = new Scanner(System.in);
		/*
		 * Creates the pre-defined employee roster.
		 */
		EmployeeRoster ER = new EmployeeRoster();
		/*
		 * Choice contains the choice of user input.
		 */
		int choice;
		/*
		 * Variable to determine the number of the table we would like to
		 * use.
		 */
		int tableNo;
		/*
		 * Variable to determine the number of the employee we would like to use,
		 * used in order to fetch the name.
		 */
		int employeeNo;
		/*
		 * Initializes a default menu.
		 */
		Menu menu = new Menu();
		/*
		 * Initializes the default saslesRevenue,
		 * by using the default constructor, the date would be
		 * the current date.
		 */
		salesRevenue SalesRevenue = new salesRevenue();
		/*
		 * Initializes the SalesRevenueRecorder,
		 * which would hold the different salesRevenue instances.
		 */
		SalesRevenueRecorder records = new SalesRevenueRecorder();
		/*
		 * Initializes the TablePlanner class, creating a pre-defined
		 * array of tables.
		 */
		TablePlanner tableArray = new TablePlanner();
		/*
		 * initializes the capacity variable in order to determine the
		 * holding capacity of the restaurant.
		 * Capacity is reserved and seated tables added together.
		 */
		int capacity = 0;
		
		do {
			/*
			 * UI for the RRPSS
			 */
			System.out.println("================ Please choose one ================");
			System.out.println("|1. Edit Menu Item                                |");
			System.out.println("|2. Create Order                                  |");
			System.out.println("|3. Edit Order                                    |");
			System.out.println("|4. View Order                                    |");
			System.out.println("|5. Create Reservation Booking                    |");
			System.out.println("|6. Check/Remove Reservation Booking              |");
			System.out.println("|7. Check Table Availability                      |");
			System.out.println("|8. Print Order Invoice                           |");
			System.out.println("|9. Close Sales                                   |");
			System.out.println("|10. Print Sales Revenue Report By Period(by day) |");
			System.out.println("|11. Add/Remove Employee                          |");
			System.out.println("|12. Exit                                         |");
			System.out.println("===================================================");
			
			choice = Exception.getInteger();
			
			if(choice < 1 || choice > 12)
			{
				System.out.println("Input value out of range! Please choose again:");
			}
			/*
			 * Updates the value of the tables after any decision has been made.
			 * Done to ensure that updated values of reserved and seated
			 * are reflected within the TablePlanner.
			 */
			tableArray.updateValues();
			/*
			 * checkCapacity is used to check if the choice would be a valid choice
			 * in the context of a fully reserved or fully seated restaurant, or an
			 * empty restaurant.
			 */
			choice = tableArray.checkCapacity(choice);
			
			switch(choice) {
				/*
				 * Calls the editMenu Method to
				 * edit the menuitems within the Menu Class.
				 */
			case 1: menu.editMenu();
					break;
		
			case 2: 
				/*
				 * Checks for any invalid Reservations within the system
				 * and removes them.
				 */
					for(int i = 0;i<21;i++) {
					if(tableArray.getTable(i).isReserved())
						tableArray.getTable(i).checkIfReservationValid();
					}
					System.out.println("Any Reservations that are invalid have been removed");
				/*
				 * Updates the values within  the TableArray as
				 * a reservation might have been removed.
				 */
					tableArray.updateValues();		
				/*
				 * Checks whether the customer has a reservation,
				 * and fetches the reserved tables instead of the empty
				 * non-seated tables.
				 */
					System.out.println("Do they have a Reservation? (True/False)");
					boolean o = Exception.getBoolean();
					System.out.println("");
					System.out.println("Please choose from the list of tables below:");
					if(o) {
						for (int i = 0;i<21;i++) {
							if(tableArray.getTable(i).isReserved()) { 
								tableArray.getTable(i).printTableNoAndSeats(true);
								tableArray.getTable(i).displayReservationDetails();
							}
						}
						if(tableArray.getReserved()==0) {
							System.out.println("Oops! There are no reserved tables.");
							System.out.println("");
							break;
						}
					}
					
					else {
						if(tableArray.getCapacity()==21) {
							System.out.println("Restaurant is full! No more walk-ins.");
							System.out.println("");
							break;
						}
						for (int i = 0;i<21;i++) {
						if(!tableArray.getTable(i).isReserved() && !tableArray.getTable(i).isSeated())
							tableArray.getTable(i).printTableNoAndSeats(true);
						
						}
					}
					System.out.println("");
					System.out.println("Order for which Table?"); 
					tableNo = Exception.getInteger();
					/*
					 * Asks for the order for which table number
					 * and creates the order for that table.
					 */
					
					
					if(o) {
						while(tableNo > 20 || tableNo< 0 || tableArray.getTable(tableNo).isSeated() ||!tableArray.getTable(tableNo).isReserved()) {
							System.out.println("Invalid Table No, Try Again");
							tableNo = Exception.getInteger();
						}
					}
					else {
						while(tableNo > 20 || tableNo< 0 || tableArray.getTable(tableNo).isSeated() || tableArray.getTable(tableNo).isReserved()) {
							System.out.println("Invalid Table No, Try Again");
							tableNo = Exception.getInteger();
						}
					}
					/*
					 * Asks for the employee ID to fetch the name
					 * corresponding to that ID from employeeRoster.
					 */
					System.out.println("Key in your Employee ID"); 
					employeeNo = Exception.getInteger();
					String employeename = ER.print(employeeNo, "name");
					/*
					 * Removes the reservation if a person who had reserved the table
					 * has arrived.
					 */
					if(o) tableArray.getTable(tableNo).unreserveTable();
					/*
					 * Creates an order for the Table corresponding
					 * to that table number.
					 */
					tableArray.getTable(tableNo).createOrder(employeename, menu);
					
					break;
			
					
			case 3:
					/*
					 * Checks for all the seated tables,
					 * those that have an order.
					 */
				
					for (int i = 0;i<21;i++) {
						if(tableArray.getTable(i).isSeated()) 
							tableArray.getTable(i).printTableNoAndSeats(true);
					}
					System.out.println("");
					System.out.println("For which Table?");
					
					tableNo = Exception.getInteger();

					while(tableNo > 20 || tableNo< 0 || !tableArray.getTable(tableNo).isSeated() ) {
						System.out.println("Invalid Table No, Try Again");
						tableNo = Exception.getInteger();
					}
					/*
					 * Edits the order for the Table
					 * corresponding to that Table number.
					 */
					tableArray.getTable(tableNo).editOrder(menu);
					break; 
					
			case 4:
					/*
					 * Checks for all the seated tables,
					 * those that have an order.
					 */
					
					for (int i = 0;i<21;i++) {
					if(tableArray.getTable(i).isSeated()) 
						tableArray.getTable(i).printTableNoAndSeats(true);
					}
					System.out.println("");
					System.out.println("For which Table?");
					tableNo = Exception.getInteger();
					while(tableNo > 20 || tableNo< 0 || !tableArray.getTable(tableNo).isSeated() ) {
						System.out.println("Invalid Table No, Try Again");
						tableNo = Exception.getInteger();
					}
					/*
					 * uses viewOrder Method to print out the 
					 * details of the Order for the Table
					 * corresponding to that table number.
					 */
					tableArray.getTable(tableNo).viewOrder();
					
					break;
			
			case 5: 
					/*
					 * Asks for number of customers needed
					 * for reservation to fetch the tables which have the seats
					 * corresponding to that number.
					 */
					System.out.println("How many people?");
					int noPax = Exception.getInteger();
					int tableavail=0;
					
					for (int i = 0;i<21;i++) {
					if(!tableArray.getTable(i).isReserved() && !tableArray.getTable(i).isSeated()) 
						if(tableArray.getTable(i).getTableSeats()>=noPax) {
							tableArray.getTable(i).printTableNoAndSeats(true);
							tableavail++;
						}
					}
					if(tableavail==0) {
						System.out.println("No table available for no. of people");
						break;
					}
					
					System.out.println("Reservation for which Table?");
					tableNo = Exception.getInteger();
					while(tableNo > 20 || tableNo < 0 || tableArray.getTable(tableNo).isReserved() || tableArray.getTable(tableNo).isSeated() || tableArray.getTable(tableNo).getTableSeats()<noPax ) {
						System.out.println("Invalid Table No, Try Again");
						tableNo = Exception.getInteger();
					}
					/*
					 * Calls the reserveTable method to create a reservation for that Table.
					 */
					tableArray.getTable(tableNo).reserveTable(noPax);
					
					break;
					
			case 6:
				/*
				 * Iterates through the TableArray to check whether
				 * all the reservations are still valid, removing any invalid
				 * reservations.
				 */
				for(int i = 0;i<21;i++) {
					if(tableArray.getTable(i).isReserved())
						tableArray.getTable(i).checkIfReservationValid();
					}
				System.out.println("");
				System.out.println("Any Reservations that are invalid have been removed");
				/*
				 * Updates the seating capacity (seated + reserved) of the restaurant as there might
				 * have been tables which reservations have been removed.
				 */
				
				tableArray.updateValues();
				
				if(tableArray.getReserved() == 0) 
				{
					System.out.println("There is no reservation for any table.");
					break;
				}
				
				for(int i = 0;i<21;i++) {
					if(tableArray.getTable(i).isReserved()) {
						tableArray.getTable(i).printTableNoAndSeats(false);
						tableArray.getTable(i).displayReservationCustomerName();
						}												
				
				}
				System.out.println("");
				System.out.println("Which Reservation would you like to check?");
				
				tableNo = Exception.getInteger();
				while(tableNo > 20 || tableNo< 0 || !tableArray.getTable(tableNo).isReserved() ) {
					System.out.println("Invalid Table No, Try Again");
					tableNo = Exception.getInteger();
				}
				/*
				 * Displays the full details of the reservation for that table, this
				 * would contain Customer contact,name, the number of customers and
				 * the date of reservation.
				 */
				tableArray.getTable(tableNo).displayReservationDetails();
				/*
				 * Asks the user if he would like to remove or retain the reservation.
				 */
				
				System.out.println("Would you like to remove this reservation? (True/False)");
				boolean remove = Exception.getBoolean();
				if (remove) {
					tableArray.getTable(tableNo).unreserveTable();
					System.out.println("Reservation for Table " + tableNo + " has been removed.");
				}
				else {break;}
				
				break;
			
			case 7: 
					/*
					 * Prints out the status of each individual table
					 * for the user. The three statuses are: 
					 *  reserved for a table that has a reservation
					 *  seated for a table that is seated, which has an order
					 *  empty for a table that is neither reserved nor seated.
					 */
					System.out.println("");
					System.out.println("List of available tables are shown below:");
					System.out.println("----------------------------------------------------------");
					for (int i = 0;i<21;i++) {
						tableArray.getTable(i).printTableNoAndSeats(false);
						tableArray.getTable(i).checkTableStatus();
					}
					System.out.println("----------------------------------------------------------");
					System.out.println("");
					break;
			
			case 8: 
				/*
				 * Checks for all the seated tables,
				 * those that have an order.
				 */
					for(int i = 0;i<21;i++) {
						if(tableArray.getTable(i).isSeated()) {
							tableArray.getTable(i).printTableNoAndSeats(true);
						}
					}
					
					System.out.println("");
					System.out.println("For which Table?");
					
					tableNo = Exception.getInteger();
					
					while(tableNo > 20 || tableNo< 0 || !tableArray.getTable(tableNo).isSeated() ) {
						System.out.println("Invalid Table No, Try Again");
						tableNo = Exception.getInteger();
					}
					/*
					 * Closes sales for that table and clears it,
					 * adding that receipt to the SalesRevenue for the day.
					 */
					tableArray.getTable(tableNo).viewInvoice();
					SalesRevenue.addOrderToSales(tableArray.getTable(tableNo).retrieveOrder());
					
					break;
			case 9: 
					/*
					 * Closes the sales for the current day. Adding all accumulated invoices/receipts
					 * to the revenue of today's sales.
					 */
					System.out.println("Sales closed for the day. Any orders created will be added to next day's sales.");
					System.out.println("");
					records.addToRecords(SalesRevenue);
					/*
					 * Non-default constructor for salesRevenue, this is to indicate that
					 * the salesRevenue would be created for the next day.
					 */
					SalesRevenue = new salesRevenue(1);
					break;
					
			case 10:
					/*
					 * Retrieves the record of the sales Revenue for any specified date which has transpired.
					 * Prints out the full salesRevenue for that specified date.
					 */
					if(records.getRecords().size()==0) {
						System.out.println("There are no sales revenue records.");
						System.out.println("");
						break;
					}
					records.retrieveSales();
					break;
					
			case 11:
				/*
				 * Function used to add or remove any employees from the employee Roster.
				 */
				int i;
					do {
						System.out.println("========== Employee Menu ========");
						System.out.println("|1. Add new Employee            |");
						System.out.println("|2. Remove Existing Employee    |");
						System.out.println("|3. Print Employee particulars  |");
						System.out.println("|4. Done and Exit               |");
						System.out.println("=================================");
						System.out.println("");
						System.out.println("Please select one option to proceed");
						i = Exception.getInteger();
						
						if(i < 1 || i > 4)
						{
							System.out.println("Input value out of range! Please choose again:");
						}
						
						switch(i) {
							case 1:
								System.out.println("Enter new Empoyee name: ");
								String name = Exception.getString();
								System.out.println("Enter new Employee gender: ");
								char gender = Exception.getChar();
								System.out.println("Enter new Employee Job Title:");
								String title = Exception.getString();
								System.out.println("Enter new EmployeeID: ");
								int ID = Exception.getID();

								if(ER.addEmployee(name, gender, ID, title) == 0)
								{
									System.out.println("EmployeeID has been taken! Please choose another EmployeeID and start over again!");

								}
								break;
								
							case 2:
								System.out.println("Enter EmployeeID to be removed: ");
								int idToRemove = Exception.getID();
								if(ER.removeEmployee(idToRemove) == 0)
								{
									System.out.println("Removal of Employee failed!");
									System.out.println("");
								}
								break;
								
							case 3: 
								ER.printAll();
								break;
								
							case 4: 
								break;
						}
					}
					while(i != 4);

					break;
					
			case 12: System.out.println("Exited!"); 
					break;
			
			default:
					break;
			}
			 capacity = 0;
			 for(int i = 0;i<21;i++) {
				if (tableArray.getTable(i).isReserved() || tableArray.getTable(i).isSeated()) capacity++;
			 }	
		}
		while(choice != 12);
	sc.close();
	}
}



