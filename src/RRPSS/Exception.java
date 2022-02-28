package RRPSS;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception handling for various user inputs.
 * @author Hans Farrell Soegeng
 *
 */
public class Exception{
	
	/**
	 * Triggers user to input a Double value.
	 * Displays error message until input is a Double value.
	 * @return value The user's Double input.
	 */
	static double getDouble(){
	    Scanner i = new Scanner(System.in);
	    double value = 0.0;

	    for(boolean test = false; test == false;){
	        try{
	        value = i.nextDouble();

	        test = true;
	        return value;
	        }
	        catch(InputMismatchException e){System.out.println("Invalid input! Please try again!");}
	        i.nextLine();
	    }
	    return value;
	}
	
	/**
	 * Triggers user to input an Integer value.
	 * Displays error message until input is an Integer value.
	 * @return value The user's Integer input.
	 */
	static int getInteger(){
	    Scanner i = new Scanner(System.in);
	    int value = 0;

	    for(boolean test = false; test == false;){
	        try{
	        value = i.nextInt();

	        test = true;
	        return value;
	        }
	        catch(InputMismatchException e){System.out.println("Invalid input! Please try again!");}
	        i.nextLine();
	    }
	    return value;
	}
	
	/**
	 * Triggers user to input a String value.
	 * Displays error message until input is a String value.
	 * @return value The user's String input.
	 */
	static String getString(){
	    Scanner i = new Scanner(System.in);
	    String value = "";

	    for(boolean test = false; test == false;){
	        try{
	        value = i.nextLine();

	        test = true;
	        return value;
	        }
	        catch(InputMismatchException e){System.out.println("Invalid input! Please try again!");}
	        i.nextLine();
	    }
	    return value;
	}
	
	/**
	 * Triggers user to input a Boolean value.
	 * Displays error message until input is a Boolean value.
	 * @return value The user's Boolean input.
	 */
	static boolean getBoolean(){
	    Scanner i = new Scanner(System.in);
	    boolean value;

	    for(boolean test = false; test == false;){
	        try{
	        value = i.nextBoolean();

	        test = true;
	        return value;
	        }
	        catch(InputMismatchException e){System.out.println("Invalid input! Please try again!");}
	        i.nextLine();
	    }
	    return value = false;
	}
	
	/**
	 * Triggers user to input an Integer value resembling a phone number.
	 * Displays error message until input is an Integer value that
	 * starts with an 8 or 9 and has 8 digits.
	 * @return value The user's contact number input.
	 */
	static int getContact() {
		//Ensure customer provide real phone number
		//Contact must be 8 digits
		//Contact must start with 8 or 9
		int contact = Exception.getInteger();
		int length = String.valueOf(contact).length();
		int firstDigit = contact/10000000;
		
		while(length != 8 || !(firstDigit == 9 || firstDigit == 8))
		{
			System.out.println("Invalid contact number entered! Please enter a valid contact number: ");
			contact = Exception.getInteger();
			
			length = String.valueOf(contact).length();
			//System.out.println("Lenght of contact: "+ length);
			firstDigit = contact/10000000;
			//System.out.println("First digit of contact: "+firstDigit);
		}
		
		return contact;
	}
	
	/**
	 * Triggers user to input a Character value resembling gender input value.
	 * Displays error message until input starts with M or F.
	 * @return value The user's gender input.
	 */
	static char getChar() {
		Scanner i = new Scanner(System.in);
		char g = Character.toUpperCase(i.nextLine().charAt(0));
		
		while(!(g == 'F' || g == 'M'))
		{
			System.out.println("Invalid gender input! Please enter again: (M/F)");
			g = Character.toUpperCase(i.nextLine().charAt(0));
		}
		
		return g;
	}
	
	/**
	 * Triggers user to input a Integer value resembling Employee ID.
	 * Displays error message until integer input is greater than 999.
	 * @return value The user's employee ID input.
	 */
	static int getID() {
		int id = Exception.getInteger();
		
		while(id < 1000)
		{
			System.out.println("Invalid EmployeeID entered! EmployeeID starts from 1000! Please input EmployeeID again:");
			id = Exception.getInteger();
		}
		return id;
	}
}
