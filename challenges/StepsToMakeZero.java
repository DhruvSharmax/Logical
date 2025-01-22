package challenges;

public class StepsToMakeZero {
/*
 * Given an integer num, return the number of steps to reduce it to zero.
In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
Example:

Input: num = 14
Output: 6

for explanation - https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
	
	public static void main(String[] args) {
		System.out.println(numberOfSteps(8)); // input 8 expected 4
	}

	public static int numberOfSteps(int num) {
        int count = 0;
        while(num>0) {
        	count++;
            if(num%2==0) 
            	num/=2;
            else 
            	num--;
        }
        return count;
    }
}
