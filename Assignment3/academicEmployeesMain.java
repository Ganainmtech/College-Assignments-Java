package academicEmployees;

import java.util.Scanner;

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
									+ "\nH: Head Principle Employee" 
									+ "\nS: Sign Out\n");
									
						}
					else
					{
						System.err.println("\nEnter your PPS number this should contain 7 numbers followed by a letter.");
					}
					
				} while (!empPpsNum.matches("\\d{7}[a-zA-Z]{1}"));
			
				do {
					
					System.err.print("Please pick F for Fulltime, P for Parttime, H for Head Principle and S to sign out: ");
					empChoice = sc.nextLine().charAt(0);
					
				} while (Character.toUpperCase(empChoice) != 'F' && Character.toUpperCase(empChoice) != 'P'
						&&Character.toUpperCase(empChoice) != 'H' && Character.toUpperCase(empChoice) != 'S');
				
				// Outputting thank you message when they don't want another quote.
				if (Character.toUpperCase(empChoice) == 'S') {
					System.out.printf("\nEmployee " + empPpsNum + " has successfully signed out\n"); 
				}
							
				if (Character.toUpperCase(empChoice) == 'F') {
					fullTime fulltime = new fullTime();

					fulltime.calcScalePointsPay();
					fulltime.calcCorrectedScripts();
					fulltime.calcDeductions();
					fulltime.calcGrossPay();
					fulltime.calcTax();
					fulltime.calcPrsi();
					fulltime.calcNetPay();
					System.out.printf("\nHere are " + empPpsNum + " Full Time work details.\n");
					fulltime.outPutWorkDetails();
					fulltime.outPutPayDetails();
				}
				

				else if (Character.toUpperCase(empChoice) == 'P') {
					partTime parttime = new partTime();

					parttime.calcCorrectedScripts();
					parttime.calcMonthlySalary();
					parttime.calcGrossPay();
					parttime.calcTax();
					parttime.calcPrsi();
					parttime.calcNetPay();
					System.out.printf("\nHere are " + empPpsNum + " Part Time work details.\n");
					parttime.outPutWorkDetails();
					parttime.outPutPayDetails();
				}

				else if (Character.toUpperCase(empChoice) == 'H') {
					principle principle = new principle();

					principle.calcTeacherCapacityPay();
					principle.calcGrossPay();
					principle.calcTax();
					principle.calcPrsi();
					principle.calcNetPay();
					System.out.printf("\nHere are " + empPpsNum + " Principle work details.\n");
					principle.outPutWorkDetails();
					principle.outPutPayDetails();
				}
				
		} while (Character.toUpperCase(getEmpDetails) == 'Y');
		
	}

}