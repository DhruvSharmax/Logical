package challenges;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindIndex {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4, 3, 0, 5, 1, 2));
        processList(list); // Expected output: 2 4 5 1 0 3
        list = new ArrayList<>(List.of(7, 6, 5, 4, 0, 1, 2, 3));
        processList(list); // Expected output: 4 5 6 7 3 2 1 0
    }

    private static void processList(List<Integer> list) {
        IntStream.range(0,list.size())
                 .map(list::indexOf)         // complexity of indexOf is O(n) makes a linear search
                 .forEach(i -> System.out.print(i + " "));

        System.out.println(); // To separate test case outputs
    }
}
