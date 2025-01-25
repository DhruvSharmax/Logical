package EPAM;

import java.util.*;
import java.util.concurrent.*;

public class ArrayPlay {
	static int sum = 0;
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,4,3,4,10,20,2,4,1);
		List<Integer> list1 = Arrays.asList(2,3,4,5,7,-1);
		ArrayPlay m = new ArrayPlay();
		m.countOccurances(list);
		
		m.findPairs(list1,10);
		m.finPairsOptimized(list1, 6);
		
		System.out.println(m.calculateSum(list,list1));
		System.out.println(m.calculateSumStream(list,list1));
		System.out.println(m.calculateSumThread(list,list1));
	}
	
	public int calculateSum(List<Integer>... list) {
		sum = 0;
		for(List<Integer> li:list) {
			for(int i:li) 
				sum+=i;
		}
		return sum;
	}
	
	public int calculateSumStream(List<Integer>... list) {
		int result = Arrays.stream(list)
				.map(i->i.stream().mapToInt(j->j).sum())
				.mapToInt(k->k).sum();
		return result;
	}
	
	public int calculateSumThread(List<Integer>... list) {
		sum = 0;
		ExecutorService ex = Executors.newCachedThreadPool();
		for(List<Integer> li:list) {
			ex.submit(()->{
				for(int i:li) 
					synchronized(ArrayPlay.class) {
						sum+=i;
					}
			});
		}
		ex.shutdown();
		return sum;
	}
	
	public void countOccurances(List<Integer> list) {
		Map<Integer,Integer> m = new HashMap<>();
		for(Integer i:list) {
			if(!m.containsKey(i))
				m.put(i,0);
			
				m.put(i, m.get(i)+1);
		}
		
		for(Map.Entry entry:m.entrySet())
			System.out.println(entry.getKey()+":"+entry.getValue());
		
		System.out.println("-----------------");
		
		Set<Integer> s = new HashSet<>(list);
		for(int i:s)
			System.out.println(i+":"+Collections.frequency(list, i));
	}
	
	public void findPairs(List<Integer> list1,int sum) {
		for(int i=0;i<list1.size();i++) {
			for(int j=i+1;j<list1.size();j++) {
				if(list1.get(i)+list1.get(j)==sum && i!=j) {
					System.out.println(list1.get(i)+","+list1.get(j));
				}
			}
		}
	}
	
	public void finPairsOptimized(List<Integer> list1,int sum) {
		List<Integer> li = new ArrayList<>();
		for(int i:list1) {
			if(li.contains(sum-i))
				System.out.println((sum-i)+":"+i);

			li.add(i);
		}
	}
}
