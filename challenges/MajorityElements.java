package challenges;

import java.util.*;

public class MajorityElements {
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {13,1,13}));
	}
	
	static int majorityElement(int a[])
    {
		int size = a.length;
		if(size==1) return a[0];
        double threshold = Math.floor(size/2);  
        Map<Integer,Integer> m = new HashMap<>();
        for(int i:a) {
            if(m.containsKey(i)) {
                int count = m.get(i)+1;
				if(count>threshold) 
					return i;
				else m.put(i,count);
            }
			else m.put(i, 1);
        }
        return -1;
    }
}
