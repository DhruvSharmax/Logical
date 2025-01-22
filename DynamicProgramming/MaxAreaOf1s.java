package DynamicProgramming;

public class MaxAreaOf1s {
	public static boolean[][] mem;
	public static int[][] dir = {{-1,0},
								  {1,0},
								  {0,-1},
								  {0,1}};
	public static int count = 0;
	public static void main(String[] args) {
		 int[][] input = {
			 {1,1,0,0,0},
			 {1,1,0,0,0},
			 {0,0,1,0,0},
			 {0,0,0,1,1}
		 };
		 
		 int count = returnMaxArea(input);
		 
		 System.out.println(count);
	}

	private static int returnMaxArea(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int out = 0;
		mem = new boolean[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				if(input[i][j]==1) {
					count = 1;
					eachNodeMaxArea(input,i,j);
					out = Math.max(count, out);
				}
			}
		}
		return out;
	}

	private static void eachNodeMaxArea(int[][] input, int i, int j) {
		if(mem[i][j]) return;
		mem[i][j] = true;
		for(int d[]:dir) {
			int x = i+d[0],y = j+d[1];
			if(x>=0 && y>=0 && x<input.length && y<input[0].length && input[x][y]==1 && !mem[x][y]) {
				count++;
				eachNodeMaxArea(input, x, y);
			}
		}
	}
}
