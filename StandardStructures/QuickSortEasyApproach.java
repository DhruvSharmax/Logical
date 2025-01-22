package StandardStructures;

import java.util.Arrays;
import java.util.Random;

public class QuickSortEasyApproach {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(100);

		System.out.println("before sort:" + Arrays.toString(arr));
		myQuickSort(arr, 0, arr.length - 1);
		System.out.println("After sort:" + Arrays.toString(arr));
	}

	private static void myQuickSort(int[] arr, int start, int end) {
		if (end < start)
			return;
		
		int pivot = arr[end];
		int left = start, right = end;
		
		while (left < right) {
			while (arr[left]<=pivot && left < right)
				left++;
			while (arr[right]>=pivot && left < right)
				right--;

			swap(arr, left, right);	// swapping to keep high elements on right & low on left
		}
		swap(arr, left, end);		// swapping pivot to put it in middle of low & high, because we took pivot as last element so swapping with left only, not the right

		myQuickSort(arr, start, left - 1);		// calling quick sort for both new partitions
											// leaving pivot index because it is at correct place now
		myQuickSort(arr, left + 1, end);
		/*
		this is why quick sort is quick because its breaking array with each recursive call, and in each call its coming back after putting pivot in right place.
		 */
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
