package challenges.stringPlay;

/*
 * https://www.geeksforgeeks.org/power-set/
 */
public class AllSubstrings {
	static String s = "abc";
	static int count=0;
	public static void main(String[] args) {
		powerSet(0,"");		// complexity 2^n
		//substrings(0,"");				// complexity n * 2^n
		//countSubstrings(0);			// complexity 2^n
		//System.out.println(count-1);
	}

	private static void powerSet(int i, String currStr) {
		if(i==s.length()) {
			System.out.println(currStr);
			return;
		}
		powerSet(i+1, currStr);
		powerSet(i+1, currStr + s.charAt(i));
	}

	private static void substrings(int start, String currStr) {
		System.out.println(currStr);
		for (int i=start;i<s.length();i++)
			substrings(i+1, currStr + s.charAt(i));
	}

	private static void countSubstrings(int start) {
		count++;
		for (int i=start;i<s.length();i++)
			countSubstrings(i+1);
	}
}
