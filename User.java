import java.util.*;

public class User {
	private String fullName;
	private String id;
	private double gpa;
	private int creditHours;
	private String department;
	private String rank;
	private String status;
	
	// student constructor
	public User() {
	}
	
	// generic info for all
	public void initBasicInfo(Scanner in) {
		this.fullName = setName(in);
		this.id = setId(in);
	}
	
	public void initStudent(Scanner in) {
		initBasicInfo(in);
	
		this.gpa = setGpa(in);
		this.creditHours = setCreditHours(in);
	}
	
	public void initFaculty(Scanner in) {
		initBasicInfo(in);
	
		this.department = setDepartment(in);
		this.rank = setRank(in);
	}
	
	public void initStaff(Scanner in) {
		initBasicInfo(in);
	
		this.department = setDepartment(in);
		this.status = setStatus(in);
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
	public String getDepartment() {
		return department;
	}
	
	// Returns rank
	public String getRank() {
		return rank;
	}
	
	// Returns creditHours
	public String getStatus() {
		return status;
	}
	
	public String setName(Scanner in) {
		String fullName;
		System.out.print("Name: ");
		fullName = in.nextLine();
		return fullName;
	}
	
	public String setId(Scanner in) {
		String id;
		System.out.print("ID: ");
		id = in.next();
		return id;
	}
	
	public double setGpa(Scanner in) {
		double gpa;
		System.out.print("Gpa: ");
		gpa = in.nextDouble();
		return gpa;
	}
	
	public int setCreditHours(Scanner in) {
		int creditHours;
		System.out.print("Credit hours: ");
		creditHours = in.nextInt();
		return creditHours;
	}
	
	public String setDepartment(Scanner in) {
		String department;
		Set<String> set = new HashSet<>();
		set.add("mathematics");
		set.add("engineering");
		set.add("english");
		
		do {				
			System.out.print("Department: ");
			department = in.nextLine().toLowerCase();
			if (!set.contains(department))
				System.out.println("\"" + department + "\" is invalid");
		}while (!set.contains(department));
		return department;				
	}
	
	public String setRank(Scanner in) {
		String rank;
		Set<String> set = new HashSet<>();
		set.add("professor");
		set.add("adjunct");
		
		do {				
			System.out.print("Rank: ");
			rank = in.nextLine();
			if (!set.contains(rank))
				System.out.println("\"" + rank + "\" is invalid");
		}while (!set.contains(rank));
		return rank;	
	}
	
	public String setStatus(Scanner in) {
		String status;
		Set<String> set = new HashSet<>();
		set.add("p");
		set.add("f");
		
		do {				
			System.out.print("Status: ");
			status = in.nextLine();
			if (!set.contains(status))
				System.out.println("\"" + status + "\" is invalid");
		}while (!set.contains(status));
		return status;	
	}
	
		
}