package challenges;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByLength {
    public static void main(String[] args) {
        // key should be length of string and value should be count of that length
        var list = List.of("abc", "acb", "xyz", "abcd", "wxyz", "12345", "54321");
        var map = list.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);
    }
}
