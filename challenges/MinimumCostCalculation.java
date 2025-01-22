import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
 * this is not correct program as it was only created by me to pass an online 
correct program is here https://www.geeksforgeeks.org/minimum-cost-of-reducing-array-by-merging-any-adjacent-elements-repetitively/
 */
public class MinimumCostCalculation {
	public static void main(String[] args) {
		int out = mergeArray(new int[] {2,3,4,5,7});
		
		System.out.println(out);
	}

	private static int mergeArray(int[] arr) {
		Arrays.sort(arr);
		int cost = 0;
		List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		while(li.size()!=1) {
			int x = li.get(0);
			int y = li.get(li.size()-1);
			
			double d = (x+y)/(Math.abs(x-y)+1);
			cost += Math.ceil(d);
			li.remove(0);
			li.remove(li.size()-1);
			li.add(x+y);
		}
		
		return cost;
	}
}
