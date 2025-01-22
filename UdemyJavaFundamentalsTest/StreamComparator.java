package UdemyJavaFundamentalsTest;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamComparator {
    public static void main(String[] args) {
        Stream<Integer> num = Stream.of(4,9,5);
        Comparator<Integer> comp = (f,g) -> f-g;
        num.sorted(comp).forEach(System.out::print);
    }
}
