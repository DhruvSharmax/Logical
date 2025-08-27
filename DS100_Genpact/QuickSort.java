package DS100_Genpact;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,8,3,0,10,9,1,4};
        quickSort(arr, 0, arr.length-1);
        System.out.println("After sort:" + Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int pivot = arr[high], leftPointer = low, rightPointer = high;
            while (leftPointer<rightPointer) {
                while (arr[leftPointer] <= pivot && leftPointer<rightPointer) leftPointer++;
                while (arr[rightPointer] >= pivot && leftPointer<rightPointer) rightPointer--;
                swap(arr, leftPointer, rightPointer);
            }
            swap(arr, high, leftPointer);
            quickSort(arr, low, leftPointer-1);
            quickSort(arr, leftPointer+1, high);
        }
    }

    private static void swap(int[] arr, int leftPointer, int rightPointer) {
        int temp = arr[leftPointer];
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;
    }
}
