package recurrsion;

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
		subsets(Arrays.asList(new Integer[] { 12, 13 }));

	}

	static ArrayList<ArrayList<Integer>> ans;

	static void solve(int idx, ArrayList<Integer> cur, List<Integer> A) {
		if (idx == A.size()) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		solve(idx + 1, cur, A); // not take
		int element = A.get(idx);
		cur.add(element); // DO
		solve(idx + 1, cur, A); // take
		cur.remove(cur.size() - 1); // UNDO
	}

	public static ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
		Collections.sort(A);
		ans = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		solve(0, cur, A);
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

}
