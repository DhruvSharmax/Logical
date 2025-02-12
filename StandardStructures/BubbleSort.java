package StandardStructures;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubble(new int[]{4,6,10,8,3})));
    }

    private static int[] bubble(int[] arr) {
        int n = arr.length;
        for (int i = 0; i< n; i++){
            for(int j = 1; j< n -i; j++){
                if(arr[j-1]>arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
