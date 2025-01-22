package challenges;

import java.util.Arrays;

/*
 * find largest sum of contiguous subarray or find subarray with maximum sum
 */
public class LargestSumSubarray {
	public static void main(String[] args) {
		int[] arr = {-3,1,-8,4,-1,2,1,-5,5};
		
		System.out.println(Arrays.stream(arr).sum());
		System.out.println("\nfoundSum="+maxSubArraySum(arr));
	}

	private static int maxSubArraySum(int[] arr) {
		int start = 0, end = 0, maxSum = 0, currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			if (curr > currSum + curr) {
				currSum = curr;
				start = i;
			} else
				currSum += curr;
			if (maxSum < currSum) {
				maxSum = currSum;
				end = i;
			}
		}
		System.out.printf("index starting from %d to %d",Math.min(start, end),end);
		return maxSum;
	}
}
