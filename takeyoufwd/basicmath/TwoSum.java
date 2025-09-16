package takeyoufwd.basicmath;

import java.util.*;

public class TwoSum {
    void main(){
        int[] a={-6, 7, 1, -7, 6, 2};
        int k=3;
        withList(a,k);
        withMap(a,k);
    }

    private void withList(int[] a, int k) {
        List<Integer> li= Arrays.stream(a).boxed().toList();
        for (int i:a)
            if(li.contains(k-i)) {
                System.out.println(li.indexOf(i) + " and " + li.indexOf(k - i));
                break;
            }
    }

    private void withMap(int[] a, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        for (int i=0;i<a.length;i++){
            m.put(a[i],i);
            if(m.containsKey(k-a[i]))
                System.out.println(i +" and "+ m.get(k-a[i]));
        }
    }


}