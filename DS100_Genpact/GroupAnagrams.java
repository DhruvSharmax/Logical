package DS100_Genpact;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"abc","bac","cab","bat"};
        Map<String,List<String>> map = new LinkedHashMap<>();
        for(String s:strings) {
            var charArray = s.toCharArray();
            Arrays.sort(charArray);
            var sorted = new String(charArray);

            if(map.containsKey(sorted)) {
                var existingList = map.get(sorted);
                existingList.add(s);
                map.put(sorted, existingList);
            }
            else {
                var newList = new ArrayList<String>();
                newList.add(s);
                map.put(sorted, newList);
            }
        }
        System.out.println(map);

        map = Arrays.stream(strings)
                .collect(Collectors.groupingBy(
                        x->x.chars()
                            .sorted()
                            .mapToObj(a -> String.valueOf((char) a))
                            .collect(Collectors.joining()),
                        LinkedHashMap::new,
                        Collectors.toList()));
        System.out.println(map);

    }
}
