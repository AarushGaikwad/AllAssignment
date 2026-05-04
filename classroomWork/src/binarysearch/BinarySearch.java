package binarysearch;

import java.util.Scanner;

public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		Scanner sc = new Scanner(System.in);
		
		//1)Get key from the user
		System.out.print("Enter key: ");
		int key = sc.nextInt();
		//int index = binarySearch(/*array name*/arr , /*left index*/0, /*right index*/arr.length-1);
		int index = binarySearch(/*array name*/arr , key);
		if(index == -1)
			System.out.println("key not found");
		else
			System.out.println("key found at index = " + index);
	}

	//without recursion
	private static int binarySearch(int[] arr, int key) {
		//2) find left, right and mid
		int left=0;
		int right = arr.length-1; 
		int mid;
		
		while(left <= right) {
			//calculate mid
			mid = (left + right)/2;
			
			//3) compare middle element with key
			if(key == arr[mid])
				return mid;
			//if key is less than middle element, search into left partition
			if(key <= arr[mid])
				right = mid - 1;
			else
				left = mid + 1;
			
		}
		return -1;
	}
}
