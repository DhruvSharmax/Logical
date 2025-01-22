package LessImportant;

public class CheckCode {
	public static void main(String[] args) {
		try {
			int x=0; int y = 5/x;
		} catch(ArithmeticException e) {
			System.out.println("Exception");
		} finally {
			System.out.println("finally");
		}
		System.out.println("finished");
	}
}
