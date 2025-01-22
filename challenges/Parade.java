package challenges;

/*
 * Problem statement
 * https://leetcode.com/discuss/interview-question/2131732
 */
public class Parade {
	public static void main(String[] args) {
		String s = "001011";
		
		int count = getCountOfIterations(s);
		System.out.println(count);
	}

	private static int getCountOfIterations(String s) {
		if(s==null || s.length()<1) return 0;
		
		char[] arr = s.toCharArray();
		int swapCount=0;
		int count = 0;
		
		do{
			swapCount = 0;
			char prev = arr[0];
			for(int j=1;j<s.length();j++) {
				char currChar = arr[j];
				if(currChar=='1' && prev=='0') {
					// swap
					arr[j] = '0';
					arr[j-1] = '1';
					swapCount++;
				}
				prev = currChar;
			}
			if(swapCount>0) 
				count++;
		} while(swapCount>0);
		
		return count;
	}
}
