package challenges.streamPlay;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamComparator {
    public static void main(String[] args) {
        Stream<Integer> num = Stream.of(4,9,5);
        Comparator<Integer> comp = Comparator.comparingInt(f -> f);  // this is also valid (f,g) -> f-g
        num.sorted(comp).forEach(System.out::print);
    }
}
