package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithGivenDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 1, 1, 2, 2 }), 0));
	}

	public static int solve(List<Integer> A, int B) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < A.size(); i++) {
			if (map.get(A.get(i)) != null) {
				map.put(A.get(i), map.get(A.get(i)) + 1);
			} else {
				map.put(A.get(i), 1);
			}
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			if (B == 0) {
				if (map.get(m.getKey()) > 1)
					count++;
			} else {
				if (map.get(B + m.getKey()) != null)
					count++;
			}
		}

		return count;
	}

}
