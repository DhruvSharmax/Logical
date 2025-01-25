package challenges;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class InfiniteSortedArraySearch {
	public static void main(String[] args) {
		int arr[]= {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170}, key=170;
		
		int pos = findPosition(arr,key);
		System.out.println(pos);
		
		AtomicInteger i = new AtomicInteger(0);
		Arrays.stream(arr)
		.takeWhile(x->x!=key)
		.forEach(x->i.incrementAndGet());
		
		System.out.println(i.get()>arr.length-1?-1:i);
	}

	private static int findPosition(int[] arr, int key) {
		int low = 0;
		int high = 1;
		int currValue = arr[0];
		
		while(currValue<key) {
			low = high;
			
			if(2*high<arr.length-1) high*=2;	// this condition can be removed in actual infinite stream
			else high = arr.length-1;		// cz we're testing with a limited array, by using length we're just avoiding ArrayIndexOutOfBound
			
			currValue = arr[high];
			
			if(low==high) return -1;		// this condition can be removed in actual infinite stream
		}
		
		return binarySearch(arr, high, low, key);
	}

	private static int binarySearch(int[] arr, int high, int low, int key) {
		while(high>=low) {
			int mid = (high+low)/2;
			if(arr[mid]==key) return mid;
			else if(arr[mid]<key) low = mid+1;
			else high = mid-1;
		}
		return -1;
	}
}
