package challenges;

import java.util.Arrays;

public class N_numbersWith0Sum {
	public static void main(String[] args) {
		
		int N = 5;		// input
		
		int[] output_arr = new int[N];
		int j = 0;
		for (int i = 1; i <= N / 2; i++) {
			output_arr[++j] = i;
			output_arr[++j] = -i;
		}
		if (N % 2 == 1)
			output_arr[N - 1] = 0;

		System.out.println(Arrays.toString(output_arr));
	}
}