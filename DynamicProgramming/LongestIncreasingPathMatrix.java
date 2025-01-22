/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
package DynamicProgramming;

public class LongestIncreasingPathMatrix {
	
	static int[][] matrix ={{ 9, 9, 4 },
							{ 6, 6, 8 },
							{ 2, 1, 1 } };
	static int m = matrix.length;
	static int n = matrix[0].length;
	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(matrix));
	}
	
	public static int longestIncreasingPath(int[][] matrix) {
		int[][] mem = new int[m][n];
		int longest = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				longest = Math.max(dfs(matrix,i,j,mem), longest);
			}
		}
		return longest;
	}

	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	private static int dfs(int[][] matrix, int i, int j,int[][] mem) {
		if(mem[i][j]>0) return mem[i][j];
		int max=0;
		for(int[] d:dir) {
			int x=i+d[0],y=j+d[1];
			if(x>=0 && y>=0 && x<m && y<n && matrix[x][y]>matrix[i][j])
				max=Math.max(max, dfs(matrix,x,y,mem));
		}
		mem[i][j] = max+1;
		return mem[i][j];
	}
}