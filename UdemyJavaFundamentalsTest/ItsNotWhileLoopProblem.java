package UdemyJavaFundamentalsTest;

public class ItsNotWhileLoopProblem {
    public static void main(String[] args) {
        do{
            int timer = 10;
            do{
                timer--;
            } while (timer>0);
                break;
        } while (true);

        //System.out.println(timer);

        // another version has variable defined on top

        int counter = 0;
        do{
            do{
                counter++;
            } while (counter<3);
            break;
        } while (true);

        System.out.println(counter);
    }
}
