package challenges;

import java.util.Arrays;

public class ZigZagPattern {
	// Driver Code
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		int n = 3;
		printZigZagPattern(str, n);
	}

	private static void printZigZagPattern(String str, int n) {
		if(n==1) {
			System.out.println(str);
			return;
		}
		
		String[] arr = new String[n];
		Arrays.fill(arr, "");
		
		boolean down = true;
		int row = 0;
		
		for(char c:str.toCharArray()) {
			arr[row]+=c;
			
			if(row==n-1) down = false;
			else if(row==0) down = true;
			
			if(down) row++;
			else row--;
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}
}
