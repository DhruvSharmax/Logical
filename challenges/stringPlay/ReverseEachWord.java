package challenges.stringPlay;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWord {
	public static void main(String[] args) {
		String s = "My Name Is Dhruv";

		reverseIterationFromLast(s);
		reverseWithSBMethod(s);

		rearrrangeInReverse(s);
	}

	private static void rearrrangeInReverse(String s) {
		String[] words = s.split(" ");
		int n = words.length;
		for(int i = n-1; i>=0; i--)
			System.out.print(words[i]+" ");
	}

	private static void reverseWithSBMethod(String s) {
		String op = Arrays.stream(s.split(" "))
				.map(StringBuilder::new)
				.map(StringBuilder::reverse)
				.collect(Collectors.joining(" "));
		System.out.println(op);
	}

	private static void reverseIterationFromLast(String s) {
		String output = "";
		for(String word: s.split(" ")) {
			for(int i=word.length()-1; i>=0; i--)
				output+=word.charAt(i);
			output+=" ";
		}
		System.out.println(output);
	}
}
