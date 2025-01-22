package UdemyJavaFundamentalsTest;

interface Trigger {
    default void enable(){
        System.out.println("Trigger");
    }
}

interface Scheduler {
    default void enable(){
        System.out.println("Scheduler");
    }
}
public class InterfaceRule2 implements Trigger, Scheduler {
    public void enable(){
        System.out.println("InterfaceRule2");
    }

    public static void main(String[] args) {
        new InterfaceRule2().enable();
    }
}
