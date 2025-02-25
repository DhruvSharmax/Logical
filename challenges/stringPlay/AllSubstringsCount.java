package challenges.stringPlay;/*
 * https://www.geeksforgeeks.org/count-distinct-subsequences/
 */
import java.util.*;

public class AllSubstringsCount {
	public static void main(String[] args) {
		System.out.println(countSubsequences("abc"));
	}

	/*
	 * a formula has been created in loop where we're taking 2 variables levelCount and allCount, 
	 * such that with each new char we'll do +1 in allCount and assign it to levelCount
	 * and allCount will be sum of previous allCount and calculated levelCount
	 */
	private static Integer countSubsequences(String s) {
		int levelCount = 0, allCount = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (Character c : s.toCharArray()) {
			levelCount = allCount + 1;
			allCount += levelCount;

			if (map.containsKey(c))
				allCount -= map.get(c);

			map.put(c, levelCount);
		}
		return allCount;
	}
}
