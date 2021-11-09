package multidimarray;

import java.util.Arrays;
import java.util.List;

public class MinMaxSmallestSubarray {

	public static void main(String[] args) {
		Integer[] arr = { 4,4,4,4,4 };
		List<Integer> A = Arrays.asList(arr);
		System.out.println(solve(A));
	}

	public static int solve(List<Integer> A) {
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) < min) {
				min = A.get(i);
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > max) {
				max = A.get(i);
			}
		}
		
		if(max==min) {
			return 1;
		}

		int latestMin = Integer.MAX_VALUE;
		int latestMax = -Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == min) {
				int length = Math.abs(i - latestMax + 1);
				ans = Math.min(ans, length);
				latestMin = i;
			} else if (A.get(i) == max) {
				int length = Math.abs(i - latestMin + 1);
				ans = Math.min(ans, length);
				latestMax = i;
			}
		}

		return ans;

	}

}
