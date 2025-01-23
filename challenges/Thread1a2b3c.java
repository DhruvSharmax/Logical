package challenges;

public class Thread1a2b3c {
    static final Object lock = new Object();
    static boolean numberTurn = true;
    public static void main(String[] args) {
        var print_numbers = new Thread(()->{
            for (int i = 1; i <= 26; i++) {
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
        });
        var print_chars = new Thread(()-> {
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
        });

        print_numbers.start();
        print_chars.start();
    }
}