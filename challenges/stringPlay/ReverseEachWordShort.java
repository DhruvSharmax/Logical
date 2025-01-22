package challenges.stringPlay;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordShort {
	public static void main(String[] args) {
		String s = "my name is dhruv";
		System.out.println(revrsewithoutfunction(s));
		System.out.println(revrsewithstream(s));
	}

	private static String revrsewithoutfunction(String s) {
		String output = "";
		for(String word:s.split(" ")) {
			for(int i = word.length()-1;i>=0;i--) {
				output+=word.charAt(i);
			}
			output+=" ";
		}
		return output;
	}
	
	private static String revrsewithstream(String s) {
		return Arrays.stream(s.split(" "))
				.map(StringBuilder::new)
				.map(x->x.reverse().append(" "))
				.collect(Collectors.joining());
	}
}
