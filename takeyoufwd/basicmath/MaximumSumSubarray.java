package takeyoufwd.basicmath;
// https://takeuforward.org/plus/dsa/problems/kadane's-algorithm
// find max sum that can be extracted from any subarray
public class MaximumSumSubarray {
    void main(){
        int[] a={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        find1(a);       // brute force
        find2(a);       // better
        find3(a);     // kadane's algo
        find4(a);       // print the subarray as well
    }

    private void find1(int[] a) {   // just creating subarrays and calculating max
        int n = a.length;
        int max=Integer.MIN_VALUE;
        for(int start=0; start<n; start++){
            for(int end=start; end<n; end++){
                int sum=0;
                for(int k=start; k<=end; k++)
                    sum+=a[k];
                max=Math.max(max,sum);
            }
        }
        System.out.println(max);
    }

    private void find2(int[] a) {
        int n = a.length;
        int max=Integer.MIN_VALUE;
        for(int start=0; start<n; start++){
            int sum=0;
            for(int end=start; end<n; end++) {
                sum += a[end];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

    private void find3(int[] a) {
        int sum=0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<a.length;i++){
            sum+=a[i];
            max=Math.max(max,sum);
            if (sum<0) sum=0;
        }
        System.out.println(max);
    }

    private void find4(int[] a) {
        int sum=0;
        int max = Integer.MIN_VALUE;
        int start=0;
        int ansStart=-1, ansEnd=-1;
        for (int i=0;i<a.length;i++){
            if(sum==0) start=i;
            sum+=a[i];

            if (sum>max){
                max=sum;
                ansStart=start;
                ansEnd=i;
            }

            if (sum<0) sum=0;
        }
        System.out.println(max);

        for (int i=ansStart;i<=ansEnd;i++)
            System.out.print(a[i]);
    }
}
