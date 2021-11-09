package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeggarProblem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> B = new ArrayList<List<Integer>>();
		int A = 10;
		B.add(Arrays.asList(new Integer[] { 1, 3, 10 }));
		B.add(Arrays.asList(new Integer[] { 6, 9, 2 }));
		B.add(Arrays.asList(new Integer[] { 3, 5, 3 }));
		B.add(Arrays.asList(new Integer[] { 2, 8, 4 }));
		B.add(Arrays.asList(new Integer[] { 6, 7, 5 }));

		for (Integer a : solve(A, B)) {
			System.out.print(a + " ");
		}
	}

	public static List<Integer> solve(int A, List<List<Integer>> B) {
		ArrayList<Integer> res = new ArrayList();

		for (int i = 0; i < A; i++) {
			res.add(0);
		}

		for (int i = 0; i < B.size(); i++) {
			int L = B.get(i).get(0) - 1;
			int R = B.get(i).get(1);
			res.set(L, B.get(i).get(2) + res.get(L));
			if (R <= A - 1) {
				res.set(R, -B.get(i).get(2) + res.get(R));
			}
		}

		// prefix sum
		for (int i = 1; i < res.size(); i++) {
			res.set(i, res.get(i - 1) + res.get(i));
		}

		return res;
	}
}