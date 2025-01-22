package samsung;

import java.util.*;
import java.util.stream.Collectors;

public class StringPlay {
	
	public static void main(String[] args) {
		String[] arr = {"AA", "AA","BB", "CC","DD"};
		
		eachElementCount(arr);		// with Stream API
		eachElementCountWithFrequency(arr);
		eachElementCountWithFrequency("AAAABBCCDD");
		readNewsPaperToFindMaxFrequencyWord("sample news to prove that sample being used multiple sample places.");
		printDuplicateElement(arr);
		printUnique(arr);
	}

	private static void eachElementCount(String[] arr) {

		Map<String, Long> m;

		m=Arrays.stream(arr).collect(Collectors.groupingBy(x->x,Collectors.counting()));

		System.out.println(m);
	}

	private static void eachElementCountWithFrequency(String[] arr) {
		List<String> li = Arrays.asList(arr);
		Set<String> set = new HashSet<>();
		set.addAll(li);
		set.stream().forEach(x->System.out.print(x+"="+Collections.frequency(li, x)+","));
		System.out.println("");
	}

	private  static void eachElementCountWithFrequency(String s) {
		s.chars()
				.mapToObj(c -> Character.valueOf((char) c))
				.collect(Collectors
						.groupingBy(x->x,Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + "=" + v));
	}

	//time comp: n+m where n is length of string and m in number of words
	// space com: m
	private static void readNewsPaperToFindMaxFrequencyWord(String str) {
		var list = Arrays.asList(str.split(" "));
		var op = list.stream()
				.collect(Collectors.groupingBy(x->x,Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println(op);
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