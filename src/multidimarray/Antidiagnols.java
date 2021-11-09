package multidimarray;

import java.util.ArrayList;

public class Antidiagnols {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> innerList1 = new ArrayList<Integer>();
		innerList1.add(1);
		innerList1.add(2);
		innerList1.add(3);

		ArrayList<Integer> innerList2 = new ArrayList<Integer>();
		innerList2.add(4);
		innerList2.add(5);
		innerList2.add(6);

		ArrayList<Integer> innerList3 = new ArrayList<Integer>();
		innerList3.add(7);
		innerList3.add(8);
		innerList3.add(9);

		outerList.add(innerList1);
		outerList.add(innerList2);
		outerList.add(innerList3);

		for (ArrayList<Integer> innerList : diagonal(outerList)) {
			for (Integer i : innerList) {
				System.out.print(i + " ");
			}
			System.out.println("\n");
		}
	}

	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

		ArrayList<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();

		int n = A.size();
		// upper triangle
		for (int i = 0; i < n; i++) {
			int row = 0;
			int col = i;
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			while (col >= 0) {
				innerList.add(A.get(row).get(col));
				col--;
				row++;
			}
			for(int j=innerList.size(); j<n;j++) {
				innerList.add(0);
			}
			outerList.add(innerList);
		}

		// lower triangle
		for (int i = 1; i < n; i++) {
			int row = i;
			int col= n-1;
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			while(row<n) {
				innerList.add(A.get(row).get(col));
				col--;
				row++;
			}
			for(int j=innerList.size(); j<n;j++) {
				innerList.add(0);
			}
			outerList.add(innerList);
		}

		return outerList;

	}

}
