package challenges.threadPlay;

public class Thread1a2b3c {
    boolean numberTurn = true;
    private void print_char() {
        for (char c='A';c<='Z';c++) {
            synchronized (this) {
                while (numberTurn) {
                    try {
                        wait();
                    } catch (InterruptedException _) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(c);
                numberTurn = true;
                notify();
            }
        }
    }

    private void print_num() {
        for (int i = 1; i <= 30; i++) {
            synchronized (this) {
                while (!numberTurn) {
                    try{
                        wait();
                    } catch (InterruptedException _) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.print(i);
                numberTurn=false;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        Thread1a2b3c obj = new Thread1a2b3c();
        new Thread(obj::print_num).start();
        new Thread(obj::print_char).start();
    }
}