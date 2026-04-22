package question2;

import java.util.Scanner;

//Write a program to print no of comparisons done to search a key in linear search

public class Question2 {

	public static void main(String[] args) {
		
		int[] arr = {5,4,8,3,1,9,5,8,4};
		Scanner sc = new Scanner(System.in);
		int count=0;
		
		System.out.print("Enter the key: ");
		int key = sc.nextInt();
		
		for (int i = 0; i < arr.length; i++) {			
			if(arr[i] == key) {
				count++;
			}
		}
		System.out.println(count);
	}

}
