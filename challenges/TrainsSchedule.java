package challenges;/*
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
import java.util.Arrays;
import java.util.PriorityQueue;

public class TrainsSchedule {
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		
		System.out.println(minimumPlatforms(arr,dep));
	}
	
	public static int minimumPlatforms(int[] arrival,int[] departure) { // assuming absolute values
		int n = arrival.length;
		
		if(n!=departure.length) {
	  	System.out.println("At least 1 train not departed at the end, so invalid case");
	    return -1;
	  }
	  int count = 1;
	  Arrays.sort(arrival);
	  
	  PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
	  
	  for(int i=1; i<n-1; i++) {
	  	pq.add(departure[i-1]);
	  	if(arrival[i]<pq.peek())
	    	count++;
	    else
	    	pq.remove();
	  }
	  return count;
	}
}
/*
 * on line 29 if condition states that 
 * new arrival time of train is less than last departure time of train, means there is overlapping of time
 * so need more platforms.
 */
