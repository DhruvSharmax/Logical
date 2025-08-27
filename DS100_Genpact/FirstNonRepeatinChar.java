package DS100_Genpact;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatinChar {
    public static void main(String[] args) {
        var s = "geeksforgeeks";
        System.out.println(findChar(s));
    }

    private static char findChar(String s) {
        return s.chars().mapToObj(x-> (char)x)
                .collect(Collectors.groupingBy(x->x, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
    }
}
