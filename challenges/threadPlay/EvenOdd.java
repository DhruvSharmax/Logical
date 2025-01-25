package challenges.threadPlay;

public class EvenOdd {
	
	private int N=10;
	private int counter=0;
	
	public void printEven() {
		while (N > counter) {
			synchronized (this) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter+++" ");
				notify();
			}
		}
	}
	
	public void printOdd() {
		while (N > counter) {
			synchronized (this) {
				while (counter % 2 != 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print(counter+++" ");
				notify();
			}
		}
	}

		public static void main(String[] args) {
			EvenOdd eo = new EvenOdd();
			
			Thread t1 = new Thread(()->eo.printEven());
			Thread t2 = new Thread(()->eo.printOdd());
			
		t1.start();
		t2.start();
	}
}