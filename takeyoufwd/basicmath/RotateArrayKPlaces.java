package takeyoufwd.basicmath;

import java.util.Arrays;
import java.util.Collections;

public class RotateArrayKPlaces {
    void main() {
        int k=2;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Array before rotation: "+ Arrays.toString(arr)); // {5,8,3,0,10,9,1,4}
        System.out.println("Array after rotation: "+ Arrays.toString(rotate(arr, k)));  // {1,4,5,8,3,0,10,9}
        arr= new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Right optimized rotation: "+ Arrays.toString(rightRo(arr,k)));
        arr= new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("Left optimized rotation: "+ Arrays.toString(leftRo(arr,k)));
    }

    private int[] rightRo(int[] arr, int k) {
        reverse(arr,0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        return arr;
    }
    private int[] leftRo(int[] arr, int k) {
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr,0, arr.length-1);
        return arr;
    }
    private void reverse(int[] arr, int start, int end) {
        while (start<=end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;end--;
        }
    }

    // brute force using extra space of rotated array
    private int[] rotate(int[] arr, int k) {
        int n = arr.length;
        k%=n;
        int[] rotated = new int[n];
        int j=0;
        for(int i=n-k;i<n;i++)
            rotated[j++]=arr[i];

        for (int i=0;i<n-k;i++)
            rotated[j++]=arr[i];

        return rotated;
    }
}
