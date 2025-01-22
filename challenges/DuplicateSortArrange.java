package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * program to replace duplicate numbers with -1 first then sort the array then put all -1 at end
 * 	6,1,4,2,3,4,2,5,2,1,3,5,2,4,3
*	output 123456,-1,-1,-1,-1
 */

public class DuplicateSortArrange {
	
	public static void oneGo(Integer[] arr) {
		Set<Integer> s = Arrays.stream(arr).collect(Collectors.toSet());
		s=s.stream().sorted().collect(Collectors.toSet());
		Integer[] minusone = new Integer[arr.length-s.size()];
		Arrays.fill(minusone, -1);
		List li = new ArrayList(Arrays.asList(minusone));
		li.addAll(0, s);
		System.out.println(li);
	}
	
	public static void main(String[] args) {
		Integer[] arr = {6,1,4,2,3,4,2,5,2,1,3,5,2,4,3};
		
		oneGo(Arrays.copyOf(arr,arr.length));
		
		System.out.println(Arrays.toString(arr));
		
		List<Integer> li = new ArrayList<Integer>();
		
		// removing duplicate and adding -1
		for(int i=0;i<arr.length;i++) {
			if(!li.contains(arr[i])) {
				li.add(arr[i]);
			} else {
				li.add(i,-1);
			}
		}
		
		System.out.println("\n-----------------");
		System.out.println(li);
		
		// bubble sorting
		int length = li.size();
		int temp = 0;
		for(int i=0;i<length;i++) {
			for(int j = 1; j < length-i; j++) {
				if(li.get(j-1)>li.get(j)) {
					//swap
					temp = li.get(j-1);
					li.set(j-1,li.get(j));
					li.set(j,temp);
				}
			}
		}
		
		//li.stream().forEach(x->System.out.print(x+" "));
		System.out.println("\n");
		int count = 0;
		for (int i = 0; i < length; i++)
            if (li.get(i) != -1)
                li.set(count++, li.get(i));
		
		while (count < length)
        	li.set(count++, -1);
		
		System.out.println(li);
	}
}
