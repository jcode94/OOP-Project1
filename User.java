public class User {
		private String fullName;
		private String id;
		private double gpa;
		private int creditHours;
		enum department {
			mathematics,
			engineering,
			english;
			
			public static department isMember(String department) {
				for (department d : values()) {
					if (d.department.equals(department)) {
						return d;
					}
				}
				return null; // FIX ME add the error checking for null
			}
		}
		enum rank {
			professor,
			adjunct;
			
			public static rank isMember(String rank) {
				for (rank r: values()) {
					if (r.rank.equals(rank)) {
						return r;
					}
				}
				return null; // FIX ME add the error checking for null
			}
		}
		enum status {
			P, F;
			
			public static status isMember(String status) {
				for (status s: values()) {
					if (s.status.equals(status)) {
						return s;
					}
				}
				return null; // FIX ME add the error checking for null
			}
		}
		
		// student constructor
		public User(String fullName, String id, double gpa, int creditHours) {
			this.fullName = fullName;
			this.id = id;
			this.gpa = gpa;
			this.creditHours = creditHours;
		}
		
		// faculty constructor
		public User(String fullName, String id, enum department, enum rank) {
			this.fullName = fullName;
			this.id = id;
			this.department = department;
			this.rank = rank;
		}
		
		// staff constructor
		public User(String fullName, String id, enum department, enum status) {
			this.fullName = fullName;
			this.id = id;
			this.department = department;
			this.status = status;
		}
		
		// generic info for all
		public void initBasicInfo(Scanner scnr) {
			// String fullName and id
			System.out.print("Name: ");
			this.fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			this.id = scnr.next();
		}
		
		public void initStudent(Scanner scnr) {
			
			initBasicInfo(scnr);
		
			// gpa, creditHours
			System.out.print("GPA: ");
			this.gpa = scnr.nextDouble();
			
			System.out.print("Credit Hours: ");
			this.creditHours = scnr.nextInt();
		}
		
		public void initFaculty(Scanner scnr) {
			
			initBasicInfo(scnr);
		
			// department, rank
			System.out.print("Department: ");
			this.department = scnr.nextLine();
			
			System.out.print("Rank: ");
			this.rank = scnr.next();
		}
		
		public void initStaff(Scanner scnr) {
			
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
		public void setdepartment(enum department) {
			this.department = department;
		}
		
		// sets rank
		public void setRank(enum rank) {
			this.rank = rank;
		}
		
		// sets status
		public void setStatus(enum status) {
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
		
		public void generateInvoice() {
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
}