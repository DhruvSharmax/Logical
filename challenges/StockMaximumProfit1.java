package challenges;

/*
 * easy programs
 */
public class StockMaximumProfit1 {
	public static void main(String[] args) {
		int[] chart = {7,1,5,3,6,4};
		
		System.out.println(maxProfitOneTransaction(chart));
		System.out.println(maxProfitUnlimitedTransactions(chart));
	}

	private static int maxProfitOneTransaction(int[] chart) {
		int min = chart[0], profit=0;
		for(int i=0;i<chart.length;i++) {
			int curr = chart[i];
			min = Math.min(min, curr);
			profit = Math.max(profit, curr - min);
		}
		return profit;
	}
	
	private static int maxProfitUnlimitedTransactions(int[] chart) {
		int maxProfit=0;
		for(int i=1;i<chart.length;i++) {
			int curr = chart[i], prev = chart[i-1];
			if(curr>prev)
				maxProfit += curr-prev;
		}
			
		return maxProfit;
	}
}
