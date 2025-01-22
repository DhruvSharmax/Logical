package challenges.stringPlay;

import java.util.*;
/*
 * String Comparison 
Given a pair of strings. The goal is to make them equal by doing one of the following operations (at most once): 
� Select two characters, charl and char2, and replace all occurrences of charl in the first string with char2. 
� Select two characters, charl and char2, and replace all occurrences of char1 in the second string with char2 
� For example, the string "xxyz" can be convened to any of the following strings:v"yyyz", "vvyz", "xxzz", "xxwz", etc. 
� However, it cannot be converted to the string "yzyz" (Since all the occurrences of a character can be replaced by a single new character). 
*/
public class ReplaceStringChar {
	public static void main(String[] args) {
		List<String> out = 
				getResults(Arrays.asList("aaa","abbc","zyz","SEEKSFORGEEKS","hhhh","xxyz","xxyz","xxyz","xxyz","xxyz"),
						   Arrays.asList("bbb","cccc","zyx","GEEKSFORGEEKG","hhhh","yyyz","vvyz","xxzz","xxwz","yzyz"));

		System.out.println(out);
	}

	private static List<String> getResults(List<String> list1, List<String> list2) {
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < list1.size(); i++) {
			String s1 = list1.get(i);
			String s2 = list2.get(i);
			output.add(checkEquality(s1, s2));
		}
		return output;
	}

	private static String checkEquality(String s1, String s2) {
		if (s1.length() != s2.length())
			return "NO";

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i))
				continue;
			else {
				String char1 = s1.charAt(i)+"";
				String char2 = s2.charAt(i)+"";
				
				if (s1.replaceAll(char1, char2).equals(s2))
					return "YES";
				else if (s2.replaceAll(char2, char1).equals(s1))
					return "YES";
				else
					return "NO";
			}
		}
		
		return "YES";
	}
}
