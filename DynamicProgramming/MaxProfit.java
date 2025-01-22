package DynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Problem: https://www.geeksforgeeks.org/maximize-profit-possible-by-selling-m-products-such-that-profit-of-a-product-is-the-number-of-products-left-of-that-supplier/
 There are n types of items in a shop, where the number of items of type i is denoted
 by quantity[i]. The price of the items is determined dynamically where the price of the
i(th) item is equal to the remaining number of items of type i. Thère are m customers in line
to buy the items from the shop, and each customer will buy exactly one item of any type

The shopkeeper, being greedy, tries to sell the items in a way that maximises revenue. Find
the maximum amount the shopkeeper can earn by selling exactly m items to
the customers optimally.
 */

public class MaxProfit {
    public static void main(String[] args) {
        List<Integer> quantity = List.of(10,10,8,9,1);
        int m=6;
        System.out.println(getProfit(quantity,m));
    }

    public static long getProfit(List<Integer> quantity, int m) {
        var profit=0;
        var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        quantity.stream().forEach(heap::add);

        while (m-- > 0) {
            var dayProfit = heap.poll();
            profit+=dayProfit;
            heap.add(dayProfit-1);
        }
        return profit;
    }

    @Test
    public void testMaxProfit(){
        assertEquals(55, getProfit(List.of(10,10,8,9,1), 6));
        assertEquals(11, getProfit(List.of(1,2,4), 4));
    }
}
