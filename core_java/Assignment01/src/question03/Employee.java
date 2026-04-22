package question03;

public class Employee {
	private String firstName;
	private String lastName;
	private double salary;
	
	public Employee(String firstName, String lastName, double salary) {
//		super();
		this.firstName = firstName;
		this.lastName = lastName;
		if(salary>=0) {
			this.salary = salary;
		}
		else {
			System.out.println("give appropriate salary");
		}
		return;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary>=0) {
			this.salary = salary;
		}
		
	}
	
	public double getYearlySalary() {
		return this.salary = salary * 12;
	}

	public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = this.salary * (percentage / 100.0);
            this.salary = this.salary + raiseAmount;
        }
    }

}
