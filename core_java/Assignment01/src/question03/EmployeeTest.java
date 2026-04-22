package question03;

public class EmployeeTest {

	public static void main(String[] args) {
		System.out.println("Salary before raise");
		Employee e1 = new Employee("Max", "Verstappen", 10000);
		Employee e2 = new Employee("Lewis", "Hamilton", 15000);
		
		System.out.println(e1.getFirstName()+ " " + e1.getLastName()+ " " + e1.getYearlySalary());
		System.out.println(e2.getFirstName()+ " " + e2.getLastName()+ " " + e2.getYearlySalary());
		
		
		e1.giveRaise(10);
		e2.giveRaise(10);
		
		System.out.println("Salary after raise");
		
		System.out.println(e1.getFirstName()+ " " + e1.getLastName()+ " " + e1.getYearlySalary());
		System.out.println(e2.getFirstName()+ " " + e2.getLastName()+ " " + e2.getYearlySalary());

	}

}
