import java.util.Scanner;

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
							+ " " + getName() + "\t\t" + getId() + "\n\n"
							+ " " + getDepartment() + " Department, " + getRank() + "\n"
							+ "---------------------------------------------------------------------------\n");
	}
}
