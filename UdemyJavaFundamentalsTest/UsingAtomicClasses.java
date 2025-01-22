package UdemyJavaFundamentalsTest;

import java.util.concurrent.atomic.AtomicBoolean;

public class UsingAtomicClasses {
    private static AtomicBoolean isActive = new AtomicBoolean();
    private Object lock = new Object();

    public synchronized boolean isActive1(boolean newValue) {
        return isActive.getAndSet(newValue);
    }
    public static synchronized boolean isActive2(boolean expectedValue, boolean newValue) {
        return isActive.compareAndSet(expectedValue, newValue);
    }
    public boolean isActive3(boolean newValue) {
        synchronized (lock) {
            return isActive.getAndSet(false);
        }
    }
}

// Q. is class thread safe ? Ans: yes all of its methods are thread safe so class is thread safe.
