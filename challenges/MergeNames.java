package challenges;

import java.util.*;
/*
 * in this program main thing to notice is, Collection to Array conversion on line 13
 */
public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> set = new HashSet<>();
        
        set.addAll(Arrays.asList(names1));
        set.addAll(Arrays.asList(names2));
        
        return set.stream().toArray(String[]::new); 
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); 
        // should print Ava, Emma, Olivia, Sophia
    }
}