package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		subsets(Arrays.asList(new Integer[] { 12, 13 }));

	}

	static ArrayList<ArrayList<Integer>> ans;
	static List<Integer> a;

	public static ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
		ans = new ArrayList();
		int i = 0;
		int j = i;
		ArrayList<Integer> temp = new ArrayList();
		Collections.sort(A);
		a = A;
		findSubsets(i, j, temp);
		return ans;
	}

	static void findSubsets(int i, int j, ArrayList<Integer> temp) {
		if (i >= a.size())
			return;

		if (j >= a.size()) {
			temp = new ArrayList();
			findSubsets(i + 1, i+1, temp);
		} else {
			temp.add(a.get(j));
			ArrayList<Integer> li = new ArrayList();
			li.addAll(temp);
			ans.add(li);
			findSubsets(i, j + 1, temp);
		}
	}

}
