package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q2. All Unique Permutations
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints

1 <= |A| <= 9

0 <= A[i] <= 10



Input Format

Only argument is an integer array A of size N.



Output Format

Return a 2-D array denoting all possible unique permutation of the array.



Example Input

Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]


Example Output

Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]


Example Explanation

Explanation 1:

 All the possible unique permutation of array [1, 1, 2].
Explanation 2:

 All the possible unique permutation of array [1, 2].


 */
public class AllUniquePermutations {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(new Integer[] { 1, 1, 2 });
		for (ArrayList<Integer> li : permute(A)) {
			System.out.println("\n");
			for (Integer i : li) {
				System.out.print(i + ",");
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> permute(List<Integer> A) {
		// ArrayList<ArrayList<Integer>> result = new ArrayList();
		int[] freq = new int[11];
		for (int i = 0; i < A.size(); i++) {
			freq[A.get(i)] = freq[A.get(i)] + 1;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		ArrayList<Integer> temp = new ArrayList();

		solve(freq, temp, A, result);
		return result;

	}

	static void solve(int[] freq, ArrayList<Integer> temp, List<Integer> a, ArrayList<ArrayList<Integer>> result) {
		if (temp.size() == a.size()) {
			ArrayList<Integer> li = new ArrayList();
			li.addAll(temp);
			result.add(li);
			return;
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				freq[i] = freq[i] - 1;// do
				temp.add(i);
				solve(freq, temp, a, result);
				freq[i] = freq[i] + 1;// undo
				temp.remove(temp.size() - 1);
			}
		}

	}

}
