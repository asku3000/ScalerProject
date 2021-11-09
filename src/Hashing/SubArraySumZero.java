package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubArraySumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 1, 2, 0, -2 };

		List<Integer> A = Arrays.asList(a);
		System.out.println(solve(A));

	}

	public static int solve(List<Integer> A) {
		if (A.get(0) == 0) {
			return 1;
		}

		HashMap<Long, Integer> map = new HashMap();

		ArrayList<Long> prefixSum = new ArrayList();
		prefixSum.add(Long.valueOf(A.get(0)));

		for (int i = 1; i < A.size(); i++) {
			Long value =  A.get(i) + prefixSum.get(i - 1);
			prefixSum.add(Long.valueOf(value));
			if (prefixSum.get(i) == 0 || A.get(i) == 0) {
				return 1;
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (map.get(prefixSum.get(i)) != null) {
				return 1;
			} else {
				map.put(prefixSum.get(i), 1);
			}
		}

		return 0;

	}

}
