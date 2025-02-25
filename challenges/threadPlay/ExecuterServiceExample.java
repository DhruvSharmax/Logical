package challenges.threadPlay;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterServiceExample {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Random r = new Random();
		Future<Integer> f = executor.submit(()->
		{
			int sleeptime = r.nextInt(2000);
			System.out.println("starting...");
			Thread.sleep(sleeptime);
			System.out.println("finished...");
			return sleeptime;
		});

		try {
			System.out.println(""+f.get());
		} catch (InterruptedException | ExecutionException _) {}
		
		executor.shutdown();
	}
}
