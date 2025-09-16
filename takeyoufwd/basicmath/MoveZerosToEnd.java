package takeyoufwd.basicmath;

import java.util.Arrays;

public class MoveZerosToEnd {
    void main() {
        int[] arr = {1, 0, 2, 3, 0, 0, 4, 5, 0, 6, 0};  // op: 1,2,3,4,5,6,0,0,0,0,0
        System.out.println("given array: "+ Arrays.toString(arr));
        // op: 1,2,3,4,5,6,0,0,0,0,0
        move0OneLoop(arr);
        System.out.println("Move all zeros to end: "+Arrays.toString(arr));
        // challenge is to not use extra space of temp array also do it in O(n)
    }
    void move0(int[] arr) {     // O(n) because both for loops will run half half
        int j=-1;
        int n = arr.length;

        for(int i = 0; i<n; i++)
            if(arr[i] == 0) {
                j = i;
                break;
            }

        if (j==-1) return;      // means array has no zeros

        for (int i = j+1; i<n; i++)      // in this loop j will maintain non-zero numbers only
            if (arr[i] != 0) {
                arr[j++]=arr[i];
                arr[i]=0;
            }
    }

    void move0OneLoop(int[] arr) {
        for (int i=0, j=0; i < arr.length; i++)
            if (arr[i] != 0) {
                if (i != j) {
                    arr[j] = arr[i];
                    arr[i] = 0;
                }
                j++;
            }
    }
}