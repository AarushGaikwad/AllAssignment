package question02;

import java.util.Scanner;


public class Average {

	public static void main(String[] args) {
		
		double a=0;
		double b=0;
		double average;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the first number: ");
		if(sc.hasNextDouble() && !sc.hasNextInt()) {   //condition check if number is double or not
			a=sc.nextDouble();     //if condition is true then only the value is assign to variable
		}
		else {
			System.out.println("Number is not double type, enter the valid double number");
			return;
		}
		
		System.out.println("enter the second double number: ");
		if(sc.hasNextDouble() && !sc.hasNextInt()) {
			b=sc.nextDouble();
		}
		else {
			System.out.println("Number is not double type, enter the valid number");
			return;
		}
		
		average = (a+b) / 2;
		System.out.println("the average of two doubles number is: " + average);
		
	}

}