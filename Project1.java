/*
-  Project 1
-  Justice Smith, Taylor Andrew
*/

import java.util.*;

public class Project1 {
	public static void printMenu() {
		System.out.print(" Choose one of the options:\n\n"
							+ " 1- Enter information for two students\n"
							+ " 2- Print tuition invoice\n"
							+ " 3- Enter faculty member information\n"
							+ " 4- Print faculty member information\n"
							+ " 5- Enter staff member information\n"
							+ " 6- Print staff member information\n"
							+ " 7- Exit Program\n\n"
							+ "\tEnter your selection: ");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Faculty> faculty = new ArrayList<>();
		ArrayList<Staff> staff = new ArrayList<>();	

		int choice;
		final int numStudents = 2;
		
		System.out.println("\n\t\t\tWelcome to my Personal Management Program\n\n");
		// Driver loop
		do {
			printMenu();
			while (!in.hasNextInt()) {
				in.nextLine();
				System.out.println("\nInvalid entry - please try again.\n");
				System.out.print("\tEnter your selection: ");
			}
				
			choice = in.nextInt();
			in.nextLine(); // To eat the newline character
			System.out.println("\n"); // Formatting
			
			switch(choice) {
				// Entering information for 2 students
				case 1:
					// Record exists
					if (!students.isEmpty()) {
						System.out.print(" You already have two students filled in. Do you want to update their information?\n"
										 + " Yes or No: ");
						String overwrite = in.nextLine();
						if (overwrite.equalsIgnoreCase("Yes")) {
							for (int i = 0; i < numStudents; ++i) {
								System.out.println("Enter student " + (i + 1) + " info: \n");
								Student newStudent = new Student();
								newStudent.initStudent(in);
								students.add(newStudent);
								System.out.println("\nStudent added!\n\n");
							}
							break;
						}
						break; // overwrite = "No" or something else
					}
					// No record
					else
						for (int i = 0; i < numStudents; ++i) {
							System.out.println(" Enter student " + (i + 1) + " info: \n");
							Student newStudent = new Student();
							newStudent.initStudent(in);
							students.add(newStudent);
							System.out.println("\nStudent added!\n\n");
						}
						
					break;
					
				// Generating invoice for 1 student
				case 2:
					if (!students.isEmpty()) {
						System.out.print(" Which student? Enter 1 for " 
										+ students.get(0).getName() + " or Enter 2 for "
										+ students.get(1).getName() + ": ");
						int idx = in.nextInt();
						in.nextLine(); // newline char
						idx--; // for zero-index array
						students.get(idx).generateInvoice();					
					}
					else
						System.out.println(" The system contains no student information.\n");
					break;
				// Entering information for 1 faculty member
				case 3:
					System.out.println(" Enter faculty info:\n");
					Faculty newFaculty = new Faculty();
					newFaculty.initFaculty(in);
					faculty.add(newFaculty);
					System.out.println(" Faculty member added!");	
					break;
				// Printing information for 1 faculty member
				case 4:
					if (!faculty.isEmpty()) 
						faculty.get(0).print();
					else
						System.out.println(" The system contains no faculty information.\n");
					break;
				// Entering information for 1 staff member
				case 5:
					System.out.println(" Enter staff info:\n");
					Staff newStaff = new Staff();
					newStaff.initStaff(in);
					staff.add(newStaff);
					System.out.println(" Staff member added!");
					break;
				// Printing information for 1 staff member
				case 6:
					if (!staff.isEmpty())
						staff.get(0).print();
					else
						System.out.println(" The system contains no staff information.\n");
					break;
				// Exiting the program
				case 7:
					System.out.println(" Exiting Program");
					break;
				// Invalid input choice
				default:
					System.out.println(" Invalid entry. Please try again.");
					choice = 0;
					break;
			}
		} while(choice != 7);
		
		// Exit Message
		System.out.println(" Goodbye!");
		
		return;
	}	
}
