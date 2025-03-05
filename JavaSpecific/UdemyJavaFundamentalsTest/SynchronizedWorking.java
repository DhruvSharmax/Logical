package JavaSpecific.UdemyJavaFundamentalsTest;

public class SynchronizedWorking {
    private volatile boolean terminate = false;

    private void clearQueue(){}
    private void clearMap(){}

    private void terminate(boolean hardTerminate) {
        System.out.println("Terminating:" + hardTerminate);

        terminate = true;
        //synchronized (terminate) {        so problem here is synchronized accepts Object only in paranthesis
        synchronized (SynchronizedWorking.class) {      // this line is fix
            if(hardTerminate) {
                clearQueue();
                clearMap();
            }
            this.notify();
        }
    }
}
