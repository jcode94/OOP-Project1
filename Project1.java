import java.util.*

public class Project1 {
	
	public static void displayMenu() {
		System.out.println("\t\t\tWelcome to my Personal Management Program");
		System.out.println("1- Enter information for two students");
		System.out.println("2- Print tuition invoice");//hellooo
		System.out.println("3- Enter faculty member information");
		System.out.println("4- Print faculty member information");
		System.out.println("5- Enter staff member information");
		System.out.println("6- Print staff member information");
	}

	public static void getFacultyInformation {
		private // full name(string?)
		private // id(int)
		private // department(enum?, for math, eng or english)
		private // rank(bool?, for prof. or adj.)
	}
	
	public static void Student {
		// Private variables are only 'visible' to the 
		// class in which they exist. Conversely, public
		// variables are accessible from any class
		private // full name(string?)
		private // id(int)
		private // gpa(double)
		private // number of credit hours(int)
	}
	
	public static void generateInvoice {
	
	}
	
	public static void Staff {
		private // full name(string?)
		private // id(int)
		private // department(enum?, for math, eng or english)
		private // status(bool? part-time or full-time)
	}
	
	public static void main(String[] args) {
		
		int choice = 0;
		Scanner.scnr = new Scanner(System.in);
		
		while (choice != 7) {
			displayMenu();
			choice = scnr.nextInt();
			switch(choice) {
				case 1:
					// 2students info
					break;
				case 2:
					generateInvoice();
					break;
				case 3:
					// enter facultyInformation
					break;
				case 4:
					// print facultyInformation
					break;
				case 5:
					// enter staffInformation
					break;
				case 6:
					// print staffInformation
					break;
				case 7:
					break;
			}		
		}
		
		System.out.println("Goodbye!");
		
		return 0;
	}
}