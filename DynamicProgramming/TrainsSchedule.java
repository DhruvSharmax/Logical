package DynamicProgramming;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TrainsSchedule {
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		
		System.out.println(minimumPlatforms(arr,dep));
	}
	
	public static int minimumPlatforms(int[] arrival,int[] departure) { // assuming absolute values
		if(arrival.length!=departure.length) {
	  	System.out.println("At least 1 train not departed at the end, so invalid case");
	    return -1;
	  }
	  int count = 1;
	  Arrays.sort(arrival);
	  Arrays.sort(departure);
	  
	  PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
	  
	  for(int i=1; i<arrival.length-1; i++) {
	  	pq.add(departure[i-1]);
	  	if(arrival[i]>pq.peek()) {
	    	count++;
	    }
	    else pq.remove();
	  }
	  
	  return count;
	}
}
