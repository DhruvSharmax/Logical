package challenges;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountSubArraysWithGivenSum {
    public static void main(String[] args) {
        int[] array = {3, 7, 9, 2, 6, 15, 8, 1};
        int targetSum = 9;
//        int[] array = {3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1};
//        int targetSum = 5;
        int count = findSubarraysWithSum(array, targetSum);
        System.out.println(count);
    }

    // Function to find all subarrays with a given sum, done with prefix sum approach using hashmap
    private static int findSubarraysWithSum(int[] array, int targetSum) {
        var map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int ans = 0, sum = 0;
        for (int i:array) {
            sum += i;                                // why we're maintaining sum of all previous elements? because this sum can help us get those previous subsequences which are equal to target sum
            if (map.containsKey(sum-targetSum))      // sum-targetsum if found earlier in the map, means i found one subsequence equal to targetsum.
                ans += map.get(sum-targetSum);       // because currently I am at sum so if I do sum-(sum-targetsum)=targetsum
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }


    @Nested
    class CountSubArraysWithGivenSumTest {
        @Test
        void testit() {
            int[] array = {3, 7, 9, 2, 6, 15, 8, 1};
            int targetSum = 9;
            var output = new ArrayList<>();
            output.add(List.of(3, 6));
            output.add(List.of(7, 2));
            output.add(List.of(8, 1));
            output.add(List.of(6, 2, 1));

            assertEquals(output.size(), findSubarraysWithSum(array, targetSum));
        }

        @Test
        void testit1() {
            int[] array = {3, 7, 9, 2, 6, 15, 8, 1};
            int targetSum = 9;
            var output = new ArrayList<>();
            output.add(List.of(9));
            output.add(List.of(8, 1));

            assertEquals(output.size(), findSubarraysWithSum(array, targetSum));
        }
    }
}
