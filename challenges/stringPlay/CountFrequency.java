package challenges.stringPlay;

import java.util.*;
import java.util.stream.Collectors;

public class CountFrequency {
	
	public static void main(String[] args) {
		eachElementCount("AAAABBCCDD");
		eachCharCount("AAAABBCCDD");
		eachElementCountWithFrequencyMethod(new String[] {"AA", "AA","BB", "CC","DD"});
		readNewsPaperToFindMaxFrequencyWord("sample news to prove that sample being used multiple sample places.");
	}

	private static void eachElementCount(String s) {
		var m = s.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors
						.groupingBy(x->x,Collectors.counting()));
		System.out.println(m);
	}

	private static void eachCharCount(String s) {
		int[] freq = new int[256];
		for(char c: s.toCharArray())
			freq[c]++;

		for(int i=0;i<256;i++)
			if(freq[i]>0)
				System.out.print( (char)i +"="+ freq[i] +", ");
	}

	private static void eachElementCountWithFrequencyMethod(String[] arr) {
		List<String> li = Arrays.asList(arr);
        Set<String> set = new HashSet<>(li);
		var m = set.stream()
				.collect(Collectors
						.toMap(x->x, x->Collections.frequency(li, x)));
		System.out.println("\n"+m);
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
}