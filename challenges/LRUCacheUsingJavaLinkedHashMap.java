package challenges;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingJavaLinkedHashMap<K,V> extends LinkedHashMap {
    int capacity;
    LRUCacheUsingJavaLinkedHashMap(int capacity) {
        super(capacity, .75f, true);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }

    public static void main(String[] args) {
        LRUCacheUsingJavaLinkedHashMap<Integer, Integer> cache = new LRUCacheUsingJavaLinkedHashMap<>(2);

        cache.put(1, "D");
        cache.put(2, "V");
        System.out.println(cache); //output {1=D, 2=V}
        cache.get(1);    // returns D
        System.out.println(cache); //output {2=V, 1=D}
        cache.put(3, "N"); // Remove V and add N
        System.out.println(cache); //output {1=D, 3=N}
        cache.get(2);    // return null
        cache.put(4, "dh"); // Remove D and add dh
        System.out.println(cache); //output {3=N, 4=dh}
        cache.get(3);    // return N
        System.out.println(cache); //output {4=dh, 3=N}
        cache.get(4);    // return 4
        System.out.println(cache); //output {3=N, 4=dh}
    }
}
