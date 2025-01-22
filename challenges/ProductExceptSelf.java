package challenges;

import java.util.Arrays;

/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

	You must write an algorithm that runs in O(n) time and without using the division operation.
 */

public class ProductExceptSelf {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { -1,1,0,-3,3 })));
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
	}

	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int res[] = new int[len];
		int suffixA[] = new int[len];
		int prev = 1;
		int suffix = 1, prefix = 1;
		
		if(countZeros(nums, res) >= 1) return res;		// according to zero(s) count we set values in result array and return, if zeros are not there we simply do not enter in this if condition
		
		for (int i = 0; i < len; i++) {	
			suffix *= prev;						// creating another array with multiplication of suffix(s) with previous element (initially previous element and suffix taken 1)
			suffixA[i] = suffix;
			prev = nums[i];
		}
		
		prev = 1;
		for (int i = len - 1; i >= 0; i--) {
			prefix *= prev;						// now here we're iterating through suffix array in reverse order, and multiplying prefix(s) with previous element(s) of original array (initially previous element and prefix taken 1)
			res[i] = suffixA[i] * prefix;		// and then multiplying that prefix with current element to get result.
			prev = nums[i];
		}

		return res;
	}

	private static int countZeros(int[] nums, int[] res) {
		int product = 1;
		int count = 0;
		int index = -1;
		int len = nums.length;
		
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				index = i;
				if (++count > 1) return count;
			} else product *= nums[i];
		}
		
		if (count == 1) res[index] = product;
		
		return count;
	}
}
