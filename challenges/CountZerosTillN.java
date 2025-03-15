package challenges;

public class CountZerosTillN {
    public static void main(String[] args) {
        int n=10001;
        System.out.println(countZeros(n));
    }

    static int countZeros(int n) {
        long count = 0;
        for(int i=0;i<=n;i++) {
            //count += countZeroInEachNumberWithChar(i);
            count+= countZeroInEachNumber(i);
        }
        return (int)count;
    }

    private static long countZeroInEachNumberWithChar(int i) {
        return String.valueOf(i)
                .chars()
                .filter(x -> x == '0')
                .count();
    }

    static int countZeroInEachNumber(int n) {
        if(n==0) return 1;
        int count=0;
            while (n>0) {
                if(n%10==0)             // simple formula to check if number has zero at the end
                    count++;
                n/=10;                  // keep breaking number from last till remains 1 digit
            }
        return count;
    }
}
