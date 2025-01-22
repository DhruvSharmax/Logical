package DynamicProgramming;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
/*
 * https://leetcode.com/discuss/general-discussion/1700915/amazon-oa
 */
public class AmazonDataClusters {
	public static void main(String[] args) {
		System.out.println(
				findMaximumSustainableClusterSize(Arrays.asList(new Integer[]{4,1,4,5,3}),
						Arrays.asList(new Integer[]{8,8,10,9,12}), 33L)); // 2 expected
		
		System.out.println(
				findMaximumSustainableClusterSize(Arrays.asList(new Integer[]{10,8,7}),
						Arrays.asList(new Integer[]{11,12,19}), 6L)); // 0 expected
		
		System.out.println(
				findMaximumSustainableClusterSize(Arrays.asList(new Integer[]{2,1,3,4,5}),
						Arrays.asList(new Integer[]{3,6,1,3,4}), 25L)); // 3 expected
	}
	
	public static int findMaximumSustainableClusterSize
	(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
		
		int start = 0, end = 0, count = 0;
		int clusters = 1;
		int SumProcessing = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (end = 0; end < processingPower.size(); end++) {
			SumProcessing += processingPower.get(end);
			pq.add(bootingPower.get(end));
			long currMaxPower = pq.peek() + ((long) SumProcessing * clusters);
			if (currMaxPower <= powerMax) {
				count = clusters;
				clusters++;
			} else {
				SumProcessing -= processingPower.get(start);
				pq.remove(bootingPower.get(start));
				start++;
			}
		}
		return count;
	}
}
