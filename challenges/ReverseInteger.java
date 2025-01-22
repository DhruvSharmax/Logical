package challenges;

/*
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Input: x = 123
 * Output: 321
 */
public class ReverseInteger {
	public static void main(String[] args) {
		int n = -123;
		System.out.println(reverse(n));
	}

	private static int reverse(int n) {
		boolean negative = false;
		if(n<0)
			negative = true;
		if(negative) 
			n = -n;
			int rev = 0;
			int prev_rev=0;
			while(n>0) {
				int rem = n%10;
				rev = (rev*10) + rem;
				// checking overflow
				if((rev-rem)/10!=prev_rev) {
					System.out.println("Overflowed");
					return 0;
				}
				prev_rev = rev;
				
				n/=10;
			}
			return 
					negative?-rev:rev;
	}
}
