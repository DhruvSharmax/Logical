package challenges;

public class Thread1a2b3c {
    static final Object lock = new Object();
    static boolean numberTurn = true;
    public static void main(String[] args) {
        new Thread(()->print_num()).start();
        new Thread(()->print_char()).start();
    }

    private static void print_char() {
        for (char c='A';c<='Z';c++) {
            synchronized (lock) {
                while (numberTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException _) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(c);
                numberTurn = true;
                lock.notifyAll();
            }
        }
    }

    private static void print_num() {
        for (int i = 1; i <= 30; i++) {
            synchronized (lock) {
                while (!numberTurn) {
                    try{
                        lock.wait();
                    } catch (InterruptedException _) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i);
                numberTurn=false;
                lock.notifyAll();
            }
        }
    }
}