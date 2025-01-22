package UdemyJavaFundamentalsTest;

import java.util.Arrays;
import java.util.List;

public class StreamDropWhile {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a","b","c","a","s");
        String result = letters.stream().dropWhile(letter -> (letter.charAt(0)<'c')).reduce("",String::concat);
        System.out.println(result);
    }
}
