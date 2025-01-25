package challenges.stringPlay;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonCharInTwoStrings {
	public static void main(String[] args) {
		System.out.println(checkSubStringBruteForce("and","art"));
		
		System.out.println(checkSubString("and","art"));
	}

	private static String checkSubString(String s1, String s2) {
		Set<Character> set1 = s1.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
		Set<Character> set2 = s2.chars().mapToObj(x->(char)x).collect(Collectors.toSet());
		set1.retainAll(set2);
		if(!set1.isEmpty())
			return "YES";
		return "NO";
	}

	private static String checkSubStringBruteForce(String s1, String s2) {
		List<Character> s1_l = s1.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		
		for(char c:s2.toCharArray()) {
			if(s1_l.contains(c))
				return "YES";
		}
		return "NO";
	}
}
