package challenges;

import java.util.*;

public class MyBlockingQueue {
	
	LinkedList<Integer> li = new LinkedList<>();
	int LIMIT = 10;
	Random rand = new Random();
	
	public static void main(String[] args) {
		MyBlockingQueue q = new MyBlockingQueue();
		Thread t1 = new Thread(()->{
			try {
				q.producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(()->{
			try {
				q.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void producer() throws InterruptedException {
		while(true) {
			while(li.size()==LIMIT) wait();
			li.add(rand.nextInt(10));
			notify();
		}
	}
	
	private synchronized void consumer() throws InterruptedException {
		while(true) {
			while(li.size()==0) wait();
			System.out.println("item consumed: "+li.removeFirst()+ " List size: "+li.size());
			notify();
		}
	}
}
