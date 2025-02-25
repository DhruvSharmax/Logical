package challenges.threadPlay;

public class Deadlock {
	
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		new Thread(()-> {
			while(true) {
				synchronized(o1) {
					synchronized(o2) {
						System.out.println("inside first");
					}
				}
			}
		}).start();

		new Thread(()-> {
			while(true) {
				synchronized(o1) {
					synchronized(o2) {
						System.out.println("inside second");
					}
				}
			}
		}).start();
	}
}
