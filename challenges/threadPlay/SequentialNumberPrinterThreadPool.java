package challenges.threadPlay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequentialNumberPrinterThreadPool {
    private static final int MAX_NUMBER = 100;
    private static int counter = 1; // Shared counter

    public static void main(String[] args) {
        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                synchronized (SequentialNumberPrinterThreadPool.class) {
                while (counter <= MAX_NUMBER)
                    System.out.println(Thread.currentThread().getName() + " printed: " + counter++);
                }
            });
        }
        executor.shutdown();
    }
}

