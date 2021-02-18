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
		
	ArrayList<User> students = new ArrayList<User>();
	ArrayList<User> faculty = new ArrayList<User>();
	ArrayList<User> staff = new ArrayList<User>();	
	
		
	public static int runMenu() {
		
		int choice = 0;
		final int numStudents = 2;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\t\t\tWelcome to my Personal Management Program");
		System.out.println();
		System.out.println("Choose one of the options:\n");
		System.out.println("1- Enter information for two students");
		System.out.println("2- Print tuition invoice");//hellooo
		System.out.println("3- Enter faculty member information");
		System.out.println("4- Print faculty member information");
		System.out.println("5- Enter staff member information");
		System.out.println("6- Print staff member information");
		System.out.println("7- Exit Program\n");
		System.out.print("\tEnter your selection: ");	
		
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
	
	public class User {
		private String fullName;
		private String id;
		private double gpa;
		private int creditHours;
		private department department;
		private rank rank;
		private status status;
		
		// student constructor
		public User(String fullName, String id, double gpa, int creditHours) {
			this.fullName = fullName;
			this.id = id;
			this.gpa = gpa;
			this.creditHours = creditHours;
		}
		
		public User(String fullName, String id, department department, rank rank) {
			this.fullName = fullName;
			this.id = id;
			this.department = department;
			this.rank = rank;
		}
		
		public User(String fullName, String id, department department, status status) {
			this.fullName = fullName;
			this.id = id;
			this.department = department;
			this.status = status;
		}
		
		public static void initBasicInfo(Scanner scnr) {
			// String fullName, int id
			System.out.print("Name of Student: ");
			this.fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			this.id = scnr.next();
		}
		
		public static void initStudent(Scanner scnr) {
			
			initBasicInfo(scnr);
		
			// gpa, creditHours
			System.out.print("Name of Student: ");
			this.fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			this.id = scnr.next();
		}
		
		public static void initFaculty(Scanner scnr) {
			
			initBasicInfo(scnr);
		
			// department, rank
			System.out.print("Department: ");
			this.department = scnr.nextLine();
			
			System.out.print("Rank: ");
			this.rank = scnr.next();
		}
		
		public static void initStaff(Scanner scnr) {
			
			initBasicInfo(scnr);
		
			// department, status
			System.out.print("Department: ");
			this.department = scnr.nextLine();
			
			System.out.print("Status: ");
			this.status = scnr.next();
		}
		
		// Getters
		// Returns name
		public String getName() {
			return fullName;
		}
		
		// Returns id
		public String getId() {
			return id;
		}
		
		// Returns gpa
		public double getGpa() {
			return gpa;
		}
		
		// Returns creditHours
		public int getCreditHours() {
			return creditHours;
		}
		
				
		// Returns department
		public department getdepartment() {
			return department;
		}
		
		// Returns rank
		public rank getRank() {
			return rank;
		}
		
		// Returns creditHours
		public status getStatus() {
			return status;
		}
		
		// Setters
		// sets name
		public void setName(String fullName) {
			this.fullName = fullName;
		}
		
		// sets id
		public void setId(String id) {
			this.id = id;
		}
		
		// sets gpa
		public void setGpa(double gpa) {
			this.gpa = gpa;
		}
		
		// sets creditHours
		public void setCreditHours(int creditHours) {
			this.creditHours = creditHours;
		}
		
		// sets department
		public void setdepartment(department department) {
			this.department = department;
		}
		
		// sets rank
		public void setRank(rank rank) {
			this.rank = rank;
		}
		
		// sets status
		public void setStatus(status status) {
			this.status = status;
		}
		
		public void printFacultyInfo() {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println(faculty.get(0).getFullName + "\t" + faculty.get(0).getId);
			System.out.println(faculty.get(0).getdepartment + ", " + faculty.get(0).getRank);
			System.out.println("---------------------------------------------------------------------------");
		}
		
		public void printStaffInfo() {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println(staff.get(0).getFullName + "\t" + staff.get(0).getId);
			System.out.println(staff.get(0).getdepartment + ", " + staff.get(0).getStatus);
			System.out.println("---------------------------------------------------------------------------");
		}
		
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