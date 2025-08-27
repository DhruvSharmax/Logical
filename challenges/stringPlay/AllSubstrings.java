package challenges.stringPlay;

import java.util.stream.IntStream;

/*
 * https://www.geeksforgeeks.org/power-set/
 * input: abc
 * output: a, ab, abc, ac, b, bc, c
 */
public class AllSubstrings {
	static int count=0;
	public static void main(String[] args) {
		String s = "abcd";

		System.out.print("PowerSet: ");
		powerSet(s,0,"");
		System.out.println();
		System.out.print("recursiveAndStreams: ");
		recursiveAndStreams(s, 0,"");
		System.out.println();

		countCombinations(s, 0);
		System.out.println("countCombinations: " + (count-1));
	}

	static void powerSet(String s, int i, String currStr) {	// complexity 2^n
		if(i==s.length()) {
			System.out.print(currStr+", ");
			return;
		}
		powerSet(s, i+1, currStr);
		powerSet(s, i+1, currStr+s.charAt(i));
	}

	static void recursiveAndStreams(String s, int i, String currStr) {		// complexity n * 2^n
		System.out.print(currStr+", ");
		IntStream.range(i,s.length())
				.forEach(index->
		recursiveAndStreams(s, index+1, currStr+s.charAt(index)));
	}

	static void countCombinations(String s, int i) {		// complexity 2^n
		count++;
		IntStream.range(i,s.length())
				.forEach(i1 -> countCombinations(s,i1+1));
	}
}
