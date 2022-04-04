package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
 * Q3. Longest Increasing Subsequence
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.



Problem Constraints

0 <= length(A) <= 2500
1 <= A[i] <= 2500



Input Format

The first and the only argument is an integer array A.



Output Format

Return an integer representing the length of the longest increasing subsequence.



Example Input

Input 1:

 A = [1, 2, 1, 5]
Input 2:

 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]


Example Output

Output 1:

 3
Output 2:

 6


Example Explanation

Explanation 1:

 The longest increasing subsequence: [1, 2, 5]
Explanation 2:

 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]


 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
//		final List<Integer> A = Arrays.asList(new Integer[] { 10, 3, 12, 7, 2, 9, 11, 20, 11, 13, 6, 8 });
		final List<Integer> A = Arrays.asList(new Integer[] { 1 });
		System.out.println(lis(A));
	}

	static int ans = 1;

	public static int lis(final List<Integer> A) {
		int[] dp = new int[A.size() + 1];
		for (int i = A.size() - 1; i >= 0; i--)
			findLis(i, dp, A);
		return ans;
	}

	private static int findLis(int i, int[] dp, List<Integer> a) {
		if (i == 0) {
			dp[0] = 1;
			return dp[i];
		}

		if (dp[i] != 0) {
			return dp[i];
		}

		for (int j = 0; j < i; j++) {
			if (j == 0) {
				dp[0] = 1;
			}
			if (a.get(j) < a.get(i)) {
				dp[i] = Math.max(dp[i], findLis(j, dp, a));
			}
		}
		dp[i] = dp[i] + 1;

		ans = Math.max(ans, dp[i]);

		return dp[i];
	}

}
