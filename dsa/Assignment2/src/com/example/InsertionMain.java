package com.example;

import java.util.Arrays;

public class InsertionMain {

	public static void main(String[] args) {
		int[] arr = {6, 5, 4, 3, 2, 1};
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		decendingSort(arr, arr.length);
		System.out.println("Array after sorting: " + Arrays.toString(arr));
	}

	private static void decendingSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if(temp > arr[j]) {
					arr[j+1] = arr[j];
				}
				else
					break;
			}
		}
	}

}
