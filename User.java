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
		
		// faculty constructor
		public User(String fullName, String id, department department, rank rank) {
			this.fullName = fullName;
			this.id = id;
			this.department = department;
			this.rank = rank;
		}
		
		// staff constructor
		public User(String fullName, String id, department department, status status) {
			this.fullName = fullName;
			this.id = id;
			this.department = department;
			this.status = status;
		}
		
		// generic info for all
		public static void initBasicInfo(Scanner scnr) {
			// String fullName and id
			System.out.print("Name: ");
			this.fullName = scnr.nextLine();
			
			System.out.print("ID: ");
			this.id = scnr.next();
		}
		
		public static void initStudent(Scanner scnr) {
			
			initBasicInfo(scnr);
		
			// gpa, creditHours
			System.out.print("GPA: ");
			this.gpa = scnr.nextDouble();
			
			System.out.print("Credit Hours: ");
			this.creditHours = scnr.nextInt();
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
}