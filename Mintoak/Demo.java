package Mintoak;

public class Demo {
	int x=10;
	
	/*public static class inner {
		public static void my() {
			System.out.println(x);
		}
	}*/
	
	public static void main(String[] args) {
		Demo d1 = new Demo();
		Demo d2 = new Demo();
		d1.x=20;
		
		System.out.println(d1.x);
		System.out.println(d2.x);
	}
}
