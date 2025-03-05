package JavaSpecific.streamPlay;

import java.util.Arrays;
import java.util.List;
/*
dropwhile
drops elements(not include) till predicate is true, once predicate is false,
remaining elements gets added in stream w/o checking
 */
public class StreamDropWhile {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a","b","c","a","s");
        String result =
                letters.stream()
                        .dropWhile(letter -> (letter.charAt(0)<'c'))
                        .reduce("",String::concat);
        System.out.println(result);
    }
}
