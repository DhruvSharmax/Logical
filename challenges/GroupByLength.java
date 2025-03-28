package challenges;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByLength {
    public static void main(String[] args) {
        var list = List.of("abc", "acb", "xyz", "abcd", "wxyz", "12345", "54321");
        list.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.toList()))
                .forEach((k,v)->System.out.println(k+":"+v.size()));
    }
}
