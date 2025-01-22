package challenges;

/*
 * go here for description: https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}

	private static int myAtoi(String s) {
		if(s.length()==0) return 0;
		char[] charArr = s.toCharArray();
		int output=0;
		boolean negative = false;
		
		int i = 0;
		while(i<s.length()-1 && charArr[i]==' ')		// Skipping white spaces, we took i<s.length-1 condition because i being used further in code
			i++;
		if(charArr[i]=='-' || charArr[i]=='+')		// handling +,-,no sign
			negative = charArr[i++]=='-'?true:false;
		
		int prev_val = 0;
		
		while(i<s.length() && charArr[i]>='0' && charArr[i]<='9' ) {		// iterating only till I see numbers, also took i<s.length condition because i not being used after this loop, so no worries of its increament
			int digit = charArr[i++]-'0';				/* most important thing to remember for this program is 
			 										* when we do [char - '0'] it always gives integer value of that character */
			output = (output*10) + digit;
			
			if(output<0 || (output-digit)/10!=prev_val) {
				return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
			}
			prev_val=output;
		}
		
		return negative?-output:output;
	}
	
	
}
