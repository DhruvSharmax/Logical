package challenges.stringPlay;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Longest substring with unique characters
 */

public class LongestSubstringWithoutRepeatingChar {
	
public static void main(String[] args) {
		
		String s = "CODINGISAWIESOME";
		//System.out.println(getSubStringByList(s));
		//System.out.println(findSubStringByString(s));
		System.out.println(getSubStringBySlidingWindow(s));
		System.out.println(getSubStringByBruteForce(s));
	}
	
	public static String getSubStringByBruteForce(String s) {
		String output="";
		for(int start=0;start<s.length();start++) {
			List<Character> li = new ArrayList<>();
			int end = start;
			for(;end<s.length();end++) {
				char c = s.charAt(end);
				if(li.contains(c))
					break;
				li.add(c);
			}
			if(output.length()<end-start+1)
				output = s.substring(start,end);
		}
		return output;
	}
	
	public static String getSubStringBySlidingWindow(String s) {
	    String output = "";
	    Map<Character,Integer> map = new HashMap<>();
	    int start = 0;
	    for(int i = 0; i<s.length(); i++) {
	    	Character c = s.charAt(i);
	    	if(map.containsKey(c))
	    		start = Math.max(map.get(c)+1, start);
	    	if(output.length()<i+1-start)
	    		output = s.substring(start,i+1);

	    	map.put(c, i);
	    }
	    return output;
	}

	@Test
	public void givenString_whengetSubStringByBruteForceCalled_thenResultFoundAsExpected() {
		assertEquals("", getSubStringByBruteForce(""));
		assertEquals("A", getSubStringByBruteForce("A"));
		assertEquals("ABCDEF", getSubStringByBruteForce("AABCDEF"));
		assertEquals("ABCDEF", getSubStringByBruteForce("ABCDEFF"));
		assertEquals("NGISAWE", getSubStringByBruteForce("CODINGISAWESOME"));
		assertEquals("be coding", getSubStringByBruteForce("always be coding"));
	}

	@Test
	public void givenString_whengetSubStringBySlidingWindowCalled_thenResultFoundAsExpected1() {
		assertEquals("", getSubStringBySlidingWindow(""));
		assertEquals("A", getSubStringBySlidingWindow("A"));
		assertEquals("ABCDEF", getSubStringBySlidingWindow("AABCDEF"));
		assertEquals("ABCDEF", getSubStringBySlidingWindow("ABCDEFF"));
		assertEquals("NGISAWE", getSubStringBySlidingWindow("CODINGISAWESOME"));
		assertEquals("be coding", getSubStringBySlidingWindow("always be coding"));
	}
}
