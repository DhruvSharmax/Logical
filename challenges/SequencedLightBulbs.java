package challenges;/*
 * we have bulbs connected in series, each bulb has an on/off switch
 * means even if you turn on 2 and 3, nothing will lit because 1 is still in off, once 1 also get on then 2 then 3 will get On
 * that sequence of turning on switches is given as an array, so you need to count all those moments when any new light(s) got lighten up
 */

import java.util.*;
import java.util.stream.IntStream;

public class SequencedLightBulbs {
	public static void main(String[] args) {

		int[] A = { 2, 1, 5, 3, 4, 7, 6 }; // input
		
		int output = 0;
		List<Integer> li = new ArrayList<>();
		int doneUpto = 0;
		for (int i = 0; i < A.length; i++) {
			int curr = A[i];
			li.add(curr);
			boolean flag = true;
			for (int j = curr; j > 1 && j>doneUpto; j--) {
				if (!li.contains(j-1)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				output++;
				while(li.contains(curr)) {
					doneUpto=curr;
					curr++;
				}
			}
		}
		System.out.println(output);
	}
}
