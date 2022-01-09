package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SumZero3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (ArrayList<Integer> list : threeSum(
				Arrays.asList(new Integer[] { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 }))) {
			System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2));
		}
	}

	public static ArrayList<ArrayList<Integer>> threeSum(List<Integer> A) {
		Collections.sort(A);
		HashSet<List<Integer>> set = new HashSet();
		for (int k = 0; k < A.size() - 2; k++) {
			int i = k + 1, j = A.size() - 1;
			while (i < j) {
				int sum = A.get(i) + A.get(j) + A.get(k);
				if (sum > 0) {
					j--;
				} else if (sum < 0) {
					i++;
				} else {
					set.add(Arrays.asList(A.get(k), A.get(i), A.get(j)));
					j--;i++;
				}
			}
		}

		ArrayList<ArrayList<Integer>> ans = new ArrayList();
		for(List<Integer> list: set) {
			ArrayList<Integer> li = new ArrayList<Integer>();
			li.add(list.get(0));
			li.add(list.get(1));
			li.add(list.get(2));
			ans.add(li);
		}
		
		return ans;
	}

}
