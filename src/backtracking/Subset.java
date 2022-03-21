package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q1. Subset
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints

1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format

First and only argument of input contains a single integer array A.



Output Format

Return a vector of vectors denoting the answer.



Example Input

Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output

Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation

Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.


 */
public class Subset {

	public static void main(String[] args) {
		for (ArrayList<Integer> list : subsets(Arrays.asList(new Integer[] {1, 2, 3}))) {
			System.out.print("\n");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
		}

	}

	static ArrayList<ArrayList<Integer>> ans;

	public static ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
		ans = new ArrayList<ArrayList<Integer>>();
		Collections.sort(A);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		findSubsets(0, curr, A);
		// sort list of list
		Collections.sort(ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
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
		return ans;
	}

	private static void findSubsets(int i, ArrayList<Integer> curr, List<Integer> A) {
		if (i == A.size()) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}

		findSubsets(i + 1, curr, A);// not taking / unselecting;
		// selecting
		curr.add(A.get(i));// do
		findSubsets(i + 1, curr, A);// rec
		curr.remove(curr.size() - 1);// undo
	}

}
