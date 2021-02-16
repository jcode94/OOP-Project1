import java.util.*;

public class Project1 {
	
	public static int runMenu() {
		
		int choice = 0;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\t\t\tWelcome to my Personal Management Program");
		System.out.println("\n");
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
					// 2students info
					System.out.println("Choice 1");
					break;
				case 2:
					System.out.println("Choice 2");
					break;
				case 3:
					// enter facultyInformation
					System.out.println("Choice 3");
					break;
				case 4:
					// print facultyInformation
					System.out.println("Choice 4");
					break;
				case 5:
					// enter staffInformation
					System.out.println("Choice 5");
					break;
				case 6:
					// print staffInformation
					System.out.println("Choice 6");
					break;
				case 7:
					System.out.println("Choice 7");
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
		
		public Student(String fullName, int id, double gpa, int creditHours) {
			this.fullName = fullName;
			this.id = id;
			this.gpa = gpa;
			this.creditHours = creditHours;
		}
		
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
	}


	public static void generateInvoice() {
	
	}

	class Faculty {
		//private // full name(string?)
		//private // id(int)
		//private // department(enum?, for math, eng or english)
		//private // rank(bool?, for prof. or adj.)
	}
	
	class Staff {
		//private // full name(string?)
		//private // id(int)
		//private // department(enum?, for math, eng or english)
		//private // status(bool? part-time or full-time)
	}
	
	public static void main(String[] args) {
		
		int choice = 0;
		
		do {
			choice = runMenu();	
		}while(choice != 7);
		
		System.out.println("Goodbye!");
		
		return;
	}
}