// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package academicEmployees;
import java.util.Scanner;

public class partTime extends academicEmployees {
	public static Scanner sc = new Scanner (System.in);

	public float examScriptsPay;

	// Method to calculate monthly salary
	public void calcMonthlySalary() {
		System.out.print("\nEnter the hours worked: ");
		float hoursWorked = sc.nextFloat();
		
		monthlySalary = hoursWorked * 34.03f;
	}

	// Method to calculate how much is earned from correcting exam scripts
	public void calcCorrectedScripts() {
		System.out.print("\nEnter the amount of scripts corrected: ");
		int examScriptsCorrected = sc.nextInt();
		
		if (examScriptsCorrected > 0)
			examScriptsPay = examScriptsCorrected * 10.18f;
		}

	// Method to calculate gross pay 
	public void calcGrossPay() {
		grossPay = monthlySalary + examScriptsPay;
	}
}
