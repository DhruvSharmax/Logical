package takeyoufwd.basicmath;

import java.util.Arrays;

import static takeyoufwd.basicmath.ArrayStaticUtil.myarr;

public class MergeSort {
    void main() {
        int[] arr = Arrays.copyOf(myarr,myarr.length);
        System.out.println("Before sort:" + Arrays.toString(arr));
        ms(arr,0,arr.length-1);
        System.out.println("After sort:" + Arrays.toString(arr));
        arr = Arrays.copyOf(myarr,myarr.length);
        System.out.println("Before sort:" + Arrays.toString(arr));
        DS100_Genpact.MergeSort.divide(arr);
        System.out.println("Before sort:" + Arrays.toString(arr));
    }
    // we can use DS100_Genpact.divide() method as well, but it adds an extra memory and operation
    private static void ms(int[] arr, int low, int high) {
        int mid = (low+high)/2;
        if(low>=high) return;
        ms(arr,low,mid);
        ms(arr,mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high)
            temp[k++] = arr[i] <= arr[j]?arr[i++]:arr[j++];

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= high)
            temp[k++] = arr[j++];

        for (i = low, k = 0; i <= high;) {
            arr[i++] = temp[k++];
        }
    }
    public static void merge1(int[] arr, int[] leftArr, int[] rightArr) {
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
