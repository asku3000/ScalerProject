package recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem Description

Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.


Problem Constraints

0 <= N <= 16



Input Format

Only argument is an integer array A of size N.



Output Format

Return a 2-D vector denoting all the possible subsets.



Example Input

Input 1:

 A = [1, 2, 2]
Input 2:

 A = [1, 1]


Example Output

Output 1:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:

 [
    [],
    [1],
    [1, 1]
 ]


Example Explanation

Explanation 1:

All the subsets of the array [1, 2, 2] in lexicographically sorted order.


 */

public class SubsetRepeats {

	public static void main(String[] args) {
		/*
		 * for (int i = 0; i < 3; i++) { System.out.println("\n"); for (int j = 0; j <=
		 * i; j++) { System.out.print(-1 + " "); } }
		 */

		// TODO Auto-generated method stub
		for (ArrayList<Integer> list : subsetsWithDup(Arrays.asList(new Integer[] { 1, 2, 2 }))) {
			System.out.println("\n next");
			for (Integer li : list) {
				System.out.print(li + "-");
			}
		}

	}

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(List<Integer> A) {
		HashMap<Integer, Integer> freq = new HashMap();
		for (Integer i : A) {
			if (freq.get(i) == null) {
				freq.put(i, 1);
			} else {
				freq.put(i, freq.get(i) + 1);
			}
		}

		A = new ArrayList();
		for (Map.Entry<Integer, Integer> keySet : freq.entrySet()) {
			A.add(keySet.getKey());
		}

		Collections.sort(A);

		ArrayList<ArrayList<Integer>> result = new ArrayList();
		ArrayList<Integer> temp = new ArrayList();
		find(0, A, freq, temp, result);
		Collections.sort(result, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
			for (int i = 0; i < first.size() && i < second.size(); i++) {
				if (first.get(i) < second.get(i))
					return -1;
				if (first.get(i) > second.get(i))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});
		return result;
	}

	static void find(int i, List<Integer> A, HashMap<Integer, Integer> freq, ArrayList<Integer> temp,
			ArrayList<ArrayList<Integer>> result) {
		if (i >= A.size()) {
			ArrayList<Integer> li = new ArrayList();
			li.addAll(temp);
			result.add(li);
			return;
		}

		find(i + 1, A, freq, temp, result);

		// selecting the frequency of A[i]
		for (int j = 0; j < freq.get(A.get(i)); j++) {
			for (int k = 0; k <= j; k++) {
				temp.add(A.get(i));
				freq.put(A.get(i), freq.get(A.get(i)) - 1);
			}
			find(i + 1, A, freq, temp, result);
			for (int k = 0; k <= j; k++) {
				temp.remove(temp.size() - 1);
				freq.put(A.get(i), freq.get(A.get(i)) + 1);
			}
		}

	}

}
