package challenges.threadPlay;

public class ThreadSequence {

 public static void main(String[] args) {
  // Three threads
  Thread t1 = new Thread(()->myTask());
  Thread t2 = new Thread(()->myTask());
  Thread t3 = new Thread(()->myTask());
  
  try {
   t1.start();
   t1.join();
   t2.start();
   t2.join();
   t3.start();
   t3.join();
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
 }

 public static void myTask() {
  System.out.println("In run method " + Thread.currentThread().getName());
 } 
}