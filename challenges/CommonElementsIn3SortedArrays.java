package challenges;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsIn3SortedArrays {
	public static void main(String args[])
    {
        int ar1[] = {1, 5, 5}; //{ 1, 5, 10, 20, 40, 80 };
        int ar2[] = {3, 4, 5, 5, 10}; //{ 6, 7, 20, 80, 100 };
        int ar3[] = {5, 5, 10, 20}; //{ 3, 4, 15, 20, 30, 70, 80, 120 H};
 
        List<Integer> li = findCommon(ar1, ar2, ar3);
        System.out.print("Common elements are "+li);
        
        findCommonFromN(ar1, ar2, ar3);
    }

	private static List<Integer> findCommon(int[] ar1, int[] ar2, int[] ar3) {
		int i=0,j=0,k=0;
		List<Integer> li = new ArrayList<>();
		while(i<ar1.length && j<ar2.length && k<ar3.length) {
			if(ar1[i]==ar2[j] && ar2[j]==ar3[k]) {
				li.add(ar1[i]);
				i++;j++;k++;
			}
			else if(ar1[i]<ar2[j]) i++;
			else if(ar2[j]<ar3[k]) j++;
			else k++;
		}
		return li;
	}
	
	private static void findCommonFromN(int[]... arrays) {
		if (arrays.length < 2) {
	        System.out.println("Too few arrays" );
	        return;
	    }
		
	    int baseIndex = 0;
	    int[] indices = new int[arrays.length-1];
	    int totalMatchFound;
	    boolean smallestArrayTraversalComplete = false;
	     
	    while ((baseIndex < arrays[0].length) && (!smallestArrayTraversalComplete)) {
	        totalMatchFound = 0;
	        for (int i = 1; i < arrays.length; i++) {
	             
	            int currIndex = indices[i-1];
	            
	            while ((currIndex < arrays[i].length) && (arrays[i][currIndex] < arrays[0][baseIndex]))
	                currIndex++;
	             
	            if (currIndex < arrays[i].length) {
	                if ((arrays[i][currIndex] == arrays[0][baseIndex]))
	                    totalMatchFound++;
	            }
	             
	            else
	                smallestArrayTraversalComplete = true;
	            
	            indices[i-1] = currIndex;
	        }
	        
	        if (totalMatchFound == arrays.length-1)
	            System.out.println(arrays[0][baseIndex]);

	        baseIndex++;
	    }
	}
}
