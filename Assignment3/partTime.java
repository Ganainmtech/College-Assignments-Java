// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package academicEmployees;

import java.util.Scanner;
import java.text.DecimalFormat;

public class partTime extends teacher {
	public static Scanner sc = new Scanner (System.in);
	public static DecimalFormat money = new DecimalFormat ("€0.00");
	
	public float hoursWorked;
	
	public void calcMonthlySalary() {
		System.out.print("\nEnter the hours worked: ");
		hoursWorked = sc.nextFloat();
		
		monthlySalary = hoursWorked * 34.03f;
	}

	public void calcGrossPay() {
		grossPay = monthlySalary + examScriptsPay;
	}
	
	public void outPutWorkDetails() {
		System.out.printf("\nCorrected Exam Scripts:%23s", + examScriptsCorrected + " | Total while €10.18 per script = " + money.format(examScriptsPay));
		System.out.printf("\nPart Time Hours Worked:%23s", + hoursWorked + " | Total while €34.03 per hour = " + money.format(monthlySalary) + "\n");

	}
}

