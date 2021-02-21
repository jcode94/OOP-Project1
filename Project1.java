/*
-  Project 1
-  Justice Smith, Taylor Andrew
*/

import java.util.*;

public class Project1 {
	public static void printMenu() {
		System.out.print("Choose one of the options:\n\n"
							+ "1- Enter information for two students\n"
							+ "2- Print tuition invoice\n"
							+ "3- Enter faculty member information\n"
							+ "4- Print faculty member information\n"
							+ "5- Enter staff member information\n"
							+ "6- Print staff member information\n"
							+ "7- Exit Program\n\n"
							+ "\tEnter your selection: ");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Faculty> faculty = new ArrayList<>();
		ArrayList<Staff> staff = new ArrayList<>();	

		int choice;
		final int numStudents = 2;
		
		System.out.println("\t\t\tWelcome to my Personal Management Program\n\n");
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
						System.out.print("You already have two students filled in. Do you want to update their information?\n"
										 + "Yes or No: ");
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
							System.out.println("Enter student " + (i + 1) + " info: \n");
							Student newStudent = new Student();
							newStudent.initStudent(in);
							students.add(newStudent);
							System.out.println("\nStudent added!\n\n");
						}
						
					break;
					
				// Generating invoice for 1 student
				case 2:
					if (!students.isEmpty()) {
						System.out.print("Which student? Enter 1 for " 
										+ students.get(0).getName() + " or Enter 2 for "
										+ students.get(1).getName() + ": ");
						int idx = in.nextInt();
						in.nextLine(); // newline char
						idx--; // for zero-index array
						students.get(idx).generateInvoice();					
					}
					else
						System.out.println("The system contains no student information.\n");
					break;
				// Entering information for 1 faculty member
				case 3:
					System.out.println("Enter faculty info:\n");
					Faculty newFaculty = new Faculty();
					newFaculty.initFaculty(in);
					faculty.add(newFaculty);
					System.out.println("Faculty member added!");	
					break;
				// Printing information for 1 faculty member
				case 4:
					if (!faculty.isEmpty()) 
						faculty.get(0).print();
					else
						System.out.println("The system contains no faculty information.\n");
					break;
				// Entering information for 1 staff member
				case 5:
					System.out.println("Enter staff info:\n");
					Staff newStaff = new Staff();
					newStaff.initStaff(in);
					staff.add(newStaff);
					System.out.println("Staff member added!");
					break;
				// Printing information for 1 staff member
				case 6:
					if (!staff.isEmpty())
						staff.get(0).print();
					else
						System.out.println("The system contains no staff information.\n");
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
		} while(choice != 7);
		
		// Exit Message
		System.out.println("Goodbye!");
		
		return;
	}	
}

// Parent class
class User {
	// Instance variables
	private String fullName;
	private String id;
	
	// Constructor
	User() {
		setName("No Name Set");
		setId("No Name Set");
	}
	
	// Generic info shared by all child classes
	public void initBasicInfo(Scanner in) {
		System.out.print("\tName: ");
		String name = in.nextLine();
		setName(name);
		
		System.out.print("\tID: ");
		String id = in.nextLine();
		setId(id);
	}
	
	// Getters
	public String getName() {
		return fullName;
	}
	
	public String getId() {
		return id;
	}
	
	// Setters
	public void setName(String name) {
		this.fullName = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}

// Child class
class Student extends User {
	// Instance variables
	private double gpa;
	private int creditHours;
	
	// Constructor
	Student() {
		super();
		setGpa(0.0);
		setCreditHours(0);
	}
	
	public void initStudent(Scanner in) {
		double gpa;
		int creditHours;
		
		initBasicInfo(in);
		
		System.out.print("\tGPA: ");
		gpa = in.nextDouble();
		in.nextLine(); // newline
		setGpa(gpa);
		
		System.out.print("\tCredit Hours: ");
		creditHours = in.nextInt();
		in.nextLine(); // newline
		setCreditHours(creditHours);		
	}
	
	public void generateInvoice() {
		final double tuition = 236.45;
		final int fees = 52;
		final double discount = 0.15;
		double totalPayment;
		double totalDiscount = 0;
		
		if (getGpa() >= 3.85) {
			totalPayment = ((creditHours * tuition) + fees) * (1 - discount);
			totalDiscount = ((creditHours * tuition) + fees) * discount;
		}
		else
			totalPayment = (creditHours * tuition) + fees;
			
		System.out.println("Here is the tuition invoice for " + getName() + " :\n"
							+ "---------------------------------------------------------------------------\n"
							+ getName() + "\t\t\t" + getId() + "\n"
							+ "Credit Hours:" + getCreditHours() + " ($236.45/credit hour)\n"
							+ "Fees: $" + fees + "\n\n"
							+ "Total payment (after discount): $" + String.format("%.2f", totalPayment) + "\t\t($" + String.format("%.2f", totalDiscount) + " discount applied)\n"
							+ "---------------------------------------------------------------------------");
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public int getCreditHours() {
		return creditHours;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
}

// Child class
class Faculty extends User {
	// Instance variables
	private String department;
	private String rank;
	
	// Constructor
	Faculty() {
		super();
		setDepartment("No Department Set");
		setRank("No Rank Set");
	}
	
	public void initFaculty(Scanner in) {
		String department;
		String rank;
		boolean dept;
		
		initBasicInfo(in);
		
		// Sadly, XOR is only a binary operator and not n-ary
		do {
			// Getting Department
			System.out.print("\tDepartment: ");
			department = in.nextLine();
			
			if (department.equalsIgnoreCase("mathematics")) {
				dept = true;
				department = "Mathematics";
			}
			else if (department.equalsIgnoreCase("engineering")) {
				dept = true;
				department = "Engineering";
			}
			else if (department.equalsIgnoreCase("english")) {
				dept = true;
				department = "English";
			}
			else {
				System.out.println("\nInvalid department. Please try again.\n");
				dept = false;
			}
		}while (!dept);
		
		setDepartment(department);
		
		// Getting Rank
		System.out.print("\tRank: ");
		rank = in.nextLine();
		// "While not exactly one is true"
		while (!(rank.equalsIgnoreCase("professor") ^ rank.equalsIgnoreCase("adjunct"))) {
			System.out.println("\nInvalid rank. Please try again.\n");
			System.out.print("\tRank: ");
			rank = in.nextLine();
		}
		// "Exactly one must be true"
		if (rank.equalsIgnoreCase("professor"))
			setRank("Professor");
		else
			setRank("Adjunct");
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	// Outputs the faculty info
	public void print() {
		System.out.println("---------------------------------------------------------------------------\n"
							+ getName() + "\t\t" + getId() + "\n\n"
							+ getDepartment() + " Department, " + getRank() + "\n"
							+ "---------------------------------------------------------------------------\n");
	}
}

class Staff extends User {
	// Instance variables
	private String department;
	private String status;
	
	// Constructor
	Staff() {
		super();
		setDepartment("No Department Set");
		setStatus("No Status Set");
	}
	
	public void initStaff(Scanner in) {
		String department;
		String status;
		boolean dept;
		
		initBasicInfo(in);
		
		do {
			// Getting Department
			System.out.print("\tDepartment: ");
			department = in.nextLine();
			
			if (department.equalsIgnoreCase("mathematics")) {
				dept = true;
				department = "Mathematics";
			}
			else if (department.equalsIgnoreCase("engineering")) {
				dept = true;
				department = "Engineering";
			}
			else if (department.equalsIgnoreCase("english")) {
				dept = true;
				department = "English";
			}
			else {
				System.out.println("\nInvalid department. Please try again.\n");
				dept = false;
			}
		}while (!dept);
		
		setDepartment(department);
		
		// Getting Status
		System.out.print("\tStatus, Enter P for Part Time or Enter F for Full Time: ");
		status = in.nextLine();
		// "while not exactly one is true"
		while (!(status.equalsIgnoreCase("p") ^ status.equalsIgnoreCase("f"))) {
			System.out.println("\nInvalid status. Please try again.\n");
			System.out.print("\tStatus, Enter P for Part Time or Enter F for Full Time: ");
			status = in.nextLine();
		}
		// Exactly one must be true
		if (status.equalsIgnoreCase("p"))
			setStatus("Part-time");
		else
			setStatus("Full-time");
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	// Outputs the staff info
	public void print() {
		System.out.println("---------------------------------------------------------------------------\n"
							+ getName() + "\t\t" + getId() + "\n\n"
							+ getDepartment() + " Department, " + getStatus() + "\n"
							+ "---------------------------------------------------------------------------\n");
	}
}
