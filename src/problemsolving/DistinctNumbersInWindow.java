package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31 };
		for (Integer i : dNums(Arrays.asList(a), 3)) {
			System.out.print(i + ", ");
		}

	}

	public static ArrayList<Integer> dNums(List<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList();
		HashMap<Integer, Integer> map = new HashMap();

		for (int i = 0; i < B; i++) {
			if (map.get(A.get(i)) != null) {
				map.put(A.get(i), map.get(A.get(i)) + 1);
			} else {
				map.put(A.get(i), 1);
			}
		}

		ans.add(map.size());
		int res = ans.get(0);
		for (int i = B; i < A.size(); i++) {
			if (map.get(A.get(i)) == null) {
				map.put(A.get(i), 1);
				res++;
			} else {
				if (map.get(A.get(i)) == 0) {
					res++;
				}
				map.put(A.get(i), map.get(A.get(i)) + 1);
			}
			map.put(A.get(i - B), map.get(A.get(i - B)) - 1);

			if (map.get(A.get(i - B)) == 0) {
				res--;
			}

			ans.add(res);
		}

		return ans;
	}

}
