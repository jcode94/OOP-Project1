public class Project1 {
	// This will ultimately contain the classes
	// responsible for all the operations within the program.
	
	// Classes:
	// Menu 
	// Getting faculty information
	// Getting student information
	// Calculating tuition invoice
	// Printing tuition invoice
	// Getting staff information
	// Printing staff information
	
	// We can create an object from a class by 
	// initializing an object of that type
	// For example, because we have a Menu.java
	// class in the same directory(package),
	// we can just use that class here(all classes
	// within the same package don't need importing)
	
	// So, we can do smt like 
	// Menu mainMenu = new Menu();
	// mainMenu.printMenu();
	
	// This will create an object of the Menu class,
	// which is in our Menu.java class file,
	// and will instantiate one for our current file.
	// We can then use the methods defined within the
	// Menu class through our object.
	
	public static void main(String[] args) {
		// This will ultimately contain the highest-level 
		// method calls that get 'the ball rolling', 
		// which I think will just be working with the menu,
		// at the most abstracted level.
		
		Menu mainMenu = new Menu();
		mainMenu.displayMenu();
	}
} // end of program