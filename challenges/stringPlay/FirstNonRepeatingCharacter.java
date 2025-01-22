package challenges.stringPlay;

public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		int index = findChar(s);
		System.out.println(s.charAt(index));
	}

	private static int findChar(String s) {
		char[] count = new char[256];
		char[] char_array = s.toCharArray();

		for(char c:char_array)
			count[c]++;
		
		int i =0;
		for(;i<s.length();i++) { 
			if(count[char_array[i]]==1)
				break;
		}
		return i;
	}
}
