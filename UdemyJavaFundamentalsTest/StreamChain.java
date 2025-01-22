package UdemyJavaFundamentalsTest;

import java.util.stream.Stream;

public class StreamChain {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("driver", "efficiency", "conversation");
        System.out.print(words.filter(b->b.startsWith("e")).count());
    }
}
