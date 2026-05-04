package bubblesort;

import java.util.Arrays;

public class BubbleSortMain {
	
	/*
	private static void efficientBubbleSort(int[] arr, int n) {
		// i will be always 1 as every element will be compared with the 1st element
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	*/
	
	private static void bubbleSort(int[] arr, int n) {
		int itr = 0;
		int comp = 0;
		for (int i = 1; i < n; i++) {
			itr++;
			for (int j = 0; j < n - 1; j++) {
				comp++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("itr: " + itr + " comp: " + comp);
	}

	public static void main(String[] args) {
		
		// int arr[] = {10, 20, 30, 40, 50, 60}; //efficient bubble sort
		int arr[] = {30, 20, 10, 60, 50, 40};
		System.out.println("Arrays before sort: " + Arrays.toString(arr));
		// efficientBubbleSort(arr, arr.length); //efficient bubble sort is always the sorted array given above
		bubbleSort(arr, arr.length);
		System.out.println("Arrays after sort: " + Arrays.toString(arr));
	}

	

	

}
