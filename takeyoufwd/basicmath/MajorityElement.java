package takeyoufwd.basicmath;

import java.util.*;

// https://takeuforward.org/plus/dsa/problems/majority-element-i
public class MajorityElement {
    void main(){
        int[] a={7,5,5,5,5,7,5,7,5,1,5,7,5,5,7,7};
        find(a);
        find2(a);
        find3(a);
    }

    private void find(int[] a) {
        int maj=a.length/2;
        List<Integer> li = Arrays.stream(a).boxed().toList();
        li.stream()
                .filter(x->Collections.frequency(li,x)>=maj)
                .distinct()
                .forEach(System.out::println);
    }
    private void find2(int[] a) {
        int maj=a.length/2;
        Map<Integer,Integer> m=new HashMap<>();
        for (int i:a){
            m.put(i, m.getOrDefault(i,0)+1);
            if(m.get(i)>=maj) {
                System.out.println(i);
                break;
            }
        }
    }

    private void find3(int[] a) {
        int maj=a.length/2;
        int ele=-1, count=0;
        for (int i : a) {
            if (count == 0) ele = i;
            if (ele == i) count++;
            else count--;
        }

        // below step only relevant to verify if there is a major element or not.
        // if question says clearly there is 1 major element, ele will be your answer w/o below step
        count=0;
        for (int i : a)
            if (i == ele) count++;;
        if (count >= maj)
            System.out.println(ele);
    }
}
