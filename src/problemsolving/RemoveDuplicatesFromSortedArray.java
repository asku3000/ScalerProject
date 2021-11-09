package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (Integer a : solve(Arrays.asList(new Integer[] { 5000, 5000, 5000 }))) {
			System.out.print(a + " ");
		}

	}

	public static ArrayList<Integer> solve(List<Integer> A) {

		ArrayList<Integer> res = new ArrayList();
		res.add(A.get(0));
		for (int i = 1; i < A.size(); i++) {
			if (!A.get(i).equals(A.get(i - 1))) {
				res.add(A.get(i));
			}
		}
		return res;
	}

}
