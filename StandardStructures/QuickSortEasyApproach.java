package StandardStructures;

import java.util.Arrays;

public class QuickSortEasyApproach {
	public static void main(String[] args) {
		int[] arr = {5,8,3,0,10,9,1,4};
		myQuickSort(arr, 0, arr.length - 1);
		System.out.println("After sort:" + Arrays.toString(arr));
	}

	private static void myQuickSort(int[] arr, int low, int high) {
		if (low<high) {
			int pivot = arr[high], leftPointer = low, rightPointer = high;

			while (leftPointer < rightPointer) {
				while(arr[leftPointer] <= pivot && leftPointer < rightPointer)
					leftPointer++;
				while(arr[rightPointer] >= pivot && leftPointer < rightPointer)
					rightPointer--;
				swap(arr, leftPointer, rightPointer);    // swapping to keep high elements on right & low on left
			}
			swap(arr, leftPointer, high);        // swapping pivot to put it in middle of low & high, because we took pivot as last element so swapping with left only, not the right

			myQuickSort(arr, low, leftPointer - 1);        // calling quick sort for both new partitions
			// leaving pivot index because it is at correct place now
			myQuickSort(arr, leftPointer + 1, high);
		}
		/*this is why quick sort is quick because its breaking array with each recursive call, and in each call its coming back after putting pivot in the right place.*/
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
