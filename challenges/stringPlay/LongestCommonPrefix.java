package challenges.stringPlay;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] s = {"geeksforgeeks", "geeks", "geeek", "geeezer"};
		System.out.println(getPrefix(s));
	}

	private static String getPrefix(String[] s) {
		Arrays.sort(s);
		int i=0;
		int lastIndex = s.length-1;
		for(;i<s[lastIndex].length() && s[0].charAt(i)==s[lastIndex].charAt(i);i++) {}
		
		return s[0].substring(0,i);
	}
}
