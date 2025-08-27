package DS100_Genpact;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,8,3,0,10,9,1,4};
        bubbleSort(arr);
        System.out.println("After sort:" + Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length;i++)
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
    }
}
