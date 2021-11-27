package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (ArrayList<Integer> list : permute(Arrays.asList(new Integer[] { 1, 2, 3 }))) {
			System.out.println("\n");
			for (Integer li : list) {
				System.out.print(li + " ");
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> permute(List<Integer> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		int i = 0;
		solve(i, A, result);
		return result;
	}

	static void solve(int i, List<Integer> A, ArrayList<ArrayList<Integer>> result) {
		if (i == A.size()) {
			ArrayList<Integer> li = new ArrayList();
			li.addAll(A);
			result.add(li);
			return;
		}

		for (int j = i; j < A.size(); j++) {
			swap(A, i, j);
			solve(i + 1, A, result);
			swap(A, j, i);
		}
	}

	static void swap(List<Integer> A, int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

}
