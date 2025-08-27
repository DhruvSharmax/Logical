package challenges;
import java.util.*;
import java.lang.Math;
/*
finding divisors is not a challenge but finding in less than n complexity is something to think,
here with a smart strategy loop cycle reduced to half of n
 */
public class FindDivisors {
    public static void main(String[] args) {
        System.out.println(divisors(36));
    }
        public static List<Integer> divisors(int n) {
            List<Integer> li = new ArrayList<>();
            for(int i=1; i<=Math.sqrt(n); i++) {
                if(n%i==0) {
                    li.add(i);
                    if(i!=(n/i))
                        li.add(n/i);
                }
            }
            return li.stream().sorted().toList();
        }
}
