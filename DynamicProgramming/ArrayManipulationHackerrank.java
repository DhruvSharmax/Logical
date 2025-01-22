/*
 * problem statement given at
 * C:\Users\erdhr\eclipse-workspace\Logical\Resources\Array Manipulation
 * Hackerrank.docx
 * 
 * My Understanding: so we have given a 2D matrix,
 * columns of matrix will always be 3 with values a,b,k, and rows can be upto m, 
 * another structure given will be an n size array with zeros, 
 * So our task is to pick indexes given a to b (including the index itself) and add k in all those
 * places. At the end we need to return Maximum element in this modified array.
 */
package DynamicProgramming;

import java.util.*;

public class ArrayManipulationHackerrank {
	public static void main(String[] args) {
		int n = 10;
		int m = 4;
		List<List<Integer>> queries = new ArrayList<>(m);

		queries.add(new ArrayList<Integer>(Arrays.asList(2, 6, 8)));
		queries.add(new ArrayList<Integer>(Arrays.asList(3, 5, 7)));
		queries.add(new ArrayList<Integer>(Arrays.asList(1, 8, 1)));
		queries.add(new ArrayList<Integer>(Arrays.asList(5, 9, 15)));

		long result = ArrayManipulationHackerrank.arrayManipulation(n, queries);

		System.out.println(result);
	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		Integer[] output = new Integer[n + 2]; 	
		/* first +1 is because a,b index values will vary between 1 to b and not 0 to b
		* second +1 is because after applying prefix sum Algo it will require one extra cell */
		
		Arrays.fill(output, 0);
		
		for (List<Integer> i : queries) {
			int a = i.get(0);
			int b = i.get(1);
			int k = i.get(2);
			output[a] += k;
			output[b + 1] -= k;
		}
		
		// now apply prefix sum algo
			long sum = 0;
			long max = Long.MIN_VALUE;
			for (int i : output) {
				sum += i;
				max = Math.max(sum, max);
			}
			return max;
		}

}