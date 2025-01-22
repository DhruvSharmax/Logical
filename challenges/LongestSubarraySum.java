package challenges;

import java.util.Arrays;

/*
 * find longest subarray having maximum sum
 */
public class LongestSubarraySum {
	public static void main(String[] args) {
		int[] arr = {-3,1,-8,4,-1,2,1,-5,5};
		System.out.println(Arrays.stream(arr).sum());
		System.out.println("\nfoundSum="+maxSubArraySum(arr));
	}

	private static int maxSubArraySum(int[] arr) {
		
		int start=0,end = 0;		// start,end variables has no contribution in calculation
		int maxSoFar = arr[0],maxInCurrentWindow=arr[0];
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > maxInCurrentWindow + arr[i]) { //handling scenario when array element is greater than our maxSoFar
				maxInCurrentWindow = arr[i];
				start = i;
			} else
				maxInCurrentWindow+=arr[i];				// simply appending element sum to currentWindow
			if(maxSoFar<maxInCurrentWindow) {
				maxSoFar = maxInCurrentWindow;
				end = i;
			}
		}
		System.out.printf("index starting from %d to %d",Math.min(start, end),end);
		return maxSoFar;
	}
}
