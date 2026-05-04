package com.sunbeam;


public class BinarySearchDesc {

    static int binarySearch(int arr[], int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key)
                return mid;

            if (arr[mid] < key)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {90, 80, 70, 60, 50, 40};

        System.out.println(binarySearch(arr, 60));
    }
}