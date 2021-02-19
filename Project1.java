import java.util.Scanner;
import java.util.ArrayList;

public class Project1 {
	public enum department {
		mathematics,
		engineering,
		english
	}
		
	public enum rank {
		professor,
		adjunct
	}
		
	public enum status {
		P, F 
	}
		
	ArrayList<User> students = new ArrayList<>();
	ArrayList<User> faculty = new ArrayList<>();
	ArrayList<User> staff = new ArrayList<>();	
	
		
	public static int runMenu() {
		
		int choice = 0;
		final int numStudents = 2;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\t\t\tWelcome to my Personal Management Program");
		System.out.println();
		System.out.println("Choose one of the options:\n"
							+ "1- Enter information for two students\n"
							+ "2- Print tuition invoice\n"
							+ "3- Enter faculty member information\n"
							+ "4- Print faculty member information\n"
							+ "5- Enter staff member information\n"
							+ "6- Print staff member information\n"
							+ "7- Exit Program\n"
							+ "\tEnter your selection: ");	
		
		// Menu selection
		choice = scnr.nextInt();

		switch(choice) {
				// Entering information for 2 students
				case 1:
					for (int i = 0; i < numStudents; ++i) {
						System.out.println("Enter student " + (i + 1) + " info: ");
						User student = new Student();
						student.initStudent(scnr);
						students.add(student);
						System.out.println("Student added!");
					}
					break;
				// Generating invoice for 1 student
				case 2:
					generateInvoice();
					break;
				// Entering information for 1 faculty member
				case 3:
					System.out.println("Enter faculty info: ");
					User faculty = new User();
					faculty.initFaculty(scnr);
					faculty.add(faculty);
					System.out.println("Faculty member added!");
					break;
				// Printing information for 1 faculty member
				case 4:
					printFacultyInfo();
					break;
				// Entering information for 1 staff member
				case 5:
					System.out.println("Enter staff info: ");
					User staff = new Staff();
					staff.initStaff(scnr);
					staff.add(staff);
					System.out.println("Staff member added!");
					break;
				// Printing information for 1 staff member
				case 6:
					printStaffInfo();
					break;
				// Exiting the program
				case 7:
					System.out.println("Exiting Program");
					break;
				// Invalid input choice
				default:
					System.out.println("Invalid entry. Please try again.");
					choice = 0;
					break;
		}
		
		return choice;
	}
	
	

	public static void generateInvoice() {
		int idx = 0;
		int totalCost = 0;
		final double costPerCreditHour = 236.45; 
		final double adminFee = 52.00;
		final double discount = 0.85;
		
		System.out.print("Which student? 1 " + students.get(0).getFullName() + " or 2 " + students.get(1).getFullName() + " ? "); 
		System.out.println();
		
		idx = scnr.nextInt();
		idx--; // to adjust for zero-based index
		
		if (students.get(idx).getGPA >= 3.85)
			totalCost = ((students.get(idx).getCreditHours() * costPerCreditHour) + adminFee) * discount;
		else
			totalCost = (students.get(idx).getCreditHours() * costPerCreditHour) + adminFee;
		
		System.out.println("Here is the tuition invoice for " + students.get(idx).getFullName + " :");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(students.get(idx).getFullName() + "\t" + students.get(idx).getId());
		System.out.println("Credit Hours:" + students.get(idx).getCreditHours() + "\t" + students.get(idx).getId());
		System.out.println("Fees: $" + adminFee);
		System.out.println();
		System.out.println("Total payment (after discount): $"+ totalCost);
		System.out.println("---------------------------------------------------------------------------");
		
	}

	public static void main(String[] args) {
		
		int choice = 0;
		
		// Driver loop
		do {
			choice = runMenu();	
		}while(choice != 7);
		
		// Exit message
		System.out.println("Goodbye!");
		
		return;
	}
}