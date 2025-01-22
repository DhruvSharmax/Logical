package challenges;

import java.util.Arrays;

public class PushAllZerosToEnd {
	public static void main(String[] args) {
        int[] A = { 5, 6, 0, 4, 6, 0, 9, 0, 8 };
        int n = A.length;
        
        int newIndex = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != 0) {
                swap(A, newIndex, i);
                newIndex++;
            }
        }
        
        System.out.println(Arrays.toString(A));
    }
    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
/*
 * To get this done in single loop, we are swapping non zero elements with newIndex
 */
