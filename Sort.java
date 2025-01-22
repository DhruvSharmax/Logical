import java.util.*;

public class Sort {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        List list1 = new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(30);
        list.add(60);
        list.add(20);
        list.add(90);

        System.out.println("Input was: "+list);

        Collections.reverse(list);

        System.out.println("Output is: "+list);
    }

}
