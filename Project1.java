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
		
	ArrayList<Student> students = new Arraylist<Student>();
	ArrayList<Faculty> faculty = new Arraylist<Faculty>();
	ArrayList<Staff> staff = new Arraylist<Staff>();	
	
		
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
						Student student = new Student();
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
					Faculty faculty = new Faculty();
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
					Staff staff = new Staff();
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
					System.out.println("Invalid choice. Please choose another.");
					choice = 0;
					break;
		}
		
		return choice;
	}
	
	public class Student {
		private String fullName;
		private String id;
		private double gpa;
		private int creditHours;
		
		final int numStudents = 2;
		
		// constructor
		public Student() {
			scnr = new Scanner(System.in);
			// String fullName, int id, double gpa, int creditHours
			System.out.print("Name of Student: ");
			fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			id = scnr.next();
			
			System.out.print("Gpa: ");
			gpa = scnr.nextDouble();
			
			System.out.print("Credit Hours: ");
			creditHours = scnr.nextInt();
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
	}

	// FIX ME
	public static void generateInvoice() {
		private int idx = 0;
		private totalCost = 0;
		final double costPerCreditHour = 236.45; 
		final double adminFee = 52.00;
		
		
		System.out.print("Which student? 1 " + students.get(0).getFullName() + " or 2 " + students.get(1).getFullName() + " ? "); 
		idx = scnr.nextInt() - 1;
		totalCost = students.get(
		
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(students.get(idx).getFullName() + "\t" + students.get(idx).getId());
		System.out.println("Credit Hours:" + students.get(idx).getCreditHours() + "\t" + students.get(idx).getId());
		System.out.println("Fees: $" + adminFee);
		System.out.println();
		System.out.println("Total payment (after discount): $"+ );
		System.out.println("---------------------------------------------------------------------------");
		
		
		//System.out.print("Here is the tuition invoice for " + students[idx].getFullName);
	}

	class Faculty {
		private String fullName; 
		private String id;
		private department dept;
		private rank rank;
		
		// constructor
		public Faculty(String fullName, int id, department dept, rank rank) {
			scnr = new Scanner(System.in);
			// String fullName, int id, enum dept, enum status
			System.out.print("Name of Staff: ");
			fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			id = scnr.next();
			
			System.out.print("Department: "); // check against enum
			dept = scnr.next().toLowerCase();
			
			System.out.print("Rank: ");
			String tempRank = next().toLowerCase();
			for (enum rank: enum
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
		
		// Returns dept
		public department getDept() {
			return dept;
		}
		
		// Returns rank
		public rank getRank() {
			return rank;
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
		
		// sets dept
		public void setDept(department dept) {
			this.dept = dept;
		}
		
		// sets rank
		public void setRank(rank rank) {
			this.rank = rank;
		}
	}
	
	class Staff {
		private String fullName; 
		private String id;
		private department dept;
		private status status;
		
		public Staff() {
			scnr = new Scanner(System.in);
			// String fullName, int id, enum dept, enum status
			System.out.print("Name of Staff: ");
			fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			id = scnr.next();
			
			System.out.print("Department: "); // check against enum
			dept = scnr.next().toLowerCase();
			
			System.out.print("Status: ");
			status = scnr.next();
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
		public department getDept() {
			return dept;
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
		
		// sets dept
		public void setDept(department dept) {
			this.dept = dept;
		}
		
		// sets status
		public void setStatus(status status) {
			this.status = status;
		}
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