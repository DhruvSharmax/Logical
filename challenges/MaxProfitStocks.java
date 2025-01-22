package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProfitStocks {
    public static void main(String[] args) {
        List<List<Integer>> weeks = new ArrayList<>();
        weeks.add(Arrays.asList(4,2,7,8,4));
        weeks.add(Arrays.asList(7,3,1,4,2));
        weeks.add(Arrays.asList(9,6,2,4,7));
        weeks.add(Arrays.asList(9,6,4,3,1));
        weeks.add(Arrays.asList(9,6,2,4,1));

        weeks.stream().map(MaxProfitStocks::getProfit).forEach(System.out::println);
    }

    private static long getProfit(List<Integer> week) {
        var profit = 0;
        var min = Integer.MAX_VALUE;
        for(var curr:week){
          min = Math.min(curr,min);
          profit = Math.max(profit, curr-min);
        }
        return profit;
    }
}
