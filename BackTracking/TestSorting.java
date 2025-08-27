package BackTracking;
import java.util.*;
public class TestSorting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort()));
    }
    static int[] arr = {1,2,5,4,3,6,7,8,9};
    public static int[] sort() {
        int n = arr.length;
        for(int i=0;i<n;i++)
            for(int j=1;j<n-i;j++)
                if(compare(j-1,j))
                    switchLocation(j,j-1);
        return arr;
    }
    public static boolean compare(int i,int j) {
        return arr[i] > arr[j];
    }
    public static void switchLocation(int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

