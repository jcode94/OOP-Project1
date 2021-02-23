import java.util.Scanner;

// Parent class
class User {
	// Instance variables
	private String fullName;
	private String id;
	
	// Constructor
	User() {
		setName("No Name Set");
		setId("No Name Set");
	}
	
	// Generic info shared by all child classes
	public void initBasicInfo(Scanner in) {
		System.out.print("\tName: ");
		String name = in.nextLine();
		setName(name);
		
		System.out.print("\tID: ");
		String id = in.nextLine();
		setId(id);
	}
	
	// Getters
	public String getName() {
		return fullName;
	}
	
	public String getId() {
		return id;
	}
	
	// Setters
	public void setName(String name) {
		this.fullName = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
