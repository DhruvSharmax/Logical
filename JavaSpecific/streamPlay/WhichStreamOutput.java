package JavaSpecific.streamPlay;
import java.util.stream.Stream;

public class WhichStreamOutput {
    private static Stream<String>  getWords(String a, String b) {
        return Stream.of(a,b);
    }
    public static void main(String[] args) {
        String answer =
                Stream.of(getWords("voyage", "rue"), getWords("habitude","quel"), getWords("oui","parfaite"))
                        .flatMap(x->x)
                        .filter(x-> !x.isEmpty())
                        .max((a,b) -> b.length()-a.length())
                        .get();
        System.out.println(answer);
        // two things to note above, first max is not actually getting max but min out of them
        // second there are two mins rue and oui, rue is printed because it was found first
    }
}
