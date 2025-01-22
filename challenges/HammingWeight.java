package challenges;

/*
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has 
 * (also known as the Hamming weight).
 */
public class HammingWeight {
	public static void main(String[] args) {
		int n = 00000000000000000000000000001011;		// input
		
		int solution = Integer.bitCount(n);
		
		int m = 10;									// input to convert integer value in BinaryString
		
		String binaryString = Integer.toBinaryString(m);
		
		System.out.println(solution);
		System.out.println(binaryString);
	}
}
