package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Q3. Minimum Falling Path Sum II
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given a square grid of integers A, a falling path with non-zero shifts is a choice of exactly one element from each row of A, such that no two elements chosen in adjacent rows are in the same column.

Return the minimum sum of a falling path with non-zero shifts.



Problem Constraints

1 <= |A| == |A[i]| <= 200
-99 <= A[i][j] <= 99



Input Format

First argument is a 2D array of integers.



Output Format

Return an integer denoting the minimum sum.



Example Input

Input 1:

 A =  [ [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9] ]
Input 2:

 A =  [ [17, 14, 19],
        [12, 18, 9],
        [20, 10, 1] ]


Example Output

Output 1:

 13
Output 2:

 27


Example Explanation

Explanation 1:

 The possible falling paths are:
 [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 The falling path with the smallest sum is [1,5,7], so the answer is 13.
Explanation 2:

 The possible falling paths are:
 The falling path with the smallest sum is [14,12,1], so the answer is 27.

 */
public class MinimumFailingPathSumII {

	public static void main(String[] args) {
		ArrayList<List<Integer>> A = new ArrayList<List<Integer>>();
		A.add(Arrays.asList(new Integer[] { 1, 2, 3 }));
		A.add(Arrays.asList(new Integer[] { 4, 5, 6 }));
		A.add(Arrays.asList(new Integer[] { 7, 8, 9 }));
		System.out.println(solve(A));

	}

	public static int solve(ArrayList<List<Integer>> A) {
		int i = 0;
		int[][] dp = new int[A.size()][A.get(0).size()];
		for (int j = 0; j < A.get(i).size(); j++)
			findMinPath(i, j, dp, A);
		int ans = Integer.MAX_VALUE;
		for (int k = 0; k < A.size(); k++) {
			ans = Math.min(ans, dp[0][k]);
		}
		return ans;
	}

	private static int findMinPath(int i, int j, int[][] dp, ArrayList<List<Integer>> a) {

		if (i == a.size() - 1) {
			dp[i][j] = a.get(i).get(j);
			return dp[i][j];
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		for (int k = 0; k < a.get(i).size(); k++) {
			if (k == 0) {
				dp[i][j] = Integer.MAX_VALUE;
			}
			if (k != j)
				dp[i][j] = Math.min(dp[i][j], a.get(i).get(j) + findMinPath(i + 1, k, dp, a));
		}

		return dp[i][j];

	}

}
