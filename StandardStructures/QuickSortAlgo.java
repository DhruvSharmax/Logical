package StandardStructures;

import java.util.Arrays;

public class QuickSortAlgo {
	public static void main(String[] args) {
		int[] arr = {5,8,3,0,10,9,1,4};
		quickSort(arr,0,arr.length-1);
		System.out.println("After sort:" + Arrays.toString(arr));
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pivot = partition(arr,low,high);
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
