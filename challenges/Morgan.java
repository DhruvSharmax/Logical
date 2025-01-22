package challenges;

public class Morgan {
	public static void main(String[] args) {
		String in = "Hello ##Smily my name Dhruv ###laugh";
		String out = "";
		
		if(in==null) System.out.println("invalid string");
		
		for(String s:in.split(" ")) {
			if(s.charAt(0)=='#') {
				int n = 1;
				while(n<s.length() && s.charAt(n)=='#') {
					n++;
				}
				if(n<s.length()) {
					s=s.substring(n,s.length());
					s="<Img src="+s+".jpg>";
				}
			}
			out+=s+" ";
		}
		System.out.println(out);
	}
}

class SmilyConstant{
	
}
