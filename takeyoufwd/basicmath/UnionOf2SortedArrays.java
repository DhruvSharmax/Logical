package takeyoufwd.basicmath;

import java.util.*;
import java.util.stream.Stream;
// union mean all elements of both arrays (no duplicates)
public class UnionOf2SortedArrays {
    void main(){
        int[] a={1,1,2,3,4,5},
              b={1,2,3,4,5,6};
        unionWithSet(a, b);
        System.out.println();
        union(a,b);
    }

    private static void unionWithSet(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        Stream.of(a, b)
                .flatMapToInt(Arrays::stream)
                .filter(set::add)
                .forEach(System.out::print);
    }

    private static void union(int[] a, int[] b) {
        int flen=a.length, slen=b.length;
        int i=0,j=0,k=0;
        int[] union = new int[flen+slen];

        while(i<flen || j<slen) {
            if(i<flen && a[i]<=b[j]) {
                if(k==0 || a[i]!=union[k-1])
                    union[k++] = a[i];
                i++;
            }
            else {
                if(k==0 || b[j]!=union[k-1])
                    union[k++] = b[j];
                j++;
            }
        }
        for (i=0;i<k;i++) System.out.print(union[i]);
    }
}
