package academicEmployees;

import java.util.Scanner;
/*
import academicEmployees.fullTime;
import academicEmployees.partTime;
import academicEmployees.principle;
*/
public class academicEmployeesMain {
	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		char getEmpDetails;
		char empChoice;
		String empPpsNum;
		
		do {
			System.out.print("\nWould you like to get Employee pay details?(y/n):");
			getEmpDetails = sc.nextLine().charAt(0);
			
			// Outputting thank you message when they don't want another quote.
			if (Character.toUpperCase(getEmpDetails) == 'N') 
				System.out.print("Thank you for using this program.");
				
			else if (Character.toUpperCase(getEmpDetails) == 'Y') 
				do { 
					System.out.print("Please enter your PPS Number to sign in: ");
					empPpsNum = sc.nextLine();
				

					// Validating if the pps number is 7 numbers in length and then followed by a letter
					if(empPpsNum.matches("\\d{7}[a-zA-Z]{1}")) 
					{ 
						System.out.print("\nChoose your employee status."
									+ "\nF: Full Time Employee" 
									+ "\nP: Part Time Employee"
									+ "\nL: Lead Principle Employee" 
									+ "\nS: Sign Out"
									+ "\nSelect corresponding letter above: ");
						}
					else
					{
						System.err.println("\nEnter your PPS number this should contain 7 numbers followed by a letter.");
					}
					
				} while (!empPpsNum.matches("\\d{7}[a-zA-Z]{1}"));
			
				empChoice = sc.nextLine().charAt(0);
				
				// Outputting thank you message when they don't want another quote.
				if (Character.toUpperCase(empChoice) == 'S') {
					System.out.println("You have signed out."); // could champ empchoice to n?
				}
							
				else if (Character.toUpperCase(empChoice) == 'F') {
					fullTime fulltime = new fullTime();

					fulltime.calcBonusPay();
					fulltime.calcCorrectedScripts();
					fulltime.calcDeductions();
					fulltime.calcGrossPay();
					fulltime.calcTax();
					fulltime.calcPrsi();
					fulltime.calcNetPay();
					fulltime.outPut();
				}

				else if (Character.toUpperCase(empChoice) == 'P') {
					partTime parttime = new partTime();

					parttime.calcCorrectedScripts();
					parttime.calcMonthlySalary();
					parttime.calcGrossPay();
					parttime.calcTax();
					parttime.calcPrsi();
					parttime.calcNetPay();
					parttime.outPut();
				}

				else if (Character.toUpperCase(empChoice) == 'L') {
					principle principle = new principle();

					principle.calcBonusPay();
					principle.calcGrossPay();
					principle.calcTax();
					principle.calcPrsi();
					principle.calcNetPay();
					principle.outPut();
				}
				
		} while (Character.toUpperCase(getEmpDetails) == 'Y');
		
	}

}
