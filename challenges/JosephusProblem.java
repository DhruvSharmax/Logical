package challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusProblem {

	public static void main(String[] args) {
		int n = 14;
		int k = 2;
		
		List<Integer> li = IntStream.range(0, n).boxed().collect(Collectors.toList());
		
		System.out.println(recursiveCall(li,k,0));
		
		System.out.println(mathematicalApproach(n,k));
	}

	private static int mathematicalApproach(int n, int k) {
		if(n==1) return 0;
		return (mathematicalApproach(n-1,k)+k)%n;
	}

	private static int recursiveCall(List<Integer> li, int k, int start) {
		int n = li.size();
		
		if(n==1) 
			return li.get(0);
		
		start = (start+k-1)%n;
		li.remove(start);
		
		return recursiveCall(li, k, start);
	}
}
