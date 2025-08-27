package challenges;
import java.util.*;
/*
Given an array of integers, determine how many distinct subarrays can be formed that contain at most a specified number of odd elements. A subarray is defined as a contiguous segment of the array, and two suberrays are distinct if they differ by at least one position in their contels.
14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33
Example numbers =[1, 2, 3, 4]
k=1
The following is a list of the 8 distinct valid subarrays having no more than 1 odd element:
[[1], [2], [3], [4], [1,2], [2, 3], [3, 4], [2, 3, 4]]
 */
public class AllCombinationsWithOdd {

    public static int evenSubarray(List<Integer> numbers, int k) {
        int n = numbers.size();
        Set<String> subarrays = new HashSet<>();
        for (int start = 0; start < n; start++) {
            int oddCount = 0;
            StringBuilder keyBuilder = new StringBuilder();
            for (int end = start; end < n; end++) {
                if (numbers.get(end) % 2 != 0) { // Odd number
                    oddCount++;
                }
                if (oddCount > k) break;
                // Create a unique key for each subarray using delimiter
                if (end > start) keyBuilder.append(",");
                keyBuilder.append(numbers.get(end));
                subarrays.add(keyBuilder.toString());
            }
        }
        return subarrays.size();
    }
    // For demonstration
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int k = 1;
        int result = evenSubarray(numbers, k);
        System.out.println(result); // Output: 8
    }
}
