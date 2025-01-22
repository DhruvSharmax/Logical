package challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayProblems {
	
	// we need to perform all operation without creation extra array or list, thats the condition.
	
	public static void main(String[] args) {
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(getUniqueElementsLength(Arrays.copyOf(arr, arr.length)));
		
		int n = 2;
		System.out.println(getLengthAfterRemovalStreams(Arrays.copyOf(arr, arr.length),n));
		
		System.out.println(Arrays.toString(getArrayAfterRemoval(Arrays.copyOf(arr, arr.length),n)));
		
		System.out.println(getLengthAfterRemoval(Arrays.copyOf(arr, arr.length),n));
		
		convertArrayToListToArrayStreams(Arrays.copyOf(arr, arr.length));
		
		System.out.println(
				Arrays.toString(
						findFirstAndLastPositionInSortedArray(
								Arrays.copyOf(arr, arr.length),1
								)
						)
				);
		
		System.out.println(
				Arrays.toString(
						findFirstAndLastPositionInSortedArrayBinarySearch(
								Arrays.copyOf(arr, arr.length),1
								)
						)
				);
	}

	private static int getUniqueElementsLength(int[] arr) {
		/*
		 * first sort array if not done already, then you can traverse the array with one previous pointer having last element
		 * which you can compare with current element, if they're different increase your count
		 */
		int count=1;
		int prev = arr[0];
		for(int i:arr) {
			if(prev!=i)
				count++;
			prev = i;
		}
		return count;
	}
	private static int[] findFirstAndLastPositionInSortedArray(int[] arr, int n) {
		int start = -1,end = -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n) {
				if(start==-1)
					start = i;
				end = i;
			}
		}
		return new int[] {start,end};
	}

	private static int[] findFirstAndLastPositionInSortedArrayBinarySearch(int[] arr, int n) {

		int low=0, high=arr.length-1;
		int start = -1, end = -1;
		
		while(high>=low) {
			int mid = (high+low)/2;
			if(arr[mid]<n)
				low = mid+1;
			else if(arr[mid]>n)
				high = mid-1;
			else {
				start=mid;
				high = mid-1;
			}
		}
		
		low=0;high=arr.length-1;
		while(high>=low) {
			int mid = (high+low)/2;
			if(arr[mid]<n)
				low = mid+1;
			else if(arr[mid]>n)
				high = mid-1;
			else {
				end=mid;
				low = mid+1;
			}
		}
		
		return new int[] {start,end};
	}



	private static int getLengthAfterRemoval(int[] arr, int n) {
		int count=0;
		for(int i=0;i<arr.length;i++)
			if(arr[i]!=n)
				count++;
		return count;
	}

	private static int[] getArrayAfterRemoval(int[] arr, int n) {
		int count=0;
		for(int i=0;i<arr.length;i++)
			if(arr[i]!=n)
				arr[count++] = arr[i];
		
		return Arrays.copyOf(arr, count);
	}

	private static void convertArrayToListToArrayStreams(int[] arr) {
		List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		int[] out = li.stream().mapToInt(Integer::intValue).toArray();
		
		Arrays.stream(out).forEach(System.out::print);
		System.out.println("\n");
	}

	private static int getLengthAfterRemovalStreams(int[] arr, int n) {
		return Arrays.stream(arr).filter(x->x!=n).toArray().length;
	}


}
