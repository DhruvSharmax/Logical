package takeyoufwd.basicmath;
// https://takeuforward.org/plus/dsa/problems/maximum-consecutive-ones
public class MaxConsecutive1s {
    void main(){
        int[] a={1, 1, 0, 0, 1, 1, 1, 0,1,1,1,1,0,0,0,1,1,1};
        count1s(a);
    }

    private void count1s(int[] a) {
        int max = 0;
        int count=0;
        for (int num : a) {
            if (num == 1) {
                count++;
                max = Math.max(count,max);
            } else count = 0;
        }
        System.out.println(max);
    }
}
