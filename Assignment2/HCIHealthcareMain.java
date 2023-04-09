/*
	Author:		Sara Jane Kenny
	Date:		06/03/2023

	This program reads in information from the user and outputs quotes for health insurance through a policy.
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class HCIHealthcareMain {
	public static Scanner sc = new Scanner (System.in);
	public static DecimalFormat money = new DecimalFormat ("€0.00");

	public static void main(String[] args) {
		myPolicy policyDemo = new myPolicy (sc);
		String getQuote;
		int userAge = 0;
		
			
			do {
				// While user is under 18, output a suitable error, then re-prompt question.
				do {
					System.out.println("\nWould you like a HCI Healthcare Quote?(y/n): ");
					getQuote = sc.next();
					
					// Outputting thank you message when they don't want another quote.
					if (getQuote.toLowerCase().equals("n"))
						System.out.print("Thank you for using HCI Healthcare!");
					
					else if (getQuote.toLowerCase().equals("y")) {
						System.out.println("Enter your age: ");
						userAge = sc.nextInt();
						if (userAge < 18)
							System.err.println("\nYou are not eligible for a quote with HCI Healthcare.");
					}
					
				} while (userAge < 18);
				
				// If a valid user, call methods methodically
				if (getQuote.toLowerCase().equals("y")) 
				{
					policyDemo.getUserInfo(sc);
					policyDemo.calcBasicCost(userAge);
					policyDemo.getUserDependents(sc);
					policyDemo.getInpatientInsurance(sc);
					policyDemo.getExtraCareOptions(sc);
					policyDemo.getVat();
					policyDemo.displayOutput(userAge, money);
				}
				// Repeating the HCI HealthCare quote while user chooses	
			} while (getQuote.toLowerCase().equals("y"));
	} 
}
