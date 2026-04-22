package question01;

import java.util.Scanner;

public class Converstion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int a = sc.nextInt();
		
		System.out.println("Given number is: " + a);
		
		System.out.println("Binary equivalent: " + Integer.toBinaryString(a));
		System.out.println("Octal equivalent: " + Integer.toOctalString(a));
		System.out.println("Hexadecimal equivalent: " + Integer.toHexString(a));
	}

}