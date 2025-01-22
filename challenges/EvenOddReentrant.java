package challenges;

import java.util.concurrent.locks.ReentrantLock;

public class EvenOddReentrant {
	static int counter=0;
		public static void main(String[] args) {
			ReentrantLock lock = new ReentrantLock();
			int N=10;

			Thread t1 = new Thread(()->
			{
				while(N>counter) {
					if(counter%2==0) {
						try {
							lock.lock();
							counter++;
							System.out.print(counter);
						} finally {
							lock.unlock();
						}
					}
				}
			}
					);
			Thread t2 = new Thread(()-> {
				while(N>counter) {
					if(counter%2!=0) {
						try {
							lock.lock();
							counter++;
							System.out.print(counter);
						} finally {
							lock.unlock();
						}
					}
					
				}
			});
			
		t1.start();
		t2.start();
	}
}