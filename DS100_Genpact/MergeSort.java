package DS100_Genpact;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,8,3,0,10,9,1,4};
        divide(arr);
        System.out.println("After sort:" + Arrays.toString(arr));
    }

    static void divide(int[] arr) {
        int n = arr.length;
        if(n==1) return;
        var mid = n/2;
        var left_arr=new int[mid];
        var right_arr=new int[n-mid];

        for (var i=0;i<mid;i++)
            left_arr[i]=arr[i];
        for (var i=mid;i<n;i++)
            right_arr[i-mid]=arr[i];

        divide(left_arr);
        divide(right_arr);
        merge(arr, left_arr, right_arr);
    }

    static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i=0,j=0,k=0;

        while (i<leftArr.length && j<rightArr.length)
            arr[k++] = leftArr[i]<=rightArr[j] ?
                    leftArr[i++] :
                    rightArr[j++];
        while (i<leftArr.length)
            arr[k++] = leftArr[i++];
        while (j<rightArr.length)
            arr[k++] = rightArr[j++];

    }
}
