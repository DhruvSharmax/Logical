package StandardStructures;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
        int[] arr = {5,8,3,0,10,9,1,4};
		divide(arr);
		System.out.println("After sort:" + Arrays.toString(arr));
	}

	static void divide(int[] arr) {
		int n = arr.length;
		if(n>1) {
			int midIndex = n / 2;
			int[] leftArr = new int[midIndex];
			int[] rightArr = new int[n - midIndex];

			for (int i = 0; i < midIndex; i++)
				leftArr[i] = arr[i];
			for (int i = midIndex; i < n; i++)
				rightArr[i - midIndex] = arr[i];            // line to remember

			divide(leftArr);
			divide(rightArr);

			merge(arr, leftArr, rightArr);
		}
	}

	static void merge(int[] arr, int[] leftArr, int[] rightArr) {
		int i=0,j=0,k=0;
		while(i<leftArr.length && j<rightArr.length)
			arr[k++] = leftArr[i]<=rightArr[j] ?		// condition to remember <=
				leftArr[i++] :
				rightArr[j++];

		while(i<leftArr.length)
			arr[k++] = leftArr[i++];
		while(j<rightArr.length)
			arr[k++] = rightArr[j++];
	}
}
