package BackTracking;
/*
 * https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
 */
import java.util.Arrays;

public class NQueenProblem {
	final static int N = 4;

	public static void main(String[] args) {

		int[][] board = new int[N][N];

		if (checkBoard(board, 0)) {
			for (int[] b : board)
				System.out.println(Arrays.toString(b));
		} else
			System.out.println("Not possible");
	}

	static boolean checkBoard(int[][] board, int row) {
		if (row == N)
			return true;

		for (int column = 0; column < N; column++) {
			if (isSafe(board, row, column)) {
				board[row][column] = 1;
				if (checkBoard(board, row + 1))
					return true;
				else
					board[row][column] = 0;
			}
		}
		return false;
	}

	
	static int[][] dir = { { 0, 1 }, { 0, -1 }, 
						  { 1, 0 }, { -1, 0 }, 
						  { 1, 1 }, { 1, -1 }, 
						  { -1, 1 },{ -1, -1 } };
	
	static boolean isSafe(int[][] board, int row, int column) {
		for (int[] d : dir) {
			int x = d[0] + row, y = d[1] + column;
			while (x >= 0 && y >= 0 && x < N && y < N) {
				if (board[x][y] == 1)
					return false;
				x += d[0];
				y += d[1];
			}
		}
		return true;
	}
}
