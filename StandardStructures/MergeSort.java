package StandardStructures;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(100);

		System.out.println("before sort:" + Arrays.toString(arr));
		myMergeSort(arr);
		System.out.println("After sort:" + Arrays.toString(arr));
	}

	private static void myMergeSort(int[] arr) {
		int inputSize = arr.length;

		if(inputSize<2) return;
		
		int midIndex = inputSize/2;
		int[] leftArr = new int[midIndex];
		int[] rightArr = new int[inputSize-midIndex];
		
		for(int i=0;i<midIndex;i++)
			leftArr[i] = arr[i];
		
		for(int i=midIndex;i<inputSize;i++)
			rightArr[i-midIndex] = arr[i];
		
		myMergeSort(leftArr);
		myMergeSort(rightArr);
		
		merge(arr,leftArr,rightArr);
	}

	private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
		int leftSize = leftArr.length;
		int rightSize = rightArr.length;

		int i=0,j=0,k=0;

		while(i<leftSize && j<rightSize) {
			if(leftArr[i]<=rightArr[j])
				arr[k++] = leftArr[i++];
			else
				arr[k++] = rightArr[j++];
		}

		while(i<leftSize)
			arr[k++] = leftArr[i++];
		while(j<rightSize)
			arr[k++] = rightArr[j++];
	}
}
