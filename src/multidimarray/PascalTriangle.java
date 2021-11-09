package multidimarray;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		int A = 0;
		for (ArrayList<Integer> innerList : solve(A)) {
			for (Integer i : innerList) {
				System.out.print(i + " ");
			}
			System.out.println("\n");
		}

	}

	public static ArrayList<ArrayList<Integer>> solve(int A) {
		ArrayList<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();
		
		if(A <=0 ) {
			return outerList;
		}
		Integer[][] result = new Integer[A][A];
		result[0][0] = 1;
		for (int i = 1; i < A; i++) {
			result[0][i] = 0;
		}

		if (A > 1) {
			for (int i = 1; i < A; i++) {
				for (int j = 0; j < A; j++) {
					if (j == 0) {
						result[i][j] = 1;
					} else {
//						For all the other numbers:num at position i = number at position i in prev row + number at position (i - 1) in previous row.
						result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
					}
				}
			}
		}

		for (int i = 0; i < A; i++) {
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			for (int j = 0; j < A; j++) {
				innerList.add(result[i][j]);
			}
			outerList.add(innerList);
		}

		return outerList;

	}
}
