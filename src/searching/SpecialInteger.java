package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }), 10));
	}

	public static int solve(List<Integer> A, int B) {
		ArrayList<Long> prefixSum = new ArrayList();
		prefixSum.add(0l);
		for (int i = 0; i < A.size(); i++) {
			prefixSum.add((long) (A.get(i) + prefixSum.get(i)));
		}

		int l = 1, r = A.size();
		int mid = 0;
		int ans = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (check(mid, prefixSum, B, A)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ans;
	}

	static boolean check(int k, ArrayList<Long> prefix, int B, List<Integer> A) {
		int i = 1, j = k;
		while (j < A.size() + 1) {
			if ((prefix.get(j) - prefix.get(i - 1)) > B) {
				return false;
			}
			i++;
			j++;
		}
//		if (j >= A.size() + 1) {
//			return false;
//		}
		return true;
	}

}
