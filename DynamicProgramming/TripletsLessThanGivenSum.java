package DynamicProgramming;

import java.util.Arrays;

public class TripletsLessThanGivenSum {
	public static void main(String[] args) {
		int[] input = {-1,-3,-4,-3,-10,-4,2};//{0,-1,2,-3,1};
		int sum = 2;
		countTriplets(input,sum);
	}
	
	private static void countTriplets(int[] input,int sum) {
		int count=0;
		Arrays.sort(input);
		int n = input.length;
		for(int i=0,j=i+1,k=n-1; i<n-1; i++) {
			while(j<k) {
				if(input[i]+input[j]+input[k]>=sum) 
					k--;
				else {
					count+=(k-j);
					j++;
				}
			}
		}
		System.out.println(count);
	}
}
