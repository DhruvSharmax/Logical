package BackTracking;
/*
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 */
import java.util.Arrays;

public class SudokuProblem {
	public static int N = 9;
	public static void main(String[] args) {
		int grid[][] = {{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
		                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
		                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
		                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
		                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
		                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
		                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
		                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }};
		
		if (sudoku(grid)) {
			for (int[] g : grid)
				System.out.println(Arrays.toString(g));
		} else
			System.out.println("Not possible");
	}

	private static boolean sudoku(int[][] grid) {
		int row = -1, col = -1;
		boolean isEmpty = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(grid[i][j]==0) {
					row = i;
					col = j;
					isEmpty=true;
					break;
				}
				if(isEmpty)
					break;
			}
		}
		
		if(!isEmpty)
			return true;
		
		for(int num=0;num<N;num++) {
			if(isSafe(grid,row,col,num)) {
				grid[row][col] = num;
				
				if(sudoku(grid))
					return true;
				
				grid[row][col] = 0;
			}
		}
		
		return false;
	}

	/*
	 * No need to memorize below method, just memorize algo of sudoku method
	 */
	private static boolean isSafe(int[][] grid, int row, int col, int num) {
		
		return false;
	}
}
