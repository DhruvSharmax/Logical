package challenges.stringPlay;

import java.util.*;
import java.util.stream.Collectors;

public class StringPlay {
	
	public static void main(String[] args) {
		String[] arr = {"AA", "AA","BB", "CC","DD"};
		
		eachElementWithStreamCounting(arr);		// with Stream API
		eachElementWithStreamCounting("AAAABBCCDD");
		eachElementCountWithFrequencyMethod(arr);
		readNewsPaperToFindMaxFrequencyWord("sample news to prove that sample being used multiple sample places.");
		printDuplicateElement(arr);
		printUnique(arr);
	}

	private static void eachElementWithStreamCounting(String[] arr) {
		Map<String, Long> m = Arrays.stream(arr)
				.collect(Collectors
						.groupingBy(x->x,Collectors.counting()));
		System.out.println(m);
	}
	private  static void eachElementWithStreamCounting(String s) {
		var m = s.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors
						.groupingBy(x->x,Collectors.counting()));
		System.out.println(m);
	}

	private static void eachElementCountWithFrequencyMethod(String[] arr) {
		List<String> li = Arrays.asList(arr);
		Set<String> set = new HashSet<>();
		set.addAll(li);
		var m = set.stream()
				.collect(Collectors
						.toMap(x->x, x->Collections.frequency(li, x)));
		System.out.println(m);
	}

	//time comp: n+m where n is length of string and m in number of words
	// space com: m
	private static void readNewsPaperToFindMaxFrequencyWord(String str) {
		var list = Arrays.asList(str.split(" "));
		var maxCountedWord = list.stream()
				.collect(Collectors.groupingBy(x->x,Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println(maxCountedWord.getKey()+ " appeared "+maxCountedWord.getValue()+" times");
	}

	private static void printDuplicateElement(String[] arr) {
		Set<String> set = new HashSet<>();
		List<String> li = Arrays.stream(arr).filter(x->!set.add(x)).collect(Collectors.toList());
		System.out.println(li);
	}
	
	private static void printUnique(String[] arr) {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(arr));
		System.out.println(set);
	}
}