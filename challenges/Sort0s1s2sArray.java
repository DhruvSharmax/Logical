package challenges;

import java.util.Arrays;

public class Sort0s1s2sArray {
	public static void main(String[] args) {
		int[] arr = {0,1,2,1,1,0,2};
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(int[] arr) {
		int low = 0, high = arr.length-1, mid = 0;
		
		while(mid<=high) {
			switch(arr[mid]) {
				case 0 -> {
					swap(arr,low,mid);
					low++;mid++;
				}
				
				case 1-> mid++;
				
				case 2->{
					swap(arr,mid,high);
					high--;
				}
			}
		}
	}
/*
 * Expected result: low -> 0 mid -> 1 and high -> 2
 * which is why we're swapping: low-mid for 0, mid no swapping for 1, mid-high for 2
 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
