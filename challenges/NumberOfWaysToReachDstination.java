package challenges;

/*
 * given a 2D matrix MxN you need to find number of ways to reach from top left to bottom right
 * moving can only be done right and down
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * https://youtu.be/46zD5d9y9b4?t=2m
 */
public class NumberOfWaysToReachDstination {
	public static void main(String[] args) {
		int m = 4, n = 4;
		
		int[][] memo = new int[m][n];
		
		System.out.println(countWays(memo, m-1, n-1));
	}

	private static int countWays(int[][] memo, int m, int n) {
		if(m==1 || n==1) 
			return memo[m][n]=1;
		
		if(memo[m][n]==0)
			memo[m][n] = countWays(memo, m-1, n)+countWays(memo, m, n-1);
		
		return memo[m][n];
	}
}

/*
 * Explanation: from one point I can go in 2 directions down or right, 
 * means I can say my solution will be sum of 2 recursive solutions
 * if I break my recursive call to least level 
 * I can say that at end of either row or column my direction will remain only 1 to reach the end.
 * so I can simply return that 1 as base case
 * and of course to avoid recalculation I can use memoization
 */
