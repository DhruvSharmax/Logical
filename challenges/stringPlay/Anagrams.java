package challenges.stringPlay;/*
 * Anagrams are those 2 strings which contains same characters. 
 * just sequence is different.
 */

public class Anagrams {
	public static void main(String[] args) {
		boolean out = isAnagram("listen","silent");
		System.out.println(out);
	}

	private static boolean isAnagram(String s1,String s2) {
		if(s1.length()!=s2.length()) return false;
		
		char[] c = new char[256];
		
		char[] s1_a = s1.toCharArray();
		char[] s2_a = s2.toCharArray();
		
		for(int i = 0; i<s1.length();i++) {
			c[s1_a[i]]++;
			c[s2_a[i]]--;
		}
		
		for(char i:c)
			if(i!=0) return false;
		
		return true;
		
/*
 * Shorter way
 */
		
	/*     
	       char[] c1 = a.toCharArray(), c2 = b.toCharArray();
	       
	       Arrays.sort(c1); Arrays.sort(c2);
	       
	       for(int i=0;i<a.length();i++)
	           if(c1[i]!=c2[i]) return false;
	  */
	}
}
