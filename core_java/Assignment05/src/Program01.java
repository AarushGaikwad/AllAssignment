import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee{
	int id;
	String name;
	double salary;
	
	public Employee() {
		
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}

public class Program01 {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
	            new Employee(1, "Steve", 45000),
	            new Employee(2, "Alice", 30000),
	            new Employee(3, "Sam", 55000),
	            new Employee(4, "Bob", 25000),
	            new Employee(5, "Sarah", 38000),
	            new Employee(6, "John", 42000),
	            new Employee(7, "Sonia", 31000),
	            new Employee(8, "Mike", 28000),
	            new Employee(10, "Diana", 60000)
	        );
		System.out.println("---normal list---");
		for(Employee e:empList)
			System.out.println(e);
		System.out.println();
		
		//sorted by name
		System.out.println("---sorted by name---");
		empList.stream().sorted(Comparator.comparing(e -> e.name))
		.forEach(System.out::println);
		System.out.println();
		
		//sorted order of salary in desc order
		System.out.println("---sorted by salary in desc---");
		empList.stream().sorted(Comparator.comparingDouble
				((Employee e) -> e.salary).reversed())
		.forEach(System.out::println);
		System.out.println();
		
		//sorted by salary>30000 in desc order
		System.out.println("---sorted by salary desc greater than 30000");
		empList.stream().filter(e -> e.salary > 30000)
		.sorted(Comparator.comparingDouble((Employee e) -> e.salary)
				.reversed()).forEach(System.out::println);
		System.out.println();
		
		//name starting with s
		System.out.println("---name starting with s---");
		empList.stream().filter(e -> e.name.startsWith("S"))
		.forEach(System.out::println);
		System.out.println();
		
		//salary greater than 40000 after giving 12% raise
		System.out.println("---Salary of emp greater than 40000 after giving 12% raise");
		empList.stream().map(e -> new Employee(e.id, e.name, e.salary*1.2))
		.filter(e -> e.salary > 40000)
		.forEach(System.out::println);
		System.out.println();
		
		//distinct employees
		System.out.println("---distinct employees---");
		empList.stream().distinct().forEach(System.out::println);
	}

}
