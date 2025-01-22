package UdemyJavaFundamentalsTest;

public class DoWhileAgain {
    public static void main(String[] args) {
        boolean isComplete = false;
        do {
            if(!isComplete) {
                isComplete = true;
                System.out.println("Processing");
            }
        } while (isComplete);
        System.out.println("Completed");
    }
}
