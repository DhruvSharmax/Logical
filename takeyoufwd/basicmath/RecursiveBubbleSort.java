package takeyoufwd.basicmath;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,8,3,0,10,9,1,4};
        bubble(arr, arr.length);
        System.out.println("After sort:" + Arrays.toString(arr));
    }

    private static void bubble(int[] arr,int n) {
        if(n==1) return;
        for (int i=0;i<n-1;i++)
            if (arr[i] > arr[i + 1])
                swap(arr, i);

        bubble(arr, n-1);
    }

    private static void swap(int[] arr, int i) {
        int temp=arr[i];
        arr[i]=arr[i+1];
        arr[i+1]=temp;

    }
}
