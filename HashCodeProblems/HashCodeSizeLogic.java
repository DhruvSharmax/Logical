package HashCodeProblems;

import java.util.HashMap;

public class HashCodeSizeLogic {
	public static void main(String[] args) {
			MyObj o1 = new MyObj(1,"Dhruv");
			MyObj o2 = new MyObj(1,"Naina");
			MyObj o3 = new MyObj(1,"Neeta");
			MyObj o4 = new MyObj(1,"VK");
			
			HashMap<Integer, MyObj> hm = new HashMap();
			hm.put(1, o1);
			hm.put(2, o2);
			hm.put(3, o3);
			hm.put(4, o4);
			
			System.out.println(hm.size());		// same hashcode still size increases
			System.out.println(hm.get(1).getS());
			
	}
}
