import java.util.*;

public class Project1 {
	
	static ArrayList<User> studentList = new ArrayList<>();
	static ArrayList<User> facultyList = new ArrayList<>();
	static ArrayList<User> staffList = new ArrayList<>();	
	
	public static int runMenu() {
		
		int choice = 0;
		final int numStudents = 2;
		Scanner in = new Scanner(System.in);
		
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
		choice = in.nextInt();

		switch(choice) {
				// Entering information for 2 students
				case 1:
					for (int i = 0; i < numStudents; ++i) {
						System.out.println("Enter student " + (i + 1) + " info: ");
						User student = new User();
						student.initStudent(in);
						studentList.add(student);
						System.out.println("Student added!");
					}
					break;
				// Generating invoice for 1 student
				case 2:
					generateInvoice(in);
					break;
				// Entering information for 1 faculty member
				case 3:
					System.out.println("Enter faculty info: ");
					User faculty = new User();
					faculty.initFaculty(in);
					facultyList.add(faculty);
					System.out.println("Faculty member added!");
					break;
				// Printing information for 1 faculty member
				case 4:
					printFacultyInfo();
					break;
				// Entering information for 1 staff member
				case 5:
					System.out.println("Enter staff info: ");
					User staff = new User();
					staff.initStaff(in);
					staffList.add(staff);
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
	
	public static void printFacultyInfo() {
		System.out.println("---------------------------------------------------------------------------\n"
							+ facultyList.get(0).getName() + "\t" + facultyList.get(0).getId() + "\n"
							+ facultyList.get(0).getDepartment() + ", " + facultyList.get(0).getRank() + "\n"
							+ "---------------------------------------------------------------------------");
	}
	
	public static void printStaffInfo() {
		System.out.println("---------------------------------------------------------------------------\n"
							+ staffList.get(0).getName() + "\t" + staffList.get(0).getId() + "\n"
							+ staffList.get(0).getDepartment() + ", " + staffList.get(0).getStatus() + "\n"
							+ "---------------------------------------------------------------------------");
	}
	
	public static void generateInvoice(Scanner in) {
		int idx;
		double totalCost, totalDiscount = 0.0;
		final double costPerCreditHour = 236.45; 
		final double adminFee = 52.00;
		final double discount = 0.15;
		
		System.out.print("Which student? 1 " + studentList.get(0).getName() 
								  + " or 2 " + studentList.get(1).getName() + " ? "); 
		
		
		idx = in.nextInt();
		idx--; // to adjust for zero-based index
		
		if (studentList.get(idx).getGpa() >= 3.85) {
			totalCost = ((studentList.get(idx).getCreditHours() * costPerCreditHour) + adminFee) * (1 - discount);
			totalDiscount = ((studentList.get(idx).getCreditHours() * costPerCreditHour) + adminFee) * discount;
		}
		else
			totalCost = (studentList.get(idx).getCreditHours() * costPerCreditHour) + adminFee;
		
		System.out.println("\nHere is the tuition invoice for " + studentList.get(idx).getName() + " :\n"
							+ "---------------------------------------------------------------------------\n"
							+ studentList.get(idx).getName() + "\t" + studentList.get(idx).getId() + "\n"
							+ "Credit Hours:" + studentList.get(idx).getCreditHours() + "\t($236.45/credit hour)\n"
							+ "Fees: $52\n\n"
							+ "Total payment (after discount): $"+ totalCost + "\t\t($" + totalDiscount + "discount applied)\n"
							+ "---------------------------------------------------------------------------");
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