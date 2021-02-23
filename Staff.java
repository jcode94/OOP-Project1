import java.util.Scanner;

public class Staff extends User {
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
							+ " " + getName() + "\t\t" + getId() + "\n\n"
							+ " " + getDepartment() + " Department, " + getStatus() + "\n"
							+ "---------------------------------------------------------------------------\n");
	}
}
