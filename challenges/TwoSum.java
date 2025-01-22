package challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSum {
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
   
   public static void convertBruteForceToStream(int[] arr, int sum) {
	  Arrays.stream(arr)
	   .mapToObj(i->Arrays.stream(arr)
	   .mapToObj(k->new int[] {k,i}))
	   .flatMap(l->l)
	   .filter(m->(Arrays.stream(m).sum()==sum))
		.collect(Collectors.toList()).stream().forEach(n->System.out.println(Arrays.toString(n)));
   }
    
    private static int[] findTwoSumGetElements(int[] arr, int sum) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int compliment = sum - arr[i];
            if (li.contains(compliment)) {
                return new int[] { compliment, arr[i] };
            }
                li.add(arr[i]);
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

    public static void main(String[] args) {
    	int[] list = new int[] { 1, 4, 1, 4, 4, 1 };
        int[] indices = findTwoSumGetElements(list, 8);
        
        System.out.println(indices[0] + " " + indices[1]);
        
        indices=findTwoSumGetIndex(list,8);
        System.out.println(indices[0] + " " + indices[1]);
        
        convertBruteForceToStream(list,8);
    }
}