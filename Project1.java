import java.util.*;

public class Project1 {
	enum department {
			mathematics,
			engineering,
			english
		}
		
		enum rank {
			professor,
			adjunct
		}
		
		enum status {
			P, 									// Part-time
			F									// Full-time
		}
		
	public static int runMenu() { // Considering passing the 3 ArrayLists through here
		
		int choice = 0;
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
				case 1:
					System.out.println("Entering info for 2 students");
					break;
				case 2:
					//generateInvoice(Students);
					break;
				case 3:
					System.out.println("Entering faculty information");
					break;
				case 4:
					System.out.println("Printing faculty information...");
					break;
				case 5:
					System.out.println("Entering staff information");
					break;
				case 6:
					System.out.println("Printing staff information...");
					break;
				case 7:
					System.out.println("Exiting Program");
					break;
				default:
					System.out.println("Invalid choice. Please choose another.");
					choice = 0;
					break;
		}
		
		return choice;
	}
	
	public class Student {
		private String fullName;
		private int id;
		private double gpa;
		private int creditHours;
		
		final int numStudents = 2;
		
		// constructor
		public Student(String fullName, int id, double gpa, int creditHours) {
			this.fullName = fullName;
			this.id = id;
			this.gpa = gpa;
			this.creditHours = creditHours;
		}
		
		// Getters
		// Returns name
		public String getName() {
			return fullName;
		}
		
		// Returns id
		public int getId() {
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
		public void setId(int id) {
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
	public static void generateInvoice(ArrayList<Student> students, Scanner scnr) {
		int idx = 0;
		
		System.out.print("Which student? Enter 1 for FIRST STUDENT and 2 for SECOND STUDENT"); // FIX ME
		idx = scnr.nextInt();
		
		//System.out.print("Here is the tuition invoice for " + students[idx].getFullName);
	}

	class Faculty {
		private String fullName; 
		private int id;
		private department dept;
		private rank rank;
		
		// constructor
		public Faculty(String fullName, int id, department dept, rank rank) {
			this.fullName = fullName;
			this.id = id;
			this.dept = dept;
			this.rank = rank;
		}
		
		// Getters
		// Returns name
		public String getName() {
			return fullName;
		}
		
		// Returns id
		public int getId() {
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
		public void setId(int id) {
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
		private int id;
		private department dept;
		private status status;
		
		public Staff(String fullName, int id, department dept, status status) {
			this.fullName = fullName;
			this.id = id;
			this.dept = dept;
			this.status = status;
		}
		
		// Getters
		// Returns name
		public String getName() {
			return fullName;
		}
		
		// Returns id
		public int getId() {
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
		public void setId(int id) {
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