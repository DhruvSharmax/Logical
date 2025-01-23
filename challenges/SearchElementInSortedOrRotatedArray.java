package challenges;

public class SearchElementInSortedOrRotatedArray {
    // Java program to search an element in sorted and rotated
        static int binarySearch(int[] arr, int lo, int hi, int x) {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == x) return mid;
                if (arr[mid] < x) lo = mid + 1;
                else hi = mid - 1;
            }
            return -1;
        }
        static int search(int[] arr, int key) {
            int n = arr.length, pivot, lo = 0, hi = n-1;

            while (lo < hi) {
                if (arr[lo] <= arr[hi]) 
                   pivot = lo;
                int mid = (lo + hi) / 2;
                if (arr[mid] > arr[hi])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            pivot = lo;

            if (arr[pivot] == key)
                return pivot;

            if (pivot == 0)
                return binarySearch(arr, 0, n - 1, key);

            if (arr[0] <= key)
                return binarySearch(arr, 0, pivot - 1, key);
            return binarySearch(arr, pivot + 1, n - 1, key);
        }

        public static void main(String[] args) {
            int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
            int key = 3;
            System.out.println(search(arr, key));
        }
}
