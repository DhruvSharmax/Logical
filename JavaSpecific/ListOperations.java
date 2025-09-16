package JavaSpecific;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ListOperations {
	static int sum = 0;
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,4,3,4,10,20,2,4,1);
		List<Integer> list1 = Arrays.asList(2,3,4,5,7,-1);

		calculateSum(list,list1);
		calculateSumStream(list,list1);
		calculateSumThread(list,list1);
		countOccurances(list);
		System.out.println();
		findPairs(list1,6);
		System.out.println();
		finPairsOptimized(list1, 6);
	}

	public static void calculateSum(List<Integer>... list) {
		int sum = 0;
		for(List<Integer> li:list) {
			for(int i:li)
				sum+=i;
		}
		System.out.println(sum);
	}

	public static void calculateSumStream(List<Integer>... list) {
		int result = Arrays.stream(list)
				.map(i->i.stream().mapToInt(j->j).sum())
				.mapToInt(k->k).sum();
		System.out.println(result);
	}

	public static void calculateSumThread(List<Integer>... list) {
		AtomicInteger sum = new AtomicInteger();
		ExecutorService ex = Executors.newCachedThreadPool();
		for(List<Integer> li:list) {
			ex.submit(()->{
				for(int i:li)
					synchronized(ListOperations.class) {
						sum.addAndGet(i);
					}
			});
		}
		ex.shutdown();
		System.out.println(sum.get());
	}

	public static void countOccurances(List<Integer> list) {
		Map<Integer,Integer> m = new HashMap<>();
		for(Integer i:list) {
			if(!m.containsKey(i))
				m.put(i,0);

			m.put(i, m.get(i)+1);
		}
		System.out.println(m);

		Set<Integer> s = new HashSet<>(list);
		for(int i:s)
			System.out.print(i+"="+Collections.frequency(list, i)+", ");
	}

	public static void findPairs(List<Integer> list1,int sum) {
		for(int i=0;i<list1.size();i++) {
			for(int j=i+1;j<list1.size();j++) {
				if(list1.get(i)+list1.get(j)==sum && i!=j) {
					System.out.print(list1.get(i)+","+list1.get(j)+" and ");
				}
			}
		}
	}

	public static void finPairsOptimized(List<Integer> list1,int sum) {
		List<Integer> li = new ArrayList<>();
		for(int i:list1) {
			if(li.contains(sum-i))
				System.out.print((sum-i)+","+i+" and ");
			li.add(i);
		}
	}
}