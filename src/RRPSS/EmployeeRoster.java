package RRPSS;

import java.util.*;
import java.util.jar.Attributes.Name;
import java.io.*;

/**
 * Represents the collection of employees working in the restaurant.
 * @author Hans Farrell Soegeng
 *
 */
public class EmployeeRoster {
	
	/**
	 * Stores all the employees working in the restaurant.
	 */
	private ArrayList<Employee> eList =  new ArrayList<Employee>();
	
	/**
	 * Instantiates the default team of employees working in the restaurant.
	 */
	public EmployeeRoster() {
		eList.add(new Employee("Jeff", 'M', 1001, "Supervisor 1"));
		eList.add(new Employee("Max", 'M', 1002, "Waiter 1"));
		eList.add(new Employee("Tom", 'M', 1003, "Waiter 2"));
		eList.add(new Employee("Dan", 'M', 1004, "Waiter 3"));
		eList.add(new Employee("Lin", 'F', 1005, "Waiter 5"));
		eList.add(new Employee("Erin", 'F', 1006, "Waiter 6"));
		eList.add(new Employee("Carol", 'F', 1007, "Supervisor 2"));
		eList.add(new Employee("Denise", 'F', 1008, "Waiter 7"));
	}
	
	/**
	 * Adds a new Employee to the team.
	 * 
	 * @param name This new Employee's name.
	 * @param gender This new Employee's gender.
	 * @param EmployeeID This new Employee's Employee ID
	 * @param JobTitle This new Employee's job title.
	 * @return 0 if EmployeeID already exists, else 1.
	 */
	public int addEmployee(String name, char gender, int EmployeeID, String JobTitle) {
		for(int i = 0; i < eList.size(); i++)
		{
			if(eList.get(i).getEmployeeID() == EmployeeID)
			{
				//System.out.println("EmployeeID has been taken! Please choose another EmployeeID and start over again!");
				return 0;
			}
		}
		eList.add(new Employee(name, gender, EmployeeID, JobTitle));
		System.out.println("Done!\n");
		return 1;

	}
	
	/**
	 * Remove an Employee from the team.
	 * @param EmployeeID This Employee's Employee ID.
	 * @return 0 if Employee ID doesn't exist, else 1.
	 */
	public int removeEmployee(int EmployeeID) {
		for(int i = 0; i < eList.size(); i++)
		{
			if(eList.get(i).getEmployeeID() == EmployeeID)
			{
				eList.remove(i);
				System.out.println("Done!");
				return 1;
			}
		}
		System.out.println("Unable to find EmployeeID: " + EmployeeID);
		return 0;
	}
	
	/**
	 * Prints out the particulars of all Employees in the team.
	 */
	public void printAll() {
		System.out.println("Particulars of all Employee\n");
		for(int i = 0; i < eList.size(); i++)
		{
			//System.out.println("Enter printAll for loop");
			System.out.println(eList.get(i).print());
		}
	}
	
	/**
	 * Print out an Employee's particular.
	 * @param EmployeeID This Employee's Employee ID.
	 * @param type The requested particular.
	 * @return The information.
	 */
	public String print(int EmployeeID, String type)
	{
		int id = EmployeeID - 1001;
		
		while(id < 0 || id > 7)
		{
			System.out.print("Invalid EmployeeID! Please enter EmployeeID again: ");
			int i = Exception.getInteger();
			id = i - 1001;
		}
		
		if(type.equals("name") || type.equals("Name"))
		{
			return eList.get(id).getName();
		}
		else if(type.equals("gender") || type.equals("Gender"))
		{
			return Character.toString(eList.get(id).getGender());
		}
		else if(type.equals("JobTitle") || type.equals("Jobtitle") || type.equals("jobtitle"))
		{
			return Integer.toString(eList.get(id).getEmployeeID());
		}
		
		return "TOTAL ERROR!";
	}
}