package challenges.stringPlay;

/*
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class AllPermutationsString {
	public static void main(String[] args) {
		printPermutations("abc");
	}

	private static void printPermutations(String s) {
		int l = 0, r = s.length();
		recursive(s,l,r);
	}

	private static void recursive(String s, int l, int r) {
		if(l==r) {
			System.out.println(s);
			return;
		}
		
		for(int i = l; i < r; i++) {
			s = swap(s,l,i);
			recursive(s, l+1, r);
			s = swap(s,l,i);
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
