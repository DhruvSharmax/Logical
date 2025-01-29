package challenges.threadPlay;

import java.util.concurrent.locks.ReentrantLock;
/*
in this re-Enterant example we're not using Object's implicit lock like in synchronized(object), here
re-enternat lock is providing explicit locking with methods like lock,unlock,trylock,lockInterruptibly and fairness
 */
public class EvenOddReentrant {
	static int counter=1;
		public static void main(String[] args) {
			ReentrantLock lock = new ReentrantLock(true);		// defined fairness property true
			int N=10;

			Thread printEven = new Thread(()->{
				while(N>counter) {
					if(counter%2==0) {
						try {
							lock.lock();
							System.out.println(counter);
							counter++;
						} finally {
							lock.unlock();
						}
					}
				}
			});
			Thread printOdd = new Thread(()-> {
				while(N>counter) {
					if(counter%2!=0) {
						try {
							lock.lock();
							System.out.println(counter);
							counter++;
						} finally {
							lock.unlock();
						}
					}

				}
			});

		printEven.start();
		printOdd.start();
	}
}