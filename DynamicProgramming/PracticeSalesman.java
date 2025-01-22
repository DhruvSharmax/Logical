package DynamicProgramming;

public class PracticeSalesman {
	
	public static int[][] mem;
	
	public static void main(String[] args) {
		int [] city1 = {23 , 9,   100 ,37};
		int [] city2 = {89,  45,  12,  44};
		int city1_cost = 34;
		int city2_cost = 77;
		System.out.println(maxProfit(city1, city2, city1_cost, city2_cost));
	}

	private static int maxProfit(int[] city1, int[] city2, int city1_cost, int city2_cost) {
		mem = new int[2][city1.length];
		
		int sumOfCity1 = dfs(city1,city2,city1_cost,city2_cost,0,0);
		int sumOfCity2 = dfs(city1,city2,city1_cost,city2_cost,1,0);
		
		return Math.max(sumOfCity1, sumOfCity2);
	}

	private static int dfs(int[] city1, int[] city2, int city12, int city21, int rowNum, int currDay) {
		if(mem[rowNum][currDay]>0) 
			return mem[rowNum][currDay];
		
		int nextDay = currDay+1;
		if(nextDay==city1.length) 
			return rowNum==0?city1[currDay]:city2[currDay];
		
		int sumNoTravel = 0, sumTravel = 0;
		
		if(rowNum==0) {
			sumNoTravel = city1[currDay] + dfs(city1,city2,city12,city21,0, nextDay);
			sumTravel = city1[currDay] - city12 + dfs(city1,city2,city12,city21, 1, nextDay);
		} else {
			sumNoTravel = city2[currDay] + dfs(city1,city2,city12,city21, 1, nextDay);
			sumTravel = city2[currDay] - city21 + dfs(city1,city2,city12,city21,0 , nextDay);
		}
		mem[rowNum][currDay] = Math.max(sumNoTravel, sumTravel);
		return mem[rowNum][currDay];
	}
}
