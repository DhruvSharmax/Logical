package challenges.stringPlay;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWord {
	public static void main(String[] args) {
		String s = "My Name Is Dhruv";

		reverseWithTwoLoops(s);
		reverseWithTwoStream(s);

		rearrrangeInReverse(s);
	}

	private static void rearrrangeInReverse(String s) {
		String[] words = s.split(" ");
		int n = words.length;
		for(int i = 0; i< n/2; i++)
			swap(words, i, n-1 -i);
		System.out.println(Arrays.toString(words));
	}

	private static void swap(String[] words, int i, int n) {
		String temp = words[i];
		words[i] = words[n];
		words[n] = temp;
	}

	private static void reverseWithTwoStream(String s) {
		String op = Arrays.stream(s.split(" "))
				.map(word -> new StringBuilder(word).reverse())
				.collect(Collectors.joining(" "));
		System.out.println(op);
	}

	private static void reverseWithTwoLoops(String s) {
		String output = "";
		for(String word: s.split(" ")) {
			for(int i=word.length()-1; i>=0; i--)
				output+=word.charAt(i);
			output+=" ";
		}
		System.out.println(output);
	}
}
