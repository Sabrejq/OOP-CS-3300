/* 
 		Program written by Julio Quintero 14/1/2020  dd/mm/yyyy
   Spring 2020, CS3300: OOP – Assignment1 (100 points)

*/

package OOP_spring_2020;
import java.util.Scanner;
import static java.lang.System.*;

public class Assigment_One {
	
	public static void main(String[] args) 
	{
		// ****** Variable declaration ******  //
		
		// Scanner to read inputs
		Scanner input = new Scanner(System.in);
		String userInput;
		
		// Menu controller 
		boolean menu = true; 
		
		// String for formatting 
		String divider = "-------------------------------------------------------------------\n";
		
		// Only loop to for menu like interface
		do {
			
			// variable declaration 
			float rate = 17.25f;
			int hoursWorked = 0;
			int overtime = 0;
			float grossPaid = 0.0f;
			float netPaid = 0.0f;
			float additionalInsurance = 0.0f;
			
			float federalTax = 0.0f;
			float incomeTax = 0.0f;
			int dependents = 0;
			
			String employeeName = " ";
			
			 // User inputs
			out.print("Employee's name: ");
			employeeName = input.nextLine();
			
			out.print("Hours worked by "+ employeeName + ": ");
			hoursWorked = input.nextInt();
			
			out.print("Number of "+employeeName+"'s dependents: ");
			dependents = input.nextInt();
			
			// Calculates paid depending on hours worked. Each if is a break point for overtime
			if (hoursWorked <= 40) {
				grossPaid = (hoursWorked * rate);
				
			}
			else if (hoursWorked > 40 && hoursWorked <= 60 ) {
				grossPaid = (rate*40); 
				overtime = hoursWorked - 40;
				grossPaid = grossPaid + (12.34f * overtime);
			}
			
			else if(hoursWorked > 60 && hoursWorked <= 80) {
				grossPaid = (rate*40); 
				overtime = hoursWorked - 40;
				grossPaid = grossPaid + (14.34f * overtime);
				
			}
			
			else if(hoursWorked > 80) {
				grossPaid = (rate*40); 
				overtime = hoursWorked - 40;
				grossPaid = grossPaid + (16.00f * overtime);
			}
			
			if (dependents >= 3) {
				
				additionalInsurance = 25 * (dependents - 2);
				
			}
			
			 // Calculates Net paid using Federal and state Tax
	
			 federalTax = (grossPaid*0.14f);
			 incomeTax =  (grossPaid*0.05f);
			 netPaid = grossPaid - (federalTax + incomeTax + 80 + additionalInsurance);
			
			
			 // ************************* Output *************************
			 out.print(divider);
			 out.printf("%-40s %5s %s %n", "Employee's name", ":", employeeName);
			 out.printf("%-40s %5s %s %n", "Number of Dependents", ":", dependents);
			 out.printf("%-40s %5s %s %n", "Hours Worked", ":", hoursWorked);
			 out.printf("%-40s %5s %s %n", "Overtime hours", ":", overtime);
			 out.printf("%-40s %5s %.2f %n", "Gross Income", ":", grossPaid);
			 out.printf("%-40s %5s %.2f %n", "State Tax Withheld %5", ":", incomeTax);
			 out.printf("%-40s %5s %.2f %n", "Federal Tax Withheld %14", ":", federalTax);
			 out.printf("%-40s %5s %.2f %n", "Worker and 2 Depenents's Insurance", ":", 80.00);
			 out.printf("%-40s %5s %.2f %n", "Additional Dependents insurance", ":", additionalInsurance);
			 out.print(divider);
			 out.printf("%-40s %5s %.2f %n", "Net take Home Pay", ":", netPaid);
			
			 out.print(divider);
			 
			 
			 /* 
			  	Choice for the user to break out of the menu by setting 
			 the variable menu to false, or true if the user wants to continue 
			 */
			 out.print("Do you want to enter another employee? y/n \n");
			 input.nextLine();
			 userInput = input.nextLine();
			 
			 if (userInput.equals("Y") || userInput.equals("y")) {
				 menu = true;
			 }
			 else {
				 menu = false;
				 out.print("Terminaning program.....\n");
				 out.print("Terminaning .....\n");
				 out.print("Goodbye!\n");
				 
			 }
			 

		 } while(menu == true);
		
		// Closes scanner to avoid memory issues 
		input.close();
	  }

}
