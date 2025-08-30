package takeyoufwd.basicmath;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n=153;
        int temp = n;
        int curr;
        int sum=0;
        int count=0;
        while(temp>0) {
            temp/=10;
            count++;
        }
        temp=n;
        while(temp>0) {
            curr = temp%10;
            sum+= (int) Math.pow(curr,count);
            temp/=10;
        }
        System.out.println(sum);
        System.out.println("isArmstroong ?"+Boolean.valueOf(n==sum));
    }
}
