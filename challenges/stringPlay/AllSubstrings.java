package challenges.stringPlay;

/*
 * https://www.geeksforgeeks.org/power-set/
 * input: abc
 * output: a, ab, abc, ac, b, bc, c
 */
public class AllSubstrings {
	static String s = "abc";
	static int count=0;
	public static void main(String[] args) {
		powerSet(0,"");
		//substrings(0,"");
		//countSubstrings(0);
		//System.out.println(count-1);
	}

	private static void powerSet(int i, String currStr) {	// complexity 2^n
		if(i==s.length()) {
			System.out.println(currStr);
			return;
		}
		powerSet(i+1, currStr);
		powerSet(i+1, currStr + s.charAt(i));
	}

	private static void substrings(int start, String currStr) {		// complexity n * 2^n
		System.out.println(currStr);
		for (int i=start;i<s.length();i++)
			substrings(i+1, currStr + s.charAt(i));
	}

	private static void countSubstrings(int start) {		// complexity 2^n
		count++;
		for (int i=start;i<s.length();i++)
			countSubstrings(i+1);
	}
}
