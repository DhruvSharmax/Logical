package DS100_Genpact;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BucketAlgoApp {
    public static void main(String[] args) {
        User u = new User(1);
        var pool = Executors.newFixedThreadPool(12);
        for (int i=0;i<12;i++)
            pool.submit(()->u.accessApp());
    }
}

class User {
    int id;
    Map<Integer, LeakyBucket> bucket;
    User(int id) {
        this.id=id;
        bucket = new HashMap<>();
        bucket.put(this.id, new LeakyBucket(10));
    }

    public void accessApp() {
        if(bucket.get(id).isAcessible())
            System.out.println(Thread.currentThread().getName()+"-> access granted");
        else System.out.println(Thread.currentThread().getName()+"-> access threshold reached");
    }
}

class LeakyBucket implements RateLimiter {
    BlockingDeque<Integer> queue;
    LeakyBucket(int requestsLimit){
        queue = new LinkedBlockingDeque<>(requestsLimit);
    }
    @Override
    public boolean isAcessible() {
        if(queue.remainingCapacity()>0) {
            return queue.add(1);
        }
        else return false;
    }
}

interface RateLimiter {
    boolean isAcessible();
}