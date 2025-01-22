package challenges.stringPlay;

import java.util.ArrayDeque;

public class BackspaceStringCompare {
	public static void main(String[] args) {
		System.out.println(new BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));
	}

	public boolean backspaceCompare(String s, String t) {
		return doBackspace(s).equals(doBackspace(t));
	}

	public static String doBackspace(String s) {

		int length = s == null ? 0 : s.length();

		ArrayDeque<Character> stack = new ArrayDeque<>();

		for(int i=0;i<length;i++) {
			if (s.charAt(i) == '#') {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.push(s.charAt(i));
		}
		return stack.toString();
	}
}
