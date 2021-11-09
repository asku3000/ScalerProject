package multidimarray;

import java.util.ArrayList;

public class RowWiseAndColumnWiseSortedMatrix {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> innerList1 = new ArrayList<Integer>();
		innerList1.add(2);
		innerList1.add(8);
		innerList1.add(8);
		innerList1.add(8);

		outerList.add(innerList1);
		outerList.add(innerList1);
		outerList.add(innerList1);
		outerList.add(innerList1);
		System.out.println(solve(outerList, 8));

		// TODO Auto-generated method stub

	}

	public static int solve(ArrayList<ArrayList<Integer>> A, int B) {

		int row = 0;
		int col = A.get(row).size() - 1;
		int ans = Integer.MAX_VALUE;

		while (row < A.size() && col >= 0) {

			if (A.get(row).get(col) == B) {
				ans = Math.min(ans, (row + 1) * 1009 + (col + 1));
				col--;
			} else if (A.get(row).get(col) > B) {
				col--;
			} else if (A.get(row).get(col) < B) {
				row++;
			}

		}

		return ans == Integer.MAX_VALUE ? -1 : ans;

	}

}
