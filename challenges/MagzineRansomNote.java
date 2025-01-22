package challenges;

import java.util.*;

public class MagzineRansomNote {
	public static void main(String[] args) {
		List<String> magazine = Arrays.asList("two times three is not four".split(" "));
		List<String> note = Arrays.asList("two times two is four".split(" "));
		
		checkMagazine(magazine, note);
	}

	private static void checkMagazine(List<String> magazine, List<String> note) {
		boolean flag=true;
		Map<String,Integer> note_m = new HashMap<>();
		
		for(String s:note) {
			if(note_m.containsKey(s))
				note_m.put(s, note_m.get(s)+1);
			else
				note_m.put(s, 1);
		}
		
		for(String s:magazine) {
			if(note_m.containsKey(s) && note_m.get(s)!=0) {
				int currVal = note_m.get(s);
				note_m.put(s, currVal-1);
			}
		}
		
		for(int i:note_m.values())
			if(i!=0) flag=false;
		
        System.out.println(flag?"Yes":"No");
    }
}
