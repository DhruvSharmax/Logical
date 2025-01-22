package UdemyJavaFundamentalsTest;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> System.out.println("Receiving"));
        Thread t2 = new Thread(()-> System.out.println("Transmitting"));
        t1.setPriority(6);      // default priority is 5, where 1 is lowest and 10 is highest
        t1.start();
        t2.start();
    }

    // but output still cannot be determined, and can vary according to jvm
}
