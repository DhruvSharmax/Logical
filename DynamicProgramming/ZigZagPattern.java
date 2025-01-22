package DynamicProgramming;
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
			
			if(row==n-1) 
				down = false;
			else if(row==0) 
				down = true;
			
			if(down) 
				row++;
			else 
				row--;
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}
}
/*
 * Logic Explanation: if you analyze problem deeply it is actually asking to create n levels 
 * and have Strings in that as per level number, at the end append those n levels to get final string
 * we can translate that creating single dimensional array of n, 
 * then with this given limit either 0 or n-1 we can decide our moving direction, which will only change on limit reach
 * as per the direction we can increase/decrease row number dynamically
 * then append strings of each level.
 */
