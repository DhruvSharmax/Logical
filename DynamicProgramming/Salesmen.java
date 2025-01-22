package DynamicProgramming;

public class Salesmen {
	static int[][] mem;
	
	public static void main(String[] args) {
		int [] city1 = {23 , 9,   100 ,37};
		int [] city2 = {89,  45,  12,  44};
		int city1_cost = 34;
		int city2_cost = 77;
		System.out.println(maxProfit(city1, city2, city1_cost, city2_cost));
	}

    public static int maxProfit(int[] city1, int[] city2, int cost12, int cost21) {
    	
        mem = new int[2][city1.length];

        for (int i = 0; i < city1.length; i++) {
            mem[0][i] = 0;
            mem[1][i] = 0;
        }
        int sum1 = dfs(city1, city2, cost12, cost21, 0, true); // for city1
        int sum2 = dfs(city1, city2, cost12, cost21, 0, false); // for city 2

        return Math.max(sum1, sum2);
    }

    private static int dfs(int[] city1, int[] city2, int cost12, int cost21, int currday, boolean inCity1) {
    	int rowNum = inCity1?0:1;
    	
        if (mem[rowNum][currday] > 0)
            return mem[rowNum][currday];
    	
    	int nextDay = currday + 1;
        if (nextDay == city1.length) {
            return inCity1 ? city1[currday] : city2[currday];
        }
        
        int sumNoTravel = 0;
        int sumTravel = 0;

        if (inCity1) {
            sumNoTravel = city1[currday] 		+ dfs(city1, city2, cost12, cost21, nextDay, inCity1);   
            sumTravel = city1[currday] - cost12 + dfs(city1, city2, cost12, cost21, nextDay, !inCity1);
        } else {
            sumNoTravel = city2[currday] 		+ dfs(city1, city2, cost12, cost21, nextDay, inCity1);
            sumTravel = city2[currday] - cost21 + dfs(city1, city2, cost12, cost21, nextDay, !inCity1);
        }
        
        mem[rowNum][currday] = Math.max(sumTravel, sumNoTravel);
        return mem[rowNum][currday];
    }
}
