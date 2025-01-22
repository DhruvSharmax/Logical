package challenges.stringPlay;

public class ReverseEachWord {
	public static void main(String[] args) {
		String s = "My Name Is Dhruv";
		
		String output = "";
		
		for(String word:s.split(" ")) {
			for(int i=word.length()-1; i>=0; i--) {
				output+=word.charAt(i);
			}
			output+=" ";
		}	
		System.out.println(output);
	}
}
