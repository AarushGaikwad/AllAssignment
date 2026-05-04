package linearserach;

import java.util.Scanner;

public class LinearSearch {
	
	public static void main(String[] args) {
		
		int arr[]= {33, 55, 88, 77, 44, 11, 66, 22, 99};
		Scanner sc = new Scanner(System.in);
		
		// 1) accept key value from the user
		System.out.print("Enter key to search: ");
		int key = sc.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			if(key == arr[i]) {
				System.out.println("key found " + key);
				
			}
			
		}
		
		//return value when key is found 1 => key found -1 => key not found
		
		/*
		int i = linearSearch(arr, arr.length, key);
		if(i == -1)
			System.out.println("Key not found");
		else
			System.out.println("Key found");
		*/
	}

	/*
	private static int linearSearch(int[] arr, int length, int key) {
		//Start traversing from the 1st element
		for (int i = 0; i < arr.length; i++) {
			if(key == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	*/
}
