package takeyoufwd.basicmath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
In place means without using extra space for new array
 */
public class RemoveDuplicatesFromSortedArrInPlace {
    void main(){
        int[] arr = {1,1,2,2,2,3,4,4,4};
        r(arr);
        System.out.println();
        rd(Arrays.copyOf(arr,arr.length));
        System.out.println();
        rds(Arrays.copyOf(arr,arr.length));
        System.out.println("\nNow if I ask you to find distinct duplicates?");
        fd(Arrays.copyOf(arr,arr.length)); // 1,2 and 4 are duplicate in this array
    }

    // below approach uses extra space in case you want to return output so less efficient
    private void r(int[] arr) {
        int prev=-1;
        for (int i : arr) {
            if (i != prev) System.out.print(i);
            prev = i;
        }
    }

    // this is the most optimal approach no extra space used and done in one pass
    private void rd(int[] arr) {        // remove duplicate
        int j=0;
        for (int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1])
                arr[++j]=arr[i];
        }
        for (int i=0;i<=j;i++)
            System.out.print(arr[i]);
    }

    // below is brute force approach uses set addition complexity
    private void rds(int[] arr) {           // remove duplicate with SET
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).filter(set::add).forEach(System.out::print);
    }

    private void fd(int[] arr) {        // find duplicate
        int count=0;
        boolean duplicateRun=false;
        for (int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1] && !duplicateRun) {
                    arr[count++] = arr[i];
                duplicateRun = true;
            } else duplicateRun=false;
        }
        for (int i=0;i<count;i++)       // bcz in line 53 count doing increment after putting data, means after last data insertion count will be +1 extra index, so to iterate that we use i<count and not i<=count
            System.out.print(arr[i]);
    }
}
