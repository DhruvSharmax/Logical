package ING;

import java.util.*;

class VisitCounter {
	
	public static void main(String[] args) {
		HashMap<String, UserStats> m1=new HashMap<String, UserStats>();
		m1.put("1", new UserStats(Optional.of(3L)));
		m1.put("2", new UserStats(Optional.of(5L)));
		
		HashMap<String, UserStats> m2=new HashMap<String, UserStats>();
		m2.put("3", new UserStats(Optional.of(7L)));
		m2.put("4", new UserStats(Optional.of(9L)));
		
		System.out.println(count(new HashMap[] {m1,m2}));
	}

   static Map<String, Long> count(Map<String, UserStats>... visits) {
        Map<String,Long> m = new HashMap<>();
        if(visits == null) return m;
        Arrays.stream(visits).filter(x->x!=null && !x.isEmpty())
        .forEach(x->x.forEach((k,v)->m.put(k, v.getVisitCount().get())));
        return m;
    }
}

