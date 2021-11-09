package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DuplicateRowsInBinaryMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> A = new ArrayList();

		A.add(Arrays.asList(new Integer[] { 1, 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 1, 0 }));
		A.add(Arrays.asList(new Integer[] { 0, 1, 0 }));
		A.add(Arrays.asList(new Integer[] { 1, 0, 0 }));
		A.add(Arrays.asList(new Integer[] { 1, 0, 0 }));

		for (Integer a : solve(A)) {
			System.out.print(a + " ");
		}

	}

	public static ArrayList<Integer> solve(List<List<Integer>> A) {
		HashMap<String, Integer> map = new HashMap();
		ArrayList<Integer> ans = new ArrayList();

		for (int i = 0; i < A.size(); i++) {
			StringBuilder string = new StringBuilder("");
			for (int j = 0; j < A.get(i).size(); j++) {
				string.append(A.get(i).get(j));
			}

			if (map.get(string.toString()) != null) {
				ans.add(i+1);
			} else {
				map.put(string.toString(), i);
			}
		}

		Collections.sort(ans);

		return ans;
	}

}
