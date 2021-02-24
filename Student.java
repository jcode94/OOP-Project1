import java.util.Scanner;

// Child class
public class Student extends User {
	// Instance variables
	private double gpa;
	private int creditHours;
	
	// Constructor
	Student() {
		super();
		setGpa(0.0);
		setCreditHours(0);
	}
	
	public void initStudent(Scanner in) {
		double gpa;
		int creditHours;
		
		initBasicInfo(in);
		
		System.out.print("\tGPA: ");
		gpa = in.nextDouble();
		in.nextLine(); // newline
		setGpa(gpa);
		
		System.out.print("\tCredit Hours: ");
		creditHours = in.nextInt();
		in.nextLine(); // newline
		setCreditHours(creditHours);		
	}
	
	public void generateInvoice() {
		final double tuition = 236.45;
		final int fees = 52;
		final double discount = 0.15;
		double totalPayment;
		double totalDiscount = 0;
		
		if (getGpa() >= 3.85) {
			totalPayment = ((creditHours * tuition) + fees) * (1 - discount);
			totalDiscount = ((creditHours * tuition) + fees) * discount;
		}
		else
			totalPayment = (creditHours * tuition) + fees;
			
		System.out.println(" Here is the tuition invoice for " + getName() + " :\n"
							+ "---------------------------------------------------------------------------\n"
							+ " " + getName() + "\t\t\t" + getId() + "\n"
							+ " Credit Hours:" + getCreditHours() + " ($236.45/credit hour)\n"
							+ " Fees: $" + fees + "\n\n"
							+ " Total payment (after discount): $" + String.format("%.2f", totalPayment) + "\t($" + String.format("%.2f", totalDiscount) + " discount applied)\n"
							+ "---------------------------------------------------------------------------");
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public int getCreditHours() {
		return creditHours;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
}
