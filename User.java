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
		public String getdepartment() {
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
			private static final Set<String> VALUES = Set.of(
				"mathematics", "engineering", "english"
			);
			do {				
				System.out.print("Department: ");
				department = in.nextLine().toLowerCase();
				if (!VALUES.contains(department))
					System.out.println("\"" + department + "\" is invalid");
			}while (!VALUES.contains(department));
			return department;				
		}
		
		public String setRank(Scanner in) {
			String rank;
			private static final Set<String> VALUES = Set.of(
				"professor", "adjunct"
			);
			do {				
				System.out.print("Rank: ");
				rank = in.nextLine();
				if (!VALUES.contains(rank))
					System.out.println("\"" + rank + "\" is invalid");
			}while (!VALUES.contains(rank));
			return rank;	
		}
		
		public String setStatus(Scanner in) {
			String status;
			private static final Set<String> VALUES = Set.of(
				"p", "f"
			);
			do {				
				System.out.print("Status: ");
				status = in.nextLine();
				if (!VALUES.contains(status))
					System.out.println("\"" + status + "\" is invalid");
			}while (!VALUES.contains(status));
			return status;	
		}
		
		public static void printFacultyInfo() {
			System.out.println("---------------------------------------------------------------------------\n"
								+ faculty.get(0).getFullName() + "\t" + faculty.get(0).getId() + "\n"
								+ faculty.get(0).getDepartment() + ", " + faculty.get(0).getRank() + "\n"
								+ "---------------------------------------------------------------------------");
		}
		
		public static void printStaffInfo() {
			System.out.println("---------------------------------------------------------------------------\n"
								+ staff.get(0).getFullName() + "\t" + staff.get(0).getId() + "\n"
								+ staff.get(0).getDepartment() + ", " + staff.get(0).getStatus() + "\n"
								+ "---------------------------------------------------------------------------");
		}
		
		public static void generateInvoice() {
			int idx;
			double totalCost, totalDiscount = 0.0;
			final double costPerCreditHour = 236.45; 
			final double adminFee = 52.00;
			final double discount = 0.15;
			
			System.out.print("Which student? 1 " + students.get(0).getFullName() 
									  + " or 2 " + students.get(1).getFullName() + " ? "); 
			
			
			idx = in.nextInt();
			idx--; // to adjust for zero-based index
			
			if (students.get(idx).getGPA >= 3.85)
				totalCost = ((students.get(idx).getCreditHours() * costPerCreditHour) + adminFee) * (1 - discount);
				totalDiscount = ((students.get(idx).getCreditHours() * costPerCreditHour) + adminFee) * discount);
			else
				totalCost = (students.get(idx).getCreditHours() * costPerCreditHour) + adminFee;
			
			System.out.println("\nHere is the tuition invoice for " + students.get(idx).getFullName() + " :\n"
								+ "---------------------------------------------------------------------------\n"
								+ students.get(idx).getFullName() + "\t" + students.get(idx).getId() + "\n"
								+ "Credit Hours:" + students.get(idx).getCreditHours() + "\t($236.45/credit hour)\n"
								+ "Fees: $52\n\n"
								+ "Total payment (after discount): $"+ totalCost + "\t\t($" + totalDiscount + "discount applied)\n"
								+ "---------------------------------------------------------------------------");
		}	
	}
}