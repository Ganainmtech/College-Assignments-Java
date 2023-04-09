import java.util.Scanner;
import java.text.DecimalFormat;

public class myPolicy {
	// Private members 
	private String userName;
	private float basicCost;
	private int numOfDept;
	private float costOfDept;
	private float inpatientCost;
	private String inpatientInput;
	private String inpatientInputUpdated;
	private String inpatientRoomType;
	private int inpatientRoomCost;
	private String firstCareOption;
	private String secondCareOption;
	private String[] storeDeptNames = new String[6];
	private int[] storeDeptAges = new int[6];
	private int userCareChoice;
	private String userCareChoiceUpdated;
	private int extraCareCost;
	private float totalBeforeVat;
	private float totalVat;
	private float totalCost;

	// Scanner
	public myPolicy(Scanner sc) {
		firstCareOption = "";
		secondCareOption = "";
		basicCost = 426;
	}
	
	// Method to prompt and find out the user Info
	public void getUserInfo (Scanner sc) {
		System.out.println("Enter your Name: ");
		userName = sc.next();
	}
	
	
	// Method to work out the basic costs
	public void calcBasicCost (int userAge) {
		if (userAge >= 50)
			basicCost = 426 + 80;
	}

	
	// Method to find out the number and cost of dependents
		public void getUserDependents (Scanner sc) {
			do {
				//reading the number of dependents from the user
				System.out.println("Enter the number of dependents you have(max six): ");
				numOfDept = sc.nextInt();
				if (numOfDept > 6)
					System.err.println ("You can only enter a number of dependents from 0 up to 6.\n");
			} while (numOfDept > 6 || numOfDept < 0);
			
			// Calculating the cost of dependents
			if (numOfDept == 1)
				costOfDept = 250;
			else if (numOfDept == 2)
				costOfDept = 400;
			else if (numOfDept == 3)
				costOfDept = 500;
			else if (numOfDept > 4)
				costOfDept = 550;

			// Creates an array in the memory of length max number of dependents
			for(int i = 0; i < numOfDept; i++)  {  
				// Prompting user and reading array elements from the user  
				System.out.print("Enter your dependent's name: "); 
				storeDeptNames[i] = sc.next(); 
				
				// Prompting user for dependents age and outputting error if incorrect data is inputted
				do {
					System.out.print("Enter your dependent's age(under 18): ");
					storeDeptAges[i] = sc.nextInt();
					
					if (storeDeptAges[i] >= 18) {
						System.err.println ("You can only enter 18 or younger.\n");
					}
				} while (storeDeptAges[i] >= 18);  
			}  
			
		}
		
	// Method to get inpatient insurance
	public void getInpatientInsurance (Scanner sc) {
		boolean roomChoice = false;
		
		// Prompts user if they would like Impatient Insurance
		do {
			System.out.println("\nWould you like inpatient insurance with additional cost of 200 euro?(y/n): ");
			inpatientInput = sc.next();
			
			// If user input is n store correct data into variables
			if (inpatientInput.toLowerCase().equals("n")) {
				inpatientInputUpdated = "No";
				inpatientRoomType = "NA";
				inpatientCost = 0;
			}
			
			// If user input is y store correct data into variables
			else if (inpatientInput.toLowerCase().equals("y")) {
				roomChoice = true;
				inpatientInputUpdated = "Yes";
				if (roomChoice) {
					inpatientCost += 200;
					inpatientRoomType = "Semi-Private Room";
				}
				
				// User promoted to choose a room type
				System.out.println("Would you like a private room with additional cost of 100 euro?(y/n): ");
				inpatientInput = sc.next();
				if (inpatientInput.toLowerCase().equals("y"))
					if (roomChoice) {
						inpatientRoomCost = 100;
						inpatientRoomType = "Private Room";
					}
			}
			else
				System.err.println ("\nYou must enter a y or an n\n"); 
		} while (!(inpatientInput.toLowerCase().equals("y") || inpatientInput.toLowerCase().equals("n")));	
	}
	
	// Method to find out extra care options and add the cost
	public void getExtraCareOptions (Scanner sc) {
		// Declare and initialise array
		String[] extraCareOption = {"Orthopaedic Care", "Ophthalmic Care", "Maternity Care", 
				"Fertility Care", "Psychiatric Care"};
		int extraCareCounter = 1;
		int userCareChoice;
		
		do {
			// Displaying the menu options
			System.out.print("\nWould you like to avail any extra care? (max 2): " + "\n1. Orthopaedic Care"
					+ "\n2. Ophthalmic Care" + "\n3. Maternity Care" + "\n4. Fertility Care" + "\n5. Psychiatric Care"
					+ "\nPick a number corresponding to the menu or 0 for none: ");
			userCareChoice = sc.nextInt();
			
			// If user picks an extra care add 50 euro to extra care cost
			if (userCareChoice != 0)
				extraCareCost += 50;
			
			// Linking the users input to the array and given the arrays choice
			if (userCareChoice == 0) 
				secondCareOption = extraCareOption [userCareChoice];
			else 
				secondCareOption = extraCareOption [userCareChoice - 1];

			// Storing the users first input before the 2nd loop or creating "none" if user choice = 0 to be displayed in print method
			if (extraCareCounter == 1) {
				firstCareOption = secondCareOption;
				if (userCareChoice == 0) {
					userCareChoiceUpdated = "None";
				}
			}
			
			// Entering the 2nd loop, if user choice is 0 update user choices else store all the options
			if (extraCareCounter == 2) {
				if (userCareChoice == 0) {
					// Storing the first care option and extra cost values if the second user input is 0
					userCareChoiceUpdated = firstCareOption + "\t\t" + "€" + extraCareCost;
				}
				// Storing the first and second care option and extra cost values if the second user input is between 1 and 5
				else userCareChoiceUpdated = firstCareOption + "\n\t\t\t\t " + secondCareOption + "\t  " + "€" + extraCareCost;
			}
			extraCareCounter++;
		} while (extraCareCounter == 2 && userCareChoice != 0);
		
	}
	
	public void getVat() {
		// Calculating the total before vat
		totalBeforeVat = costOfDept + basicCost + inpatientCost + inpatientRoomCost + extraCareCost;
		
		// Calculating the total vat
		totalVat = (totalBeforeVat / 100) * 21;
		
		// Calculating the total cost with added vat
		totalCost = totalBeforeVat + totalVat;
	}
	
	// Method to print out information
	public void displayOutput(int userAge, DecimalFormat money) {
		if (userAge >= 18)
			// Displaying User's info and dependecy's extra's
		System.out.printf("\n\nName:%30s", userName);
		System.out.printf("\nNumber of dependents:%13s", numOfDept); 
		
		// Accessing dependents name and age array's using the for loop  
		for (int i = 0; i < numOfDept; i++)   {  
				System.out.println("\nName of Dependent(s):\t\t " + storeDeptNames[i] +
								   "\nAge of Dependent(s):\t\t " + storeDeptAges[i]);
		} 
		System.out.printf("\nDependent Cost:%50s", money.format(costOfDept));

		// Displaying Basic cost's and inpatient's info			
		System.out.printf("\nBasic cost (outpatient care):%36s",  money.format(basicCost));
		System.out.printf("\nInpatient Cost:%21s%29s", inpatientInputUpdated, money.format(inpatientCost));
		System.out.printf("\nRoom type:%40s%15s", inpatientRoomType, money.format(inpatientRoomCost));
		
		// Displaying Additional extra's
		System.out.print("\nAdditional extras:\t\t ");
		if (userCareChoice != 0)
			System.out.print(userCareChoiceUpdated);
		// Needed Else, as same variable name with the same purpose but storing 2 different outputs
		else 
			System.out.print(userCareChoiceUpdated);
		
		// Displaying VAT info and the total cost
		System.out.printf("\n\nTotal before VAT:%48s", money.format(totalBeforeVat));
		System.out.printf("\nVAT:%61s", money.format(totalVat));
		System.out.printf("\nTotal:%59s", money.format(totalCost)); 
	} 
}
