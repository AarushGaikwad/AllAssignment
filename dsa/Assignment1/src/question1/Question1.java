package question1;

import java.util.Scanner;

//Write a linear search algorithm to return index of last occurrence of key.

public class Question1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {5,4,8,3,1,9,5,8,4};
		int count = 0;
		
		System.out.print("Enter the key: ");
		int key = sc.nextInt();
		
		/*
		//traversing from backward direction
		for(int i = arr.length - 1; i >= 0 ; i--) {
			if(arr[i] == key) {
				System.out.println("index of last occurrence: " + i);
				break;
			}
		}
		*/
		
		//traversing from the forward direction 
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				count = i;
			}
		}
		System.out.println("index of last occurrence: " + count);
	}
}
