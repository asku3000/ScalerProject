package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
 * Q1. Cutting a Rod
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved..
Get help from TA.
Problem Description

Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.

Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.



Problem Constraints

1 <= N <= 1000

0 <= A[i] <= 106



Input Format

First and only argument is an integer array A of size N.



Output Format

Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.



Example Input

Input 1:

 A = [3, 4, 1, 6, 2]
Input 2:

 A = [1, 5, 2, 5, 6]


Example Output

Output 1:

 15
Output 2:

 11


Example Explanation

Explanation 1:

 Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
Explanation 2:

 Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.


 */
public class CuttingaRod {

	public static void main(String[] args) {
//		List<Integer> A = Arrays.asList(new Integer[] { 3, 4, 1, 6, 2 });
//		List<Integer> A = Arrays.asList(new Integer[] { 1, 5, 2, 5, 6 });
		List<Integer> A = Arrays.asList(new Integer[] { 2, 5, 7, 8 });
		System.out.println(solve(A));
	}

	public static int solve(List<Integer> A) {
		// i is lengths it can be cutt into
		// j is given length at that moment
		int i = A.size(), j = A.size();
		long dp[][] = new long[i + 1][j + 1];

		for (long[] row : dp) {
			Arrays.fill(row, -1);
		}
		return (int) findMax(i, j, dp, A);
	}

	private static long findMax(int i, int j, long[][] dp, List<Integer> A) {
		if (j == 0 || i == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (j >= i) {
			dp[i][j] = Math.max(findMax(i - 1, j, dp, A), A.get(i - 1) + findMax(i, j - i, dp, A));
		} else {
			dp[i][j] = findMax(i - 1, j, dp, A);
		}

		return dp[i][j];
	}

}
