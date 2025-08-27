package BackTracking;
/*
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/\
 * input: abc
 * output: abc, acb, bac, bca, cba, cab
 */
public class AllCombinationsString {
	public static void main(String[] args) {
		printPermutaions("abc");
	}

	public static void printPermutaions(String s) {
		recursive(s,0);
	}

	private static void recursive(String s, int i1) {
		if(i1==s.length()) {			// base case to terminate recursion
			System.out.println(s);
			return;
		}
		for(int i = i1; i < s.length(); i++) {
			s = swap(s,i1,i);
			recursive(s, i1+1);
			s = swap(s,i1,i);		// backtracking - to restore the original string
		}
	}

	private static String swap(String s, int i, int j) {
		char[] arr = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
}
