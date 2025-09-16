package takeyoufwd.basicmath;

import java.util.Arrays;
// https://www.youtube.com/watch?v=tp8JIuCXBaU&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=22&ab_channel=takeUforward
// https://takeuforward.org/plus/dsa/problems/sort-an-array-of-0's-1's-and-2's
public class sort1s0s2sInPlace {
    void main(){
        int[] a={1, 0, 2, 1, 0};
        doIt(a);        // TC: O(2n)
        dutchFlagAlgo(a);       // TC: O(N)
    }

    private void doIt(int[] a) {
        int ones=0, twos=0, zeros=0;
        for (int i:a)
            switch (i) {
                case 0: zeros++; break;
                case 1: ones++; break;
                case 2: twos++; break;
            }
        for (int i=0;          i<zeros;     i++) a[i]=0;
        for (int i=zeros;      i<zeros+ones;i++) a[i]=1;
        for (int i=zeros+ones; i<a.length;  i++) a[i]=2;

        System.out.println(Arrays.toString(a));
    }

    private void dutchFlagAlgo(int[] a) {
        int low=0,mid=0,high=a.length-1;
        while (mid<=high){
            if(a[mid]==0) {
                swap(low,mid,a);
                low++;mid++;
            }
            if(a[mid]==1) mid++;
            if(a[mid]==2) {
                swap(mid,high,a);
                high--;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    private void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
