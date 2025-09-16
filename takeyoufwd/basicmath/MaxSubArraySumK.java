package takeyoufwd.basicmath;

import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k
// find max length of subarray, that can add upto k
public class MaxSubArraySumK {
    void main(){
        int[] a1 = {5, -1, 0};
        int[] a2 = {1,2,0,0,1,3,2};
        int k=4;
        prefixSum(a1,k);   // good for all cases like negative, zeros etc (uses hashmap's extra space)
        slidingWin(a2,k);    // good only for positive and zeros (uses no extra space)
    }

    private void slidingWin(int[] a, int k) {
        int sum=0, left=0, max=0;
        for (int right=0; right< a.length; right++){
            sum+=a[right];
            while (sum>k && left<right)
                sum-=a[left++];
            if (sum==k)
                max=Math.max(max, right-left+1);
        }
        System.out.println(max);
    }

    private void prefixSum(int[] a, int k) {
        Map<Integer,Integer> prefixsum=new HashMap<>();
        prefixsum.put(0,-1);
        int sum=0, max=0;
        for (int i=0;i<a.length;i++){
            sum+=a[i];
            if(prefixsum.containsKey(sum-k))
                max=Math.max(max, i-prefixsum.get(sum-k));
            prefixsum.putIfAbsent(sum,i);
        }
        System.out.println(max);
    }
}