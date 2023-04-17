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
		String empPpsNum = "";
		
		
		do {	
			do {
				System.out.print("\nWould you like to get Employee pay details?(y/n):");
				getEmpDetails = sc.nextLine().charAt(0);
				
				if (Character.toUpperCase(getEmpDetails) != 'Y' && Character.toUpperCase(getEmpDetails) != 'N')
					System.err.print("\nPlease enter y/Y for yes or n/Y for no\n");
				
			} while (Character.toUpperCase(getEmpDetails) != 'Y' && Character.toUpperCase(getEmpDetails) != 'N');
			
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
					System.out.printf("\nEmployee " + empPpsNum + " has successfully signed out\n"); // could champ empchoice to n?
				}
							
				if (Character.toUpperCase(empChoice) == 'F') {
					fullTime fulltime = new fullTime();

					fulltime.calcBonusPay();
					fulltime.calcCorrectedScripts();
					fulltime.calcDeductions();
					fulltime.calcGrossPay();
					fulltime.calcTax();
					fulltime.calcPrsi();
					fulltime.calcNetPay();
					System.out.printf("\nHere are " + empPpsNum + " pay details below:\n");
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
					System.out.printf("\nHere are " + empPpsNum + " pay details below:\n");
					parttime.outPut();
				}

				else if (Character.toUpperCase(empChoice) == 'L') {
					principle principle = new principle();

					principle.calcBonusPay();
					principle.calcGrossPay();
					principle.calcTax();
					principle.calcPrsi();
					principle.calcNetPay();
					System.out.printf("\nHere are " + empPpsNum + " pay details below:\n");
					principle.outPut();
				}
				
		} while (Character.toUpperCase(getEmpDetails) == 'Y');
		
	}

}
