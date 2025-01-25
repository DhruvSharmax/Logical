package challenges;
/*
print 1,11,21,31 using thread 1
      2,22,32,42 using thread 2
      and so on
      final o/p should be 1 to 100 serially.
 */
class OneThreadForOneNumber implements Runnable {

    public static final int TOTAL_THREADS = 10;
    private static final int LIMIT = 30;
    private static volatile int counter = 0;
    private int id;

    public OneThreadForOneNumber(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while(counter <= LIMIT) {
            while (counter % TOTAL_THREADS == id) {
                System.out.println("Thread "+Thread.currentThread().getName()+ " printed " + counter);
                counter++;
            }
        }
    }

    public static void main (String args[]) {
        for (int i=0;i<TOTAL_THREADS;i++)
            new Thread(new OneThreadForOneNumber(i)).start();
    }
}
