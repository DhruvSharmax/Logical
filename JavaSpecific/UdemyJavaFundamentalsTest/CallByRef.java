package JavaSpecific.UdemyJavaFundamentalsTest;
import java.util.*;

public class CallByRef {
	
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("Dhruv");
		inner c = new CallByRef().new inner();
		c.modified(li);
		System.out.println(li);
	}
	
	class inner {
		public void modified(List<String> li) {
			li.add("Naina");
		}
	}
}
