package insertionsort;

import java.util.Arrays;

public class InsertionSortMain {

	private static void insertionSort(int[] arr, int n) {
		// outer for loop will start from the index 1 as the it will be compared with the previous value index
		for (int i = 1; i < n; i++) {
			int temp = arr[i]; //the element on the first element is stored in the temp variable
			int j;
			for (j = i - 1; j >= 0; j--) { 
				if(temp < arr[j]) {
					arr[j+1] = arr[j];
				}
				else
					break;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 5, 4, 3, 2, 1};
		System.out.println("Array before sort: " + Arrays.toString(arr));
		insertionSort(arr, arr.length);
		System.out.println("Array after sort: " + Arrays.toString(arr));
	}

	

}
