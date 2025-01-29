package DynamicProgramming;

import java.util.Arrays;

public class TripletsWithGivenSum {
	public static void main(String[] args) {
		int[] input = {0,-1,2,-3,1};
		int sum = -2;
		countTriplets(input,sum);
	}

	private static void countTriplets(int[] input,int sum) {
		Arrays.sort(input);
		int n = input.length;
		for(int i=0,j = i+1,k = n-1; i<n-1; i++) {
			while(j<k) {
				int currSum = input[i]+input[j]+input[k];
				if(currSum==sum) {
					System.out.println(input[i]+","+input[j]+","+input[k]);
					j++;
					k--;
				} else if(currSum<sum) j++;
				else k--;
			}
		}
	}
}
/*
 * Solution explained: first we sort the array to apply binary search
 * then we are traversing the array with element i as a first element j as next element(low) and k as last element(high)
 * now keeping i unchanged we run a while loop till j(low)<k(high) its a binary search logic
 * we check if sum of i,j,k index values is == sum we'll print it,
 * else if sum is smaller we will increase low index j coz any index smaller than j will have smaller value than sum
 * if no above condition is matched means sum is greater so we have to reduce high index k, coz any index after k will have greater value than sum
 */
