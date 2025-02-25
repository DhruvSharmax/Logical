package challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSum {

    public static void main(String[] args) {
        int[] list = new int[] { 3, 4, 1, 6, 4, 1 };
        int[] indices = findTwoSumGetElements(list, 9);
        System.out.println(indices[0] + " " + indices[1]);

        indices=findTwoSumGetIndex(list,8);
        System.out.println(indices[0] + " " + indices[1]);
    }

   public static int[] findTwoSumBruteForce(int[] list, int sum) {
        for(int i=0;i<list.length;i++) {
            for(int j=i+1;j<list.length;j++) {
               if(list[i]+list[j] == sum) {
            	   return new int[] {i,j};
               }
            }
        }
        return new int[] {-1,-1};
    }
    
    private static int[] findTwoSumGetElements(int[] arr, int sum) {
        List<Integer> li = new ArrayList<>();
        for (int element : arr) {
            if (li.contains(sum-element))
                return new int[] { (sum-element), element };
            li.add(element);
        }
        return new int[] {-1,-1};
    }
    
    private static int[] findTwoSumGetIndex(int[] arr, int sum) {
    	List<Integer> main_list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    	List<Integer> li = new ArrayList<>();
    	for(int i:main_list) {
    		int compliment = sum - i;
    		if(li.contains(compliment)) {
    			return new int[] {main_list.indexOf(compliment),main_list.lastIndexOf(i)};
    		}
    		li.add(i);
    	}
    	return new int[] {-1,-1};
    }
}