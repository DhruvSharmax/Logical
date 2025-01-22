package DynamicProgramming;
/*
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 * https://youtu.be/3YILP-PdEJA?t=35m50s
 */
public class StockMaximumProfit2 {
	public static void main(String[] args) {
		int[] price = {5, 11, 3, 50, 60, 90};
		int k = 2;

		System.out.println("Maximum profit is: " +maxProfit(price, k));
	}

	/*
	 * in below loops t stands for transactions and d stands for days
	 */
	private static int maxProfit(int[] price, int k) {
		int n = price.length;
		int[][] profit = new int[k+1][n];
		
		for(int t=1;t<=k;t++) {
			int max = Integer.MIN_VALUE;
			for(int d=1;d<n;d++) {
				max = Math.max(max, profit[t-1][d-1] -price[d-1]);
				
				profit[t][d] = Math.max(max +price[d], profit[t][d-1]);
			}
		}
		return profit[k][n-1];		// returning last element of matrix on bottom right
	}
}
/*
 * on line 22 (while taking max variable)
 * we're separating common part from our calculation and keeping max of it 
 * so that we don't need to traverse again just to get max of all previous profits (based on transaction number & days)
 * basically calculation was to get maximum among: 
 * yesterday's same transaction profit (profit[t][d-1])
 * vs
 * yesterday's previous transaction profit (profit[t-1][d-1])
 * +
 * current day's price - yesterday's price (+price[d] -price[d-1])
 * 
 * now for every next element of profit array we need to compare above system with more and more profit[t-1][d-1]
 * so to avoid that extra loop we are keeping our max variable at runtime
 * 
 * which on next line (line no 25) getting compared with our profit[t][d-1] and of course non common part from above +price[d]
 * its output than stored in our profit matrix
 */
