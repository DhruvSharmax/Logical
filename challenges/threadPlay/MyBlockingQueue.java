package challenges.threadPlay;

import java.util.*;

public class MyBlockingQueue {
	/*
	just remember 2 methods of linkedList add() and removeFirst()
	 */
	
	LinkedList<Integer> li = new LinkedList<>();
	int LIMIT = 10;
	Random rand = new Random();
	
	public static void main(String[] args) {
		MyBlockingQueue q = new MyBlockingQueue();
		Thread t1 = new Thread(()->{
			try {
				q.producer();
			} catch (InterruptedException _) {}
		});
		Thread t2 = new Thread(()->{
			try {
				q.consumer();
			} catch (InterruptedException _) {}
		});

		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();

		try {
			Thread.sleep(20);				// will run main till 20ms giving producers consumers time to execute
		} catch (InterruptedException _) {}
	}

	synchronized void producer() throws InterruptedException {
		while(true) {
			while(li.size()==LIMIT) wait();
			li.add(rand.nextInt(10));
			notify();
		}
	}
	
	synchronized void consumer() throws InterruptedException {
		while(true) {
			while(li.size()==0) wait();
			System.out.println("item consumed: "+li.removeFirst()+ " List size: "+li.size());
			notify();
		}
	}
}
