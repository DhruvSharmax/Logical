package challenges.stringPlay;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateChars {
	public static void main(String[] args) {
		String s = "mynameisdhruvsharma";
		Set<Character> set = new HashSet<>();
		List<Character> output = s.chars()
									.mapToObj(c -> (char) c)
									.filter(x -> !set.add(x))
									.collect(Collectors.toList());
		System.out.println(output);

		s.chars()
				.mapToObj(c -> Character.valueOf((char) c))
				.collect(Collectors
						.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + "=" + v));
	}
}
