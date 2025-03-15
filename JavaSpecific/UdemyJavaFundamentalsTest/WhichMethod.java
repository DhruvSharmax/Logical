package JavaSpecific.UdemyJavaFundamentalsTest;

public class WhichMethod {
	public static void main(String[] args) {
		sum(3,4);
		check(null);
	}
	
	public static void sum(int i, int j) {
		System.out.println(i+j);
	}
	
	public static void sum(double i, double j) {
		System.out.println(i+j);
	}
	
	public static void check(String s) {
		System.out.println(s);
	}
	
	public static void check(Object s) {
		System.out.println(s);
	}
}