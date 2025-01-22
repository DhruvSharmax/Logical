package challenges;

public class Deadlock {
	
	private Object o1 = new Object();
	private Object o2 = new Object();
	
	public void first() {
		while(true) {
			synchronized(o1) {
				synchronized(o2) {
					System.out.println("inside first");
				}
			}
		}
	}
	
	public void second() {
			while(true) {
			synchronized(o1) {
				synchronized(o2) {
					System.out.println("inside second");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Deadlock d = new Deadlock();
		Thread t1 = new Thread(()->d.first());
		Thread t2 = new Thread(()->d.second());
		
		t1.start();
		t2.start();
	}
}
