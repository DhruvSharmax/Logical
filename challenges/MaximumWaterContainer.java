package challenges;

/*
 * https://www.geeksforgeeks.org/container-with-most-water/
 */
public class MaximumWaterContainer {
	public static void main(String[] args) {
		int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};
     
        System.out.println(maxArea(a));
        System.out.println(maxArea(b));
	}

	private static int maxArea(int[] arr) {
		int maxArea = 0;
		int l = 0,r=arr.length-1;
		
		while(l<r) {
			maxArea = Math.max(maxArea, Math.min(arr[l], arr[r])*(r-l));
			// area calculation is (minimum height b/w first & last towers * gap between those towers)
			// this formula indirectly given in problem gap is written as size of base.
			if(arr[l]<arr[r]) l++;
			else r--;
		}
		return maxArea;
	}
}
