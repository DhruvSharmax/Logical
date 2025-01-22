package StandardStructures;
import java.util.Arrays;
import java.util.Random;

public class QuickSortAlgo {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(100);

		System.out.println("before sort:" + Arrays.toString(arr));
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

	private static void swap(int[] arr, int element1, int element2) {
		int temp = arr[element2];
		arr[element2] = arr[element1];
		arr[element1] = temp;

	}
}
