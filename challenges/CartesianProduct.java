package challenges;

import java.util.*;
import java.util.stream.*;
/*
create all Permutations combinations with given arrays.
also apply a condition to find only those combinations which sum up to less than 25.
 */
public class CartesianProduct {
	public static void main(String[] args) {
		int[] pants= {3, 5, 7}, shirts = {4, 7, 8}, 
				skirts = {5, 8}, shoes = {3};
		int budget = 25;
		long time_pre=System.currentTimeMillis();

		List<int[]> li = Arrays.stream(pants)
				.mapToObj(i -> Arrays.stream(shirts)
						.mapToObj(j -> Arrays.stream(skirts)
								.mapToObj(k -> Arrays.stream(shoes)
										.mapToObj(l -> new int[]{i, j, k, l}))))
										.flatMap(e -> e)
								.flatMap(e -> e)
						.flatMap(e -> e)
				.filter(x -> (Arrays.stream(x).sum()) < budget)
				.collect(Collectors.toList());
		
		//li.forEach(ar->System.out.println(Arrays.toString(ar)));
		
		long time_post=System.currentTimeMillis();
		System.out.println("Time Spent:"+ (time_post-time_pre));

		// Another shorter way with Integar objects

		Integer[] pants1= {3, 5, 7}, shirts1 = {4, 7, 8},
				skirts1 = {5, 8}, shoes1 = {3};
		List<Integer[]> li2 =
				Arrays.stream(pants1)
				.flatMap(i -> Arrays.stream(shirts1)
						.flatMap(j -> Arrays.stream(skirts1)
								.flatMap(k -> Arrays.stream(shoes1)
										.map(l -> new Integer[]{i, j, k, l}))))
				.filter(x -> Arrays.stream(x).mapToInt(y->y).sum() < budget)
				.collect(Collectors.toList());

		li2.forEach(ar->System.out.println(Arrays.toString(ar)));
	}
}