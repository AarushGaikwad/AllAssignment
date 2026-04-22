package question3;

import java.util.Scanner;

//Create array of employees and search employee by empid name

class Employee{
	int empId;
	String empName;
	
	public Employee() {
	}
	
	public Employee(int id, String name) {
		this.empId = id;
		this.empName = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
	
	
}

public class Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);   
		
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		
		System.out.println("Enter name: ");
		String name = sc.next();
		
		Employee[] emp = new Employee[3];
		emp[0] = new Employee(1, "Aarush");
		emp[1] = new Employee(2, "Nilesh");
		emp[2] = new Employee(3, "Balaji");
		
		for (int i = 0; i < emp.length; i++) {
			if(emp[i].getEmpId() == id || emp[i].getEmpName().equalsIgnoreCase(name)) {
				System.out.println("Employee found: " + emp[i]);
			}
		}
	}
	
	
}
