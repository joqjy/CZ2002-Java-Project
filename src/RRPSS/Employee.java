package RRPSS;

/**
 * Represents the employee working in the restaurant.
 * @author Hans Farrell Soegeng
 *
 */
public class Employee {
	
	/**
	 * The name of the employee.
	 */
	private String name;
	
	/**
	 * The gender of the employee.
	 */
	private char gender;
	
	/**
	 * The unique identifier of the employee.
	 */
	private int EmployeeID;
	
	/**
	 * The job title of the employee.
	 */
	private String JobTitle;
	
	/**
	 * Creates a new Employee with the given details.
	 * @param name This Employee's name.
	 * @param gender This Employee's gender.
	 * @param EmployeeID This Employee's ID.
	 * @param JobTitle This Employee's job title.
	 */
	public Employee(String name, char gender, int EmployeeID, String JobTitle) {
		this.name = name;
		this.gender = gender;
		this.EmployeeID = EmployeeID;
		this.JobTitle = JobTitle;
	}
	
	/**
	 * Gets the name of this Employee.
	 * @return name This Employee's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the gender of this Employee.
	 * @return gender This Employee's gender.
	 */
	public char getGender() {
		return gender;
	}
	
	/**
	 * Gets the Employee ID of this Employee.
	 * @return EmployeeID This Employee's EmployeeID.
	 */
	public int getEmployeeID() {
		return EmployeeID;
	}
	
	/**
	 * Gets the job title of this Employee.
	 * @return JobTitle This Employee's job title.
	 */
	public String getJobTitle() {
		return JobTitle;
	}
	
	/**
	 * Changes the name of this Employee
	 * @param name This Employee's new name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Changes the gender of this Employee
	 * @param gender This Employee's new gender.
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * Changes the Employee ID of this Employee.
	 * @param EmployeeID This Employee's new Employee ID.
	 */
	public void setEmployeeID(int EmployeeID) {
		this.EmployeeID = EmployeeID;
	}
	
	/**
	 * Changes the job title of this Employee.
	 * @param JobTitle This Employee's new job title.
	 */
	public void setJobTitle(String JobTitle) {
		this.JobTitle = JobTitle;
	}
	
	/**
	 * Gets the details of this Employee in String format.
	 * @return this Employee's details.
	 */
	public String print() {
		return String.format("Name: %s\nGender: %s\nEmployeeID: %d\nJobTitle: %s\n", name, gender, EmployeeID, JobTitle);
	}
}
