// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package academicEmployees;

import java.util.Scanner;
public class teacher extends academicEmployees {
	public static Scanner sc = new Scanner (System.in);
	
	protected int examScriptsCorrected;
	protected float examScriptsPay;

	public void calcCorrectedScripts() {
		System.out.print("\nEnter the amount of scripts corrected: ");
		examScriptsCorrected = sc.nextInt();
		
		if (examScriptsCorrected > 0)
			examScriptsPay = examScriptsCorrected * 10.18f;
	}	
}
