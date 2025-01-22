package StandardStructures;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MergeSort_Shorter {
    public static void main(String[] args) {
        var arr =
                IntStream.generate(()->
                                new Random().nextInt(100))
                        .limit(10)
                        .toArray();

        System.out.println("before sort:" + Arrays.toString(arr));
        divide(arr, 0, arr.length-1);
        System.out.println("After sort:" + Arrays.toString(arr));
    }

    /*
        this method should be pretty straight to understand, we're just dividing the array with recursive calls
        till start and end indexes match, meaning just one cell left in the array. point to note here is
        we're not actually dividing the array we're just playing with indexes, so we're able to pass same array and start-end indexes with it.
        Mid we are calculating so no need to pass that.
    */
    private static void divide(int[] arr, int start, int end) {
        if(start<end) {
            int mid = start + (end - start) / 2;
            divide(arr, start, mid);
            divide(arr, mid + 1, end);
            merge(arr, start, mid, end);        // after every merge call main array will get modified with sorted data
        }
    }

    /*
        this method is where we start merging TWO ARRAYS at a time, since main array not modified yet
        so we're accepting that only as parameter here. we also need mid index to identify starting of 2nd array.
        also we need a temporary array where we'll put merged contents of two arrays.
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        var left_arr_pointer = start;
        var right_arr_pointer = mid+1;
        var merged = new int[end-start+1];
        var merged_index = 0;

        while (left_arr_pointer <= mid && right_arr_pointer <= end)     // running loop from start till end of either array
            merged[merged_index++] =             // doing simple comparison, within only pointers of both array
                    arr[left_arr_pointer] < arr[right_arr_pointer]     // you see thats the part where merge sort magic showing
                            ? arr[left_arr_pointer++]       // we're not comparing each element with n elements which results in n square complexity, we're comparing only elements which are at pointer in both arrays.
                            : arr[right_arr_pointer++];     // saving it in temp array(lowest in comparison) also increasing the pointer of comparison passed array.

        while (left_arr_pointer <= mid)
            merged[merged_index++] = arr[left_arr_pointer++];
        while (right_arr_pointer <= end)
            merged[merged_index++] = arr[right_arr_pointer++];

        System.arraycopy(merged,0,arr,start,merged.length);     // and thus we created a merged temporary array out of two divided arrays (divided just by index, not real division) and copied it from 0th location till its length into our original array from start location.
        // why we copied from start location and not 0, because merge method will be called multiple times at the end of division method, so start index will vary as per current call, it will keep increasing as merging will proceed.
        // how we're able to touch original array, because we're only doing shuffeling of data, that too in subarray, not in complete array.
    }
}
