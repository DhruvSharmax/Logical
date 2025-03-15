package challenges.stringPlay;

import java.util.*;

public class FindDuplicateUniqueDistinct {
	public static void main(String[] args) {
		String s = "mynameisdhruvsharma";
		findDuplicates(s);
		printDistinct(s);
		findNonRepeatingChars(s);
	}

	private static void findDuplicates(String s) {
		Set<Character> set = new HashSet<>();
		var op = s.chars()
									.mapToObj(c -> (char) c)
									.filter(x -> !set.add(x))
									.toList();
		System.out.println(op);
	}

	private static void printDistinct(String s) {
		List<String> list = Arrays.asList(s.split(""));
        Set<String> set = new HashSet<>(list);
		System.out.println(set);
	}

	private static void findNonRepeatingChars(String s) {
		char[] freq = new char[256];
		for(char c:s.toCharArray())
			freq[c]++;

		for (int i = 0; i<256; i++)
			if (freq[i] == 1)
				System.out.print((char)i +",");
	}
}
