package challenges.stringPlay;

import java.util.stream.IntStream;

public class PalindromeCheck {
	public static void main(String[] args) {
		String s="12321";
		System.out.println(checkPali(s));
		System.out.println(checkPaliReverse(s));
		System.out.println(checkPaliStream(s));
	}

	static boolean checkPaliReverse(String s) {
		return new StringBuilder(s).reverse().toString().equals(s);
	}

	static boolean checkPaliStream(String s) {
		int n = s.length();
		return IntStream.range(0, n /2)
				.allMatch(i -> s.charAt(i)==s.charAt(n-i-1));
	}

	public static boolean checkPali(String s) {
		int start = 0;
		int end = s.length()-1;
		
		if(s.length()==0) return false;
		
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		
		return true;
	}
}
