package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q2. Combination Sum
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description
Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints
1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format
The first argument is an integer array A.

The second argument is integer B.



Output Format
Return a vector of all combinations that sum up to B.



Example Input
Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7


Example Output
Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]


Example Explanation
Explanation 1:

All possible combinations are listed.
Explanation 2:

All possible combinations are listed.


 */
public class CombinationSum {

	public static void main(String[] args) {
		for (ArrayList<Integer> li : combinationSum(Arrays.asList(new Integer[] { 2, 3, 6, 7 }), 7)) {
			System.out.println(" ");
			for (Integer i : li) {
				System.out.print(i + " ");
			}
		}
	}

	static ArrayList<ArrayList<Integer>> ans;

	public static ArrayList<ArrayList<Integer>> combinationSum(List<Integer> A, int B) {
		Collections.sort(A);
		ans = new ArrayList<>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		int sum = 0;
		findCombinationSum(0, sum, curr, A, B);
		Collections.sort(ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
			for (int k = 0; k < first.size() && k < second.size(); k++) {
				if (first.get(k) < second.get(k))
					return -1;
				if (first.get(k) > second.get(k))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});
		return ans;
	}

	private static void findCombinationSum(int i, int sum, ArrayList<Integer> curr, List<Integer> A, int B) {
		if (sum == B) {
			ans.add(new ArrayList<Integer>(curr));
			return;
		}

		if (sum > B) {
			return;
		}

		for (int j = i; j < A.size(); j++) {
			curr.add(A.get(j));
			sum += A.get(j);
			findCombinationSum(j, sum, curr, A, B);
			curr.remove(curr.size() - 1);
			sum -= A.get(j);
			while ((j + 1) < A.size() && A.get(j + 1) == A.get(j)) {
				j++;
			}
		}
	}

}
