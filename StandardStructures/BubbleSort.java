package StandardStructures;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubble(new int[]{4,6,10,8,3})));
    }

    private static int[] bubble(int[] arr) {
        int temp;
        int n = arr.length;
        for (int i = 0; i< n -1; i++){
            for(int j = 0; j< n -i-1; j++){
                if(arr[j+1]<arr[j]) {
                    swap_adjacent(arr, j);
                }
            }
        }
        return arr;
    }

    private static void swap_adjacent(int[] arr, int j) {
        int temp;
        temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }
}
