package searching;

import java.util.Arrays;
import java.util.List;

public class LocalMaxima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(new Integer[] { 2, 3 })));
	}

	public static int solve(List<Integer> A) {
		int l = 0, r = A.size() - 1;
		if (l == r) {
			return A.get(l);
		}
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (mid == 0) {
				return Math.max(A.get(mid), A.get(mid + 1));
			}
			if (mid == A.size() - 1) {
				return Math.max(A.get(mid), A.get(mid - 1));
			}
			// previous element < mid > next element that is the answer
			if (mid > 0 && (A.get(mid) >= A.get(mid - 1) && A.get(mid) >= A.get(mid + 1))) {
				return A.get(mid);
			}
			// previous element > mid > next element then move left
			else if (mid > 0 && (A.get(mid - 1) >= A.get(mid)) && (A.get(mid) > A.get(mid + 1))) {
				r = mid - 1;
			} else if (mid > 0 && (A.get(mid - 1) < A.get(mid)) && (A.get(mid) <= A.get(mid + 1))) {
				l = mid + 1;
			}
		}
		return -1;
	}

}
