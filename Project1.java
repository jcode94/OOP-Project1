import java.util.*;

public class Project1 {
	public static void printMenu() {
		System.out.print("\t\t\tWelcome to my Personal Management Program\n"
							+ "Choose one of the options:\n"
							+ "1- Enter information for two students\n"
							+ "2- Print tuition invoice\n"
							+ "3- Enter faculty member information\n"
							+ "4- Print faculty member information\n"
							+ "5- Enter staff member information\n"
							+ "6- Print staff member information\n"
							+ "7- Exit Program\n"
							+ "\tEnter your selection: ");	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Faculty> faculty = new ArrayList<>();
		ArrayList<Staff> staff = new ArrayList<>();	
		int choice;
		final int numStudents = 2;
		// Driver loop
		do {
			printMenu();
			choice = in.nextInt();
			in.nextLine(); // To eat the newline character
			switch(choice) {
				// Entering information for 2 students
				case 1:
					for (int i = 0; i < numStudents; ++i) {
						System.out.println("Enter student " + (i + 1) + " info: ");
						Student newStudent = new Student();
						newStudent.initStudent(in);
						students.add(newStudent);
						System.out.println("Student added!");
					}
					break;
				// Generating invoice for 1 student
				case 2:
					System.out.print("Which student? Enter 1 for " 
									+ students.get(0).getName() + " or Enter 2 for "
									+ students.get(1).getName() + ": ");
					int idx = in.nextInt();
					in.nextLine(); // newline char
					idx--; // for zero-index array
					students.get(idx).generateInvoice();					
					break;
				// Entering information for 1 faculty member
				case 3:
					System.out.println("Enter faculty info: ");
					Faculty newFaculty = new Faculty();
					newFaculty.initFaculty(in);
					faculty.add(newFaculty);
					System.out.println("Faculty member added!");
					break;
				// Printing information for 1 faculty member
				case 4:
					System.out.println("Printing faculty member information...");
					faculty.get(0).print();
					break;
				// Entering information for 1 staff member
				case 5:
					System.out.println("Enter staff info: ");
					Staff newStaff = new Staff();
					newStaff.initStaff(in);
					staff.add(newStaff);
					System.out.println("Staff member added!");
					break;
				// Printing information for 1 staff member
				case 6:
					System.out.println("Printing staff member information");
					staff.get(0).print();
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

class User {
	private String fullName;
	private String id;
	
	User() {
		setName("No Name Set");
		setId("No Name Set");
	}
	
	// generic info for all
	public void initBasicInfo(Scanner in) {
		System.out.print("Name: ");
		String name = in.nextLine();
		setName(name);
		
		System.out.print("ID: ");
		String id = in.nextLine();
		setId(id);
	}
	
	public String getName() {
		return fullName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.fullName = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}

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
		
		System.out.print("GPA: ");
		gpa = in.nextDouble();
		in.nextLine(); // newline
		setGpa(gpa);
		
		System.out.print("Credit Hours: ");
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
			totalPayment = (creditHours * tuition) * (1 - discount);
			totalDiscount = (creditHours * tuition) * discount;
		}
		else
			totalPayment = creditHours * tuition;
			
		System.out.println("Here is the tuition invoice for " + getName() + " :\n"
							+ "---------------------------------------------------------------------------\n"
							+ getName() + "\t\t" + getId() + "\n"
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
		initBasicInfo(in);
		
		System.out.print("Department: ");
		department = in.nextLine();
		setDepartment(department);
		
		System.out.print("Rank: ");
		rank = in.nextLine();
		setRank(rank);		
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
		System.out.println("---------------------------------------------------------------------------"
							+ getName() + "\t\t" + getId() + "\n"
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
		initBasicInfo(in);
		
		System.out.print("Department: ");
		department = in.nextLine();
		setDepartment(department);
		
		System.out.print("Status: ");
		status = in.nextLine();
		setStatus(status);		
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
		System.out.println("---------------------------------------------------------------------------"
							+ getName() + "\t\t" + getId() + "\n"
							+ getDepartment() + " Department, " + getStatus() + "\n"
							+ "---------------------------------------------------------------------------\n");
	}
}
