package takeyoufwd.basicmath;

import java.util.*;
// https://takeuforward.org/plus/dsa/problems/single-number---i
// https://www.youtube.com/watch?v=bYWLJb3vCWY&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=19&ab_channel=takeUforward
public class FindSingleNumber {
    void main(){
        int[] a={1, 2, 2, 4, 3, 1, 4};
        int[] a1={5};

        findSingle1(a);      // brute force using streams, another brute force can be O(n²) loop
        findSingle2(a);     //  better sol - use Map TC- O(n)+O(m) SC- O(m) ere m is size of map which is (n/2)+1
        findSingle3(a);     // best - its a classic XOR problem ;)
    }

    private void findSingle3(int[] a) {
        int xor = 0;
        for (int i:a)
            xor^=i;
        System.out.println(xor);
    }

    private void findSingle2(int[] a){
        Map<Integer,Integer> m = new HashMap<>();
        for(int i:a)
            m.put(i, m.getOrDefault(i,0) +1);

        for (Map.Entry<Integer,Integer> entry:m.entrySet())
            if (entry.getValue()==1)
                System.out.println(entry.getKey());
    }

    private void findSingle1(int[] a) {
        List<Integer> li=Arrays.stream(a).boxed().toList();
        li.stream()
                .filter(x->
                        Collections.frequency(li,x)==1
                )
                .forEach(System.out::println);
    }
}
