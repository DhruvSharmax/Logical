package challenges.stringPlay;

public class PalindromeCheck {
	public static void main(String[] args) {
		String s="12321";
		System.out.println(checkPali(s));
	}
	
	public static boolean checkPali(String s) {
		int start = 0;
		int end = s.length()-1;
		
		if(s.length()==0) return false;
		
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		
		return true;
	}
}
