package problemsolving;

import java.util.ArrayList;
import java.util.Collections;

public class ConstructArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Integer a : solve(3, 10, 39)) {
			System.out.print(a + " ");
		}

	}

	public static ArrayList<Integer> solve(final int A, final int B, final int C) {

		ArrayList<Integer> ans = new ArrayList();
		ans.add(Integer.MAX_VALUE);

		for (int i = 1; i < 50; i++) {
			ArrayList<Integer> probableAns = new ArrayList();
			probableAns.add(C);
			for (int j = 1; j < A; j++) {
				probableAns.add(probableAns.get(j - 1) - i);
			}

			if (probableAns.contains(B) && Math.abs(probableAns.get(A - 1)) < Math.abs(ans.get(0))) {
				Collections.reverse(probableAns);
				ans = probableAns;
			} else {
				continue;
			}
		}

		return ans;

	}

}
