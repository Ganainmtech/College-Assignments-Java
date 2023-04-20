// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package academicEmployees;

import java.util.Scanner;
import java.text.DecimalFormat;

public class principle extends academicEmployees {
	public static Scanner sc = new Scanner (System.in);
	public static DecimalFormat money = new DecimalFormat ("€0.00");
	
	public float workCapcityPay;
	public int numOfTeachers;

	public void calcTeacherCapacityPay() {
		System.out.print("\nEnter the number of Teachers in your school: ");
		numOfTeachers = sc.nextInt();
		
		if (numOfTeachers > 200)
			workCapcityPay += 1196.67f;
		else if (numOfTeachers > 100) 
			workCapcityPay += 1019.83f;
		else if (numOfTeachers > 10) 
			workCapcityPay += 869.33f;
		else 
			workCapcityPay += 775.83f;
	}


	public void calcGrossPay() {
		monthlySalary = 5000;
		grossPay = workCapcityPay + monthlySalary;
	}
	
	public void outPutWorkDetails() {
		System.out.printf("\nNumber of Teachers: " + numOfTeachers + ", capacity bonus = " + money.format(workCapcityPay)
		+ "\nSet Principle Monthly Salary: " + money.format(monthlySalary)  + "\n");

	}
}
