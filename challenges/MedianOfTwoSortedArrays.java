package challenges;

import java.util.*;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] arr1 = {-5, 3, 6, 12, 15};
		int[] arr2 = {-12, -10, -6, -3, 4, 10};
		System.out.println(getMedian(arr1,arr2));
	}

	private static float getMedian(int[] arr1, int[] arr2) {
		int i = arr1.length;
		int j = arr2.length;
		int[] arr3 = new int[i+j];
		System.arraycopy(arr1, 0, arr3, 0, i);
		System.arraycopy(arr2, 0, arr3, i, j);
		
		Arrays.sort(arr3);
		int n = arr3.length;
		
		if(n%2!=0) return arr3[n/2];
		
		return (arr3[(n/2)-1] + arr3[n/2])/2f;  // appended f with 2, to get floating point result
	}
}
