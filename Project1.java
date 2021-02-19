import java.util.Scanner;
import java.util.ArrayList;

public class Project1 {
	
		
	public static ArrayList<User> students = new ArrayList<>();
	public static ArrayList<User> faculty = new ArrayList<>();
	public static ArrayList<User> staff = new ArrayList<>();	
	
		
	public static int runMenu() {
		
		int choice = 0;
		final int numStudents = 2;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\t\t\tWelcome to my Personal Management Program\n"
							+ "Choose one of the options:\n"
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
						User student = new User();
						student.initStudent(scnr);
						students.add(student);
						System.out.println("Student added!");
					}
					break;
				// Generating invoice for 1 student
				case 2:
					User.generateInvoice();
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
					User.printFacultyInfo();
					break;
				// Entering information for 1 staff member
				case 5:
					System.out.println("Enter staff info: ");
					User staff = new User();
					staff.initStaff(scnr);
					staff.add(staff);
					System.out.println("Staff member added!");
					break;
				// Printing information for 1 staff member
				case 6:
					User.printStaffInfo();
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